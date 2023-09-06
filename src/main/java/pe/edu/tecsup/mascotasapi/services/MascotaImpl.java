package pe.edu.tecsup.mascotasapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.mascotasapi.entities.Mascota;
import pe.edu.tecsup.mascotasapi.repository.MascotaRepository;

import java.util.List;

@Service
public class MascotaImpl implements MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;
    @Override
    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }
}
