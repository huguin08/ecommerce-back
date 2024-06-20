package com.example.ecommerce.controller;

import com.example.ecommerce.model.Proveedor;
import com.example.ecommerce.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public Page<Proveedor> getAllProveedores(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return proveedorService.getAllProveedores(pageable);
    }

    @PostMapping
    public Proveedor addProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.addProveedor(proveedor);
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable Long id) {
        proveedorService.deleteProveedor(id);
    }
}

