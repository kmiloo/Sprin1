package hotel;

import java.util.Objects;

public class Cliente{

    private String nombre;
    private String rut;
    private int edad;
    private int pasajeros;

    public Cliente(String nombre, String rut, int pasajeros){
        this.nombre = nombre;
        this.rut=rut;
        this.pasajeros=pasajeros;
        
    }



    public int getPasajeros() {
        return pasajeros;
    }



    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }



    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

        Cliente a = (Cliente) o;

        //Comparando entre valores
        return Objects.equals(rut, a.rut) && Objects.equals(nombre, a.nombre)&& Objects.equals(pasajeros, a.pasajeros);
    }

    










}
