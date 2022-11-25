import React, { Component } from "react";
import UserService from '../services/UserService';
//import signupcomponent from './components/signupcomponent';
export default class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: '',
            password: '',
        }
        this.LoginHandler = this.LoginHandler.bind(this);
        this.changeUserNameHandler = this.changeUserNameHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
    }
    LoginHandler = (e) => {
        e.preventDefault();
        // console.log(this.state)
        let userName,password;
        [userName,password]=[this.state.userName,this.state.password];
        localStorage.setItem("username", userName);
        localStorage.setItem("password", password);
        //console.log(JSON.stringify(user));

    
        UserService.authenticate(userName,password).then(res => {
            //this.props.history.push('/policyholders');
           if( res.data==="policyholder Login Successful")
           {
            this.props.history.push(`/view-policyholder/${this.state.userName}`);
           }
           else if (res.data==="agent Login Successful")
           {
               this.props.history.push('/agent')
            }
            else if(res.data==="admin Login Successful")
            {
                this.props.history.push('/admin')
            }
            else{
                this.props.history.push('/signup')
            }
        })
    }
    changeUserNameHandler = (event) => {
        this.setState({ userName: event.target.value });
    }
    changePasswordHandler = (event) => {
        this.setState({ password: event.target.value });

    }
    

  render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Login</h3>
                            <div className="card-body">
                                <form>

                                    <div className="form-group">
                                        <label>Enter User Name</label>
                                        <input  type="text" placeholder="User Name" name="userName"
                                            className="form-control"
                                            value={this.state.userName}
                                            onChange={this.changeUserNameHandler} />

                                    </div>
                                    <div className="form-group">
                                        <label>Enter Password</label>
                                        <input type="password" placeholder="Password" name="password"
                                            className="form-control"
                                            value={this.state.password}
                                            onChange={this.changePasswordHandler} />

                                    </div>
                                    <button className="btn btn-success" onClick={this.LoginHandler}>Login</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}


