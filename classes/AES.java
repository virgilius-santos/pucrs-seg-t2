package classes;

import static classes.HexToString.byteArrayToHexString;
import static classes.HexToString.hexStringToByteArray;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;
import static javax.crypto.Cipher.getInstance;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    static enum Type {
        CBC("AES/CBC/PKCS5PADDING"), CTR("AES/CTR/NoPadding");

        private String descricao;

        Type(String descricao) {
            this.descricao = descricao;
        }

        public String getDescription() {
            return descricao;
        }
    }

    private static String MODE;
    private static String AES = "AES";
    private static SecretKeySpec secretKey;
    private static IvParameterSpec ivParameterSpec;
    private static Cipher cipher;

    private static void setKey(final String myKey) throws Exception {
        byte[] key = hexStringToByteArray(myKey);
        secretKey = new SecretKeySpec(key, AES);
    }

    private static void setIV(final String iv) {
        byte[] ivBytes = hexStringToByteArray(iv);
        ivParameterSpec = new IvParameterSpec(ivBytes);
    }

    private static String getMessage(final String message) throws Exception {
        byte[] data = hexStringToByteArray(message);
        byte[] converted = cipher.doFinal(data);
        return byteArrayToHexString(converted);
    }

    private static String processCrypt(final String title, final String message, final String secret, final String iv,
            Type type, int mode, String messageError) {
        try {
            MODE = type.getDescription();
            setKey(secret);
            setIV(iv);

            cipher = getInstance(MODE);
            cipher.init(mode, secretKey, ivParameterSpec);

            return getMessage(message);

        } catch (final Exception e) {
            System.out.println("error in: " + title);
            System.out.println(messageError + " " + e);
            e.printStackTrace();
        }
        return "null";
    }

    public static String encrypt(final Task task, final String message) {
        return processCrypt(task.title, message, task.key, task.iv, task.type, ENCRYPT_MODE, "Error while encrypting:");
    }

    public static String encrypt(final Task task) {
        return encrypt(task, task.text);
    }

    public static String decrypt(final Task task, final String message) {
        return processCrypt(task.title, message, task.key, task.iv, task.type, DECRYPT_MODE, "Error while decrypting:");
    }

    public static String decrypt(final Task task) {
        return decrypt(task, task.text);
    }
}