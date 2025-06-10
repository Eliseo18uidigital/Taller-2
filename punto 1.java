public class Animal {
    // definimos las caracteriscas del animal
    String nombre;
    String tipo;   // puede ser "terrestre", "aereo" o "acuatico"
    String genero; // puede ser "masculino" o "femenino"

    // creamos la clase animal.
    // Le pasamos el nombre, tipo y genero cuando lo creamos para que se pueda guardar.
    public Animal(String elNombre, String elTipo, String elGenero) {
        this.nombre = elNombre;   // Guardamos el nombre que nos dieron
        this.tipo = elTipo;       // Guardamos el tipo que nos dieron
        this.genero = elGenero;   // Guardamos el genero que nos dieron
    }
    // preguntamos la información del animal
    public String getNombre() {
        return nombre; // devuelve el nombre del animal
    }

    public String getTipo() {
        return tipo;   // devuelve el tipo del animal
    }

    public String getGenero() {
        return genero; // devuelve el genero del animal
    }

    // despues de crear el animal, podemos cambiar su información si queremos.
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre; // Cambia el nombre del animal
    }

    public void setTipo(String nuevoTipo) {
        this.tipo = nuevoTipo;     // Cambia el tipo del animal
    }

    public void setGenero(String nuevoGenero) {
        this.genero = nuevoGenero; // Cambia el genero del animal
    }

    // Este método nos ayuda a imprimir el animal,mostrando por ahora solo su nombre.
    @Override
    public String toString() {
        return nombre; // Cuando pidas imprimir un animal, solo verás su nombre
    }
}
