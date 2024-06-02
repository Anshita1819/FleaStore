package flea.store.pojos;

public class Registartion {
	//`_id`, `first_name`, `last_name`, `email_id`, `mobile_no`, `state`, `pincode`, `password`, `confirm_password`
    private int _id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNo;
    private String state;
    private String pincode;
    private String password;
    private String confirmPassword;
	public Registartion(int _id, String firstName, String lastName, String emailId, String mobileNo, String state,
			String pincode, String password, String confirmPassword) {
		super();
		this._id = _id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.state = state;
		this.pincode = pincode;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public Registartion(String firstName, String lastName, String emailId, String mobileNo, String state,
			String pincode, String password, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.state = state;
		this.pincode = pincode;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
    
    
    
}
