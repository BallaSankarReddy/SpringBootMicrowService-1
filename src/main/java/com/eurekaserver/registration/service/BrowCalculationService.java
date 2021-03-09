package com.eurekaserver.registration.service;

import java.util.List;

import com.eurekaserver.registration.entitiy.Account;

public interface BrowCalculationService {
	
	
	Account createBrowLoanAccount(Account account);
	List<Account> getAllBrowAccounts(Integer offset, Integer limit);
	Account getBrowLoanAccount(Integer accountId);
	

}
