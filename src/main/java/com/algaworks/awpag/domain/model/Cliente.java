package com.algaworks.awpag.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
// import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
// @Table(name = "cliente")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded=true)

public class Cliente {
    @Id
    // indetity -> forma nativa do sgbd(no caso auto increment.Para casos em que o banco é criado manualmente. AUTO é para quando for criando junto com a API)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    // Not blank do projeto validation (hibernate validation)=esse campo nao pode ser nulo,"" ou " "
    @NotBlank
    @Size(max=60)
    @Column(name="nome")
    private String nome;

    @NotBlank
    @Size(max=255)
    // validacao se a string esta no padrao comum de um email valido.
    @Email
    private String email;

    @NotBlank
    @Size(max=60)
    private String telefone;

}
