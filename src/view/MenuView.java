package view;
import java.util.Scanner;

public class MenuView {
    Scanner sn = new Scanner(System.in);
    public MenuView (){}

    public int menuPpal() {
        int a = 3;
       // do {
            System.out.println("===========================================");
            System.out.println("====Hola Bienvenido al sistema bancario====");
            System.out.println("===========================================");
            System.out.println("Seleccione lo que desea hacer:");
            System.out.println("1. GESTIONAR CUENTAS");
            System.out.println("2. TRANSACCIONES");
            System.out.println("0. SALIR");
            a = sn.nextInt();
       // } while (a != 0 || a!= 2 || a!= 1);
            return a;

    }
}
