package com.example.ecommerce.service;

import com.example.ecommerce.model.Proveedor;
import com.example.ecommerce.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public Page<Proveedor> getAllProveedores(Pageable pageable) {
        return proveedorRepository.findAll(pageable);
    }

    public Proveedor addProveedor(Proveedor proveedor) {
        Optional<Proveedor> existingProveedor = proveedorRepository.findByNombre(proveedor.getNombre());
        if (existingProveedor.isPresent()) {
            throw new RuntimeException("Proveedor con el nombre ya existe");
        }
        return proveedorRepository.save(proveedor);
    }

    public void deleteProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
