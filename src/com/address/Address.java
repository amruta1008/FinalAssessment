package com.address;

public class Address {
private String street;
private String city;
private String state;
private String country;
private int zipcode;
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public Address() {
	super();
}
public Address(String street, String city, String state, String country, int zipcode) {
	super();
	this.street = street;
	this.city = city;
	this.state = state;
	this.country = country;
	this.zipcode = zipcode;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public int getZipcode() {
	return zipcode;
}
public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}
@Override
public String toString() {
	return  street + "," + city + "," + state + "," + country + ", "
			+ zipcode ;
}
}
