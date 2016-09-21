/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Genaro F
 */
class SimpleSHA1 {

    static public String getSHA1(String cadena) {

        MessageDigest md;
        byte buffer[], resultado[];
        String hash = "";

        buffer = cadena.getBytes();
        try {
            md = MessageDigest.getInstance("SHA1");
            md.update(buffer);
            resultado = md.digest();
        }catch(NoSuchAlgorithmException e){
            return null;
        }

        for (byte elem : resultado) {
            int b = elem & 0xff;
            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }
            hash += Integer.toHexString(b);
        }
        return hash;
    }
}
