package com.projeto.encurtador.controller;

import com.projeto.encurtador.model.Url;
import com.projeto.encurtador.repository.UrlRepository;
import com.projeto.encurtador.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UrlController {

    @Autowired
    private UrlRepository repository;

    @Autowired
    private UrlService service;

    // 1. Rota para exibir a página principal
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // 2. Rota que recebe a URL longa do formulário
    @PostMapping("/encurtar")
    public String encurtar(@RequestParam String urlOriginal, Model model) {
        Url url = new Url();
        url.setUrlOriginal(urlOriginal);

        // Primeiro salvamos para o Hibernate gerar o ID único
        url = repository.save(url);

        // Agora usamos o ID gerado para criar o código Base62
        String codigo = service.converterParaBase62(url.getId());
        url.setCodigoCurto(codigo);

        // Atualizamos o registro com o código curto
        repository.save(url);

        // Enviamos a URL pronta para o HTML exibir
        model.addAttribute("urlEncurtada", "http://localhost:8080/" + codigo);
        return "index";
    }

    // 3. Rota de Redirecionamento (quando alguém clica no link curto)
    @GetMapping("/{codigo}")
    public RedirectView redirecionar(@PathVariable String codigo) {
        Url url = repository.findByCodigoCurto(codigo)
                .orElseThrow(() -> new RuntimeException("Ops! Link não encontrado."));

        return new RedirectView(url.getUrlOriginal());
    }
}