
const axios = require('axios');
const policyholderservice = require('../services/policyholderservice');
const POLICYHOLDER_API_BASE_URL = "http://localhost:8081/springfox/hims/policyholder";
//mocking entire axios module
jest.mock('axios');
describe("mock api calls", () => {
       test("get policyholder by idtest", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const policyholderservice = require('../services/policyholderservice');
              // act
              policyholderservice.getPolicyHolderById(1);
              // asserts
              expect(axios.get).toHaveBeenCalled()
              expect(axios.get).toHaveBeenCalledWith(POLICYHOLDER_API_BASE_URL + '/' + 'view' + '/' + 1);

       })

       test("get all policyholder test", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const policyholderservice = require('../services/policyholderservice');
              // act
              policyholderservice.getAllPolicyHolders();
              // asserts
              expect(axios.get).toHaveBeenCalled()
              expect(axios.get).toHaveBeenCalledWith(POLICYHOLDER_API_BASE_URL + '/getallpolicyholders');

       })
       test("get property by idtest", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const policyholderservice = require('../services/policyholderservice');
              // act
              policyholderservice.viewProperty(33);
              // asserts
              expect(axios.get).toHaveBeenCalled()
              expect(axios.get).toHaveBeenCalledWith(POLICYHOLDER_API_BASE_URL + '/' + 'viewproperty' + '/' + 33);

       })


       test("get policy by idtest", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const policyholderservice = require('../services/policyholderservice');
              // act
              policyholderservice.viewPolicy(1)
              // asserts
              expect(axios.get).toHaveBeenCalled()
              expect(axios.get).toHaveBeenCalledWith(POLICYHOLDER_API_BASE_URL + '/' + 'viewpolicy' + '/' + 1);


       })


       test("get quote by idtest", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const policyholderservice = require('../services/policyholderservice');
              // act
              policyholderservice.viewQuote(2)
              // asserts
              expect(axios.get).toHaveBeenCalled()
              expect(axios.get).toHaveBeenCalledWith(POLICYHOLDER_API_BASE_URL + '/' + 'viewquote' + '/' + 2);


       })

       test("delete policyholder by idtest", () => {

              // arrange
              const mockedResponse = {};
              axios.get.mockResolvedValue(mockedResponse);
              const policyholderservice = require('../services/policyholderservice');
              // act
              policyholderservice.deletePolicyHolder(1);
              // asserts
              expect(axios.delete).toHaveBeenCalled()
              expect(axios.delete).toHaveBeenCalledWith(POLICYHOLDER_API_BASE_URL + '/' + 'deletepolicyholder' + '/' + 1);
       })



       test("post employee test", () => {

              // arrange
              const mockedResponse = {};
              axios.post.mockResolvedValue(mockedResponse);
              const policyholderservice = require('../services/policyholderservice');
              // act
              var id;
              var property;
              policyholderservice.addProperty(id, property)
              // asserts
              expect(axios.post).toHaveBeenCalled()
              expect(axios.post).toHaveBeenCalledWith(POLICYHOLDER_API_BASE_URL + '/addproperty/' + id, property);

       })


       test("post property test", () => {

              // arrange
              const mockedResponse = {};
              axios.post.mockResolvedValue(mockedResponse);
              const policyholderservice = require('../services/policyholderservice');
              // act
              var id;
              var property;
              policyholderservice.addProperty(id, property)
              // asserts
              expect(axios.post).toHaveBeenCalled()
              expect(axios.post).toHaveBeenCalledWith(POLICYHOLDER_API_BASE_URL + '/addproperty/' + id, property);

       })

       test("update policyholder test", () => {

              // arrange
              const mockedResponse = {};
              axios.put.mockResolvedValue(mockedResponse);
              const policyholderservice = require('../services/policyholderservice');
              // act
              var policyholder;
              policyholderservice.updatePolicyHolder(policyholder);
              // asserts
              expect(axios.put).toHaveBeenCalled()
              expect(axios.put).toHaveBeenCalledWith(POLICYHOLDER_API_BASE_URL + '/update', policyholder);

       })
})
