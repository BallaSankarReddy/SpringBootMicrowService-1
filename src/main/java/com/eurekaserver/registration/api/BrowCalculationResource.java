package com.eurekaserver.registration.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.eurekaserver.registration.entitiy.Account;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/calculation/brow")
@Api(value ="Loan Brow Interate Calcultion " )
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface BrowCalculationResource {

	@POST
	@Path("/loan/pernalLoan")
	@ApiOperation(value =" Create brow loan account")
	public Response  createBrowLoanAccount(Account account);
	
	@GET
	@Path("/{accountId}")
	@ApiOperation(value =" get brow loan account")
	public Response  getBrowLoanAccount(@PathParam("accountId") Integer accountId );
	
	@GET
	@Path("/all")
	@ApiOperation(value ="Get All Brow loan Accounts" )
	
	public Response getAllBrowAccounts(@QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit);
	
	
}
