import React, { Component } from "react";
import "./quote-list.css"
import AgentService from "../services/agentservice";
import { Link } from "react-router-dom";

export default class QuoteList extends Component {
  constructor(props) {
    super(props);
    this.onChangeSearchId = this.onChangeSearchId.bind(this);
    this.retrieveQuotes = this.retrieveQuotes.bind(this);
    this.refreshData = this.refreshData.bind(this);
    this.setActiveQuote = this.setActiveQuote.bind(this);
    this.searchId = this.searchId.bind(this);
    this.selectquote = this.selectquote.bind(this);
    // this.removeAllTutorials = this.removeAllTutorials.bind(this);

    this.state = {
      quotes: [],
      currentQuote: null,
      currentIndex: -1,
      SearchId: "",

    };
  }

  componentDidMount() {
    var str = this.props.location.pathname;
    var matches = str.match(/(\d+)/);
    console.log(matches[0]);
    this.retrieveQuotes();
  }
  selectquote = (e) => {
    e.preventDefault();
    var str = this.props.location.pathname;
    var matches = str.match(/(\d+)/);
    this.props.history.push(`/update-quote/${this.state.currentQuote.quoteId}/${matches[0]}`);
  }
  onChangeSearchId(e) {
    const searchId = e.target.value;

    this.setState({
      searchId: searchId,
    });
  }

  retrieveQuotes() {
    AgentService.getAllQuotes()
      .then(response => {
        this.setState({
          quotes: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  refreshData() {
    this.setState({
      currentQuote: null,
      currentIndex: -1,
    });
  }

  setActiveQuote(quote, index) {
    this.setState({
      currentQuote: quote,
      currentIndex: index,
    });
  }




  searchId() {
    this.setState({
      currentQuote: null,
      currentIndex: -1
    });

    AgentService.getQuote(this.state.searchId)
      .then(response => {
        this.setState({

          quotes: [response.data]
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  render() {
    const { searchId, quotes, currentQuote, currentIndex } = this.state;


    return (

      // <div className="ScrollStyle-w">
      <div className="list row mt-3" >

        <div className="container-float"><img src="/images/agent logo.png" alt=""></img></div>
        <div className="searchbar">


          <div className="input-group mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Search by quote id"
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
          <h4>Quote List</h4>

          <ul className="list-group">
            {
              quotes &&
              quotes.map((quote, index) => (
                <li
                  className={
                    "list-group-item " +
                    (index === currentIndex ? "active" : "")
                  }
                  onClick={() => this.setActiveQuote(quote, index)}

                  key={index}
                >
                  {quote.quoteId}
                  {"-"}
                  {quote.premiumType}
                </li>
              ))}
          </ul>
        </div>

        <div className="quoteform">
          <div className="bg">
            {currentQuote ? (
              <div>
                <h4>Quote</h4>
                <div class="fonty">
                  <div >
                    <label className="label2" >
                      <strong>Quote Id</strong>
                   </label >{" "}
                  :  {currentQuote.quoteId}
                  </div>

                  <div>
                    <label className="label2">
                      <strong>Premium Type</strong>
                   </label>{" "}
                  :  {currentQuote.premiumType}
                  </div>

                  <div>
                    <label className="label2">
                      <strong>Premium Amount</strong>
                   </label>{" "}
                  :  {currentQuote.premiumAmount}
                  </div>

                  <div>
                    <label className="label2">
                      <strong>Dwelling Coverage</strong>
                    </label>{" "}
                   : {currentQuote.dwellingCoverage}
                  </div>

                  <div>
                    <label className="label2">
                      <strong>Detached Structure Coverage</strong>
                    </label>{" "}
                  :  {currentQuote.detachedStructureCoverage}
                  </div>

                  <div>
                    <label className="label2">
                      <strong>Personal Property Coverage</strong>
                    </label>{" "}
                  :  {currentQuote.personalPropertyCoverage}
                  </div>

                  <div>
                    <label className="label2">
                      <strong>Additional Living Expense</strong>
                    </label>{" "}
                  :  {currentQuote.additionalLivingExpense}
                  </div>

                  <div>
                    <label className="label2">
                      <strong>Medical Expense</strong>
                    </label>{" "}
                   : {currentQuote.medicalExpense}
                  </div>

                  <div >
                    <label className="label2">
                      <strong>Deducible Amount</strong>
                    </label>{" "}
                  :  {currentQuote.deducibleAmount}
                  </div>
                </div>
                <div>
                  <button
                    className="buttonforview"
                    onClick={this.selectquote}>Click Here to select quote </button>
                </div>
              </div>
            ) : (
              <div>
                <br />
                <p>Please click on a Quote...</p>
              </div>
            )}
          </div>
          {/* <div className="box"></div> */}
        </div>

      </div>

    );
  }
}

