package main.java.models.magazine;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import main.java.models.Course;
import main.java.models.Role;
import main.java.models.Status;


@Entity
@Table(name = "usr_m")
public class UserM extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 50)
	private String name;	
	
	private int age;	
	
	/* many to one */
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	/* one to one */
	@OneToOne
	@PrimaryKeyJoinColumn
	private Status status;
	
	/* many to many */
	@ManyToMany
	@JoinTable(name = "user_course", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "course_id")})
	private Set<Course> courses;

	public UserM() {
		
	}

	public UserM(Long id) {
		super(id);
	}

	public UserM(String name) {
		this.name = name;
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
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
