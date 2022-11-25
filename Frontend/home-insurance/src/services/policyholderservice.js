const axios = require('axios');
const POLICYHOLDER_API_BASE_URL ="http://localhost:8081/springfox/hims/policyholder";

class PolicyHolderservice
{
    updatePolicyHolder(policyholder) {
        return axios.put(POLICYHOLDER_API_BASE_URL +'/'+'update' , policyholder);
    }
    getPolicyHolderById(policyHolderId) {
        return axios.get(POLICYHOLDER_API_BASE_URL + '/'+'view' +'/'+policyHolderId);
    }
    getPolicyHolderByUserName(userName) {
        return axios.get(POLICYHOLDER_API_BASE_URL + '/'+'viewing' +'/'+userName);
    }
    deletePolicyHolder(policyholderId) {
        return axios.delete(POLICYHOLDER_API_BASE_URL + '/' +'deletepolicyholder'+'/'+policyholderId);
    }
    getAllPolicyHolders(){
        return axios.get(POLICYHOLDER_API_BASE_URL+'/'+'getallpolicyholders');
    }
     viewPolicy(policyId)
     {
         return axios.get(POLICYHOLDER_API_BASE_URL +'/viewpolicy'+'/'+policyId)
     }
   
      selectquote(id,quote)
      {
          return axios.put(POLICYHOLDER_API_BASE_URL +'/selectquote'+'/'+id,quote)
      }
      selectpolicy(id,policy)
      {
          return axios.put(POLICYHOLDER_API_BASE_URL +'/selectpolicy'+'/'+id,policy)
      }
    addProperty(policyHolderId,property)
    {
        return axios.post(POLICYHOLDER_API_BASE_URL+'/addproperty'+'/'+policyHolderId,property);
    }
    viewProperty(propertyId)
    {
        return axios.get(POLICYHOLDER_API_BASE_URL+'/viewproperty/'+propertyId);
    }
    viewQuote(quoteId)
    {
        return axios.get(POLICYHOLDER_API_BASE_URL+'/viewquote/'+quoteId)
    }


}
module.exports= new PolicyHolderservice()