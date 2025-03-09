package com.sivale.bankcrud.Service.Impl;

import com.sivale.bankcrud.Model.Clientes;
import com.sivale.bankcrud.Model.CuentasModel;
import com.sivale.bankcrud.Service.ConsultaCuentasService;
import com.sivale.bankcrud.dto.ResponseConsultaCuentas;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaCuentasServiceImpl implements ConsultaCuentasService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    public ConsultaCuentasServiceImpl(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    @Override
    public ResponseConsultaCuentas getCuentas(Long id) {
        ResponseConsultaCuentas response = new ResponseConsultaCuentas();
        Clientes responseClientes = new Clientes();
        String urlClientes = environment.getProperty("getClienteById") + id;

        try {
            responseClientes = restTemplate.getForObject(urlClientes, Clientes.class);
            if (responseClientes != null) {
               //response.setId_cliente(responseClientes.getId_cliente());
                response.setNombre(responseClientes.getNombre());
                response.setApellido(responseClientes.getApellido());
                response.setTelefono(responseClientes.getTelefono());
                response.setDireccion(responseClientes.getDireccion());
                response.setCorreo_electronico(responseClientes.getCorreo_electronico());

                String urlCuentas = environment.getProperty("getCuentasById") + id;

                ResponseEntity<List<ResponseConsultaCuentas.Cuentas>> responseEntity =
                        restTemplate.exchange(urlCuentas, HttpMethod.GET, null, new ParameterizedTypeReference<List<ResponseConsultaCuentas.Cuentas>>() {});

                List<ResponseConsultaCuentas.Cuentas> responseCuentas = responseEntity.getBody();

                if (responseCuentas != null) {

                    response.setCuentas(responseCuentas);

                }
            }
        }catch (RestClientException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
         return response;
    }


}
