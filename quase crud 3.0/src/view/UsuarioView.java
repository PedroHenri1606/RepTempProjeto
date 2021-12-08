package view;


import controller.UsuarioController;
import model.Bairro;
import model.Curso;
import model.Faculdade;
import model.Usuario;
import model.Carro;


import java.util.List;
import java.util.Scanner;

public class UsuarioView {
    UsuarioController usuarioController = new UsuarioController();
    BairroView bairroView = new BairroView();
    CursoView cursoView = new CursoView();
    CorridaView corridaview = new CorridaView();
    FaculdadeView faculdadeView = new FaculdadeView();
    CarroView carroView = new CarroView();
    Scanner scan = new Scanner(System.in);

    public void menuInicio() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("==============================================");
            System.out.println("              Escolha uma opção             \n");
            System.out.println("        [1]- Realizar Login ");
            System.out.println("        [2]- Cadastrar novo Usuario");
            System.out.println("==============================================");
            System.out.print(" Opção: ");
            int escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 1 -> this.realizarlogin();
                case 2 -> this.cadastroUsuario();
            }
        }
    }


    public void cadastroUsuario() {
        this.espaco();
        Scanner scan = new Scanner(System.in);

        Usuario usuarioModel = new Usuario();
        System.out.println("==============================================");
        System.out.println("       Realizando Cadastro de usuario         ");
        System.out.println("==============================================");
        System.out.print(" Nome do usuario: "); usuarioModel.setNome(scan.nextLine());
        System.out.print(" Sobrenome: ");  usuarioModel.setSobrenome(scan.nextLine());
        System.out.print(" Digite o seu Email: "); usuarioModel.setEmail(scan.nextLine());
        System.out.print(" Senha do usuario: ");  usuarioModel.setSenha(scan.nextLine());
        usuarioModel.setBairro(this.escolhendoBairro());
        usuarioModel.setCurso(this.escolhendoCurso());
        usuarioModel.setDestino(this.escolhendoFaculdade());
        usuarioModel.setSexo(this.escolherSexo());
        usuarioModel.setEscolha(this.escolha());

        if (escolha() == 1) {
            usuarioModel.setCarro(carroView.cadastrarCarro());
            usuarioController.realizarCadastro(usuarioModel);
        } else {
            usuarioController.realizarCadastro(usuarioModel);
        }
    }

    public Faculdade escolhendoFaculdade() {
        while (true) {
            System.out.println("==============================================");
            faculdadeView.listarFaculdades();
            System.out.println("==============================================");
            System.out.println("              Escolha uma opção             \n");
            System.out.println("       [1] Cadastrar Faculdade");
            System.out.println("       [2] Selecionar Faculdade");
            System.out.println("==============================================");
            switch (Integer.parseInt(scan.nextLine())) {
                case 1 -> faculdadeView.cadastrar();
                case 2 ->{ return faculdadeView.selecionarFaculdade();}
            }
        }
    }
