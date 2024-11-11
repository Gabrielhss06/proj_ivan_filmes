package br.grupointegrado.movies.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class Movie {


    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    // adiciona a coluna e use o get e set;
    @Column
    private String comentario;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // adiciona a coluna e use o get e set;
    @Column
    private String nome;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // adiciona a coluna e use o get e set;
    @Column
    private String descricao; // String é testo depende do atributo que esta no banco

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    // adiciona a coluna e use o get e set;
    @Column
    private BigDecimal nota; // BigDecimal é numero depende do atributo que esta no banco
    // Atencao procurar na mais sobre as clases !!!!!

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}