package com.eurekaserver.registration.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface FormarLoanCalculation {

	public static BigDecimal ONE_HUNDRED = new BigDecimal(100);
	public static BigDecimal ONE_YEAR = new BigDecimal(12);
	public static BigDecimal DEFAULT_DAYS = new BigDecimal(30);

	public static BigDecimal getBrowWithInterestAmount(BigDecimal browAmount, BigDecimal rateOfInterest,
			BigDecimal nofYear, BigDecimal nofMonths) {
		BigDecimal totalBrowWithInterestAmount = BigDecimal.ZERO;
		// formula :: PTR%100

		if (null == nofYear) {
			nofYear = ONE_YEAR;
			totalBrowWithInterestAmount = PTRCaculation(browAmount, rateOfInterest, nofYear);
		} else {
			totalBrowWithInterestAmount = PTRCaculation(browAmount, rateOfInterest, nofYear);

		}

		return totalBrowWithInterestAmount;

	}

	public static BigDecimal getNoOfMonthsInterestAmount(BigDecimal browAmount, BigDecimal rateOfInterest,
			BigDecimal nofYear, BigDecimal nofMonths) {
		BigDecimal totalBrowWithInterestAmount = BigDecimal.ZERO;
		BigDecimal monthily_Amount = BigDecimal.ZERO;
		// formula :: PTR%100

		if (null == nofYear) {
			nofYear = ONE_YEAR;
			totalBrowWithInterestAmount = PTRCaculation(browAmount, rateOfInterest, nofYear);
		}

		if (null != nofMonths) {

			monthily_Amount = (totalBrowWithInterestAmount.divide(ONE_YEAR)).multiply(nofMonths);

		}

		return monthily_Amount;

	}

	public static BigDecimal getDailyInterestAmount(BigDecimal montilyInterstAmount) {
		BigDecimal daily_interst_Amount = BigDecimal.ZERO;
		if (montilyInterstAmount.compareTo(BigDecimal.ZERO) > 0) {
			daily_interst_Amount = montilyInterstAmount.divide(DEFAULT_DAYS, 3, RoundingMode.HALF_UP);
		}

		return daily_interst_Amount;

	}

	public static BigDecimal PTRCaculation(BigDecimal browAmount, BigDecimal rateOfInterest, BigDecimal nofYear) {
		BigDecimal totalBrowWithInterestAmount;
		BigDecimal divide = (browAmount.divide(ONE_HUNDRED));
		totalBrowWithInterestAmount = divide.multiply(nofYear).multiply(rateOfInterest);
		return totalBrowWithInterestAmount;
	}

}
