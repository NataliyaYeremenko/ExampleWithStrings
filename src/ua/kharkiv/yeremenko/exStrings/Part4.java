package ua.kharkiv.yeremenko.exStrings;

import java.security.*;

public class Part4 {
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
    	StringBuilder output = new StringBuilder();
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        char[] val = new char[2*hash.length];
        String hex = "0123456789ABCDEF";
        for (int i = 0; i < hash.length; i++){
            int b = hash[i] & 0xff;
            val[2*i] = hex.charAt(b >>> 4);
            val[2*i + 1] = hex.charAt(b & 15);
        }
        for (int i = 0; i < val.length; i++){
        	 output.append(val[i]);
        }
        return output.toString();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("password", "SHA-256"));
        System.out.println(hash("passwort", "SHA-256"));
        System.out.println(hash("adf", "MD5"));
        System.out.println(hash("passwort", "MD5"));
        System.out.println(hash("password", "SHA-512"));
        System.out.println(hash("passwort", "SHA-512"));
    }
}
