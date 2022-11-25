
// import React, { Component } from "react";
// import PolicyHolderService from "../services/policyholderservice";
// import ViewPolicyComponent from './ViewPolicyComponent';
// import ViewQuoteComponent from './ViewQuoteComponent'
// //import { Link } from "react-router-dom";
// import {
//   BrowserRouter as Router,
//   Link,
//   useLocation
// } from "react-router-dom";
// import ViewPropertyComponent from "./ViewPropertyComponent";
// // function useQuery() {
// //   console.log(useLocation().search);
// //   return new URLSearchParams(useLocation().search);
// // }

// export default class PolicyHolderComponent extends Component {
//   constructor(props) {
//     super(props);
//     this.onChangeSearchId = this.onChangeSearchId.bind(this);
//     this.retrievePolicyHolders = this.retrievePolicyHolders.bind(this);
//     this.refreshList = this.refreshList.bind(this);
//     this.setActivePolicyHolder = this.setActivePolicyHolder.bind(this);
//     // this.removeAllTutorials = this.removeAllTutorials.bind(this);
//     this.searchId = this.searchId.bind(this);
//     this.deletePolicyHolder = this.deletePolicyHolder.bind(this);

//     // let query = useQuery();
//     // console.log(query.get("name"));
//     // console.log(query);
  
//     this.state = {
//       policyholders: [],
//       currentPolicyHolder: null,
//       cPolicyHolder: null,
//       currentIndex: -1,
//       searchId: "",
//     };
//   }

//   componentDidMount() {
//     this.retrievePolicyHolders();
//     // this.get();
//   }


//   onChangeSearchId(e) {
//     const searchId = e.target.value;

//     this.setState({
//       searchId: searchId,
//     });
//   }
//   deletePolicyHolder() {
//     PolicyHolderService.deletePolicyHolder(this.state.currentPolicyHolder.policyHolderId)
//       .then((response) => {
//         console.log(response.data);
//         this.props.history.push("/policyholders");
//       })
//       .catch((e) => {
//         console.log(e);
//       });
//   }

//   retrievePolicyHolders() {
//     PolicyHolderService.getAllPolicyHolders()
//       .then((response) => {
//         this.setState({
//           policyholders: response.data,
//         });
//         console.log(response.data);
//         console.log(response.data.property);
//       })
//       .catch((e) => {
//         console.log(e);
//       });
//   }

//   refreshList() {
//     this.retrievePolicyHolders();
//     this.setState({
//       currentPolicyHolder: null,
//       currentIndex: -1,

//     });
//   }

//   setActivePolicyHolder(policyholder, index) {
//     this.setState({
//       currentPolicyHolder: policyholder,
//       currentIndex: index,
//     });
//   }

//   //   removeAllTutorials() {
//   //     TutorialDataService.deleteAll()
//   //       .then((response) => {
//   //         console.log(response.data);
//   //         this.refreshList();
//   //       })
//   //       .catch((e) => {
//   //         console.log(e);
//   //       });
//   //   }


//   searchId() {
//     this.setState({
//       currentPolicyHolder: null,
//       currentIndex: -1,
//     });
//     PolicyHolderService.getPolicyHolderById(this.state.searchId)
//       .then((response) => {
//         this.setState({
//           // cAgent: response.data,
//           policyholders: [response.data],
//         });
//         console.log(response.data);
//       })
//       .catch((e) => {
//         console.log(e);
//       });
//   }

//   render() {
//     const { searchId, policyholders, currentPolicyHolder, currentIndex, cPolicyHolder } = this.state;
//     return (
//       <div className="list row">
//         <div className="col-md-8">
//           <div className="input-group mb-3">
//             <input
//               type="text"
//               className="form-control"
//               placeholder="Search by ID"
//               value={searchId}
//               onChange={this.onChangeSearchId}
//             />
//             <div className="input-group-append">
//               <button
//                 className="btn btn-outline-secondary"
//                 type="button"
//                 onClick={this.searchId}
//               >
//                 Search
//               </button>
//             </div>
//           </div>
//         </div>
//         <div className="col-md-6">
//           <h4>PolicyHolders List</h4>

