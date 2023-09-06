package pe.edu.tecsup.mascotasapi.repository;


import org.springframework.data.repository.CrudRepository;
import pe.edu.tecsup.mascotasapi.entities.Mascota;

import java.util.List;

public interface MascotaRepository extends CrudRepository<Mascota, Long> {
    @Override
    List<Mascota> findAll();
}
