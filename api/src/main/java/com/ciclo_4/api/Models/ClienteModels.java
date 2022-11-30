package com.ciclo_4.api.Models;


import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("clientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteModels {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Long documento;
    private LocalDate fechaNacimiento;
    private Long celular;
    private Object direccion; // ejemplo: direccion: [Ciudad:"Pasto",departamento: "Nariño"] => diccionarios
                              // dentro de diccionarios

}
