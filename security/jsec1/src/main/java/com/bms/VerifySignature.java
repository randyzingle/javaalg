package com.bms;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/*
 * Here we'll verify the signature generated using the data and key created by
 * the GenSig program. The key is baldurkey and the signed data is in jabber.dat
 * The data file is jabber.txt
 */
public class VerifySignature {

	public static void main(String[] args) {
		try {
			// read the public key 
			System.out.println("read the key...");
			FileInputStream fis = new FileInputStream("baldurkey");
			byte[] key = new byte[fis.available()];
			fis.read(key);
			fis.close();
			// now we have an encoded key - we need to convert to a DSA public key
			X509EncodedKeySpec spec = new X509EncodedKeySpec(key);
			KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
			PublicKey publicKey = keyFactory.generatePublic(spec);
			
			// now read the signed data
			System.out.println("read the signed data...");
			fis = new FileInputStream("jabber.dat");
			byte[] signatureData = new byte[fis.available()];
			fis.read(signatureData);
			fis.close();
			
			// create a signature object to verify the signature
			// we need to use the same algorithm as was used to sign the data
			Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
			sig.initVerify(publicKey);
			// load the unsigned data so that you can verify the signature
			fis = new FileInputStream("jabber.txt");
			BufferedInputStream buf = new BufferedInputStream(fis);
			
			byte[] buffer = new byte[1024];
			int len;
			while ( (len = buf.read(buffer)) >= 0) {
				sig.update(buffer, 0, len);
			}
			buf.close();
			// verify the signature
			boolean verifies = sig.verify(signatureData);
			System.out.println("Signature verifies: " + verifies);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
