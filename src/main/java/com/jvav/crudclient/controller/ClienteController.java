package com.jvav.crudclient.controller;

import com.jvav.crudclient.model.Cliente;
import com.jvav.crudclient.model.TipoCliente;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final Map<String, Cliente> clientes = new ConcurrentHashMap<>();

    @GetMapping
    public Collection<Cliente> listar() {
        return clientes.values();
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        clientes.put(cliente.id(), cliente);
        return cliente;
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable String id, @RequestBody Cliente cliente) {
        clientes.put(id, cliente);
        return cliente;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        clientes.remove(id);
    }
}
