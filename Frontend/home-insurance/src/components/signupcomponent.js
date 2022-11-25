// import React, { Component } from "react";
// import UserService from '../services/UserService';
// export default class SignUp extends Component {
//     constructor(props) {
//         super(props);
//         this.state = {
//             userId: '',
//             firstName: '',
//             lastName: '',
//             userName: '',
//             password: '',
//             emailId: '',
//             contactNo: '',
//             address : '',
//             role: ''
//         }
//         this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
//         this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
//         this.changeUserNameHandler = this.changeUserNameHandler.bind(this);
//         this.changePasswordHandler = this.changePasswordHandler.bind(this);
//         this.changeEmailIdHandler = this.changeEmailIdHandler.bind(this);
//         this.changeContactNoHandler = this.changeContactNoHandler.bind(this);
//         this.changeAddressHandler=this.changeAddressHandler.bind(this);
//         this.changeRoleHandler = this.changeRoleHandler.bind(this);
//         this.saveUser = this.saveUser.bind(this);
//     }
//     saveUser = (e) => {
//         e.preventDefault();
//         // console.log(this.state)
//         let user = {
//             id: null, firstName: this.state.firstName, lastName: this.state.lastName,
//             userName: this.state.userName, password: this.state.password, emailId: this.state.emailId, contactNo: this.state.contactNo,address:this.state.address, role: this.state.role
//         };
//         console.log(JSON.stringify(user));
//         const {userName, password, userId}= this.state;
//         localStorage.setItem('username',userName);
//         localStorage.setItem('password',password);
//         localStorage.setItem('userid',userId);
//         UserService.createUser(user).then(res => {
//             this.props.history.push('/login');
//         })
//     }
//     cancel() {
//         this.props.history.push('/login');
//     }
//     changeFirstNameHandler = (event) => {
//         this.setState({ firstName: event.target.value });
//     }
//     changeLastNameHandler = (event) => {
//         this.setState({ lastName: event.target.value });
//     }
//     changeUserNameHandler = (event) => {
//         this.setState({ userName: event.target.value });
//     }
//     changePasswordHandler = (event) => {
//         this.setState({ password: event.target.value });

//     }
//     changeEmailIdHandler = (event) => {
//         this.setState({ emailId: event.target.value });
//     }
//     changeContactNoHandler = (event) => {
//         this.setState({ contactNo: event.target.value });
//     }
//     changeAddressHandler = (event) => {
//         this.setState({ address: event.target.value });
//     }
//     changeRoleHandler = (event) => {
//         this.setState({ role: event.target.value });
//     }

//     render() {
//         return (
//             <div>
//                 <div className="container">
//                     <div className="row">
//                         <div className="card col-md-6 offset-md-3 offset-md-3">
//                             <h3 className="text-center">Register</h3>
//                             <div className="card-body">
//                                 <form>

//                                     <div className="form-group">
//                                         <label>Enter First Name</label>
//                                         <input type ="text" placeholder=" First Name" name="firstName"
//                                             className="form-control"
//                                             value={this.state.firstName}
//                                             onChange={this.changeFirstNameHandler} />

//                                     </div>
//                                     <div className="form-group">
//                                         <label>Enter Last Name</label>
//                                         <input type ="text" placeholder=" Name" name="lastName"
//                                             className="form-control"
//                                             value={this.state.lastName}
//                                             onChange={this.changeLastNameHandler} />

//                                     </div>
//                                     <div className="form-group">
//                                         <label>Enter User Name</label>
//                                         <input  type ="text" placeholder="User Name" name="userName"
//                                             className="form-control"
//                                             value={this.state.userName}
//                                             onChange={this.changeUserNameHandler} />

//                                     </div>
//                                     <div className="form-group">
//                                         <label>Enter Password</label>
//                                         <input type ="password" placeholder="Password" name="password"
//                                             className="form-control"
//                                             value={this.state.password}
//                                             onChange={this.changePasswordHandler} />

//                                     </div>
//                                     <div className="form-group">
//                                         <label>Enter EmailId</label>
//                                         <input type ="email" placeholder="EmailId" name="emailId"
//                                             className="form-control"
//                                             value={this.state.emailId}
//                                             onChange={this.changeEmailIdHandler} />

//                                     </div>
//                                     <div className="form-group">
//                                         <label>Enter ContactNo</label>
//                                         <input placeholder="ContactNo" name="contactNo"
//                                             className="form-control"
//                                             value={this.state.contactNo}
//                                             onChange={this.changeContactNoHandler} />

//                                     </div>
//                                     <div className="form-group">
//                                         <label>Enter Address</label>
//                                         <input placeholder="Address" name="address"
//                                             className="form-control"
//                                             value={this.state.address}
//                                             onChange={this.changeAddressHandler} />

//                                     </div>
//                                     <div className="form-group">
//                                         <label>Enter Role</label>
//                                         <input type ="text" placeholder="Role" name="role"
//                                             className="form-control"
//                                             value={this.state.role}
//                                             onChange={this.changeRoleHandler} />