//           <ul className="list-group">
//             {policyholders &&
//               policyholders.map((policyholder, index) => (
//                 <li
//                   className={
//                     "list-group-item " +
//                     (index === currentIndex ? "active" : "")
//                   }
//                   onClick={() => this.setActivePolicyHolder(policyholder, index)}
//                   key={index}
//                 >
//                   {policyholder.policyHolderId}
//                   {"-"}
//                   {policyholder.policyHolderName}
//                 </li>
//               ))}
//           </ul>

//           {/* <button
//             className="m-3 btn btn-sm btn-danger"
//             onClick={this.removeAllTutorials}
//           >
//             Remove All
//           </button> */}
//         </div>
//         <div className="col-md-6">
//           {currentPolicyHolder ? (
//             <div>
//               <h4>PolicyHolder</h4>
//               <div>
//                 <label>
//                   <strong>ID:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.policyHolderId}
//               </div>
//               <div>
//                 <label>
//                   <strong>Name:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.policyHolderName}
//               </div>
//               <div>
//                 <label>
//                   <strong>CreditCard:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.creditCard}
//               </div>
//               <div>
//                 <label>
//                   <strong>Date Of Birth</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.dob}
//               </div>
//               <div>
//                 <label>
//                   <strong>Occupation</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.occupation}
//               </div>
//               <div>
//                 <label>
//                   <strong>AnnualIncome</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.annualIncome}
//               </div>
//               <div>
//                 <label>
//                   <strong>ResidenceType</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.residenceType}
//               </div>
//               <div>
//                 <label>
//                   <strong>City</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.city}
//               </div>
//               <div>
//                 <label>
//                   <strong>State</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.state}
//               </div>
//               <div>
//                 <label>
//                   <strong>Zip Code</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.zip}
//               </div>
//               <div>
//                 <label>
//                   <strong>Residence Use</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.residenceUse}
//               </div>
//               {/* <div>
//                 <label>
//                   <strong>Username:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.user.userName}
//               </div> */}
//               {/* <div>
//                 <label>
//                   <strong>Password:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.user.password}
//               </div> */}
//               <div>
//                 <label>
//                   <strong>First Name:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.user.firstName}
//               </div>
//               <div>
//                 <label>
//                   <strong>Last Name:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.user.lastName}
//               </div>
//               <div>
//                 <label>
//                   <strong>Email ID:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.user.emailId}
//               </div>
//               <div>
//                 <label>
//                   <strong>Contact No.:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.user.contactNo}
//               </div>
//               <div>
//                 <label>
//                   <strong>Address:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.user.address}
//               </div>
//               {/* <div>
//                   <h2>Property Details</h2>
//               </div>
//               <div>
//                 <label>
//                   <strong>Market Value:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.property.marketValue}
//               </div>
//               <div>
//                 <label>
//                   <strong>Year Built:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.property.yearBuilt}
//               </div>
//               <div>
//                 <label>
//                   <strong>Square Footage:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.property.squareFootage}
//               </div> */}
//               {/* <div>
//                 <label>
//                   <strong>Has Swimming Pool:</strong>
//                 </label>{" "}
//                 {currentPolicyHolder.property.hasSwimmingPool}
//               </div> */}

//               <Link
//                 to={"/update-policyholder/" + currentPolicyHolder.policyHolderId}
//                 className="badge badge-pill badge-success"
//               >
//                 Edit
//               </Link>
//               {/* <Link
//                 to={`/view-property/?name=${currentPolicyHolder.property.propertyId}` }
//                 className="badge badge-pill badge-success"
//               >
//                 View Property
//               </Link> */}
              
              
//             <button
//               className="badge badge-danger mr-2"
//               onClick={this.deletePolicyHolder}
//             >
//               Delete
//             </button>
//             {/* <button
//               className="badge badge-danger mr-2"
//               onClick={()=>{this.props.history.push(`/view-property/${currentPolicyHolder.property.propertyId}`)}}
//             >
//               View
//             </button> */}
           
