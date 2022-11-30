package com.ciclo_4.api.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo_4.api.Models.ClienteModels;
import com.ciclo_4.api.Services.ClienteServices;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")

public class ClienteController {
    @Autowired
    ClienteServices clienteServices;

    @GetMapping()
    public List<ClienteModels> getAllClienteOrden() {
        return clienteServices.getListClienteOrden();
    }

    @GetMapping("/{id}")
    public Optional<ClienteModels> findClienteById(@PathVariable(value = "id") String id) {
        return clienteServices.getClienteById(id);
    }

    @PostMapping()
    public String saveCliente(@RequestBody ClienteModels cliente) {
        return clienteServices.guardarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public String deleteClienteById(@PathVariable("id") String id) {
        return clienteServices.eliminarPacientePorId(id);

    }

}
