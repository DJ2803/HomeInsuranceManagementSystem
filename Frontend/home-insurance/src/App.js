// import logo from './logo.svg';
// import './App.css';
// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
// import logincomponent from './components/logincomponent';
// import signupcomponent from './components/signupcomponent'
// import PolicyHoldercomponent from './components/PolicyHoldercomponent';
// import viewpolicyholdercomponent from  './components/viewpolicyholdercomponent';
// import updatepolicyholdercomponent from  './components/updatepolicyholdercomponent';
// import { BrowserRouter as Router, Switch, Route, Link,useParams } from "react-router-dom";
// import AddPropertyComponent from './components/AddPropertyComponent';
// import ViewPropertyComponent from './components/ViewPropertyComponent';
// import AdminComponent from './components/AdminComponent';
// import AgentComponent from './components/AgentComponent'
// import PolicyHolderActions from './components/PolicyHolderActions'
// function App() {
//   return (
//     <Router>
//         <div className="inner">
//           <Switch>
//             <Route exact path='/' component={signupcomponent} />
//             <Route path="/signup" component={signupcomponent} />
//             <Route path="/login" component={logincomponent} />
//             <Route path="/policyholders" component={PolicyHoldercomponent} />
//             <Route path= "/update-policyholder/:policyHolderId" component={PolicyHolderActions} />
//             <Route path="/view-policyholder/:policyHolderId" component={viewpolicyholdercomponent} />
//             <Route path = "/add-property/:id" component= {AddPropertyComponent}></Route> 
//             <Route path = "/view-property/:id" component= {ViewPropertyComponent}></Route> 
//             <Route path = "/admin" component= {AdminComponent}></Route> 
//             <Route path = "/agent" component= {AgentComponent}></Route> 
//           </Switch>
//         </div>
//     </Router >)
// }

// export default App;







import logo from './logo.svg';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import logincomponent from './components/logincomponent';
import signupcomponent from './components/signupcomponent'
import PolicyHolderHomePagecomponent from './components/PolicyHolderHomePageComponent'
import PolicyHolderComponent from './components/PolicyHolderComponent1';
// import PolicyHolderActions from './components/PolicyHolderActions'
import ViewPolicyComponent from './components/ViewPolicyComponent';
import viewpolicyholdercomponent from  './components/viewpolicyholdercomponent';
import updatepolicyholdercomponent from  './components/updatepolicyholdercomponent';
import { BrowserRouter as Router, Switch, Route, Link,useParams } from "react-router-dom";
import AddPropertyComponent from './components/AddPropertyComponent';
import ViewPropertyComponent from './components/ViewPropertyComponent';
import ViewQuoteComponent from './components/ViewQuoteComponent';
import quotelist from './components/quote-list.component';
import policylist from './components/Policy-listComponent';
import updatequote from './components/UpdateQuoteComponent';
import updatepolicy from './components/updatepolicycomponent';
// import AdminComponent from './components/AdminComponent';
// import AgentComponent from './components/AgentComponent'
import PolicyHolderActions from './components/PolicyHolderActions'
function App() {
  return (
    <Router>
      <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to={"/"} className="navbar-brand">
            HOME INSURANCE
          </Link>


          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"#"} className="nav-link">
                ABOUT
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"#"} className="nav-link">
                CONTACT US
              </Link>
            </li>


          </div>
        </nav>
        <div className="inner">
          <Switch>
            <Route exact path='/' component={signupcomponent} />
            <Route path="/signup" component={signupcomponent} />
            <Route path="/login" component={logincomponent} />
            <Route path="/policyholderhomepage" component={PolicyHolderHomePagecomponent} />
            <Route path="/policyholders" component={PolicyHolderComponent} />
            <Route path= "/update-policyholder/:policyHolderId" component={PolicyHolderActions} />
            <Route path="/view-policyholder/:userName" component={viewpolicyholdercomponent} />
            <Route path = "/add-property/:id" component= {AddPropertyComponent}></Route> 
            <Route path = "/view-property/:id" component= {ViewPropertyComponent}></Route> 
            <Route path="/quotes/:id"component={quotelist}></Route>
            <Route path = "/view-policy/:id" component= {ViewPolicyComponent}></Route> 
            <Route path = "/view-quote/:id" component= {ViewQuoteComponent}></Route> 
            <Route path = "/update-quote/:id1/:id2" component= {updatequote}></Route> 
            <Route path = "/policies/:id" component= {policylist}></Route> 
            <Route path = "/update-policy/:id1/:id2" component= {updatepolicy}></Route> 

          </Switch>
        </div>
    </Router >)
}

export default App;
