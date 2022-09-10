package sk.tuke.coronastatapp.TempPeterClasses;

import java.awt.*;
import java.net.URI;

public class OpenDefaultBrowserWithURL {

    public static void main(String[] args) throws Exception {
        String url = "http://google.com";

        if (Desktop.isDesktopSupported()) {
            // Windows
            Desktop.getDesktop().browse(new URI(url));
        } else {
            // Ubuntu
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("/usr/bin/firefox -new-window " + url);
        }
    }
}