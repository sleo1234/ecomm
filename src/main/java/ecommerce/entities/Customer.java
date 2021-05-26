package ecommerce.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Customer {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	@SequenceGenerator(name="customer_seq", sequenceName="customer_seq", allocationSize = 1)
	private long customer_id;
	private String role;
	
	@Column(name = "first_name")
	private String firstName;
	
	private String last_name;
	private String email;
	private String password;
	private String adress;
	private boolean enabled = true;
	
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name ="phone_number", nullable = true)
	private String phoneNumber;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST})

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Cart cart ;
	
	
	public Customer() {
		
	}

	public Customer(String firstName, String last_name, boolean enabled, String email, String password, String adress,
			String phoneNumber, String role, Cart cart) {
	    this.enabled = enabled;
		this.firstName = firstName;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
	    this.cart = cart;
		this.role = role;
		
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", role=" + role + ", first_name=" + firstName + ", last_name="
				+ last_name + ", email=" + email + ", password=" + password + ", adress=" + adress + ", phoneNumber="
				+ phoneNumber + ", cart=" + cart + "]";
	}

	
	
}
