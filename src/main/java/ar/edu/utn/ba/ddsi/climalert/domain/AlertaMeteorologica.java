package ar.edu.utn.ba.ddsi.climalert.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AlertaMeteorologica {

  private Long id;
  private RegistroClima registroClima;
  private LocalDateTime fechaGeneracion;
  private String mensaje;

  //protected AlertaMeteorologica() {}

  public AlertaMeteorologica(RegistroClima registroClima) {
    this.registroClima = registroClima;
    this.fechaGeneracion = LocalDateTime.now();
    this.mensaje = "Se detectaron condiciones climáticas críticas.";
  }

  public String detalleParaCorreo() {
    return """
                ALERTA METEOROLÓGICA
                
                %s
                
                Detalle del clima:
                %s
                """.formatted(
        mensaje,
        registroClima.detalleCompleto()
    );
  }

}