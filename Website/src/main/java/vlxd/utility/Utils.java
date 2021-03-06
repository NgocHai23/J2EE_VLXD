package vlxd.utility;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import vlxd.dto.UserDTO;

public class Utils {
	private static String algorithm = "AES/CBC/PKCS5Padding";
	private static String secretKey = "QLVLXD";
	private static String salt = "J2EE";
	
	public static void storeLoginedUser(HttpSession session, UserDTO loginedUser) {
		session.setAttribute("loginedUser", loginedUser);
		session.setMaxInactiveInterval(30*60);
	}
	
    public static UserDTO getLoginedUser(HttpSession session) {
    	UserDTO loginedUser = (UserDTO) session.getAttribute("loginedUser");
        return loginedUser;
    }
    
    public static Boolean CheckUserInSession(HttpSession session, String user) {
    	UserDTO check = (UserDTO) session.getAttribute("loginedUser");
    	if (check == null) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    public static String Encrypt(String strToEncrypt) {
    	try {
    		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
    		
	        Cipher cipher = Cipher.getInstance(algorithm);
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
	        return Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return null;
    }

    public static String Decrypt(String strToDecrypt) {
    	try {
    		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);
    		
    		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
             
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
    	} catch (Exception e) {
    		System.out.println(e);
		}
    	return null;
    }
    
    public static String formatStringWithoutDot(String str) {
    	String replaceAmount = str.replace(".", "");
    	return replaceAmount;
    }

}
