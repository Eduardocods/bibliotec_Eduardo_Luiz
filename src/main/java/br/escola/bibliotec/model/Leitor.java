package br.escola.bibliotec.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "leitor")
public class Leitor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @Column(nullable = false, unique = true, length = 20)
    @NotBlank(message = "A matrícula é obrigatória")
    @Size(max = 20, message = "A matrícula deve ter no máximo 20 caracteres")
    private String matricula;

    @Column(length = 100)
    @Email(message = "Informe um e-mail válido")
    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    @NotNull(message = "Escolha o tipo do leitor")
    private TipoLeitor tipo;

    public @Email(message = "Informe um e-mail válido") @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres")

    String getEmail() {return email;}

    public Long getId() {return id;}

    public @NotBlank(message = "A matrícula é obrigatória") @Size(max = 20, message = "A matrícula deve ter no máximo 20 caracteres") String getMatricula() {return matricula;}

    public @NotBlank(message = "O nome é obrigatório") @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres") String getNome() {return nome;}

    public @NotNull(message = "Escolha o tipo do leitor") TipoLeitor getTipo() {return tipo;}

    public void setEmail(@Email(message = "Informe um e-mail válido") @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres") String email) {this.email = email;}

    public void setId(Long id) {this.id = id;}

    public void setMatricula(@NotBlank(message = "A matrícula é obrigatória") @Size(max = 20, message = "A matrícula deve ter no máximo 20 caracteres") String matricula) {this.matricula = matricula;}

    public void setNome(@NotBlank(message = "O nome é obrigatório") @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres") String nome) {this.nome = nome;}

    public void setTipo(@NotNull(message = "Escolha o tipo do leitor") TipoLeitor tipo) {this.tipo = tipo;}
}

