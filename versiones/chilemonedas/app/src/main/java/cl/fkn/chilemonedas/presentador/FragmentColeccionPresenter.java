package cl.fkn.chilemonedas.presentador;

import android.content.Context;

import java.util.ArrayList;

import cl.fkn.chilemonedas.BD.ConstructorMonedas;
import cl.fkn.chilemonedas.BD.ConstructorTiposMonedas;
import cl.fkn.chilemonedas.pojo.TipoMoneda;
import cl.fkn.chilemonedas.vista.IFragmentColeccionView;

/**
 * Created by DonFalcon on 18-07-2017.
 */

public class FragmentColeccionPresenter implements IFragmentColeccionPresenter{

    private IFragmentColeccionView iFragmentColeccionView ;
    private Context context;
    private ConstructorTiposMonedas constructorTiposMonedas;
    private ArrayList<TipoMoneda> tiposMonedas;
    private ConstructorMonedas constructorMonedas;

    public FragmentColeccionPresenter(IFragmentColeccionView iFragmentColeccionView, Context context){

        this.iFragmentColeccionView = iFragmentColeccionView;
        this.context = context;
        obtenerTiposMonedasBD();
    }

    @Override
    public void obtenerTiposMonedasBD() {
        constructorTiposMonedas = new ConstructorTiposMonedas(context);
        constructorMonedas = new ConstructorMonedas(context);
        tiposMonedas = constructorTiposMonedas.obtenerDatos();
        mostrarTiposMonedasRV();
    }

    @Override
    public void mostrarTiposMonedasRV() {
        iFragmentColeccionView.iniciarAdaptadorRV(iFragmentColeccionView.crearAdaptador(tiposMonedas));
        iFragmentColeccionView.generarLinearLayoutVertical();
    }
}
