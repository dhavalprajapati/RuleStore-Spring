package com.store.rule.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.rule.dao.RuleDao;
import com.store.rule.model.Rule;

@Repository
public class RuleDaoImpl implements RuleDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Rule saveRule(Rule rule) {
		return (Rule)getSession().merge(rule);

	}

	@SuppressWarnings("unchecked")
	public List<Rule> listRules() {

		return getSession().createCriteria(Rule.class).list();
	}

	public Rule getRule(Long id) {
		return (Rule) getSession().get(Rule.class, id);
	}

	public void deleteRule(Long id) {

		Rule rule = getRule(id);

		if (null != rule) {
			getSession().delete(rule);
		}

	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
