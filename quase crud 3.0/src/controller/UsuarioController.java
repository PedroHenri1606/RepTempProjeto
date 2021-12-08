package controller;

import DAO.DaoUsuario;
import model.Usuario;

import java.util.List;

public class UsuarioController {
    DaoUsuario daoUsuario = new DaoUsuario();

    public void CriarTabelaUsuario() {daoUsuario.criarTabelaUsuario();}
    public void realizarCadastro(Usuario al) {daoUsuario.adicionar(al);}
    public boolean realizarLogin(String tmp1, String tmp2) {return daoUsuario.login(tmp1, tmp2);}
    public Usuario determinarUsuario(String email, String senha) {return daoUsuario.determinarUsuarioAtual(email, senha);}
    public void editarDados(Usuario usuario) {daoUsuario.editar(usuario);}
    public List<Usuario> visualizarUsuarios(Usuario usuario) {return daoUsuario.visualizarUsuariosProximos(usuario);}
}
