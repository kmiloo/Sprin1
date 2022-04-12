package hotel;

public class Excursion {
    private String tipo;
    private String descripcion;
    private int precio;




    public Excursion(String tipo, String descripcion, int precio){

        this.tipo=tipo;
        this.descripcion=descripcion;
        this.precio=precio;
    }













    public String getTipo() {
        return tipo;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
