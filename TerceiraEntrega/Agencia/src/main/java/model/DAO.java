package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de Conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/agencia?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";

	// Método de Conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD Create
	public void inserirCliente(JavaBeans cliente) {
		String create = "insert into cliente(nome,cpf,email) values (?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// preparar a query
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parâmetros pelo conteúdo
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getCpf());
			pst.setString(3, cliente.getEmail());
			// Executar a query
			pst.executeUpdate();
			// encerrar conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD Read
	public ArrayList<JavaBeans> listarClientes() {
		// Criando objeto
		ArrayList<JavaBeans> clientes = new ArrayList<>();
		String read = "select * from cliente order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// Laço
			while (rs.next()) {
				// Variáveis de apoio
				String idclie = rs.getString(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String email = rs.getString(4);
				// ArrayList
				clientes.add(new JavaBeans(idclie, nome, cpf, email));
			}
			con.close();
			return clientes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD UPDATE
	// SELECIONAR CLIENTE
	public void selecionarCliente(JavaBeans cliente) {
		String read2 = "select * from cliente where idcli = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, cliente.getIdcli());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Setar variáveis
				cliente.setIdcli(rs.getString(1));
				cliente.setNome(rs.getString(2));
				cliente.setCpf(rs.getString(3));
				cliente.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// editar cliente
	public void alterarCliente(JavaBeans cliente) {
		String create = "update cliente set nome=?, cpf=?, email=? where idcli=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getCpf());
			pst.setString(3, cliente.getEmail());
			pst.setString(4, cliente.getIdcli());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//CRUD Delete
	public void deletarCliente(JavaBeans cliente) {
		String delete = "delete from cliente where idcli=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, cliente.getIdcli());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
