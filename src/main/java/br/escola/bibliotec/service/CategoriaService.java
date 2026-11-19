package br.escola.bibliotec.service;

import br.escola.bibliotec.model.Categoria;
import br.escola.bibliotec.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import br.escola.bibliotec.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final LivroRepository livroRepository;

    public CategoriaService(CategoriaRepository categoriaRepository, LivroRepository livroRepository) {this.categoriaRepository = categoriaRepository;this.livroRepository = livroRepository;}

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAllByOrderByNomeAsc();
    }

    public void salvar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public void excluir(Long id) {
        categoriaRepository.deleteById(id);
    }

    public boolean nomeJaExiste(@Valid Categoria categoria) {return false;}

    public boolean possuiLivros(Long id) {return livroRepository.existsByCategoriaId(id);}
}