package cl.fkn.chilemonedas.pojo;

/**
 * Created by DonFalcon on 14-07-2017.
 */

public class Moneda {

    int id;
    String tipo;
    int valorComercial;
    int imagen;
    int ano;
    String version;
    String descripcion;
    Boolean coleccionada;
    int cantidad;
    int idTipoMoneda;

    public Moneda(){

    }

    public Moneda(String tipo, int valorComercial, int imagen, int ano, String version, String descripcion, Boolean coleccionada) {
        this.tipo = tipo;
        this.valorComercial = valorComercial;
        this.imagen = imagen;
        this.ano = ano;
        this.version = version;
        this.descripcion = descripcion;
        this.coleccionada = coleccionada;
        this.cantidad = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipoMoneda() {
        return idTipoMoneda;
    }

    public void setIdTipoMoneda(int idTipoMoneda) {
        this.idTipoMoneda = idTipoMoneda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(int valorComercial) {
        this.valorComercial = valorComercial;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getColeccionada() {
        return coleccionada;
    }

    public void setColeccionada(Boolean coleccionada) {
        this.coleccionada = coleccionada;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
