import React, { Component } from 'react';
import policyholderservice from '../services/policyholderservice';
// import '../styles/PolicyHolderComponent.css'
import '../styles/ViewPolicyHolderComponent.css';

export default class ViewPolicyHolderComponent extends Component {
    constructor(props) {
        super(props);


        this.state = {
            userName: this.props.match.params.userName,
            isdisabled:false,
            policyholder: {
                user: {},
                property: {},
                policy: {},
                quote: {}
            }
        }
        this.handleClick = this.handleClick.bind(this);
        this.changepolicy = this.changepolicy.bind(this);
        this.changequote = this.changequote.bind(this);
        this.addproperty = this.addproperty.bind(this);
        this.updatepolicyholder = this.updatepolicyholder.bind(this);
        this.selectquote = this.selectquote.bind(this);
        this.logout = this.logout.bind(this);
        this.selectpolicy = this.selectpolicy.bind(this);
        this.getDate=this.getDate.bind(this);
    }
    getDate = (date) => {
        return date && date.length ? date[0] + "-" + date[1] + "-" + date[2] : date;
      }

    logout = (e) => {
        e.preventDefault();
        this.props.history.push("/login")
    }
    handleClick = (e) => {
        e.preventDefault();
        let propertyId;
        [propertyId] = [this.state.policyholder.property.propertyId];
      
        this.props.history.push(`/view-property/${propertyId}`)

    }
    changepolicy = (e) => {
        e.preventDefault();
        let policyId;
        [policyId] = [this.state.policyholder.policy.policyId];
        this.props.history.push(`/view-policy/${policyId}`)
    }
    changequote = (e) => {
        e.preventDefault();
        let quoteId;
        [quoteId] = [this.state.policyholder.quote.quoteId];
        this.props.history.push(`/view-quote/${quoteId}`)
    }
    addproperty = (e) => {
        e.preventDefault();
        let policyHolderId;
        [policyHolderId] = [this.state.policyholder.policyHolderId];
        this.props.history.push(`/add-property/${policyHolderId}`)
    }
    updatepolicyholder = (e) => {
        e.preventDefault();
        let policyHolderId;
        [policyHolderId] = [this.state.policyholder.policyHolderId];
        this.props.history.push(`/update-policyholder/${policyHolderId}`)
    }
    selectquote = (e) => {
        e.preventDefault();
        let policyHolderId = [this.state.policyholder.policyHolderId]; 
        this.props.history.push(`/quotes/${policyHolderId}`);
        console.log(this.state.isdisabled);  
    }
    selectpolicy = (e) => {
        e.preventDefault();
        let policyHolderId = [this.state.policyholder.policyHolderId];
        this.props.history.push(`/policies/${policyHolderId}`);
    }
    componentDidMount() {

        policyholderservice.getPolicyHolderByUserName(this.state.userName).then(res => {

            this.setState({ policyholder: res.data });
        })

    }

    render() {
        return (
            <div>
                <div>
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <button
                                        className="buttonfornav labels"
                                        onClick={this.handleClick}>View Property</button>
                                </li>
                                <li class="nav-item">
                                    <button
                                        className="buttonfornav labels"
                                        onClick={this.changepolicy}>View Policy</button>
                                </li>
                                <li class="nav-item">
                                    <button
                                        className="buttonfornav labels"
                                        onClick={this.changequote}>View quote</button>
                                </li>
                                <li class="nav-item">
                                    <button
                                        className="buttonfornav labels"
                                        onClick={this.addproperty}>Add Property Details</button>
                                </li>
                                <li class="nav-item">
                                    <button
                                        className="buttonfornav labels"
                                        onClick={this.updatepolicyholder}>Update Personal Details</button>
                                </li>
                                <li class="nav-item">
                                    <button
                                        className="buttonfornav labels"
                                        disabled={this.state.isdisabled}
                                        onClick={this.selectquote}> Select quote</button>
                                        
                                </li>
                                <li class="nav-item">
                                    <button
                                        className="buttonfornav labels"
                                        onClick={this.selectpolicy}> Select Policy </button>
                                </li>
                                <li class="nav-item buttonforexit labels">
                                    <button
                                        className="buttonfornav1"
                                        onClick={this.logout}> Log Out </button>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
                <div className="viewpolicyholderform">
                    <h3 className="text-center">View PolicyHolder Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <label className="labels">PolicyHolder Name</label>
                            <div className="labels">: {this.state.policyholder.policyHolderName}</div>
                        </div>
                        <div className="row">
                            <label className="labels">EmailId </label>
                            <div className="labels">: {this.state.policyholder.user.emailId}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Contact No </label>
                            <div className="labels">: {this.state.policyholder.user.contactNo}</div>
                        </div>
                        <div className="row">
                            <label className="labels">First Name</label>
                            <div className="labels">: {this.state.policyholder.user.firstName}</div>
                        </div>
                        <div className="row">
                            <label className="labels"> Last Name </label>
                            <div className="labels">: {this.state.policyholder.user.lastName}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Credit Card </label>
                            <div className="labels">:  {this.state.policyholder.creditCard}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Date Of Birth </label>
                            <div className="labels">:  {this.getDate(this.state.policyholder.dob)}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Occupation </label>
                            <div className="labels">: {this.state.policyholder.occupation}</div>
                        </div>
                        <div className="row">
                            <label className="labels">AnnualIncome </label>
                            <div className="labels">: {this.state.policyholder.annualIncome}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Residence Type </label>
                            <div className="labels">: {this.state.policyholder.residenceType}</div>
                        </div>
                        <div className="row">
                            <label className="labels">City </label>
                            <div className="labels">: {this.state.policyholder.city}</div>
                        </div>
                        <div className="row">
                            <label className="labels">State </label>
                            <div className="labels">: {this.state.policyholder.state}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Zip Code </label>
                            <div className="labels">: {this.state.policyholder.zip}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Residence Use</label>
                            <div className="labels"> : {this.state.policyholder.residenceUse}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Address </label>
                            <div className="labels">:{this.state.policyholder.user.address}</div>
                        </div>
                        
                    </div>
                </div>
            </div>
        );
    }
}