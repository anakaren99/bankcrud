package com.sivale.bankcrud.Service.Impl;

import com.sivale.bankcrud.Model.CuentasModel;
import com.sivale.bankcrud.Repository.CuentasRepository;
import com.sivale.bankcrud.Service.CuentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CuentasServiceImpl implements CuentasService {

    @Autowired
    private CuentasRepository cuentasRepository;

    @Override
    @Transactional
    public CuentasModel save(CuentasModel cuentas) {
        return cuentasRepository.save(cuentas);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CuentasModel> getCuenta(Long id) {
        return cuentasRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CuentasModel> getAllCuentas() {
        return cuentasRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteCuentas(Long id) {
        cuentasRepository.deleteById(id);

    }

    @Override
    public List<CuentasModel> getCuentasByClient(Long id) {
        return cuentasRepository.buscarCuentasPorCliente(id);
    }
}
