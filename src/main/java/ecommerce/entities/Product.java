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

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Product {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(name="product_seq", sequenceName="product_seq", allocationSize = 1)
	@Column(name = "product_id")
	private long productId;
	
	private String name;
	private String manufacturer;
	private float price;

	private String description;
	private String category;
	
	private Integer quantity;
	
	
	@ManyToOne (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
//	@JoinColumn(name = "cart_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Cart cart; 
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Column(name = "image_url")
	private String imageUrl;
	
	//@JsonIgnore
	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}

   @Transient
	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public float getPrice() {
		return price ;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	



	public Product(String name, String manufacturer, String category, float price,
			String description, Cart cart, String imageUrl, Integer quantity) {
		this.category = category;
		this.name = name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.description = description;
		this.cart = cart;
		this.imageUrl = imageUrl;
		this.quantity=quantity;
		
	}


	public Integer getQuantity() {
		return this.quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Product() {
		
	}
    
	public boolean checkRangePrice(float minPrice, float maxPrice) {
		return minPrice < this.price && this.price <maxPrice;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + productId + ", name=" + name + ", manufacturer=" + manufacturer + ", price="
				+ price + ", description=" + description + ", imageUrl=" + imageUrl + ", cart=" + cart + "]";
	}

	
}
