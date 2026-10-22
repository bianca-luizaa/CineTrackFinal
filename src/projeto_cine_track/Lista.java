package projeto_cine_track;

import java.util.ArrayList;

public class Lista {
    private String nome;
    private ArrayList<Conteudo> conteudos;

    public Lista(String nome) {
        this.nome = nome;
        this.conteudos = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public boolean adicionarConteudo(Conteudo conteudo) {
        if (conteudo == null || contemId(conteudo.getId())) return false;
        conteudos.add(conteudo);
        return true;
    }

    public boolean removerConteudo(int id) {
        return conteudos.removeIf(c -> c.getId() == id);
    }

    public boolean contemId(int id) {
        for (Conteudo c : conteudos) {
            if (c.getId() == id) return true;
        }
        return false;
    }

    public void listarConteudos() {
        System.out.println("\nLista: " + nome);
        if (conteudos.isEmpty()) {
            System.out.println("A lista está vazia.");
            return;
        }
        for (Conteudo c : conteudos) System.out.println(c);
    }
}
