package pe.edu.tecsup.mascotasapi.services;

import pe.edu.tecsup.mascotasapi.entities.Mascota;

import java.util.List;

public interface MascotaService {

    public List<Mascota> findAll();

    public Mascota findById(Long id);

    public void save(Mascota libro);

    public void deleteById(Long id);

    public Boolean existsById(Long id);
}
