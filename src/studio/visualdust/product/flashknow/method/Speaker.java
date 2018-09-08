package studio.visualdust.product.flashknow.method;

import java.io.File;
import java.time.LocalTime;

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
//        File file = new File(speakFilePath + getRandFileName() + speakFileType);
//        FileWriter.WriteUnicode(file, sentence, false);
        try {
//            file.deleteOnExit();
            Runtime.getRuntime().exec("mshta vbscript:CreateObject(\"SAPI.SpVoice\").Speak(\"" + sentence + "\")(window.close)");
            EventRW.Write("Speaking : " + sentence);
//            Runtime.getRuntime().exec(file.getPath());
//            EventRW.Write("Speaking with file " + file.getPath());
        } catch (Exception e) {
            EventRW.Write(e);
        }
//        file.delete();
    }

//    public static void main(String[] args) {
//        Speak("Speaker Test");
//    }
}
