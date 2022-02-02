import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class TicTacToe {


    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String aha = scanner.nextLine();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(aha.getBytes(StandardCharsets.UTF_8));
            System.out.println(bytesTo(encodedhash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    private static String bytesTo(byte[] hash) {
        StringBuilder stringBuilder = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String he = Integer.toHexString(0xff & hash[i]);
            if (he.length() == 1) stringBuilder.append('0');

            stringBuilder.append(he);

        }
        return stringBuilder.toString();
    }

}
