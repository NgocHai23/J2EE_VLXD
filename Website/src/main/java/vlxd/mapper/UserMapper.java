package vlxd.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vlxd.dto.UserDTO;

public class UserMapper extends DBMapper {
	
	public UserMapper() throws Exception {
		super(); // call constructor DBMapper -- get connection
	}

	public UserDTO loginUser(UserDTO user) {
		UserDTO userLogined = new UserDTO();
		try {
			String sqlStr = "SELECT * FROM user WHERE username=? AND password=? AND status=1";

			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);
			preparedStmt.setString(1, user.getUsername());
			preparedStmt.setString(2, user.getPassword());
			
			ResultSet rs = preparedStmt.executeQuery(); // Send the query to the server
			while (rs != null && rs.next()) {
				userLogined.setId(rs.getInt("id"));
				userLogined.setName(rs.getString("name"));
				userLogined.setEmail(rs.getString("email"));
				userLogined.setPhone(rs.getString("phone"));
				userLogined.setUsername(rs.getString("username"));
				userLogined.setRole(rs.getString("role"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return userLogined;
	}

	public void createUser(UserDTO newUser) {
		try {
			String sqlStr = "INSERT into user (name,email,phone,username,password,role,avatar) "
					+ "VALUE (?,?,?,?,?,?,?)";

			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, newUser.getName());
			preparedStmt.setString(2, newUser.getEmail());
			preparedStmt.setString(3, newUser.getPhone());
			preparedStmt.setString(4, newUser.getUsername());
			preparedStmt.setString(5, newUser.getPassword());
			preparedStmt.setString(6, newUser.getRole());
			preparedStmt.setString(7, newUser.getAvatar());
//			if (newUser.getAgency_id() == null) {
//				preparedStmt.setNull(8, Types.INTEGER);
//			} else {
//				preparedStmt.setInt(8, newUser.getAgency_id());
//			}
			preparedStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<UserDTO> checkUserAvailable(String username) {
		ArrayList<UserDTO> users = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM user WHERE username='" + username + "' AND status=1 LIMIT 1";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				UserDTO user = new UserDTO();
				user.setUsername(rs.getString("username"));

				users.add(user);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return users;
	}

	public ArrayList<UserDTO> listUser() {
		ArrayList<UserDTO> users = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM user WHERE status=1";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				UserDTO user = new UserDTO();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setRole(rs.getString("role"));
				user.setCreatedAt(rs.getTimestamp("created_at"));
				user.setUpdatedAt(rs.getTimestamp("updated_at"));

				users.add(user);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return users;
	}
	
	public UserDTO searchUserById(Integer id) {
		UserDTO user = new UserDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM user "
					+ "WHERE id=" + id + " AND status=1";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setRole(rs.getString("role"));
				user.setCreatedAt(rs.getTimestamp("created_at"));
				user.setUpdatedAt(rs.getTimestamp("updated_at"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return user;
	}

	public ArrayList<UserDTO> searchUser(String searchParameter) {
		ArrayList<UserDTO> users = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM user "
					+ "WHERE id=trim('" + searchParameter + "') "
					+ "OR name LIKE '%" + searchParameter + "%' "
					+ "AND status=1";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				UserDTO user = new UserDTO();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setRole(rs.getString("role"));
				user.setCreatedAt(rs.getTimestamp("created_at"));
				user.setUpdatedAt(rs.getTimestamp("updated_at"));

				users.add(user);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return users;
	}

	public void editUser(UserDTO user) {
		try {
			String sqlStr = "UPDATE user "
					+ "SET name=?, email=?, phone=?, role=?, username=?, updated_at=? "
					+ "WHERE id=? AND status=1";
			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, user.getName());
			preparedStmt.setString(2, user.getEmail());
			preparedStmt.setString(3, user.getPhone());
			preparedStmt.setString(4, user.getRole());
			preparedStmt.setString(5, user.getUsername());
			preparedStmt.setTimestamp(6, user.getUpdatedAt());
			preparedStmt.setInt(7, user.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteUser(UserDTO user) {
		try {
			String sqlStr = "UPDATE user SET status=0, updated_at=? WHERE id=? AND status=1";

			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);
			preparedStmt.setTimestamp(1, user.getUpdatedAt());
			preparedStmt.setInt(2, user.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
