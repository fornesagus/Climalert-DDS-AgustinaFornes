package ar.edu.utn.ba.ddsi.climalert.domain;


import lombok.Getter;

@Getter
public class CriterioAlerta { //TODO: pensar en si se agrega otro criterio. hacerlo interfaz

  private Double temperaturaMinima;
  private Integer humedadMinima;

  public CriterioAlerta() {
    this.temperaturaMinima = 35.0;
    this.humedadMinima = 60;
  }

  /*public CriterioAlerta(Double temperaturaMinima, Integer humedadMinima) {
    this.temperaturaMinima = temperaturaMinima;
    this.humedadMinima = humedadMinima;
  }*/

  public boolean seCumpleCon(RegistroClima registroClima) {
    return registroClima.getTemperaturaCelsius() > temperaturaMinima
        && registroClima.getHumedad() > humedadMinima;
  }

}
