package my.inno.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Mst_Claim")
public class Claim {
	@Id
	@Column(name = "ClaimID")
	/*@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequenceName", value = "sequence"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"), })
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(name = "ClaimNo")
	String claimNumber;

	@Column(name = "DateOfLoss")
	Date dateOfLoss;
	
	@Column(name = "CoverageType")
	String coverageType;

	@Column(name = "ClaimStatus")
	String claimStatus;
	
	public Claim() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public Date getDateOfLoss() {
		return dateOfLoss;
	}

	public void setDateOfLoss(Date dateOfLoss) {
		this.dateOfLoss = dateOfLoss;
	}

	public String getCoverageType() {
		return coverageType;
	}

	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	

}
