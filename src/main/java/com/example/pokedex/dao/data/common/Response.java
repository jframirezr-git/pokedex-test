package com.example.pokedex.dao.data.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "Response", description = "http response")
public class Response <T extends Serializable> implements Serializable  {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(position = 1, value = "Ok")
    private T data;

    @ApiModelProperty(position = 2, value = "Error")
    private ErrorResponse errorResponse;

    public Response(T data) {
        this.data = data;
    }
}
