package org.softleader.user;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserDto implements Serializable {

	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private Integer role;

	public UserDto() {}

	public UserDto(Long id, String firstName, String lastName, String userName, Integer role) {
		this();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
