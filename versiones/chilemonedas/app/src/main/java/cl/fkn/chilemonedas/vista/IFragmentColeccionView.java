package cl.fkn.chilemonedas.vista;

import java.util.ArrayList;

import cl.fkn.chilemonedas.adapter.TipoMonedaAdaptador;
import cl.fkn.chilemonedas.pojo.TipoMoneda;

/**
 * Created by DonFalcon on 18-07-2017.
 */

public interface IFragmentColeccionView {

    public void generarLinearLayoutVertical();
    public TipoMonedaAdaptador crearAdaptador(ArrayList<TipoMoneda> monedas);
    public void iniciarAdaptadorRV(TipoMonedaAdaptador tipoMonedaAdaptador);

}
