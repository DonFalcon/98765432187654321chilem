package cl.fkn.chilemonedas.presentador;

import java.util.ArrayList;

import cl.fkn.chilemonedas.pojo.Moneda;
import cl.fkn.chilemonedas.pojo.TipoMoneda;

/**
 * Created by DonFalcon on 21-07-2017.
 */

public interface IFragmentResumenPresenter {

    public String obtenerTotalMonedas();
    public ArrayList<Moneda> obtenerUltimasMonedas();
    public ArrayList<TipoMoneda> obtenerTiposMonedas();

}
