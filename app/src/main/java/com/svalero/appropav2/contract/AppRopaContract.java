package com.svalero.appropav2.contract;

import com.svalero.appropav2.domain.Ropa;

import java.util.List;

public interface AppRopaContract {

    interface Model {
        List<Ropa> loadAllArticulos();
        Ropa getByNombre(String nombre);
        List<Ropa> getAll();
        Ropa getById(long idArticulo);
        void deleteByNombre(String nombre);
        void insert(Ropa ropa);
        void delete(Ropa ropa);
        void update(Ropa ropa);



    }

    interface View {
        void showArticulos(List<Ropa> ropaList);
        void showMessage(String message);

    }

    interface Presenter {
        void loadAllArticulos();
        void loadArticuloByNombre(String nombre);
        void deleteArticulo(Ropa ropa);
    }
}
