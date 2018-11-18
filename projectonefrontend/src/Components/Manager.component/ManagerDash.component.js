import React from 'react';


export class ManagerDashComponent extends React.Component {
   
   constructor(props){
      super(props);

      this.state = {
         employeeRequests:[]
      }
   }
   
   componentDidMount(){
      fetch('http://localhost:8080/ProjectOne1/Reimbursement/request/allEmployees')
      .then(res => res.json()).then()
      .then(data => {
         this.setState({
               ...this.state,
               employeeRequests: data   
         })  
         console.log(data);  
      })
      .catch(err => {
            console.log(err);
      }); 
      
   }

   logOutManager = (e) =>{
      setTimeout(
         function() {
            this.props.history.push('/sign-in-manager');
         }.bind(this),
         1000
         );
   }

   timeConverter (UNIX_timestamp){
      let a = new Date(UNIX_timestamp);
      let months = ['1','2','3','4','5','6','7','8','9','10','11','12'];
      let year = a.getFullYear();
      let month = months[a.getMonth()];
      let date = a.getDate();
      let hour = a.getHours();
      let min = a.getMinutes();
      //let  sec = a.getSeconds();
      let time = month + '/' + date + '/' + year + ' ' + hour + ':' + min;
      return time;
   };

   render(){
      return(
         <div className="col-sm-16 mx-auto">
            <div className="navbar navbar-secondary bg-dark flex-row-sb mt-2 mb-2">
               <div> <h1 className="emp-mgr-dashboard"> Manager Dashboard</h1> </div>
               <div>
                   <div><button id = "employee-signout-btn" type="button" className="btn btn-danger" onClick={this.logOutManager}> Sign Out</button></div>
               </div>
            </div>
            <table className="col-sm-10 mx-auto table table-bordered table-hover mt-5">
               <thead className="thead-dark table-hover table-striped">
                  <tr>
                     <th scope="col">#</th>
                     <th scope="col"> Employee Name </th>
                     <th scope="col"> Date Requested </th>
                     <th scope="col"> Amount </th>
                     <th scope="col"> Type </th>
                     <th scope="col"> Status </th>
                     <th scope="col"> Resolved On </th>
                     <th scope="col"> Description </th>
                  </tr>
               </thead>
               <tbody className="table-striped">
                  {this.state.employeeRequests.map((employeeRequests, index) => (
                     <tr>
                        <th scope="row">{index + 1}</th>
                        <td>{employeeRequests.employeeUser.ersUserName +" "+ employeeRequests.employeeUser.ersUserFirstName}</td>
                        <td>{this.timeConverter(employeeRequests.reimbSubmitted)}</td>
                         <td><span>$</span>{employeeRequests.reimbAmount}<span>.00</span></td>
                        <td>{employeeRequests.reimbType}</td>
                        <td>{employeeRequests.reimbStatus}</td>
                        <td>{this.timeConverter(employeeRequests.reimbResolved)}</td>
                        <td>{employeeRequests.reimbDescription}</td>
                     </tr>
                  ))}
                  
               </tbody>
            </table>
            <div className="mb-5"> </div>
         </div>
      );

   }
}