package cl.fkn.chilemonedas.BD;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Switch;

import java.util.ArrayList;

import cl.fkn.chilemonedas.R;
import cl.fkn.chilemonedas.pojo.Moneda;

/**
 * Created by DonFalcon on 18-07-2017.
 */

public class ConstructorMonedas {

    private Context context;

    public ConstructorMonedas(Context context) {
        this.context = context;
    }

    public ArrayList<Moneda> obtenerDatos(int idTipoMoneda){

        BaseDatos db = new BaseDatos(context);
        ArrayList<Moneda> monedas = db.obtenerMonedasPorTipo(idTipoMoneda);

        if(monedas.size()==0){
            insertarMonedas(db);
            return db.obtenerMonedasPorTipo(idTipoMoneda);
        }
        return monedas;
    }

    public void sumarUnaMonedaPorID(Moneda moneda){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, moneda.getCantidad()+1);
        db.modificarCantidadMismaMoneda(contentValues, moneda.getId());
    }

    public void restarUnaMonedaPorId(Moneda moneda){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, moneda.getCantidad()-1);
        db.modificarCantidadMismaMoneda(contentValues, moneda.getId());
    }

    public void dejarEnCeroMonedas(Moneda moneda){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
        db.modificarCantidadMismaMoneda(contentValues, moneda.getId());

    }

    public void insertarMonedas(BaseDatos db){

        insertarMonedasUno(db);
        insertarMonedasCinco(db);
        insertarMonedasDiez(db);
        insertarMonedasCincuenta(db);
        insertarMonedasCien(db);
        insertarMonedasQuinientos(db);
    }

    public void insertarMonedasUno(BaseDatos db){

        ContentValues contentValues = new ContentValues();

        for (int i=1975;i<1978;i++){

            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "1");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "1");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_uno_v1_100);
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "1");

            db.insertarMoneda(contentValues);

        }

        for (int i=1978;i<1980;i++){

            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "1");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "1");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_uno_v2_100);
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "1");

            db.insertarMoneda(contentValues);

        }

        for (int i=1980;i<1992;i++) {

            switch (i) {

                case 1980:

                    break;

                case 1982:

                    break;

                case 1983:

                    break;


                case 1992:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "1");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "1");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_uno_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "1");

                    db.insertarMoneda(contentValues);

                    break;

                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "1");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "1");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_uno_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "1");

                    db.insertarMoneda(contentValues);

                    break;

            }
        }
        for (int i=1992;i<2016;i++){

            switch (i) {

                case 1992:
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "1");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "1");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_uno_v4_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "1");

                    db.insertarMoneda(contentValues);


                    break;

                case 2007:

                    break;


                case 2010:

                    break;


                case 2012:

                    break;


                case 2014:

                    break;

                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "1");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "1");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_uno_v4_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "1");

                    db.insertarMoneda(contentValues);

                    break;

            }//fin switch

        }//fin for

    }//fin agregar monedas de 1


//=================================================================================================================
//============================== Monedas de 5 =====================================================================



    public void insertarMonedasCinco(BaseDatos db){

        ContentValues contentValues = new ContentValues();

        for (int i=1976;i<1981;i++) {

            switch (i) {

                case 1979:

                    break;

                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v1_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);

                    break;
            }
        }

        for (int i=1981;i<1991;i++) {

            switch (i) {


                case 1983:

                    break;

                case 1990:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v2_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);

                    break;

                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v2_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);


                    break;

            }

        }

        for (int i=1990;i<1993;i++) {

            switch (i) {

                case 1990:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);
                    break;

                case 1992:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);

                    break;

                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);

                    break;

            }

        }

        for (int i=1992;i<2016;i++) {

            switch (i) {

                case 1992:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v4_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v4_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);

                    break;

                case 2001:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v4_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v4_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);


                    break;

                case 2002:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v4_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v4_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);

                    break;

                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "5");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cinco_v4_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "2");

                    db.insertarMoneda(contentValues);

                    break;

            }//fin switch
        }//fin for
    }//fin insertar monedas 5


