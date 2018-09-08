package studio.visualdust.product.flashknow.method;

import studio.visualdust.product.flashknow.Resource.Resource;

import java.io.File;
import java.time.LocalTime;
import java.util.Queue;

public class Speaker {
    public static String speakFilePath = "D:\\";
    public static String speakFileType = ".vbs";

    public Speaker() {
//        (new SpeakThread()).start();
    }

    private static String getRandFileName() {
        return String.valueOf(LocalTime.now().getHour()) + String.valueOf(LocalTime.now().getMinute()) + String.valueOf(LocalTime.now().getSecond()) + String.valueOf(LocalTime.now().getNano());
    }

    public static void Speak(String sentence) {
//        File file = FileWriter.Write(speakFilePath + getRandFileName(), speakFileType, "CreateObject(\"SAPI.SpVoice\").Speak(\"" + sentence + "\")");
        try {
//            file.deleteOnExit();
            Runtime.getRuntime().exec("mshta vbscript:CreateObject(\"SAPI.SpVoice\").Speak(\"" + sentence + "\")(window.close)");
//            EventRW.Write("Speaking with file " + file.getPath());
        } catch (Exception e) {
            EventRW.Write(e);
        }
//        file.delete();
    }


    public static void main(String[] args) {
        Speak("Speaker Test");
    }

//    private class SpeakThread extends Thread {
//        @Override
//        public void run() {
//            for (; ; ) {
//                if (!speakerFileQue.isEmpty()) {
//                    //Read a file from head and pop it soon
//                }
//                try {
//                    sleep(233);
//                } catch (Exception e) {
//                    EventRW.Write(e);
//                }
//            }
//        }
//    }
}
