package com.eurekaserver.registration.api;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eurekaserver.registration.entitiy.Account;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/calculation/emi")
@Api(value ="Loan EMI Interate Calcultion")
@RestController
public interface EMILoanCalculationResource {
	@PostMapping("/loan/emi")
	@ApiOperation(value =" Create EMI loan account")
	public Account createBrowLoanAccount(Account account);
	
	@GetMapping("/loan/get/emi")
	@ApiOperation(value =" Get EMI loan accounts")
	public List<Account> getEMILoanAccounts(Account account);
}
