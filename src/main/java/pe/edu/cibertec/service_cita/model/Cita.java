package pe.edu.cibertec.service_cita.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Cita {
    private Integer id;
    private Integer pacienteId;
    private Integer tratamientoId;
    private LocalDateTime fecha;
}
