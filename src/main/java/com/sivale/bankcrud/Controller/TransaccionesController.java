package com.sivale.bankcrud.Controller;

import com.sivale.bankcrud.Model.TransaccionesModel;
import com.sivale.bankcrud.Service.TransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/si-vale/transacciones")
public class TransaccionesController {

    @Autowired
    private TransaccionesService transaccionesService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TransaccionesModel transaccionesModel){
        if(!transaccionesModel.getTipo_transaccion().equals("Deposito") && !transaccionesModel.getTipo_transaccion().equals("Retiro") && !transaccionesModel.getTipo_transaccion().equals("Transferencia")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de transaccion no valido");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(transaccionesService.save(transaccionesModel));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long n){
        Optional<TransaccionesModel> transaccionesModel = transaccionesService.findById(n);

        if(!transaccionesModel.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(transaccionesModel);
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.status(HttpStatus.OK).body(transaccionesService.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long n, @RequestBody TransaccionesModel transaccionesModel){
        Optional<TransaccionesModel> transaccionModel = transaccionesService.findById(n);

        if(!transaccionModel.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        transaccionesModel.setId_transaccion(n);
        return ResponseEntity.status(HttpStatus.OK).body(transaccionesService.save(transaccionesModel));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long n){
        transaccionesService.delete(n);
    }
}
