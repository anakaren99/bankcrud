package com.sivale.bankcrud.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


public class ResponseConsultaCuentas {

    //private int id_cliente;
    private String nombre;
    private String apellido;
    private String correo_electronico;
    private String telefono;
    private String direccion;
    private List<Cuentas> cuentas;

    @AllArgsConstructor
    public static class Cuentas{
        //private Long id_cuenta;
        private Long id_cliente;
        private String tipo_cuenta;
        private double saldo;
        private Date fecha_apertura;

        public Long getId_cliente() {
            return id_cliente;
        }

        public void setId_cliente(Long id_cliente) {
            this.id_cliente = id_cliente;
        }

        public String getTipo_cuenta() {
            return tipo_cuenta;
        }

        public void setTipo_cuenta(String tipo_cuenta) {
            this.tipo_cuenta = tipo_cuenta;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        public Date getFecha_apertura() {
            return fecha_apertura;
        }

        public void setFecha_apertura(Date fecha_apertura) {
            this.fecha_apertura = fecha_apertura;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

}
