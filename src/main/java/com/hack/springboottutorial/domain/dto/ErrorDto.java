package com.hack.springboottutorial.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {

    private String originalErrorMessage;
    private final String errorMessage;
    private String requestURL;

    @Builder
    public ErrorDto(String originalErrorMessage, String errorMessage, String requestURL) {
        this.originalErrorMessage = originalErrorMessage;
        this.errorMessage = errorMessage;
        this.requestURL = requestURL;
    }
}
