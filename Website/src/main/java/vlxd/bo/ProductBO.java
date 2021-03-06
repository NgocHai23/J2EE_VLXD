package vlxd.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import vlxd.dto.CategoryDTO;
import vlxd.dto.ProductDTO;
import vlxd.mapper.ProductMapper;

public class ProductBO {
	
	protected ServletContext context;

	public ProductBO(ServletContext context) {
		this.context = context;
	}
	
	public void createProduct(String name, String price, String unit, Integer category_id) {
		ProductMapper mapper = null;
		try {
			ProductDTO product = new ProductDTO();
			CategoryDTO category = new CategoryDTO();
			product.setName(name);
			product.setPrice(price);
			product.setUnit(unit);
			category.setId(category_id);
			product.setCategory(category);

			mapper = new ProductMapper();
			mapper.createProduct(product);

		} catch (Exception ex) {
			Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public ArrayList<ProductDTO> listProduct() {
		ArrayList<ProductDTO> products = null;
		ProductMapper mapper = null;
		try {
			mapper = new ProductMapper();
			products = mapper.listProduct();
		} catch (Exception ex) {
			Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return products;
	}
	
	public ProductDTO searchProductById(Integer id) {
		ProductDTO product = null;
		ProductMapper mapper = null;
		try {
			mapper = new ProductMapper();
			product = mapper.searchProductById(id);
		} catch (Exception ex) {
			Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return product;
	}
	
	public ArrayList<ProductDTO> searchProduct(String searchParameter) {
		ArrayList<ProductDTO> products = null;
		ProductMapper mapper = null;
		try {
			mapper = new ProductMapper();
			products = mapper.searchProduct(searchParameter);
		} catch (Exception ex) {
			Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return products;
	}
	
	public void editProduct(String id, String name, String price, String unit, Integer category_id) {
		ProductMapper mapper = null;
		try {
			ProductDTO product = new ProductDTO();
			CategoryDTO category = new CategoryDTO();
			product.setId(Integer.valueOf(id));
			product.setName(name);
			product.setPrice(price);
			product.setUnit(unit);
			category.setId(category_id);
			product.setCategory(category);
			
			mapper = new ProductMapper();
			mapper.editProduct(product);

		} catch (Exception ex) {
			Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void deteleProduct(String id) {
		ProductMapper mapper = null;
		try {
			ProductDTO product = new ProductDTO();
			product.setId(Integer.valueOf(id));

			mapper = new ProductMapper();
			mapper.deleteProduct(product);
		} catch (Exception ex) {
			Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
}
