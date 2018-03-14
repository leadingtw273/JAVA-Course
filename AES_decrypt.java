import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES_decrypt {

    private static final String DEFAULT_CODING = "utf-8";

    /** 
     * 解密 
     */
    public static String decrypt(String encrypted, String seed) throws Exception {
        byte[] keyb = seed.getBytes(DEFAULT_CODING);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(keyb);
        SecretKeySpec skey = new SecretKeySpec(thedigest, "AES");
        Cipher dcipher = Cipher.getInstance("AES/ECB/NoPadding");
        dcipher.init(Cipher.DECRYPT_MODE, skey);

        byte[] clearbyte = dcipher.doFinal(toByte(encrypted));
        return new String(clearbyte);
    }

    /** 
     * String => byte[]
     */
    public static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(AES_decrypt.decrypt("46bf154f98ccb2d3fbc36ff6322fe9a35217c69e1c622d3b2a591a52c547db55",
                "abed4518b1fad2974797"));
    }
}