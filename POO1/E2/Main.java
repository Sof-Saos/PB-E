import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Casa casa = new Casa();
        Habitacion habitacion1 = new Habitacion(12, 45);
        Habitacion habitacion2 = new Habitacion(43, 34);
        Habitacion habitacion3 = new Habitacion(54, 67);

        casa.agregarHabitacion(habitacion1);
        casa.agregarHabitacion(habitacion2);
        casa.agregarHabitacion(habitacion3);

        int opcion;
        do {
            System.out.println("1. Ver informacion completa");
            System.out.println("2. Ver numero de habitaciones");
            System.out.println("3. Agregar habitaciones");
            System.out.println("4. Destruir casa");
            System.out.println("5. Salir del programa.");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    casa.mostrarInformacionCasa();
                    break;
                case 2:
                    System.out.println(casa.getContadorHabitaciones());
                    break;
                case 3:
                    agregarHabitacionesConsola(casa);
                    break;
                case 4:
                    casa.destruirCasa();
                    System.out.println();
                    System.out.println("Verificacion de eliminacion");
                    casa.mostrarInformacionCasa();
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
                    break;
            }
        } while (opcion!=5);
    }

    public static void agregarHabitacionesConsola(Casa casa){
        System.out.println("Ingrese la cantidad de habitaciones que desea agregar:" );
        int cantidadNuevasHab = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<cantidadNuevasHab; i++) {
            System.out.print("Ingrese el numero de la habitacion: ");
            int numero = sc.nextInt();
            System.out.print("Ingrese el tamano en metros cuadrados de la habitacion: ");
            double metros = sc.nextDouble();
            Habitacion habitacion = new Habitacion(numero, metros);
            casa.agregarHabitacion(habitacion);
            System.out.println("Habitacion agregada con exito");
        }
    }

}
