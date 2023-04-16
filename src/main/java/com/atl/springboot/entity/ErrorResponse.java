package com.atl.springboot.entity;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    private Integer statusCode;
    private String message;

    private LocalDateTime localDateTime;

}
