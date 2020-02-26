package org.generation.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements Serializable {

	/**
	 * 
	 * */
	
	
	private static final long serialVersionUID = -4733192922294311126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native")
	private Long id;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String username;
	@Column
	private String password;
	
	/*Transient sirve para omitir el valor pero poder seguir utilizandolo dentro del programa.*/
	@Transient
	private String confirmPassword;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	/*La diferencia entre un Set y un List es que con el Set nos aseguramos que todos
	 * los objetos dentro sean únicos.*/
	private Set<Role> roles;

	public User(Long id) {
		this.id = id;
	}

	public User() {
		super();
	}
	
	
	
	
	
	

	
}
