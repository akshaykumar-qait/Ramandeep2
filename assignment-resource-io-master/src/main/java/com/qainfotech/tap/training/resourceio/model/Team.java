package com.qainfotech.tap.training.resourceio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class Team {
    
    private final String name;
    private final Integer id;
    
    private final List<Individual> members;
    
 public Team(Map<String, Object> teamMap)
    {
	throw new UnsupportedOperationException("Not implemented.");
	}
    
    
    public Team(String aa, Integer bb,List<Individual> x)
    {     	
    	name=aa;
    	id=bb;
    	members=x;
    	
    }
    
    /**
     * get team name
     * 
     * @return 
     */
    public String getName(){
        
    	
    	
    	return name;
    }
    
    /**
     * get team id
     * 
     * @return 
     */
    public Integer getId(){
        return id;
    }
    
    /** 
     * get list of individuals that are members of this team
     * 
     * @return 
     */
    public List<Individual> getMembers(){
        return members;
    }
    
    /**
     * get a list of individuals that are members of this team and are also active
     * 
     * @return 
     */
    public List<Individual> getActiveMembers(){
        throw new UnsupportedOperationException("Not implemented.");
    }
        
    /**
     * get a list of individuals that are members of this team but are inactive
     * 
     * @return 
     */
    public List<Individual> getInactiveMembers(){
        throw new UnsupportedOperationException("Not implemented.");
    }
}
