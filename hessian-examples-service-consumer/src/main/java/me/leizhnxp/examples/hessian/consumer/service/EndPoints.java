package me.leizhnxp.examples.hessian.consumer.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import me.leizhnxp.examples.hessian.poc.Account;
import me.leizhnxp.examples.hessian.poc.AccountService;

@Controller
@Slf4j
public class EndPoints {
	
	@RequestMapping(path = "/accounts", method = RequestMethod.GET)
	@ResponseBody
	Result<List<Account>> accounts(@RequestParam("name") String name){
		log.info("param name : {}",name);
		final List<Account> accounts = accountService.getAccounts(name);
		Result<List<Account>> result = new Result<>();
		result.setCode(0);
		result.setDesc(accounts);
		return result;
	}

	@Resource
	private AccountService accountService;
}
