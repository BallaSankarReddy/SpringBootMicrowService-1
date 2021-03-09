package com.eurekaserver.registration.api;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.eurekaserver.registration.entitiy.Account;
import com.eurekaserver.registration.service.BrowCalculationService;

@RestController
public class BrowCalculationResourceImpl implements BrowCalculationResource{
	
	@Autowired
	private BrowCalculationService browCalculationService;

	@Override
	public Response createBrowLoanAccount(Account account) {
		
		return Response.ok(browCalculationService.createBrowLoanAccount(account)).build();
	}

	@Override
	public Response getBrowLoanAccount(Integer accountId) {
		return Response.ok(browCalculationService.getBrowLoanAccount(accountId)).build();
	}

	@Override
	public Response getAllBrowAccounts(Integer offset, Integer limit) {
		return Response.ok(browCalculationService.getAllBrowAccounts(offset, limit)).build();
	}

}
