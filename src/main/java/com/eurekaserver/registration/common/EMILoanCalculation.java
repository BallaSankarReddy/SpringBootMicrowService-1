package com.eurekaserver.registration.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface EMILoanCalculation {

	public static BigDecimal ONE_HUNDRED = new BigDecimal(100);
	public static BigDecimal YEAR = new BigDecimal(12);

	public static BigDecimal getPrincipalAmount(BigDecimal loanAmount, BigDecimal rateOfInterest, BigDecimal nofYear,
			BigDecimal nofMonths) {
		BigDecimal principalAmount = BigDecimal.ZERO;
		if (null != nofYear) {

			BigDecimal setScale = rateOfInterest.setScale(0, RoundingMode.FLOOR);
			principalAmount = loanAmount.multiply(ONE_HUNDRED).divide(nofYear.multiply(setScale));

		}

		return principalAmount;

	}

	public static BigDecimal getTotalPrincipalAmount(BigDecimal loanAmount, BigDecimal totalRateOfInterest,
			BigDecimal otherfee) {
		BigDecimal principalAmount = BigDecimal.ZERO;
		principalAmount = loanAmount.add(totalRateOfInterest).add(otherfee);

		return principalAmount;

	}

	public static BigDecimal getTotalInterestAmount(BigDecimal loanAmount, BigDecimal rateOfInterest,
			BigDecimal nofYear, BigDecimal nofMonths) {
		BigDecimal totalInterestAmount = BigDecimal.ZERO;
		if (null != nofMonths) {
			BigDecimal multiply = loanAmount.multiply(nofMonths).multiply(rateOfInterest);
			totalInterestAmount = multiply.divide(ONE_HUNDRED.multiply(YEAR));

		}

		return totalInterestAmount;

	}

	public static BigDecimal getEMIPaymentAmount(BigDecimal loanAmount, BigDecimal totalInterestAmount,
			BigDecimal nofYear, BigDecimal nofMonths) {
		BigDecimal monthlyPaymentAmount = BigDecimal.ZERO;
		if (null != nofMonths) {
			monthlyPaymentAmount = loanAmount.add(totalInterestAmount).divide(nofMonths);

		}

		return monthlyPaymentAmount;

	}

}