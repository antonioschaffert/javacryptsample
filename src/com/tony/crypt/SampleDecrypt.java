package com.tony.crypt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.Enumeration;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class SampleDecrypt {

	public static void main(String[] args) throws NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException, KeyStoreException, NoSuchPaddingException {
		// TODO Auto-generated method stub

		
	    FileInputStream is = new FileInputStream("/Users/antonioschaffert/workspace/enroll/keystore.jks");

	    KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
	    keystore.load(is, "password".toCharArray());

	    String alias = "selfsigned";
	    
        Enumeration<String> enumeration = keystore.aliases();
        while(enumeration.hasMoreElements()) {
            String a = (String)enumeration.nextElement();
            System.out.println("alias name: " + a);
        }

	    Key key = keystore.getKey(alias, "gflevv10".toCharArray());
	    

	    //String  enc_text = "\\x0F\\x04\\xD9\\x10\\xE2\\x9B\\xB1\\xE3P\\xA4\\x15\\x8Cl\\xA0r\\xBF\\xAC\\x88e\\xA3\\xBC\\xA1T\\xA8\\xF8C\\xD7\\xFF_\\xF2=t\\xE04\\xC5\\x19\\x1A\\xE2\\x86 \\xA4\\x9E\\x18r\\xDD\\x90\\x80\\x10O{\\xABC\\x05t\\xE7\\xAA\\xD2\\xA8\\x8B\\xE4ld\\xF7\\xA3-\\xE4\\xD6\\xEA\\xC2r\\xF3\\nD\\xAF\\x7Fu\\xBE\\xE4\\xB2M\\xE4\\xBEJ\\x1A\\x87\\x11\\xDB(3\\xA7\\xFCa\\x15\\x86\\x10\\\"4\\xDEa\\xD6B\\xD5\\a\\xAA\\xD2\\xEF\\x9C\\x95\\xA8\\xE0\\xFB\\xE9\\xDC\\x1Fe\\xA1#\\xA4\\b**\\xEF \\xA9\\xC8\\x0F\\xEEs\\x85}\\x1CD\\xB1\\xF9 \\xB5\\xF2\\xEC\\xF6s\\xD1\\t\\x8FW\\xB6\\xFD\\xF9\\x1F-\\\"N %c\\xDC\\x95(\\x04\\xF0\\x87;B\\xBBfB\\xF9\\xB6\\xCE)\\xCE\\x958i\\xC28\\f\\xD3\\x02k\\xFD\\x85\\xB49\\x94A\\x80w\\xFC\\xD7\\x90\\xD7\\x9Fq\\x86)x~\\xB7\\xB0\\x16W(\\xF2\\x04\\xC4\\xD9\\x94!\\r\\x16\\x9D\\xC0<\\xE3\\x0F\\xE9F\\x1E=\\x86\\x94:\\xD9\\x1Cn\\x9C\\xB2^\\x16\\xCD\\xA5\\xD4\\xF0J\\x15\\xC6\\xF0\\x12]\\xBF\\xED\\bn\\xDE\\xA9\\xFB\\n\\x83\\x8E\\xFFY\\x98\\xC3\\xF2j\\x90";
	    String enc_text = "aPvem7oVl0780WzHPzWFV+LeAk/VLVDh56Y0x7QsB9qgGtf7vJb4M04eESKtvBboVKN4Q9ndx8HzTTyHMDEPK9mo2H/g5Hp/eSzX70Tifm7pLZAGiy6VzFLY76JGHd/zeord3l+cxgw2dLf8KlKoOIS0ThomhFJ6ukf64ImE+7iVZrTeYml+cG+lIpaxtcnWhgnTO5tuVUCGKnB245OfHvwBps6udP00YzAimhbRZZGiqDhPQMHG5aRCkIboiznfS0vHbAZnXfQLF8p3EMRGdJAxagPBsJzIqSML/OqK6K2feBGfTve3JgBuG0yKCTt6I1KAcFPwheaHsrPpXY+hUQ==";
	    
		Cipher cipher = Cipher.getInstance("RSA");

		//Cipher decrypt=Cipher.getInstance("RSA/ECB/PKCS1Padding");
		//decrypt.init(Cipher.DECRYPT_MODE, privateKey);
		

		try {
			
			cipher.init(Cipher.DECRYPT_MODE, (PrivateKey) key);
			Base64.Decoder decoder = Base64.getDecoder();
			String decryptedMessage = new String(cipher.doFinal(decoder.decode(enc_text)), StandardCharsets.UTF_8);
			System.out.println("Decrypted string: " + decryptedMessage);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
