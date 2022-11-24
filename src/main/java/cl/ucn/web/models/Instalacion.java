package cl.ucn.web.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "instalaciones")
public class Instalacion implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8074867975298871205L;
    @Id
    private String nombre;
    private String direccion;
    private TipoInstalacion tipo;
    @Min(value = 0)
    @Max(value = 1)
    private Integer estado; // 0: inoperativa 1:operativa
    private Integer precio;

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getDireccion() {
	return direccion;
    }

    public void setDireccion(String direccion) {
	this.direccion = direccion;
    }

    public TipoInstalacion getTipo() {
	return tipo;
    }

    public void setTipo(TipoInstalacion tipo) {
	this.tipo = tipo;
    }

    public Integer getEstado() {
	return estado;
    }

    public void setEstado(Integer estado) {
	this.estado = estado;
    }

    public Integer getPrecio() {
	return precio;
    }

    public void setPrecio(Integer precio) {
	this.precio = precio;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

    @Override
    public String toString() {
	return "Instalacion [" + (nombre != null ? "nombre=" + nombre + ", " : "")
		+ (direccion != null ? "direccion=" + direccion + ", " : "")
		+ (tipo != null ? "tipo=" + tipo + ", " : "") + (estado != null ? "estado=" + estado + ", " : "")
		+ (precio != null ? "precio=" + precio : "") + "]";
    }

}
