package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCambioMontoDto {

  private Double monto;

  private Double montoTipoCambio;

  private String monedaOrigen;

  private String monedaDestino;

  private Double tipoCambio;

}
