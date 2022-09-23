package cl.ucn.web.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

    private static final long serialVersionUID = 6997599843726610795L;

    @Id
    private int id;
    private String nombre;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

}
