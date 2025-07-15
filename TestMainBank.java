package com.bankTest;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bank.serviceImplementation.SibBank;
import com.bankCongig.HibernateUtil;



public class TestMainBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SibBank sbi=new SibBank();
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
		System.out.println("\n 1.createAccount/2.Deposite amount /3. checking the balance /4. withdrawl /5.deletion of account /6. for Exiting the project");
		System.out.println("Enter Your Choice for Handelling Bank Project :->");
		int ch=sc.nextInt();
		switch(ch)
		
		{
		case 1:
			sbi.createAccount();
			break;
			
		case 2:
			sbi.deposite();
			break;
			
		case 3:
			sbi.check_balance();
			break;
			
		case 4:
			sbi.withdrawl();
			break;
		case 5:
			sbi.deleteAccount();
			break;
			
		case 6:
			System.out.println("Exiting.....");
			System.exit(0);
			break;
		}
		
		}
	}

		
		
		
	}


