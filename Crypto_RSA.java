package com;

import java.math.BigInteger;

import org.python.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.python.bouncycastle.crypto.engines.RSAEngine;
import org.python.bouncycastle.crypto.params.RSAKeyParameters;

public class Crypto_RSA {
	
	static String publicKey_N = "a75c80db021974b34740f84d23d1becb5cebadbb6d00238c96156dd7ec116b41a95b5ff4c4db66dfad7972fc08e44779882baec9ebff3013bb14f7f2d3951f028e407a94ca658c4b1e11fbd7a9ea5d2ae787153345550fbfae790069b05637f38cee90993b62e605b670ae3eac3536217d5d54a0931145531e9187d2715494b7";
	static String privateKey_D = "6bfced0be383e7601276e2806bbf57bbc27e33c07ee99b068884d536809510bef2770a2856a936ecd6f34975448b7f6ef4a533080925c4b0c6831625f1ce038e48728833759765691821642d8c09324a0eb96b68144146580fa7af28c4f41c16c48f7d008cdd8cf45087aa9af05ddc01cc833d7fabf3685db31f2a69528559e1";
	
	public static PKCS1Encoding create_rsa_public(RSAKeyParameters PublicKey){
	    RSAEngine engine=new RSAEngine();
	    PKCS1Encoding encrypto=new PKCS1Encoding(engine);
	    encrypto.init(true,PublicKey);
	    return encrypto;
	}
	
	public static byte[] encrypt(byte[] plainData) {
		BigInteger mod = new BigInteger(publicKey_N, 16);;
		BigInteger exp = new BigInteger("10001", 16);
		RSAKeyParameters keyParams = new RSAKeyParameters(false, mod, exp);
		
		RSAEngine engine=new RSAEngine();
		engine.init(true, keyParams);
		  
		try {
		  byte[] data = engine.processBlock(plainData, 0, plainData.length);
		  return data;
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] decrypt(byte[] ecnData) {
		BigInteger mod = new BigInteger(publicKey_N, 16);;
		BigInteger exp = new BigInteger(privateKey_D, 16);
		RSAKeyParameters keyParams = new RSAKeyParameters(true, mod, exp);
		
		RSAEngine engine=new RSAEngine();
		engine.init(false, keyParams);
		  
		try {
		  byte[] data = engine.processBlock(ecnData, 0, ecnData.length);
		  return data;
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return null;
	}
	
//	public static void main(String[] args) {
//    	
//    	byte [] plainData = Util.hexStringToByteArray("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F202122232425262728292A2B2C2D2E2F303132333435363738393A3B3C3D3E3F404142434445464748494A4B4C4D4E4F505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E");
//    	byte [] encData = RSA.encrypt(plainData);
//    	System.out.println(Util.byteArrayToHexString(encData));
//    	System.out.println(Util.byteArrayToHexString(RSA.decrypt(encData)));
//    }
}
