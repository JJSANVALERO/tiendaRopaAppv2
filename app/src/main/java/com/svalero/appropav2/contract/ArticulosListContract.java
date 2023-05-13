package com.svalero.appropav2.contract;

import com.svalero.appropav2.domain.Ropa;

import java.util.List;

public interface ArticulosListContract {

    interface Model {
        interface OnLoadArticulosListener {
            void onLoadArticulosSuccess(List<Ropa> listaRopa);

            void onLoadArticulosError(String message);
        }

        void loadAllArticulos(OnLoadArticulosListener listener);


        void update(Ropa ropa);


    }

    interface View {
        void showArticulos(List<Ropa> listaRopa);

        void showMessage(String message);

    }

    interface Presenter {
        void loadAllArticulos();

        void loadArticuloByNombre(String nombre);

        void deleteArticulo(Ropa ropa);
    }
}
