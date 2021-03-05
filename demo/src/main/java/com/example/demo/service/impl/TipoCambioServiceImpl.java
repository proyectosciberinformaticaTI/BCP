package com.example.demo.service.impl;

import com.example.demo.dto.RequestCambioMontoDto;
import com.example.demo.dto.ResponseCambioMontoDto;
import com.example.demo.entity.TipoCambio;
import com.example.demo.process.TipoCambioProcess;
import com.example.demo.repository.TipoCambioRepository;
import com.example.demo.service.TipoCambioService;
import com.example.demo.service.mapper.TipoCambioMapper;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TipoCambioServiceImpl implements TipoCambioService {

  private final TipoCambioRepository tipoCambioRepository;

  private final TipoCambioMapper cambioMontoMapper;

  private final TipoCambioProcess tipoCambioProcess;

  @Override
  public Single<ResponseCambioMontoDto> tipoCambio(RequestCambioMontoDto requestCambioMontoDto) {
    TipoCambio responseTipoCambio =
        tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(requestCambioMontoDto.getMonedaOrigen().toUpperCase(),
            requestCambioMontoDto.getMonedaDestino().toUpperCase());

    Double montoFinal = tipoCambioProcess.converMontoTipoCambio(requestCambioMontoDto.getMonto(), responseTipoCambio.getTipoCambio());
    return cambioMontoMapper.responseCambioMonto(requestCambioMontoDto, montoFinal, responseTipoCambio.getTipoCambio());
  }

  @Override
  public Observable<TipoCambio> findAll() {
    return Single.just(tipoCambioRepository.findAll())
        .toObservable()
        .flatMap(Observable::fromIterable);
  }

  @Override
  public Single<TipoCambio> update(TipoCambio tipoCambio) {
    return Single.just(tipoCambioRepository.save(tipoCambio));
  }

  @Override
  public Maybe<TipoCambio> findById(Integer id) {
    Optional<TipoCambio> optionalTipoCambio = tipoCambioRepository.findById(id);

    if (optionalTipoCambio.isPresent()) {
      return Maybe.just(optionalTipoCambio.get());
    } else {
      return Maybe.empty();
    }
  }
}
