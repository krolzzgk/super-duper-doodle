package com.apiwhiletrue.controller;

import com.apiwhiletrue.dao.CategoriaDao;
import com.apiwhiletrue.model.Categoria;
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
public class CategoriaController {

    CategoriaDao dao = new CategoriaDao();

    @GetMapping("/categoria")
    public ArrayList<Categoria> getAll() {
        try {
            return dao.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @GetMapping("/categoria/{id}")
    public Categoria getById(@PathVariable(value = "id") int id) {
        try {
            return dao.getById(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @PostMapping("/nova-categoria")
    public HttpStatus novaCategoria(@ModelAttribute("categoria") Categoria categoria) {
        try {
            dao.inserir(categoria);
            return HttpStatus.OK;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    
    @PutMapping("/editar-categoria")
    public HttpStatus editarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        try {
            dao.atualizar(categoria);
            return HttpStatus.OK;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @DeleteMapping("/del-categoria/{id}")
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
