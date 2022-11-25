import React, { Component } from 'react';
import policyholderservice from '../services/policyholderservice';
import { withRouter } from 'react-router-dom';
 import "../Main.css";
// import '../styles/PolicyHolderComponent.css'
import '../styles/ViewProperty.css';
class ViewPropertyComponent extends Component {
    constructor(props) {
        super(props);
        this.state =
        {
            property: {}
        }
        this.changehandler = this.changehandler.bind(this);
    }

    componentDidMount() {
        var str = this.props.location.pathname;
        var matches = str.match(/(\d+)/);
        console.log(matches[0]);
        policyholderservice.viewProperty(matches[0]).then(res => {

            this.setState({ property: res.data });
        })

    }
    changehandler = (e) => {
        e.preventDefault();
        var username = localStorage.getItem("username");
        this.props.history.push(`/view-policyholder/${username}`);
    }

    render() {
        return (
            <div >
                <div className="viewpropertyform">
                    <div>
                        <h3 className="text-center">View Property Details</h3>
                        <div className="card-body">
                            <div className="row">
                                <label className="labels">Market Value </label>
                                <div>: {this.state.property.marketValue}</div>
                            </div>
                            <div className="row">
                                <label className="labels">Year Built</label>
                                <div>: {this.state.property.yearBuilt}</div>
                            </div>
                            <div className="row">
                                <label className="labels">Square Footage</label>
                                <div>: {this.state.property.squareFootage}</div>
                            </div>
                            <div>
                                <button className="buttonforback" onClick={this.changehandler}>Back</button>
                            </div>


                        </div>

                    </div>
                </div>
                <img src="../image/user logo.png"alt="" className="homeimage"/>
            </div>

        );
    }
}

export default withRouter(ViewPropertyComponent);




// function ViewPropertyComponent()
// {


//       const {propertyId}=useParams();
//   console.log(propertyId);
//         policyholderservice.viewProperty(propertyId).then(res => {

//             this.setState({ property: res.data });
//         })

//         return (
//                         <div>
//                             <div className="card col-md-6 offset-md-3">
//                                 <h3 className="text-center">View Property Details</h3>
//                                 <div className="card-body">
//                                     <div className="row">
//                                         <label>Market Value: </label>
//                                         <div>{this.state.property.marketValue}</div>
//                                     </div>
//                                     <div className="row">
//                                         <label>Year Built</label>
//                                         <div>{this.state.property.yearBuilt}</div>
//                                     </div>
//                                     <div className="row">
//                                         <label>Square Footage </label>
//                                         <div>{this.state.property.squareFootage}</div>
//                                     </div>
//                                     {/* button className="btn btn-danger" onClick={this.cancel.bind(this)} style={<{ marginLeft: "10px" }}>Go Back</button> */}
//                                 </div>
//                             </div>
//                         </div>
//                     );


// }
// export default ViewPropertyComponent;






