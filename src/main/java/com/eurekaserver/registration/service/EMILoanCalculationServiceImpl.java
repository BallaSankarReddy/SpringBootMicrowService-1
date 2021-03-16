package com.eurekaserver.registration.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eurekaserver.registration.common.EMILoanCalculation;
import com.eurekaserver.registration.entitiy.Account;
@Component
public class EMILoanCalculationServiceImpl implements EMILoanCalculationService {
	
	

	@Override
	public Account createBrowLoanAccount(Account account) {
		
		BigDecimal oneYearEMIInterstAmount = EMILoanCalculation.oneYearEMIInterstAmount(account.getLoanAmount(), account.getInterestRate(), account.getNoOfYear(),null);
		BigDecimal oneMonthEMIInterstAmount = EMILoanCalculation.oneMonthEMIInterstAmount(oneYearEMIInterstAmount);
		BigDecimal eMIPrincipalAmount =EMILoanCalculation. eMIPrincipalAmount(oneMonthEMIInterstAmount);
		BigDecimal eMIOutStandingAmount = EMILoanCalculation.getEMIOutStandingAmount(account.getLoanAmount(), eMIPrincipalAmount);
		account.setEmiYearInterestAmount(oneYearEMIInterstAmount);
		account.setEmiMonthlyInterestAmount(oneMonthEMIInterstAmount);
		account.seteMIOutStandingAmount(eMIOutStandingAmount);
		account.setEmiPrincipalAmount(EMILoanCalculation.EMI);
		return account;
	}
	
	@Override
	public List<Account> getListOfAmounts(Account account) {
		List<Account> accounts= new ArrayList<Account>();
		int ONE_MONTh = 1;
		if(account.getNoOfYear()!=null || account.getLoanNoOfMonths()!=null) {
			BigDecimal months=BigDecimal.ZERO;
			if(null!=account.getNoOfYear()) {
				
				 months = account.getNoOfYear().multiply(EMILoanCalculation.YEAR);
			}
			else {
				months=new BigDecimal(account.getLoanNoOfMonths());
			}
			account.seteMIOutStandingAmount(BigDecimal.ZERO);
			if(account.getLoanAmount().compareTo(BigDecimal.ZERO)>=0) {
			while (new BigDecimal(ONE_MONTh).compareTo(months.add(BigDecimal.ONE))<0) {
				BigDecimal oneYearEMIInterstAmount=BigDecimal.ZERO;
				if(null!=account.getNoOfYear()) {
					
					 oneYearEMIInterstAmount = EMILoanCalculation.oneYearEMIInterstAmount(account.getLoanAmount(), account.getInterestRate(), account.getNoOfYear(),null);
				}else if(null!=account.getLoanNoOfMonths()) {
					 oneYearEMIInterstAmount = EMILoanCalculation.oneYearEMIInterstAmount(account.getLoanAmount(), account.getInterestRate(), null,new BigDecimal(account.getLoanNoOfMonths()));
				}
					Account accountRes = new Account ();
					accountRes.setAccountId(account.getAccountId());
					accountRes.setTotalMonths(months);
					accountRes.setInterestRate(account.getInterestRate());
				BigDecimal oneMonthEMIInterstAmount = EMILoanCalculation.oneMonthEMIInterstAmount(oneYearEMIInterstAmount);
				BigDecimal eMIPrincipalAmount =EMILoanCalculation. eMIPrincipalAmount(oneMonthEMIInterstAmount);
				BigDecimal eMIOutStandingAmount = EMILoanCalculation.getEMIOutStandingAmount(account.getLoanAmount(), eMIPrincipalAmount);
				accountRes.setEmiYearInterestAmount(oneYearEMIInterstAmount.setScale(2, RoundingMode.HALF_UP));
				accountRes.setEmiMonthlyInterestAmount(oneMonthEMIInterstAmount.setScale(2, RoundingMode.HALF_UP));
				accountRes.seteMIOutStandingAmount(eMIOutStandingAmount);
				accountRes.setEmiPrincipalAmount(EMILoanCalculation.EMI);
				accountRes.setSerialNumber(new BigDecimal(ONE_MONTh));
				account.setLoanAmount(eMIOutStandingAmount);
				accountRes.setLoanAmount(account.getLoanAmount());
				accountRes.setPrincipal(EMILoanCalculation.EMI.subtract(oneMonthEMIInterstAmount.setScale(2,RoundingMode.HALF_UP)));
				accounts.add(accountRes);
				ONE_MONTh++;
	}
			}
			

		}
		
		return accounts;
		
	}
	

}
