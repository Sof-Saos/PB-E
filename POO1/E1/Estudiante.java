public class Estudiante {

    private String nombre;
    private int edad;
    private long id_estudiante;

    public Estudiante(String nombre, int edad, long id_estudiante) {
        this.nombre = nombre;
        this.edad = edad;
        this.id_estudiante = id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public long getId_estudiante() {
        return id_estudiante;
    }
}
