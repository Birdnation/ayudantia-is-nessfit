package cl.ucn.web.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -4338086459154161506L;

    @Id
    private String rut;

    @Size(min = 3, message = "Nombre corto")
    private String nombre;
    private String apellido;
    private int telefono;
    @Email
    private String email;
    private int estado; // 1: Habilitado, 0: Deshabilitado
    private String contrasena;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    private Rol rol;

    public String getRut() {
	return rut;
    }

    public void setRut(String rut) {
	this.rut = rut;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public int getTelefono() {
	return telefono;
    }

    public void setTelefono(int telefono) {
	this.telefono = telefono;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public int getEstado() {
	return estado;
    }

    public void setEstado(int estado) {
	this.estado = estado;
    }

    public String getContrasena() {
	return contrasena;
    }

    public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
    }

    public Rol getRol() {
	return rol;
    }

    public void setRol(Rol rol) {
	this.rol = rol;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

    @Override
    public String toString() {
	return "Usuario [" + (rut != null ? "rut=" + rut + ", " : "")
		+ (nombre != null ? "nombre=" + nombre + ", " : "")
		+ (apellido != null ? "apellido=" + apellido + ", " : "") + "telefono=" + telefono + ", "
		+ (email != null ? "email=" + email + ", " : "") + "estado=" + estado + ", "
		+ (contrasena != null ? "contrasena=" + contrasena + ", " : "") + (rol != null ? "rol=" + rol : "")
		+ "]";
    }

}
