package com.clipayments.java;

import com.clipayments.java.entity.User;
import java.util.List;

public class UserOperations {
		
		public User doUserRegistration(String fName, String lName, String password, long phNum, String dob,String addr) {
			User u = new User();
			u.setFirstName(fName);
			u.setLastName(lName);
			u.setPhoneNum(phNum);
			u.setDateOfBirth(dob);
			u.setCommunicationAddr(addr);
			u.setPassword(password);
			
			u.setUserId(1234);
			return u;
		}
		
		public void printUserList(List<User> userlist){
			for(int i=0;i<userlist.size();i++) {
				if(userlist.get(i) != null) {
					System.out.println("User Details of "+ userlist.get(i).getFirstName());
					System.out.println(userlist.get(i));
				}
				
			}
		}
		int i=0;
		public boolean verifyuserid(String userId,String password,List<User> Users) {
			if(String.valueOf(Users.get(i).equals(userId))!= null) {
				if(password.equals(password)) {
					return true;
				}
			}
			return false;
		}
		public void Printcurruserdetails(int userId,List<User> Users) {
			for (int i = 0;i<Users.size();i++) {
				if(Users.get(i).getUserId() !=userId) {
					System.out.println(userId);
					break;
				}
				
				
			}
			
		}

	}

