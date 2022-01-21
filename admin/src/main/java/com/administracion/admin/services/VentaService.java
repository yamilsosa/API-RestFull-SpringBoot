package com.administracion.admin.services;

import java.util.ArrayList;
import java.util.Optional;

import com.administracion.admin.models.VentaModel;
import com.administracion.admin.repositories.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    @Autowired
    VentaRepository ventaRepository;

    public VentaModel guardarVenta(VentaModel venta){
        return ventaRepository.save(venta);
    }

    public Optional<VentaModel> obtenerVenta(Long id){
        return ventaRepository.findById(id);
    }

    public ArrayList<VentaModel> obtenerVentas(){
        return (ArrayList<VentaModel>) ventaRepository.findAll();
    }
    public boolean eliminarVenta(Long id) {
        
        try {
            ventaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
