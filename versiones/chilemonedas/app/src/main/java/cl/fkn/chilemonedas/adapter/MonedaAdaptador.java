package cl.fkn.chilemonedas.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

        //_============= Aqui se pone y elimina el color de coleccionado ===========================
        //==========================================================================================

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

                // al apretar el boton agregar
                dialogo.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        ConstructorMonedas constructorMonedas = new ConstructorMonedas(context);
                        ConstructorTiposMonedas constructorTiposMonedas = new ConstructorTiposMonedas(context);
                        ConstructorUsuarioMoneda constructorUsuarioMoneda = new ConstructorUsuarioMoneda(context);
                        if(moneda.getCantidad()==99){
                            //constructorMonedas.dejarEnCeroMonedas(moneda);
                            //constructorTiposMonedas.restarMonedaConteo(moneda);
                            //constructorUsuarioMoneda.removerMoneda(moneda);
                            //moneda.setColeccionada(false);
                            //moneda.setCantidad(0);
                        }else {

                            constructorMonedas.sumarUnaMonedaPorID(moneda);//primero se suma una moneda
                            if (moneda.getCantidad()+1 == 1) {
                                constructorTiposMonedas.sumarMonedaConteo(moneda);//si es la primera de ese año se agrega al conteo de la coleccion
                            }
                            constructorUsuarioMoneda.insertarMoneda(moneda);// se añade a la lista de ultima agregada
                            moneda.setColeccionada(true);
                            Log.i("MODIFICANDO CARDVIEWS", "id: " + moneda.getId() + " cantidad: " + moneda.getCantidad()+1);
                        }
                        moneda.setCantidad(moneda.getCantidad() + 1);// se modifica la moneda "local"
                        notifyItemChanged(position);
                    }
                });

                //Boton remover ============
                dialogo.setNegativeButton("Remover", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        ConstructorMonedas constructorMonedas = new ConstructorMonedas(context);
                        ConstructorTiposMonedas constructorTiposMonedas = new ConstructorTiposMonedas(context);
                        ConstructorUsuarioMoneda constructorUsuarioMoneda = new ConstructorUsuarioMoneda(context);

                        constructorMonedas.restarUnaMonedaPorId(moneda);//primero se resta una moneda a la bd de monedas

                            if (moneda.getCantidad()-1 == 0) {
                                constructorTiposMonedas.restarMonedaConteo(moneda);
                                moneda.setColeccionada(false);
                            }

                        constructorUsuarioMoneda.removerMoneda(moneda);
                        moneda.setCantidad(moneda.getCantidad() - 1); // se modifica la moneda "local"

                        Log.i("MODIFICANDO CARDVIEWS", "id: " + moneda.getId() + " cantidad: " + moneda.getCantidad());
                        notifyItemChanged(position);
                    }
                });

                //el boton de cancelar
                dialogo.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                    }
                });
                dialogo.setIcon(moneda.getImagen());
                //dialogo.show();

                //si no hay monedas el boton remover aparece descativsado
                AlertDialog dialog = dialogo.show();
                if (moneda.getCantidad()==0){
                        Button button = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                        button.setEnabled(false);
                    }

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
