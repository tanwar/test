package com.tanwar.classcourt.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
* This program generates a AES key, retrieves its raw bytes, and
* then reinstantiates a AES key from the key bytes.
* The reinstantiated key is used to initialize a AES cipher for
* encryption and decryption.
*/

public class EncryptDecrypt {

  /**
  * Turns array of bytes into string
  *
  * @param buf	Array of bytes to convert to hex string
  * @return	Generated hex string
  */
  public static String asHex (byte buf[]) {
   StringBuffer strbuf = new StringBuffer(buf.length * 2);
   int i;

   for (i = 0; i < buf.length; i++) {
    if (((int) buf[i] & 0xff) < 0x10)
	    strbuf.append("0");

    strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
   }

   return strbuf.toString();
  }

  public static void encryptDecrypt(String[] args) throws Exception {

    String message="This is just an example";

    // Get the KeyGenerator

    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    kgen.init(128); // 192 and 256 bits may not be available


    // Generate the secret key specs.
    SecretKey skey = kgen.generateKey();
    byte[] raw = skey.getEncoded();

    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");


    // Instantiate the cipher

    Cipher cipher = Cipher.getInstance("AES");

    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

    byte[] encrypted =
      cipher.doFinal((args.length == 0 ?
       "classadmin" : args[0]).getBytes());
    System.out.println("encrypted string: " + asHex(encrypted));

    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    byte[] original =
      cipher.doFinal(encrypted);
    String originalString = new String(original);
    System.out.println("Original string: " +
      originalString + " " + asHex(original));
  }
  
  public static String encryptText(String plainText) throws Exception{
	  
	  
	  KeyGenerator kgen = KeyGenerator.getInstance("AES");
	    kgen.init(128); // 192 and 256 bits may not be available


	    // Generate the secret key specs.
	    SecretKey skey = kgen.generateKey();
	    byte[] raw = skey.getEncoded();

	    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");


	    // Instantiate the cipher

	    Cipher cipher = Cipher.getInstance("AES");

	    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

	    byte[] encrypted =
	      cipher.doFinal(plainText.getBytes());
	    System.out.println("encrypted string: " + asHex(encrypted));


	  
	  return null;
  }
  
  public static void decryptText(String encryptedText) throws Exception {

	    // Get the KeyGenerator

	    KeyGenerator kgen = KeyGenerator.getInstance("AES");
	    kgen.init(128); // 192 and 256 bits may not be available


	    // Generate the secret key specs.
	    SecretKey skey = kgen.generateKey();
	    byte[] raw = skey.getEncoded();

	    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");


	    // Instantiate the cipher

	    Cipher cipher = Cipher.getInstance("AES");

	    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
	    asHex(encryptedText.getBytes());
	    byte[] original =
	      cipher.doFinal(encryptedText.getBytes());
	    String originalString = new String(original);
	    System.out.println("Original string: " +
	      originalString);// + " " + asHex(original));
	  }
  
  public static void main(String[] a) throws Exception{
	  //EncryptDecrypt.encryptText("testing the change");
	  EncryptDecrypt.decryptText("1a299c06d4f6bcbf7967d346309326a8b19024fca7cf9942c069e7db52e83ea5");
  }
  
}