//             {/* <div><h2 style={{textAlign:"center"}}>Add Property</h2></div>
//             <div> */}
//             <div>
//         <ViewPropertyComponent propertyId={currentPolicyHolder.property.propertyId} />
//       </div>
//       <div>
//         <ViewPolicyComponent policyId={currentPolicyHolder.policy.policyId} />
//       </div>
//       <div>
//         <ViewQuoteComponent quoteId={currentPolicyHolder.quote.quoteId} />
//       </div>

            
           

//             </div>
//           ) : (
//             <div>
//               <br />
//               <p>Please click on a PolicyHolder...</p>
//             </div>
//           )}
//         </div>
//       </div>
//     );
//   }
// }
import React, { Component } from "react";
import "../Main.css";
import '../styles/PolicyHolderComponent.css'
import PolicyHolderService from "../services/policyholderservice";
import { Link } from "react-router-dom";
import ViewPropertyComponent from "./ViewPropertyComponent"
import ViewPolicyComponent from './ViewPolicyComponent';
import ViewQuoteComponent from './ViewQuoteComponent'
export default class PolicyHolderComponent extends Component {
    constructor(props) {
        super(props);
        this.onChangeSearchId = this.onChangeSearchId.bind(this);
        this.retrievePolicyHolders = this.retrievePolicyHolders.bind(this);
        this.refreshList = this.refreshList.bind(this);
        this.setActivePolicyHolder = this.setActivePolicyHolder.bind(this);
        // this.removeAllTutorials = this.removeAllTutorials.bind(this);
        this.searchId = this.searchId.bind(this);
        this.deletePolicyHolder = this.deletePolicyHolder.bind(this);
        this.viewPropertyDetails = this.viewPropertyDetails.bind(this);

        this.state = {
            policyholders: [],
            currentPolicyHolder: null,
            cPolicyHolder: null,
            currentIndex: -1,
            searchId: "",
        };
    }

    componentDidMount() {
        this.retrievePolicyHolders();
        // this.get();
    }

    onChangeSearchId(e) {
        const searchId = e.target.value;

        this.setState({
            searchId: searchId,
        });
    }
    deletePolicyHolder() {
        PolicyHolderService.deletePolicyHolder(this.state.currentPolicyHolder.policyHolderId)
            .then((response) => {
                console.log(response.data.property);
                console.log(response.data);
                this.props.history.push("/policyholders");
            })
            .catch((e) => {
                console.log(e);
            });
    }

    viewPropertyDetails() {
        <ViewPropertyComponent propertyId={this.state.currentPolicyHolder.property.propertyId} />
    }
    retrievePolicyHolders() {
        PolicyHolderService.getAllPolicyHolders()
            .then((response) => {
                this.setState({
                    policyholders: response.data,
                });
                console.log(response.data);
            })
            .catch((e) => {
                console.log(e);
            });
    }

    refreshList() {
        this.retrievePolicyHolders();
        this.setState({
            currentPolicyHolder: null,
            currentIndex: -1,
        });
    }

    setActivePolicyHolder(policyholder, index) {
        this.setState({
            currentPolicyHolder: policyholder,
            currentIndex: index,
        });
    }

    //   removeAllTutorials() {
    //     TutorialDataService.deleteAll()
    //       .then((response) => {
    //         console.log(response.data);
    //         this.refreshList();
    //       })
    //       .catch((e) => {
    //         console.log(e);
    //       });
    //   }

