package com.projectone.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.projectone.model.EmployeeUser;
import com.projectone.model.Reimbursement;
import com.projectone.util.ConnectionUtility;

public class ReimbursementDaoJDBC implements ReimbursementDao {

	/* This an optional feature, will be tackled if there time is left*/
	@Override
	public Reimbursement cancelRequestByEmployee(int employeeId, int requestId) {
		
		return null;
	}

	@Override
	public Reimbursement updateRequestByMgr(Reimbursement updateReimb) {
		
		//Reimbursement updateReimb = new Reimbursement();
		
		System.out.print("What they want, TO UPDATE:");
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			PreparedStatement prepStmt = conn.prepareStatement("UPDATE paymentsystems.ers_reimbursement\n" 
			+ "SET reimb_resolved=?,reimb_resolver=?, reimb_status_id=?\n" 
			+ "WHERE reimb_id = ?");
			
			
			prepStmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			prepStmt.setInt(2, updateReimb.getReimbResolverId());
			prepStmt.setInt(3, updateReimb.getReimbStatusId());
			prepStmt.setInt(4, updateReimb.getReimbId());
			
			prepStmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int addRequestByEmployee(Reimbursement newReimb) {
		
		System.out.println("It is funny how the act now!");
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			
			PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO paymentsystems.ers_reimbursement(\n" 
			+ "reimb_amount, reimb_submitted, reimb_resolved, reimb_receipt, reimb_author,\n"
			+ "reimb_resolver, reimb_status_id, reimb_type_id, reimb_description)\n" 
			+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", new String[] {"reimb_id"});
			
			prepStmt.setDouble(1 , newReimb.getReimbAmount());
			prepStmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			prepStmt.setTimestamp(3,  new Timestamp(System.currentTimeMillis()));
			prepStmt.setString(4, newReimb.getReimbReciept());
			prepStmt.setInt(5, newReimb.getReimbAuthorId());
			prepStmt.setInt(6, newReimb.getReimbResolverId());
			prepStmt.setInt(7, newReimb.getReimbStatusId());
			prepStmt.setInt(8, newReimb.getReimbTypeId());
			prepStmt.setString(9, newReimb.getReimbDescription());
			
			prepStmt.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<Reimbursement> findRequestAllEmployees() {
		
		try(Connection conn = ConnectionUtility.getConnection()){
					
			PreparedStatement prepStmt = conn.prepareStatement("SELECT ers_reimbursement.reimb_amount, \n" + 
					" ers_reimbursement.reimb_id,\n" + 
					" ers_reimbursement.reimb_submitted,\n" + 
					" ers_reimbursement.reimb_resolved,\n" + 
					" ers_reimbursement.reimb_receipt,\n" + 
					" ers_reimbursement.reimb_amount,\n" + 
					" ers_reimbursement.reimb_description,\n" + 
					" ers_users.ers_user_id,\n" + 
					" ers_users.user_first_name,\n" + 
					" ers_users.user_last_name,\n" + 
					" ers_reimbursement_type.reimb_type,\n" + 
					" ers_reimbursement_status.reimb_status\n" + 
					" FROM ers_reimbursement\n" + 
					" LEFT JOIN ers_users ON ers_reimbursement.reimb_author= ers_users.ers_user_id\n" + 
					" LEFT JOIN ers_reimbursement_status ON ers_reimbursement.reimb_status_id = ers_reimbursement_status.reimb_status_id\n" + 
					" LEFT JOIN ers_reimbursement_type ON ers_reimbursement.reimb_type_id = ers_reimbursement_type.reimb_type_id");

			ResultSet rstSet = prepStmt.executeQuery();

			List<Reimbursement> reimbursementRqt = new ArrayList<>();

			while (rstSet.next()) {
				reimbursementRqt.add(new Reimbursement(rstSet.getInt("reimb_id"),
						rstSet.getDouble("reimb_amount"),
						rstSet.getString("reimb_description"),
						rstSet.getString("reimb_receipt"),
						new EmployeeUser(rstSet.getInt("ers_user_id"),rstSet.getString("user_first_name"),rstSet.getString("user_last_name"), null, null),
						rstSet.getString("reimb_status"),
						rstSet.getString("reimb_type"),
						rstSet.getTimestamp("reimb_submitted"), 
						rstSet.getTimestamp("reimb_resolved")));
			}

			return reimbursementRqt;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Reimbursement> findAllRequestsForEmployee(int reimbAuthorId) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {

			List<Reimbursement> reimbursementRqt = new ArrayList<>();
			PreparedStatement prepStmt = conn
					.prepareStatement("SELECT ers_reimbursement.reimb_amount,\n "+ 					
							" ers_reimbursement.reimb_id,\n" + 
							" ers_reimbursement.reimb_submitted,\n" + 
							" ers_reimbursement.reimb_resolved,\n" + 
							" ers_reimbursement.reimb_receipt,\n" + 
							" ers_reimbursement.reimb_amount,\n" + 
							" ers_reimbursement.reimb_description,\n" + 
							" ers_users.ers_user_id,\n" + 
							" ers_users.user_first_name,\n" + 
							" ers_users.user_last_name,\n" + 
							" ers_reimbursement_type.reimb_type,\n" + 
							" ers_reimbursement_status.reimb_status FROM ers_reimbursement\n" + 
							" LEFT JOIN ers_users ON ers_reimbursement.reimb_resolver = ers_users.ers_user_id\n" + 
							" LEFT JOIN ers_reimbursement_status ON ers_reimbursement.reimb_status_id = ers_reimbursement_status.reimb_status_id\n" + 
							" LEFT JOIN ers_reimbursement_type ON ers_reimbursement.reimb_type_id = ers_reimbursement_type.reimb_type_id \n" + 
							" WHERE reimb_author = ?");
			
			prepStmt.setInt(1, reimbAuthorId);

			ResultSet rstSet = prepStmt.executeQuery();

			while (rstSet.next()) {
				reimbursementRqt.add(new Reimbursement(rstSet.getInt("reimb_id"),
						rstSet.getDouble("reimb_amount"),
						rstSet.getString("reimb_description"),
						rstSet.getString("reimb_receipt"),
						new EmployeeUser(rstSet.getInt("ers_user_id"),rstSet.getString("user_first_name"),rstSet.getString("user_last_name"), null, null),
						rstSet.getString("reimb_status"),
						rstSet.getString("reimb_type"),
						rstSet.getTimestamp("reimb_submitted"), 
						rstSet.getTimestamp("reimb_resolved")));
			}
			return reimbursementRqt;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}
	
}