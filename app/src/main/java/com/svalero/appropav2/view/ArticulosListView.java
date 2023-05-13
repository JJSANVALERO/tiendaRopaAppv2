package com.svalero.appropav2.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.appropav2.R;
import com.svalero.appropav2.adapter.RopaAdapter;
import com.svalero.appropav2.contract.ArticulosListContract;
import com.svalero.appropav2.domain.Ropa;
import com.svalero.appropav2.presenter.ArticulosListPresenter;

import java.util.ArrayList;
import java.util.List;

public class ArticulosListView extends AppCompatActivity implements ArticulosListContract.View {

    private List<Ropa> ropaList;
    private RopaAdapter adapter;
    private ArticulosListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos_list);

        presenter = new ArticulosListPresenter(this);

        presenter.loadAllArticulos();

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        ropaList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.ropa_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RopaAdapter(this, ropaList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllArticulos();
    }
    public void goBackButton(View view) {
        onBackPressed();
    }


    @Override
    public void showArticulos(List<Ropa> ropaList) {
        this.ropaList.clear();
        this.ropaList.addAll(ropaList);
        adapter.notifyDataSetChanged();
        Log.d("Lista Ropa", String.valueOf(ropaList));

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}