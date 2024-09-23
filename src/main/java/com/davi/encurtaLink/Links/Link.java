package com.davi.encurtaLink.Links;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "links")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlOriginal;
    private String urlLonga;
    private String urlEncurtada;
    private String urlQrCode;
    private LocalDateTime urlCriadaEm;
}
