package com.kartheek.java.clipayments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kartheek.java.clipayments.entity.AcctType;
import com.kartheek.java.clipayments.entity.BankAccount;
import com.kartheek.java.clipayments.entity.User;
import com.kartheek.java.clipayments.entity.Wallet;

public class RunPaymentsApplication {

	static int x=10;
   static List<User> userList = new ArrayList<User> ();
   static int currentUserId = -1;
 
    public static Map<Integer, Wallet> walletList = new HashMap<Integer,Wallet>();
	 
    

	public static void main(String[] args) {
//		FileOps fileOps = new FileOps();
//		 try {
//			List<User> userData = fileOps.fileToUser();
//			for(User u : userData) {
//				System.out.println(u.getUserId()+" "+u.getFirstName()+" "+u.getLastName()+" "+u.getPhoneNum()+" "+u.getDateOfBirth()+" "+u.getCommunicationAddr());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
//		
		
		int selectedOption=0;		
		Scanner opt = new Scanner(System.in);
				
		while(true) {
			System.out.println("Payments App Actions:");
			System.out.println("1. Register New User");
			System.out.println("2. Login");
			System.out.println("3. ADD Bank Account");
			System.out.println("4. List of Users");
			System.out.println("5. Current User");
			System.out.println("6.Add money to Wallet");
			System.out.println("7.logout user");
			System.out.println("-1. Quit ");


			System.out.println("Choose an Option:");
			
			String optStr = opt.next();
			try {
				selectedOption = Integer.parseInt(optStr);
				
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
			   register();
			   
			}else if(optStr.equalsIgnoreCase("2")) {
				 logIn();
				
				
			}else if(optStr.equalsIgnoreCase("3")) {
				addBankAccount();
				
			}else if(optStr.equalsIgnoreCase("4")) {
				ops.printUserList( );
			}else if(optStr.equalsIgnoreCase("-1")) {
				break;
			}else if(optStr.equalsIgnoreCase("5")) {
				 ops.currentUser();
			}else if(optStr.equalsIgnoreCase("6")) {
				   addMoney();
			}
			else if(optStr.equalsIgnoreCase("7")) {
			 
				System.out.println(ops.checkWalletBalance());
			}else if(optStr.equalsIgnoreCase("8")) {
				  logout();
			}
			else {
				
			}
		}
		opt.close();
	}
	
	
	
	
	private static void register() {
		 try {
		Scanner opt = new Scanner(System.in);
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
				UserOperations ops = new UserOperations();
				User u = ops.doUserRegistration(fName, lName, password, phNo, dob, addr);
				 
			     userList.add(u);
			   Wallet wallet = new Wallet();
			   int usrId = u.getUserId();
			   walletList.put(usrId, wallet);
			    
			     
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
	 
	     
	}
	
	
	private static void logIn() {
		Scanner opt = new Scanner(System.in);
		if(currentUserId == -1) {
			System.out.println("enter User credentials to login ");
			System.out.println();
			System.out.println("Enter UserId : ");
			int userId = opt.nextInt();
			System.out.println("Enter password : ");
			String password = opt.next();
			 
			
			UserOperations ops = new UserOperations();
			
			ops.userLogIn ( userId, password);
			}
			else {
				System.out.println("To log in to another account you must log out the current user");
			}
	}
	private static void addBankAccount() {
		BankAccount bankAccount = new BankAccount();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Bank Name : ");
		String bankName = sc.next();
		System.out.println("Enter Bank Account Number : ");
		String acctNumber = sc.next();
		System.out.println("Enter IFSC Code : ");
		String ifsc = sc.next();
		 
		System.out.println("Select Your Account type from the following : ");
		for(AcctType type : AcctType.values()) {
			System.out.println("      "+type);
		}
		String actType = sc.next();
		 
		try {
			AcctType acctType = AcctType.valueOf(actType);
			bankAccount.setAcctType(acctType);
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
			 
		}
	 
		
		System.out.println("Enter Account Pin");
		String pin = sc.next();
		
		 
		bankAccount.setBankName(bankName);
		bankAccount.setAcctNumber(acctNumber);
		bankAccount.setIFSC(ifsc);
		bankAccount.setAcctPin(pin);
		bankAccount.setUserid(currentUserId);
		
		System.out.println(bankAccount);
		 
		
		
	}
	private static void addMoney() {
		
		if(currentUserId!=-1) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount : ");
		double amount = sc.nextDouble();
		if(amount <=10000.00) {
			UserOperations ops = new UserOperations();
			ops.addMoneyToWallet(amount);
		}
		else {
			System.out.println("Maximum deposit is 10,000 ");
		}
	 
		 
	}
		else {
			System.out.println("user must log in to add money to wallet");
		}
	}
	private static void logout() {
		currentUserId = -1;
	}
	private static String accountTypeList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Your Account type from the following : ");
		for(AcctType type : AcctType.values()) {
			System.out.println("      "+type);
		}
		String actType = sc.next();
		sc.close();
		return actType;
		
	}

}