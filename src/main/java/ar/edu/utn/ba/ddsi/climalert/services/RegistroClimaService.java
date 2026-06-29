package ar.edu.utn.ba.ddsi.climalert.services;

import ar.edu.utn.ba.ddsi.climalert.domain.RegistroClima;
import ar.edu.utn.ba.ddsi.climalert.repositories.RegistroClimaRepository;
import ar.edu.utn.ba.ddsi.climalert.weatherAPI.WeatherApiCliente;
import org.springframework.stereotype.Service;

@Service
public class RegistroClimaService {
  //Pide clima a WeatherAPI, lo pasa a RegistroClima y guarda
  private final WeatherApiCliente weatherApiCliente;
  private final RegistroClimaRepository registroClimaRepository;

  public RegistroClimaService(
      WeatherApiCliente weatherApiCliente,
      RegistroClimaRepository registroClimaRepository
  ) {
    this.weatherApiClient = weatherApiClient;
    this.registroClimaRepository = registroClimaRepository;
  }

  public RegistroClima registrarClimaActual() {
    RegistroClima registro = weatherApiClient.obtenerClimaActual();
    return registroClimaRepository.save(registro);
  }

}
