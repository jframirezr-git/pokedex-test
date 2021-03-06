package com.example.pokedex.dao.data.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "Error", description = "Error description")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(position = 1, value = "Error")
    private Integer id;

    @ApiModelProperty(position = 2, value = "Error")
    private String name;

}
