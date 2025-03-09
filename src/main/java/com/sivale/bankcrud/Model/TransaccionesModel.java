package com.sivale.bankcrud.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Transacciones")
public class TransaccionesModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaccion;
    private Long id_cuenta_origen;
    private Long id_cuenta_destino;
    private double monto;
    private Date fecha_transaccion;
    private String tipo_transaccion;

    public Long getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(Long id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Long getId_cuenta_origen() {
        return id_cuenta_origen;
    }

    public void setId_cuenta_origen(Long id_cuenta_origen) {
        this.id_cuenta_origen = id_cuenta_origen;
    }

    public Long getId_cuenta_destino() {
        return id_cuenta_destino;
    }

    public void setId_cuenta_destino(Long id_cuenta_destino) {
        this.id_cuenta_destino = id_cuenta_destino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public Date getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(Date fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }
}
