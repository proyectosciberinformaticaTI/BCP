package com.example.demo.service;

import com.example.demo.dto.RequestCambioMontoDto;
import com.example.demo.dto.ResponseCambioMontoDto;
import com.example.demo.entity.TipoCambio;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface TipoCambioService {

  Single<ResponseCambioMontoDto> tipoCambio(RequestCambioMontoDto requestCambioMontoDto);

  Observable<TipoCambio> findAll();

  Single<TipoCambio> update(TipoCambio tipoCambio);

  Maybe<TipoCambio> findById(Integer id);

}
