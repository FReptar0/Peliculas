import java.util.List;

public class Peliculas {
    private String idPelicula;
    private String titulo;
    private double duracion;
    private String genero;
    private int cantidad;
    private int cantidadRentas;
    private int cantidadDeVecesRentada;
    private List<Peliculas> listaPeliculasDisponibles;
    private List<Peliculas> listaPeliculasEnRenta;

    /* CONSTRUCTORES */
    public Peliculas() {
    }

    public Peliculas(String idPelicula, String titulo, double duracion, String genero, int cantidad, int cantidadRentas,
            int cantidadDeVecesRentada) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.cantidad = cantidad;
        this.cantidadRentas = cantidadRentas;
        this.cantidadDeVecesRentada = cantidadDeVecesRentada;
    }

    /* GETTERS Y SETTERS */

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadRentas() {
        return cantidadRentas;
    }

    public void setCantidadRentas(int cantidadRentas) {
        this.cantidadRentas = cantidadRentas;
    }

    public int getCantidadDeVecesRentada() {
        return cantidadDeVecesRentada;
    }

    public void setCantidadDeVecesRentada(int cantidadDeVecesRentada) {
        this.cantidadDeVecesRentada = cantidadDeVecesRentada;
    }

    public List<Peliculas> getListaPeliculasDisponibles() {
        return listaPeliculasDisponibles;
    }

    public void setListaPeliculasDisponibles(List<Peliculas> listaPeliculasDisponibles) {
        this.listaPeliculasDisponibles = listaPeliculasDisponibles;
    }

    public List<Peliculas> getListaPeliculasEnRenta() {
        return listaPeliculasEnRenta;
    }

    public void setListaPeliculasEnRenta(List<Peliculas> listaPeliculasEnRenta) {
        this.listaPeliculasEnRenta = listaPeliculasEnRenta;
    }

    /* METODOS */

    public void mostrarPeliculasDisponibles() {
        try {
            for (Peliculas peliculas : listaPeliculasDisponibles) {
                System.out.println("ID: " + peliculas.getIdPelicula() + " Titulo: " + peliculas.getTitulo()
                        + " Duracion: " + peliculas.getDuracion() + " Genero: " + peliculas.getGenero()
                        + " Cantidad: " + peliculas.getCantidad() + " Cantidad en renta: "
                        + peliculas.getCantidadRentas() + " Cantidad de veces rentada: "
                        + peliculas.getCantidadDeVecesRentada());
            }
        } catch (Exception e) {
            System.out.println("No hay peliculas disponibles");
        }
    }

    public void mostrarPeliculasEnRenta() {
        try {
            for (Peliculas peliculas : listaPeliculasEnRenta) {
                System.out.println("ID: " + peliculas.getIdPelicula() + " Titulo: " + peliculas.getTitulo()
                        + " Duracion: " + peliculas.getDuracion() + " Genero: " + peliculas.getGenero()
                        + " Cantidad: " + peliculas.getCantidad() + " Cantidad en renta: "
                        + peliculas.getCantidadRentas()
                        + " Cantidad de veces rentada: " + peliculas.getCantidadDeVecesRentada());
            }
        } catch (Exception e) {
            System.out.println("No hay peliculas en renta");
        }
    }

    public void agregarPelicula(Peliculas pelicula) {
        int verificacion = 0;

        for (Peliculas peliculas : listaPeliculasDisponibles) {
            if (peliculas.getIdPelicula().equals(pelicula.getIdPelicula())) {
                peliculas.setCantidad(peliculas.getCantidad() + pelicula.getCantidad());
                verificacion = 1;
                break;
            }
        }

        if (verificacion == 0) {
            listaPeliculasDisponibles.add(pelicula);
            System.out.println("Pelicula agregada exitosamente");
        } else {
            System.out.println("Se aumento la cantidad de la pelicula");
        }

    }

    public void eliminarPelicula(String codigo) {
        int validacion = 0;

        for (int i = 0; i < listaPeliculasDisponibles.size(); i++) {
            if (listaPeliculasDisponibles.get(i).getIdPelicula().equals(codigo)) {
                listaPeliculasDisponibles.remove(i);
                validacion = 1;
            }
        }

        if (validacion == 0) {
            System.out.println("No se encontro la pelicula");
        } else {
            System.out.println("Pelicula eliminada");
        }
    }

    public void mostrarPeliculaMasRentada() {
        int posicion = 0;
        int posicion2 = 0;
        int mayor = 0;

        for (int i = 0; i < listaPeliculasDisponibles.size(); i++) {
            if (listaPeliculasDisponibles.get(i).getCantidadDeVecesRentada() > mayor) {
                mayor = listaPeliculasDisponibles.get(i).getCantidadDeVecesRentada();
                posicion = i;
            }
        }

        for (int i = 0; i < listaPeliculasEnRenta.size(); i++) {
            if (listaPeliculasEnRenta.get(i).getCantidadDeVecesRentada() > mayor) {
                mayor = listaPeliculasEnRenta.get(i).getCantidadDeVecesRentada();
                posicion2 = i;
            }
        }

        if (listaPeliculasDisponibles.get(posicion).getCantidadDeVecesRentada() > listaPeliculasEnRenta.get(posicion2)
                .getCantidadDeVecesRentada()) {
            System.out
                    .println("La pelicula mas rentada es: " + listaPeliculasDisponibles.get(posicion).getTitulo());
        } else {
            System.out.println("La pelicula mas rentada es: " + listaPeliculasEnRenta.get(posicion2).getTitulo());
        }

    }

    public void mostrarPeliculaMenosRentada() {
        int posicion = 0;
        int posicion2 = 0;
        int menor = 0;

        for (int i = 0; i < listaPeliculasDisponibles.size(); i++) {
            if (listaPeliculasDisponibles.get(i).getCantidadDeVecesRentada() < menor) {
                menor = listaPeliculasDisponibles.get(i).getCantidadDeVecesRentada();
                posicion = i;
            }
        }

        for (int i = 0; i < listaPeliculasEnRenta.size(); i++) {
            if (listaPeliculasEnRenta.get(i).getCantidadDeVecesRentada() < menor) {
                menor = listaPeliculasEnRenta.get(i).getCantidadDeVecesRentada();
                posicion2 = i;
            }
        }

        if (listaPeliculasDisponibles.get(posicion).getCantidadDeVecesRentada() < listaPeliculasEnRenta.get(posicion2)
                .getCantidadDeVecesRentada()) {
            System.out.println("La pelicula menos rentada es: " + listaPeliculasDisponibles.get(posicion).getTitulo());
        } else {
            System.out.println("La pelicula menos rentada es: " + listaPeliculasEnRenta.get(posicion).getTitulo());
        }

    }

}
