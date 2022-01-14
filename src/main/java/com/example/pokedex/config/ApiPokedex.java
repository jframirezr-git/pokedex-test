package com.example.pokedex.config;


import com.example.pokedex.dao.data.pokedex.PokedexDto;
import com.example.pokedex.dao.data.pokemon.AbilityDto;
import com.example.pokedex.dao.data.pokemon.PokemonResponseDto;
import com.example.pokedex.dao.data.pokemon.TypeDto;
import com.example.pokedex.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiPokedex {

    private final RestTemplate restTemplate;

    public HttpEntity<String> header(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return new HttpEntity<String>("parameters", headers);
    }

    public List<PokedexDto> getAllPokemons (int set){

        List<PokedexDto> pokedexDtoList = new ArrayList<>();
        List<Map> list = null;

        String url = "https://pokeapi.co/api/v2/pokemon?offset="+set+"&limit=20";

        try{

            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, header() ,Map.class);

            if (response != null && response.getStatusCode().value() == 200) {
                list = (List<Map>) response.getBody().get("results");
                for (Map item : list) {
                    PokedexDto pokedexDto = PokedexDto.builder()
                            .url(item.get("url").toString())
                            .name(item.get("name").toString())
                            .build();
                    pokedexDtoList.add(pokedexDto);
                }
            }
            return pokedexDtoList;
        }
        catch (GeneralException e){
            log.error("API Error");
            throw new GeneralException(1000, "Api Error");
        }
    }


    public PokemonResponseDto getPokemon(String url){

        PokemonResponseDto pokemon;
        List<AbilityDto> abilitiesDtoList = new ArrayList<>();
        List<Map> abilities = null;
        Map ability = null;
        List<TypeDto> typeDtoList = new ArrayList<>();
        List<Map> types = null;
        Map type = null;

        try{
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, header() ,Map.class);

            if (response != null && response.getStatusCode().value() == 200) {
                abilities = (List<Map>) response.getBody().get("abilities");
                    for(Map item : abilities) {
                            ability = (Map) item.get("ability");
                        AbilityDto  abilityDto = AbilityDto.builder()
                                .name(ability.get("name").toString())
                                .url(ability.get("url").toString())
                                .build();
                        abilitiesDtoList.add(abilityDto);
                    }

                    types = (List<Map>) response.getBody().get("types");
                    for(Map item : types){
                        type = (Map) item.get("type");

                        TypeDto typeDto = TypeDto.builder()
                                .name(type.get("name").toString())
                                .url(type.get("url").toString())
                                .build();

                        typeDtoList.add(typeDto);
                    }

                    pokemon = PokemonResponseDto.builder()
                            .abilities(abilitiesDtoList)
                            .name(response.getBody().get("name").toString())
                            .weight(response.getBody().get("weight").toString())
                            .height(response.getBody().get("height").toString())
                            .types(typeDtoList)
                            .build();

            } else {
                pokemon = null;
            }
            return pokemon;
        }
        catch (GeneralException e){
            log.error("API Error");
            throw new GeneralException(1000, "Api Error");
        }
    }


}
