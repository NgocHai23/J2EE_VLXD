package vlxd.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import vlxd.dto.VendorDTO;
import vlxd.mapper.VendorMapper;

public class VendorBO {
	protected ServletContext context;

	public VendorBO(ServletContext context) {
		this.context = context;
	}

	public void createVendor(String name, String address, String phone, String email) {
		VendorMapper mapper = null;
		try {
			VendorDTO vendor = new VendorDTO();
			vendor.setName(name);
			vendor.setAddress(address);
			vendor.setPhone(phone);
			vendor.setEmail(email);
			
			mapper = new VendorMapper();
			mapper.createVendor(vendor);

		} catch (Exception ex) {
			Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public ArrayList<VendorDTO> listVendor() {
		ArrayList<VendorDTO> vendors = null;
		VendorMapper mapper = null;
		try {
			mapper = new VendorMapper();
			vendors = mapper.listVendor();
		} catch (Exception ex) {
			Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return vendors;
	}
	
	public VendorDTO searchVendorById(Integer id) {
		VendorDTO vendor = null;
		VendorMapper mapper = null;
		try {
			mapper = new VendorMapper();
			vendor = mapper.searchVendorById(id);
		} catch (Exception ex) {
			Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return vendor;
	}
	
	public ArrayList<VendorDTO> searchVendor(String searchParameter) {
		ArrayList<VendorDTO> vendors = null;
		VendorMapper mapper = null;
		try {
			mapper = new VendorMapper();
			vendors = mapper.searchVendor(searchParameter);
		} catch (Exception ex) {
			Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return vendors;
	}
	
	public void updateDebtOfVendor(String id, String debt) {
		VendorMapper mapper = null;
		try {
			VendorDTO vendor = new VendorDTO();
			vendor.setId(Integer.valueOf(id));
			vendor.setDebt(debt);
			Timestamp updateAt = new Timestamp(System.currentTimeMillis());
			vendor.setUpdatedAt(updateAt);
			mapper = new VendorMapper();
			mapper.updateDebtOfVendor(vendor);

		} catch (Exception ex) {
			Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public void editVendor(String id, String name, String address, String phone, String email) {
		VendorMapper mapper = null;
		try {
			VendorDTO vendor = new VendorDTO();
			vendor.setId(Integer.valueOf(id));
			vendor.setName(name);
			vendor.setAddress(address);
			vendor.setPhone(phone);
			vendor.setEmail(email);
			Timestamp updateAt = new Timestamp(System.currentTimeMillis());
			vendor.setUpdatedAt(updateAt);
			mapper = new VendorMapper();
			mapper.editVendor(vendor);

		} catch (Exception ex) {
			Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void deleteVendor(String id) {
		VendorMapper mapper = null;
		try {
			VendorDTO vendor = new VendorDTO();
			vendor.setId(Integer.valueOf(id));
			
			mapper = new VendorMapper();
			mapper.deleteVendor(vendor);
			
		} catch (Exception ex) {
			Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(VendorBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
