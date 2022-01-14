package com.example.pokedex.dao.data.pokemon;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PokemonRequest {

    @ApiModelProperty(value = "Url", required = true, position = 1)
    String url;
}
