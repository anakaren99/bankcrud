package com.sivale.bankcrud.Service;

import com.sivale.bankcrud.Model.TransaccionesModel;

import java.util.List;
import java.util.Optional;

public interface TransaccionesService {

    public TransaccionesModel save(TransaccionesModel transaccionesModel);
    public Optional<TransaccionesModel> findById(Long id);
    public List<TransaccionesModel> findAll();
    public void delete(Long id);
}
