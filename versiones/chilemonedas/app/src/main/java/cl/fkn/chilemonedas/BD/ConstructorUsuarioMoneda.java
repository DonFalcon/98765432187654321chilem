package cl.fkn.chilemonedas.BD;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import cl.fkn.chilemonedas.pojo.Moneda;
import cl.fkn.chilemonedas.pojo.Usuario;

/**
 * Created by DonFalcon on 21-07-2017.
 */

public class ConstructorUsuarioMoneda {

    Context context;

    public ConstructorUsuarioMoneda(Context context){

        this.context = context;

    }

    public void insertarMoneda(Moneda moneda){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_MONEDA_ID_MONEDA, moneda.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_MONEDA_ID_USUARIO, "1");
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_MONEDA_ANO_MONEDA, moneda.getAno());
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_MONEDA_IMAGEN_MONEDA, moneda.getImagen());

        db.insertarUsuarioMoneda(contentValues);
    }

    public void removerMoneda(Moneda moneda){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        db.removerUsuarioMoneda(moneda);
    }

    public ArrayList<Moneda> getUltimosCinco(){

        BaseDatos db = new BaseDatos(context);
        ArrayList<Moneda> monedas = db.obtenerUltimasMonedas(5);

        return monedas;

    }

}