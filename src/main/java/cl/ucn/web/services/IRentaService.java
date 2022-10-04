package cl.ucn.web.services;

import java.util.List;

import cl.ucn.web.models.Renta;

public interface IRentaService {

    public void guardar(Renta renta);

    public List<Renta> buscarPorInstalacion(String instalacion);
}
