package me.leizhnxp.examples.hessian.consumer.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.leizhnxp.examples.hessian.poc.Account;
import me.leizhnxp.examples.hessian.poc.AccountService;

@Controller
public class EndPoints {
	
	@RequestMapping(path = "/{para}", method = RequestMethod.GET)
	@ResponseBody
	String echo(@PathVariable String para){
		return accountService.getAccounts("any").size()+"";
	}

	@Resource
	private AccountService accountService;
}
