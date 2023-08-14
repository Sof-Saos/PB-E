import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Cuenta {
    private double saldoDeCuenta;
    private String nombreDelTitular;
    private long numeroDeCuenta;

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
    public long getNumeroDeCuenta() {
        return numeroDeCuenta;
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

    public String getNombreDelTitular() {
        return nombreDelTitular;
    }

    public static void imprimirCuentas(List<Cuenta> cuentas) {
        System.out.println("Cuentas disponibles:");
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println((i + 1) + ". " + cuentas.get(i).getNombreDelTitular());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cuenta cuenta1 = new Cuenta(1000.0, "Gerard Way");
        Cuenta cuenta2 = new Cuenta(500.0, "Oli Sykes");
        Banco banco = new Banco(cuenta1, cuenta2);
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        int opcion;
        do {
            System.out.println(" ");
            System.out.println("1. Ver todos los datos de cuenta especifica");
            System.out.println("2. Ver titular de una especifica");
            System.out.println("3. Ver saldo de cuenta de una especifica");
            System.out.println("4. Ver numero de cuenta de una especifica");
            System.out.println("5. Ingresar más dinero a la cuenta especifica");
            System.out.println("6. Retirar dinero de la cuenta de una especifica");
            System.out.println("7. Agregar cuenta");
            System.out.println("8. Ver cuentas inscritas");
            System.out.println("9. Transferir de una cuenta a otra");
            System.out.println("10. Salir del programa");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese número de cuenta de la que desea ver:");
                    long numeroCuentaVer = sc.nextLong();
                    for (Cuenta cuenta : cuentas) {
                        if (cuenta.getNumeroDeCuenta() == numeroCuentaVer) {
                            cuenta.getDatosCuenta();
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese número de cuenta para ver el titular:");
                    long numeroCuentaTitular = sc.nextLong();
                    for (Cuenta cuenta : cuentas) {
                        if (cuenta.getNumeroDeCuenta() == numeroCuentaTitular) {
                            System.out.println("El titular de la cuenta es: " + cuenta.getNombreDelTitular());
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese número de cuenta para ver el saldo:");
                    long numeroCuentaSaldo = sc.nextLong();
                    for (Cuenta cuenta : cuentas) {
                        if (cuenta.getNumeroDeCuenta() == numeroCuentaSaldo) {
                            System.out.println("El saldo de la cuenta es: " + cuenta.getSaldoDeCuenta());
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del titular para ver el número de cuenta:");
                    String titularBuscar = sc.nextLine();
                    boolean encontrada = false;

                    for (Cuenta cuenta : cuentas) {
                        if (cuenta.getNombreDelTitular().equalsIgnoreCase(titularBuscar)) {
                            System.out.println("El número de cuenta de " + titularBuscar + " es: " + cuenta.getNumeroDeCuenta());
                            encontrada = true;
                            break;
                        }
                    } if (!encontrada) {
                        System.out.println("No se encontró ninguna cuenta asociada a " + titularBuscar); }
                    break;
                case 5:
                    System.out.println("Ingrese número de cuenta para realizar el ingreso:");
                    long numeroCuentaIngreso = sc.nextLong();
                    for (Cuenta cuenta : cuentas) {
                        if (cuenta.getNumeroDeCuenta() == numeroCuentaIngreso) {
                            System.out.print("Ingrese la cantidad a ingresar: ");
                            double saldoIngresado = sc.nextDouble();
                            cuenta.setIngreso(saldoIngresado);
                            System.out.println("Saldo correctamente ingresado");
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Ingrese número de cuenta para realizar el retiro:");
                    long numeroCuentaRetiro = sc.nextLong();
                    for (Cuenta cuenta : cuentas) {
                        if (cuenta.getNumeroDeCuenta() == numeroCuentaRetiro) {
                            System.out.print("Digite la cantidad a retirar: ");
                            double saldoRetirado = sc.nextDouble();
                            cuenta.setRetiro(saldoRetirado);
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Cuantas cuentas va a ingresar?");
                    int cantidadCuentas = sc.nextInt();
                    sc.nextLine();
                    for (int i=0; i<cantidadCuentas; i++) {
                        System.out.print("Ingrese el nombre del titular: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese el saldo que tendra: ");
                        double saldoI = sc.nextDouble();
                        Cuenta cuenta = new Cuenta(saldoI, nombre);
                        cuentas.add(cuenta);
                    }
                case 8:
                    Cuenta.imprimirCuentas(cuentas);
                    break;
                case 9:
                    banco.transferencias(cuenta1, cuenta2, 100.0);
                    System.out.print("Cuenta que se retiro: ");
                    cuenta1.getDatosCuenta();
                    System.out.print("Cuenta que se ingreso: ");
                    cuenta2.getDatosCuenta();
                    break;
                case 10:
                    System.out.println(" ");
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Introduce una opción válida.");
            }
        } while(opcion != 9);
    }
}
