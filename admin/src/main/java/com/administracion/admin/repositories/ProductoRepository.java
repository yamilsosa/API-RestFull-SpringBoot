package com.administracion.admin.repositories;

import com.administracion.admin.models.ProductoModel;

import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<ProductoModel,Long>{
    
}
