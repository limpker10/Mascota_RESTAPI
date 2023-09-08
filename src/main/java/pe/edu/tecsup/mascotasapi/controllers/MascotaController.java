package pe.edu.tecsup.mascotasapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.tecsup.mascotasapi.entities.Mascota;
import pe.edu.tecsup.mascotasapi.services.MascotaService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class MascotaController {
    private static final Logger logger = LoggerFactory.getLogger(MascotaController.class);
    @Autowired
    private MascotaService mascotaService;
    @GetMapping("/mascotas")
    public ResponseEntity<List<Mascota>> obtenerLibros() {
        try {
            List<Mascota> libros = mascotaService.findAll();
            logger.info("Libros encontrados: " + libros.size());

            if (libros.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(libros);
            }
        } catch (Exception e) {
            logger.error("Error al obtener libros", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/mascotas/{id}")
    public ResponseEntity<Mascota> obtenerLibroPorId(@PathVariable Long id) {
        try {

            Mascota libro = mascotaService.findById(id);

            if (libro != null) {
                return ResponseEntity.status(HttpStatus.OK).body(libro);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/mascotas")
    public ResponseEntity<Mascota> crearLibro(@RequestBody Mascota mascota) {
        try {
            mascotaService.save(mascota);
            logger.info("Libro creado: " + mascota);
            return ResponseEntity.status(HttpStatus.CREATED).body(mascota);
        } catch (Exception e) {
            logger.error("Error al crear libros", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/mascotas/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable Long id) {
        try {
            if (!mascotaService.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El libro con ID " + id + " no se encuentra.");
            }
            mascotaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("El libro con ID " + id + " ha sido eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el libro.");
        }
    }
}
