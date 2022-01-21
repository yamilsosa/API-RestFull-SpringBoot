package com.administracion.admin.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.administracion.admin.models.ClienteModel;
import com.administracion.admin.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ArrayList<ClienteModel> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @PostMapping
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente){
        return clienteService.guardarCliente(cliente);
    }
    @GetMapping(path = "{id}")
    public Optional<ClienteModel> obtenerCliente(@PathVariable("id") Long id){
        return clienteService.obtenerCliente(id);
    }

    @DeleteMapping(path = "{id}")
    public String eliminarCliente(@PathVariable("id") Long id) {
        boolean elimino= clienteService.eliminarCliente(id);
        if(elimino){
            return "El cliente fue eliminado!";
        }
        return "Ocurrio un error al eliminar el Cliente!";
    }
    
}
