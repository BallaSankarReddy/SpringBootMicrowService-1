
package com.eurekaserver.registration.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.eurekaserver.registration.entitiy.Account;
import com.eurekaserver.registration.service.BrowCalculationService;

@RestController
public class BrowCalculationResourceImpl implements BrowCalculationResource {

	@Autowired
	private BrowCalculationService browCalculationService;

	@Override
	public Account createBrowLoanAccount(Account account) {

		return browCalculationService.createBrowLoanAccount(account);
	}

	@Override
	public Account getBrowLoanAccount(Integer accountId) {
		return browCalculationService.getBrowLoanAccount(accountId);
	}

	@Override
	public List<Account> getAllBrowAccounts(Integer offset, Integer limit) {
		return browCalculationService.getAllBrowAccounts(offset, limit);
	}

}
