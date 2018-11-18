import React from 'react';
import { SignInEmployeeComponent } from '../SignIn.component/SignInEmployee.component';


export class EmployeeDashboardComponent extends React.Component {
   
   constructor(props){
      super(props);
      
      this.state = {
         reimbRequests: [ ],
         reimbRequestObjet: {
            reimbId: '',
            reimbAmount: '',
            reimbDescription: '',
            reimbReciept: '',
            reimbAuthorId: '',
            reimbResolverId: 3,
            reimbStatusId: 1,
            reimbTypeId: '',
            reimbSubmitted: '',
            reimbResolved: '' 
         }
      }
        
   }
   componentDidMount(){
      fetch('http://localhost:8080/ProjectOne1/Reimbursement/request/employee/1')
      .then(res => res.json()).then()
      .then(data => {
         this.setState({
               ...this.state,
               reimbRequests: data   
         })  
         console.log(data);  
      })
      .catch(err => {
            console.log(err);
      }); 
      
   }
   submitRequest = (e) =>{
      this.setState({
         ...this.state
      });

      console.log(this.state.reimbRequestObjet);
      console.log("from the component");
      console.log(this.state);
   }

   handleReimbAmount = (e)=>{
      this.setState({
         ...this.state,
         reimbAmount: e.target.value
      })
   }
   handleReimbDescription = (e)=>{
      this.setState({
         ...this.state,
         reimbDescription: e.target.value
      })
   }
   handleReimbTypeSelect = (e)=>{
      this.setState({
         ...this.state,
         reimbTypeId: e.target.value
      })
   }

   logOutEmployee = (e) =>{
      setTimeout(
         function() {
            this.props.history.push('/sign-in-employee');
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
      var first = this.props.emloyeeInfo;
      console.log(first);
      return(
         <>
         {/* <SignInEmployeeComponent value={this.state.value}/> */}
         <div className="col-sm-16 mx-auto">
            <div className="navbar navbar-light bg-dark flex-row-sb mt-1 mb-2">
               <div> <h1 className="emp-mgr-dashboard">Employee Dashboard</h1> </div>
               <div><button id = "add-request-btn" type="button" className="btn btn-primary" data-toggle="modal" data-target="#add-Request-Modal"> Add Request</button></div>
               <form className="form" id="add-request-form" onSubmit={this.submitRequest}>
               <div className="modal fade" id="add-Request-Modal" tabIndex="-1" role="dialog" aria-labelledby="add-Request-ModalLabel" aria-hidden="true">
                  <div className="modal-dialog modal-dialog-centered" role="document">
                     <div className="modal-content">
                        <div className="modal-header" id="forHeader">
                           <h5 className="modal-title" id="add-Request-Modal">Reimbursement Request </h5>
                           <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">&times;</span>
                           </button>
                        </div>
                        <div className="modal-body form-group">
                              <div className="row">
                                 <div className="col">
                                    <label htmlFor="requestControlSelect">Amount</label>
                                    <input type="number" className="form-control" placeholder="$ Enter amount"
                                       value={this.state.reimbAmount}
                                       onChange={this.handleReimbAmount}
                                    />
                                 </div>
                                 <div className="col">
                                    <div className="form-group">
                                       <label htmlFor="requestControlSelect">Type</label>
                                       <select className="form-control" id="requestControlSelect"
                                          value={this.state.reimbTypeId} onChange={this.handleReimbTypeSelect} >
                                          <option value="1">LODGING</option>
                                          <option value="2">TRAVEL</option>
                                          <option value="3">FOOD</option>
                                          <option value="4">OTHER</option>
                                       </select>
                                    </div>
                                 </div>
                              </div>
                              <div className="form-group col">
                                 <label htmlFor="requestControlTextarea">Description</label>
                                 <textarea className="form-control" id="requestControlTextarea" rows="2"
                                    value={this.state.reimbDescription} onChange={this.handleReimbDescription}
                                 />
                              </div>
                              <div className="col form-group">
                                 <label htmlFor="requestControlFile">Upload Reciept</label>
                                 <input type="file" className="form-control-file" id="requestControlFile" />
                              </div>
                          
                        </div>
                        <div className="modal-footer">
                           <div className="row">
                              <div className="col">
                                 <button type="button" className="btn btn-danger" data-dismiss="modal">Cancel</button>
                              </div>
                              <div className="col">
                                 <button type="submit" className="btn btn-success" data-dismiss="modal"onClick={this.submitRequest}>Save changes</button>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               </form>
               <div>
                   <div><button id = "employee-signout-btn" type="button" className="btn btn-danger" onClick={this.logOutEmployee}> Sign Out</button></div>
               </div>
            </div>
            <table className="col-sm-11 mx-auto table table-bordered table-hover mt-5">
               <thead className="thead-dark table-striped">
                  <tr>
                     <th scope="col">#</th>
                     <th scope="col"> Date Requested </th>
                     <th scope="col"> Type </th>
                     <th scope="col"> Amount </th>
                     <th scope="col"> Status </th>
                     <th scope="col"> Date Resolved </th>
                     <th scope="col"> Resolver </th>
                     <th scope="col"> Description </th> 
                  </tr>
               </thead>
               <tbody className=" table-striped" id="requests-container">
                  {this.state.reimbRequests.map((reimbRequests, index) => (
                     <tr>
                        <th scope="row">{index + 1}</th>
                        <td>{this.timeConverter(reimbRequests.reimbSubmitted)}</td>
                        <td>{reimbRequests.reimbType}</td>
                        <td><span>$</span>{reimbRequests.reimbAmount}<span>.00</span></td>
                        <td>{reimbRequests.reimbStatus}</td>
                        <td>{this.timeConverter(reimbRequests.reimbResolved)}</td>
                        <td>{reimbRequests.employeeUser.ersUserFirstName}</td>
                        <td>{reimbRequests.reimbDescription}</td>
                     </tr>
                  ))}
               </tbody>
            </table>
            <div className="mb-5"> </div>
         </div>
         </>
      );
   }
}