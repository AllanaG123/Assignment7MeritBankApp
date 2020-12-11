package com.assignments.assignment5.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
@Entity
@Table(name = "CDAccount")
public class CDAccount extends BankAccount{

	@DecimalMin(value = "0.0", inclusive = false, message = "interest rate must be greater than zero")
	@DecimalMax(value = "1.0", inclusive = false, message = "interest rate must be less than one")
	double interestRate = 0.025;
	int term;
	
	public CDAccount() {
		super();
		this.term = 0;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

}