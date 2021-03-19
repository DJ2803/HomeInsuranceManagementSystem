package com.cg.hims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.hims.entities.Agent;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.service.IAgentService;




@RestController
@RequestMapping("/agent")
public class AgentController {
	@Autowired
	private IAgentService agentService;

	@PostMapping("/addAgent")
	public ResponseEntity<Agent> addAgent(@RequestBody Agent agent) {
		try {
			Agent agt= agentService.addAgent(agent);
			return new ResponseEntity<>(agt, HttpStatus.OK);
		}catch(AgentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@PutMapping("/updateAgent")
	public ResponseEntity<Agent> updateAgent(@RequestBody Agent agent) {
		try {
			Agent agt= agentService.updateAgent(agent);
			return new ResponseEntity<>(agt, HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@DeleteMapping("/removeAgent/{agtId}")
	public ResponseEntity<String> removeAgent(@PathVariable Integer agtId) {
		try {
			agentService.removeAgent(agtId);
			return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@GetMapping("/findAgentById/{agtId}")
	public ResponseEntity<Agent> findAgentById(@PathVariable Integer agtId){
		try {
			Agent agent = agentService.findAgentById(agtId);
			return new ResponseEntity<>(agent, HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}

	@GetMapping("/viewAllAgents")
	public ResponseEntity<List<Agent>> viewAllAgents(){
		try {
			List<Agent> agentList = agentService.viewAllAgents();
			return new ResponseEntity<>(agentList, HttpStatus.OK);
		}catch(AgentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
