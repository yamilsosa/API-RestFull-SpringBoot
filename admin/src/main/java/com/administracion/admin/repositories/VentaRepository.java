package com.administracion.admin.repositories;

import com.administracion.admin.models.VentaModel;

import org.springframework.data.repository.CrudRepository;

public interface VentaRepository extends CrudRepository<VentaModel,Long> {
    
}
