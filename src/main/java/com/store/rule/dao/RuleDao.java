package com.store.rule.dao;

import java.util.List;

import com.store.rule.model.Rule;


public interface RuleDao {

	/*
	 * CREATE and UPDATE
	 */
	public Rule saveRule(Rule rule); // create and update

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