//=================================================================================================================
//============================== Monedas de 10 ====================================================================


    public void insertarMonedasDiez(BaseDatos db){

        ContentValues contentValues = new ContentValues();

        for (int i=1976;i<1981;i++) {

            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v1_100);
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "Alas");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
            contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

            db.insertarMoneda(contentValues);

        }

        for (int i=1981;i<1990;i++) {

            switch (i) {

                case 1983:

                    break;

                case 1986:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v2_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "1986 gordito");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v2_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "1986 flaco");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);


                    break;

                case 1990:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v2_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "Alas");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);

                    break;

                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v2_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "Alas");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);

                    break;

            }

        }

        for (int i=1990;i<2017;i++){

            switch (i) {

                case 1990:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "Cara chica");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "c");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "Cara grande");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);

                    break;


                case 2001:

                    break;


                case 2010:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "Thenot");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "Sin thenot");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);


                    break;


                case 2014:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "1986 gordito");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "1986 flaco");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);


                    break;

                case 2015:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "holanda");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "Santiago Chile");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);


                    break;


                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "10");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_diez_v3_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "3");

                    db.insertarMoneda(contentValues);

                    break;

            }//fin switch

        }//fin for

    }//fin agregar monedas de 10


//=================================================================================================================
//============================== Monedas de 50 ====================================================================


    public void insertarMonedasCincuenta(BaseDatos db){

        ContentValues contentValues = new ContentValues();

        for (int i=1981;i<2017;i++){

            switch (i) {

                case 1983:

                    break;

                case 1984:

                    break;

                case 1989:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "0 curvo");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "0 recto");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);


                    break;

                case 1990:

                    break;


                case 2003:

                    break;


                case 2004:

                    break;


                case 2008:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "dice CHIIE");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "2008 numeros delgados");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "c");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "2008 numeros gorditos y circulares");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "d");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "2008 con números gorditos y rectos");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "e");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "La palabra Pesos es más delgada");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    break;

                case 2009:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "Dice CHIIE");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "sin thenot, cuño 1");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "c");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "sin thenot, cuño 2");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    break;

                case 2010:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "cuño 1");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "cuño 2");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "c");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "cuño 3");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    break;

                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "50");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cincuenta_v1_96);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "4");

                    db.insertarMoneda(contentValues);

                    break;

            }//fin switch

        }//fin for

    }//fin agregar monedas de 50


//=================================================================================================================
//============================== Monedas de 100 ===================================================================

    public void insertarMonedasCien(BaseDatos db){

        ContentValues contentValues = new ContentValues();

        for (int i=1981;i<2001;i++) {

            switch (i) {

                case 1982:

                    break;

                case 1983:

                    break;

                case 1987:

                    break;

                case 1990:

                    break;


                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "100");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "100");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cien_v1_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default papaya");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "5");

                    db.insertarMoneda(contentValues);

                    break;

            }
        }

        for (int i=2001;i<2017;i++) {

            switch (i) {

                case 2002:

                    break;


                case 2007:

                    break;

                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "100");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "100");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.icons8_cien_v2_100);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "5");

                    db.insertarMoneda(contentValues);

                    break;

            }//fin switch

        }//fin for

    }//fin agregar monedas de 100



//=================================================================================================================
//============================== Monedas de 500 ===================================================================

    public void insertarMonedasQuinientos(BaseDatos db){

        ContentValues contentValues = new ContentValues();

        for (int i=2000;i<2017;i++){

            switch (i) {

                case 2000:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "500");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "500");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.quinientos_v1);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "dice 2000 en el borde");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "6");

                    db.insertarMoneda(contentValues);


                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "500");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "500");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.quinientos_v1);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "6");

                    db.insertarMoneda(contentValues);

                    break;

                case 2002:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "500");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "500");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.quinientos_v1);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "a");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "2002 con letras alargadas");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "6");

                    db.insertarMoneda(contentValues);

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "500");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "500");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.quinientos_v1);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "b");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "2002 con números gorditos");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "6");

                    db.insertarMoneda(contentValues);

                    break;

                case 2004:

                    break;

                case 2005:

                    break;

                case 2006:

                    break;

                case 2007:

                    break;

                case 2009:

                    break;

                default:

                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_TIPO, "500");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VALOR_COMERCIAL, "500");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_IMAGEN, R.drawable.quinientos_v1);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ANO, i);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_VERSION, "z");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_DESCRIPCION, "default");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_COLECCIONADA, "false");
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_CANTIDAD, 0);
                    contentValues.put(ConstantesBaseDatos.TABLE_MONEDA_ID_TIPO_MONEDA, "6");

                    db.insertarMoneda(contentValues);

                    break;

            }//fin switch

        }//fin for

    }//fin agregar monedas de 500

}
