package com.apiwhiletrue.controller;

import com.apiwhiletrue.dao.FornecedorDao;
import com.apiwhiletrue.model.Fornecedor;
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
public class FornecedorController {
    FornecedorDao dao = new FornecedorDao();

    @GetMapping("/fornecedor")
    public ArrayList<Fornecedor> getAll() {
        try {
            return dao.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    @GetMapping("/fornecedor/{id}")
    public Fornecedor getById(@PathVariable(value = "id") int id) {
        try {
            return dao.getById(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @PostMapping("/novo-fornecedor")
    public HttpStatus novaCategoria(@ModelAttribute("fornecedor") Fornecedor fornecedor) {
        try {
            dao.inserir(fornecedor);
            return HttpStatus.OK;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    
    @PutMapping("/editar-fornecedor")
    public HttpStatus editarCategoria(@ModelAttribute("fornecedor") Fornecedor fornecedor) {
        try {
            dao.atualizar(fornecedor);
            return HttpStatus.OK;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @DeleteMapping("/del-fornecedor/{id}")
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
