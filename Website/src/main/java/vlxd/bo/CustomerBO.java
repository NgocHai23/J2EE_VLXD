package vlxd.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import vlxd.dto.CustomerDTO;
import vlxd.mapper.CustomerMapper;

public class CustomerBO {
	protected ServletContext context;

	public CustomerBO(ServletContext context) {
		this.context = context;
	}
	
	public void createCustomer(String name, String address, String phone, String email) {
		CustomerMapper mapper = null;
		try {
			CustomerDTO customer = new CustomerDTO();
			customer.setName(name);
			customer.setAddress(address);
			customer.setPhone(phone);
			customer.setEmail(email);

			mapper = new CustomerMapper();
			mapper.createCustomer(customer);

		} catch (Exception ex) {
			Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public ArrayList<CustomerDTO> listCustomer() {
		ArrayList<CustomerDTO> customers = null;
		CustomerMapper mapper = null;
		try {
			mapper = new CustomerMapper();
			customers = mapper.listCustomer();
		} catch (Exception ex) {
			Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return customers;
	}
	
	public CustomerDTO searchCustomerById(Integer id) {
		CustomerDTO customer = null;
		CustomerMapper mapper = null;
		try {
			mapper = new CustomerMapper();
			customer = mapper.searchCustomerById(id);
		} catch (Exception ex) {
			Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return customer;
	}

	public ArrayList<CustomerDTO> searchCustomer(String searchParameter) {
		ArrayList<CustomerDTO> customers = null;
		CustomerMapper mapper = null;
		try {
			mapper = new CustomerMapper();
			customers = mapper.searchCustomer(searchParameter);
		} catch (Exception ex) {
			Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return customers;
	}

	public void editCustomer(String id, String name, String address, String phone, String email) {
		CustomerMapper mapper = null;
		try {
			CustomerDTO customer = new CustomerDTO();
			customer.setId(Integer.valueOf(id));
			customer.setName(name);
			customer.setAddress(address);
			customer.setPhone(phone);
			customer.setEmail(email);
			Timestamp updateAt = new Timestamp(System.currentTimeMillis());
			customer.setUpdatedAt(updateAt);
			
			mapper = new CustomerMapper();
			mapper.editCustomer(customer);

		} catch (Exception ex) {
			Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
