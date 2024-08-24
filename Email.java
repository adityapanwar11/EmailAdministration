package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String department;
	private String password;
	private String email;
	private int mailBoxCapacity=500;
	private String alternateEmail;
	private int defaultPasswordLength=10;
	private String companySuffix="aeycompany.com";

	//Constructor to receive the firstname and lastname

	public Email(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;

		//Call method asking for the department-return the department
		this.department=setDepartment();
		
		//Call a method that returns a random password
		this.password=randomPassword(defaultPasswordLength);
		
		//COmbine elements to generate email
		email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.toLowerCase()+"."+companySuffix;
	}
	//Ask for the department
	private String setDepartment() {
		System.out.println("New employee: "+firstName+ "\nDEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department ");
		Scanner in=new Scanner(System.in);
		int deptChoice=in.nextInt();
		if(deptChoice==1) {
			return "Sales";
		}
		else if(deptChoice==2) {
			return "Development";
		}
		else if(deptChoice==3) {
			return "Accouting";
		}
		else {
			return "";
		}
	}
	
	//generate a random password
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			//Math.random gives a random number between 0 to 1
			int rand=(int)(Math.random() * passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailBoxCapacity=capacity;
	}
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail=altEmail;
	}
	//Change the password
	public void changePassword(String password) {
		this.password=password;
	}
	
	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {
		return password;
	}
	public String showInfo() {
		return "DISPLAY NAME: "+firstName+" "+lastName+
				"\nCOMPANY EMAIL: "+email+
				"\nMAILBOX CAPACITY: "+mailBoxCapacity+ "mb";
	}
}