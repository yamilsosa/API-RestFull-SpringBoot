package com.administracion.admin.repositories;

import com.administracion.admin.models.ClienteModel;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteModel,Long>{
    
}
