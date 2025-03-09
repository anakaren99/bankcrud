package com.sivale.bankcrud.Repository;

import com.sivale.bankcrud.Model.Clientes;
import com.sivale.bankcrud.Model.CuentasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentasRepository extends JpaRepository<CuentasModel, Long> {

    @Query("SELECT c FROM CuentasModel c WHERE c.id_cliente = :idCliente")
    List<CuentasModel> buscarCuentasPorCliente(@Param("idCliente") Long idCliente);

}
