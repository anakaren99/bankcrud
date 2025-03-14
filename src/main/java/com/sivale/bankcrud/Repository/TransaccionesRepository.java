package com.sivale.bankcrud.Repository;

import com.sivale.bankcrud.Model.TransaccionesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionesRepository extends JpaRepository<TransaccionesModel, Long> {

}
