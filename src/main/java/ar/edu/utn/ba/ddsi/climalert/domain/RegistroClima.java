package ar.edu.utn.ba.ddsi.climalert.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RegistroClima {

  private Long id;
  private String ubicacion;
  private Double temperaturaCelsius;
  private Integer humedad;
  private String condicion;
  private LocalDateTime fechaConsulta;

  //protected RegistroClima() {}

  public RegistroClima(
      String ubicacion,
      Double temperaturaCelsius,
      Integer humedad,
      String condicion,
      LocalDateTime fechaConsulta
  ) {
    this.ubicacion = ubicacion;
    this.temperaturaCelsius = temperaturaCelsius;
    this.humedad = humedad;
    this.condicion = condicion;
    this.fechaConsulta = fechaConsulta;
  }

  //Detalle con la info registrada, que se mandaria por mail de ser necesario
  public String detalleCompleto() {
    return """
                Ubicación: %s
                Temperatura: %.1f°C
                Humedad: %d%%
                Condición: %s
                Fecha de consulta: %s
                """.formatted(
        ubicacion,
        temperaturaCelsius,
        humedad,
        condicion,
        fechaConsulta
    );
  }



}
