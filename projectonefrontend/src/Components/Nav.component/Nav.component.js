import React from 'react';
import {Link} from 'react-router-dom';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import RevLogo from '../../Assets/rev-logo.png';
import '../../App.css'; 

export class AppNav extends React.Component {
  
  aboutUsHandler = (e)=>{
    window.location = 'https://revature.com/our-story/'
  }

  render() {
    return (
      <div >
        <nav id="forHeader" className="navbar navbar-toggleable-md navbar-expand-lg navbar-light bg-light display-front nav-pad">
          <div className="navbar-header c-pointer shift-left">
            <Link to="/sign-in-employee" className="unset-anchor">
              <img className="img-adjust-position rev-logo" src={RevLogo} alt="revature" />
            </Link>
          </div>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarsExample04">
            <ul className="navbar-nav ml-auto margin-nav">
              {/* <li className="nav-item active">
                <Link to="/home" className="unset-anchor nav-link"><button type="button" className="btn btn-dark">Home</button></Link>
              </li> */}
              <li className="nav-item active">
                <Link to="" className="unset-anchor nav-link">
                <div className="dropdown">
                  <button className="btn btn-dark dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Sign In </button>
                    <div className="dropdown-menu" aria-labelledby="dropdownMenu2">
                        <Link to="/sign-in-employee" className="unset-anchor nav-link">
                            <button className="dropdown-item" type="button">Sign In Employee</button>
                        </Link>
                        <Link to="/sign-in-manager" className="unset-anchor nav-link">
                            <button className="dropdown-item" type="button">Sign In Manager</button>
                        </Link>
                    </div>
                </div>
                </Link>
              </li>
              <li className="nav-item active">
                <Link to="/sign-up" className="unset-anchor nav-link"><button type="button" className="btn btn-dark">Sign Up</button></Link>
              </li>
              <li className="nav-item active">
                <Link to="" className="unset-anchor nav-link"><button type="button" className="btn btn-dark" onClick={this.aboutUsHandler}>About</button></Link>
              </li>
            </ul>
          </div>
        </nav>
      </div>
    );
  }
}

