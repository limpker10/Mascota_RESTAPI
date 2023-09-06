package pe.edu.tecsup.mascotasapi.services;

import pe.edu.tecsup.mascotasapi.entities.Mascota;

import java.util.List;

public interface MascotaService {
    List<Mascota> findAll();
}
