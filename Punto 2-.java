public class Persona {
    // Atributos de la persona
    String nombre;
    String apellido;
    int edad;
    String genero;     // "masculino" o "femenino"
    double sueldoHora;
    String cargo;

    // Constructor para crear una Persona
    public Persona(String nombre, String apellido, int edad, String genero, double sueldoHora, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.sueldoHora = sueldoHora;
        this.cargo = cargo;
    }

    // Métodos Getters (para obtener los datos)
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }

    public String getCargo() {
        return cargo;
    }

    // Métodos Setters (para cambiar los datos, si es necesario)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método para imprimir la información de la persona de forma legible
    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido + ", Edad: " + edad +
                ", Género: " + genero + ", Sueldo/Hora: $" + sueldoHora + ", Cargo: " + cargo;
    }
}
