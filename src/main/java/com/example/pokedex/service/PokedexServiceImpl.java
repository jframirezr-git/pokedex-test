package com.example.pokedex.service;

import com.example.pokedex.config.ApiPokedex;
import com.example.pokedex.dao.data.pokedex.AllPokemonsResponse;
import com.example.pokedex.dao.data.pokedex.PokedexDto;
import com.example.pokedex.dao.data.pokemon.PokemonRequest;
import com.example.pokedex.dao.data.pokemon.PokemonResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokedexServiceImpl implements PokedexService{

    private final ApiPokedex apiPokedex;

    @Override
    public AllPokemonsResponse getAllPokemons(int set) {
        List<PokedexDto> pokedexDtos = apiPokedex.getAllPokemons(set);

        return AllPokemonsResponse.builder()
                .ok(true)
                .message("Request successfully")
                .pokedexDtoList(pokedexDtos)
                .build();
    }

    @Override
    public PokemonResponseDto getPokemon(PokemonRequest request) {

        PokemonResponseDto pokemon = apiPokedex.getPokemon(request.getUrl());

        return pokemon;
    }
}
