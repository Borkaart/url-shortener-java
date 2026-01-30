package com.projeto.encurtador.service;

import org.springframework.stereotype.Service;

@Service
public class UrlService {

    // Alfabeto: 0-9, a-z, A-Z (Total de 62 caracteres)
    private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALFABETO.length();

    // Método que converte o ID (ex: 105) para Código (ex: "b9")
    public String converterParaBase62(Long id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(ALFABETO.charAt((int) (id % BASE)));
            id /= BASE;
        }
        return sb.reverse().toString();
    }

    // Opcional: Se quiséssemos fazer o caminho inverso (Código -> ID)
    // poderíamos adicionar outro método aqui depois.
}