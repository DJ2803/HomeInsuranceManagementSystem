import React, { Component } from "react";
import policyholderservice from "../services/policyholderservice";
// import PolicyHoderService from "../services/policyholderservice";
// import PolicyHolder from './PolicyHolderActions';
//import AgentService from "../services/agent.service";
// export default class AddProperty extends Component {
//   constructor(props) {
//     super(props);
//     this.onChangeMarketValue = this.onChangeMarketValue.bind(this);
//     this.onChangeYearBuilt = this.onChangeYearBuilt.bind(this);
//     this.onChangeSquareFootage = this.onChangeSquareFootage.bind(this);
//     this.onChangeHasSwimmingPool = this.onChangeHasSwimmingPool.bind(this);
//     this.saveProperty = this.saveProperty.bind(this);
//     this.newProperty = this.newProperty.bind(this);


//     this.state = {

//       propertyId: null,
//       marketValue: "",
//       yearBuilt: "",
//       squareFootage: "",
//       hasSwimmingPool: "",
//       message: ""
//     }
//   }
//   // componentDidMount() {
//   //   super.componentDidMount();
//   // }


//   onChangeMarketValue(e) {
//     this.setState({
//       marketValue: e.target.value,
//     });
//   }

//   onChangeYearBuilt(e) {
//     this.setState({
//       yearBuilt: e.target.value,
//     });
//   }

//   onChangeSquareFootage(e) {
//     this.setState({
//       squareFootage: e.target.value,
//     });
//   }

//   onChangeHasSwimmingPool(e) {
//     this.setState({
//       hasSwimmingPool: e.target.value,
//     });
//   }

//   saveProperty() {

//     var data =
//     {
//       marketValue: this.state.marketValue,
//       yearBuilt: this.state.marketValue,
//       squareFootage: this.state.squareFootage,
//       hasSwimmingPool: this.state.hasSwimmingPool
//     };


//     PolicyHoderService.addProperty(16, data).then(response => {
//       // this.setState({
//       //     propertyId: response.data.propertyId,
//       //     marketValue: response.data.marketValue,
//       //     yearBuilt: response.data.yearBuilt,
//       //     squareFootage: response.data.squareFootage,
//       //     hasSwimmingPool: response.data.hasSwimmingPool
//       // });
//       this.setState({
//         message:"The property was Added successfully!"
//       });

//       console.log(response.data);
//       // alert("Property Added");
//       // this.props.history.push("/policyholders");
//     })
//       .catch(e => {
//         console.log(e);
//       });



//   }

//   newProperty() {
//     this.setState({
//       propertyId: null,
//       marketValue: "",
//       yearBuilt: "",
//       squareFootage: "",
//       hasSwimmingPool: ""
//     });
//   }

//   render() {
//     return (
//       <div className="submit-form">
//         {this.state.submitted ? (
//           <div>
//             <h4>You submitted successfully!</h4>
//             <button className="btn btn-success" onClick={this.newProperty}>
//               Add
//               </button>
//           </div>
//         ) : (
//           <div>
//             <div className="form-group">
//               <label htmlFor="marketValue">Market Value</label>
//               <input
//                 type="number"
//                 className="form-control"
//                 id="marketValue"
//                 required
//                 value={this.state.marketValue}
//                 onChange={this.onChangeMarketValue}
//                 name="marketValue"
//               />
//             </div>

//             <div className="form-group">
//               <label htmlFor="yearBuilt">Year Built</label>
//               <input
//                 type="number"
//                 className="form-control"
//                 id="yearBuilt"
//                 required
//                 value={this.state.yearBuilt}
//                 onChange={this.onChangeYearBuilt}
//                 name="yearBuilt"
//               />
//             </div>

//             <div className="form-group">
//               <label htmlFor="squareFootage">Square Footage</label>
//               <input
//                 type="number"
//                 className="form-control"
//                 id="squareFootage"
//                 required
//                 value={this.state.squareFootage}
//                 onChange={this.onChangeSquareFootage}
//                 name="squareFootage"
//               />
//             </div>

//             <div className="form-group">
//               <label htmlFor="hasSwimmingPool">Has Swimming Pool</label>
//               <input
//                 type="text"
//                 className="form-control"
//                 id="hasSwimmingPool"
//                 required
//                 value={this.state.hasSwimmingPool}
//                 onChange={this.onChangeHasSwimmingPool}
//                 name="hasSwimmingPool"
//               />
//             </div>
//             <button onClick={this.saveProperty} className="btn btn-success">
//               Submit
//               </button>
//             <p>{this.state.message}</p>
//           </div>
//         )}
//       </div>
//     );
//   }
// }


class AddPropertyComponent extends Component
{
  constructor(props)
  {
    super(props);
    this.state={
           
             id: '',
             marketValue:'',
             squareFootage:'',
             yearBuilt:''
           
    }
    this.changemarketvalue=this.changemarketvalue.bind(this);
    this.changesquarefootage=this.changesquarefootage.bind(this);
    this.changeyearbuilt=this.changeyearbuilt.bind(this);
    this.changeproperty=this.changeproperty.bind(this);
  }
  changeproperty=(e)=>
  {
    e.preventDefault();
    let property=
    {
      id : null,marketValue:this.state.marketValue,squareFootage:this.state.squareFootage,yearBuilt:this.state.yearBuilt
    };
    console.log(JSON.stringify(property));
    var str = this.props.location.pathname;
    var matches = str.match(/(\d+)/);
console.log(matches[0]);
    policyholderservice.addProperty(matches[0],property).then(res => {
      var username=localStorage.getItem("username");
        this.props.history.push(`/view-policyholder/${username}`);
    })
  }
  changemarketvalue = (event) => {
    this.setState({ marketValue: event.target.value });
}
changesquarefootage = (event) => {
  this.setState({ squareFootage: event.target.value });
}
changeyearbuilt = (event) => {
  this.setState({ yearBuilt: event.target.value });
}

  render()
  {
    return(
      <div>
      <div className="container">
          <div className="row">
              <div className="policyholderform">
                  <h3 className="text-center">Add Property Details</h3>
                  <div className="card-body">
                      <form>
                          <div className="form-group">
                              <label className="label1">Enter Market Value</label>
                              <input  type="number"placeholder="Market Value" name="marketValue"
                                    className="label1"
                                  value={this.state.marketValue}

                                  onChange={this.changemarketvalue} />
                          </div>
                          <div className="form-group">
                              <label className="label1">Enter squareFootage</label>
                              <input placeholder="square Footage" name="squareFootage"
                              className="label1"
                                  value={this.state.squareFootage}
                                  onChange={this.changesquarefootage} />
                          </div>
                          <div className="form-group">
                              <label className="label1">Enter Year Built</label>
                              <input placeholder="Year Built" name="yearBuilt"
                              className="label1"
                                  value={this.state.yearBuilt}
                                  onChange={this.changeyearbuilt} />
                          </div>
                          <button className="buttonforback" onClick={this.changeproperty}>Save</button>
                         
                      </form>
                  </div>
              </div>
          </div>

      </div>
  </div>
    );
  }
}
export default AddPropertyComponent;






