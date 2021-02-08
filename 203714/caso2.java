import java.util.Scanner;
public class caso2{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("BIENVENIDO");
        String nombre,direccion;
        System.out.println("Ingrese su nombre: ");
        nombre=scanner.next();
        System.out.println("Ingrese su direccion ");
        direccion=scanner.next();

        Cliente cliente = new Cliente();
        cliente.setCliente(nombre, direccion);
        menu();
        System.out.println("--------------------------------------");
        System.out.println("DATOS DEL COMPRADOR.");
        System.out.println("enviando pedido a nombre de: "+ cliente.getNombre());
        System.out.println("enviando con direccion a: "+ cliente.getDireccion());
        System.out.println("--------------------------------------");
    }

    public static void menu(){
        int eleccion=0, pedidoEnsalada=0, pedidoRapida=0;
        double pedidoCarne=0;
        do{
            System.out.println("--------------------------------------");
        System.out.println("                     Menu");
        System.out.println("Contamos con los siugientes alimentos:");
        System.out.println("1.- Ensaladas                 $50");
        System.out.println("2.- Carnes                    $40");
        System.out.println("3.- Comida rapida             $30");
        System.out.println("4.- Ir a ticket");
        System.out.println("Escriba su eleccion:");
        do{
            eleccion=scanner.nextInt();
           }while(eleccion<=0 || eleccion>=5);
           System.out.println("--------------------------------------");
           System.out.println("--------------------------------------");
        switch (eleccion){
            case 1:
            pedidoEnsalada=ensalada();
            break;
            case 2:
            pedidoCarne=carnes();
            break;
            case 3:
            pedidoRapida=rapida();
            break;
            case 4:
            ticket(pedidoEnsalada, pedidoCarne, pedidoRapida);
            break;
            default:
        }
    }while(eleccion>0 && eleccion<4);
    }

    public static int ensalada() {
        int cantidadE=0, aderezo;
        
        System.out.println("Seleccione la cantidad de ensalada que desee");
        System.out.println("La orden tiene un costo de $50.00");
        do{
            cantidadE=scanner.nextInt();
           }while(cantidadE<0);
        cantidadE=cantidadE*50;
        System.out.println("Desea agregar un aderezo extra en su orden? tendria un costo de $25 ");
        System.out.println("1==si      2==no");
        aderezo=scanner.nextInt();
        if (aderezo==1){
            System.out.println("Se ha agregado el aderezo a su cuenta");
            cantidadE=cantidadE+25;
        }else{System.out.println("No se ha agregado el aderezo a su cuenta");}
        return cantidadE; 
    }

    public static double carnes() {
        int tipo;
        double cantidadC=0;
        System.out.println("Seleccione la cantidad de carne que desee o escriba una: ");
        System.out.println("La orden tiene un costo de $40.00");
        System.out.println("1.- Un medio de orden, se le cobrara como una orden completa");
        System.out.println("2.- Una orden entera");
        System.out.println("3.- Mas de una orden:");
        do{
            tipo=scanner.nextInt();
           }while(tipo<0);
        switch (tipo){
            case 1:
            System.out.println("Se ha tomado la orden de un medio de orden de carne");
            cantidadC=0.5;
            break;
            case 2:
            System.out.println("Se ha tomado la orden de un entero de orden de carne");
            cantidadC=1;
            break;
            case 3:
            System.out.println("Ingrese una cantidad de carne que desee: ");
            cantidadC=scanner.nextDouble();
            break;
        }
        System.out.println("Orden de comida carne tomada");
        System.out.println("Cantidad: " + cantidadC);
        return cantidadC;
    }

    public static int rapida() {
        int ComidaR;
        System.out.println("Ingrese la cantidad papas que desee: ");
        System.out.println("La orden tiene un costo de $30.00");

        do{
            ComidaR=scanner.nextInt();
           }while(ComidaR<0);
    System.out.println("Orden de comida rapida tomada");
    System.out.println("Cantidad: " + ComidaR);
    return ComidaR;
    }

    
    public static void ticket(int cantidadE, double cantidadC, int comidaR){
        double costoC=0, costoR=0, desE=0, desC=0, sub=0, total=0;
        if (cantidadC<1) {
            costoC=40;
        }

        System.out.println(" ");
        System.out.println("------------Pedido------------");
        System.out.println(" ");
        
        if (cantidadE%2==0) {
            System.out.println("Precio de ensalada:....$"+cantidadE);
        }
        else{
            System.out.println("Ensalada + aderezo:....$"+cantidadE);
        }

        System.out.println("Carne(s)..............."+cantidadC);

        if (cantidadC<1) {
            System.out.println("Precio media orden:....$"+costoC);
        }else{
            costoC=cantidadC*40;
            System.out.println("Precio por orden:....$"+costoC);}

        System.out.println("Comida Rapida(s)......."+comidaR);
        costoR=comidaR*30;
        System.out.println("Costo por rapida.......$"+costoR);
        System.out.println(" ");
        System.out.println("------------------------------");
        System.out.println(" ");
        System.out.println("-----------POR ANIVERSARIO------------");
        System.out.println("10% DE DESCUENTO EN ENSALADAS Y CARNES");
        System.out.println("5% DE DESCUENTO EN COMIDA RAPIDA");
        System.out.println("--------------------------------------");
        desE=cantidadE*0.90;
        desC=costoC*0.90;
        costoR=costoR*0.95;
        sub=costoR+desC+desE;
        System.out.println("PRECIO FINAL ENSALADA: "+desE);
        System.out.println("PRECIO FINAL CARNE: "+desC);
        System.out.println("PRECIO FINAL COMIDA RAPIDA: "+costoR);
        System.out.println("SUBTOTAL: "+sub);
        total=(sub)+sub*0.16;
        System.out.println("TOTAL + IVA(16%): "+total);
        System.out.println("--------------------------------------");
       
    }


}
