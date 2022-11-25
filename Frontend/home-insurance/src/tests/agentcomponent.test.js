
const axios = require('axios');
// const agentservice = require('../services/agent.service');
const AGENT_API_BASE_URL = "http://localhost:8081/springfox/hims/agent";

//mocking entire axios module
jest.mock('axios');
describe("mock api calls", () => {
       test("get policyholder by idtest", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const agentservice = require('../services/agentservice');
              // act
              agentservice.getPolicyHolder(1);
              // asserts
              expect(axios.get).toHaveBeenCalled()
              expect(axios.get).toHaveBeenCalledWith(AGENT_API_BASE_URL + '/' + 'policyholder' + '/' + 1);

       })

       test("get all policyholder test", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const agentservice = require('../services/agentservice');
              // act
              agentservice.getAllPolicyHolders();
              // asserts
              expect(axios.get).toHaveBeenCalled()
              expect(axios.get).toHaveBeenCalledWith(AGENT_API_BASE_URL + '/policyholders');

       })

       test("get all quote test", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const quoteservice = require('../services/agentservice');
              // act
              quoteservice.getAllQuotes();
              // asserts
              expect(axios.get).toHaveBeenCalled()
              expect(axios.get).toHaveBeenCalledWith(AGENT_API_BASE_URL + '/quotes');

       })
      
       test("get quote by id test", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const quoteservice = require('../services/agentservice');
              // act
              quoteservice.getQuote(2)
              // asserts
              expect(axios.get).toHaveBeenCalled()
              expect(axios.get).toHaveBeenCalledWith(AGENT_API_BASE_URL + '/' + 'quote' + '/' + 2);


       })

       test("delete policyholder by id test", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const policyholderservice = require('../services/agentservice');
              // act
              policyholderservice.deletePolicyHolder(1);
              // asserts
              expect(axios.delete).toHaveBeenCalled()
              expect(axios.delete).toHaveBeenCalledWith(AGENT_API_BASE_URL + '/' + 'policyholder' + '/' + 1);
       })


       
       
       test("delete quote by id test", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const quoteservice = require('../services/agentservice');
              // act
              quoteservice.deleteQuote(1);
              // asserts
              expect(axios.delete).toHaveBeenCalled()
              expect(axios.delete).toHaveBeenCalledWith(AGENT_API_BASE_URL + '/' + 'quote' + '/' + 1);
       })


       test("post quote test", () => {

              // arrange
              const mockedResponse = { };
              axios.post.mockResolvedValue(mockedResponse);
              const quoteservice = require('../services/agentservice');
              // act
             var id;
             var quote;
              quoteservice.createQuote(id,quote)
              // asserts
              expect(axios.post).toHaveBeenCalled()
              expect(axios.post).toHaveBeenCalledWith(AGENT_API_BASE_URL+'/quote/'+id,quote);

       })


       // test("post policy test", () => {

       //        // arrange
       //        const mockedResponse = { };
       //        axios.post.mockResolvedValue(mockedResponse);
       //        const policyservice = require('../services/agentservice');
       //        // act
       //       var id;
       //       var policy;
       //        policyservice.addPolicy(id,policy)
       //        // asserts
       //        expect(axios.post).toHaveBeenCalled()
       //        expect(axios.post).toHaveBeenCalledWith(AGENT_API_BASE_URL+'/policy/'+policy);

       // })


       test("update quote test", () => {

              // arrange
              const mockedResponse = { };
              axios.put.mockResolvedValue(mockedResponse);
              const quoteservice = require('../services/agentservice');
              // act
              var quote;
              quoteservice.updateQuote(quote);
              // asserts
              expect(axios.put).toHaveBeenCalled()
              expect(axios.put).toHaveBeenCalledWith(AGENT_API_BASE_URL+'/quote',quote);

       })
})
