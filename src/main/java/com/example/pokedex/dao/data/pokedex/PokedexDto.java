package com.example.pokedex.dao.data.pokedex;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokedexDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String url;
}
