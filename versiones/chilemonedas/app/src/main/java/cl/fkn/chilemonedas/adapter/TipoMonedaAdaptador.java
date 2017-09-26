package cl.fkn.chilemonedas.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import cl.fkn.chilemonedas.vista.ColeccionPorMonedaView;
import cl.fkn.chilemonedas.R;
import cl.fkn.chilemonedas.pojo.TipoMoneda;

/**
 * Created by DonFalcon on 15-07-2017.
 */

public class TipoMonedaAdaptador extends RecyclerView.Adapter<TipoMonedaAdaptador.TipoMonedaViewHolder> {

    ArrayList<TipoMoneda> tipoMonedas;
    Activity activity;
    private ProgressBar progressBar = null;


    public TipoMonedaAdaptador(ArrayList<TipoMoneda> tipoMonedas, Activity activity){

        this.tipoMonedas=tipoMonedas;
        this.activity = activity;

    }

    @Override
    public TipoMonedaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_tipomoneda,parent,false);
        return new TipoMonedaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(TipoMonedaViewHolder holder, int position) {

        final TipoMoneda tipoMoneda = tipoMonedas.get(position);

        holder.tvTituloCardTipoMoneda.setText("$ " + tipoMoneda.getDenominacion());
        holder.tvCantidadMonedasTipoMoneda.setText(tipoMoneda.getCantidadColeccionada()+"/"+tipoMoneda.getCantidadTotal());


        //================ Barra de estado========================================================

        holder.pvCantidadMonedas.setVisibility(View.VISIBLE);
        holder.pvCantidadMonedas.setMax(100);
        holder.pvCantidadMonedas.setProgress(tipoMoneda.getPorcentajeCompletado());

        //=========================================================================================


        // ================= Ir a coleccion especifica de moneda ==================================

        holder.tvIrAColeccionCardTipoMoneda.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity, ColeccionPorMonedaView.class);
                intent.putExtra("id", tipoMoneda.getId());
                intent.putExtra("denominacion", tipoMoneda.getDenominacion());
                activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        if (tipoMonedas != null) {
            return tipoMonedas.size();
        }
        return 0;
    }

    public static class TipoMonedaViewHolder extends RecyclerView.ViewHolder{

        private ProgressBar pvCantidadMonedas;
        private TextView tvTituloCardTipoMoneda;
        private TextView tvIrAColeccionCardTipoMoneda;
        private TextView tvCantidadMonedasTipoMoneda;

        public TipoMonedaViewHolder(View itemView) {
            super(itemView);

            pvCantidadMonedas = (ProgressBar) itemView.findViewById(R.id.pvCantidadMonedas);
            tvTituloCardTipoMoneda = (TextView) itemView.findViewById(R.id.tvTituloCardTipoMoneda);
            tvCantidadMonedasTipoMoneda =(TextView) itemView.findViewById(R.id.tvCantidadMonedasTipoMoneda);
            tvIrAColeccionCardTipoMoneda = (TextView) itemView.findViewById(R.id.tvIrAColeccionCardTipoMoneda);

        }
    }


}
