package com.sivale.bankcrud.Controller;

import com.sivale.bankcrud.Model.CuentasModel;
import com.sivale.bankcrud.Service.CuentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/si-vale/cuentas")
public class CuentasController {

    @Autowired
    private CuentasService cuentasService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CuentasModel cuentasModel){

        if(!cuentasModel.getTipo_cuenta().equals("Ahorros") && !cuentasModel.getTipo_cuenta().equals("Corriente")){
            return new ResponseEntity<>("Tipo de cuenta no valido", HttpStatus.BAD_REQUEST);
        }else {
           return ResponseEntity.status(HttpStatus.CREATED).body(cuentasService.save(cuentasModel));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        Optional<CuentasModel> cuenta = cuentasService.getCuenta(id);

        if(!cuenta.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(cuenta.get());
    }

    @GetMapping("/get")
    public  List<CuentasModel>  getAll(){
        return cuentasService.getAllCuentas();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CuentasModel cuentasModel){
        Optional<CuentasModel> upCuenta = cuentasService.getCuenta(id);
        if(!upCuenta.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        cuentasModel.setId_cuenta(id);
        return ResponseEntity.ok().body(cuentasService.save(cuentasModel));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        cuentasService.deleteCuentas(id);
    }

    @GetMapping("/getClient/{id}")
    public List<CuentasModel> getClient(@PathVariable Long id){
       return cuentasService.getCuentasByClient(id);
    }
}
