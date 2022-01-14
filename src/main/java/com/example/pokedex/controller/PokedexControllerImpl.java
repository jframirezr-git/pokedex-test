package com.example.pokedex.controller;

import com.example.pokedex.dao.data.common.ErrorResponse;
import com.example.pokedex.dao.data.common.Response;
import com.example.pokedex.dao.data.pokemon.PokemonRequest;
import com.example.pokedex.service.PokedexService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;

@Api(value = "Pokedex", tags = "Pokedex")
@RestController
@RequiredArgsConstructor
public class PokedexControllerImpl implements PokedexController{

    private final PokedexService pokedexService;

    @Override
    public ResponseEntity getAllPokemons(int set) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(pokedexService.getAllPokemons(set), new ErrorResponse()));
    }

    @Override
    public ResponseEntity<Response<Serializable>> saveCases(@Valid PokemonRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(pokedexService.getPokemon(request), new ErrorResponse()));
    }

}
