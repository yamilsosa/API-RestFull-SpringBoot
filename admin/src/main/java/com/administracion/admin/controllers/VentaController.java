package com.administracion.admin.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.administracion.admin.models.VentaModel;
import com.administracion.admin.services.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    VentaService ventaService;

    @GetMapping
    public ArrayList<VentaModel> obtenerVentas(){
        return ventaService.obtenerVentas();
    }
    @PostMapping
    public VentaModel guardarVenta(@RequestBody VentaModel venta){
        return ventaService.guardarVenta(venta);
    }
    @GetMapping(path="{id}")
    public Optional<VentaModel> obtenerVenta(@PathVariable("id") Long id){
        return ventaService.obtenerVenta(id);
    }

    @DeleteMapping(path="{id}")
    public String borrarVenta(@PathVariable("id") Long id){
        boolean elimino=ventaService.eliminarVenta(id);
        if(elimino){
            return "La venta se elimino!";
        }
        return "Ocurrio un Error al eliminar la Venta!";
    }
}
