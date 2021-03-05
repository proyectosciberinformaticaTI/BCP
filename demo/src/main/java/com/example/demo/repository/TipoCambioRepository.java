package com.example.demo.repository;

import com.example.demo.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer> {

  TipoCambio findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);

}
