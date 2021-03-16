package com.eurekaserver.registration.api;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eurekaserver.registration.entitiy.Account;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/calculation/brow")
@Api(value ="Loan Brow Interate Calcultion")
@RestController
public interface BrowCalculationResource {
	

	@PostMapping("/loan/pernalLoan")
	@ApiOperation(value =" Create brow loan account")
	public Account  createBrowLoanAccount(@RequestBody Account account);
	
	
	@GetMapping("/loan/{accountId}")
	@ApiOperation(value =" get brow loan account")
	public Account  getBrowLoanAccount(@PathVariable("accountId") Integer accountId );
	
	@GetMapping("/all")
	@ApiOperation(value ="Get All Brow loan Accounts" )
	
	public List<Account> getAllBrowAccounts(@QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit);
	}
	
	
