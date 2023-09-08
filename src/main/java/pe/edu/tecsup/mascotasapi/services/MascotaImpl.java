package pe.edu.tecsup.mascotasapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.mascotasapi.entities.Mascota;
import pe.edu.tecsup.mascotasapi.repository.MascotaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MascotaImpl implements MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;
    @Override
    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota findById(Long id) {
        return mascotaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
    }

    @Override
    public void save(Mascota libro) {
        mascotaRepository.save(libro);
    }

    @Override
    public void deleteById(Long id) {
        mascotaRepository.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return mascotaRepository.existsById(id);
    }

}
