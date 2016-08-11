package com.store.rule.event;

import org.springframework.context.ApplicationEvent;

import com.store.rule.model.Rule;

public class RuleEvent extends ApplicationEvent
{
    private static final long serialVersionUID = 1L;
     
    private String eventType;
    private Rule rule;
     
    //Constructor's first parameter must be source
    public RuleEvent(Object source, String eventType, Rule rule) 
    {
        //Calling this super class constructor is necessary
        super(source);
        this.eventType = eventType;
        this.rule = rule;
    }
 
    public String getEventType() {
        return eventType;
    }
 
    public Rule getRule() {
        return rule;
    }
}