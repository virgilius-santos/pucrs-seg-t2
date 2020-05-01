package classes;

import static classes.AES.decrypt;
import static classes.AES.encrypt;
import static classes.HexToString.hexStringToString;

public class App {

    public static void main(final String[] args) {
        printEncrypted(Task.task1);
        printEncrypted(Task.task2);
        printEncrypted(Task.task3);
        printEncrypted(Task.task4);
        printDecrypted(Task.task5);
        printDecrypted(Task.task6);
    }

    private static void printDecrypted(Task task) {
        System.out.println("\n---start Encrypt---");
        String encryptedString = encrypt(task);
        String decryptedString = decrypt(task, encryptedString);
        boolean valid = decryptedString.toUpperCase().equals(task.text.toUpperCase());
        print(task, decryptedString, encryptedString, valid);
        System.out.println("----end----\n");
    }

    private static void printEncrypted(Task task) {
        System.out.println("\n---start Decrypt---");
        final String decryptedString = decrypt(task);
        final String encryptedString = encrypt(task, decryptedString);
        boolean valid = encryptedString.toUpperCase().equals(task.text.toUpperCase());
        print(task, decryptedString, encryptedString, valid);
        System.out.println("----end----\n");
    }

    private static void print(final Task task, final String decryptedString, final String encryptedString,
            boolean valid) {
        System.out.printf("%15s%s\n\n", "title:\t", task.title);
        System.out.printf("%15s%s\n", "original:\t", task.key);
        System.out.printf("%15s%s\n", "key:\t", task.text);
        System.out.printf("%15s%s\n", "mode:\t", task.type.getDescription());
        System.out.printf("%15s%s\n\n", "iv:\t", task.iv);
        System.out.printf("%15s%s\n", "encrypted:\t", encryptedString);
        System.out.printf("%15s%s\n", "decrypted:\t", hexStringToString(decryptedString));
        System.out.printf("\n%15s%b\n", "validate:\t", valid);
    }
}