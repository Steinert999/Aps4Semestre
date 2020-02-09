package br.com.ies.candyShop.controller;

import br.com.ies.candyShop.entity.Produto;
import br.com.ies.candyShop.services.ProdutoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/home")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtos")
    @ResponseBody
    public List<Produto> listProdutos(){
        return produtoService.findAll();
    }

    @GetMapping("/produto/{id}")
    @ResponseBody
    public Produto getProduto(@PathVariable(value = "id") Long idProduto){
        return produtoService.FindProdutoById(idProduto);
    }
}
