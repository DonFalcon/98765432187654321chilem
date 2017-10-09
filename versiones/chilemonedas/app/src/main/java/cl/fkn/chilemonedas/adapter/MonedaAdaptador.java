package cl.fkn.chilemonedas.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.ColorSpace;
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

        if (moneda.getVersion().equals("z")) {
            holder.tvAnoCardMoneda.setText(String.valueOf(moneda.getAno()));
        }else{
            holder.tvAnoCardMoneda.setText(String.valueOf(moneda.getAno()) +" ("+moneda.getVersion()+")");
        }
        holder.ivCardMoneda.setImageResource(moneda.getImagen());

        if(moneda.getCantidad()!=0 ){

            holder.tvCantidadCardMoneda.setText(String.valueOf(moneda.getCantidad()));
            holder.tvAnoCardMoneda.setBackgroundColor(Color.rgb(0,191,165));

        }else{
            holder.tvAnoCardMoneda.setBackgroundColor(Color.WHITE);
            holder.tvCantidadCardMoneda.setText("");
        }

        //_============= Aqui se pone y elimina las monedas al presionarlas ============================
        //==============================================================================================

        //apretando el dibujo
        holder.ivCardMoneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                // AlertDialog.Builder dialogo = new AlertDialog.Builder(view.getContext(), R.style.AppTheme);
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

                            constructorMonedas.sumarUnaMonedaPorID(moneda);//primero se suma una moneda al conteo de esa moneda especifica
                            if (moneda.getCantidad() == 0) {
                                constructorTiposMonedas.sumarMonedaConteo(moneda);//si es la primera de ese año se agrega al conteo de la coleccion
                            }
                            constructorUsuarioMoneda.insertarMoneda(moneda);// se añade a la lista de todas las monedas agregadas
                            moneda.setColeccionada(true);
                            Log.i("MODIFICANDO CARDVIEWS", "id: " + moneda.getId() + " cantidad: " + moneda.getCantidad()+1);
                        }
                        moneda.setCantidad(moneda.getCantidad() + 1);// se modifica la moneda "local"
                        notifyItemChanged(position);
                    }
                });

                //Boton remover ============
                dialogo.setNegativeButton("Quitar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        ConstructorMonedas constructorMonedas = new ConstructorMonedas(context);
                        ConstructorTiposMonedas constructorTiposMonedas = new ConstructorTiposMonedas(context);
                        ConstructorUsuarioMoneda constructorUsuarioMoneda = new ConstructorUsuarioMoneda(context);

                        constructorMonedas.restarUnaMonedaPorId(moneda);//primero se resta una moneda a esa moneda especifica

                            if (moneda.getCantidad() == 1) { //si solo queda una moneda
                                constructorTiposMonedas.restarMonedaConteo(moneda); //cuando quedan cero monedas se resta del conteo de esa moneda especifica
                                moneda.setColeccionada(false);
                            }

                        constructorUsuarioMoneda.removerMoneda(moneda); //se remueve de la lista de todas las monedas agregadas
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

                //si no hay monedas el boton "remover" se descativa
                //dialogo.show();
                AlertDialog dialog = dialogo.show();
                if (moneda.getCantidad()==0){
                        Button buttonNegative = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                        buttonNegative.setEnabled(false);

                    }
                //el boton cancelar se pone de otro color

                Button buttonNeutral = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
                buttonNeutral.setTextColor(Color.rgb(75,75,75));





            }
        });

    }




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


}
