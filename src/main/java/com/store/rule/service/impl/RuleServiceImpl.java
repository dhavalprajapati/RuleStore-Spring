package com.store.rule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.rule.dao.RuleDao;
import com.store.rule.event.RuleEvent;
import com.store.rule.model.Rule;
import com.store.rule.service.RuleService;

@Service
public class RuleServiceImpl implements RuleService , ApplicationEventPublisherAware{

	@Autowired
	private RuleDao ruleDao;
	
	private ApplicationEventPublisher publisher;
	
	/**
	 * 
	 */
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
	
	
	/**
	 * 
	 */
	@Transactional
	public void saveRule(Rule rule) {
		Rule updateRule = ruleDao.saveRule(rule);
		publisher.publishEvent(new RuleEvent(this, "SAVE", updateRule));
	}
	
	/**
	 * 
	 */
	@Transactional(readOnly = true)
	public List<Rule> listRules() {
		return ruleDao.listRules();
	}
	
	/**
	 * 
	 */
	@Transactional(readOnly = true)
	public Rule getRule(Long id) {
		return ruleDao.getRule(id);
	}
	
	/**
	 * 
	 */

	@Transactional
	public void deleteRule(Long id) {
		Rule rule = ruleDao.getRule(id);
		ruleDao.deleteRule(id);
		publisher.publishEvent(new RuleEvent(this, "DELETE", rule));

	}

}
