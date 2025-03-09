package com.sivale.bankcrud.Service.Impl;

import com.sivale.bankcrud.Model.Clientes;
import com.sivale.bankcrud.Repository.ClientesRepository;
import com.sivale.bankcrud.Service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesRepository clientes;

    @Override
    @Transactional()
    public Clientes addCliente(Clientes cliente) {
        return clientes.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> getClientes() {
        return clientes.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Clientes> getCliente(Long id) {
        return clientes.findById(id);
    }

    @Override
    @Transactional()
    public void deleteCliente(Long id) {
     clientes.deleteById(id);
    }
}
