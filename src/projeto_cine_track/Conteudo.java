package projeto_cine_track;

public abstract class Conteudo {
    private int id;
    private String titulo;
    private String sinopse;
    private int ano;
    private String genero;

    public Conteudo(int id, String titulo, String sinopse, int ano, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.ano = ano;
        this.genero = genero;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getSinopse() { return sinopse; }
    public void setSinopse(String sinopse) { this.sinopse = sinopse; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public abstract String getTipo();
    public abstract void exibirDetalhes();

    @Override
    public String toString() {
        return "[" + id + "] " + titulo + " (" + ano + ") - " + getTipo()
                + " | Gênero: " + genero;
    }
}
