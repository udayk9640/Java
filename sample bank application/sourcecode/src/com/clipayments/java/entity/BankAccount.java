package com.clipayments.java.entity;
import java.util.List;

public class BankAccount {
	private String Bankacctno;
	private String BankacctName;
	private AccType Acctype;
	private String AcctIFSC;
	private String Pin;
	private List<BankAccount> Bankacctlist;
	public String getBankacctno() {
		return Bankacctno;
	}
	public void setBankacctno(String bankacctno) {
		Bankacctno = bankacctno;
	}
	public String getBankacctName() {
		return BankacctName;
	}
	public void setBankacctName(String bankacctName) {
		BankacctName = bankacctName;
	}
	public AccType getAcctype() {
		return Acctype;
	}
	public void setAcctype(AccType acctype) {
		Acctype = acctype;
	}
	public String getAcctIFSC() {
		return AcctIFSC;
	}
	public void setAcctIFSC(String acctIFSC) {
		AcctIFSC = acctIFSC;
	}
	public String getPin() {
		return Pin;
	}
	public void setPin(String pin) {
		Pin = pin;
	}
	public List<BankAccount> getBankacctlist() {
		return Bankacctlist;
	}
	public void setBankacctlist(List<BankAccount> bankacctlist) {
		Bankacctlist = bankacctlist;
	}
	

}
