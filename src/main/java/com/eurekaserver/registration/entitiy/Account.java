package com.eurekaserver.registration.entitiy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Account implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -3164563765358913799L;
		
		private Integer accountId;
		
		private String loanNumber;
		private String accountStatus;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
		private LocalDate nextPaymentDate;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
		private LocalDate previusPaymentDate;
		private BigDecimal loanAmount;
		private Integer loanNoOfMonths;
		private BigDecimal interestRate;
		private BigDecimal dailyInterRate;
		private Integer paymentid;
		private BigDecimal payingAmount;
		//private Payment payment;
		//private BigDecimal monthilyAmount;
		private BigDecimal noOfYear;
		
		public Integer getAccountId() {
			return accountId;
		}
		public void setAccountId(Integer accountId) {
			this.accountId = accountId;
		}
		public String getLoanNumber() {
			return loanNumber;
		}
		public void setLoanNumber(String loanNumber) {
			this.loanNumber = loanNumber;
		}
		public String getAccountStatus() {
			return accountStatus;
		}
		public void setAccountStatus(String accountStatus) {
			this.accountStatus = accountStatus;
		}
		public LocalDate getNextPaymentDate() {
			return nextPaymentDate;
		}
		public void setNextPaymentDate(LocalDate nextPaymentDate) {
			this.nextPaymentDate = nextPaymentDate;
		}
		public LocalDate getPreviusPaymentDate() {
			return previusPaymentDate;
		}
		public void setPreviusPaymentDate(LocalDate previusPaymentDate) {
			this.previusPaymentDate = previusPaymentDate;
		}
		public BigDecimal getLoanAmount() {
			return loanAmount;
		}
		public void setLoanAmount(BigDecimal loanAmount) {
			this.loanAmount = loanAmount;
		}
		public Integer getLoanNoOfMonths() {
			return loanNoOfMonths;
		}
		public void setLoanNoOfMonths(Integer loanNoOfMonths) {
			this.loanNoOfMonths = loanNoOfMonths;
		}
		public BigDecimal getInterestRate() {
			return interestRate;
		}
		public void setInterestRate(BigDecimal interestRate) {
			this.interestRate = interestRate;
		}
		public BigDecimal getDailyInterRate() {
			return dailyInterRate;
		}
		public void setDailyInterRate(BigDecimal dailyInterRate) {
			this.dailyInterRate = dailyInterRate;
		}
		public Integer getPaymentid() {
			return paymentid;
		}
		public void setPaymentid(Integer paymentid) {
			this.paymentid = paymentid;
		}
		public BigDecimal getPayingAmount() {
			return payingAmount;
		}
		public void setPayingAmount(BigDecimal payingAmount) {
			this.payingAmount = payingAmount;
		}
		public BigDecimal getNoOfYear() {
			return noOfYear;
		}
		public void setNoOfYear(BigDecimal noOfYear) {
			this.noOfYear = noOfYear;
		}
}
