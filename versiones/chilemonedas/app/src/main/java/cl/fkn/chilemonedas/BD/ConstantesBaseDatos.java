package cl.fkn.chilemonedas.BD;

/**
 * Created by DonFalcon on 18-07-2017.
 */

public final class ConstantesBaseDatos {


    public static final String DATABASE_NAME = "db_monedas_chile";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_TIPO_MONEDA = "tipo_moneda";
    public static final String TABLE_TIPO_MONEDA_ID = "id";
    public static final String TABLE_TIPO_MONEDA_NOMBRE = "nombre";
    public static final String TABLE_TIPO_MONEDA_TIPO_COLECCION = "coleccion";
    public static final String TABLE_TIPO_MONEDA_IMAGEN = "imagen";
    public static final String TABLE_TIPO_MONEDA_DENOMINACION = "denominacion";
    public static final String TABLE_TIPO_MONEDA_DESCRIPCION = "descripcion";
    public static final String TABLE_TIPO_MONEDA_CANTIDAD_TOTAL = "cantidad_total";
    public static final String TABLE_TIPO_MONEDA_CANTIDAD_COLECCIONADA = "cantidad_coleccionada";


    public static final String TABLE_MONEDA = "moneda";
    public static final String TABLE_MONEDA_ID = "id";
    public static final String TABLE_MONEDA_TIPO = "tipo";
    public static final String TABLE_MONEDA_VALOR_COMERCIAL = "valor";
    public static final String TABLE_MONEDA_IMAGEN = "imagen";
    public static final String TABLE_MONEDA_ANO = "ano";
    public static final String TABLE_MONEDA_VERSION = "version";
    public static final String TABLE_MONEDA_DESCRIPCION = "descripcion";
    public static final String TABLE_MONEDA_COLECCIONADA = "coleccionada";
    public static final String TABLE_MONEDA_CANTIDAD = "cantidad";
    public static final String TABLE_MONEDA_ID_TIPO_MONEDA = "id_tipo_moneda";

    public static final String TABLE_TROFEO = "trofeo";
    public static final String TABLE_TROFEO_ID = "id";
    public static final String TABLE_TROFEO_NOMBRE = "nombre";
    public static final String TABLE_TROFEO_TIPO = "tipo";
    public static final String TABLE_TROFEO_COLOR = "color";
    public static final String TABLE_TROFEO_FOTO = "imagen";
    public static final String TABLE_TROFEO_ID_USUARIO = "id_usuario";

    public static final String TABLE_USUARIO = "usuario";
    public static final String TABLE_USUARIO_ID = "id";
    public static final String TABLE_USUARIO_TIPO_COLECCION = "tipo_coleccion";
    public static final String TABLE_USUARIO_CANTIDAD_COLECCIONADA = "cantidad_coleccionada";
    public static final String TABLE_USUARIO_CANTIDAD_TOTAL = "cantidad_total";

    public static final String TABLE_USUARIO_MONEDA = "usuario_moneda";
    public static final String TABLE_USUARIO_MONEDA_ID = "id";
    public static final String TABLE_USUARIO_MONEDA_ID_USUARIO = "id_usuario";
    public static final String TABLE_USUARIO_MONEDA_ID_MONEDA = "id_moneda";
    public static final String TABLE_USUARIO_MONEDA_ANO_MONEDA = "ano_moneda";
    public static final String TABLE_USUARIO_MONEDA_IMAGEN_MONEDA = "imagen_moneda";



}
