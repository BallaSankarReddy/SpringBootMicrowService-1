package com.eurekaserver.registration.service;

import java.util.List;

import com.eurekaserver.registration.entitiy.Account;

public interface EMILoanCalculationService {
	Account createBrowLoanAccount(Account account);

	List<Account> getListOfAmounts(Account account);

}
