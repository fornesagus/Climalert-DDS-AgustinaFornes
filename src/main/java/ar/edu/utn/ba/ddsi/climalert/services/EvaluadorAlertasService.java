package ar.edu.utn.ba.ddsi.climalert.services;

import ar.edu.utn.ba.ddsi.climalert.domain.AlertaMeteorologica;
import ar.edu.utn.ba.ddsi.climalert.domain.CriterioAlerta;
import ar.edu.utn.ba.ddsi.climalert.domain.RegistroClima;
import ar.edu.utn.ba.ddsi.climalert.repositories.AlertaMeteorologicaRepository;
import ar.edu.utn.ba.ddsi.climalert.repositories.RegistroClimaRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluadorAlertasService {

  private final RegistroClimaRepository registroClimaRepository;
  private final AlertaMeteorologicaRepository alertaMeteorologicaRepository;
  private final CriterioAlerta criterioAlerta;
  private final NotificarCorreoService notificarCorreoService;

  public EvaluadorAlertasService(
      RegistroClimaRepository registroClimaRepository,
      AlertaMeteorologicaRepository alertaMeteorologicaRepository,
      CriterioAlerta criterioAlerta,
      NotificarCorreoService notificarCorreoService
  ) {
    this.registroClimaRepository = registroClimaRepository;
    this.alertaMeteorologicaRepository = alertaMeteorologicaRepository;
    this.criterioAlerta = criterioAlerta;
    this.notificarCorreoService = notificarCorreoService;
  }

  public void evaluarUltimoRegistro() {
    registroClimaRepository.buscarUltimo()
        .ifPresent(this::evaluarRegistro);
  }

  private void evaluarRegistro(RegistroClima registroClima) {
    if (!criterioAlerta.seCumpleCon(registroClima)) {
      return;
    }

    AlertaMeteorologica alerta = new AlertaMeteorologica(registroClima);

    alertaMeteorologicaRepository.guardar(alerta);

    notificarCorreoService.notificar(alerta);
  }
}