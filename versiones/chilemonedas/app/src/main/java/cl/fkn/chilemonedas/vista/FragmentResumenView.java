package cl.fkn.chilemonedas.vista;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import cl.fkn.chilemonedas.R;
import cl.fkn.chilemonedas.pojo.Moneda;
import cl.fkn.chilemonedas.presentador.FragmentResumenPresenter;
import cl.fkn.chilemonedas.presentador.IFragmentResumenPresenter;

public class FragmentResumenView extends Fragment implements IFragmentResumenView  {

    private IFragmentResumenPresenter presenter;
    private View v;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        v = inflater.inflate(R.layout.fragment_resumen, container, false);
        presenter = new FragmentResumenPresenter(this, getContext());
        cargarCantidadMonedasColeccionadas();
        cargarUltimasMonedas();

        return v;
    }

    @Override
    public void cargarCantidadMonedasColeccionadas() {

        TextView tvTotalColeccionadas = (TextView) v.findViewById(R.id.tvTotalMonedasColeccionadasResumen);
        tvTotalColeccionadas.setText(presenter.obtenerTotalMonedas());

    }

    @Override
    public void cargarUltimasMonedas() {

        ArrayList<Moneda> ultimasMonedas = presenter.obtenerUltimasMonedas();

        TextView tvUltimaMoneda1 = (TextView) v.findViewById(R.id.tvUltimaMoneda1);
        ImageView ivUltimaMoneda1 = (ImageView) v.findViewById(R.id.ivUltimaMoneda1);
        TextView tvUltimaMoneda2 = (TextView) v.findViewById(R.id.tvUltimaMoneda2);
        ImageView ivUltimaMoneda2 = (ImageView) v.findViewById(R.id.ivUltimaMoneda2);
        TextView tvUltimaMoneda3 = (TextView) v.findViewById(R.id.tvUltimaMoneda3);
        ImageView ivUltimaMoneda3 = (ImageView) v.findViewById(R.id.ivUltimaMoneda3);
        TextView tvUltimaMoneda4 = (TextView) v.findViewById(R.id.tvUltimaMoneda4);
        ImageView ivUltimaMoneda4 = (ImageView) v.findViewById(R.id.ivUltimaMoneda4);
        TextView tvUltimaMoneda5 = (TextView) v.findViewById(R.id.tvUltimaMoneda5);
        ImageView ivUltimaMoneda5 = (ImageView) v.findViewById(R.id.ivUltimaMoneda5);

        switch(ultimasMonedas.size()){

            case 1:
                tvUltimaMoneda5.setText(String.valueOf(ultimasMonedas.get(0).getAno()));
                ivUltimaMoneda5.setImageResource(ultimasMonedas.get(0).getImagen());
                break;

            case 2:
                tvUltimaMoneda5.setText(String.valueOf(ultimasMonedas.get(0).getAno()));
                ivUltimaMoneda5.setImageResource(ultimasMonedas.get(0).getImagen());
                tvUltimaMoneda4.setText(String.valueOf(ultimasMonedas.get(1).getAno()));
                ivUltimaMoneda4.setImageResource(ultimasMonedas.get(1).getImagen());
                break;
            case 3:

                tvUltimaMoneda5.setText(String.valueOf(ultimasMonedas.get(0).getAno()));
                ivUltimaMoneda5.setImageResource(ultimasMonedas.get(0).getImagen());
                tvUltimaMoneda4.setText(String.valueOf(ultimasMonedas.get(1).getAno()));
                ivUltimaMoneda4.setImageResource(ultimasMonedas.get(1).getImagen());
                tvUltimaMoneda3.setText(String.valueOf(ultimasMonedas.get(2).getAno()));
                ivUltimaMoneda3.setImageResource(ultimasMonedas.get(2).getImagen());
                break;
            case 4:

                tvUltimaMoneda5.setText(String.valueOf(ultimasMonedas.get(0).getAno()));
                ivUltimaMoneda5.setImageResource(ultimasMonedas.get(0).getImagen());
                tvUltimaMoneda4.setText(String.valueOf(ultimasMonedas.get(1).getAno()));
                ivUltimaMoneda4.setImageResource(ultimasMonedas.get(1).getImagen());
                tvUltimaMoneda3.setText(String.valueOf(ultimasMonedas.get(2).getAno()));
                ivUltimaMoneda3.setImageResource(ultimasMonedas.get(2).getImagen());
                tvUltimaMoneda2.setText(String.valueOf(ultimasMonedas.get(3).getAno()));
                ivUltimaMoneda2.setImageResource(ultimasMonedas.get(3).getImagen());
                break;
            case 5:
                tvUltimaMoneda5.setText(String.valueOf(ultimasMonedas.get(0).getAno()));
                ivUltimaMoneda5.setImageResource(ultimasMonedas.get(0).getImagen());
                tvUltimaMoneda4.setText(String.valueOf(ultimasMonedas.get(1).getAno()));
                ivUltimaMoneda4.setImageResource(ultimasMonedas.get(1).getImagen());
                tvUltimaMoneda3.setText(String.valueOf(ultimasMonedas.get(2).getAno()));
                ivUltimaMoneda3.setImageResource(ultimasMonedas.get(2).getImagen());
                tvUltimaMoneda2.setText(String.valueOf(ultimasMonedas.get(3).getAno()));
                ivUltimaMoneda2.setImageResource(ultimasMonedas.get(3).getImagen());
                tvUltimaMoneda1.setText(String.valueOf(ultimasMonedas.get(4).getAno()));
                ivUltimaMoneda1.setImageResource(ultimasMonedas.get(4).getImagen());
                break;

            default:
                Log.e("CEKHGIDRHGUSH", "DSFIGHDSFU");
                break;

        }




    }

    @Override
    public void cargarTrofeos() {

    }

}
