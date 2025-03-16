class Mision implements Comparable<Mision> {
    private String nombre;
    private Prioridad prioridad;

    public Mision(String nombre, Prioridad prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    // MÉTODO COMPARETO PARA ORDENAR PRIMERO POR PRIORIDAD Y LUEGO POR NOMBRE
    @Override
    public int compareTo(Mision otra) {
        // PRIMERO, SE COMPARA POR PRIORIDAD
        int resultado = this.prioridad.compareTo(otra.prioridad);

        // SI LAS PRIORIDADES SON IGUALES, SE ORDENA POR NOMBRE EN ORDEN ALFABÉTICO
        if (resultado == 0) {
            resultado = this.nombre.compareToIgnoreCase(otra.nombre);
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "[Prioridad: " + prioridad + "] " + nombre;
    }
}