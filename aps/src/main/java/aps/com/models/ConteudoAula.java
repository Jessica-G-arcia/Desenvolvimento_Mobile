package aps.com.models;

public abstract class ConteudoAula {
    private String nome;

    public ConteudoAula(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método abstrato que DEVE ser implementado pelas classes filhas
    public abstract String getDescricaoCompleta();
}