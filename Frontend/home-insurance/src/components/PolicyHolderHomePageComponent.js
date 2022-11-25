
import "../App.css";
import React, { Component } from "react";
import PolicyHolderService from "../services/policyholderservice";
import "../styles/PolicyHolderHomePageComponent.css";
// import { useHistory, Link } from "react-router-dom";
// const PolicyHolderHome = () => {
//     const history = useHistory();
//     const handleClick = () => history.push("/view-policyholder/:policyHolderId");
//     return (
//         <div className="ScrollStyle">
//             <div className="heading">
//                 PolicyHolders
//             </div>
//             <div>
//                 <button
//                     className="buttonforview"
//                     onClick={handleClick}>Click Here to View</button>
//             </div>
//             <div>
//                 <Link to={"/login"} className="nav-link">
//                     <button className="buttonforlogout">Logout</button>
//                 </Link>
//             </div>
//             <div className="image">
//                 <img src="./image/user logo.png" alt=""/>
//             </div>
//         </div>
//     );
// };

// export default PolicyHolderHome;


class PolicyHolderHome extends Component {
    constructor(props) {
        super(props)
        this.state =
        {
            userName:""
        }
        this.changeusername = this.changeusername.bind(this);
        this.handleClick=this.handleClick.bind(this);

    }
    // handleClick = () => history.push("/view-policyholder/");
    handleClick=(e)=>
    {
       e.preventDefault();
       let userName;
       [userName]=[this.state.userName];
       PolicyHolderService.getPolicyHolderByUserName(userName).then(res=>
        {
            this.props.history.push(`/view-policyholder/${userName}`)
        })
    }
    changeusername = (event) => {
        this.setState({ userName: event.target.value });
    }
    render() {
        return (
            <div className="ScrollStyle">
                <div className="heading">
                    PolicyHolders
            </div>
                <form>
                    <div className="form-group">
                        <label>
                            Enter UserName
                    </label>
                        <input placeholder="user Name" name="userName"
                            value={this.state.userName}
                            onChange={this.changeusername} />
                        <div>
                            <button
                                className="buttonforview"
                                onClick={this.handleClick}>Click Here to View</button>
                        </div>
                    </div>
                </form>
                <div className="image">
                    <img src="./image/user logo.png" alt="" />
                </div>
            </div>
        )
    }
}
export default PolicyHolderHome;


// {
// let str4="home/home1/prahul";
// let str5;
// for(let i=str4.length-1;i>=0;i--)
// {
//     if(str4[i]!="/")
//     {
//        str5+=str4[i];
//     }
//     else
//     {
//         break;
//     }
    
// }
// let str6=str5.split('').reverse().join('')
// console.log(str6);
// }