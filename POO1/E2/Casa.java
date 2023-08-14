public class Casa {
    private Habitacion[] habitaciones;
    private int contadorHabitaciones;
    private int capacidad_Maxima = 100;

    public Casa(){
        this.habitaciones = new Habitacion[capacidad_Maxima];
        this.contadorHabitaciones = 0;
    }
    public void agregarHabitacion(Habitacion habitacion){
        if (contadorHabitaciones < habitaciones.length) {
            habitaciones[contadorHabitaciones] = habitacion;
            contadorHabitaciones++;
        } else {
            System.out.println("No se pueden agregar más habitaciones. Capacidad máxima alcanzada.");
        }
    }

    public void destruirCasa() {
        habitaciones = new Habitacion[capacidad_Maxima];
        contadorHabitaciones = 0;
        System.out.println("La casa ha sido destruida junto con todas sus habitaciones.");
    }

    public void mostrarInformacionCasa() {
        System.out.println("La casa cuenta con: " + contadorHabitaciones + " habitaciones");
        System.out.println("Numero de habitaciones disponibles: " + (habitaciones.length - contadorHabitaciones));
        System.out.println();
        System.out.println("Informacion de las habitaciones");
        for (int i = 0; i < contadorHabitaciones; i++) {
            Habitacion habitacion = habitaciones[i];
            System.out.println("Habitación #" + habitacion.getHabitacion() + " tiene un tamaño de: " + habitacion.getTamanoHabitacion() + " metros cuadrados.");
            System.out.println("------------------");
        }
    }

    public int getContadorHabitaciones() {
        return contadorHabitaciones;
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }
}
