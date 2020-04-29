package main.java.models.magazine;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import main.java.models.User;

@Entity
@Table(name = "role_m")
public class RoleM extends Model {
	
	private static final long serialVersionUID = 1L;

	private String title;
	
	/* one to many */
	@OneToMany
	(mappedBy = "role")
	private Set<User> users;
	
	public RoleM() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
