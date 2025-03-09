package com.sivale.bankcrud.Service;

import com.sivale.bankcrud.Model.Clientes;

import java.util.List;
import java.util.Optional;

public interface ClientesService {

    public Clientes addCliente(Clientes cliente);
    public List<Clientes> getClientes();
    public Optional<Clientes> getCliente(Long id);
    public void deleteCliente(Long id);
}
