import React, {Component} from 'react';
import './Include/bootstrap';
import './App.css';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import {AppNav} from './Components/Nav.component/Nav.component';
import {SignInEmployeeComponent} from './Components/SignIn.component/SignInEmployee.component';
import {SignInManagerComponent} from './Components/SignIn.component/SignInManager.component';
import {HomeComponent} from './Components/Home.component/Home.component';
import {SignUpComponent} from './Components/SignUp.component/SignUp.component';
import {AboutUsComponent} from './Components/AboutUs.component';
import {ManagerDashComponent} from './Components/Manager.component/ManagerDash.component';
import {EmployeeDashboardComponent} from './Components/Employee.component/EmployeeDashboard.component';


class App extends Component { 
  render() {
    return (
      <BrowserRouter>
      <>
        <AppNav/>
          <div id="main-content-container">
            <Switch>
                <Route path="/sign-in-employee"   component={SignInEmployeeComponent}/>
                <Route path="/sign-in-manager"    component={SignInManagerComponent}/>
                <Route path="/employee-dashboard" component={EmployeeDashboardComponent}/>
                <Route path="/manager-dashboard"  component={ManagerDashComponent}/>
                <Route path="/sign-up"            component={SignUpComponent}/>
                {/* default */}
                 <Route component={SignInEmployeeComponent} />
            </Switch>
          </div>
      </>
      </BrowserRouter>
    );
  }
}
export default App;
