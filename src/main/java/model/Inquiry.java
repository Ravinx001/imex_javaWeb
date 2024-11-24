package model;

public class Inquiry {

	int inquiryId;
	int vehicleId;
	String customerName;
	String customerEmail;
	String customerMobile;
	String inquiry;
	String vehicleTitle;
	String vehiclePrice;

	public String getVehicleTitle() {
		return vehicleTitle;
	}

	public void setVehicleTitle(String vehicleTitle) {
		this.vehicleTitle = vehicleTitle;
	}

	public String getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(String vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public int getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getInquiry() {
		return inquiry;
	}

	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}

}
