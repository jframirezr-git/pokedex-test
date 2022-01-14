package com.example.pokedex.dao.data.pokedex;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllPokemonsResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean ok;
    private String message;
    private List<PokedexDto> pokedexDtoList;
}
