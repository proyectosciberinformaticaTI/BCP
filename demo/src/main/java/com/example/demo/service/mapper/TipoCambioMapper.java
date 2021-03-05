package com.example.demo.service.mapper;

import com.example.demo.dto.RequestCambioMontoDto;
import com.example.demo.dto.ResponseCambioMontoDto;
import io.reactivex.Single;

public interface TipoCambioMapper {

  Single<ResponseCambioMontoDto> responseCambioMonto(RequestCambioMontoDto requestCambioMontoDto, Double montoFinal,
      Double tipoCambio);

}
