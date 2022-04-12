package hotel;

public class Reserva {

    private float precio;
    private float total;
    private int  noches;


    public Reserva(float precio,int noches){

        //this.precio = precio;
        //this.noches = noches;
    }


    public float getTotal(float precio, int noches) {
        total = noches * precio;
        return total;
    }


    public float getPrecio() {
        return precio;
    }


    public void setPrecio(float precio) {
        this.precio = precio;
    }


    public int getNoches() {
        return noches;
    }


    public void setNoches(int noches) {
        this.noches = noches;
    }


    
    

    
}
