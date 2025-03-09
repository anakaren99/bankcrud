package com.sivale.bankcrud.Controller;

import com.sivale.bankcrud.Service.ConsultaCuentasService;
import com.sivale.bankcrud.dto.ResponseConsultaCuentas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Obtiene todas las cuentas", description = "Retorna una lista de cuentas disponibles")
    @ApiResponse(responseCode = "200", description = "Lista de cuentas obtenida correctamente",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseConsultaCuentas.Cuentas.class)))
    @GetMapping("/getInfoClient/{id}")
    public ResponseConsultaCuentas getInfoClient(@PathVariable Long id) {
       return consultaCuentasService.getCuentas(id);
    }

}
