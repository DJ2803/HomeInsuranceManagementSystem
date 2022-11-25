const axios = require('axios');
const ADMIN_API_BASE_URL = "http://localhost:8081/springfox/hims/admin";
class adminservice {
  getAllAgents() {
    return axios.get(ADMIN_API_BASE_URL+"/agents");
  }

  getAllPolicyHolder() {
    return axios.get(ADMIN_API_BASE_URL+"/policyholders");
  }

  getAgent(id) {
    return axios.get(ADMIN_API_BASE_URL+`/agent/${id}`);
  }

  // createQuote(data) {
  //   return http.post("/agent/addquote", data);
  // }

  updateAgent(data) {
    return axios.put(ADMIN_API_BASE_URL+`/agent`, data);
  }

  deleteAgent(id) {
    return axios.delete(ADMIN_API_BASE_URL+`/agent/${id}`);
  }

  deletePolicyHolder(id) {
    return axios.delete(ADMIN_API_BASE_URL+`/policyholder/${id}`);
  }

 

  getPolicyHolder(id) {
    return axios.get(ADMIN_API_BASE_URL+`/policyholder/${id}`);
  }
}

module.exports= new adminservice();