package projeto_cine_track;

import java.util.ArrayList;
import java.util.Scanner;

public class CineTrack {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Conteudo> catalogo = new ArrayList<>();
    private static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private static int proximoIdConteudo = 1;
    private static int proximoIdUsuario = 1;
    private static Usuario usuarioAtual;

    public static void main(String[] args) {
        carregarExemplos();
        System.out.println("==================================");
        System.out.println("       BEM-VINDO AO CINETRACK");
        System.out.println(" Organize seus filmes e suas séries");
        System.out.println("==================================");

        menuPrincipal();
        scanner.close();
    }

    private static void carregarExemplos() {
        catalogo.add(new Filme(proximoIdConteudo++, "A Viagem de Chihiro",
                "Uma garota entra em um mundo mágico.", 2001, "Fantasia", 125, "Hayao Miyazaki"));
        catalogo.add(new Serie(proximoIdConteudo++, "Stranger Things",
                "Um grupo de amigos enfrenta acontecimentos misteriosos.", 2016,
                "Ficção científica", 4, 34));
    }

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Criar usuário");
            System.out.println("2 - Selecionar usuário");
            System.out.println("3 - Cadastrar filme");
            System.out.println("4 - Cadastrar série");
            System.out.println("5 - Listar catálogo");
            System.out.println("6 - Buscar conteúdo");
            System.out.println("7 - Atualizar conteúdo");
            System.out.println("8 - Excluir conteúdo");
            System.out.println("9 - Criar lista para usuário atual");
            System.out.println("10 - Adicionar conteúdo à lista");
            System.out.println("11 - Ver listas do usuário atual");
            System.out.println("12 - Avaliar conteúdo");
            System.out.println("13 - Ver avaliações do usuário atual");
            System.out.println("14 - Ver perfil do usuário atual");
            System.out.println("0 - Sair");
            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1: criarUsuario(); break;
                case 2: selecionarUsuario(); break;
                case 3: cadastrarFilme(); break;
                case 4: cadastrarSerie(); break;
                case 5: listarCatalogo(); break;
                case 6: buscarConteudo(); break;
                case 7: atualizarConteudo(); break;
                case 8: excluirConteudo(); break;
                case 9: criarLista(); break;
                case 10: adicionarConteudoLista(); break;
                case 11: verListas(); break;
                case 12: avaliarConteudo(); break;
                case 13: verAvaliacoes(); break;
                case 14: verPerfil(); break;
                case 0: System.out.println("Obrigada por usar o CineTrack. Até mais!"); break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void criarUsuario() {
        System.out.println("\n--- CADASTRAR USUÁRIO ---");
        String nome = lerTexto("Nome: ");
        String email = lerTexto("E-mail: ");
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Já existe um usuário com esse e-mail.");
                return;
            }
        }
        usuarioAtual = new Usuario(proximoIdUsuario++, nome, email);
        usuarios.add(usuarioAtual);
        System.out.println("Usuário cadastrado e selecionado com sucesso!");
    }

    private static void selecionarUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " - " + u.getNome() + " (" + u.getEmail() + ")");
        }
        int id = lerInt("Digite o ID do usuário: ");
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                usuarioAtual = u;
                System.out.println("Usuário atual: " + u.getNome());
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    private static void cadastrarFilme() {
        System.out.println("\n--- CADASTRAR FILME ---");
        String titulo = lerTexto("Título: ");
        String sinopse = lerTexto("Sinopse: ");
        int ano = lerInt("Ano de lançamento: ");
        String genero = lerTexto("Gênero: ");
        int duracao = lerInt("Duração em minutos: ");
        String diretor = lerTexto("Diretor: ");
        catalogo.add(new Filme(proximoIdConteudo++, titulo, sinopse, ano, genero, duracao, diretor));
        System.out.println("Filme cadastrado com sucesso!");
    }

    private static void cadastrarSerie() {
        System.out.println("\n--- CADASTRAR SÉRIE ---");
        String titulo = lerTexto("Título: ");
        String sinopse = lerTexto("Sinopse: ");
        int ano = lerInt("Ano de lançamento: ");
        String genero = lerTexto("Gênero: ");
        int temporadas = lerInt("Quantidade de temporadas: ");
        int episodios = lerInt("Quantidade total de episódios: ");
        catalogo.add(new Serie(proximoIdConteudo++, titulo, sinopse, ano, genero, temporadas, episodios));
        System.out.println("Série cadastrada com sucesso!");
    }

    private static void listarCatalogo() {
        System.out.println("\n--- CATÁLOGO CINETRACK ---");
        if (catalogo.isEmpty()) {
            System.out.println("Nenhum conteúdo cadastrado.");
            return;
        }
        for (Conteudo c : catalogo) {
            System.out.println(c);
        }
    }

    private static Conteudo encontrarConteudo(int id) {
        for (Conteudo c : catalogo) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    private static void buscarConteudo() {
        String termo = lerTexto("Digite o título ou parte dele: ").toLowerCase();
        boolean encontrado = false;
        for (Conteudo c : catalogo) {
            if (c.getTitulo().toLowerCase().contains(termo)) {
                c.exibirDetalhes();
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("Nenhum conteúdo encontrado.");
    }

    private static void atualizarConteudo() {
        listarCatalogo();
        int id = lerInt("ID do conteúdo que deseja atualizar: ");
        Conteudo c = encontrarConteudo(id);
        if (c == null) {
            System.out.println("Conteúdo não encontrado.");
            return;
        }

        System.out.println("Deixe o campo vazio para manter o valor atual.");
        String titulo = lerTexto("Novo título [" + c.getTitulo() + "]: ");
        if (!titulo.isEmpty()) c.setTitulo(titulo);
        String sinopse = lerTexto("Nova sinopse [" + c.getSinopse() + "]: ");
        if (!sinopse.isEmpty()) c.setSinopse(sinopse);
        String anoTexto = lerTexto("Novo ano [" + c.getAno() + "]: ");
        if (!anoTexto.isEmpty()) {
            try { c.setAno(Integer.parseInt(anoTexto)); }
            catch (NumberFormatException e) { System.out.println("Ano inválido; valor mantido."); }
        }
        String genero = lerTexto("Novo gênero [" + c.getGenero() + "]: ");
        if (!genero.isEmpty()) c.setGenero(genero);

        if (c instanceof Filme) {
            Filme f = (Filme) c;
            String duracao = lerTexto("Nova duração em minutos [" + f.getDuracaoMinutos() + "]: ");
            if (!duracao.isEmpty()) {
                try { f.setDuracaoMinutos(Integer.parseInt(duracao)); }
                catch (NumberFormatException e) { System.out.println("Duração inválida; valor mantido."); }
            }
            String diretor = lerTexto("Novo diretor [" + f.getDiretor() + "]: ");
            if (!diretor.isEmpty()) f.setDiretor(diretor);
        } else if (c instanceof Serie) {
            Serie s = (Serie) c;
            String temporadas = lerTexto("Novas temporadas [" + s.getTemporadas() + "]: ");
            if (!temporadas.isEmpty()) {
                try { s.setTemporadas(Integer.parseInt(temporadas)); }
                catch (NumberFormatException e) { System.out.println("Valor inválido; temporadas mantidas."); }
            }
            String episodios = lerTexto("Novos episódios [" + s.getEpisodios() + "]: ");
            if (!episodios.isEmpty()) {
                try { s.setEpisodios(Integer.parseInt(episodios)); }
                catch (NumberFormatException e) { System.out.println("Valor inválido; episódios mantidos."); }
            }
        }
        System.out.println("Conteúdo atualizado com sucesso!");
    }

    private static void excluirConteudo() {
        listarCatalogo();
        int id = lerInt("ID do conteúdo que deseja excluir: ");
        Conteudo c = encontrarConteudo(id);
        if (c == null) {
            System.out.println("Conteúdo não encontrado.");
            return;
        }
        catalogo.remove(c);
        for (Usuario u : usuarios) {
            for (Lista l : u.getListas()) l.removerConteudo(id);
        }
        System.out.println("Conteúdo excluído do catálogo e das listas.");
    }

    private static void criarLista() {
        if (!verificarUsuario()) return;
        String nome = lerTexto("Nome da nova lista (ex.: Quero assistir): ");
        usuarioAtual.adicionarLista(new Lista(nome));
        System.out.println("Lista criada com sucesso!");
    }

    private static void adicionarConteudoLista() {
        if (!verificarUsuario()) return;
        if (usuarioAtual.getListas().isEmpty()) {
            System.out.println("Crie uma lista primeiro.");
            return;
        }
        for (int i = 0; i < usuarioAtual.getListas().size(); i++) {
            System.out.println((i + 1) + " - " + usuarioAtual.getListas().get(i).getNome());
        }
        int indice = lerInt("Escolha o número da lista: ") - 1;
        if (indice < 0 || indice >= usuarioAtual.getListas().size()) {
            System.out.println("Lista inválida.");
            return;
        }
        listarCatalogo();
        int id = lerInt("ID do conteúdo que deseja adicionar: ");
        Conteudo c = encontrarConteudo(id);
        if (c == null) {
            System.out.println("Conteúdo não encontrado.");
            return;
        }
        boolean adicionado = usuarioAtual.getListas().get(indice).adicionarConteudo(c);
        System.out.println(adicionado ? "Conteúdo adicionado à lista!" : "Esse conteúdo já está na lista.");
    }

    private static void verListas() {
        if (!verificarUsuario()) return;
        if (usuarioAtual.getListas().isEmpty()) {
            System.out.println("Você ainda não criou listas.");
            return;
        }
        for (Lista l : usuarioAtual.getListas()) l.listarConteudos();
    }

    private static void avaliarConteudo() {
        if (!verificarUsuario()) return;
        listarCatalogo();
        int id = lerInt("ID do conteúdo que deseja avaliar: ");
        Conteudo c = encontrarConteudo(id);
        if (c == null) {
            System.out.println("Conteúdo não encontrado.");
            return;
        }
        int nota = lerInt("Nota de 0 a 10: ");
        if (nota < 0 || nota > 10) {
            System.out.println("Nota inválida. A avaliação deve ser de 0 a 10.");
            return;
        }
        String comentario = lerTexto("Comentário: ");
        usuarioAtual.adicionarAvaliacao(new Avaliacao(c, nota, comentario));
        System.out.println("Avaliação registrada com sucesso!");
    }

    private static void verAvaliacoes() {
        if (!verificarUsuario()) return;
        if (usuarioAtual.getAvaliacoes().isEmpty()) {
            System.out.println("Você ainda não fez avaliações.");
            return;
        }
        for (Avaliacao a : usuarioAtual.getAvaliacoes()) a.exibirAvaliacao();
    }

    private static void verPerfil() {
        if (!verificarUsuario()) return;
        usuarioAtual.exibirPerfil();
    }

    private static boolean verificarUsuario() {
        if (usuarioAtual == null) {
            System.out.println("Primeiro, crie ou selecione um usuário no menu principal.");
            return false;
        }
        return true;
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    private static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }
}
