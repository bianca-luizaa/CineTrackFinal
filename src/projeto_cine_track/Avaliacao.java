package projeto_cine_track;

public class Avaliacao {
    private int nota;
    private String comentario;
    private Conteudo conteudo;

    public Avaliacao(Conteudo conteudo, int nota, String comentario) {
        this.conteudo = conteudo;
        setNota(nota);
        this.comentario = comentario;
    }

    public int getNota() { return nota; }
    public void setNota(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.nota = nota;
    }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public Conteudo getConteudo() { return conteudo; }

    public void exibirAvaliacao() {
        System.out.println(conteudo.getTitulo() + " — Nota: " + nota + "/10");
        System.out.println("Comentário: " + comentario);
    }
}