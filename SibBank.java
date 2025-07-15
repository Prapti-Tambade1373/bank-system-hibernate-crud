package com.bank.serviceImplementation;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bank.service.RbiBank;
import com.bankCongig.HibernateUtil;
import com.bankmodel.Account;

public class SibBank implements RbiBank {

	SessionFactory factory = HibernateUtil.getSessionFactory(); 
	Session session = factory.openSession();
	
      Scanner sc=new Scanner(System.in);
	
	@Override
	public void createAccount() {
		Transaction txn=session.beginTransaction();
		Account account=new Account();
		System.out.println("Enter Account Holder Name:-");
		String ac_name=sc.next();
		
		System.out.println("Enter Account Branch Name:-");
		String ac_branch=sc.next();
		
		System.out.println("Enter Account Holder Adhar number:-");
		String adhar_num=sc.next();
		
		System.out.println("Enter Account Initial Balance:-");
		double bal=sc.nextDouble();
		
		account.setAc_name(ac_name);
		account.setAc_branch(ac_branch);
		account.setAddhar_num(adhar_num);
		account.setAc_bal(bal);
		session.save(account);
		txn.commit();
		System.out.println("Account of "+ac_name+" is created successfully...");
		
	}
	

	@Override
	public void deposite() {
		
		Transaction txn=session.beginTransaction();
		System.out.println("Enter Account Number:-");
		int ac_num=sc.nextInt();
		
		Account ac=session.get(Account.class,ac_num);
		if(ac==null)
		{
			System.out.println("Account Does not Exists");
		}
		else {
			System.out.println("Enter Deposited Amount ");
			double dept_amt=sc.nextDouble();
			double old_bal=ac.getAc_bal();
			ac.setAc_bal(dept_amt+old_bal);
			session.update(ac);
			txn.commit();
			System.out.println("Money "+dept_amt+" is deposited in your account");
		}
		
	}
	
	

	@Override
	public void withdrawl() {
		
		
		Transaction txn=session.beginTransaction();
		System.out.println("Enter Account Number");
		int ac_num=sc.nextInt();
		
		Account ac=session.get(Account.class,ac_num);
		if(ac==null)
		{
			System.out.println("Account Does not Exists !!!");
		}
		else
		{
			System.out.println("Enter Withdrawl amount");
			double w_amt=sc.nextDouble();
			double available_bal=ac.getAc_bal();
			
			if(w_amt<available_bal)
			{
				ac.setAc_bal(available_bal-w_amt);
				session.update(ac);
				txn.commit();
				System.out.println("Hii "+ac.getAc_name()+" Money "+w_amt+" is debited from your account:-"+ac_num);
			}
			else
			{
				System.out.println("Insufficient Balance in your Account"+ac_num);
			}
			
			
		}
		
	}

	
	
	@Override
	public void check_balance() {
		
		System.out.println("Enter Account Number:-");
		int ac_num=sc.nextInt();
		
		Account ac=session.get(Account.class,ac_num);
		if(ac==null)
		{
			System.out.println("Account Does not Exists");
		}
		else {
			System.out.println("Hey "+ac.getAc_name()+" Available Balance in Your account "+ac_num+" is "+ac.getAc_bal());
			
		}
	}
	
	

	@Override
	public void deleteAccount() {
	
		
		Transaction txn=session.beginTransaction();
		System.out.println("Enter Account Number:-");
		int ac_num=sc.nextInt();
		
		Account ac=session.get(Account.class,ac_num);
		if(ac==null)
		{
			System.out.println("Account Does not Exists");
		}
		else {
			session.delete(ac);
			txn.commit();
			
			System.out.println("Hey "+ac.getAc_name()+" Your account is Deleted successfully "+ac_num);
			
		}
		
	}


		
}

