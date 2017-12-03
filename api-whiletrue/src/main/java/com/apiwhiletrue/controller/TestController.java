package com.apiwhiletrue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
@RequestMapping("/teste")
public class TestController {

    @GetMapping("/categoria")
    public ModelAndView testeCategoria() {
        return new ModelAndView("teste-api-categoria.html");
    }

    @GetMapping("/fornecedor")
    public ModelAndView testeFornecedor() {
        return new ModelAndView("teste-api-fornecedor.html");
    }
}
