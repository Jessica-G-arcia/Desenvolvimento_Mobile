package aps.com.models;

import java.util.ArrayList;

public class CursoComConteudo extends Curso {
    private ArrayList<ConteudoAula> conteudos = new ArrayList<>();

    public CursoComConteudo(String nome, String codigo, String duracao) {
        super(nome, codigo, duracao);
    }

    public void adicionarConteudo(ConteudoAula conteudo) {
        this.conteudos.add(conteudo);
    }

    public ArrayList<ConteudoAula> getConteudos() {
        return this.conteudos;
    }

    @Override
    public String getDescricaoCompleta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso: ").append(getNome())
          .append(" (Código: ").append(getCodigo())
          .append(", Duração: ").append(getDuracao()).append(")\n");
        
        if (conteudos.isEmpty()) {
            sb.append("  Não há conteúdo cadastrado para este curso.");
        } else {
            sb.append("  Conteúdo do Curso:\n");
            for (ConteudoAula conteudo : conteudos) {
                sb.append(conteudo.toString()).append("\n");
            }
        }
        
        return sb.toString();
    }
}
