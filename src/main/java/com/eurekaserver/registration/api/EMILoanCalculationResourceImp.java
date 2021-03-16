package com.eurekaserver.registration.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.eurekaserver.registration.entitiy.Account;
import com.eurekaserver.registration.service.EMILoanCalculationService;

@RestController
public class EMILoanCalculationResourceImp implements EMILoanCalculationResource{
	
	@Autowired
	private EMILoanCalculationService eMILoanCalculationService;

	@Override
	public Account createBrowLoanAccount(Account account) {
		
		return eMILoanCalculationService.createBrowLoanAccount(account);
	}

	@Override
	public List<Account> getEMILoanAccounts(Account account) {
		return eMILoanCalculationService.getListOfAmounts(account);
	}

}
