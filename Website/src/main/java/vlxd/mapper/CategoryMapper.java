package vlxd.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vlxd.dto.CategoryDTO;

public class CategoryMapper extends DBMapper {
	
	public CategoryMapper() throws Exception {
		super(); // call constructor DBMapper -- get connection
	}

	public void createCategory(CategoryDTO newCategory) {
		try {
			String sqlStr = "INSERT into category (name) VALUE (?)";

			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, newCategory.getName());
			
			preparedStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CategoryDTO> listCategory() {
		ArrayList<CategoryDTO> categories = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM category";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				CategoryDTO category = new CategoryDTO();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));

				categories.add(category);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return categories;
	}
	
	public CategoryDTO searchCategoryById(Integer id) {
		CategoryDTO category = new CategoryDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM category WHERE id=" + id;
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return category;
	}
	
	public void editCategory(CategoryDTO category) {
		try {
			String sqlStr = "UPDATE category SET name=? WHERE id=?";
			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, category.getName());
			preparedStmt.setInt(2, category.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteCategory(CategoryDTO category) {
		try {
			String sqlStr = "DELETE FROM category WHERE id=?";
			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);
			preparedStmt.setInt(1, category.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
