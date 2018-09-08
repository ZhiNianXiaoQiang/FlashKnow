package studio.visualdust.product.flashknow.Runable;

import studio.visualdust.product.flashknow.Resource.Resource;
import studio.visualdust.product.flashknow.Structure.FlashDrive;
import studio.visualdust.product.flashknow.method.EventRW;
import studio.visualdust.product.gztwigets.GMessageWindow;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileOutputStream;

public class FlashScanner extends Thread {
    File[] listRoots;
    //    Vector<FlashDrive> driveList;
    MainThread mainThread;

    public FlashScanner(MainThread mainThread) {
        this.mainThread = mainThread;
    }

    @Override
    public void run() {
        for (; ; ) {
            listRoots = File.listRoots();
            for (File file : listRoots) {
                if (!FileSystemView.getFileSystemView().getSystemTypeDescription(file).equals(FileSystemView.getFileSystemView().getSystemTypeDescription(new File("C:\\")))) {
                    if (FlashDrive.isKnownFlash(file)) {
                        FlashDrive flashDrive = FlashDrive.getDriveClassOf(file);
                        mainThread.check(flashDrive);
                    } else {
                        EventRW.Write("Initing FlashDrive " + FileSystemView.getFileSystemView().getSystemDisplayName(file));
                        mainThread.InitFlashDrive(file);
                    }
                }
            }
            try {
                sleep(500);
            } catch (Exception e) {
                EventRW.Write(e);
            }
        }
    }
}
