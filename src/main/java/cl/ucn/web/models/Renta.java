package cl.ucn.web.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "rentas")
public class Renta implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 255176625135723469L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dias_solicitados")
    @ElementCollection(targetClass = Date.class)
    private List<Date> diasSolicitud;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nombre_instalacion", referencedColumnName = "nombre")
    private Instalacion instalacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rut_usuario", referencedColumnName = "rut")
    private Usuario usuario;

    private Integer estado; // 0:pendiente 1:confirmado 2:rechazado

    private Integer monto;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public List<Date> getDiasSolicitud() {
	return diasSolicitud;
    }

    public void setDiasSolicitud(List<Date> diasSolicitud2) {
	this.diasSolicitud = diasSolicitud2;
    }

    public Date getFechaCreacion() {
	return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
    }

    public Instalacion getInstalacion() {
	return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
	this.instalacion = instalacion;
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public Integer getEstado() {
	return estado;
    }

    public void setEstado(Integer estado) {
	this.estado = estado;
    }

    public Integer getMonto() {
	return monto;
    }

    public void setMonto(Integer monto) {
	this.monto = monto;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

    @Override
    public String toString() {
	return "Renta [id=" + id + ", " + (diasSolicitud != null ? "diasSolicitud=" + diasSolicitud + ", " : "")
		+ (fechaCreacion != null ? "fechaCreacion=" + fechaCreacion + ", " : "")
		+ (instalacion != null ? "instalacion=" + instalacion + ", " : "")
		+ (usuario != null ? "usuario=" + usuario + ", " : "")
		+ (estado != null ? "estado=" + estado + ", " : "") + (monto != null ? "monto=" + monto : "") + "]";
    }

}
