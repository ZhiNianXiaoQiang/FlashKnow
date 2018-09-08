package studio.visualdust.product.flashknow;

import studio.visualdust.product.flashknow.Resource.Resource;
import studio.visualdust.product.flashknow.method.EventRW;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;

public class UITheme {
    public UITheme(JFrame parent) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            EventRW.Write(e);
        }
        parent.setTitle(Resource.softName + Resource.version);
        Reset_Default_Fonts();
    }

    public static Font defaultFont = new Font("微软雅黑", 0, 17);

    public static void Reset_Default_Fonts() {

        String names[] = {"Label", "CheckBox", "PopupMenu", "MenuItem", "CheckBoxMenuItem",
                "JRadioButtonMenuItem", "ComboBox", "Button", "Tree", "ScrollPane",
                "TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
                "OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
                "ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
                "PasswordField", "TextField", "Table", "Label", "Viewport",
                "RadioButtonMenuItem", "RadioButton", "DesktopPane", "InternalFrame"
        };
        for (String item : names) {
            UIManager.put(item + ".font", defaultFont);
        }
    }
}
