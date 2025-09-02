package aps.com.models;

// public abstract class ConteudoAula {
//     private String nome;

//     public ConteudoAula(String nome) {
//         this.nome = nome;
//     }

//     public String getNome() {
//         return nome;
//     }

//     public void setNome(String nome) {
//         this.nome = nome;
//     }

//     // Método abstrato que DEVE ser implementado pelas classes filhas
//     public abstract String getDescricaoCompleta();
// }


public class ConteudoAula {
    private String ementa;
    private String objetivo;

    public ConteudoAula(String ementa, String objetivo) {
        this.ementa = ementa;
        this.objetivo = objetivo;
    }

    // Getters
    public String getEmenta() {
        return ementa;
    }

    public String getObjetivo() {
        return objetivo;
    }

    @Override
    public String toString() {
        return "  Ementa: " + ementa + "\n" +
               "  Objetivo: " + objetivo;
    }
}