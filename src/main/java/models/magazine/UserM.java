package main.java.models.magazine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import main.java.models.Role;

@Entity
@Table(name = "usr_m")
public class UserM extends Model {

	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String name;

	private int age;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public UserM() {

	}

	public UserM(Long id) {
		super(id);
	}

	public UserM(String name) {
		this.name = name;
	}

	public UserM(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
