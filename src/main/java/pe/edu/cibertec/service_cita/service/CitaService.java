package pe.edu.cibertec.service_cita.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.service_cita.model.Cita;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {
    private List<Cita> citas = new ArrayList<>();
    private Integer idContador = 1;

    // Constructor que se llama al crear el servicio
    public CitaService() {
        inicializarDatos();
    }

    // Método para inicializar datos
    private void inicializarDatos() {
        // Creando citas de ejemplo
        citas.add(new Cita(idContador++, 1, 1, LocalDateTime.of(2024, 10, 12, 10, 30)));
        citas.add(new Cita(idContador++, 2, 2, LocalDateTime.of(2024, 10, 13, 11, 15)));
        citas.add(new Cita(idContador++, 1, 3, LocalDateTime.of(2024, 10, 14, 9, 0)));
        citas.add(new Cita(idContador++, 3, 1, LocalDateTime.of(2024, 10, 15, 14, 45)));
        citas.add(new Cita(idContador++, 2, 2, LocalDateTime.of(2024, 10, 16, 16, 0)));
    }

    public List<Cita> obtenerCitas() {
        return citas;
    }

    public Optional<Cita> obtenerCitaPorId(Long id) {
        return citas.stream().filter(cita -> cita.getId().equals(id)).findFirst();
    }

    public Cita crearCita(Long pacienteId, Long tratamientoId, LocalDateTime fecha) {
        Cita nuevaCita = new Cita(idContador++, Math.toIntExact(pacienteId), Math.toIntExact(tratamientoId), fecha);
        citas.add(nuevaCita);
        return nuevaCita;
    }

    public boolean eliminarCita(Long id) {
        return citas.removeIf(cita -> cita.getId().equals(id));
    }

}
