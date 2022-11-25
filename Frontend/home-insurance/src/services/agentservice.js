
const axios = require('axios');
const AGENT_API_BASE_URL = "http://localhost:8081/springfox/hims/agent";
class AgentService {
    getAllQuotes() {
      return axios.get(AGENT_API_BASE_URL+"/quotes");
    }
  
    getAllPolicyHolders() {
      return axios.get(AGENT_API_BASE_URL+"/policyholders");
    }
  
    getQuote(id) {
      return axios.get(AGENT_API_BASE_URL+`/quote/${id}`);
    }
  
    createQuote(data,id) {
      console.log(id);
      return axios.post(AGENT_API_BASE_URL+`/quote/${id}`, data);
    }
  
    updateQuote(data) {
      
      return axios.put(AGENT_API_BASE_URL+"/quote", data);
    }
  
    deleteQuote(id) {
      return axios.delete(AGENT_API_BASE_URL+`/quote/${id}`);
    }
  
    deletePolicyHolder(id) {
      return axios.delete(AGENT_API_BASE_URL+`/policyholder/${id}`);
    }
  
   
  
    getPolicyHolder(id) {
      return axios.get(AGENT_API_BASE_URL+`/policyholder/${id}`);
    }
  }
  
  module.exports= new AgentService();