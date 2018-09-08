package studio.visualdust.product.flashknow.Structure;

import studio.visualdust.product.flashknow.Resource.Resource;
import studio.visualdust.product.flashknow.method.EventRW;
import studio.visualdust.product.flashknow.method.FileWriter;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.charset.Charset;

public class FlashDrive {
    public String name;
    public String type;
    public String discription;
    public String ownerNmae;
    public File path;

    public FlashDrive(String name, String type, String ownerNmae, String discription, File path) {
        this.name = name;
        this.type = type;
        this.discription = discription;
        this.ownerNmae = ownerNmae;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getOwnerNmae() {
        return ownerNmae;
    }

    public String getDiscription() {
        return discription;
    }

    public File getPath() {
        return path;
    }

    public static boolean isKnownFlash(File file) {
        return (new File(file.getPath() + Resource.infLocation + "discription")).exists();
    }

    public static FlashDrive getDriveClassOf(File file) {
        if (!isKnownFlash(file)) return null;
        FlashDrive flashDrive = new FlashDrive(null, null, null, null, null);
        try {
            InputStream inputStream = new FileInputStream(new File(file.getPath() + Resource.infLocation + "discription"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String tmpDiscription = bufferedReader.readLine();
            String tmpOwnerName = bufferedReader.readLine();
            String tmpDriveName = FileSystemView.getFileSystemView().getSystemDisplayName(file);
            String tmpType = FileSystemView.getFileSystemView().getSystemTypeDescription(file);
            flashDrive = new FlashDrive(tmpDriveName, tmpType, tmpOwnerName, tmpDiscription, file);
//            bufferedReader.close();
        } catch (Exception e) {
            EventRW.Write(e);
        }
        return flashDrive;
    }

    public static FlashDrive InitFlashDrive(String ownerNmae, String discription, File path) {
        File tmpFile = new File(path + Resource.infLocation + "discription");
        FileWriter.WriteUTF8(tmpFile, discription, true);
        FileWriter.WriteUTF8(tmpFile, ownerNmae, true);
        return getDriveClassOf(path);
    }

    public boolean equal(FlashDrive flashDrive) {
        return flashDrive.toString().equals(this.toString());
    }

    @Override
    public String toString() {
        return "    [TYPE]" + type + "     [PATH]" + path.toString() + "     [NAME]" + name + "     [OWNERNAME]" + ownerNmae + "     [DISCRIPTION]" + discription;
    }
}
