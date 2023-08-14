import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Universidad universidad = new Universidad("Universidad XYZ");


        Estudiante estudiante1 = new Estudiante("Juan", 20, 1011221);
        Estudiante estudiante2 = new Estudiante("María", 22, 10234255);
        Estudiante estudiante3 = new Estudiante("Carlos", 19, 10375476);
        Estudiante estudiante4 = new Estudiante("Ana", 21, 10476888);

        universidad.agregarEstudiantes(estudiante1);
        universidad.agregarEstudiantes(estudiante2);
        universidad.agregarEstudiantes(estudiante3);
        universidad.agregarEstudiantes(estudiante4);
        int op;
    do {
        System.out.println("Bienvenido a la " + universidad.getNombre());
        System.out.println("1. Ver todos los estudiantes.");
        System.out.println("2. Agregar un estudiante a la lista.");
        System.out.println("3. Ver cantidad de estudiantes matriculados.");
        System.out.println("4. Salir de programa");
        System.out.print("Seleccione una opcion: ");
        op = sc.nextInt();

        switch (op) {
            case 1:
                recorrerYMostrarEstudiantes(universidad);
                break;
            case 2:
                agregarEstudiante(universidad);
                break;
            case 3:
                System.out.println(universidad.getContadorEstudiantes());
                break;
            case 4:
                System.out.println("Saliendo del programa. ¡Hasta luego!");
                break;
        }
    } while (op != 4);

    }

    public static void recorrerYMostrarEstudiantes(Universidad universidad) {
        Estudiante[] estudiantes = universidad.getEstudiantes();
        for (int i = 0; i < universidad.getContadorEstudiantes(); i++) {
            Estudiante estudiante = estudiantes[i];
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Edad: " + estudiante.getEdad());
            System.out.println("Número de estudiante: " + estudiante.getId_estudiante());
            System.out.println("-----------------------------");
        }
    }

    public static void agregarEstudiante(Universidad universidad) {
        System.out.println("Ingrese la cantidad de estudiantes que desea agregar:");
        int cantidadEstudiantes = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("Ingrese el nombre del estudiante:");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la edad del estudiante:");
            int edad = sc.nextInt();
            System.out.println("Ingrese el número de estudiante:");
            int numeroEstudiante = sc.nextInt();
            Estudiante estudiante = new Estudiante(nombre, edad, numeroEstudiante);
            universidad.agregarEstudiantes(estudiante);
            System.out.println("Estudiante agregado con éxito.");
        }
    }
}
