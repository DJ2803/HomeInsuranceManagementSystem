
import React, { Component } from "react";
import policyholderservice from "../services/policyholderservice";
import policyservice from '../services/policyservice'
class UpdateQuoteComponent extends Component
{
  constructor(props)
  {
    super(props);
    this.state={
          policyId:'',
          policyName:'',
          policyEffectiveDate:'',
          policyEndDate :'',
          policyStatus :'',
          policyTerm:''
    }
   
  }
componentDidMount()
{
    var str = this.props.location.pathname;
    var  matches = str.match(/\d+/g);
    policyservice.get(matches[0]).then((res)=>{
        console.log(res);
        var policy=res.data;
        console.log(policy);
        this.setState({
         policyId:policy.policyId,
         policyName:policy.policyName,
         policyEffectiveDate:policy.policyEffectiveDate,
         policyEndDate:policy.policyEndDate,
         policyTerm:policy.policyTerm,
         policyStatus:policy.policyStatus 
        })
    //    this.getDate=this.getDate.bind(this);
    })
  this.selectpolicy=(e)=>
   {
       e.preventDefault();
       let policy=
       {
          policyId:this.state.policyId,
          policyName:this.state.policyName,
          policyEffectiveDate:this.state.policyEffectiveDate,
          policyEndDate:this.state.policyEndDate,
          policyTerm:this.state.policyTerm,
          policyStatus:this.state.policyStatus
       }
       console.log(JSON.stringify(policy));
       var str = this.props.location.pathname;
    var  matches = str.match(/\d+/g);
    policyholderservice.selectpolicy(matches[1],policy).then(res=>{
        var username=localStorage.getItem("username");
        this.props.history.push(`/view-policyholder/${username}`)
    })

   }
//    this.getDate = (date) => {
//     return date && date.length ? date[2] + "-" + date[1] + "-" + date[0] : date;
//   }
}
render() {
    return (
        <div>               
            <div className="container">
                <div className="row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">Policy Details</h3>
                        <div className = "card-body">
                            <form>
                            <div className="form-group"> 
                                    <label>Policy Name</label>
                                    <input type="text" placeholder="Policy Name"disabled={true} name="policyName"
                                        className="form-control" value = {this.state.policyName} 
                                      />
                                </div>
                                <div className="form-group"> 
                                    <label>Policy Effective Date:</label>
                                    <input type="date" placeholder="Policy Effective Date" name="policyEffectiveDate"
                                    disabled={true}
                                        className="form-control" value = {(this.state.policyEffectiveDate)} 
                                       />
                                </div>
                                <div className="form-group"> 
                                    <label>Policy End Date:</label>
                                    <input type="date" placeholder="Policy End Date" name="policyEndDate"
                                    disabled={true}
                                        className="form-control" value = {(this.state.policyEndDate)} 
                                        />
                                </div>
                                <div className="form-group"> 
                                    <label>Policy Term</label>
                                    <input type="number" placeholder="Policy Term" name="policyTerm"
                                    disabled={true}
                                        className="form-control" value = {this.state.policyTerm} 
                                       />
                                </div>
                                <div className="form-group"> 
                                    <label>Policy Status</label>
                                    <input type="text" placeholder="Policy Status" name="policyStatus"
                                       disabled={true}
                                       className="form-control" value = {this.state.policyStatus} 
                                        />
                                </div>
                               
                               
                                <button className = "btn btn-success" onClick = {this.selectpolicy}>Policy</button>
                                
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    );
}
     
}
  

export default UpdateQuoteComponent;

