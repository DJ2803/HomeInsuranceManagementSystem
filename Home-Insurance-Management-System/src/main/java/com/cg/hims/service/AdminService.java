package com.cg.hims.service;
import java.util.List;

import com.cg.hims.entities.Admin;
import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Transactions;
import com.cg.hims.exceptions.AdminNotFoundException;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.exceptions.TransactionNotFoundException;
public interface AdminService 
{
	public Agent addAgent(Agent agent) throws AgentException;

	public Agent updateAgent(Agent agent) throws AgentNotFoundException;

    public void removeAgent(int agentId) throws AgentNotFoundException;

	public Agent findAgentById(int agentId) throws AgentNotFoundException;

	public List<Agent> viewAllAgents()throws AgentException;
	
	PolicyHolder addPolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;
	PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;
	void deletePolicyHolder(Integer policyHolderId) throws PolicyHolderNotFoundException;
	PolicyHolder getPolicyHolderById(Integer policyHolderId) throws PolicyHolderNotFoundException;
	List<PolicyHolder> getAllPolicyHolders() throws PolicyHolderNotFoundException;
//	List<Transactions> getAllTransactions() throws TransactionNotFoundException;
//	List<Transactions> getAllTransactionsByPolicyHolderId(Integer policyHolderId) throws TransactionNotFoundException;
//	List<Transactions> getAllTransactionsByPolicyId(Integer policyId) throws TransactionNotFoundException;
	Policy addPolicy(Policy policy) throws PolicyNotFoundException;
	Policy updatePolicy(Policy policy) throws PolicyNotFoundException;
	void deletePolicy(Integer policyId) throws PolicyNotFoundException;
	Policy getPolicyById(Integer policyId) throws PolicyNotFoundException;
	List<Policy> getAllPolicies() throws PolicyNotFoundException;
	Admin addAdmin(Admin admin) throws AdminNotFoundException;
	Admin updateAdmin(Admin admin) throws AdminNotFoundException;
	void deleteAdmin(Integer adminId) throws AdminNotFoundException;
	Admin getAdminById(Integer adminId) throws AdminNotFoundException;
	List<Admin> getAllAdmins() throws AdminNotFoundException;
}
