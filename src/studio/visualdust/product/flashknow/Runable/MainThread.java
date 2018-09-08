package studio.visualdust.product.flashknow.Runable;

import studio.visualdust.product.flashknow.GUI.Console;
import studio.visualdust.product.flashknow.GUI.FlashInfoFillerFrame;
import studio.visualdust.product.flashknow.Resource.Resource;
import studio.visualdust.product.flashknow.Structure.FlashDrive;
import studio.visualdust.product.flashknow.Structure.SaySomething;
import studio.visualdust.product.flashknow.method.EventRW;
import studio.visualdust.product.flashknow.method.FileWriter;
import studio.visualdust.product.flashknow.method.Speaker;

import java.io.File;
import java.util.Vector;

public class MainThread {
    public Vector<FlashDrive> oriDriveList = new Vector<>();
    public Speaker speaker;
    public SaySomething saySomething = new SaySomething();
    FlashScanner flashScanner = new FlashScanner(this);

    public MainThread(Console console) {
        flashScanner.start();
        new clearThread().start();
    }

    public void check(FlashDrive flashDrive) {
//        System.out.println("Checking FlashDrive " + flashDrive.toString());
        if (!BeIn(flashDrive, oriDriveList)) {
            oriDriveList.add(flashDrive);
            EventRW.Write("Connected " + flashDrive.toString());
            speaker.Speak(saySomething.getRandOP() + "" + flashDrive.getOwnerNmae() + "," + saySomething.getRandED());
            //TODO add GUIrefresh()
        }
    }

    public boolean BeIn(FlashDrive flashDrive, Vector<FlashDrive> driveList) {
        boolean b = false;
        for (int i = 0; i < driveList.size(); i++) {
            if (flashDrive.equal(driveList.elementAt(i))) {
                b = true;
                break;
            }
        }
        return b;
    }

    public void InitFlashDrive(File file) {
        FlashInfoFillerFrame flashInfoFillerFrame = new FlashInfoFillerFrame(file);
        Speaker.Speak("请问这个U盘是谁的？我们好像初次见面");
        while (flashInfoFillerFrame.isVisible()) {
            System.out.println("Waiting");
        }
        String ownerName = flashInfoFillerFrame.getOwnerName();
        String discription = flashInfoFillerFrame.getDiscription();
        File f = new File(file.getPath() + Resource.infLocation + "discription");
        f.getParentFile().mkdirs();
        FileWriter.WriteUTF8(new File(file.getPath() + Resource.infLocation + "discription"), discription, false);
        FileWriter.WriteUTF8(new File(file.getPath() + Resource.infLocation + "discription"), ownerName, true);
        try {
            EventRW.Write("attrib +s +h " + file.getPath() + "DriveInfo");
            Runtime.getRuntime().exec("attrib +s +h " + file.getPath() + "DriveInfo");
        } catch (Exception e) {
            EventRW.Write(e);
        }
    }

    public class clearThread extends Thread {
        File[] nowRootList;

        @Override
        public void run() {
            for (; ; ) {
                try {
                    sleep(Resource.checkDelayTime);
                    nowRootList = File.listRoots();
                    Vector<FlashDrive> driveList = new Vector<>();
                    for (int i = 0; i < nowRootList.length; i++) {
                        if (FlashDrive.isKnownFlash(nowRootList[i])) {
                            driveList.add(FlashDrive.getDriveClassOf(nowRootList[i]));
                        }
                    }
                    for (int i = 0; i < oriDriveList.size(); i++) {
                        if (!BeIn(oriDriveList.elementAt(i), driveList)) {
                            EventRW.Write("Disconnected " + oriDriveList.elementAt(i).toString());
                            Speaker.Speak("再见" + oriDriveList.elementAt(i).getOwnerNmae() +"，"+ saySomething.getRandLE());
                            oriDriveList.removeElementAt(i);
                        }
                    }
                } catch (Exception e) {
                    EventRW.Write(e);
                }
            }
        }
    }
}
