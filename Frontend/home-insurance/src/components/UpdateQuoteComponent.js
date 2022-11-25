
import React, { Component } from "react";
import policyholderservice from "../services/policyholderservice";
import agentservice from '../services/agentservice'
class UpdateQuoteComponent extends Component
{
  constructor(props)
  {
    super(props);
    this.state={
          quoteId:'',
          premiumType: '',
          premiumAmount:'',
          dwellingCoverage:'',
          detachedStructureCoverage:'',
          personalPropertyCoverage:'',
          additionalLivingExpense:'',
          medicalExpense:'',
          deducibleAmount:''
    }
    // this.selectquote=this.selectquote.bind(this);
  }
componentDidMount()
{
    var str = this.props.location.pathname;
    var  matches = str.match(/\d+/g);
    agentservice.getQuote(matches[0]).then((res)=>{
        console.log(res);
        var quote=res.data;
        console.log(quote);
        this.setState({
          quoteId:quote.quoteId,
          premiumType:quote.premiumType,
          premiumAmount:quote.premiumAmount,
          dwellingCoverage:quote.dwellingCoverage,
          detachedStructureCoverage:quote.detachedStructureCoverage,
          personalPropertyCoverage:quote.personalPropertyCoverage,
          additionalLivingExpense:quote.additionalLivingExpense,
          medicalExpense:quote.medicalExpense,
          deducibleAmount:quote.deducibleAmount

          
        })
       
    })
  this.selectquote=(e)=>
   {
       e.preventDefault();
       let quote=
       {
           quoteId:this.state.quoteId,
           premiumType:this.state.premiumType,
           premiumAmount:this.state.premiumAmount,
           dwellingCoverage:this.state.dwellingCoverage,
           detachedStructureCoverage:this.state.detachedStructureCoverage,
           personalPropertyCoverage:this.state.personalPropertyCoverage,
           additionalLivingExpense:this.state.additionalLivingExpense,
           medicalExpense:this.state.medicalExpense,
           deducibleAmount:this.state.deducibleAmount
       }
       console.log(JSON.stringify(quote));
       var str = this.props.location.pathname;
    var  matches = str.match(/\d+/g);
    policyholderservice.selectquote(matches[1],quote).then(res=>{
        var username=localStorage.getItem("username");
        this.props.history.push(`/view-policyholder/${username}`)
    })

   } 
}
render() {
    return (
        <div>               
            <div className="container">
                <div className="row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">Quote Details</h3>
                        <div className = "card-body">
                            <form>
                            <div className="form-group"> 
                                    <label>Premium Type:</label>
                                    <input type="text" placeholder="Premium Type"disabled={true} name="premiumType"
                                        className="form-control" value = {this.state.premiumType} 
                                      />
                                </div>
                                <div className="form-group"> 
                                    <label>Premium Amount:</label>
                                    <input type="number" placeholder="Premium Amount" name="premiumAmount"
                                    disabled={true}
                                        className="form-control" value = {this.state.premiumAmount} 
                                       />
                                </div>
                                <div className="form-group"> 
                                    <label>Dwelling Coverage:</label>
                                    <input type="number" placeholder="Dwelling Coverage" name="dwellingCoverage"
                                    disabled={true}
                                        className="form-control" value = {this.state.dwellingCoverage} 
                                        />
                                </div>
                                <div className="form-group"> 
                                    <label>Detached Structure Coverage</label>
                                    <input type="number" placeholder="Detached Structure Coverage" name="detachedStructureCoverage"
                                    disabled={true}
                                        className="form-control" value = {this.state.detachedStructureCoverage} 
                                       />
                                </div>
                                <div className="form-group"> 
                                    <label>Personal Property Coverage</label>
                                    <input type="number" placeholder="Personal Property Coverage" name="personalPropertyCoverage"
                                       disabled={true}
                                       className="form-control" value = {this.state.personalPropertyCoverage} 
                                        />
                                </div>
                                <div className="form-group"> 
                                    <label>Additional Living Expense</label>
                                    <input type="number" placeholder="Additional Living Expense" name="additionalLivingExpense"
                                       disabled={true}
                                       className="form-control" value = {this.state.additionalLivingExpense} 
                                        />
                                </div>
                                <div className="form-group"> 
                                    <label>Medical Expense</label>
                                    <input type="number" placeholder="Medical Expense" name="medicalExpense"
                                    disabled={true}
                                        className="form-control" value = {this.state.medicalExpense} 
                                        />
                                </div>
                                <div className="form-group"> 
                                    <label>Deducible Amount</label>
                                    <input type="number" placeholder="Deducible Amount" name="deducibleAmount"
                                    disabled={true}
                                        className="form-control" value = {this.state.deducibleAmount} 
                                        />
                                </div>
                               
                                <button className = "btn btn-success" onClick = {this.selectquote}>Quote</button>
                                
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

