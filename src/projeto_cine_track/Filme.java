package projeto_cine_track;

public class Filme extends Conteudo {
    private int duracaoMinutos;
    private String diretor;

    public Filme(int id, String titulo, String sinopse, int ano, String genero,
                 int duracaoMinutos, String diretor) {
        super(id, titulo, sinopse, ano, genero);
        this.duracaoMinutos = duracaoMinutos;
        this.diretor = diretor;
    }

    public int getDuracaoMinutos() { return duracaoMinutos; }
    public void setDuracaoMinutos(int duracaoMinutos) { this.duracaoMinutos = duracaoMinutos; }
    public String getDiretor() { return diretor; }
    public void setDiretor(String diretor) { this.diretor = diretor; }

    @Override
    public String getTipo() { return "Filme"; }

    @Override
    public void exibirDetalhes() {
        System.out.println("\n--- FILME ---");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Sinopse: " + getSinopse());
        System.out.println("Ano: " + getAno());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Duração: " + duracaoMinutos + " minutos");
        System.out.println("Diretor: " + diretor);
    }
}
