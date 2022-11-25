import React, { Component } from 'react';
import policyholderservice from '../services/policyholderservice';
import '../styles/ViewProperty.css';


export default class ViewPolicyComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
           //policyId: this.props.match.params.policyId,
            policy: {}
        }
this.changehandler=this.changehandler.bind(this);
this.getDate = this.getDate.bind(this);
    }

    componentDidMount() {
        var str = this.props.location.pathname;
        var matches = str.match(/(\d+)/);
    console.log(matches[0]);
        policyholderservice.viewPolicy(matches[0]).then(res => {
            
            this.setState({ policy: res.data });
        })
    }
    changehandler=(e)=>
    {
        e.preventDefault();
        var username=localStorage.getItem("username");
        this.props.history.push(`/view-policyholder/${username}`);
    }

    getDate = (date) => {
        return date && date.length ? date[0] + "-" + date[1] + "-" + date[2] : date;
      }
    render() {
        return (
            <div>
                <div className="viewpropertyform">
                <div >
                    <h3 className="text-center">View Policy Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <label className="labels">Policy Name</label>
                            <div>: {this.state.policy.policyName}</div>
                        </div>
                        <div className="row">
                            <label className="labels"> PolicyEndDate </label>
                            <div>: {this.getDate(this.state.policy.policyEndDate)}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Policy Effective Date </label>
                            <div>: {this.getDate(this.state.policy.policyEffectiveDate)}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Policy Status</label>
                            <div>: {this.state.policy.policyStatus}</div>
                        </div>
                        <div className="row">
                            <label className="labels">Policy Term </label>
                            <div>: {this.state.policy.policyTerm}</div>
                        </div>
                        <div>
                        <button className = "buttonforback" onClick = {this.changehandler}>Back</button>
                    </div>
                       </div>


                    </div>
                </div>
            </div>
        );
    }
}


