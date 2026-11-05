/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Portafolio_SebastianAngulo.controller;

/**
 *
 * @author home
 */

import Portafolio_SebastianAngulo.service.CategoriaService;
import Portafolio_SebastianAngulo.service.ProductoService;
import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ConsultaController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        return "/consultas/listado";
    }

    @PostMapping("/consultaCategoria")
    public String consultaCategoria(@RequestParam() Integer idCategoria,
            Model model) {
        var productos = productoService.consultaPorCategoria(idCategoria);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        model.addAttribute("idCategoria", idCategoria);
        return "/consultas/listado";
    }

    @PostMapping("/consultaDerivada")
    public String consultaDerivida(@RequestParam() double precioInf,
            @RequestParam() double precioSup,
            Model model) {
        var productos = productoService.consultaDerivada(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/consultas/listado";
    }

    @PostMapping("/consultaJPQL")
    public String consultaJPQL(@RequestParam() double precioInf,
            @RequestParam() double precioSup,
            Model model) {
        var productos = productoService.consultaJPQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/consultas/listado";
    }

    @PostMapping("/consultaSQL")
    public String consultaSQL(@RequestParam() double precioInf,
            @RequestParam() double precioSup,
            Model model) {
        var productos = productoService.consultaSQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/consultas/listado";
    }
}

