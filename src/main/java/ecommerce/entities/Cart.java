package ecommerce.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "cart_seq")
	@SequenceGenerator(name="cart_seq", sequenceName="cart_seq", allocationSize = 1)
	@Column(name = "cart_id")
	private int cartId;
	
	 
	@OneToMany
	(mappedBy =  "cart", orphanRemoval = true, cascade = CascadeType.PERSIST)
	@JsonIgnore
	private List <Product> product;
	
	
   @OneToMany
   (mappedBy = "cart",cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonIgnore
	private List <Customer> customer;
	
	public Cart( List<Product> product, List<Customer> customer) {
	

	this.product = product;
	this.customer = customer;
}
	
	public Cart() {
		super();
	}

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + "]";
	}

	

	

	
	
}
