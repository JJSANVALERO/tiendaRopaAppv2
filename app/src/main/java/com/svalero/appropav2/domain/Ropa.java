package com.svalero.appropav2.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;



public class Ropa {
    private long idRopa;
    private String nombre;
    private String code;
//    @JsonFormat(pattern = "dd-MM-yyyy")
    private String fechaAlta;
    private double precio;
    private Boolean hayStock;

    public Ropa() {

    }

    public Boolean getHayStock() {
        return hayStock;
    }

    public void setHayStock(Boolean hayStock) {
        this.hayStock = hayStock;
    }

    public Ropa(long idRopa, String nombre, String code, String fechaAlta, double precio, Boolean hayStock) {
        this.idRopa = idRopa;
        this.nombre = nombre;
        this.code = code;
        this.fechaAlta = fechaAlta;
        this.precio = precio;
        this.hayStock = hayStock;
    }

    public Ropa(String nombre, String code, String fechaAlta, double precio, Boolean hayStock) {
        this.nombre = nombre;
        this.code = code;
        this.fechaAlta = fechaAlta;
        this.precio = precio;
        this.hayStock = hayStock;
    }

    public long getIdRopa() {
        return idRopa;
    }

    public void setIdRopa(long idRopa) {
        this.idRopa = idRopa;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isHayStock() {
        return hayStock;
    }

    public void setHayStock(boolean hayStock) {
        this.hayStock = hayStock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
