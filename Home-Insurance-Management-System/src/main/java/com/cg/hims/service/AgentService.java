package com.cg.hims.service;

import java.util.List;

import com.cg.hims.entities.Agent;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;

public interface AgentService {

	public Agent addAgent(Agent agent) throws AgentException;

	public Agent updateAgent(Agent agent) throws AgentNotFoundException;

	public void removeAgent(int agentId) throws AgentNotFoundException;

	public Agent findAgentById(int agentId) throws AgentNotFoundException;

	public List<Agent> viewAllAgents()throws AgentException;
}
