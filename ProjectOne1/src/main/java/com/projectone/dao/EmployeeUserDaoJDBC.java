package com.projectone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projectone.model.EmployeeUser;
import com.projectone.model.EmployeeUserRole;
import com.projectone.model.Reimbursement;
import com.projectone.util.ConnectionUtility;

public class EmployeeUserDaoJDBC implements EmployeeUserDao {

	@Override
	public List<EmployeeUser> findById(int id) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT ers_users.ers_username, \n" + 
					"ers_users.ers_user_id,\n" + 
					"ers_users.user_first_name,\n" + 
					"ers_users.user_last_name,\n" + 
					"ers_users.user_email,\n" + 
					"ers_user_roles.ers_user_roles_id,\n" + 
					"ers_user_roles.user_role\n" + 
					"FROM ers_users LEFT JOIN ers_user_roles ON ers_users.ers_user_role_id = ers_user_roles.ers_user_roles_id WHERE ers_user_id = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			List<EmployeeUser> employeeUserList = new ArrayList<>();
			
			while (rs.next()) {
				
				employeeUserList.add(new EmployeeUser(rs.getInt("ers_user_id"),rs.getString("ers_username"),rs.getString("user_first_name"),rs.getString("user_last_name"),
						new EmployeeUserRole(rs.getInt("ers_user_roles_id"), rs.getString("user_role"))));
			}
			
			return employeeUserList;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<EmployeeUser> findByUsername(String username) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT ers_users.ers_username, \n"
					+ "ers_users.ers_user_id,\n" + "ers_users.user_first_name,\n" + "ers_users.user_last_name,\n"
					+ "ers_users.user_email,\n" + "ers_user_roles.ers_user_roles_id,\n" + "ers_user_roles.user_role\n"
					+ "FROM ers_users LEFT JOIN ers_user_roles ON ers_users.ers_user_role_id = ers_user_roles.ers_user_roles_id WHERE ers_username = ?");

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			List<EmployeeUser> employeeUserList = new ArrayList<>();

			while (rs.next()) {

				employeeUserList.add(new EmployeeUser(rs.getInt("ers_user_id"), rs.getString("ers_username"),
						rs.getString("user_first_name"), rs.getString("user_last_name"),
						new EmployeeUserRole(rs.getInt("ers_user_roles_id"), rs.getString("user_role"))));
			}

			return employeeUserList;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EmployeeUser> findAll() {
		
		try (Connection conn = ConnectionUtility.getConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT ers_users.ers_username, \n"
					+ "ers_users.ers_user_id,\n" + "ers_users.user_first_name,\n" + "ers_users.user_last_name,\n"
					+ "ers_users.user_email,\n" + "ers_user_roles.ers_user_roles_id,\n" + "ers_user_roles.user_role\n"
					+ "FROM ers_users LEFT JOIN ers_user_roles ON ers_users.ers_user_role_id = ers_user_roles.ers_user_roles_id");

			ResultSet rs = ps.executeQuery();

			List<EmployeeUser> employeeUserList = new ArrayList<>();

			while (rs.next()) {

				employeeUserList.add(new EmployeeUser(rs.getInt("ers_user_id"), rs.getString("ers_username"),
						rs.getString("user_first_name"), rs.getString("user_last_name"),
						new EmployeeUserRole(rs.getInt("ers_user_roles_id"), rs.getString("user_role"))));
			}

			return employeeUserList;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EmployeeUser findByUsernameAndPassword(String username, String password) {
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM ers_users LEFT JOIN ers_user_roles ON ers_users.ers_user_role_id = ers_user_roles.ers_user_roles_id WHERE ers_username = ? AND ers_password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return (new EmployeeUser(rs.getInt("ers_user_id"), rs.getString("ers_username"),
						rs.getString("user_first_name"), rs.getString("user_last_name"),
						new EmployeeUserRole(rs.getInt("ers_user_roles_id"), rs.getString("user_role"))));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}


}
