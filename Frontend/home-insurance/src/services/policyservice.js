const axios = require('axios');
const AGENT_API_BASE_URL = "http://localhost:8081/springfox/hims/agent";

class PolicyService {
  getAll() {
    return axios.get(AGENT_API_BASE_URL+"/policies");
  }

  get(policyId) {
    return axios.get(AGENT_API_BASE_URL+`/policy/${policyId}`);
  }

  create(data) {
    console.log(data);
    return axios.post(AGENT_API_BASE_URL+"/policy", data);
  }

  update(data) {
    return axios.put(AGENT_API_BASE_URL+"/policy", data);
  }

  delete(policyId) {
    return axios.delete(AGENT_API_BASE_URL+`/policy/${policyId}`);
  }

  //   deleteAll() {
  //     return http.delete(`/tutorials`);
  //   }
  findById(policyId) {
    return axios.get(AGENT_API_BASE_URL+`/policy?id=${policyId}`);
  }
}

module.exports= new PolicyService();
