package com;



public class Util {
	
	public static byte[] hexStringToByteArray(String s) 
	{
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	public static byte hexStringToByte(String s) 
	{
	    int len = s.length();
	    byte data = 0x00;
	    for (int i = 0; i < len; i += 2) {
	        data = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	public static String byteArrayToHexString(byte[] a) 
	{
		    StringBuilder sb = new StringBuilder();
		    for(final byte b: a)
		        sb.append(String.format("%02x", b&0xff));
		    return sb.toString().toUpperCase();
	}


	public static String byteToHexString(byte a) 
	{
		    StringBuilder sb = new StringBuilder();
		        sb.append(String.format("%02x", a&0xff));
		    return sb.toString().toUpperCase();
	}
	
	public static String hexStringToString(String arg)
	{
	    String str = "";
	    for(int i=0;i<arg.length();i+=2)
	    {
	        String s = arg.substring(i, (i + 2));
	        int decimal = Integer.parseInt(s, 16);
	        str = str + (char) decimal;
	    }       
	    return str;
	}
	
	public static String toLittleEndian(String hex) {

	    String hexLittleEndian = "";
	    
	    if (hex.length() % 2 != 0)
	    	hex = "0" + hex;
	    
	    for (int i = hex.length() - 2; i >= 0; i -= 2) {
	        hexLittleEndian += hex.substring(i, i + 2);
	    }
	    
	    return hexLittleEndian.toUpperCase();
	}
}
