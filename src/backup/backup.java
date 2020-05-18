package backup;

import java.io.*;
import java.security.MessageDigest;

import sun.security.provider.MD5;

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
        //byte[] md5 = new byte[1024];
        long md5;
        //generate md5
        md5 = CreateChecksum(path);
        System.out.println(md5);

    }


    public static long CreateChecksum(String filename) throws Exception {
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
    }

}