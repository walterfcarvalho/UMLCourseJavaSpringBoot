package com.walterfcarvalho.cursoumc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Column(length = 40)
    private String nome;

    @OneToMany(mappedBy = "cat_pai")
    private Set<Categoria> cat_filhas = new HashSet<>();

    @ManyToOne()
    @JoinColumn(name="categoria_pai")  
    @JsonBackReference
    private Categoria cat_pai;

    // @JsonManagedReference // retorna os produtos da categoria
    @ManyToMany(mappedBy = "categorias")   // nome do campo
    private List<Produto> produtos = new ArrayList<Produto>();

    public Categoria() {

    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

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
    
    public Set<Categoria> getCat_filhas() {
        return cat_filhas;
    }

    public void setCat_filhas(Set<Categoria> cat_filhas) {
        this.cat_filhas = cat_filhas;
    }

    public Categoria getCat_pai() {
        return cat_pai;
    }

    public void setCat_pai(Categoria cat_pai) {
        this.cat_pai = cat_pai;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } 
        return true;
    }

}
