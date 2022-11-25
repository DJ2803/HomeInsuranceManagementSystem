const axios = require('axios');
const ADMIN_API_BASE_URL = "http://localhost:8081/springfox/hims/admin";

jest.mock('axios');
describe("mock api calls", () => {
       test("get all agents test", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const adminservice = require('../services/adminservice');
              // act
              adminservice.getAllAgents();
              // asserts
              expect(axios.get).toHaveBeenCalled()
              expect(axios.get).toHaveBeenCalledWith(ADMIN_API_BASE_URL  + '/' + 'agents');

       })

       test("get all policyholders test", () => {

        // arrange
        const mockedResponse = {};
        axios.get.mockResolvedValue(mockedResponse);
        const adminservice = require('../services/adminservice');
        // act
        adminservice.getAllPolicyHolder();
        // asserts
        expect(axios.get).toHaveBeenCalled()
        expect(axios.get).toHaveBeenCalledWith(ADMIN_API_BASE_URL  + '/' + 'policyholders');

 })
 test("get  agent by id test", () => {

    // arrange
    const mockedResponse = {};
    axios.get.mockResolvedValue(mockedResponse);
    const adminservice = require('../services/adminservice');
    // act
    adminservice.getAgent(1);
    // asserts
    expect(axios.get).toHaveBeenCalled()
    expect(axios.get).toHaveBeenCalledWith(ADMIN_API_BASE_URL  + '/' + 'agent/'+1);

})

test("get  agent by id test", () => {

    // arrange
    const mockedResponse = {};
    axios.get.mockResolvedValue(mockedResponse);
    const adminservice = require('../services/adminservice');
    // act
    adminservice.getAgent(1);
    // asserts
    expect(axios.get).toHaveBeenCalled()
    expect(axios.get).toHaveBeenCalledWith(ADMIN_API_BASE_URL  + '/' + 'agent/'+1);

})
test("update agent test", () => {

    // arrange
    const mockedResponse = {};
    axios.put.mockResolvedValue(mockedResponse);
    const adminservice = require('../services/adminservice');
    // act
    var agent;
    adminservice.updateAgent(agent);
    // asserts
    expect(axios.put).toHaveBeenCalled()
    expect(axios.put).toHaveBeenCalledWith(ADMIN_API_BASE_URL  + '/' + 'agent',agent);

})
test("delete  agent by id test", () => {

    // arrange
    const mockedResponse = {};
    axios.delete.mockResolvedValue(mockedResponse);
    const adminservice = require('../services/adminservice');
    // act
    adminservice.deleteAgent(1);
    // asserts
    expect(axios.delete).toHaveBeenCalled()
    expect(axios.delete).toHaveBeenCalledWith(ADMIN_API_BASE_URL  + '/' + 'agent/'+1);

})
test("delete  policyholder by id test", () => {

    // arrange
    const mockedResponse = {};
    axios.delete.mockResolvedValue(mockedResponse);
    const adminservice = require('../services/adminservice');
    // act
    adminservice.deletePolicyHolder(1);
    // asserts
    expect(axios.delete).toHaveBeenCalled()
    expect(axios.delete).toHaveBeenCalledWith(ADMIN_API_BASE_URL  + '/' + 'policyholder/'+1);

})
test("get policyholder by id test", () => {

    // arrange
    const mockedResponse = {};
    axios.get.mockResolvedValue(mockedResponse);
    const adminservice = require('../services/adminservice');
    // act
    adminservice.getPolicyHolder(1);
    // asserts
    expect(axios.get).toHaveBeenCalled()
    expect(axios.get).toHaveBeenCalledWith(ADMIN_API_BASE_URL  + '/' + 'policyholder/'+1);

})




    })
