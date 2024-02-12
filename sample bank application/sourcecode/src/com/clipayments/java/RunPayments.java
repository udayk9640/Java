package com.clipayments.java;
import java.util.Scanner;
import java.util.List;

import com.clipayments.java.entity.BankAccount;
import com.clipayments.java.entity.User;
public class RunPayments {
	
	

	
	

		static int x=10;
		//public static User[] usersList = new User[5];
		public static List<User> userlist;
		public static List<BankAccount> Bankacctlist;

		public static void main(String[] args) {
			
			int selectedOption=0;		
			Scanner opt = new Scanner(System.in);
					
			while(true) {
				System.out.println("Payments App Actions:");
				System.out.println("1. Register New User");
				System.out.println("2. Login");
				System.out.println("3. ADD Bank Account");
				System.out.println("4. List of Users");
				System.out.println("5.Current User");
				System.out.println("-1. Quit/ Logout");
				System.out.println("Choose an Option:");
				
				String optStr = opt.next();
				try {
					selectedOption = Integer.parseInt(optStr);
					int currBal=10;
					int x = 100/currBal;
					
				}catch(NumberFormatException e) {
					e.printStackTrace();
					e.getMessage();
					System.out.println("Number format Error Occured Please choose another option.");
					
				}catch(ArithmeticException e) {
					e.printStackTrace();
					e.getMessage();
					System.out.println("arithmetic Error Occured Please choose another option.");
					
				}catch(Exception e) {
					e.printStackTrace();
					e.getMessage();
					System.out.println("Some Error Occured Please choose another option.");
				}finally{
					System.out.println();
				}
				
				System.out.println("User selected "+selectedOption);
				UserOperations ops = new UserOperations();
				if(optStr.equalsIgnoreCase("1")) {
					System.out.println("Please do provide user details as asked:");
					System.out.println("First Name:");
					String fName = opt.next();
					System.out.println("Last Name:");
					String lName = opt.next();
					System.out.println("Phone Number:");
					long phNo = Long.parseLong(opt.next());
					System.out.println("Date Of Birth:");
					String dob = opt.next();
					System.out.println("Address:");
					String addr = opt.next();
					System.out.println("Password:");
					String password = opt.next();
					
					
					User u = ops.doUserRegistration(fName, lName, password, phNo, dob, addr);
					
//					for(int i=0;i<usersList.length;i++) {
//						if(usersList[i] ==null) {
//							usersList[i]=u;
//							break;
//									
//						}
//						
//					}
					
					for(int i=0;i<userlist.size();i++) {
						if(userlist.get(i)==null) {
							userlist.get(i).setUserId(i);
							break;
						}
							
							
						}
				}else if(optStr.equalsIgnoreCase("2")) {
					System.out.println("Login Your ID");
					System.out.println("Enter UserId : ");
					String Uid =opt.next();
					System.out.println("Enter the Password : ");
					String password = opt.next();
					ops.verifyuserid(Uid, password, userlist);
					if (ops.verifyuserid(Uid, password, userlist)) {
						System.out.println("Login Success !");
					}else {
					System.out.println("Login Failed !");
					}
					
				}else if(optStr.equalsIgnoreCase("3")) {
					
				}else if(optStr.equalsIgnoreCase("4")) {
					ops.printUserList(userlist);
				}else if(optStr.equalsIgnoreCase("5")){
					ops.Printcurruserdetails(0, userlist);
				}else if(optStr.equalsIgnoreCase("-1")) {
					break;
				}else {
					
				}
			}
		}
		
		

	}

