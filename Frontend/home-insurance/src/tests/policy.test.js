const axios = require('axios');
// const agentservice = require('../services/agent.service');
const AGENT_API_BASE_URL = "http://localhost:8081/springfox/hims/agent";
jest.mock('axios');
describe("mock api calls", () => {
test("get all policy test", () => {

    // arrange
    const mockedResponse = {};
    axios.get.mockResolvedValue(mockedResponse);
    const PolicyService = require('../services/policyservice');
    // act
    PolicyService.getAll();
    // asserts
    expect(axios.get).toHaveBeenCalled()
    expect(axios.get).toHaveBeenCalledWith(AGENT_API_BASE_URL + '/policies');

})


test("get policy by id test", () => {

    // arrange
    const mockedResponse = {};
    axios.get.mockResolvedValue(mockedResponse);
    const policyservice = require('../services/policyservice');
    // act
    policyservice.get(1);
    // asserts
    expect(axios.get).toHaveBeenCalled()
    expect(axios.get).toHaveBeenCalledWith(AGENT_API_BASE_URL + '/' + 'policy' + '/' + 1);


})

test("delete policy by id test", () => {

    // arrange
    const mockedResponse = {};
    axios.get.mockResolvedValue(mockedResponse);
    const policyservice = require('../services/policyservice');
    // act
    policyservice.delete(1);
    // asserts
    expect(axios.delete).toHaveBeenCalled()
    expect(axios.delete).toHaveBeenCalledWith(AGENT_API_BASE_URL + '/' + 'policy' + '/' + 1);
})

test("update policy test", () => {

    // arrange
    const mockedResponse = { };
    axios.put.mockResolvedValue(mockedResponse);
    const policyservice = require('../services/policyservice');
    // act
    var policy;
    policyservice.update(policy);
    // asserts
    expect(axios.put).toHaveBeenCalled()
    expect(axios.put).toHaveBeenCalledWith(AGENT_API_BASE_URL+'/policy',policy);

})



})