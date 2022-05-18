package pos_java_jdbc.pos_java_jdbc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJDBC {

	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("dddddd");
		userposjava.setEmail("DDDDDD");

		userPosDao.salvar(userposjava);

	}

	// Metodo para trazer uma lista de objetos
	@Test
	public void initListar() {
		UserPosDao dao = new UserPosDao();
		try {
			List<Userposjava> list = dao.listar();// traz a lista

			for (Userposjava userposjava : list) {// vai fazer varredura nos objetos
				System.out.println(userposjava);
				System.out.println("---------------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Metodo para buscar apenas um objeto
	@Test
	public void initBuscar() {

		UserPosDao dao = new UserPosDao();

		try {
			Userposjava userposjava = dao.buscar(4l);
			System.out.println(userposjava);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {

		UserPosDao dao = new UserPosDao();

		try {
			Userposjava objetoBanco = dao.buscar(3l);
			
			objetoBanco.setNome("Nome mudado com metodo atualizar");
			dao.atualizar(objetoBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void initDeletar() {
		try {
			UserPosDao dao = new UserPosDao();
			dao.deletar(7L);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(11) 44444-4444");
		telefone.setTipo("Casa");
		telefone.setUsuario(3L);
		
		UserPosDao dao = new UserPosDao();
		dao.salvarTelefone(telefone);
				
	}
	
	@Test
	public void testeCarregarFoneUser() {
		
		UserPosDao dao = new UserPosDao();
		
		List<BeanUserFone> beanUserFones = dao.listaBeanUserFones(2L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			
			System.out.println(beanUserFone);
			System.out.println("-------------------------------");

			
		}
		
	}
	
	@Test
	public void testeDeleteUserFone() {
		
		UserPosDao dao = new UserPosDao();
		dao.deleteFoneUser(2L);
		
	}

}
