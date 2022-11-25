
import React, { Component } from "react";
import PolicyHolderService from "../services/policyholderservice";
import AddPropertyComponent from "./AddPropertyComponent";
import "../styles/PolicyHolderActions.css";
class PolicyHolder extends Component {
  constructor(props) {
    super(props);
    this.changePolicyHolderHandler= this.changePolicyHolderHandler.bind(this);
    this.changeCreditCardHandler= this.changeCreditCardHandler.bind(this);
    this.changedobHandler= this.changedobHandler.bind(this);
    this.changeoccupationHandler= this.changeoccupationHandler.bind(this);
    this.changeAnnualIncomeHandler= this.changeAnnualIncomeHandler.bind(this);
    this.changeresidenceTypeHandler= this.changeresidenceTypeHandler.bind(this);
    this.changecityHandler= this.changecityHandler.bind(this);
    this.changestateHandler= this.changestateHandler.bind(this);
    this.changezipHandler= this.changezipHandler.bind(this);
    this.changeresidenceUseHandler= this.changeresidenceUseHandler.bind(this);
    this.getPolicyHolder = this.getPolicyHolder.bind(this);
    // this.updatePublished = this.updatePublished.bind(this);
    this.updatePolicyHolder = this.updatePolicyHolder.bind(this);
    // this.changeMarketValue = this.changeMarketValue.bind(this);
    // this.changeYearBuilt = this.changeYearBuilt.bind(this);
    // this.changeSquareFootage = this.changeSquareFootage.bind(this);
    // this.changeHasSwimmingPool = this.changeHasSwimmingPool.bind(this);

    this.state = {
      currentPolicyHolder: {
        policyHolderId: null,
        policyHolderName: "",
        creditCard: '',
        dob: '',
        occupation: '',
        annualIncome :'',
        residenceType: '',
        city: '',
        state :'',
        zip :'',
        residenceUse: '',
        user: "",
        quote:"",
        property:{
          propertyId: null,
          marketValue: "",
          yearBuilt: "",
          squareFootage: "",
        },
      },
      message: "",
    };
  }

  componentDidMount() {
    this.getPolicyHolder(this.props.match.params.policyHolderId);
  }

  changePolicyHolderHandler(e) {
    const policyHolderName = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPolicyHolder: {
          ...prevState.currentPolicyHolder,
          policyHolderName: policyHolderName,
        },
      };
    });
  }
  // onChangeAddress(e) {
  //   const address = e.target.value;

  //   this.setState(function (prevState) {
  //     return {
  //       currentAgen: {
  //         ...prevState.currentAgent.user,
  //         address: address,
  //       },
  //     };
  //   });
  // }
  changeCreditCardHandler(e) {
    const creditCard = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPolicyHolder: {
          ...prevState.currentPolicyHolder,
          creditCard: creditCard,
        },
      };
    });
  }
  changedobHandler(e) {
    const dob = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPolicyHolder: {
          ...prevState.currentPolicyHolder,
          dob: dob,
        },
      };
    });
  }
  changeoccupationHandler(e) {
    const occupation = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPolicyHolder: {
          ...prevState.currentPolicyHolder,
          occupation: occupation,
        },
      };
    });
  }

