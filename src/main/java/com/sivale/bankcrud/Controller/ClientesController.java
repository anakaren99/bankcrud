package com.sivale.bankcrud.Controller;

import com.sivale.bankcrud.Model.Clientes;
import com.sivale.bankcrud.Service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Optional;

@RestController
@RequestMapping("/si-vale/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;


    @PostMapping("/save")
    public ResponseEntity<?> saveCliente(@RequestBody Clientes cliente) {

        return ResponseEntity.status(HttpStatus.CREATED).body((clientesService.addCliente(cliente)));

    }

    @GetMapping ("/get/{id}")
        public ResponseEntity<?> getCliente(@PathVariable Long id) {
        Optional<Clientes> cliente = clientesService.getCliente(id);

        if (cliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody Clientes cliente) {
        Optional<Clientes> cliente2 = clientesService.getCliente(id);

        if (!cliente2.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
       cliente.setId_cliente(id);
        return ResponseEntity.ok().body((clientesService.addCliente(cliente)));
    }

    @DeleteMapping("/delete/{id}")
        public void deleteCliente(@PathVariable Long id) {
        clientesService.deleteCliente(id);
        }
}
