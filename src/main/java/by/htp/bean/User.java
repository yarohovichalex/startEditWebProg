package by.htp.bean;

public class User {
	private String login;
	private String password;
	private String role;
	private int editId;
	

	public User() {
		super();
		//this.role = "unknown";
	}
	
	public User(String login, String password, String role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getEditId() {
		return editId;
	}

	public void setEditId(int editId) {
		this.editId = editId;
	}
	
	
}
