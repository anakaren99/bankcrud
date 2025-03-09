package com.sivale.bankcrud.Service;

import com.sivale.bankcrud.Model.Clientes;
import com.sivale.bankcrud.Model.CuentasModel;

import java.util.List;
import java.util.Optional;

public interface CuentasService {

    public CuentasModel save(CuentasModel cuentas);
    public Optional<CuentasModel> getCuenta(Long id);
    public List<CuentasModel> getAllCuentas();
    public void deleteCuentas(Long id);
    public List<CuentasModel> getCuentasByClient(Long id);

}
