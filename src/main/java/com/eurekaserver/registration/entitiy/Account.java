package com.eurekaserver.registration.entitiy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIgnoreProperties({"Account"})

@JsonInclude(Include.NON_NULL)
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
		private BigDecimal noOfYear;
		
		private BigDecimal emiYearInterestAmount;
		private BigDecimal emiMonthlyInterestAmount;
		private BigDecimal emiPrincipalAmount;
		private BigDecimal eMIOutStandingAmount;
		private BigDecimal serialNumber;
		private BigDecimal totalMonths;
		private BigDecimal principal;
		
		
		
		
		public BigDecimal getPrincipal() {
			return principal;
		}
		public void setPrincipal(BigDecimal principal) {
			this.principal = principal;
		}
		public BigDecimal getTotalMonths() {
			return totalMonths;
		}
		public void setTotalMonths(BigDecimal totalMonths) {
			this.totalMonths = totalMonths;
		}
		public BigDecimal getSerialNumber() {
			return serialNumber;
		}
		public void setSerialNumber(BigDecimal serialNumber) {
			this.serialNumber = serialNumber;
		}
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
		public BigDecimal getEmiYearInterestAmount() {
			return emiYearInterestAmount;
		}
		public void setEmiYearInterestAmount(BigDecimal emiYearInterestAmount) {
			this.emiYearInterestAmount = emiYearInterestAmount;
		}
		public BigDecimal getEmiMonthlyInterestAmount() {
			return emiMonthlyInterestAmount;
		}
		public void setEmiMonthlyInterestAmount(BigDecimal emiMonthlyInterestAmount) {
			this.emiMonthlyInterestAmount = emiMonthlyInterestAmount;
		}
		public BigDecimal getEmiPrincipalAmount() {
			return emiPrincipalAmount;
		}
		public void setEmiPrincipalAmount(BigDecimal emiPrincipalAmount) {
			this.emiPrincipalAmount = emiPrincipalAmount;
		}
		public BigDecimal geteMIOutStandingAmount() {
			return eMIOutStandingAmount;
		}
		public void seteMIOutStandingAmount(BigDecimal eMIOutStandingAmount) {
			this.eMIOutStandingAmount = eMIOutStandingAmount;
		}
}
