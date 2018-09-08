package studio.visualdust.product.flashknow;

import studio.visualdust.product.flashknow.GUI.Console;
import studio.visualdust.product.flashknow.Runable.MainThread;
import studio.visualdust.product.flashknow.method.EventRW;
import studio.visualdust.product.flashknow.method.Speaker;

public class FlashKnowLuncher {
    public static void main(String[] args) {
        Speaker.Speak("移动存储身份识别已启动。 powered by Studio dot VisualDust (original GZT)");
//        new SaySomething();
        try {
            Thread.sleep(9000);
        } catch (Exception e) {
            EventRW.Write(e);
        }
        Console console = new Console();
        new UITheme(console);
        MainThread mainThread = new MainThread(console);
    }
}
