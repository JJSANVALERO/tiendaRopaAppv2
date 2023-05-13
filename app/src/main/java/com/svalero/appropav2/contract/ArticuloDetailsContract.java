package com.svalero.appropav2.contract;

import com.svalero.appropav2.domain.Ropa;

public interface ArticuloDetailsContract {

    interface Model {
        interface OnDetailArticuloListener {
            void onDetailArticuloSuccess(Ropa ropa);
            void onDetailArticuloError(String message);
        }
        void loadArticulo(OnDetailArticuloListener listener, long idRopa);

    }

    interface View {
        void showArticulo(Ropa ropa);
        void showError(String message);

        void showMessage(String message);
    }

    interface Presenter {
        void loadArticulo(long idRopa);
    }




}
