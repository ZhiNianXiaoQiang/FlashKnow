package studio.visualdust.product.flashknow;

import studio.visualdust.product.flashknow.GUI.Console;
import studio.visualdust.product.flashknow.Runable.MainThread;
import studio.visualdust.product.flashknow.Structure.SaySomething;

public class FlashKnowLuncher {
    public static void main(String[] args) {
//        new SaySomething();
        Console console = new Console();
        new UITheme(console);
        MainThread mainThread = new MainThread(console);
    }
}
