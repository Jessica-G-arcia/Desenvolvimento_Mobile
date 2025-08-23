package aps.com.models;

public class Curso extends ConteudoAula {
    private String codigo;
    private String duracao;

    public Curso(String nome, String codigo, String duracao) {
        super(nome); // Chama o construtor da classe mãe
        this.codigo = codigo;
        this.duracao = duracao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override // Polimorfismo: implementa o método abstrato
    public String getDescricaoCompleta() {
        return "O curso " + getNome() + " (código: " + codigo + ") tem duração de " + duracao + ".";
    }

    @Override // Polimorfismo: sobrescreve o toString da classe Object
    public String toString() {
        return "Curso{" +
               "nome='" + getNome() + '\'' +
               ", codigo='" + codigo + '\'' +
               ", duracao='" + duracao + '\'' +
               '}';
    }
}