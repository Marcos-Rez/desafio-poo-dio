package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosConcluido = new LinkedHashSet<>();
    private Set<Conteudo> ConteudosInscritos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.ConteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.ConteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()){
            this.conteudosConcluido.add(conteudo.get());
            this.ConteudosInscritos.remove(conteudo.get());
        }else {
            System.err.println("Voceê não esta matriculado em nenhum conteudo.");
        }
    };
/*
* Utilizando o stream - pegando cada conteudo dos set conteudo
* concluidos - pegando o xp de cada conteudo e somando*/
    public Double calcularTotalXp(){
        return this.conteudosConcluido
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluido;
    }

    public void setConteudosConcluido(Set<Conteudo> conteudosConcluido) {
        this.conteudosConcluido = conteudosConcluido;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return ConteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        ConteudosInscritos = conteudosInscritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosConcluido, dev.conteudosConcluido) && Objects.equals(ConteudosInscritos, dev.ConteudosInscritos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosConcluido, ConteudosInscritos);
    }
}
