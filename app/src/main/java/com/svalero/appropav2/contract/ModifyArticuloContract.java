package com.svalero.appropav2.contract;

import com.svalero.appropav2.domain.Ropa;

public interface ModifyArticuloContract {

    interface Model {
        interface OnModifyArticuloListener {
            void onModifyArticuloSuccess(Ropa ropa);
            void onModifyArticuloError(String message);
        }
        void modifyArticulo (Ropa ropa, OnModifyArticuloListener listener, long idRopa);
    }

    interface View {
        void showError(String message);

        void showMessage(String message);

    }

    interface Presenter {
        void modifyArticulo(Ropa ropa, long idRopa);
    }
}
