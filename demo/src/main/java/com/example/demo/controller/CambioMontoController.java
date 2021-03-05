package com.example.demo.controller;

import com.example.demo.dto.RequestCambioMontoDto;
import com.example.demo.dto.ResponseCambioMontoDto;
import com.example.demo.entity.TipoCambio;
import com.example.demo.service.TipoCambioService;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class CambioMontoController {

  private TipoCambioService cambioMontoService;

  @ApiOperation(value = "Obtener Tipo de Cambio", response = Iterable.class, tags = "tipoCambio")
  @PostMapping(value = "/tipo/cambio")
  public ResponseEntity<Single<ResponseCambioMontoDto>> tipoCambio(@RequestBody RequestCambioMontoDto requestCambioMontoDto) {
    Single<ResponseCambioMontoDto> cambioMontoDtoSingle = cambioMontoService.tipoCambio(requestCambioMontoDto);
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(cambioMontoDtoSingle);
  }

  @ApiOperation(value = "Lista de tipo de cambio", response = Iterable.class, tags = "tipoCambio")
  @GetMapping
  public ResponseEntity<Observable<TipoCambio>> findAll() {
    Observable<TipoCambio> listTipoCambio = cambioMontoService.findAll();
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(listTipoCambio);
  }

  @ApiOperation(value = "Actualizar Tipo de Cambio", response = Iterable.class, tags = "tipoCambio")
  @PutMapping(value = "/{id}")
  public ResponseEntity<Single<TipoCambio>> update(@RequestBody TipoCambio tipoCambio, @PathVariable Integer id) {
    Single<TipoCambio> tipoCambioMaybe = cambioMontoService.findById(id)
        .toSingle()
        .flatMap(response -> {
          tipoCambio.setId(response.getId());
          return cambioMontoService.update(tipoCambio);
        });
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(tipoCambioMaybe);
  }

  @ApiOperation(value = "Buscar Tipo de Cambio por Id", response = Iterable.class, tags = "tipoCambio")
  @GetMapping(value = "/{id}")
  public Maybe<ResponseEntity<TipoCambio>> findById(@PathVariable Integer id) {
    return cambioMontoService.findById(id)
        .map(responseCambioMonto ->
            ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(responseCambioMonto)
        ).defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
