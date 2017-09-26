package cl.fkn.chilemonedas.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cl.fkn.chilemonedas.BD.ConstructorMonedas;
import cl.fkn.chilemonedas.BD.ConstructorTiposMonedas;
import cl.fkn.chilemonedas.BD.ConstructorUsuarioMoneda;
import cl.fkn.chilemonedas.pojo.Moneda;
import cl.fkn.chilemonedas.R;


/**
 * Created by DonFalcon on 16-07-2017.
 */

public class MonedaAdaptador extends RecyclerView.Adapter<MonedaAdaptador.MonedaViewHolder> {

    ArrayList<Moneda> monedas;
    Context context;

    public MonedaAdaptador(ArrayList<Moneda> monedas, Context context){

        this.monedas=monedas;
        // /PAra anoimar el recicler
        this.context = context;
    }

    @Override
    public MonedaAdaptador.MonedaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_moneda,parent,false);
        return new MonedaAdaptador.MonedaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MonedaAdaptador.MonedaViewHolder holder, final int position) {

        final Moneda moneda = monedas.get(position);
        final int cantidad = moneda.getCantidad();

        if (moneda.getVersion().equals("z")) {
            holder.tvAnoCardMoneda.setText(String.valueOf(moneda.getAno()));
        }else{
            holder.tvAnoCardMoneda.setText(String.valueOf(moneda.getAno()) +" ("+moneda.getVersion()+")");
        }
        holder.ivCardMoneda.setImageResource(moneda.getImagen());

        if(moneda.getCantidad()!=0 ){
            //holder.ivBackgroundCardMoneda.setImageResource(R.drawable.icons8_marca_de_verificaci_n_48);

            holder.tvCantidadCardMoneda.setText(String.valueOf(moneda.getCantidad()));
            //Log.e("MISTERIUUUS", "id: "+moneda.getId() +"cant: "+ cantidad + "position " + position);
            holder.tvAnoCardMoneda.setBackgroundColor(Color.rgb(0,191,165));

        }else{
            //Log.e("======SINSINSINS======", "id: "+moneda.getId() +"cant: "+ cantidad + "position " + position);
            holder.tvAnoCardMoneda.setBackgroundColor(Color.WHITE);
            holder.tvCantidadCardMoneda.setText("");
        }

        //_============= Aqui se pone y elimina el ticket==========================================
        //========================================================================================

        //apretando el dibujo
        holder.ivCardMoneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialogo = new AlertDialog.Builder(view.getContext());

                if (moneda.getVersion().equals("z")) {
                    dialogo.setTitle(String.valueOf(moneda.getAno()));
                }else{
                    dialogo.setTitle(moneda.getAno()+" ("+moneda.getVersion()+")");
                }

                dialogo.setMessage(moneda.getDescripcion());
                dialogo.setCancelable(false);
                dialogo.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        ConstructorMonedas constructorMonedas = new ConstructorMonedas(context);
                        ConstructorTiposMonedas constructorTiposMonedas = new ConstructorTiposMonedas(context);
                        ConstructorUsuarioMoneda constructorUsuarioMoneda = new ConstructorUsuarioMoneda(context);
                        if(moneda.getCantidad()==9){
                            constructorMonedas.dejarEnCeroMonedas(moneda);
                            constructorTiposMonedas.restarMonedaConteo(moneda);
                            constructorUsuarioMoneda.removerMoneda(moneda);
                            moneda.setColeccionada(false);
                            moneda.setCantidad(0);
                        }else {

                            moneda.setCantidad(moneda.getCantidad() + 1);
                            constructorMonedas.sumarMoneda(moneda);
                            if (moneda.getCantidad() == 1) {
                                constructorTiposMonedas.sumarMonedaConteo(moneda);
                            }
                            constructorUsuarioMoneda.insertarMoneda(moneda);
                            moneda.setColeccionada(true);
                            Log.i("MODIFICANDO CARDVIEWS", "id: " + moneda.getId() + " cantidad: " + moneda.getCantidad());
                        }
                        notifyItemChanged(position);
                    }
                });
                dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                    }
                });
                dialogo.setIcon(moneda.getImagen());
                dialogo.show();

                /*
                ConstructorMonedas constructorMonedas = new ConstructorMonedas(context);
                ConstructorTiposMonedas constructorTiposMonedas = new ConstructorTiposMonedas(context);
                ConstructorUsuarioMoneda constructorUsuarioMoneda = new ConstructorUsuarioMoneda(context);
                if(moneda.getCantidad()==9){
                    constructorMonedas.dejarEnCeroMonedas(moneda);
                    constructorTiposMonedas.restarMonedaConteo(moneda);
                    constructorUsuarioMoneda.removerMoneda(moneda);
                    moneda.setColeccionada(false);
                    moneda.setCantidad(0);
                }else {

                    moneda.setCantidad(moneda.getCantidad() + 1);
                    constructorMonedas.sumarMoneda(moneda);
                    if (moneda.getCantidad() == 1) {
                        constructorTiposMonedas.sumarMonedaConteo(moneda);
                    }
                    constructorUsuarioMoneda.insertarMoneda(moneda);
                    moneda.setColeccionada(true);
                    Log.i("MODIFICANDO CARDVIEWS", "id: " + moneda.getId() + " cantidad: " + moneda.getCantidad());
                }
                notifyItemChanged(position);

                */

            }
        });
        //=========================================================================================
        //setAnimation(holder.itemView, position);

    }

    //=========================================================================
    //=========================================================================

/*
    public void aceptar(){
        Toast t=Toast.makeText(context,"SIIIII", Toast.LENGTH_SHORT);
        t.show();
    }

    public void cancelar() {
        Toast t=Toast.makeText(context,"NOOOO", Toast.LENGTH_SHORT);
        t.show();
    }
*/


    //=========================================================================
    //=========================================================================


    @Override
    public int getItemCount() {
        return monedas.size();
    }

    public static class MonedaViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivCardMoneda;
        private TextView tvAnoCardMoneda;
        private TextView tvCantidadCardMoneda;
        private ImageView ivBackgroundCardMoneda;

        public MonedaViewHolder(View itemView) {
            super(itemView);

            tvCantidadCardMoneda = (TextView) itemView.findViewById(R.id.tvCantidadCardMoneda);
            ivCardMoneda = (ImageView) itemView.findViewById(R.id.ivCardMoneda);
            tvAnoCardMoneda = (TextView) itemView.findViewById(R.id.tvAnoCardMoneda);
            ivBackgroundCardMoneda = (ImageView) itemView.findViewById(R.id.ivBackgroundCardMoneda);

        }
    }

/* ================================ EN caso de querer animar el rv


 private int lastPosition = -1;
    private Context context;

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    */
}
