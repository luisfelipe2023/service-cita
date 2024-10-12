package pe.edu.cibertec.service_cita.remoteService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-tratamiento")
public interface TratamientoClient {
    @GetMapping("/tratamiento")
    String obtenerListaDeTratamientos();
    @GetMapping("/tratamiento/descripcion")
    String descripcionTratamiento();
    @GetMapping("/{id}/descripcion")

    String descripcionTratamiento(int id);

}
