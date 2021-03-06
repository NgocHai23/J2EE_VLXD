package vlxd.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vlxd.dto.VendorDTO;

public class VendorMapper extends DBMapper {
	
	public VendorMapper() throws Exception {
		super(); // call constructor DBMapper -- get connection
	}

	public void createVendor(VendorDTO newVendor) {
		try {
			String sqlStr = "INSERT into vendor (name,address,phone,email,debt) VALUE (?,?,?,?,?)";

			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, newVendor.getName());
			preparedStmt.setString(2, newVendor.getAddress());
			preparedStmt.setString(3, newVendor.getPhone());
			preparedStmt.setString(4, newVendor.getEmail());
			preparedStmt.setString(5, String.valueOf(0));

			preparedStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<VendorDTO> listVendor() {
		ArrayList<VendorDTO> vendors = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM vendor";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				VendorDTO vendor = new VendorDTO();
				vendor.setId(rs.getInt("id"));
				vendor.setName(rs.getString("name"));
				vendor.setAddress(rs.getString("address"));
				vendor.setPhone(rs.getString("phone"));
				vendor.setEmail(rs.getString("email"));
				vendor.setDebt(rs.getString("debt"));
				vendor.setCreatedAt(rs.getTimestamp("created_at"));
				vendor.setUpdatedAt(rs.getTimestamp("updated_at"));

				vendors.add(vendor);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return vendors;
	}
	
	public VendorDTO searchVendorById(Integer id) {
		VendorDTO vendor = new VendorDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM vendor WHERE id=" + id;
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				vendor.setId(rs.getInt("id"));
				vendor.setName(rs.getString("name"));
				vendor.setAddress(rs.getString("address"));
				vendor.setPhone(rs.getString("phone"));
				vendor.setEmail(rs.getString("email"));
				vendor.setDebt(rs.getString("debt"));
				vendor.setCreatedAt(rs.getTimestamp("created_at"));
				vendor.setUpdatedAt(rs.getTimestamp("updated_at"));
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return vendor;
	}

	public ArrayList<VendorDTO> searchVendor(String searchParameter) {
		ArrayList<VendorDTO> vendors = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM vendor "
					+ "WHERE id=trim('" + searchParameter + "') "
					+ "OR name LIKE '%" + searchParameter + "%' ";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				VendorDTO vendor = new VendorDTO();
				vendor.setId(rs.getInt("id"));
				vendor.setName(rs.getString("name"));
				vendor.setAddress(rs.getString("address"));
				vendor.setPhone(rs.getString("phone"));
				vendor.setEmail(rs.getString("email"));
				vendor.setDebt(rs.getString("debt"));
				vendor.setCreatedAt(rs.getTimestamp("created_at"));
				vendor.setUpdatedAt(rs.getTimestamp("updated_at"));

				vendors.add(vendor);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return vendors;
	}
	
	public void updateDebtOfVendor(VendorDTO vendor) {
		try {
			String sqlStr = "UPDATE vendor SET debt=?, updated_at=? WHERE id=?";
			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, vendor.getDebt());
			preparedStmt.setTimestamp(2, vendor.getUpdatedAt());
			preparedStmt.setInt(3, vendor.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void editVendor(VendorDTO vendor) {
		try {
			String sqlStr = "UPDATE vendor SET name=?, address=?, phone=?, email=?, updated_at=? WHERE id=?";
			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, vendor.getName());
			preparedStmt.setString(2, vendor.getAddress());
			preparedStmt.setString(3, vendor.getPhone());
			preparedStmt.setString(4, vendor.getEmail());
			preparedStmt.setTimestamp(5, vendor.getUpdatedAt());
			preparedStmt.setInt(6, vendor.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteVendor(VendorDTO vendor) {
		try {
			String sqlStr = "DELETE FROM vendor WHERE id=?";
			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);
			preparedStmt.setInt(1, vendor.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
