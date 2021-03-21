package com.cg.hims.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Transactions;
import com.cg.hims.entities.Admin;
import com.cg.hims.exceptions.AdminNotFoundException;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.exceptions.TransactionNotFoundException;
import com.cg.hims.repository.AdminRepository;
import com.cg.hims.repository.AgentRepository;
import com.cg.hims.repository.PolicyHolderRepository;
import com.cg.hims.repository.PolicyRepository;
import com.cg.hims.repository.TransactionRepository;
@Service
@Transactional
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AgentRepository iAgentRepository;
	@Autowired
	private PolicyHolderRepository iPolicyHolderRepository;
//	@Autowired
//	private ITransactionRepository iITransactionRepository;
	@Autowired
	private PolicyRepository iPolicyRepository;
	@Autowired
	private AdminRepository iAdminRepository;
	@Override
	public Agent addAgent(Agent agent) throws AgentException
	{
		try {			
			return iAgentRepository.save(agent);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentException(e.getMessage());
		}
		
	}

	@Override
	public Agent updateAgent(Agent agent) throws AgentNotFoundException
	{
		try {
			return iAgentRepository.save(agent);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}
		
		
		
	}

	@Override
	public void removeAgent(int agentId) throws AgentNotFoundException
	{
		try {
			iAgentRepository.deleteById(agentId);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}
	}

	@Override
	public Agent findAgentById(int agentId) throws AgentNotFoundException
	{
		try {
			Optional<Agent> optional= iAgentRepository.findById(agentId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Agentno");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Agent> viewAllAgents() throws AgentException
	{
		try {
			return iAgentRepository.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException {
		try {			
			return iPolicyHolderRepository.save(policyHolder);
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException {
		try {			
			return iPolicyHolderRepository.save(policyHolder);
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public void deletePolicyHolder(Integer policyHolderId) throws PolicyHolderNotFoundException {
		try {			
			iPolicyHolderRepository.deleteById(policyHolderId);
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder getPolicyHolderById(Integer policyHolderId) throws PolicyHolderNotFoundException {
		try {
			Optional<PolicyHolder> optional=iPolicyHolderRepository.findById(policyHolderId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid PolicyHolder Id");
			}
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<PolicyHolder> getAllPolicyHolders() throws PolicyHolderNotFoundException {
		try {			
			return iPolicyHolderRepository.findAll();
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}
//
//	@Override
//	public List<Transactions> getAllTransactions() throws TransactionNotFoundException {
//		try {	
//			return iITransactionRepository.findAll();
//		}catch(DataAccessException e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}catch(Exception e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}
//	}
//
//	@Override
//	public List<Transactions> getAllTransactionsByPolicyHolderId(Integer policyHolderId) throws TransactionNotFoundException {
//		try {			
//			List<Transactions> Tlist=iITransactionRepository.findAll().stream().filter(e->e.getPolicyHolderId()==policyHolderId).collect(Collectors.toList());
//			return Tlist;
//		}catch(DataAccessException e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}catch(Exception e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}
//	}
//
//	@Override
//	public List<Transactions> getAllTransactionsByPolicyId(Integer policyId) throws TransactionNotFoundException {
//		try {			
//			List<Transactions> Tlist=iITransactionRepository.findAll().stream().filter(e->e.getPolicyId()==policyId).collect(Collectors.toList());
//			return Tlist;
//		}catch(DataAccessException e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}catch(Exception e) {
//			throw new TransactionNotFoundException(e.getMessage());
//		}
//	}
//
	@Override
	public Policy addPolicy(Policy policy) throws PolicyNotFoundException {
		try {			
			return iPolicyRepository.save(policy);
		}catch(DataAccessException e) {
			
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException {
		try {			
			return iPolicyRepository.save(policy);
		}catch(DataAccessException e) {
			
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public void deletePolicy(Integer policyId) throws PolicyNotFoundException {
		try {
			iPolicyRepository.deleteById(policyId);
		}catch(DataAccessException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public Policy getPolicyById(Integer policyId) throws PolicyNotFoundException {
		try {
			Optional<Policy> optional= iPolicyRepository.findById(policyId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new PolicyNotFoundException("Invalid Policy Id");
			}
		}catch(DataAccessException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Policy> getAllPolicies() throws PolicyNotFoundException {
		try {
			return iPolicyRepository.findAll();
		}catch(DataAccessException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyNotFoundException(e.getMessage());
		}
		}

	@Override
	public Admin addAdmin(Admin admin) throws AdminNotFoundException {
		try {			
			return iAdminRepository.save(admin);
		}catch(DataAccessException e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {
		try {			
			return iAdminRepository.save(admin);
		}catch(DataAccessException e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}
	}

	@Override
	public void deleteAdmin(Integer adminId) throws AdminNotFoundException {
		try {
			iAdminRepository.deleteById(adminId);
		}catch(DataAccessException e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public Admin getAdminById(Integer adminId) throws AdminNotFoundException {
		try {
			Optional<Admin> optional= iAdminRepository.findById(adminId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new AdminNotFoundException("Invalid Admin Id");
			}
		}catch(DataAccessException e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Admin> getAllAdmins() throws AdminNotFoundException {
		try {
			return iAdminRepository.findAll();
		}catch(DataAccessException e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new AdminNotFoundException(e.getMessage());
		}
	}
}


