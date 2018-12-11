package com.hwua.springboot04.controller;

import com.hwua.springboot04.dao.ProductDao;
import com.hwua.springboot04.po.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductDao productDao;
    @GetMapping("/products")
    public String list(Model model){
        List<Product> products = productDao.getAll();
        model.addAttribute("products",products);
        return "list";
    }
    @GetMapping("/product")
    public String toAddForm(){
        return "form";
    }
    @GetMapping("/product/{productId}")
    public String toEditForm(@PathVariable Integer productId, Model model){
        Product product = productDao.get(productId);
        model.addAttribute("product",product);
        return "form";
    }
    @PostMapping("/product")
    public String save(Product product){
        boolean save = productDao.save(product);
        System.out.println("save = " + save);
        return "redirect:/products";
    }
    @PutMapping("/product")
    public String update(Product product){
        Product update = productDao.update(product);
        return "redirect:/products";
    }
    @DeleteMapping("/product/{productId}")
    public String delete(@PathVariable Integer productId){
        Product delete = productDao.delete(productId);
        return "redirect:/products";
    }
}
