package com.example.demo.service.mapper;

import com.example.demo.dto.RequestCambioMontoDto;
import com.example.demo.dto.ResponseCambioMontoDto;
import io.reactivex.Single;
import org.springframework.stereotype.Component;

@Component
public class TipoCambioMapperImpl implements TipoCambioMapper {


  @Override
  public Single<ResponseCambioMontoDto> responseCambioMonto(RequestCambioMontoDto requestCambioMontoDto, Double montoFinal, Double tipoCambio) {
    return Single.just(ResponseCambioMontoDto.builder()
        .monto(requestCambioMontoDto.getMonto())
        .montoTipoCambio(montoFinal)
        .monedaOrigen(requestCambioMontoDto.getMonedaOrigen())
        .monedaDestino(requestCambioMontoDto.getMonedaDestino())
        .tipoCambio(tipoCambio)
        .build());
  }
}
