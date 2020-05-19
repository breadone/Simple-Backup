package backup;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

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
                byte[] block = new byte[2048];
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


}