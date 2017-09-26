package cl.fkn.chilemonedas.BD;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import cl.fkn.chilemonedas.pojo.Moneda;
import cl.fkn.chilemonedas.pojo.Usuario;

/**
 * Created by DonFalcon on 21-07-2017.
 */

public class ConstructorUsuarios {

    private Context context;

    public ConstructorUsuarios(Context context){

        this.context = context;

    }
/*
    public Usuario obtenerDatos(){

        Usuario usuario;
        BaseDatos db = new BaseDatos(context);
        ArrayList<Usuario> usuarios = db.obtenerUsuarios();

        if(usuarios.size()==0){
            insertarUsuarios(db);
        }
        usuarios = db.obtenerUsuarios();
        return usuarios.get(0);
    }

    public void insertarUsuarios(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_TIPO_COLECCION, "standart");
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_CANTIDAD_TOTAL, "1000");
        contentValues.put(ConstantesBaseDatos.TABLE_USUARIO_CANTIDAD_COLECCIONADA, "0");

        db.insertarUsuario(contentValues);

    }
*/
}
