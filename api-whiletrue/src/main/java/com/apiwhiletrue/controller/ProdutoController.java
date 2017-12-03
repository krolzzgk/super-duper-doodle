
package com.apiwhiletrue.controller;

import com.apiwhiletrue.dao.ProdutoDao;
import com.apiwhiletrue.model.Produto;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author while true
 */
@RestController()
public class ProdutoController {
    ProdutoDao dao = new ProdutoDao();
    
    
    @GetMapping("/produto")
    public ArrayList<Produto> getAll() {
        try {
            return dao.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @GetMapping("/produto/{id}")
    public Produto getById(@PathVariable(value = "id") int id) {
        try {
            return dao.getById(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @PostMapping("/novo-produto")
    public HttpStatus novaCategoria(@ModelAttribute("produto") Produto produto) {
        try {
            dao.inserir(produto);
            return HttpStatus.OK;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    
    @PutMapping("/editar-produto")
    public HttpStatus editarCategoria(@ModelAttribute("produto") Produto produto) {
        try {
            dao.atualizar(produto);
            return HttpStatus.OK;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @DeleteMapping("/del-prduto/{id}")
    public HttpStatus delCategoria(@PathVariable(value = "id") int id) {
        try {
            dao.excluir(id);
            return HttpStatus.OK;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
