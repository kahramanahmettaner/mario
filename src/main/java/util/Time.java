package util;

public class Time {
    public static float timeStarted = System.nanoTime(); // a static variable is initialized at the application start!

    public static float getTime() {
        return (float) ((System.nanoTime() - timeStarted) * 1E-9); // 1E-9 to convert ns to sec
    }
}