changeAnnualIncomeHandler(e) {
    const annualIncome = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPolicyHolder: {
          ...prevState.currentPolicyHolder,
          annualIncome: annualIncome,
        },
      };
    });
  }

  changeresidenceTypeHandler(e) {
    const residenceType = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPolicyHolder: {
          ...prevState.currentPolicyHolder,
          residenceType: residenceType,
        },
      };
    });
  }
  changecityHandler(e) {
    const city = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPolicyHolder: {
          ...prevState.currentPolicyHolder,
          city: city,
        },
      };
    });
  }
  changestateHandler(e) {
    const state = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPolicyHolder: {
          ...prevState.currentPolicyHolder,
          state: state,
        },
      };
    });
  }

  changezipHandler(e) {
    const zip = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPolicyHolder: {
          ...prevState.currentPolicyHolder,
          zip: zip,
        },
      };
    });
  }
  changeresidenceUseHandler(e) {
    const residenceUse = e.target.value;

    this.setState(function (prevState) {
      return {
        currentPolicyHolder: {
          ...prevState.currentPolicyHolder,
          residenceUse: residenceUse,
        },
      };
    });
  }
  // changeMarketValue(e) {
  //   const marketValue = e.target.value;
  //   this.setState(function (prevState) {
  //     return {
  //       currentPolicyHolder: {
  //         ...prevState.currentPolicyHolder,
  //         marketValue: marketValue,
  //       },
  //     };
  //   });
  // }
  // changeYearBuilt(e) {
  //   const yearBuilt = e.target.value;

  //   this.setState(function (prevState) {
  //     return {
  //       currentPolicyHolder: {
  //         ...prevState.currentPolicyHolder,
  //         yearBuilt: yearBuilt,
  //       },
  //     };
  //   });
  // }

  // changeSquareFootage(e) {
  //   const squareFootage = e.target.value;

  //   this.setState(function (prevState) {
  //     return {
  //       currentPolicyHolder: {
  //         ...prevState.currentPolicyHolder,
  //         squareFootage: squareFootage,
  //       },
  //     };
  //   });
  // }

  // changeHasSwimmingPool(e) {
  //   const hasSwimmingPool = e.target.value;

  //   this.setState(function (prevState) {
  //     return {
  //       currentPolicyHolder: {
  //         ...prevState.currentPolicyHolder,
  //         hasSwimmingPool: hasSwimmingPool,
  //       },
  //     };
  //   });
  // }

  getPolicyHolder(policyHolderId) {
    PolicyHolderService.getPolicyHolderById(policyHolderId)
      .then((response) => {
        this.setState({
          currentPolicyHolder: response.data,
        });
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }

  updatePolicyHolder() {
    PolicyHolderService.updatePolicyHolder(this.state.currentPolicyHolder)
      .then((response) => {
        alert("Successfully Updated");
        this.props.history.push(`/view-policyholder/${this.state.currentPolicyHolder.user.userName}`);
        console.log(response.data);
        console.log(this.state.currentPolicyHolder.policyHolderId);
        this.setState({
          // message: "The agent was updated successfully!",
        });
      })
      .catch((e) => {
        console.log(e);
      });
  }


  // addProperty() {
  //   PolicyHolderService.addProperty(this.state.currentPolicyHolder.property)
  //     .then((response) => {
  //       console.log(response.data);
  //       this.props.history.push("/add-property");
  //     })
  //     .catch((e) => {
  //       console.log(e);
  //     });
  // }

  render() {
    const { currentPolicyHolder } = this.state;

    return (
      <div className="ScrollStyle">
        <div className="policyholderform">
        {currentPolicyHolder ? (
          <div className="edit-form">
            <h4>PolicyHolder</h4>
            <form>
              <div className="form-group">
                <label htmlFor="title">PolicyHolder ID:</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.policyHolderId}
                  // onChange={this.onChangeName}
                  readOnly
                />
              </div>
              <div className="form-group">
                <label htmlFor="title">Name:</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.policyHolderName}
                  onChange={this.changePolicyHolderHandler}
                />
              </div>
              <div className="form-group">
                <label htmlFor="title">CreditCard Details:</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.creditCard}
                  onChange={this.changeCreditCardHandler}
                />
              </div>

              <div className="form-group">
                <label htmlFor="title">Date Of Birth:</label>
                <input
                  type="date"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.dob}
                  onChange={this.changedobHandler}
                />
              </div>
              <div className="form-group">
                <label htmlFor="title">Occupation:</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.occupation}
                  onChange={this.changeoccupationHandler}
                />
              </div>
              <div className="form-group">
                <label htmlFor="title">AnnualIncome:</label>
                <input
                  type="number"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.annualIncome}
                  onChange={this.changeAnnualIncomeHandler}
                />
              </div>

              <div className="form-group">
                <label htmlFor="title">Residence Type:</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.residenceType}
                  onChange={this.changeresidenceTypeHandler}
                />
              </div>
              <div className="form-group">
                <label htmlFor="title">City:</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.city}
                  onChange={this.changecityHandler}
                />
              </div>
              <div className="form-group">
                <label htmlFor="title">State:</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.state}
                  onChange={this.changestateHandler}
                />
              </div>
              <div className="form-group">
                <label htmlFor="title">Zip Code:</label>
                <input
                  type="number"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.zip}
                  onChange={this.changezipHandler}
                />
              </div>

              <div className="form-group">
                <label htmlFor="title">Residence Use:</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.residenceUse}
                  onChange={this.changeresidenceUseHandler}
                />
              </div>

              {/* <div className="form-group">
                <label htmlFor="title">Market Value:</label>
                <input
                  type="number"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.marketValue}
                  onChange={this.changeMarketValue}
                />
              </div>
              <div className="form-group">
                <label htmlFor="title">Year Built:</label>
                <input
                  type="number"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.yearBuilt}
                  onChange={this.changeYearBuilt}
                />
              </div>
              <div className="form-group">
                <label htmlFor="title">Square Footage:</label>
                <input
                  type="number"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.squareFootage}
                  onChange={this.changeSquareFootage}
                /> */}
              {/* </div> */}
              {/* <div className="form-group">
                <label htmlFor="title">Has Swimming Pool:</label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  value={currentPolicyHolder.property.hasSwimmingPool}
                  onChange={this.changeHasSwimmingPool}
                />
              </div> */}
             
            </form>

            {/* <button
              className="badge badge-danger mr-2"
              onClick={()=>this.props.history.push(`/add-property/${currentPolicyHolder.policyHolderId}`)}
            >
              Add Property Details
            </button> */}
            
            <button
              type="submit"
              style={{marginLeft:"10px"}}
              className="badge badge-success"
              onClick={this.updatePolicyHolder}
            >
              Update
            </button>
            <p>{this.state.message}</p>
          </div>
        ) : (
          <div>
            <br />
            <p>Please click on a PolicyHolder...</p>
          </div>
        )}
        </div>
        {/* <div className="addpropertyform">
        <div><h2 style={{textAlign:"center"}}>Add Property</h2></div>
        <AddPropertyComponent policyHolderId={this.state.currentPolicyHolder.policyHolderId} />
        </div> */}
      </div>
      
    );
  }
}
export default PolicyHolder;