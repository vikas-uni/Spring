package my.inno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mst_Claimant")
public class Claimant {

	@Id
	@Column(name = "ClaimantID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "ClaimID")
	int claimId;
	
	@Column(name = "Firstname")
	String firstName;
	
	@Column(name = "LastName")
	String lastName;
	
	@Column(name = "Street1")
	String street1;
	
	@Column(name = "Street2")
	String street2;
	
	@Column(name = "City")
	String City;
	
	@Column(name = "SOJ")
	String soj;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
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

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getSoj() {
		return soj;
	}

	public void setSoj(String soj) {
		this.soj = soj;
	}
	
	
}
