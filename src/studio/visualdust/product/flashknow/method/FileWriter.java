package studio.visualdust.product.flashknow.method;

import java.io.*;
import java.nio.charset.Charset;

public class FileWriter {
    private static OutputStream FileWriterStream;

    public static void Write(File file, String string, boolean append) {
        try {
            FileWriterStream = new FileOutputStream(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(FileWriterStream, Charset.forName("UTF-8")));
            bufferedWriter.write(string);
            bufferedWriter.write("\r\n");
            bufferedWriter.close();
        } catch (Exception e) {
            EventRW.Write(e);
        }
    }

//    public static File Write(String filePath, String fileType, String string) {
//        File outputFile = new File(filePath + fileType);
//        try {
//            FileWriterStream = new FileOutputStream(outputFile, false);
//            FileWriterStream.write(string.getBytes());
//            FileWriterStream.close();
//        } catch (Exception e) {
//            EventRW.Write(e);
//        }
//        if (outputFile.exists())
//            return outputFile;
//        return null;
//    }
}
