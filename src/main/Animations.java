package main;

public class Animations {
    public static void launchGameAnimation() {
        System.out.println("#################################################");
        Animations.wait(1000);
        System.out.println("############## Bienvenido al juego ##############");
        Animations.wait(1000);
        System.out.println("#################################################");
        Animations.wait(2000);
        Animations.clearScreen();
    }
    public static void closeGameAnimation() {
        System.out.println("#################################################");
        Animations.wait(1000);
        System.out.println("############### Gracias por jugar ###############");
        Animations.wait(1000);
        System.out.println("#################################################");
        Animations.wait(2000);
        Animations.clearScreen();
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
