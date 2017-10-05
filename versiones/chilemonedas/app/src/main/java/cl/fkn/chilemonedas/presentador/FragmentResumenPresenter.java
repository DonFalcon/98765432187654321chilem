package cl.fkn.chilemonedas.presentador;

import android.content.Context;

import java.util.ArrayList;

import cl.fkn.chilemonedas.BD.ConstructorTiposMonedas;
import cl.fkn.chilemonedas.BD.ConstructorUsuarioMoneda;
import cl.fkn.chilemonedas.pojo.Moneda;
import cl.fkn.chilemonedas.pojo.TipoMoneda;
import cl.fkn.chilemonedas.vista.IFragmentResumenView;

/**
 * Created by DonFalcon on 21-07-2017.
 */

public class FragmentResumenPresenter implements IFragmentResumenPresenter {

    private IFragmentResumenView iFragmentResumenView;
    private Context context;
    private ConstructorTiposMonedas constructorTiposMonedas;
    private ConstructorUsuarioMoneda constructorUsuarioMoneda;
    private ArrayList<TipoMoneda> tiposMonedas;
    private ArrayList<Moneda> ultimasMonedas;


    public FragmentResumenPresenter(IFragmentResumenView iFragmentResumenView, Context context){

        this.iFragmentResumenView = iFragmentResumenView;
        this.context = context;

        //obtiene la informacion desde la bd si existe
        constructorTiposMonedas = new ConstructorTiposMonedas(context);
        constructorUsuarioMoneda = new ConstructorUsuarioMoneda(context);
        tiposMonedas = constructorTiposMonedas.obtenerDatos();
        ultimasMonedas = constructorUsuarioMoneda.getUltimosCinco();
    }

    public String obtenerTotalMonedas(){

        int total=0;
        int coleccionadas=0;
        String respuesta = "";

        for (int i=0;i<tiposMonedas.size();i++){
            total = total + tiposMonedas.get(i).getCantidadTotal();
            coleccionadas = coleccionadas + tiposMonedas.get(i).getCantidadColeccionada();
        }

        respuesta = coleccionadas+"/"+total;
        return respuesta;

    }

    public ArrayList<Moneda> obtenerUltimasMonedas(){

        return ultimasMonedas;

    }

    public ArrayList<TipoMoneda> obtenerTiposMonedas(){
        return tiposMonedas;
    }




}
