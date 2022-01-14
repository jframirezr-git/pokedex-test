package com.example.pokedex.dao.data.pokemon;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private List<AbilityDto> abilities;

    private String height;

    private String weight;

    private List<TypeDto> types;

}
