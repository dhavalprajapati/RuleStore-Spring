package com.store.rule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.store.rule.model.Rule;
import com.store.rule.service.RuleService;

@RestController  
public class RuleRestController {
	@Autowired
	private RuleService ruleService;
	
	@RequestMapping(value = { "/", "/listRules" }, method = RequestMethod.GET,headers="Accept=application/json")  
	public List<Rule> listRules() {
		return ruleService.listRules();
	}
	
	@RequestMapping(value = "/get/{ruleId}", method = RequestMethod.GET,headers="Accept=application/json")
	public Rule getRule(@PathVariable Long ruleId) {
		return ruleService.getRule(ruleId);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST,headers="Accept=application/json")
	public Rule saveRule(@RequestBody Rule rule) {
		ruleService.saveRule(rule);
		return rule;
	}

	@RequestMapping(value= "/delete/{ruleId}", method = RequestMethod.GET,headers="Accept=application/json")
	public void deleteRule(@PathVariable("ruleId") Long id) {
		 ruleService.deleteRule(id);
	}
}
