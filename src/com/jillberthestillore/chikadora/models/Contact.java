package com.jillberthestillore.chikadora.models;

import android.content.ContentValues;
import android.database.Cursor;

public class Contact extends Model {

	private static final String [] fields = {
		"username",
		"password",
		"firstname",
		"lastname",
		"status"
	};
	
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String status;
	
	public Contact(int id, String username, String password, String firstname, String lastname, String status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.status = status;
	}

	public Contact() {
		
	}
	
	@Override
	public ContentValues getContentValues() {
		ContentValues values = new ContentValues();
		values.put("username", username);
		values.put("password", password);
		values.put("firstname", firstname);
		values.put("lastname", lastname);
		values.put("status", status);
		return values;
	}
	@Override
	public void setCursor(Cursor cursor) {
		id = Integer.parseInt(cursor.getString(0));
		username = cursor.getString(1);
		password = cursor.getString(2);
		firstname = cursor.getString(3);
		lastname = cursor.getString(4);
		status = cursor.getString(5);
	}
	@Override
	public String[] getFields() {
		return fields;
	}
	@Override
	public String getTable() {
		return "contacts";
	}
	@Override
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
