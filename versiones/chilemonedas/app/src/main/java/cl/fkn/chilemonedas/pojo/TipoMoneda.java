package cl.fkn.chilemonedas.pojo;

/**
 * Created by DonFalcon on 14-07-2017.
 */

public class TipoMoneda {

    int id;
    int denominacion;
    String nombre;
    String tipoColeccion;
    int imagen;
    String descripcion;
    int cantidadTotal;
    int cantidadColeccionada;

    public TipoMoneda() {
    }

    public TipoMoneda(int denominacion, String nombre, int imagen, String descripcion, int cantidadTotal) {
        this.denominacion = denominacion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.cantidadTotal = cantidadTotal;
        this.cantidadColeccionada = 0;
    }

    public TipoMoneda(int denominacion, String nombre, int icono, String descripcion, int cantidadTotal, int cantidadColeccionada) {
        this.denominacion = denominacion;
        this.nombre = nombre;
        this.imagen = icono;
        this.descripcion = descripcion;
        this.cantidadTotal = cantidadTotal;
        this.cantidadColeccionada = cantidadColeccionada;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoColeccion() {
        return tipoColeccion;
    }

    public void setTipoColeccion(String tipoColeccion) {
        this.tipoColeccion = tipoColeccion;
    }

    public int getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(int denominacion) {
        this.denominacion = denominacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public int getCantidadColeccionada() {
        return cantidadColeccionada;
    }

    public void setCantidadColeccionada(int cantidadColeccionada) {
        this.cantidadColeccionada = cantidadColeccionada;
    }

    public int getPorcentajeCompletado() {

        int porcentaje = 0;

        if (cantidadTotal!=0) {
            porcentaje = (cantidadColeccionada * 100) / cantidadTotal;
        }

        return porcentaje;
    }


}
