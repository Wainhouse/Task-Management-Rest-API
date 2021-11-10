package com.wainhouse.tmra.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?, ?> data;

}
