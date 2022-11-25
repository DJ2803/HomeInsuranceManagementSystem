const axios = require('axios');
const USER_API_BASE_URL = "http://localhost:8081/springfox/hims/user";

class UserService {


    createUser(user) {
        return axios.post(USER_API_BASE_URL + '/' + 'signup', user);
    }
    authenticate(userName, password) {
        return axios.post(USER_API_BASE_URL + '/' + 'login' + '/' + userName + '/' + password);
        // return axios.post( "http://localhost:8081/springfox/hims/user/user")
    }

}
export default new UserService()