package com.store.rule.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.store.rule.event.RuleEvent;

@Component
public class RuleEventHandler implements ApplicationListener<RuleEvent> 
{
    public void onApplicationEvent(RuleEvent event) 
    {
    	RuleEvent ruleEvent = (RuleEvent) event;
 
        System.out.println("Employee " + ruleEvent.getEventType() + " with details : " + ruleEvent.getRule());
 
        // TODO :  Do more processing as per application logic
    }
}
