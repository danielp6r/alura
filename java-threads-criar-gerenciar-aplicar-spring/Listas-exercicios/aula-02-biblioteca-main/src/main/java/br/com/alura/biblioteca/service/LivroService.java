package br.com.alura.biblioteca.service;

import br.com.alura.biblioteca.dto.LivroDTO;
import br.com.alura.biblioteca.model.Livro;
import br.com.alura.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    @Transactional
    public void atualizarTituloDoLivro(Long livroId, String novoTitulo) {
        Optional<Livro> livroOptional = livroRepository.findById(livroId);

        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            livro.setTitulo(novoTitulo);
            livroRepository.save(livro);
        }
    }

    //No caso de remover a anotação @Transactional:
    //Estamos forçando um incremento. então a leitura também escreve no banco de dados, pois ela precisa
    //incrementar a versão. Dessa forma, se o metodo não é anotado com Transactional, recebemos uma exceção.

    //@Transactional
    @Transactional
    public LivroDTO obterLivroPeloId(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            var livro = livroOptional.get();
            return new LivroDTO(livro.getTitulo(), livro.getAutor());
        }
        return null;
    }
}

