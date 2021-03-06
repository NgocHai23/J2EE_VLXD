package vlxd.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vlxd.dto.CategoryDTO;
import vlxd.dto.ProductDTO;

public class ProductMapper extends DBMapper {

	public ProductMapper() throws Exception {
		super(); // call constructor DBMapper -- get connection
	}

	public void createProduct(ProductDTO newProduct) {
		try {
			String sqlStr = "INSERT into product (name,price,unit,category_id) VALUE (?,?,?,?)";

			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, newProduct.getName());
			preparedStmt.setString(2, newProduct.getPrice());
			preparedStmt.setString(3, newProduct.getUnit());
			preparedStmt.setInt(4, newProduct.getCategory().getId());

			preparedStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ProductDTO> listProduct() {
		ArrayList<ProductDTO> products = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT p.id, p.name, p.price, p.unit,p.category_id, c.name 'category_name' "
					+ "FROM product p, category c "
					+ "WHERE p.category_id=c.id";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				ProductDTO product = new ProductDTO();
				CategoryDTO category = new CategoryDTO();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setUnit(rs.getString("unit"));
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));
				product.setCategory(category);

				products.add(product);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return products;
	}
	
	public ProductDTO searchProductById(Integer id) {
		ProductDTO product = new ProductDTO();
		CategoryDTO category = new CategoryDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT p.id, p.name, p.price, p.unit,p.category_id, c.name 'category_name' "
					+ "FROM product p, category c "
					+ "WHERE p.category_id=c.id "
					+ "AND p.id=" + id;   
			
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setUnit(rs.getString("unit"));
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));
				product.setCategory(category);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return product;
	}

	public ArrayList<ProductDTO> searchProduct(String searchParameter) {
		ArrayList<ProductDTO> products = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT p.id, p.name, p.price, p.unit,p.category_id, c.name 'category_name' "
					+ "FROM product p, category c "
					+ "WHERE p.category_id=c.id "
					+ "AND ( p.id=trim('" + searchParameter + "') OR p.name LIKE '%" + searchParameter + "%' )";
			
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				ProductDTO product = new ProductDTO();
				CategoryDTO category = new CategoryDTO();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setUnit(rs.getString("unit"));
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));
				product.setCategory(category);

				products.add(product);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return products;
	}

	public void editProduct(ProductDTO product) {
		try {
			String sqlStr = "UPDATE product SET name=?, price=?, unit=?, category_id=? WHERE id=?";
			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);

			preparedStmt.setString(1, product.getName());
			preparedStmt.setString(2, product.getPrice());
			preparedStmt.setString(3, product.getUnit());
			preparedStmt.setInt(4, product.getCategory().getId());
			preparedStmt.setInt(5, product.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteProduct(ProductDTO product) {
		try {
			String sqlStr = "DELETE FROM product WHERE id=?";
			PreparedStatement preparedStmt = getConnection().prepareStatement(sqlStr);
			preparedStmt.setInt(1, product.getId());

			preparedStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
