package com.cg.trg.login.Loginpage;
import javax.persistence.Entity;
import javax.persistence.Id;



import org.hibernate.validator.constraints.Length;


@Entity
public class User {
	@Id
	public int user_id;
	
	@Length(max=20)
	public String user_name;

	@Length(max=20)
	public String password;

	@Length(max=20)
	public String email_id;

	@Length(max=20)
	public String first_name;

	@Length(max=20)
	public String last_name;

	@Length(max=15)
	public String contact_no;

	public User() {
		super();
	}

	public User(int user_id,String uname, String password, String email_id, String first_name, String last_name, String contact_no) {
		super();
		this.user_id = user_id;
		this.user_name=uname;
		this.password = password;
		this.email_id = email_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.contact_no = contact_no;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}





}
