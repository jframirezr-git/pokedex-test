package com.example.pokedex.exception;

import javax.validation.constraints.NotBlank;

public class GeneralException extends MainException {
    private static final long serialVersionUID = 0x4D9F49EC614DC330L;
    private final Integer code;

    public GeneralException(@NotBlank Integer code, String msg) {
        this(code, msg, null);
    }


    public GeneralException(@NotBlank Integer code, String msg, Throwable causa) {
        super(msg, causa);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
