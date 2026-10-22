package projeto_cine_track;

public class Serie extends Conteudo {
    private int temporadas;
    private int episodios;

    public Serie(int id, String titulo, String sinopse, int ano, String genero,
                 int temporadas, int episodios) {
        super(id, titulo, sinopse, ano, genero);
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }
    public int getEpisodios() { return episodios; }
    public void setEpisodios(int episodios) { this.episodios = episodios; }

    @Override
    public String getTipo() { return "Série"; }

    @Override
    public void exibirDetalhes() {
        System.out.println("\n--- SÉRIE ---");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Sinopse: " + getSinopse());
        System.out.println("Ano: " + getAno());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Temporadas: " + temporadas);
        System.out.println("Episódios: " + episodios);
    }
}
