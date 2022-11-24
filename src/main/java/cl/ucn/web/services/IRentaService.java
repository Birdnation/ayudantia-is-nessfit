package cl.ucn.web.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.ucn.web.models.Renta;

public interface IRentaService {

    public void guardar(Renta renta);

    public List<Renta> buscarPorInstalacionAndEstado(String instalacion, int estado);

    public Page<Renta> verRentasPorUsuario(String rut, Pageable page);

    public List<Renta> verRentasPorUsuario(String rut);

    public Page<Renta> verSolicitudesPorEstado(Integer estado, Pageable page);

    public Renta buscarPorId(int id);

    public List<Renta> buscarPorRangoFecha(Date inicio, Date termino);
}
