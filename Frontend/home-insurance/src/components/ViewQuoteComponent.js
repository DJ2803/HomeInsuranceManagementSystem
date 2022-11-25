import React, { Component } from 'react';
import policyholderservice from '../services/policyholderservice';
//import PolicyHolderService from '../services/policyholderservice';
// import '../styles/ViewProperty.css';

export default class ViewQuoteComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            quote: {}
        }

        this.changehandler = this.changehandler.bind(this);
    }


    componentDidMount() {
        var str = this.props.location.pathname;
        var matches = str.match(/(\d+)/);
        console.log(matches[0]);
        policyholderservice.viewQuote(matches[0]).then(res => {

            this.setState({ quote: res.data });
        })
    }
    changehandler = (e) => {
        e.preventDefault();
        var username = localStorage.getItem("username");
        this.props.history.push(`/view-policyholder/${username}`);
    }
    render() {
        return (
            <div>
                <div className="viewpropertyform">
                    <div >
                        <h3 className="text-center">View Quote Details</h3>
                        <div className="card-body">
                            <div className="row">
                                <label className="labels">Preminum Type </label>

                                <div className="values">:  {this.state.quote.premiumType}</div>
                            </div>
                            <div className="row">
                                <label className="labels">Premium Amount</label>
                                <div className="values">: {this.state.quote.premiumAmount}</div>
                            </div>
                            <div className="row">
                                <label className="labels">Dwelling Coverage</label>
                                <div className="values">: {this.state.quote.dwellingCoverage}</div>
                            </div>
                            <div className="row">
                                <label className="labels">Detached Structure Coverage</label>
                                <div className="values">: {this.state.quote.detachedStructureCoverage}</div>
                            </div>
                            <div className="row">
                                <label className="labels">Personal Property Coverage</label>
                                <div className="values">: {this.state.quote.personalPropertyCoverage}</div>
                            </div>
                            <div className="row">
                                <label className="labels">Additional Living Expense</label>
                                <div className="values">: {this.state.quote.additionalLivingExpense}</div>
                            </div>
                            <div className="row">
                                <label className="labels">Medical Expense</label>
                                <div className="values">: {this.state.quote.medicalExpense}</div>
                            </div>
                            <div className="row">
                                <label className="labels">Deducible Amount </label>
                                <div className="values">: {this.state.quote.deducibleAmount}</div>
                            </div>
                            <button className="buttonforback" onClick={this.changehandler}>Back</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}


