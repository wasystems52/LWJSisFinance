package br.com.javaparaweb.financeiro.usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAOHibernate implements UsuarioDAO {
	
	private Session session;
	public void setSession(Session session){
		
		this.session = session;
	}


	public void salvar(Usuario usuario) {
		
		this.session.save(usuario);
		

	}


	public void atualizar(Usuario usuario) {

		this.session.update(usuario);

	}


	public void excluir(Usuario usuario) {

		 this.session.delete(usuario);

	}


	public Usuario carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	public List<Usuario> lista() {
		// TODO Auto-generated method stub
		return this.session.createCriteria(Usuario.class).list();
	}


	public Usuario buscarPorLogin(String login) {

		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
		
		
		
	}


}
