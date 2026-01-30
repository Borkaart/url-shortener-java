package com.projeto.encurtador.repository; // Verifique se o nome do pacote bate com o seu

import com.projeto .encurtador.model.Url; // Vai ficar vermelho por enquanto
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    // Busca no banco pela coluna 'codigoCurto'
    Optional<Url> findByCodigoCurto(String codigoCurto);
}