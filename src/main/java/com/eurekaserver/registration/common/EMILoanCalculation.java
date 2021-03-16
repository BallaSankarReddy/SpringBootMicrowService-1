package com.eurekaserver.registration.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface EMILoanCalculation {




		public static BigDecimal ONE_HUNDRED = new BigDecimal(100);
		public  BigDecimal YEAR = new BigDecimal(12);
		//6602.47
		public  BigDecimal EMI = new BigDecimal(4769.96);
		
		public static BigDecimal getPrincipalAmount(BigDecimal loanAmount, BigDecimal rateOfInterest, BigDecimal nofYear,
				BigDecimal nofMonths) {
			BigDecimal principalAmount = BigDecimal.ZERO;
			BigDecimal oneYearEMIInterstAmount = oneYearEMIInterstAmount(loanAmount, rateOfInterest, nofYear,null);
			BigDecimal oneMonthEMIInterstAmount = oneMonthEMIInterstAmount(oneYearEMIInterstAmount);
			BigDecimal eMIPrincipalAmount = eMIPrincipalAmount(oneMonthEMIInterstAmount);
			 principalAmount = getEMIOutStandingAmount(loanAmount, eMIPrincipalAmount);
			return principalAmount;

		}
		public static BigDecimal getEMIOutStandingAmount(BigDecimal loanAmount, BigDecimal eMIPrincipalAmount) {
			BigDecimal EMIOutStandingAmount = BigDecimal.ZERO;
		
			if(loanAmount.compareTo(BigDecimal.ZERO)>0) {
			
			EMIOutStandingAmount= loanAmount.subtract(eMIPrincipalAmount);
		}
			return EMIOutStandingAmount;

		}
		
		public static BigDecimal oneYearEMIInterstAmount(BigDecimal loanAmount, BigDecimal rateOfInterest,
				BigDecimal nofYear,BigDecimal noOfMonths) {
			BigDecimal oneYearInterest = BigDecimal.ZERO;
			if (null != nofYear) {

				oneYearInterest = (loanAmount.divide(ONE_HUNDRED)).multiply(rateOfInterest);

			}
			if (null != noOfMonths) {

				BigDecimal year = noOfMonths.divide(YEAR);
				oneYearInterest = (loanAmount.divide(ONE_HUNDRED)).multiply(rateOfInterest);

			}
			return oneYearInterest;
		}
		
		public static BigDecimal oneMonthEMIInterstAmount(BigDecimal yearlyInterestAmont) {
			BigDecimal oneMonthInterest = BigDecimal.ZERO;
			if (null != yearlyInterestAmont) {

				oneMonthInterest = (yearlyInterestAmont.divide(YEAR));

			}
			return oneMonthInterest;
		}
		
		public static BigDecimal eMIPrincipalAmount(BigDecimal oneMonthInterest) {
			BigDecimal principalAmount = BigDecimal.ZERO;
			if (null != oneMonthInterest) {

				BigDecimal setScale = EMI.setScale(2,RoundingMode.HALF_UP);
				BigDecimal setScale2 = oneMonthInterest.setScale(2,RoundingMode.HALF_UP);
				principalAmount = setScale.subtract(setScale2);

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