import java.util.Random;
import java.util.Scanner;
public class Cuenta {
    private static double saldoDeCuenta;
    private static String nombreDelTitular;
    private static long numeroDeCuenta;

    public Cuenta(double saldoDeCuenta, String nombreDelTitular) {
        this.saldoDeCuenta = saldoDeCuenta;
        this.nombreDelTitular = nombreDelTitular;
        this.numeroDeCuenta = generarNumeroDeCuentaAleatorio();
    }

    public double setIngreso(double ingreso) {
        saldoDeCuenta += ingreso;
        return saldoDeCuenta;
    }

    public void setRetiro(double retiro) {
        if (retiro <= saldoDeCuenta) {
            saldoDeCuenta -= retiro;
            System.out.println("Saldo correctamente retirado");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double getSaldoDeCuenta() {
        return saldoDeCuenta;
    }

    public void getDatosCuenta() {
        System.out.println("Señor/a: " + nombreDelTitular);
        System.out.println("Numero de cuenta corriente " + numeroDeCuenta);
        System.out.println("Su saldo es: " + saldoDeCuenta);
    }

    private long generarNumeroDeCuentaAleatorio() {
        Random random = new Random();
        return Math.abs(random.nextLong());
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese saldo inicial: ");
        double saldoInicial = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese nombre del titular: ");
        String nombreTitular = sc.nextLine();
        Cuenta cuenta = new Cuenta(saldoInicial, nombreTitular);

        int opcion;
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
            switch (opcion){
                case 1:
                    cuenta.getDatosCuenta();
                    break;
                case 2:
                    System.out.println("La cuenta se encuentra a nombre de: " + Cuenta.nombreDelTitular);
                    break;
                case 3:
                    System.out.println("El saldo de su cuenta es: " + cuenta.getSaldoDeCuenta());
                    break;
                case 4:
                    System.out.println("El numero de cuenta es: " + Cuenta.numeroDeCuenta);
                    break;
                case 5:
                    System.out.print("Digite la cantidad a ingresar: ");
                    double saldoIngresado = sc.nextDouble();
                    cuenta.setIngreso(saldoIngresado);
                    System.out.println("Saldo correctamente ingresado");
                    break;
                case 6:
                    System.out.print("Digite la cantidad a retirar: ");
                    double saldoRetirado = sc.nextDouble();
                    cuenta.setRetiro(saldoRetirado);
                    break;
                case 7:
                    System.out.println(" ");
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Introduce una opción válida.");
            }
        } while(opcion != 7);
    }
}
