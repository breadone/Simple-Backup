package backup;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Random;
import java.util.Scanner;

public class bGen {
    
    public enum Hash {

        MD5("MD5"),
        SHA1("SHA1"),
        SHA256("SHA-256"),
        SHA512("SHA-512");
    
        private String name;
    
        Hash(String name) {
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    
        public byte[] checksum(File input) {
            try (InputStream in = new FileInputStream(input)) {
                MessageDigest digest = MessageDigest.getInstance(getName());
                byte[] block = new byte[4096];
                int length;
                while ((length = in.read(block)) > 0) {
                    digest.update(block, 0, length);
                }
                return digest.digest();
            } catch (Exception e) {
                System.out.println("error when calculating hash value");
                e.printStackTrace();
            }
            return null;
        }   
    }

    public static int RInt(int bound) {
        Random rnd = new Random();
        int rand;
        rand = rnd.nextInt(bound);
        return rand;
    }

    public static boolean CheckPrime(int number) {
        boolean prime = true;

        for (int i = 2; i <+ number / 2; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }

    public static void WriteToFile(String path, String text) throws IOException {
        FileWriter writer = new FileWriter(path, false);
        try {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("an error occured while writing to the file.");
        }
        writer.close();
    }

    public static String ReadFromFile(String path) throws Exception {
        Scanner reader = new Scanner(path);
        String text = "";
        //TODO length of file

        try {
            while (reader.hasNextLine() == true) {
                text += reader.next();
            }         
       } catch (Exception e) {
            System.out.println("error while reading from file");
        }
        System.out.println(text);
        return text;
    }

}