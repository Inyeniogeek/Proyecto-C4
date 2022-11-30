package com.ciclo_4.api.Services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo_4.api.Models.ClienteModels;
import com.ciclo_4.api.Repository.ClienteRepository;

@Service
public class ClienteServices {
    @Autowired
    ClienteRepository clienteRepository;


    public String guardarCliente(ClienteModels cliente){
        cliente.setNombre(cliente.getNombre().toLowerCase()); //convertir a minúscula
        cliente.setApellido(cliente.getApellido().toLowerCase());

        if(cliente.getId() == null || !clienteRepository.existsById(cliente.getId())){
            clienteRepository.save(cliente);
            return "Se guardó el Cliente";
        }else{
            clienteRepository.save(cliente);
            return "Se actualizó el Cliente";
        }

    }
    public List<ClienteModels> getListClienteOrden(){
        List<ClienteModels> listaClientes =clienteRepository.findAll();
        listaClientes.sort(Comparator.comparing(ClienteModels::getNombre));//ordenar el listado cliente alfabéticamente
        return listaClientes;

    }
    public Optional <ClienteModels> getClienteById(String id){ //buscar por id
        return clienteRepository.findById(id);
    }

    public String eliminarPacientePorId(String id){
        if(clienteRepository.existsById(id)){
            Optional<ClienteModels> cliente = clienteRepository.findById(id);
            clienteRepository.deleteById(id);
            return "El cliente "+ cliente.get().getNombre()+ " " +cliente.get().getApellido()+ " eliminado correctamente";
        }else{
            return "Cliente no existe o fue eliminado";
        }

    }

}
