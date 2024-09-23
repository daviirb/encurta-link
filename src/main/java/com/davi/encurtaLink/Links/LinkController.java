package com.davi.encurtaLink.Links;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class LinkController {
    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/encurta-link")
    public ResponseEntity<LinkResponse> gerarUrlEncurtada(@RequestBody Map<String, String> request) {
        String urlOriginal = request.get("urlOriginal");
        Link link = linkService.encurtarUrl(urlOriginal);

        String gerarUrlDeRedirecionamentoDoUsuario = "http://localhost:8080/r/" + link.getUrlEncurtada();

        LinkResponse response = new LinkResponse(
                link.getId(),
                link.getUrlLonga(),
                gerarUrlDeRedirecionamentoDoUsuario,
                link.getUrlQrCode(),
                link.getUrlCriadaEm()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/r/{urlEncurtada}")
    public void redirecionaLink(@PathVariable String urlEncurtada, HttpServletResponse response) throws IOException {
        Link link = linkService.obterUrlOriginal(urlEncurtada);
            System.out.println("Chegou aqui");
        if(link != null) {
            System.out.println("URL encontrada: " + link.getUrlLonga());
            response.sendRedirect(link.getUrlLonga());
        }else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
