package cl.fkn.chilemonedas.presentador;

import android.content.Context;

import java.util.ArrayList;

import cl.fkn.chilemonedas.BD.ConstructorMonedas;
import cl.fkn.chilemonedas.pojo.Moneda;
import cl.fkn.chilemonedas.vista.IColeccionPorMonedaView;

/**
 * Created by DonFalcon on 18-07-2017.
 */

public class ColeccionPorMonedaPresenter implements IColeccionPorMonedaPresenter {


    private IColeccionPorMonedaView iColeccionPorMonedaView;
    private Context context;
    private ConstructorMonedas constructorMonedas;
    private ArrayList<Moneda> monedas;


    public ColeccionPorMonedaPresenter(IColeccionPorMonedaView iColeccionPorMonedaView, Context context, int idTipoMoneda){

        this.iColeccionPorMonedaView = iColeccionPorMonedaView;
        this.context = context;
        obtenerMonedasBD(idTipoMoneda);
    }

    @Override
    public void obtenerMonedasBD(int idTipoMoneda) {
        constructorMonedas = new ConstructorMonedas(context);
        monedas = constructorMonedas.obtenerDatos(idTipoMoneda);
        mostrarMonedasRV();
    }


    @Override
    public void mostrarMonedasRV() {

        iColeccionPorMonedaView.iniciarAdaptadorRV(iColeccionPorMonedaView.crearAdaptador(monedas));
        iColeccionPorMonedaView.generarLayout();

    }
}
