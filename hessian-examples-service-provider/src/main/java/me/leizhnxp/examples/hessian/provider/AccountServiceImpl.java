package me.leizhnxp.examples.hessian.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import me.leizhnxp.examples.hessian.dao.AccountModelMapper;
import me.leizhnxp.examples.hessian.dao.model.AccountModel;
import me.leizhnxp.examples.hessian.dao.model.AccountModelExample;
import me.leizhnxp.examples.hessian.poc.Account;
import me.leizhnxp.examples.hessian.poc.AccountService;

@Slf4j
public class AccountServiceImpl implements AccountService {

    public void insertAccount(Account acc) {
    	AccountModel record = of(acc);
		this.accountMapper.insert(record);
    }

    private AccountModel of(Account acc) {
		return new AccountModel(accountId(), acc.getName(), new Date(), new Date(), (byte)1);
	}

	private Long accountId() {
		return UUID.randomUUID().toString().hashCode()+0l;
	}

	public List<Account> getAccounts(String name) {
		log.info("name: {}",name);
    	AccountModelExample ae = new AccountModelExample();
    	
    	ae.or().andNameEqualTo(name);
    	final List<AccountModel> selectByExample = accountMapper.selectByExample(ae);
    	log.info("selectByExample : {}",selectByExample.size());
    	List<Account> accounts = of(selectByExample);
    	log.info("size : {}",accounts.size());
		return accounts;
    }

    private List<Account> of(List<AccountModel> models) {
    	List<Account> result = new ArrayList<>();
    	for(AccountModel am:models){
    		Account a = new Account();
    		a.setName(am.getName());
    		result.add(a);
    	}
		return result;
	}

    @Resource
	private AccountModelMapper accountMapper;
}