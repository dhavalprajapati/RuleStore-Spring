package com.store.rule.service;

import java.util.List;

import com.store.rule.model.Rule;

public interface RuleService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveRule(Rule rule);

	/*
	 * READ
	 */
	public List<Rule> listRules();
	public Rule getRule(Long id);

	/*
	 * DELETE
	 */
	public void deleteRule(Long id);

}
