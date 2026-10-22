package projeto_cine_track;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private ArrayList<Lista> listas;
    private ArrayList<Avaliacao> avaliacoes;

    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.listas = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void adicionarLista(Lista lista) { listas.add(lista); }
    public ArrayList<Lista> getListas() { return listas; }
    public void adicionarAvaliacao(Avaliacao avaliacao) { avaliacoes.add(avaliacao); }
    public ArrayList<Avaliacao> getAvaliacoes() { return avaliacoes; }

    public void exibirPerfil() {
        System.out.println("\nUsuário: " + nome + " | E-mail: " + email);
        System.out.println("Listas criadas: " + listas.size());
        System.out.println("Avaliações feitas: " + avaliacoes.size());
    }
}
