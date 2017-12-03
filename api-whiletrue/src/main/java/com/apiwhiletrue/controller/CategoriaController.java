package com.apiwhiletrue.controller;

import com.apiwhiletrue.dao.CategoriaDao;
import com.apiwhiletrue.model.Categoria;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author while true
 */
@RestController()
public class CategoriaController {

    @GetMapping("/categoria")
    public ArrayList<Categoria> getAll() {
        try {
            return new CategoriaDao().listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    @GetMapping("/categoria/{id}")
    public Categoria getById(@PathVariable(value = "id") int id){
        try {
            return new CategoriaDao().getById(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
