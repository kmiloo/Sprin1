package hotel;

import java.util.Objects;

public class Habitacion {

    private String tipo;
    private int precio;
    private int capacidad;


    public Habitacion(String tipo, int precio, int capacidad){

        this.tipo = tipo;
        this.precio = precio;
        this.capacidad = capacidad;
    }



    public String getTipo() {
        return tipo;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o){
        // Compara con el objeto o con una instancia
        if(this == o)
            return true;
        // Omitir los objetos nulos
        if(o == null)
            return false;

        //validamos la clase del objeto entregado
        if(getClass() != o.getClass())
            return false;

        Habitacion a = (Habitacion) o;

        //Comparando entre valores
        return Objects.equals(tipo, a.tipo);
    }

    
    
    
}
