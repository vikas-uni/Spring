package my.inno.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mst_Bill")
public class Bill {

	@Id
	@Column(name = "BillID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "ProviderID")
	int providerId;
	
	@Column(name = "DateReceived")
	Date dateReceived;
	
	@Column(name = "InvoiceDate")
	Date invoiceDate;
	
	@Column(name = "TotalAmount")
	double totalAmt;
	
	@Column(name = "AmountAllowed")
	double amtAllowed;
	
	@Column(name = "BillStatus")
	String billStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public double getAmtAllowed() {
		return amtAllowed;
	}

	public void setAmtAllowed(double amtAllowed) {
		this.amtAllowed = amtAllowed;
	}

	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	
	
	
}