/*
    public Carro escolhendoCarro(){
        while (true) {
            System.out.println("==============================================");
            carroView.visualizar();
            System.out.println("==============================================");
            System.out.println("            Escolha uma opção  \n");
            System.out.println("       [1] - Cadastrar novo Carro");
            System.out.println("       [2] - Escolher um Carro");
            System.out.println("==============================================");
            System.out.print  ("Opção: "); int escolha = Integer.parseInt(scan.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> carroView.cadastrarCarro();
                case 2 -> {return this.escolherCarro();}
            }
        }
    }

    public Carro escolherCarro() {
        long idcarro;
        List<Carro> carros = carroView.visualizar();
        System.out.println("==============================================");
        System.out.print  ("Informe carro escolhido: "); idcarro = Long.parseLong(scan.nextLine());

        for (int i = 0; i< carros.size(); i++) {
            if (carros.get(i).getId() == idcarro) {
                return carros.get(i);
            }
        }
        return null;
    }

*/
    public Bairro escolhendoBairro() {

        while (true) {
            System.out.println("==============================================");
            bairroView.visualizar();
            System.out.println("==============================================");
            System.out.println("            Escolha uma opção  \n");
            System.out.println("       [1] - Cadastrar novo bairro");
            System.out.println("       [2] - Escolher um Bairro");
            System.out.println("==============================================");
            System.out.print  ("Opção: "); int escolha = Integer.parseInt(scan.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> bairroView.cadastrarBairro();
                case 2 -> {return this.escolherBairro();}
            }
        }
    }

    public Bairro escolherBairro() {
        long idBairro;
        List<Bairro> bairros = bairroView.visualizar();
        System.out.println("==============================================");
        System.out.print  ("Informe bairro escolhido: "); idBairro = Long.parseLong(scan.nextLine());

        for (int i = 0; i< bairros.size(); i++) {
            if (bairros.get(i).getId() == idBairro) {
                return bairros.get(i);
            }
        }
        return null;
    }


    public Curso escolhendoCurso() {
        while (true) {
            System.out.println("==============================================");
            cursoView.listar();
            System.out.println("==============================================");
            System.out.println("              Escolha uma opção             \n");
            System.out.println("       [1] - Cadastrar Curso");
            System.out.println("       [2] - Escolher Curso");
            System.out.println("==============================================");
            System.out.print  (" Opção: "); int escolha = Integer.parseInt(scan.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> cursoView.cadastrarCurso();
                case 2 -> {return this.escolherCurso();}
            }
        }
    }

    public Curso escolherCurso() {

        long idCurso;
        List<Curso> cursos = cursoView.listar();
        System.out.println("==============================================");
        System.out.print  ("Informe o Id: "); idCurso = Long.parseLong(scan.nextLine());

        for (int i = 0; i< cursos.size(); i++) {
            if (cursos.get(i).getId() == idCurso) {
                return cursos.get(i);
            }
        }
        return null;
    }

    public long escolha() {

        long resposta = 0;

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("==============================================");
            System.out.println("Informe se deseja ser Motorista ou Passageiro");
            System.out.println("==============================================");
            System.out.println("      [1] - Motorista   [2] - Passageiro ");
            System.out.println("==============================================");
            System.out.print  (" Infome Opção: "); int opcao = scan.nextInt();
            System.out.println("==============================================");
            switch (opcao) {
                case 1 -> resposta = 1;
                case 2 -> resposta = 2;
            }
            return resposta;
        }
    }

    public long escolherSexo(){
        long resposta = 0;

        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("==============================================");
            System.out.println("           Informe o seu sexo                 ");
            System.out.println("==============================================");
            System.out.println("      [1] - Homem   [2] - Mulher ");
            System.out.println("==============================================");
            System.out.print  (" Infome Opção: "); int opcao = scan.nextInt();
            System.out.println("==============================================");
            switch (opcao){
                case 1-> resposta = 1;
                case 2-> resposta = 2;
            }
            return resposta;
        }
    }

    public void realizarlogin() {

        Scanner scan = new Scanner(System.in);
        String tmp1, tmp2;
        System.out.println("============================================");
        System.out.println("            Realizando Login");
        System.out.print  (" Email: "); tmp1 = scan.nextLine();
        System.out.print  (" Senha: "); tmp2 = scan.nextLine();

        if (usuarioController.realizarLogin(tmp1, tmp2)) {
            Usuario usuarioAtual = usuarioController.determinarUsuario(tmp1, tmp2);
            if(usuarioAtual.getEscolha() == 1) {
                this.menuMotorista(usuarioAtual);
            } else{
                this.menuPassageiro(usuarioAtual);
            }
        } else {
            System.out.println("==============================================");
            System.out.println("       Usuario ou senha incorreta!!:(         ");
            System.out.println("==============================================");
        }

    }

    public void menuMotorista(Usuario userAtual) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("==============================================");
            System.out.println(" Bem Vindo: " + userAtual.getNome() + "\n");
            System.out.println(" [1] - Criar corridas ");
            System.out.println(" [2] - Historico de corridas");
            System.out.println(" [3] - Configuracoes");
            System.out.println(" [4] - Sair");
            System.out.println("==============================================");
            int escolha = Integer.parseInt(scan.nextLine());

            switch (escolha) {
                case 1 ->  this.menuCorrida(userAtual);
                case 2 ->  corridaview.visualizarMinhasCorrida(userAtual);
                case 3 ->  this.configuracoes(userAtual);
                case 4 ->  { return;}
            }
        }
    }

    public void menuCorrida2(Usuario userAtual){

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("==============================================");
            System.out.println(" [1] - Escolher Corrida");
            System.out.println(" [2] - Visualizar Usuarios próximos");
            System.out.println(" [3] - Voltar");
            System.out.println("==============================================");
            int escolha = Integer.parseInt(scan.nextLine());

            switch (escolha) {
                case 1:
                    corridaview.visualizarCorridasPendentes();
                    corridaview.escolherCorridaPassageiro(userAtual);
                    break;
                case 2:
                    this.visualizarUsuariosProximos(userAtual);
                    break;
                case 3:
                    return;
            }
        }
    }

    public void menuPassageiro(Usuario userAtual) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("==============================================");
            System.out.println(" Bem Vindo: " + userAtual.getNome() + "\n");
            System.out.println(" [1] - Ver Corridas ");
            System.out.println(" [2] - Historico de  corridas");
            System.out.println(" [3] - Configuracoes");
            System.out.println(" [4] - Sair");
            System.out.println("==============================================");
            int escolha = Integer.parseInt(scan.nextLine());

            switch (escolha) {
                case 1 ->  this.menuCorrida2(userAtual);
                case 2 ->  corridaview.visualizarMinhasCorrida(userAtual);
                case 3 ->  this.configuracoes(userAtual);
                case 4 ->  { return;}
            }
        }
    }

    public void menuCorrida(Usuario userAtual) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("==============================================");
            System.out.println(" [1] - Criar corrida");
            System.out.println(" [2] - Visualizar Usuarios próximos");
            System.out.println(" [3] - Historico de Corridas");
            System.out.println(" [4] - Voltar");
            System.out.println("==============================================");
            int escolha = Integer.parseInt(scan.nextLine());

            switch (escolha) {
                case 1 -> corridaview.cadastrarCorrida(userAtual);
                case 2 -> this.visualizarUsuariosProximos(userAtual);
                case 3 -> corridaview.escolherCorrida(userAtual);
                case 4 -> {return;}
            }
        }
    }


    public void visualizarUsuariosProximos(Usuario usuario) {
        List<Usuario> usuarios = usuarioController.visualizarUsuarios(usuario);
        System.out.println("==============================================");
        for (Usuario usuario1 : usuarios) {
            System.out.println("Nome: " + usuario1.getNome() + " | Email: " + usuario1.getEmail());
        }
    }

    public void configuracoes(Usuario usuarioAtual) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==============================================");
            System.out.println("            Modificar Dados");
            System.out.println("==============================================");
            System.out.println("     [1] nome de usuario");
            System.out.println("     [2] senha");
            System.out.println("     [3] sair");
            System.out.println("==============================================");
            System.out.print  (" Informe opção: "); int escolha = Integer.parseInt(scanner.nextLine());
            System.out.println("==============================================");
            switch (escolha) {
                case 1 -> { usuarioAtual = this.modificarnome(usuarioAtual); this.salvarAlteracoes(usuarioAtual);}
                case 2 -> { usuarioAtual = this.modificarSenha(usuarioAtual); this.salvarAlteracoes(usuarioAtual);}
                case 3 -> { return; }
            }
        }
    }

    public void salvarAlteracoes(Usuario usuario) {usuarioController.editarDados(usuario);}

    public Usuario modificarSenha(Usuario usuarioAtual) {
        if (validar(usuarioAtual)) {
            System.out.println("Digite uma nova Senha: "); usuarioAtual.setSenha(scan.nextLine());
            System.out.println("==============================================");
        }
        return usuarioAtual;
    }

    public Usuario modificarnome(Usuario usuarioAtual) {
        if (validar(usuarioAtual)) {
            System.out.println("Digite um novo Nome: "); usuarioAtual.setNome(scan.nextLine());
            System.out.println("==============================================");
        }
        return usuarioAtual;
    }

    public boolean validar(Usuario usuarioAtual) {

        System.out.print("Digite a Senha Atual: "); String senha = scan.nextLine();
        System.out.println("==============================================");

        if (usuarioAtual.getSenha().equals(senha)) {
            return usuarioAtual.getSenha().equals(senha);
        } else {
            System.out.println("     -Senha invalida - Tente Novamente-");
            System.out.println("==============================================");
            return usuarioAtual.getSenha().equals(senha);
        }
    }

    public void espaco() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }
}

