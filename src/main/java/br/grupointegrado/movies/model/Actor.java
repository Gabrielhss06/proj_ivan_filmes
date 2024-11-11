package br.grupointegrado.movies.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer id;

    @Column(name = "name")
    private  String nome;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
