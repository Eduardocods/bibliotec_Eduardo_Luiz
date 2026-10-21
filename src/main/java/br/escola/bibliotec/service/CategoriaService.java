
package br.escola.bibliotec.service;

import br.escola.bibliotec.model.Categoria;
import br.escola.bibliotec.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        List<Categoria> categorias = categoriaRepository.findAll();

        System.out.println("TOTAL ENCONTRADO: " + categorias.size());

        for (Categoria categoria : categorias) {
            System.out.println(categoria.getNome());
        }

        return categorias;
    }
}
