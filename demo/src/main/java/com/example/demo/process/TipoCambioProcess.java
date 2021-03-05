package com.example.demo.process;

import org.springframework.stereotype.Component;

@Component
public class TipoCambioProcess {

  public Double converMontoTipoCambio(Double monto, Double tipoCambio) {
    return monto * tipoCambio;
  }
}
