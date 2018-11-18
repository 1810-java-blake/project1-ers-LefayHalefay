import React from 'react';
import { EmployeeDashboardComponent } from '../Employee.component/EmployeeDashboard.component';
export class SignInEmployeeComponent extends React.Component{
   
   constructor(props){
      super(props);
      this.state ={
            username: '',
            password: '',
            employeeInfo: []
      }
   }

   passwordChange = (e) => {
      this.setState({
        ...this.state,
        password: e.target.value
      })
    }
  
    usernameChange = (e) => {
      this.setState({
        ...this.state,
        username: e.target.value
      })
    }
  
    submit = (e) => {
      e.preventDefault();
      let cred = {
         username: this.state.username,
         password: this.state.password
      }

      fetch('http://localhost:8080/ProjectOne1/Reimbursement/employee/userLogin', {
        method: 'POST',
        body: JSON.stringify(cred),
        headers: {
          'Content-Type': 'application/json'
        },
        credentials: 'include'
      })
        .then(res => {
         console.log("I logged in Kiddos!");
         if (res.status === 200) {
            fetch('http://localhost:8080/ProjectOne1/Reimbursement/employee/byUsername/msngre')
           .then(res=> res.json()).then()
            .then(data => {
               this.setState({
                     ...this.state,
                     employeeInfo: data   
               })
               console.log(data)
           })
           .catch(err=>{
              console.log(err);
           })
            
           this.props.history.push('/employee-dashboard');
           
          } else if(res.status === 403){
            alert("Wrong Username or Password Entered!");
          }
        })
        .catch(err => {
          console.log(err);
        })
    }
   render(){
      return(
         <>
         <EmployeeDashboardComponent data={this.state.employeeInfo}/>
         <div className="backgroundForBody" >
            <div className="container py-5">
               <div className="row">
                  <div className="backgroundForPages card mx-auto col-sm-6 mb-4">
                     <h1 className="text-center"> Employee Portal </h1>
                        <div className="mx-auto">
                           <div className="col-md-5"></div>
                              <div className="card rounded-0">
                              <div className="card-header">
                                 <h3 className="mb-0">Login</h3>
                              </div>
                                 <div className="card-body">
                                    <form className="form" autoComplete="" id="formLogin" onSubmit={this.submit} noValidate="">
                                       <div className="form-group">
                                       <label htmlFor="input-username">Username</label>
                                       <input type="text" 
                                          className="form-control form-control-lg rounded-0" 
                                          name="input-username" 
                                          id="input-username" 
                                          required
                                             value={this.state.username}
                                             onChange={this.usernameChange}
                                          />
                                          <div className="invalid-feedback">Oops, you missed this one.</div>
                                     </div>
                                       <div className="form-group">
                                          <label htmlFor="input-password">Password</label>
                                          <input type="password" 
                                             className="form-control form-control-lg rounded-0" 
                                             id="input-password" required  autoComplete="new-password"
                                             value={this.state.password}
                                             onChange={this.passwordChange}/>
                                             <div className="invalid-feedback">Enter your password too!</div>
                                       </div>
                                       <button type="submit" 
                                          className="btn btn-dark btn-lg float-right" 
                                          id="btnLogin">Sign In</button>
                                    </form>
                              </div>
                        </div>
                        <div className="mb-5"> </div>
                     </div>
                  </div>
               </div>  
            </div>   
         </div>  
      </>          
      );
   }
}

