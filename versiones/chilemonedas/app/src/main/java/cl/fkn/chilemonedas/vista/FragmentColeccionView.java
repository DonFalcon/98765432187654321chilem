package cl.fkn.chilemonedas.vista;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cl.fkn.chilemonedas.R;
import cl.fkn.chilemonedas.adapter.TipoMonedaAdaptador;
import cl.fkn.chilemonedas.pojo.TipoMoneda;
import cl.fkn.chilemonedas.presentador.FragmentColeccionPresenter;
import cl.fkn.chilemonedas.presentador.IFragmentColeccionPresenter;

/**
 * Created by DonFalcon on 16-07-2017.
 */

public class FragmentColeccionView extends Fragment implements IFragmentColeccionView {


    private RecyclerView listaTipoMonedas;
    private IFragmentColeccionPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_coleccion, container, false);

        listaTipoMonedas = (RecyclerView) v.findViewById(R.id.rvColeccion);
        presenter = new FragmentColeccionPresenter(this, getContext());
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaTipoMonedas.setLayoutManager(llm);
    }

    @Override
    public TipoMonedaAdaptador crearAdaptador(ArrayList<TipoMoneda> tiposMonedas) {

        TipoMonedaAdaptador tipoMonedaAdaptador = new TipoMonedaAdaptador(tiposMonedas, getActivity());
        return tipoMonedaAdaptador;
    }

    @Override
    public void iniciarAdaptadorRV(TipoMonedaAdaptador tipoMonedaAdaptador) {
        listaTipoMonedas.setAdapter(tipoMonedaAdaptador);
    }
}
