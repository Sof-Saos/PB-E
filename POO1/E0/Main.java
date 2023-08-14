import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long numCuenta = generarNumCuenta();
        Cuenta account = new Cuenta("Sardina Mendez", 200000, numCuenta);

        int opcion;

        System.out.println("Primero debe crear el pin de la cuenta");
        int pin = sc.nextInt();

        do {
            System.out.println(" ");
            System.out.println("1. Ver todos los datos de cuenta");
            System.out.println("2. Ver titular");
            System.out.println("3. Ver saldo de cuenta");
            System.out.println("4. Ver numero de cuenta");
            System.out.println("5. Ingresar más dinero a la cuenta");
            System.out.println("6. Retirar dinero de la cuenta");
            System.out.println("7. Salir del programa");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el pin para acceder a estos datos: ");
                    int verificacion1 = sc.nextInt();
                    if (verificacion1 == pin) {
                    account.mostrar();
                    } else {
                        System.out.println("Pin incorrecto, intente de nuevo");
                    }
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println(account.getTitular());
                    System.out.println("Desea cambiar el nombre del titular? SI/NO");
                    String cambiar = sc.nextLine();
                    if (cambiar.equals("SI")) {
                        System.out.print("Ingrese el nuevo nombre: ");
                        String newname = sc.nextLine();
                        account.setTitular(newname);
                    } else {
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el pin para acceder a estos datos: ");
                    int verificacion2 = sc.nextInt();
                    if (verificacion2 == pin) {
                        System.out.println(" ");
                        System.out.println(account.getCantidad());
                    } else {
                        System.out.println("Pin incorrecto, intente de nuevo");
                    }
                    break;
                case 4:
                    System.out.println(numCuenta);
                    break;
                case 5:
                    System.out.println(" ");
                    double saldoIngresado = sc.nextDouble();
                    account.ingresar(saldoIngresado);
                    break;
                case 6:
                    System.out.println(" ");
                    System.out.println("Ingrese el pin para acceder a estos datos: ");
                    int verificacion3 = sc.nextInt();
                    if (verificacion3 == pin) {
                        double saldoRetirar = sc.nextDouble();
                        account.retirar(saldoRetirar);
                    } else {
                        System.out.println("Pin incorrecto, intente de nuevo");
                    }
                    break;
                case 7:
                    System.out.println(" ");
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Introduce una opción válida.");
            }
        } while (opcion != 7);
    }

    private static long generarNumCuenta(){
        Random random = new Random();
        long accountpin = random.nextLong();
        return accountpin;
    }
}
