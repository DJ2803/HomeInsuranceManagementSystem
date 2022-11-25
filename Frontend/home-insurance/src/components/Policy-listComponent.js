import React, { Component } from "react";
import PolicyService from "../services/policyservice";
import { Link } from "react-router-dom";
import "../Main.css";
// import "./agenttut-list.css";
export default class PolicyList extends Component {
  constructor(props) {
    super(props);
    this.onChangeSearchId = this.onChangeSearchId.bind(this);
    this.retrievePolicy = this.retrievePolicy.bind(this);
    this.refreshList = this.refreshList.bind(this);
    this.setActivePolicy = this.setActivePolicy.bind(this);
    // this.removeAllTutorials = this.removeAllTutorials.bind(this);
    this.searchId = this.searchId.bind(this);
    this.getDate = this.getDate.bind(this);
    this.state = {
      policies: [],
      currentPolicy: null,
      // cAgent: null,
      currentIndex: -1,
      searchId: "",
    };
  }

  componentDidMount() {
    this.retrievePolicy();
    // this.get();
  }

  onChangeSearchId(e) {
    const searchId = e.target.value;

    this.setState({
      searchId: searchId,
    });
  }

  retrievePolicy() {
    PolicyService.getAll()
      .then((response) => {
        this.setState({
          policies: response.data,
        });
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }

  refreshList() {
    this.retrievePolicy();
    this.setState({
      currentPolicy: null,
      currentIndex: -1,
    });
  }

  setActivePolicy(policy, index) {
    this.setState({
      currentPolicy: policy,
      currentIndex: index,
    });
  }
  selectpolicy=(e)=>
  {
      e.preventDefault();
      var str = this.props.location.pathname;
      var matches = str.match(/(\d+)/);
      this.props.history.push(`/update-policy/${this.state.currentPolicy.policyId}/${matches[0]}`);
  }
  
  searchId() {
    this.setState({
      currentPolicy: null,
      currentIndex: -1,
    });
    PolicyService.get(this.state.searchId)
      .then((response) => {
        this.setState({
          // cAgent: response.data,
          policies: [response.data],
        });

        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }
  getDate = (date) => {
    return date && date.length ? date[0] + "-" + date[1] + "-" + date[2] : date;
  };

  render() {
    const { searchId, policies, currentPolicy, currentIndex } = this.state;

    return (
      <div className="list row">
        <div className="searchbar">
          <div className="input-group mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Search by ID"
              value={searchId}
              onChange={this.onChangeSearchId}
            />
            <div className="input-group-append">
              <button
                className="btn btn-outline-secondary"
                type="button"
                onClick={this.searchId}
              >
                Search
              </button>
            </div>
          </div>
        </div>
        <div className="col-md-6">
          <h4>Policies List</h4>

          <ul className="list-group">
            {policies &&
              policies.map((policy, index) => (
                <li
                  className={
                    "list-group-item " +
                    (index === currentIndex ? "active" : "")
                  }
                  onClick={() => this.setActivePolicy(policy, index)}
                  key={index}
                >
                  {policy.policyId}
                  {"-"}
                  {policy.policyName}
                </li>
              ))}
          </ul>
        </div>
        <div className="quoteform">
          {currentPolicy ? (
            <div>
              <h4>Policy</h4>
              <div>
                <label className="labels">
                  <strong>ID</strong>
                </label>{" "}
                : {currentPolicy.policyId}
              </div>
              <div>
                <label className="labels">
                  <strong>Name</strong>
                </label>{" "}
               : {currentPolicy.policyName}
              </div>
              <div>
                <label className="labels">
                  <strong>Effective Date</strong>
                </label>{" "}
               : {this.getDate(currentPolicy.policyEffectiveDate)}
              </div>
              <div>
                <label className="labels">
                  <strong>End date</strong>
                </label>{" "}
                : {this.getDate(currentPolicy.policyEndDate)}
              </div>
              <div>
                <label className="labels">
                  <strong>Term</strong>
                </label>{" "}
                : {currentPolicy.policyTerm}
              </div>
              <div>
                <label className="labels">
                  <strong>Status</strong>
                </label>{" "}
               : {currentPolicy.policyStatus}
              </div>
              <div>
                            <button
                                className="buttonforview"
                                onClick={this.selectpolicy}>Click Here to select policy </button>
                      
                </div>
            </div>
            
          ) : (
            <div>
              <br />
              <p>Please click on a Policy...</p>
            </div>
          )}
        </div>
      </div>
    );
  }
}
