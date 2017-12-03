package com.apiwhiletrue.controller;

import com.apiwhiletrue.model.Categoria;
import com.apiwhiletrue.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author while true
 */
@RestController
public class TestController {

    @GetMapping("/echo/{nome}")
    public String ping(@PathVariable(value = "nome") String nome) {

        return "Oi, " + nome;
    }

    @GetMapping("/teste-produto/{id}")
    public Produto getProduto(@PathVariable(value = "id") int id) {
        return new Produto(id, "QWERTY", 19.99, new Categoria(19, "Categoria X"));
    }
}
