package com.davi.encurtaLink.Links;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class LinkResponse {
    private Long id;
    private String urlLong;
    private String urlEncurtada;
    private String urlQrCode;
    private LocalDateTime urlCriadaEm;
}