    searchId() {
        this.setState({
            currentPolicyHolder: null,
            currentIndex: -1,
        });
        PolicyHolderService.getPolicyHolderById(this.state.searchId)
            .then((response) => {
                this.setState({
                    // cAgent: response.data,
                    policyholders: [response.data],
                });
                console.log(response.data);
            })
            .catch((e) => {
                console.log(e);
            });
    }

    render() {
        const { searchId, policyholders, currentPolicyHolder, currentIndex, cPolicyHolder } = this.state;

        return (
            <div>
                <div className="ScrollStyle">
                    <div className="list column">
                        <div className="search">
                            <div className="input-group mb-3">
                                <img src="./image/user logo.png" alt="" />
                                <input
                                    type="text"
                                    className="form-control"
                                    placeholder="Search by ID"
                                    value={searchId}
                                    onChange={this.onChangeSearchId}
                                />
                                <div>
                                    <button
                                        className="searchbutton"
                                        type="button"
                                        onClick={this.searchId}
                                    >
                                        Search
                                </button>
                                </div>
                                <div>
                                    <Link to={"/login"} className="nav-link">
                                        <button className="buttonlogout">Logout</button>
                                    </Link>
                                </div>
                            </div>
                        </div>
                        <div className="outer">
                            <div className="row-1">
                                <div className="row-1-left">
                                    <h4>PolicyHolders List</h4>
                                    <ul className="list-group">
                                        {policyholders &&
                                            policyholders.map((policyholder, index) => (
                                                <li
                                                    className={
                                                        "list-group-item " +
                                                        (index === currentIndex ? "active" : "")
                                                    }
                                                    onClick={() => this.setActivePolicyHolder(policyholder, index)}
                                                    key={index}
                                                >
                                                    {policyholder.policyHolderId}
                                                    {"-"}
                                                    {policyholder.policyHolderName}
                                                </li>
                                            ))}
                                    </ul>
                                </div>
                                {currentPolicyHolder ? (
                                    <div>
                                        <div className="row-1-right">
                                            <h4 style={{ textAlign: "center" }}>PolicyHolder</h4>
                                            <div className="row-1-right-box">
                                                <div>
                                                    <label>
                                                        <strong>ID:</strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.policyHolderId}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>Name:</strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.policyHolderName}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>CreditCard:</strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.creditCard}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>Date Of Birth:</strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.dob}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>Occupation: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.occupation}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>AnnualIncome: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.annualIncome}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>ResidenceType: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.residenceType}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>City: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.city}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>State: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.state}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>Zip Code: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.zip}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>Residence Use: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.residenceUse}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>First Name: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.user.firstName}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>Last Name: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.user.lastName}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>Email ID: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.user.emailId}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>Contact No.: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.user.contactNo}
                                                </div>
                                                <div>
                                                    <label>
                                                        <strong>Address: </strong>
                                                    </label>{" "}
                                                    {currentPolicyHolder.user.address}
                                                </div>
                                            </div>
                                            <Link
                                                to={"/update-policyholder/" + currentPolicyHolder.policyHolderId}
                                                className="badge badge-pill badge-success"
                                            >
                                                Edit
                                        </Link>

                                            <button
                                                className="badge badge-danger mr-2"
                                                onClick={this.deletePolicyHolder}
                                            >
                                                Delete
                                        </button>
                                        </div>
                                        <div className="row-2">
                                            <div className="row-2-left">
                                                <ViewPropertyComponent propertyId={currentPolicyHolder.property.propertyId} />
                                            </div>
                                            <div className="row-2-middle">
                                                <ViewPolicyComponent policyId={currentPolicyHolder.policy.policyId} />
                                            </div>
                                        </div>
                                        <div className="row-2-right">
                                            <ViewQuoteComponent quoteId={currentPolicyHolder.quote.quoteId} />
                                        </div>
                                    </div>
                                ) : (
                                    <div>
                                        <br />
                                    </div>
                                )}
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}
