import React, { Component } from 'react';
import policyholderservice from '../services/policyholderservice';

 export default class UpdatePolicyHolderComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            policyHolderId: this.props.match.params.policyHolderId,
            policyHolderName: '',
            creditCard: '',
            dob: '',
            occupation: '',
            annualIncome :'',
            // isRetired: '',
            residenceType: '',
            city: '',
            state :'',
            zip :'',
            residenceUse: '',
            user:{},
            agent:{},
            policy:{},
            quote:{},
            property:{}
        }
        this.changePolicyHolderHandler= this.changePolicyHolderHandler.bind(this);
        this.changeCreditCardHandler= this.changeCreditCardHandler.bind(this);
        this.changedobHandler= this.changedobHandler.bind(this);
        this.changeoccupationHandler= this.changeoccupationHandler.bind(this);
        this.changeAnnualIncomeHandler= this.changeAnnualIncomeHandler.bind(this);
        // this.changeisRetiredHandler= this.changeisRetiredHandler.bind(this);
        this.changeresidenceTypeHandler= this.changeresidenceTypeHandler.bind(this);
        this.changecityHandler= this.changecityHandler.bind(this);
        this.changestateHandler= this.changestateHandler.bind(this);
        this.changezipHandler= this.changezipHandler.bind(this);
        this.changeresidenceUseHandler= this.changeresidenceUseHandler.bind(this);
    }
    componentDidMount(){
        console.log(this.state.policyHolderId);
        policyholderservice.getPolicyHolderById(this.state.policyHolderId).then((res)=>{
            var policyholder=  res.data;
            this.state.user.userName=policyholder.user.userName;
            this.state.user.userId=policyholder.user.userId;
            this.state.user.emailId=policyholder.user.emailId;
            this.state.user.contactNo=policyholder.user.contactNo;
            this.state.user.firstName=policyholder.user.firstName;
            this.state.user.lastName=policyholder.user.lastName;
            this.state.user.password=policyholder.user.password;
            this.state.user.role=policyholder.user.role;
            this.state.user.address=policyholder.user.address;
            
            console.log(res);
            this.setState({
                policyHolderId :policyholder.policyHolderId,
                policyHolderName:policyholder.policyHolderName,
                creditCard :policyholder.creditCard,
                dob:policyholder.dob,
                occupation:policyholder.occupation,
                annualIncome:policyholder.annualIncome,
                // isRetired:policyholder.isRetired,
                residenceType:policyholder.residenceType,
                city:policyholder.city,
                state:policyholder.state,
                zip:policyholder.zip,
                residenceUse:policyholder.residenceUse,
               
                // marketValue:policyholder.property.marketValue,
                // yearBuilt:policyholder.property.yearBuilt,
                // squareFootage:policyholder.property.squareFootage,
                // hasSwimmingPool:policyholder.property.hasSwimmingPool
            });
        });
    }
    updatePolicyHolder = (e)=>{
        e.preventDefault();
        


        let policyholder ={ policyHolderId: this.state.policyHolderId,policyHolderName:this.state.policyHolderName, creditCard:this.state.creditCard, dob:this.state.dob,
            occupation:this.state.occupation,annualIncome:this.state.annualIncome,residenceType:this.state.residenceType,city:this.state.city,
            state:this.state.state,zip:this.state.zip,residenceUse:this.state.residenceUse,userId:this.state.user.userId,
            userName:this.state.userName,address:this.state.user.address,firstName:this.state.user.firstName,lastName:this.state.user.lastName,
            password:this.state.user.password,role:this.state.user.role,contactNo:this.state.user.contactNo,emailId:this.state.user.emailId
        };
        console.log(JSON.stringify((policyholder)));
       policyholderservice.updatePolicyHolder(policyholder).then((res) =>{
            this.props.history.push(`/view-policyholder/${this.state.user.userName}`);
       });
    }  
    

    changePolicyHolderHandler = (event) =>{
        this.setState({policyHolderName: event.target.value});
    }


    changeCreditCardHandler = (event) =>{
        this.setState({creditCard: event.target.value});
    }

    changedobHandler= (event) =>{
        this.setState({dob: event.target.value});
    }

    changeoccupationHandler = (event) =>{
        this.setState({occupation: event.target.value});
    }

    changeAnnualIncomeHandler = (event) =>{
        this.setState({annualIncome: event.target.value});
    }
   
    changeresidenceTypeHandler = (event) =>{
        this.setState({residenceType: event.target.value});
    }

    changecityHandler= (event) =>{
        this.setState({city: event.target.value});
    }

    changestateHandler= (event) =>{
        this.setState({state: event.target.value});
    }

    changezipHandler= (event) =>{
        this.setState({zip: event.target.value});
    }

    changeresidenceUseHandler= (event) =>{
        this.setState({residenceUse: event.target.value});
    }
    changeMarketValueHandler = (event) => {
        this.setState({ marketValue: event.target.value });
    }

    changeYearBuiltHandler = (event) => {
        this.setState({ yearBuilt: event.target.value });
    }

    changeSquareFootageHandler = (event) => {
        this.setState({ squareFootage: event.target.value });
    }

    changeHasSwimmingPoolHandler = (event) => {
        this.setState({ hasSwimmingPool: event.target.value });
    }

    render() {
        return (
            <div>               
                <div className="container">
                    <div className="row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Edit PolicyHolder</h3>
                            <div className = "card-body">
                                <form>
                                <div className="form-group"> 
                                        <label>Enter PolicyHolder Name</label>
                                        <input type="text" placeholder="policyHolder Name"disabled={true} name="policyHolderName"
                                            className="form-control" value = {this.state.policyHolderName} 
                                            onChange = {this.changePolicyHolderHandler}/>
                                    </div>
                                    <div className="form-group"> 
                                        <label>Enter Credit Card Details</label>
                                        <input type="text" placeholder="Credit Card Name" name="creditCard"
                                            className="form-control" value = {this.state.creditCard} 
                                            onChange = {this.changeCreditCardHandler}/>
                                    </div>
                                    <div className="form-group"> 
                                        <label>Enter PolicyHolder DateOfBirth(yyyy-mm-dd)</label>
                                        <input type="date" placeholder="date of birth" name="dob"
                                            className="form-control" value = {this.state.dob} 
                                            onChange = {this.changedobHandler}/>
                                    </div>
                                    <div className="form-group"> 
                                        <label>Enter PolicyHolder Occupation</label>
                                        <input type="text" placeholder="Occupation" name="occupation"
                                            className="form-control" value = {this.state.occupation} 
                                            onChange = {this.changeoccupationHandler}/>
                                    </div>
                                    <div className="form-group"> 
                                        <label>Enter PolicyHolder AnnualIncome</label>
                                        <input type="number" placeholder="Annual Income" name="annualIncome"
                                            className="form-control" value = {this.state.annualIncome} 
                                            onChange = {this.changeAnnualIncomeHandler}/>
                                    </div>
                                    <div className="form-group"> 
                                        <label>Enter PolicyHolder Residence Type</label>
                                        <input type="text" placeholder="Residence Type" name="residenceType"
                                            className="form-control" value = {this.state.residenceType} 
                                            onChange = {this.changeresidenceTypeHandler}/>
                                    </div>
                                    <div className="form-group"> 
                                        <label>Enter PolicyHolder City</label>
                                        <input type="text" placeholder="City" name="city"
                                            className="form-control" value = {this.state.city} 
                                            onChange = {this.changecityHandler}/>
                                    </div>
                                    <div className="form-group"> 
                                        <label>Enter PolicyHolder State</label>
                                        <input type="text" placeholder="State" name="state"
                                            className="form-control" value = {this.state.state} 
                                            onChange = {this.changestateHandler}/>
                                    </div>
                                    <div className="form-group"> 
                                        <label>Enter PolicyHolder Zip</label>
                                        <input type="number" placeholder="Zip" name="zip"
                                            className="form-control" value = {this.state.zip} 
                                            onChange = {this.changezipHandler}/>
                                    </div>
                                    <div className="form-group"> 
                                        <label>Enter PolicyHolder Residence Use</label>
                                        <input type="text" placeholder="Residence Use" name="residenceUse"
                                            className="form-control" value = {this.state.residenceUse} 
                                            onChange = {this.changeresidenceUseHandler}/>
                                    </div>
                                    <button className = "btn btn-success" onClick = {this.updatePolicyHolder}>Update</button>
                                    
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
    }