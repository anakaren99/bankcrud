package com.sivale.bankcrud.Controller;

import com.sivale.bankcrud.Service.ConsultaCuentasService;
import com.sivale.bankcrud.dto.ResponseConsultaCuentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/si-vale/Cosulta")
public class ConsultaCuentasController {

    @Autowired
    private ConsultaCuentasService consultaCuentasService;

    @GetMapping("/getInfoClient/{id}")
    public ResponseConsultaCuentas getInfoClient(@PathVariable Long id) {
       return consultaCuentasService.getCuentas(id);
    }

}
