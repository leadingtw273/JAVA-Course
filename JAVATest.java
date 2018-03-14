public class JAVATest {
    public static void main(String[] args) {

        String synValue = "c336325aabaaccddc904e52fd88211968eda7860123c75eac6fc0f1b1cec9cfd";
        String usbKey   = "313ce386d364785c56cd";

        try {
            System.out.println(AES_decrypt.decrypt(synValue,usbKey));
        } catch (Exception e) {
            System.out.println("AES_decrypt Error : " + e);
        }

    }
}