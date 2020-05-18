package backup;

import java.io.*;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.lang.Object;
import java.security.MessageDigest;

public class backup {

    public static void main(String[] args) throws IOException {
        StartService();
    }

    public static String QueryPath() throws FileNotFoundException {
        String path;
        System.out.print("paste the path to the file or folder to backup: ");
        path = System.console().readLine();
        

        return path;
    }

    public static void StartService() throws IOException {
        File path = new File(QueryPath());
        byte[] hash = new byte[65535];
        //generate md5

        hash = bGen.Hash.MD5.checksum(path);
        System.out.println(hash);

        

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


   /* public static long GenerateChecksum(String path) throws IOException {

        InputStream stream = new FileInputStream(path);
        CheckedInputStream CInputStream = new CheckedInputStream(stream, new CRC32());
        byte[] buffer = new byte[65536];
        
        long hash = 

        return 1238;
    } */

  /*  private static String getFileChecksum(/*MessageDigest digest, File file) throws IOException {
        //Get file input stream for reading the file content
        FileInputStream fis = new FileInputStream(file);
        MessageDigest digest = new MessageDigest("SHA-256");

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0; 
        
        //Read file data and update in message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };
        
        //close the stream; We don't need it now.
        fis.close();
        
        //Get the hash's bytes
        byte[] bytes = digest.digest();
        
        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    } 
     
    //return complete hash
   return sb.toString(); */
} 

