package model;

public class JavaBeans {
	private String idcli;
	private String nome;
	private String cpf;
	private String email;
	
	public JavaBeans() {
		super();

	}
	
	public JavaBeans(String idcli, String nome, String cpf, String email) {
		super();
		this.idcli = idcli;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public String getIdcli() {
		return idcli;
	}
	public void setIdcli(String idcli) {
		this.idcli = idcli;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
