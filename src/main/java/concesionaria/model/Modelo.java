package concesionaria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by cristian.ovando on 27/04/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Modelo {
    private String nombre;
    private Double precio;
    private String[] opcionales;
    private String _id;
    private String query;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String[] getOpcionales() {
        return opcionales;
    }

    public void setOpcionales(String[] opcionales) {
        this.opcionales = opcionales;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
