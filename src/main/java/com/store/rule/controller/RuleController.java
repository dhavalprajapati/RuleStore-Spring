package com.store.rule.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.store.rule.model.Rule;
import com.store.rule.service.RuleService;

@Controller
@RequestMapping("/rule")
public class RuleController {

	@Autowired
	private RuleService ruleService;

	@RequestMapping(value = { "/", "/listRules" })
	public String listRules(Map<String, Object> map) {

		map.put("rule", new Rule());
		map.put("ruleList", ruleService.listRules());

		return "/rule/listRules";
	}

	@RequestMapping("/get/{ruleId}")
	public String getRule(@PathVariable Long ruleId, Map<String, Object> map) {

		Rule rule = ruleService.getRule(ruleId);

		map.put("rule", rule);

		return "/rule/ruleForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRule(@ModelAttribute("rule") Rule rule,
			BindingResult result) {

		ruleService.saveRule(rule);
		
		return "redirect:listRules";
	}

	@RequestMapping("/delete/{ruleId}")
	public String deleteRule(@PathVariable("ruleId") Long id) {

		ruleService.deleteRule(id);

		return "redirect:/rule/listRules";
	}
}
