package cl.fkn.chilemonedas.BD;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import cl.fkn.chilemonedas.pojo.Moneda;
import cl.fkn.chilemonedas.pojo.TipoMoneda;
import cl.fkn.chilemonedas.pojo.Usuario;

/**
 * Created by DonFalcon on 18-07-2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String queryCrearTablaTipoMoneda = "CREATE TABLE " + ConstantesBaseDatos.TABLE_TIPO_MONEDA + "("+
                ConstantesBaseDatos.TABLE_TIPO_MONEDA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                ConstantesBaseDatos.TABLE_TIPO_MONEDA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_TIPO_MONEDA_TIPO_COLECCION + " TEXT, " +
                ConstantesBaseDatos.TABLE_TIPO_MONEDA_IMAGEN + " INTEGER, " +
                ConstantesBaseDatos.TABLE_TIPO_MONEDA_DENOMINACION + " INTEGER, " +
                ConstantesBaseDatos.TABLE_TIPO_MONEDA_DESCRIPCION + " TEXT, " +
                ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_TOTAL + " INTEGER, " +
                ConstantesBaseDatos.TABLE_TIPO_MONEDA_CANTIDAD_COLECCIONADA + " INTEGER" +
                ")";


        String queryCrearTablaMoneda = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MONEDA + "("+
                ConstantesBaseDatos.TABLE_MONEDA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                ConstantesBaseDatos.TABLE_MONEDA_TIPO + " TEXT, " +
                ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL + " TEXT, " +
                ConstantesBaseDatos.TABLE_MONEDA_IMAGEN + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MONEDA_ANO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MONEDA_VERSION + " TEXT, " +
                ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION + " TEXT, " +
                ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA + " TEXT, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA +") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_TIPO_MONEDA + "(" + ConstantesBaseDatos.TABLE_TIPO_MONEDA_ID + ")" +
                ")";

        String queryCrearTablaUsuario = "CREATE TABLE " + ConstantesBaseDatos.TABLE_USUARIO + "("+
                ConstantesBaseDatos.TABLE_USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                ConstantesBaseDatos.TABLE_USUARIO_TIPO_COLECCION + " TEXT, " +
                ConstantesBaseDatos.TABLE_USUARIO_CANTIDAD_TOTAL + " INTEGER, " +
                ConstantesBaseDatos.TABLE_USUARIO_CANTIDAD_COLECCIONADA + " INTEGER " +
                ")";

        String queryCrearTablaUsuarioMoneda = "CREATE TABLE " + ConstantesBaseDatos.TABLE_USUARIO_MONEDA + "("+
                ConstantesBaseDatos.TABLE_USUARIO_MONEDA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                ConstantesBaseDatos.TABLE_USUARIO_MONEDA_ID_USUARIO + " INTEGER, "+
                ConstantesBaseDatos.TABLE_USUARIO_MONEDA_ID_MONEDA + " INTEGER, "+
                ConstantesBaseDatos.TABLE_USUARIO_MONEDA_ANO_MONEDA + " INTEGER, "+
                ConstantesBaseDatos.TABLE_USUARIO_MONEDA_IMAGEN_MONEDA + " INTEGER "+
                ")";


                db.execSQL(queryCrearTablaTipoMoneda);
        db.execSQL(queryCrearTablaMoneda);
        db.execSQL(queryCrearTablaUsuario);
        db.execSQL(queryCrearTablaUsuarioMoneda);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXIST " +ConstantesBaseDatos.TABLE_MONEDA);
        db.execSQL("DROP TABLE IF EXIST " +ConstantesBaseDatos.TABLE_TIPO_MONEDA);
        onCreate(db);
    }

    public ArrayList<TipoMoneda> obtenerMonedasStandart() {

        ArrayList<TipoMoneda> tiposMonedas = new ArrayList<>();

        String query = "SELECT * " +
                "FROM " + ConstantesBaseDatos.TABLE_TIPO_MONEDA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            TipoMoneda tipoMonedaActual = new TipoMoneda();
            tipoMonedaActual.setId(registros.getInt(0));
            tipoMonedaActual.setNombre(registros.getString(1));
            tipoMonedaActual.setTipoColeccion(registros.getString(2));
            tipoMonedaActual.setImagen(registros.getInt(3));
            tipoMonedaActual.setDenominacion(registros.getInt(4));
            tipoMonedaActual.setDescripcion(registros.getString(5));
            tipoMonedaActual.setCantidadTotal(registros.getInt(6));
            tipoMonedaActual.setCantidadColeccionada(registros.getInt(7));

            tiposMonedas.add(tipoMonedaActual);
        }

        db.close();

        return tiposMonedas;
    }

    public ArrayList<Moneda> obtenerMonedasPorTipo(int idTipoMoneda) {

        ArrayList<Moneda> monedas = new ArrayList<>();

        String query = "SELECT * " +
                "FROM " + ConstantesBaseDatos.TABLE_MONEDA +
                " WHERE " + ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA+"="+idTipoMoneda;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Moneda monedaActual = new Moneda();
            monedaActual.setId(registros.getInt(0));
            monedaActual.setTipo(registros.getString(1));
            monedaActual.setValorComercial(registros.getInt(2));
            monedaActual.setImagen(registros.getInt(3));
            monedaActual.setAno(registros.getInt(4));
            monedaActual.setVersion(registros.getString(5));
            monedaActual.setDescripcion(registros.getString(6));

            if (registros.getString(7).equals("true")){

                monedaActual.setColeccionada(true);

            }else{
                monedaActual.setColeccionada(false);
            }

            monedaActual.setCantidad(registros.getInt(8));
            monedaActual.setIdTipoMoneda(registros.getInt(9));
            monedas.add(monedaActual);
        }

        return monedas;
    }

    public void insertarTipoMoneda(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_TIPO_MONEDA, null, contentValues);

        Log.i("BASE DE DATOS:"," Insertando Tipo Moneda en base de datos ");

        db.close();
    }

    public void modificarCantidadMismaMoneda(ContentValues contentValues, int idMoneda){

        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesBaseDatos.TABLE_MONEDA, contentValues, ConstantesBaseDatos.TABLE_MONEDA_ID+"="+idMoneda, null);
        Log.i("BASE DE DATOS:"," sumando moneda a base de datos ");
        db.close();
    }

    public void insertarUsuarioMoneda(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_USUARIO_MONEDA, null, contentValues);
        Log.i("BASE DE DATOS:"," Insertando Usuario-Moneda en base de datos ");

        db.close();
    }

    public void removerUsuarioMoneda(Moneda moneda){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ConstantesBaseDatos.TABLE_USUARIO_MONEDA, ConstantesBaseDatos.TABLE_USUARIO_MONEDA_ID_MONEDA+"="+moneda.getId(), null );
        Log.i("BASE DE DATOS:"," Removiendo UsuarioMoneda de base de datos ");

        db.close();
    }

    public void insertarMoneda(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MONEDA, null, contentValues);

        Log.i("BASE DE DATOS:"," Insertando Moneda en base de datos ");

        db.close();
    }

    public void insertarUsuario(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_USUARIO, null, contentValues);
        Log.i("BASE DE DATOS:"," Insertando Usuario en base de datos ");

        db.close();
    }

    public void modificarColeccionada(ContentValues contentValues, int idMoneda){

        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesBaseDatos.TABLE_MONEDA, contentValues, ConstantesBaseDatos.TABLE_MONEDA_ID+"="+idMoneda, null);
        Log.i("BASE DE DATOS:"," añadiendo/removiendo moneda a colección");
        db.close();

    }

    public void modificarCantidadColeccionada(ContentValues contentValues, int idTipoMoneda){

        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesBaseDatos.TABLE_TIPO_MONEDA, contentValues, ConstantesBaseDatos.TABLE_TIPO_MONEDA_ID+"="+idTipoMoneda, null);
        Log.i("BASE DE DATOS:"," sumando/restando moneda a colección");
        db.close();

    }

    public TipoMoneda obtenerTipoMonedaPorId(int idTipoMoneda){

        ArrayList<TipoMoneda> tiposMonedas = new ArrayList<>();

        String query = "SELECT * " +
                "FROM " + ConstantesBaseDatos.TABLE_TIPO_MONEDA +
                " WHERE " + ConstantesBaseDatos.TABLE_TIPO_MONEDA_ID +"="+ idTipoMoneda;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        TipoMoneda tipoMonedaActual = new TipoMoneda();

        while (registros.moveToNext()){
            tipoMonedaActual = new TipoMoneda();
            tipoMonedaActual.setId(registros.getInt(0));
            tipoMonedaActual.setNombre(registros.getString(1));
            tipoMonedaActual.setTipoColeccion(registros.getString(2));
            tipoMonedaActual.setImagen(registros.getInt(3));
            tipoMonedaActual.setDenominacion(registros.getInt(4));
            tipoMonedaActual.setDescripcion(registros.getString(5));
            tipoMonedaActual.setCantidadTotal(registros.getInt(6));
            tipoMonedaActual.setCantidadColeccionada(registros.getInt(7));

            tiposMonedas.add(tipoMonedaActual);
        }

        db.close();
        return tipoMonedaActual;

    }
/*
    public ArrayList<Usuario> obtenerUsuarios(){

        ArrayList<Usuario> usuarios = new ArrayList<>();

        String query = "SELECT * " +
                "FROM " + ConstantesBaseDatos.TABLE_USUARIO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){

            Usuario usuarioActual = new Usuario();
            usuarioActual.setId(registros.getInt(0));
            usuarioActual.setTipoColeccion(registros.getString(1));
            usuarioActual.setTotalColeccion(registros.getInt(2));
            usuarioActual.setCantidadColeccionada(registros.getInt(3));
            usuarios.add(usuarioActual);
        }
        db.close();
        return usuarios;

    }

*/
    public ArrayList<Moneda> obtenerUltimasMonedas(int cantidad){

        ArrayList<Moneda> monedas = new ArrayList<>();

        String query = "SELECT * " +
                "FROM " + ConstantesBaseDatos.TABLE_USUARIO_MONEDA +
                " ORDER BY " + ConstantesBaseDatos.TABLE_USUARIO_MONEDA_ID +
                " DESC LIMIT "+cantidad;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        Moneda MonedaActual = new Moneda();

        while (registros.moveToNext()){
            MonedaActual = new Moneda();
            MonedaActual.setId(registros.getInt(2));
            MonedaActual.setAno(registros.getInt(3));
            MonedaActual.setImagen(registros.getInt(4));
            monedas.add(MonedaActual);
        }

        db.close();
        return monedas;

    }


}
