package com.customer;

import java.util.Date;

import com.address.Address;

public class Customer {
private long id;
@Override
public String toString() {
	return id + "," + name + "," + gender + "," + email + ","
			+ contactNumber + "," + createdOn + "," + address ;
}
private String name;
private char gender;
private String email;
private String contactNumber;
private Date createdOn;
private Address address;
public Customer() {
	super();
}
public Customer(long id, String name, char gender, String email, String contactNumber, Date createdOn,
		Address address) {
	super();
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.email = email;
	this.contactNumber = contactNumber;
	this.createdOn = createdOn;
	this.address = address;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public char getGender() {
	return gender;
}
public void setGender(char gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public Date getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}

}
