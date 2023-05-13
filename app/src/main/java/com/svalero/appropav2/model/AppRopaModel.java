package com.svalero.appropav2.model;

import com.svalero.appropav2.contract.AppRopaContract;
import com.svalero.appropav2.domain.Ropa;

import java.util.List;

public class AppRopaModel implements AppRopaContract.Model {
    @Override
    public List<Ropa> loadAllArticulos() {
        return null;
    }

    @Override
    public Ropa getByNombre(String nombre) {
        return null;
    }

    @Override
    public List<Ropa> getAll() {
        return null;
    }

    @Override
    public Ropa getById(long idArticulo) {
        return null;
    }

    @Override
    public void deleteByNombre(String nombre) {

    }

    @Override
    public void insert(Ropa ropa) {

    }

    @Override
    public void delete(Ropa ropa) {

    }

    @Override
    public void update(Ropa ropa) {

    }
}
