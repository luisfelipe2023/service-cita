package pe.edu.cibertec.service_cita.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.service_cita.model.Cita;
import pe.edu.cibertec.service_cita.remoteService.PacienteClient;
import pe.edu.cibertec.service_cita.remoteService.TratamientoClient;
import pe.edu.cibertec.service_cita.service.CitaService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CitaController {
    private final CitaService citaService;
    private final PacienteClient citaClient;
    private final TratamientoClient tratamientoClient;

    @GetMapping("/mensaje-cita")
    public String obtenerListaDeCitas(){
        return "  SERVICE - CITA  ";
    }
    @GetMapping("/list-citas")
    public ResponseEntity<List<Cita>> obtenerCitas() {
        List<Cita> citas = citaService.obtenerCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerCitaPorId(@PathVariable Long id) {
        return citaService.obtenerCitaPorId(id)
                .map(cita -> new ResponseEntity<>(cita, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/saludo-pacientes")
    public String obtenerMensajeDePacientes() {
        String mensajePacientes = citaClient.saludoPacientes();
        return mensajePacientes;
    }

    @GetMapping("/info-pacientes")
    public String obtenerinfoPacientes() {
        String mensajePacientes = citaClient.informacionDelPaciente();
        return mensajePacientes;
    }
    @GetMapping("/tratamiento-mensaje")
    public String obtenerMensajeTratamiento(){
        String mensajeTratamiento = tratamientoClient.obtenerListaDeTratamientos();
        return  mensajeTratamiento;
    }

    @GetMapping("/tratamiento-descripcion")
    public String descripcionTratamiento(){
        String mensajeTratamiento = tratamientoClient.descripcionTratamiento();
        return  mensajeTratamiento;
    }


}