//                                     </div>
//                                     <button className="btn btn-success" onClick={this.saveUser}>Save</button>
//                                     <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
//                                     <p className="forgot-password text-right">
//                     Already registered <a href="/login">log in?</a>
//                 </p>
//                                 </form>
//                             </div>
//                         </div>
//                     </div>

//                 </div>
//             </div>
//         );
//     }
// }






import React, { Component } from "react";
import UserService from "../services/UserService";
const password_regExp = RegExp(
  /^.(?=.{6,})(?=.[a-zA-Z])(?=.\d)(?=.[!@#$%^]).$/
);
const contactno_regExp = RegExp(/^[0-9]{10}$/);
const email_regExp = RegExp(/\S+@\S+\.\S+/);
// const formValid = ({ isError, ...rest }) => {
//   let isValid1 = false;
//   let isValid2 = false;

//   var temp1 = 0;
//   Object.values(rest).forEach((val) => {
//     if (val.length === 0) {
//       isValid1 = false;
//     } else {
//       isValid1 = true;
//       temp1++;
//     }
//   });

//   var temp2 = 0;
//   Object.values(isError).forEach((val) => {
//     if (val.length > 0) {
//       isValid2 = false;
//     } else {
//       isValid2 = true;
//       temp2++;
//     }
//   });
//   if (isValid1 && temp1 >= 7 && isValid2 && temp2 >= 7) {
//     return true;
//   }
//   return false;
//   let isValid = false;

//   Object.values(isError).forEach((val) => {
//     if (val.length > 0) {
//       isValid = false;
//     } else {
//       isValid = true;
//     }
//   });

//   Object.values(rest).forEach((val) => {
//     if (val === null) {
//       isValid = false;
//     } else {
//       isValid = true;
//     }
//   });

//   return isValid;
//
//};
export default class SignUp extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userId: "",
      username: "",
      password: "",
      firstName: "",
      lastName: "",
      emailId: "",
      contactNo: "",
      address: "",
      userRole: "",
      successful: false,
      message: "",
      isError: {
        userId: "",
        username: "",
        password: "",
        firstName: "",
        lastName: "",
        emailId: "",
        contactNo: "",
        address: "",
      },
    };
    this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
    this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
    this.changeUserNameHandler = this.changeUserNameHandler.bind(this);
    this.changePasswordHandler = this.changePasswordHandler.bind(this);
    this.changeEmailIdHandler = this.changeEmailIdHandler.bind(this);
    this.changeContactNoHandler = this.changeContactNoHandler.bind(this);
    this.changeAddressHandler = this.changeAddressHandler.bind(this);
    this.changeRoleHandler = this.changeRoleHandler.bind(this);
    // this.onhandleRegister = this.onhandleRegister.bind(this);
    this.saveUser = this.saveUser.bind(this);
  }
  saveUser = (e) => {
    e.preventDefault();
    //this.form.validateAll();
    // console.log(this.state)

    let user = {
      id: null,
      //userName: this.state.userName,
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      userName: this.state.userName,
      password: this.state.password,
      emailId: this.state.emailId,
      address: this.state.address,
      contactNo: this.state.contactNo,
      role: this.state.role,
    };
    console.log(JSON.stringify(user));
    const { userName, password, userId } = this.state;
    UserService.createUser(user).then((res) => {
      if (res.data === "Username already exists") {
        alert("User Name already Exists");
      } else {
        alert("Registration Successful");
        this.props.history.push("/login");

      }
    });
  };
  cancel() {
    this.props.history.push("/login");
  }
  changeFirstNameHandler = (event) => {
    this.setState({ firstName: event.target.value });
  };
  changeLastNameHandler = (event) => {
    this.setState({ lastName: event.target.value });
  };
  changeUserNameHandler = (event) => {
    this.setState({ userName: event.target.value });
  };
  changePasswordHandler = (event) => {
    this.setState({ password: event.target.value });
  };
  changeEmailIdHandler = (event) => {
    this.setState({ emailId: event.target.value });
  };
  changeAddressHandler = (event) => {
    this.setState({ address: event.target.value });
  };
  changeContactNoHandler = (event) => {
    this.setState({ contactNo: event.target.value });
  };
  changeRoleHandler = (event) => {
    this.setState({ role: event.target.value });
  };
  // onhandleRegister(e) {
  //   e.preventDefault();
  //   this.form.validateAll();
  // }
  formValChange = (e) => {
    e.preventDefault();
    const { name, value } = e.target;
    let isError = { ...this.state.isError };
    switch (name) {
      case "userName":
        isError.username =
          value.length < 4 ? "Atleast 4 characaters required" : "";
        break;
      case "password":
        isError.password = value.length < 4 ? "Weak Password" : "";
        break;
      case "firstName":
        isError.firstName =
          value.length < 3 ? "Must be three characters or above" : "";
        break;
      case "lastName":
        isError.lastName =
          value.length < 3 ? "Must be three characters or above" : "";
        break;
      case "emailId":
        isError.emailId = email_regExp.test(value)
          ? ""
          : "Enter Correct E-Mail ID";
        break;
      case "contactNo":
        isError.contactNo = contactno_regExp.test(value)
          ? ""
          : "Contact Number must be 10 digits";
        break;
      case "address":
        isError.address = value.length < 4 ? "Enter the correct Address" : "";
        break;
      default:
        break;
    }
    this.setState({
      isError,
      [name]: value,
    });
  };
  render() {
    const { isError } = this.state;
    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <h3 className="text-center">Register</h3>

              <div className="card-body">
                <form>
                  <div className="form-group">
                    <div className="form-group">
                      <label>Enter User Name</label>
                      <input
                        type="text"
                        placeholder="User Name"
                        name="userName"
                        className={
                          isError.username.length > 0
                            ? "is-invalid form-control"
                            : "form-control"
                        }
                        value={this.state.userName}
                        onChange={
                          (this.changeUserNameHandler, this.formValChange)
                        }
                        //validations={[required, vusername]}
                      />
                      {isError.username.length > 0 && (
                        <span className="invalid-feedback">
                          {isError.username}
                        </span>
                      )}
                    </div>
                    <label>Enter First Name</label>
                    <input
                      type="text"
                      placeholder=" First Name"
                      name="firstName"
                      className={
                        isError.firstName.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.firstName}
                      onChange={
                        (this.changeFirstNameHandler, this.formValChange)
                      }
                      //validations={[required]}
                    />
                    {isError.firstName.length > 0 && (
                      <span className="invalid-feedback">
                        {isError.firstName}
                      </span>
                    )}
                  </div>
                  <div className="form-group">
                    <label>Enter Last Name</label>
                    <input
                      type="text"
                      placeholder="Last Name"
                      name="lastName"
                      className={
                        isError.lastName.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.lastName}
                      onChange={
                        (this.changeLastNameHandler, this.formValChange)
                      }
                      //validations={[required]}
                    />
                    {isError.lastName.length > 0 && (
                      <span className="invalid-feedback">
                        {isError.lastName}
                      </span>
                    )}
                  </div>

                  <div className="form-group">
                    <label>Enter Password</label>
                    <input
                      type="password"
                      placeholder="Password"
                      name="password"
                      className={
                        isError.password.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.password}
                      onChange={
                        (this.changePasswordHandler, this.formValChange)
                      }
                      //validations={[required, vpassword]}
                    />
                    {isError.password.length > 0 && (
                      <span className="invalid-feedback">
                        {isError.password}
                      </span>
                    )}
                  </div>
                  <div className="form-group">
                    <label>Enter EmailId</label>
                    <input
                      type="email"
                      placeholder="EmailId"
                      name="emailId"
                      className={
                        isError.emailId.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.emailId}
                      onChange={(this.changeEmailIdHandler, this.formValChange)}
                      //validations={[required, ValidEmail]}
                    />
                    {isError.emailId.length > 0 && (
                      <span className="invalid-feedback">
                        {isError.emailId}
                      </span>
                    )}
                  </div>
                  <div className="form-group">
                    <label>Enter Address</label>
                    <input
                      type="address"
                      placeholder="Address"
                      name="address"
                      className={
                        isError.address.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.address}
                      onChange={(this.changeAddressHandler, this.formValChange)}
                      //validations={[required]}
                    />
                    {isError.address.length > 0 && (
                      <span className="invalid-feedback">
                        {isError.address}
                      </span>
                    )}
                  </div>
                  <div className="form-group">
                    <label>Enter ContactNo</label>
                    <input
                      placeholder="ContactNo"
                      name="contactNo"
                      className={
                        isError.contactNo.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      value={this.state.contactNo}
                      onChange={
                        (this.changeContactNoHandler, this.formValChange)
                      }
                      //validations={[required, vcontactno]}
                    />
                    {isError.contactNo.length > 0 && (
                      <span className="invalid-feedback">
                        {isError.contactNo}
                      </span>
                    )}
                  </div>
                  {/* <div className="form-group">
                    <label>Enter Role</label>
                    <input
                      type="text"
                      placeholder="Role"
                      name="role"
                      className="form-control"
                      value={this.state.role}
                      onChange={this.changeRoleHandler}
                      //validations={[required]}
                    />
                  </div> */}

                  <div className="form-group">
                    Select Role:&nbsp;
                    <select
                      value={this.state.role}
                      onChange={this.changeRoleHandler}
                    >
                      <option>Select</option>
                      <option value="policyholder">PolicyHolder</option>
                      <option value="agent">Agent</option>
                      <option value="admin">Admin</option>
                    </select>
                  </div>

                  <button className="btn btn-success" onClick={this.saveUser}>
                    Save
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={this.cancel.bind(this)}
                    style={{ marginLeft: "10px" }}
                  >
                    Cancel
                  </button>
                  <p className="forgot-password text-right">
                    Already registered <a href="/login">log in?</a>
                  </p>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}














