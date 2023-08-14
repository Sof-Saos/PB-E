public class Universidad {

    private String nombre;
    private Estudiante[] estudiantes;
    private int contadorEstudiantes;
    int maxEstudiantes = 100;
    public Universidad(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new Estudiante[maxEstudiantes];
        this.contadorEstudiantes = 0;
    }

    public void agregarEstudiantes(Estudiante estudiante) {
        if (contadorEstudiantes < estudiantes.length) {
            estudiantes[contadorEstudiantes] = estudiante;
            contadorEstudiantes++;
        } else {
            System.out.println("No se pueden agregar más estudiantes. Capacidad máxima alcanzada.");
        }
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public String getNombre() {
        return nombre;
    }
    public int getContadorEstudiantes() {
        return contadorEstudiantes;
    }
}
