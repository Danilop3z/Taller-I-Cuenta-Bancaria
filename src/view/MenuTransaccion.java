package view;
import controller.GestionCuenta;
import enums.ETypeFile;

import java.util.Scanner;

public class MenuTransaccion {

    Scanner sn = new Scanner(System.in);
    GestionCuenta gc;

    public MenuTransaccion(GestionCuenta gc){
        this.gc = gc;
      //  gc.loadFile(ETypeFile.FILE_PLAIN);
    }

    public void menuTra(){
        System.out.println("===TRANSACCIONES===");
        System.out.println("1. CONSIGNAR");
        System.out.println("2. RETIRAR");
        System.out.println("3. TRANSFERIR");
        System.out.println("0. ATRAS");
        int a = sn.nextInt();

        switch (a){
            case 1->{
                System.out.println("Ingrese la id de la cuenta a la que va a consignar");
                int id = sn.nextInt();
                System.out.println("Ingrese el monto que va a consignar");
                double sld = sn.nextDouble();
                gc.consignar(id,sld);

gc.dumpFile(ETypeFile.FILE_PLAIN);
gc.dumpFile(ETypeFile.CSV);
            }
            case 2->{
                System.out.println("Ingrese la id de la cuenta de la cual va a retirar");
                int id = sn.nextInt();
                System.out.println("Ingrese el monto que desea retirar");
                double sld = sn.nextDouble();
                gc.findCuentaById(id).retirar(sld);
                System.out.println("Retiro Exitoso!!");
 gc.dumpFile(ETypeFile.FILE_PLAIN);
 gc.dumpFile(ETypeFile.CSV);
            }
            case 3->{
                System.out.println("Ingrese la id de cuenta que va a enviar");
                int id1 = sn.nextInt();
                System.out.println("Ingrese la id de cuenta que va a recibir");
                int id2 = sn.nextInt();
                System.out.println("Ingrese el monto que va a transferir");
                double sld = sn.nextDouble();
                gc.transferir(id1, id2, sld);

gc.dumpFile(ETypeFile.FILE_PLAIN);
gc.dumpFile(ETypeFile.CSV);
            }
            case 0->{

            }
            default ->{

            }
        }
    }
}
