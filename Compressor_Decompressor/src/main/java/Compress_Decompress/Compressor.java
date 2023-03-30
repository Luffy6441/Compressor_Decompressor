/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compress_Decompress;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author kali
 */
public class Compressor {
    public static void method(File file) throws IOException
    {
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "CompressedFile.gzip    ");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
        byte buffer[] = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1)
        {
            gzip.write(buffer , 0 , len);
        }
        gzip.close();
        fis.close();
        fos.close();
    }
    public static void main(String args[]) throws IOException
    {
        File path = new File("");
        method(path);
    }
}
