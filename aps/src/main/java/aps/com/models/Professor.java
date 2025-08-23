package aps.com.models;

public class Professor extends Pessoa {
    
    private String curso;

    public Professor(String nome, String id, String curso) {
        super(nome, id); // Chama o construtor da classe mãe (Pessoa)
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Professor{" +
               "nome='" + getNome() + '\'' +
               ", id='" + getId() + '\'' +
               ", curso='" + curso + '\'' +
               '}';
    }
}