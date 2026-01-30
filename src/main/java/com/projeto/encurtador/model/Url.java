package com.projeto.encurtador.model;

import jakarta.persistence.*;

@Entity // Isso diz que essa classe vira uma tabela no banco
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Obriga a ter um valor
    private String urlOriginal;

    private String codigoCurto;

    // --- Getters e Setters (Essenciais para o Java funcionar) ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUrlOriginal() { return urlOriginal; }
    public void setUrlOriginal(String urlOriginal) { this.urlOriginal = urlOriginal; }

    public String getCodigoCurto() { return codigoCurto; }
    public void setCodigoCurto(String codigoCurto) { this.codigoCurto = codigoCurto; }
}