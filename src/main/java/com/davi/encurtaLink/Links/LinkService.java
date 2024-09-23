package com.davi.encurtaLink.Links;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LinkService {
    private LinkRepository linkRepository;
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String gerarUrlAleatoria() {
        return RandomStringUtils.randomAlphanumeric(5,10);
    }

    public Link encurtarUrl(String urlOriginal) {
        Link link = new Link();
        link.setUrlLonga(urlOriginal);
        link.setUrlEncurtada(gerarUrlAleatoria());
        link.setUrlCriadaEm(LocalDateTime.now());
        link.setUrlQrCode("QR CODE INDISPONIVEL NO MOMENTO");

        return linkRepository.save(link);
    }

    public Link obterUrlOriginal(String urlEncurtada) {
        try {
            return linkRepository.findByUrlEncurtada(urlEncurtada);
        } catch (Exception erro) {
            throw new RuntimeException("Url nao existe nos nossos registros");
        }
    }
}


