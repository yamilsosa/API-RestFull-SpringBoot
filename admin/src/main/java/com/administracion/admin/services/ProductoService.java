package com.administracion.admin.services;

import java.util.ArrayList;
import java.util.Optional;

import com.administracion.admin.models.ProductoModel;
import com.administracion.admin.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    public Optional<ProductoModel> obtenerProducto(Long id) {
        return productoRepository.findById(id);
    }

    public ArrayList<ProductoModel> obtenerProductos() {
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public boolean eliminarProducto(Long id) {

        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
