package com.administracion.admin.services;

import java.util.ArrayList;
import java.util.Optional;

import com.administracion.admin.models.ClienteModel;
import com.administracion.admin.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    
    public ClienteModel guardarCliente(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }
    
    public Optional<ClienteModel> obtenerCliente(Long id){
        return clienteRepository.findById(id);
    }

    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public boolean eliminarCliente(Long id){
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
