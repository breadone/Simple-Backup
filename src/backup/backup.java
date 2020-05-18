package backup;

import java.io.*;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

public class backup {

    public static void main(String[] args) {
        StartService();
    }

    public static String QueryPath() {
        String path;
        System.out.print("paste the path to the file or folder to backup: ");
        path = System.console().readLine();
        return path;
    }

    public static void StartService() {
        String path = QueryPath();
        long md5;
        //generate md5
        md5 = GenerateChecksum(path);
        System.out.println(md5);

        

    }


   /* public static long CreateChecksum(String filename) throws Exception {
        InputStream fis =  new FileInputStream(filename);
        long hash = 0;

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");
        int numRead;
        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
             }
         } while (numRead != -1);
            fis.close();
            //return complete.digest();

            for (int i = 0; i < complete.digest().length - 1; i++) {
                hash += buffer[i];
            }

            return hash;
    }*/


    public static long GenerateChecksum(String path) throws IOException {
        InputStream stream = new FileInputStream(path);
        CheckedInputStream CInputStream = new CheckedInputStream(stream, new CRC32());
        byte[] buffer = new byte[65536];
        

        return 1238;
    }
}