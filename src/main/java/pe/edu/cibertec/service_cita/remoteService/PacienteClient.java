package pe.edu.cibertec.service_cita.remoteService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-paciente")
public interface PacienteClient {
    @GetMapping("/pacientes/saludo-paciente")
    String saludoPacientes();
    @GetMapping("/info-paciente")
    String informacionDelPaciente();


}
