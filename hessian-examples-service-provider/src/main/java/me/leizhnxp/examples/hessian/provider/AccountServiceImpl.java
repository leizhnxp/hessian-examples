package me.leizhnxp.examples.hessian.provider;

import java.util.Arrays;
import java.util.List;

import me.leizhnxp.examples.hessian.poc.Account;
import me.leizhnxp.examples.hessian.poc.AccountService;

public class AccountServiceImpl implements AccountService {

    public void insertAccount(Account acc) {
        // do something...
    }

    public List<Account> getAccounts(String name) {
		return Arrays.asList(new Account());
        // do something...
    }

}