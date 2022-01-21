package com.administracion.admin.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.administracion.admin.models.ProductoModel;
import com.administracion.admin.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping
    public ArrayList<ProductoModel> obtenerProductos(){
        return productoService.obtenerProductos();
    }
    @GetMapping(path="{id}")
    public Optional<ProductoModel> obtenerProducto(@PathVariable("id") Long id){
        return productoService.obtenerProducto(id);
    }
    @PostMapping
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto){
        return productoService.guardarProducto(producto);
    }
    @DeleteMapping(path = "{id}")
    public String eliminarProducto(@PathVariable("id") Long id){
        boolean elimino=productoService.eliminarProducto(id);
        if(elimino){
            return "El producto fue eliminado!";
        }
        return "Ocurrio un error al eliminar el Producto!";
    }
}
