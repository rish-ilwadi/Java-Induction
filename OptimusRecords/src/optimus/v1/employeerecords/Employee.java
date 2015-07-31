package optimus.v1.employeerecords;
/*
 * public class Employee
 * POJO for Employee_Details table
 */
public class Employee {
	
	/*
	 * Data Members
	 */
	private int employeeCode;
	private String name;
	private String email;
	private String address;
	private long salary;
	private long mobileNo;
	/*
	 * Getters & Setters of data members
	 */
	public int getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
}
