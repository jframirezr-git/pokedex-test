package com.example.pokedex.service;

import com.example.pokedex.dao.data.pokedex.AllPokemonsResponse;
import com.example.pokedex.dao.data.pokemon.PokemonRequest;
import com.example.pokedex.dao.data.pokemon.PokemonResponseDto;

public interface PokedexService {

    AllPokemonsResponse getAllPokemons(int set);

    PokemonResponseDto getPokemon(PokemonRequest request);
}
