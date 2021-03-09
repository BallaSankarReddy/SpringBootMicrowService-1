package com.eurekaserver.registration.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eurekaserver.registration.common.FormarLoanCalculation;
import com.eurekaserver.registration.entitiy.Account;

@Service
public class BrowCalculationServiceImpl implements BrowCalculationService{

	private   List<Account> account_list = new ArrayList<Account>();
	
	
	
	@Override
	public Account createBrowLoanAccount(Account account) {		
		BigDecimal browWithInterestAmount = FormarLoanCalculation.getBrowWithInterestAmount(account.getLoanAmount(), account.getInterestRate(), account.getNoOfYear(), new BigDecimal(account.getLoanNoOfMonths()));
		account.setPayingAmount(browWithInterestAmount);
		Random random= new Random();
		account.setAccountId(random.nextInt(100));
		account_list.add(account);
		return account;
	}

	@Override
	public List<Account> getAllBrowAccounts(Integer offset, Integer limit) {
		
		limit=limit==null ? 100: limit;
		List<Account> collect = account_list.stream().limit(limit).collect(Collectors.toList());
		return collect;
	}

	@Override
	public Account getBrowLoanAccount(Integer accountId) {
		// TODO Auto-generated method stub
		return null;
	}

}
