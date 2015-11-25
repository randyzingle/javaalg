package com.bms;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;

/*
 * The person who has the original documents needs to
 * 1) generate keys
 * 2) generate a digital signature for the data using the private key
 * 3) export the public key and the signature along with the original documents
 * 
 * The person who receives the documents needs to
 * 1) import the public key
 * 2) verify the authenticity of the signature
 * 
 * You can generate a public/private key pair (and a keystore) with the command:
 * keytool -genkey -alias baldur -keystore keys
 * this creates a self-signed certificate valid for 90 days (change this with -validity flag)
 * If you don't include -keystore it will look for a .keystore store in your home directory
 * 
 * You can list keys in a keystore with the command:
 * keytool -keystore keys -list
 * 
 * You can export the public key (certificate) with:
 * keytool -keystore keys -export -alias baldur -file baldur.cer
 * 
 * check this with:
 * keytool -printcert -file baldur.cer
 * or graphically on linux with:
 * xca baldur.cer
 * 
 * You can sign a jar file with the jarsigner utility:
 * jarsigner -keystore keys -signedjar simple.jar tmp.jar baldur
 * 
 * typically this would happen on another computer, but you would import the 
 * baldur.cer certificate into your keystore and verify the signature with:
 * jarsigner -verify -verbose -keystore keys simple.jar
 * 
 * This code achieves the above using the java apis
 */
public class GenSig {

	public static void main(String[] args) {
		try {
			GenSig gs = new GenSig();
			KeyPair keyPair = gs.createKeyPair();
			byte[] signedData = gs.signData(keyPair.getPrivate());
			gs.saveSignedData(signedData);
			gs.savePublicKey(keyPair.getPublic().getEncoded());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private KeyPair createKeyPair() throws Exception {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
		keyGen.initialize(1024, random);
		KeyPair pair = keyGen.generateKeyPair();
		return pair;

	}
	
	private byte[] signData(PrivateKey privateKey) throws Exception {
		Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
		// initialize the signature with your private key
		dsa.initSign(privateKey);
		// read all the data into the signature's data buffer
		FileInputStream fis = new FileInputStream("jabber.txt");
		BufferedInputStream buf = new BufferedInputStream(fis);
		byte[] buffer = new byte[1024];
		int len = 0;
		while ( (len = buf.read(buffer)) >= 0) {
			dsa.update(buffer, 0, len);
		}
		buf.close();
		// sign the data
		byte[] realSignature = dsa.sign();
		return realSignature;
	}
	
	private void saveSignedData(byte[] data) throws Exception {
		System.out.println("Saving the signed data in file jabber.dat...");
		FileOutputStream fos = new FileOutputStream("jabber.dat");
		fos.write(data);
		fos.close();
	}
	
	private void savePublicKey(byte[] data) throws Exception {
		System.out.println("Saving the public key in file baldurkey...");
		FileOutputStream fos = new FileOutputStream("baldurkey");
		fos.write(data);
		fos.close();
	}

}
