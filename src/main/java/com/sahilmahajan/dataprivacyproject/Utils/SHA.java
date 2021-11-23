package com.sahilmahajan.dataprivacyproject.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {

    public String Token(String passwordToHash) {

        String StrSalt = "8pNYEQ_vvm^P";
        byte[] salt = StrSalt.getBytes();

        String Token = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            Token = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return Token;
    }
}
