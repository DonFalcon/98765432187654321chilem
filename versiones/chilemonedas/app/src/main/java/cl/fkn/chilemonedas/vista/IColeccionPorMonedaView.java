package cl.fkn.chilemonedas.vista;

import java.util.ArrayList;

import cl.fkn.chilemonedas.adapter.MonedaAdaptador;
import cl.fkn.chilemonedas.pojo.Moneda;

/**
 * Created by DonFalcon on 18-07-2017.
 */

public interface IColeccionPorMonedaView {


    public void generarLayout();
    public MonedaAdaptador crearAdaptador(ArrayList<Moneda> monedas);
    public void iniciarAdaptadorRV(MonedaAdaptador MonedaAdaptador);


}
