package cl.fkn.chilemonedas.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import cl.fkn.chilemonedas.R;
import cl.fkn.chilemonedas.adapter.MonedaAdaptador;
import cl.fkn.chilemonedas.pojo.Moneda;
import cl.fkn.chilemonedas.presentador.ColeccionPorMonedaPresenter;
import cl.fkn.chilemonedas.presentador.IColeccionPorMonedaPresenter;

public class ColeccionPorMonedaView extends AppCompatActivity implements IColeccionPorMonedaView{


    private RecyclerView listaMonedas;
    private IColeccionPorMonedaPresenter presenter;
    private int idTipoMoneda;
    private int denominacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coleccion_por_monedas);

        //datos
        Bundle parametros = getIntent().getExtras();
        idTipoMoneda = parametros.getInt("id");
        denominacion = parametros.getInt("denominacion");

        //ActionBar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.tbColeccionPorMonedas);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(denominacion + " Peso");

        //editarTitulo(denominacion);
        listaMonedas = (RecyclerView) findViewById(R.id.rvColeccionPorMoneda);
        presenter = new ColeccionPorMonedaPresenter(this, getApplicationContext(), idTipoMoneda);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void editarTitulo(int denominacion){

        TextView titulo = (TextView) findViewById(R.id.tvSubtituloColeccionPorMoneda);
        titulo.setText("$ "+denominacion);

    }

    @Override
    public void generarLayout() {

        GridLayoutManager glm = new GridLayoutManager(this, 3);
        listaMonedas.setLayoutManager(glm);
    }

    @Override
    public MonedaAdaptador crearAdaptador(ArrayList<Moneda> monedas) {

        MonedaAdaptador monedaAdaptador = new MonedaAdaptador(monedas, getApplicationContext());
        return monedaAdaptador;
    }

    @Override
    public void iniciarAdaptadorRV(MonedaAdaptador monedaAdaptador) {
        listaMonedas.setAdapter(monedaAdaptador);
    }



}
