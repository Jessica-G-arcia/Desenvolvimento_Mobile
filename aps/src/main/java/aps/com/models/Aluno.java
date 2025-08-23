package aps.com.models;

public class Aluno extends Pessoa {
    
    private String ra;
    private String curso;

    public Aluno(String nome, String ra, String curso) {
        super(nome); // Chama o construtor da classe mãe (Pessoa)
        this.ra = ra;
        this.curso = curso;
    }
    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    @Override
    public String toString() {
        return "Aluno{" +
               "nome='" + getNome() + '\'' +
               ", RA='" + ra + '\'' +
               ", curso='" + curso + '\'' +
               '}';
    }
}