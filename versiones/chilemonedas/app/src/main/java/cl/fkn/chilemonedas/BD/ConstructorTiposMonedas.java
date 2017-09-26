package cl.fkn.chilemonedas.BD;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import cl.fkn.chilemonedas.R;
import cl.fkn.chilemonedas.pojo.Moneda;
import cl.fkn.chilemonedas.pojo.TipoMoneda;

/**
 * Created by DonFalcon on 18-07-2017.
 */

public class ConstructorTiposMonedas {

    private Context context;

    public ConstructorTiposMonedas(Context context) {
        this.context = context;
    }

    public ArrayList<TipoMoneda> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        ArrayList<TipoMoneda> tiposMonedas = db.obtenerMonedasStandart();

        if (tiposMonedas.size()==0) {
            insertarTiposMonedasStandart(db);
            return db.obtenerMonedasStandart();
        }
        return tiposMonedas;

    }

    public void sumarMonedaConteo(Moneda moneda){

        BaseDatos db = new BaseDatos(context);
        TipoMoneda tipoMoneda= db.obtenerTipoMonedaPorId(moneda.getIdTipoMoneda());
        ContentValues contentValues = new ContentValues();
        int cantidad = tipoMoneda.getCantidadColeccionada()+1;
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_COLECCIONADA, cantidad);
        db.modificarCantidadColeccionada(contentValues,moneda.getIdTipoMoneda());
    }

    public void restarMonedaConteo(Moneda moneda){

        BaseDatos db = new BaseDatos(context);
        TipoMoneda tipoMoneda= db.obtenerTipoMonedaPorId(moneda.getIdTipoMoneda());
        ContentValues contentValues = new ContentValues();
        int cantidad = tipoMoneda.getCantidadColeccionada();
        if (cantidad >0){
            cantidad=cantidad-1;
        }
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_COLECCIONADA, cantidad);
        db.modificarCantidadColeccionada(contentValues,moneda.getIdTipoMoneda());
    }


    public void insertarTiposMonedasStandart(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_NOMBRE, "Un Peso");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_TIPO_COLECCION, "Standart");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_IMAGEN, "R.drawable.icons8_moneda_128");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DENOMINACION, "1");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DESCRIPCION, "Desde 1975 hasta el 2015");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_TOTAL, "36");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_COLECCIONADA, "0");

        db.insertarTipoMoneda(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_NOMBRE, "Cinco Pesos");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_TIPO_COLECCION, "Standart");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_IMAGEN, "R.drawable.icons8_moneda_128");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DENOMINACION, "5");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DESCRIPCION, "Desde 1976 hasta el 2015");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_TOTAL, "42");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_COLECCIONADA, "0");

        db.insertarTipoMoneda(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_NOMBRE, "Diez Peso");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_TIPO_COLECCION, "Standart");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_IMAGEN, "R.drawable.icons8_moneda_128");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DENOMINACION, "10");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DESCRIPCION, "Desde 1976 hasta la actualidad");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_TOTAL, "45");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_COLECCIONADA, "0");

        db.insertarTipoMoneda(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_NOMBRE, "Cincuenta Pesos");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_TIPO_COLECCION, "Standart");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_IMAGEN, "R.drawable.icons8_moneda_128");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DENOMINACION, "50");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DESCRIPCION, "Desde 1981 hasta la actualidad");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_TOTAL, "40");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_COLECCIONADA, "0");

        db.insertarTipoMoneda(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_NOMBRE, "Cien Pesos");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_TIPO_COLECCION, "Standart");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_IMAGEN, "R.drawable.icons8_moneda_128");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DENOMINACION, "100");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DESCRIPCION, "Desde 1981 hasta la actualidad");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_TOTAL, "30");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_COLECCIONADA, "0");

        db.insertarTipoMoneda(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_NOMBRE, "Quinientos Pesos");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_TIPO_COLECCION, "Standart");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_IMAGEN, "R.drawable.icons8_moneda_128");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DENOMINACION, "500");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_DESCRIPCION, "Desde el año 2000 hasta la actualidad");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_TOTAL, "14");
        contentValues.put(ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_COLECCIONADA, "0");

        db.insertarTipoMoneda(contentValues);

    }



}
