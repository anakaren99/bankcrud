package com.sivale.bankcrud.Service.Impl;

import com.sivale.bankcrud.Model.TransaccionesModel;
import com.sivale.bankcrud.Repository.TransaccionesRepository;
import com.sivale.bankcrud.Service.TransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionesServiceImpl implements TransaccionesService {

    @Autowired
    private TransaccionesRepository transaccionesRepository;

    @Override
    @Transactional
    public TransaccionesModel save(TransaccionesModel transaccionesModel) {
        return transaccionesRepository.save(transaccionesModel);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<TransaccionesModel> findById(Long id) {
        return transaccionesRepository.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<TransaccionesModel> findAll() {
        return transaccionesRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        transaccionesRepository.deleteById(id);
    }
}
