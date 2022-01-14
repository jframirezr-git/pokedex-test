package com.example.pokedex.controller;

import com.example.pokedex.dao.data.common.Response;
import com.example.pokedex.dao.data.pokemon.PokemonRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.Serializable;

public interface PokedexController {

    @ApiOperation(value = "get all pokemons", notes = "get All Pokemons", nickname = "getAllPokemons",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = "successful request", response = Response.class),
            @ApiResponse(code = 502, message = "integration error", response = Response.class),
            @ApiResponse(code = 206, message = "error request", response = Response.class)})
    @GetMapping(path = "/pokemons/{set}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity getAllPokemons(@PathVariable int set);

    @ApiOperation(value = "get pokemon", notes = "get pokemon", nickname = "getPokemon",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = "successful request", response = Response.class),
            @ApiResponse(code = 502, message = "integration error", response = Response.class),
            @ApiResponse(code = 206, message = "error request", response = Response.class)})
    @PostMapping(path = "/pokemon",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response<Serializable>> saveCases(@Valid @RequestBody PokemonRequest request);

}

