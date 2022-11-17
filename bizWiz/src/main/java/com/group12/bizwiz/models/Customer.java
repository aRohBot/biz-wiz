package com.group12.bizwiz.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="customers")
public class Customer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Customer Name is required!")
    @Size(min=3, max=15, message="Customer name must be between 3 and 15 characters")
    private String customerName;
    
    @NotEmpty(message="Contact Name is required!")
    @Size(min=3, max=15, message="Contact name must be between 3 and 15 characters")
    private String contactName;
    
    @NotEmpty(message="Phone Number is required!")
    @Size(min=10, max=15, message="Phone number must be between 10 and 15 numbers")
    private String phoneNumber;
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Address is required")
    private String address;
    
    @NotEmpty(message="City is required")
    private String city;
    
    @NotEmpty(message="State is required")
    private String state;
    
    @NotEmpty(message="Zip Code is required")
    @Size(min=5, max=5, message="Zip code must be 5 numbers long")
    private String zip;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @OneToMany(mappedBy="customer", fetch=FetchType.LAZY)
    private List<Invoice> invoices;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    //CONSTRUCTORS
    
    public Customer() {}
	public Customer(
			@NotEmpty(message = "Customer Name is required!") @Size(min = 3, max = 15, message = "Customer name must be between 3 and 15 characters") String customerName,
			@NotEmpty(message = "Contact Name is required!") @Size(min = 3, max = 15, message = "Contact name must be between 3 and 15 characters") String contactName,
			@NotEmpty(message = "Phone Number is required!") @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 numbers") String phoneNumber,
			@NotEmpty(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
			@NotEmpty(message = "Address is required") String address,
			@NotEmpty(message = "City is required") String city, @NotEmpty(message = "State is required") String state,
			@NotEmpty(message = "Zip Code is required") @Size(min = 5, max = 5, message = "Zip code must be 5 numbers long") String zip) {
		super();
		this.customerName = customerName;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
    
	
}
