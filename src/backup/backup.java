package backup;

import java.io.*;
import java.util.Arrays;

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
        byte[] hash = new byte[1024];
        String HashValue = Arrays.toString(hash);
        hash = bGen.Hash.SHA256.checksum(path);
        System.out.println(HashValue);
    }


    

} 

