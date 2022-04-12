package hotel;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

//import javax.swing.JOptionPane;

import java.io.IOException;
import java.io.FileNotFoundException;
//import java.util.ArrayList;


public class Main {
    public static void main(String[] args){

        Scanner lectorr = new Scanner(System.in);

        
        int heI=9;
        int heD=10;
        int hf=10;
        int hpH=2;
        


        Habitacion ejecutivaIndividual = new Habitacion("Ejecutiva Individual", 50000, 2);
        Habitacion ejecutivaDoble = new Habitacion("Ejecutivo Doble", 80000, 4);
        Habitacion familiar = new Habitacion("Familiar", 150000, 8);
        Habitacion pentHouse = new Habitacion("Pent-House", 1080000, 2);


        PlanMenu inicial = new PlanMenu("Inicial", "Incluye el plato principal de una comida (almuerzo o cena) del menu diario a gusto del chef.", 10000);
        PlanMenu intermedio = new PlanMenu("Intermedio", "Incluye una comida (almuerzo o cena) de tres tiempos (entrada, fondo y postre) del menu diario a gusto del chef.", 25000);
        PlanMenu completo = new PlanMenu("Completo", "Incluye dos comidas, almuerzo y cena, de tres tiempos (entrada, fondo y postre) del menu diario a gusto del chef.", 45000);
        PlanMenu avanzado = new PlanMenu("Avanzado", "Incluye dos comidas, almuerzo y cena, de tres tiempos (entrada, fondo y postre) del menu abierto de especialidad del chef.", 60000);
        PlanMenu premium = new PlanMenu("Premium", "Incluye tiempo de chef dedicado a todo momento para satisfacer los gustos exclusivos y peticiones especificas de los pasajeros para una cantidad no determinada de comidas al dia.", 100000);


        Excursion light = new Excursion("Light", "Corresponde a una excursion de tipo caminata de 6 horas en total por senderos de complejidad baja con hermosos lugares de vegetacion nativa y afluentes de agua, ideal para grupos familiares con ninos o personas de 3ra edad (inclusive para personas con dificultades metrices)", 5000);
        Excursion plus = new Excursion("Plus", "Corresponde a una excursion de tipo hiking de 3 dias en total por una cadena montanosa, experiencia de campamento y contemplacion de glaciares y cascadas, ideal para grupos de personas con capacidades fisicas compatibles con la exigencia de la caminata", 25000);
        Excursion heavy = new Excursion("Heavy", "Corresponde a una excursion de tipo hiking de 5 dias en total por una cadena montanosa y con navegacion en afluentes locales. Se incluyen actividades extremas de Rapel, Canopi, Rafting y Escalada. Las actividades requieren de capacidades fisicas compatibles con la complejidad de la excursion.", 50000);

        

    
        System.out.println("\n\n**********Bienvenido al hotel**********\n\nPorfavor ingrese sus datos: ");
        //nombre = JOptionPane.showInputDialog("nombre");
        System.out.println("\nPrimero su nombre: \n");
       String  nombre = lectorr.nextLine();

        System.out.println("\nAhora su rut sin punto ni guion: \n");
        String rut = lectorr.nextLine();

        System.out.println("\nPor ultimo los pasajeros: \n");
        int pasajeros = lectorr.nextInt();

        //System.out.println("dias");
        //dias = lectorr.nextInt();

        //System.out.println("pasajeros");
        //pasajeros = lectorr.nextInt();




        Cliente cl = new Cliente(nombre,rut,pasajeros);
        




        ////creacion de archivo


        try{
            File nuevoArchivo = new File("hotel/clientes.csv");
            if(nuevoArchivo.createNewFile()){
                System.out.println("Archivo Creado: " + nuevoArchivo.getName());
            } else {
                //System.out.println("El archivo descrito ya existe!");
            }
    
        }catch(IOException e){
            System.out.println("Ocurrió un error en la creación del archivo");
            e.printStackTrace();
        }


        
        

         /////////////que planes
        


        if (heI==0 && heD==0 && hf==0 && hpH ==0){

            System.out.println("Lo sentimos estamos llenos");
        }




        System.out.println("Elija la habitacion que desea reservar:\n \n1."+ejecutivaIndividual.getTipo()+"\n2."+ejecutivaDoble.getTipo()+"\n3."+familiar.getTipo()+"\n4."+pentHouse.getTipo()+"\n5.salir");
        int opcion=33;

        do{
            opcion = lectorr.nextInt();
        switch(opcion){
            case 1:
                System.out.println("\n\nLa habitacion " +ejecutivaIndividual.getTipo()+" cuenta con una capacidad de: "+ ejecutivaIndividual.getCapacidad()+" personas\nCon un precio de: $"+ ejecutivaIndividual.getPrecio()+"\n");
                System.out.println("Desea continuar? \n1.Si\n2.No\n");
                int opcion2 = lectorr.nextInt();
                do{
                switch(opcion2){
                    case 1:
                        System.out.println("\n\nTambien contamos con los siguientes planes diarios estandar con menu al gusto del chef:\n1."+inicial.getTipo()+"\n2."+intermedio.getTipo()+"\n3."+completo.getTipo()+"\n4."+avanzado.getTipo()+"\n5."+premium.getTipo()+"\n6.No gracias\n");
                        int opcion3 = lectorr.nextInt();
                        do{
                            switch(opcion3){
                                case 1:
                                    System.out.println("El plan "+inicial.getTipo()+":\n"+inicial.getDetalles()+"\nPor un precio de $"+inicial.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    int opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera111 = new Pulsera(ejecutivaIndividual.getPrecio()+inicial.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera111.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva111 = new Reserva(pulsera111.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva111.getTotal(pulsera111.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva111.getTotal(pulsera111.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera112 = new Pulsera(ejecutivaIndividual.getPrecio()+inicial.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera112.getTotal());

                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva112 = new Reserva(pulsera112.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva112.getTotal(pulsera112.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva112.getTotal(pulsera112.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera113 = new Pulsera(ejecutivaIndividual.getPrecio()+inicial.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera113.getTotal());

                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva113 = new Reserva(pulsera113.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva113.getTotal(pulsera113.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva113.getTotal(pulsera113.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera11 = new Pulsera(ejecutivaIndividual.getPrecio()+inicial.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera11.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva11 = new Reserva(pulsera11.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva11.getTotal(pulsera11.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva11.getTotal(pulsera11.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                            
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 2:
                                    System.out.println("El plan "+intermedio.getTipo()+":\n"+intermedio.getDetalles()+"\nPor un precio de $"+intermedio.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera121 = new Pulsera(ejecutivaIndividual.getPrecio()+intermedio.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera121.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva121 = new Reserva(pulsera121.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva121.getTotal(pulsera121.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva121.getTotal(pulsera121.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera122 = new Pulsera(ejecutivaIndividual.getPrecio()+intermedio.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera122.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva122 = new Reserva(pulsera122.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva122.getTotal(pulsera122.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva122.getTotal(pulsera122.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera123 = new Pulsera(ejecutivaIndividual.getPrecio()+intermedio.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera123.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea:");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva123 = new Reserva(pulsera123.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva123.getTotal(pulsera123.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva123.getTotal(pulsera123.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera12 = new Pulsera(ejecutivaIndividual.getPrecio()+intermedio.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera12.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva12 = new Reserva(pulsera12.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva12.getTotal(pulsera12.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva12.getTotal(pulsera12.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 3:
                                    System.out.println("El plan "+completo.getTipo()+":\n"+completo.getDetalles()+"\nPor un precio de $"+completo.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera131 = new Pulsera(ejecutivaIndividual.getPrecio()+completo.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera131.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva131 = new Reserva(pulsera131.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva131.getTotal(pulsera131.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva131.getTotal(pulsera131.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera132 = new Pulsera(ejecutivaIndividual.getPrecio()+completo.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera132.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva132 = new Reserva(pulsera132.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva132.getTotal(pulsera132.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva132.getTotal(pulsera132.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera133 = new Pulsera(ejecutivaIndividual.getPrecio()+completo.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera133.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva133 = new Reserva(pulsera133.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva133.getTotal(pulsera133.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva133.getTotal(pulsera133.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera13 = new Pulsera(ejecutivaIndividual.getPrecio()+completo.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera13.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva13 = new Reserva(pulsera13.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva13.getTotal(pulsera13.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva13.getTotal(pulsera13.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 4:
                                    System.out.println("El plan "+avanzado.getTipo()+":\n"+avanzado.getDetalles()+"\nPor un precio de $"+avanzado.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera141 = new Pulsera(ejecutivaIndividual.getPrecio()+avanzado.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera141.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva141 = new Reserva(pulsera141.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva141.getTotal(pulsera141.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva141.getTotal(pulsera141.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera142 = new Pulsera(ejecutivaIndividual.getPrecio()+avanzado.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera142.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva142 = new Reserva(pulsera142.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva142.getTotal(pulsera142.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva142.getTotal(pulsera142.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera143 = new Pulsera(ejecutivaIndividual.getPrecio()+avanzado.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera143.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva143 = new Reserva(pulsera143.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva143.getTotal(pulsera143.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva143.getTotal(pulsera143.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera14 = new Pulsera(ejecutivaIndividual.getPrecio()+avanzado.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera14.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva14 = new Reserva(pulsera14.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva14.getTotal(pulsera14.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva14.getTotal(pulsera14.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 5:
                                    System.out.println("El plan "+premium.getTipo()+":\n"+premium.getDetalles()+"\nPor un precio de $"+premium.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera151 = new Pulsera(ejecutivaIndividual.getPrecio()+premium.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera151.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva151 = new Reserva(pulsera151.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva151.getTotal(pulsera151.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva151.getTotal(pulsera151.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera152 = new Pulsera(ejecutivaIndividual.getPrecio()+premium.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera152.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva152 = new Reserva(pulsera152.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva152.getTotal(pulsera152.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva152.getTotal(pulsera152.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera153 = new Pulsera(ejecutivaIndividual.getPrecio()+premium.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera153.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva153 = new Reserva(pulsera153.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva153.getTotal(pulsera153.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva153.getTotal(pulsera153.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera15 = new Pulsera(ejecutivaIndividual.getPrecio()+premium.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera15.getTotal());
                                                if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva15 = new Reserva(pulsera15.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva15.getTotal(pulsera15.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaIndividual.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva15.getTotal(pulsera15.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 6:
                                    Pulsera pulsera1 = new Pulsera(ejecutivaIndividual.getPrecio());
                                    System.out.println("El total por noche es: $"+pulsera1.getTotal());
                                    if(pasajeros>ejecutivaIndividual.getCapacidad()){
                                        System.out.println("Usted no cumple con los requisitos de capacidad");
                                    }
                                    else{
                                        try{
                                            File bd = new File("hotel/clientes.csv");
                                            Scanner lector = new Scanner(bd);
                                            boolean a = false;
                                            while(lector.hasNextLine()){
                                                String linea = lector.nextLine(); 
                                                String[] valor = linea.split(",");
                                                if(ejecutivaIndividual.getTipo().equals(valor[3])){ 
                                                    heI--;
                                                }       
                                            }
                                            lector.close();
                                        }catch(FileNotFoundException e){
                                            System.out.println("ERROR: Archivo no encontrado!!!");
                                            e.printStackTrace();
                                        }
                                            if(heI<0){
                                                System.out.println("Lo sentimos no hay habitaciones disponibles");
                                            }
                                            else{
                                                System.out.println("Ingrese la cantidad de noches que desea: ");
                                                int noches = lectorr.nextInt();
                                                Reserva reserva1 = new Reserva(pulsera1.getTotal(), noches);
                                                try{
                                                    File bd = new File("hotel/clientes.csv");
                                                    Scanner lector = new Scanner(bd);
                                                    boolean a = false;
                                                    while(lector.hasNextLine()){
                                                        String linea = lector.nextLine(); 
                                                        String[] valor = linea.split(",");
                                                        if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                            System.out.println("Bienvenido denuevo");
                                                            System.out.print("El valor Total es: $"+reserva1.getTotal(pulsera1.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                            int opcion5= lector.nextInt(); 
                                                            switch(opcion5){
                                                                case 1:
                                                                    //valor[2] = cl.getPasajeros();
                                                                    valor[3] = ejecutivaIndividual.getTipo();
                                                                    //valor[4] = noches;
                                                                    break;
                                                                case 2:
                                                                    break;
                                                            }
                                                            a = true;
                                                        }
                                                        if(lector.hasNextLine()==false){
                                                            if(a==false){
                                                                try{
                                                                    FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                    System.out.print("El valor Total es: $"+reserva1.getTotal(pulsera1.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                    int opcion5= lectorr.nextInt();
                                                                    switch(opcion5){
                                                                        case 1:
                                                                            escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaIndividual.getTipo()+","+noches+"\n");
                                                            
                                                                            escritor.close();
                                                                            System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                            break;
                                                                        case 2:
                                                                            break;
                                                                    }
                                                                }catch(IOException e){
                                                                    System.out.println("Ocurrió un error en la escritura del archivo");
                                                                    e.printStackTrace();
                                                                }
                                                            }
                                                        }
                                                        
                                                    }
                                                    lector.close();
                                        
                                                }catch(FileNotFoundException e){
                                                    System.out.println("ERROR: Archivo no encontrado!!!");
                                                    e.printStackTrace();
                                                }
                                                lectorr.close(); 
                                            }
                                    }
                                    
                                    break;
                            }

                        }while(opcion3<0 || opcion3>7);
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Porfavor elejir una opcion valida: ");
                }
                }while(opcion2<0 || opcion2>3);
                break;
            case 2:
                System.out.println("La habitacion " +ejecutivaDoble.getTipo()+" cuenta con una capacidad de: "+ ejecutivaDoble.getCapacidad()+" personas\nCon un precio de: $"+ ejecutivaDoble.getPrecio()+"\n");
                System.out.println("Desea continuar? \n1.Si\n2.No\n");
                opcion2 = lectorr.nextInt();
                do{
                switch(opcion2){
                    case 1:
                        System.out.println("\n\nTambien contamos con los siguientes planes diarios estandar con menu al gusto del chef:\n1."+inicial.getTipo()+"\n2."+intermedio.getTipo()+"\n3."+completo.getTipo()+"\n4."+avanzado.getTipo()+"\n5."+premium.getTipo()+"\n6.No gracias\n");
                        int opcion3 = lectorr.nextInt();
                        do{
                            switch(opcion3){
                                case 1:
                                    System.out.println("El plan "+inicial.getTipo()+":\n"+inicial.getDetalles()+"\nPor un precio de $"+inicial.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    int opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera211 = new Pulsera(ejecutivaDoble.getPrecio()+inicial.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera211.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva211 = new Reserva(pulsera211.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva211.getTotal(pulsera211.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva211.getTotal(pulsera211.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }

                                                break;
                                            case 2:
                                                Pulsera pulsera212 = new Pulsera(ejecutivaDoble.getPrecio()+inicial.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera212.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva212 = new Reserva(pulsera212.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva212.getTotal(pulsera212.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva212.getTotal(pulsera212.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera213 = new Pulsera(ejecutivaDoble.getPrecio()+inicial.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera213.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva213 = new Reserva(pulsera213.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva213.getTotal(pulsera213.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva213.getTotal(pulsera213.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera21 = new Pulsera(ejecutivaDoble.getPrecio()+inicial.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera21.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva21 = new Reserva(pulsera21.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva21.getTotal(pulsera21.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva21.getTotal(pulsera21.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 2:
                                    System.out.println("El plan "+intermedio.getTipo()+":\n"+intermedio.getDetalles()+"\nPor un precio de $"+intermedio.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera221 = new Pulsera(ejecutivaDoble.getPrecio()+intermedio.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera221.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva221 = new Reserva(pulsera221.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva221.getTotal(pulsera221.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva221.getTotal(pulsera221.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }

                                                break;
                                            case 2:
                                                Pulsera pulsera222 = new Pulsera(ejecutivaDoble.getPrecio()+intermedio.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera222.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva222 = new Reserva(pulsera222.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva222.getTotal(pulsera222.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva222.getTotal(pulsera222.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera223 = new Pulsera(ejecutivaDoble.getPrecio()+intermedio.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera223.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva223 = new Reserva(pulsera223.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva223.getTotal(pulsera223.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva223.getTotal(pulsera223.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera22 = new Pulsera(ejecutivaDoble.getPrecio()+intermedio.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera22.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva22 = new Reserva(pulsera22.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva22.getTotal(pulsera22.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva22.getTotal(pulsera22.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 3:
                                    System.out.println("El plan "+completo.getTipo()+":\n"+completo.getDetalles()+"\nPor un precio de $"+completo.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera231 = new Pulsera(ejecutivaDoble.getPrecio()+completo.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera231.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva231 = new Reserva(pulsera231.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva231.getTotal(pulsera231.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva231.getTotal(pulsera231.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera232 = new Pulsera(ejecutivaDoble.getPrecio()+completo.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera232.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heI--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heI<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva232 = new Reserva(pulsera232.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva232.getTotal(pulsera232.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva232.getTotal(pulsera232.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera233 = new Pulsera(ejecutivaDoble.getPrecio()+completo.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera233.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva233 = new Reserva(pulsera233.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva233.getTotal(pulsera233.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva233.getTotal(pulsera233.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera23 = new Pulsera(ejecutivaDoble.getPrecio()+completo.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera23.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva23 = new Reserva(pulsera23.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva23.getTotal(pulsera23.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva23.getTotal(pulsera23.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 4:
                                    System.out.println("El plan "+avanzado.getTipo()+":\n"+avanzado.getDetalles()+"\nPor un precio de $"+avanzado.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera241 = new Pulsera(ejecutivaDoble.getPrecio()+avanzado.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera241.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva241 = new Reserva(pulsera241.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva241.getTotal(pulsera241.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva241.getTotal(pulsera241.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera242 = new Pulsera(ejecutivaDoble.getPrecio()+avanzado.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera242.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva242 = new Reserva(pulsera242.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva242.getTotal(pulsera242.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva242.getTotal(pulsera242.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera243 = new Pulsera(ejecutivaDoble.getPrecio()+avanzado.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera243.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva243 = new Reserva(pulsera243.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva243.getTotal(pulsera243.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva243.getTotal(pulsera243.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera24 = new Pulsera(ejecutivaDoble.getPrecio()+avanzado.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera24.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva24 = new Reserva(pulsera24.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva24.getTotal(pulsera24.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva24.getTotal(pulsera24.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                            
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 5:
                                    System.out.println("El plan "+premium.getTipo()+":\n"+premium.getDetalles()+"\nPor un precio de $"+premium.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera251 = new Pulsera(ejecutivaDoble.getPrecio()+premium.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera251.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva251 = new Reserva(pulsera251.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva251.getTotal(pulsera251.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva251.getTotal(pulsera251.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera252 = new Pulsera(ejecutivaDoble.getPrecio()+premium.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera252.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva252 = new Reserva(pulsera252.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva252.getTotal(pulsera252.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva252.getTotal(pulsera252.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera253 = new Pulsera(ejecutivaDoble.getPrecio()+premium.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera253.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva253 = new Reserva(pulsera253.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva253.getTotal(pulsera253.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva253.getTotal(pulsera253.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera25 = new Pulsera(ejecutivaDoble.getPrecio()+premium.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera25.getTotal());
                                                if(pasajeros>ejecutivaDoble.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                                heD--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(heD<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva25 = new Reserva(pulsera25.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva25.getTotal(pulsera25.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = ejecutivaDoble.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva25.getTotal(pulsera25.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 6:
                                    Pulsera pulsera2 = new Pulsera(ejecutivaDoble.getPrecio());
                                    System.out.println("El total por noche es: $"+pulsera2.getTotal());
                                    if(pasajeros>ejecutivaDoble.getCapacidad()){
                                        System.out.println("Usted no cumple con los requisitos de capacidad");
                                    }
                                    else{
                                        try{
                                            File bd = new File("hotel/clientes.csv");
                                            Scanner lector = new Scanner(bd);
                                            boolean a = false;
                                            while(lector.hasNextLine()){
                                                String linea = lector.nextLine(); 
                                                String[] valor = linea.split(",");
                                                if(ejecutivaDoble.getTipo().equals(valor[3])){ 
                                                    heD--;
                                                }       
                                            }
                                            lector.close();
                                        }catch(FileNotFoundException e){
                                            System.out.println("ERROR: Archivo no encontrado!!!");
                                            e.printStackTrace();
                                        }
                                            if(heI<0){
                                                System.out.println("Lo sentimos no hay habitaciones disponibles");
                                            }
                                            else{
                                                System.out.println("Ingrese la cantidad de noches que desea: ");
                                                int noches = lectorr.nextInt();
                                                Reserva reserva2 = new Reserva(pulsera2.getTotal(), noches);
                                                try{
                                                    File bd = new File("hotel/clientes.csv");
                                                    Scanner lector = new Scanner(bd);
                                                    boolean a = false;
                                                    while(lector.hasNextLine()){
                                                        String linea = lector.nextLine(); 
                                                        String[] valor = linea.split(",");
                                                        if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                            System.out.println("Bienvenido denuevo");
                                                            System.out.print("El valor Total es: $"+reserva2.getTotal(pulsera2.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                            int opcion5= lector.nextInt(); 
                                                            switch(opcion5){
                                                                case 1:
                                                                    //valor[2] = cl.getPasajeros();
                                                                    valor[3] = ejecutivaDoble.getTipo();
                                                                    //valor[4] = noches;
                                                                    break;
                                                                case 2:
                                                                    break;
                                                            }
                                                            a = true;
                                                        }
                                                        if(lector.hasNextLine()==false){
                                                            if(a==false){
                                                                try{
                                                                    FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                    System.out.print("El valor Total es: $"+reserva2.getTotal(pulsera2.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                    int opcion5= lectorr.nextInt();
                                                                    switch(opcion5){
                                                                        case 1:
                                                                            escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+ejecutivaDoble.getTipo()+","+noches+"\n");
                                                            
                                                                            escritor.close();
                                                                            System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                            break;
                                                                        case 2:
                                                                            break;
                                                                    }
                                                                }catch(IOException e){
                                                                    System.out.println("Ocurrió un error en la escritura del archivo");
                                                                    e.printStackTrace();
                                                                }
                                                            }
                                                        }
                                                        
                                                    }
                                                    lector.close();
                                        
                                                }catch(FileNotFoundException e){
                                                    System.out.println("ERROR: Archivo no encontrado!!!");
                                                    e.printStackTrace();
                                                }
                                                lectorr.close(); 
                                            }
                                    }
                                    break;
                            }

                        }while(opcion3<0 || opcion3>7);
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Porfavor elejir una opcion valida: ");
                }
                }while(opcion2<0 || opcion2>3);
                break;
            case 3:
                System.out.println("La habitacion " +familiar.getTipo()+" cuenta con una capacidad de: "+ familiar.getCapacidad()+" personas\nCon un precio de: $"+ familiar.getPrecio()+"\n");
                System.out.println("Desea continuar? \n1.Si\n2.No\n");
                opcion2 = lectorr.nextInt();
                do{
                switch(opcion2){
                    case 1:
                        System.out.println("\n\nTambien contamos con los siguientes planes diarios estandar con menu al gusto del chef:\n1."+inicial.getTipo()+"\n2."+intermedio.getTipo()+"\n3."+completo.getTipo()+"\n4."+avanzado.getTipo()+"\n5."+premium.getTipo()+"\n6.No gracias\n");
                        int opcion3 = lectorr.nextInt();
                        do{
                            switch(opcion3){
                                case 1:
                                    System.out.println("El plan "+inicial.getTipo()+":\n"+inicial.getDetalles()+"\nPor un precio de $"+inicial.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    int opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera311 = new Pulsera(familiar.getPrecio()+inicial.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera311.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva311 = new Reserva(pulsera311.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva311.getTotal(pulsera311.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva311.getTotal(pulsera311.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera312 = new Pulsera(familiar.getPrecio()+inicial.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera312.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva312 = new Reserva(pulsera312.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva312.getTotal(pulsera312.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva312.getTotal(pulsera312.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera313 = new Pulsera(familiar.getPrecio()+inicial.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera313.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva313 = new Reserva(pulsera313.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva313.getTotal(pulsera313.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva313.getTotal(pulsera313.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera31 = new Pulsera(familiar.getPrecio()+inicial.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera31.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva31 = new Reserva(pulsera31.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva31.getTotal(pulsera31.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva31.getTotal(pulsera31.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 2:
                                    System.out.println("El plan "+intermedio.getTipo()+":\n"+intermedio.getDetalles()+"\nPor un precio de $"+intermedio.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera321 = new Pulsera(familiar.getPrecio()+intermedio.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera321.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva321 = new Reserva(pulsera321.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva321.getTotal(pulsera321.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva321.getTotal(pulsera321.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera322 = new Pulsera(familiar.getPrecio()+intermedio.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera322.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva322 = new Reserva(pulsera322.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva322.getTotal(pulsera322.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva322.getTotal(pulsera322.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera323 = new Pulsera(familiar.getPrecio()+intermedio.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera323.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva323 = new Reserva(pulsera323.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva323.getTotal(pulsera323.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva323.getTotal(pulsera323.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera32 = new Pulsera(familiar.getPrecio()+intermedio.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera32.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva32 = new Reserva(pulsera32.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva32.getTotal(pulsera32.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva32.getTotal(pulsera32.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 3:
                                    System.out.println("El plan "+completo.getTipo()+":\n"+completo.getDetalles()+"\nPor un precio de $"+completo.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera331 = new Pulsera(familiar.getPrecio()+completo.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera331.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva331 = new Reserva(pulsera331.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva331.getTotal(pulsera331.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva331.getTotal(pulsera331.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                
                                                break;
                                            case 2:
                                                Pulsera pulsera332 = new Pulsera(familiar.getPrecio()+completo.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera332.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva332 = new Reserva(pulsera332.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva332.getTotal(pulsera332.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva332.getTotal(pulsera332.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera333 = new Pulsera(familiar.getPrecio()+completo.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera333.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva333 = new Reserva(pulsera333.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva333.getTotal(pulsera333.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva333.getTotal(pulsera333.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera33 = new Pulsera(familiar.getPrecio()+completo.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera33.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva33 = new Reserva(pulsera33.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva33.getTotal(pulsera33.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva33.getTotal(pulsera33.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 4:
                                    System.out.println("El plan "+avanzado.getTipo()+":\n"+avanzado.getDetalles()+"\nPor un precio de $"+avanzado.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera341 = new Pulsera(familiar.getPrecio()+avanzado.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera341.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva341 = new Reserva(pulsera341.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva341.getTotal(pulsera341.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva341.getTotal(pulsera341.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera342 = new Pulsera(familiar.getPrecio()+avanzado.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera342.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva342 = new Reserva(pulsera342.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva342.getTotal(pulsera342.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva342.getTotal(pulsera342.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera343 = new Pulsera(familiar.getPrecio()+avanzado.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera343.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva343 = new Reserva(pulsera343.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva343.getTotal(pulsera343.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva343.getTotal(pulsera343.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera34 = new Pulsera(familiar.getPrecio()+avanzado.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera34.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva34 = new Reserva(pulsera34.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva34.getTotal(pulsera34.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva34.getTotal(pulsera34.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 5:
                                    System.out.println("El plan "+premium.getTipo()+":\n"+premium.getDetalles()+"\nPor un precio de $"+premium.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera351 = new Pulsera(familiar.getPrecio()+premium.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera351.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva351= new Reserva(pulsera351.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva351.getTotal(pulsera351.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva351.getTotal(pulsera351.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera352 = new Pulsera(familiar.getPrecio()+premium.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera352.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva352 = new Reserva(pulsera352.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva352.getTotal(pulsera352.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva352.getTotal(pulsera352.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera353 = new Pulsera(familiar.getPrecio()+premium.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera353.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva353 = new Reserva(pulsera353.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva353.getTotal(pulsera353.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva353.getTotal(pulsera353.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera35 = new Pulsera(familiar.getPrecio()+premium.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera35.getTotal());
                                                if(pasajeros>familiar.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(familiar.getTipo().equals(valor[3])){ 
                                                                hf--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hf<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva35 = new Reserva(pulsera35.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva35.getTotal(pulsera35.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = familiar.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva35.getTotal(pulsera35.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 6:
                                    Pulsera pulsera3 = new Pulsera(familiar.getPrecio());
                                    System.out.println("El total por noche es: $"+pulsera3.getTotal());
                                    if(pasajeros>familiar.getCapacidad()){
                                        System.out.println("Usted no cumple con los requisitos de capacidad");
                                    }
                                    else{
                                        try{
                                            File bd = new File("hotel/clientes.csv");
                                            Scanner lector = new Scanner(bd);
                                            boolean a = false;
                                            while(lector.hasNextLine()){
                                                String linea = lector.nextLine(); 
                                                String[] valor = linea.split(",");
                                                if(familiar.getTipo().equals(valor[3])){ 
                                                    hf--;
                                                }       
                                            }
                                            lector.close();
                                        }catch(FileNotFoundException e){
                                            System.out.println("ERROR: Archivo no encontrado!!!");
                                            e.printStackTrace();
                                        }
                                            if(hf<0){
                                                System.out.println("Lo sentimos no hay habitaciones disponibles");
                                            }
                                            else{
                                                System.out.println("Ingrese la cantidad de noches que desea: ");
                                                int noches = lectorr.nextInt();
                                                Reserva reserva3 = new Reserva(pulsera3.getTotal(), noches);
                                                try{
                                                    File bd = new File("hotel/clientes.csv");
                                                    Scanner lector = new Scanner(bd);
                                                    boolean a = false;
                                                    while(lector.hasNextLine()){
                                                        String linea = lector.nextLine(); 
                                                        String[] valor = linea.split(",");
                                                        if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                            System.out.println("Bienvenido denuevo");
                                                            System.out.print("El valor Total es: $"+reserva3.getTotal(pulsera3.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                            int opcion5= lector.nextInt(); 
                                                            switch(opcion5){
                                                                case 1:
                                                                    //valor[2] = cl.getPasajeros();
                                                                    valor[3] = familiar.getTipo();
                                                                    //valor[4] = noches;
                                                                    break;
                                                                case 2:
                                                                    break;
                                                            }
                                                            a = true;
                                                        }
                                                        if(lector.hasNextLine()==false){
                                                            if(a==false){
                                                                try{
                                                                    FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                    System.out.print("El valor Total es: $"+reserva3.getTotal(pulsera3.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                    int opcion5= lectorr.nextInt();
                                                                    switch(opcion5){
                                                                        case 1:
                                                                            escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+familiar.getTipo()+","+noches+"\n");
                                                            
                                                                            escritor.close();
                                                                            System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                            break;
                                                                        case 2:
                                                                            break;
                                                                    }
                                                                }catch(IOException e){
                                                                    System.out.println("Ocurrió un error en la escritura del archivo");
                                                                    e.printStackTrace();
                                                                }
                                                            }
                                                        }
                                                        
                                                    }
                                                    lector.close();
                                        
                                                }catch(FileNotFoundException e){
                                                    System.out.println("ERROR: Archivo no encontrado!!!");
                                                    e.printStackTrace();
                                                }
                                                lectorr.close(); 
                                            }
                                    }
                                    break;
                            }

                        }while(opcion3<0 || opcion3>7);
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Porfavor elejir una opcion valida: ");
                }
                }while(opcion2<0 || opcion2>3);
                break;
            case 4:
                System.out.println("La habitacion " +pentHouse.getTipo()+" cuenta con una capacidad de: "+ pentHouse.getCapacidad()+" personas\nCon un precio de: $"+ pentHouse.getPrecio()+"\n");
                System.out.println("Desea continuar? \n1.Si\n2.No\n");
                opcion2 = lectorr.nextInt();
                do{
                switch(opcion2){
                    case 1:
                        System.out.println("\n\nTambien contamos con los siguientes planes diarios estandar con menu al gusto del chef:\n1."+inicial.getTipo()+"\n2."+intermedio.getTipo()+"\n3."+completo.getTipo()+"\n4."+avanzado.getTipo()+"\n5."+premium.getTipo()+"\n6.No gracias\n");
                        int opcion3 = lectorr.nextInt();
                        do{
                            switch(opcion3){
                                case 1:
                                    System.out.println("El plan "+inicial.getTipo()+":\n"+inicial.getDetalles()+"\nPor un precio de $"+inicial.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    int opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera411 = new Pulsera(pentHouse.getPrecio()+inicial.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera411.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva411 = new Reserva(pulsera411.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva411.getTotal(pulsera411.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva411.getTotal(pulsera411.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera412 = new Pulsera(pentHouse.getPrecio()+inicial.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera412.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva412 = new Reserva(pulsera412.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva412.getTotal(pulsera412.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva412.getTotal(pulsera412.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera413 = new Pulsera(pentHouse.getPrecio()+inicial.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera413.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva413 = new Reserva(pulsera413.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva413.getTotal(pulsera413.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva413.getTotal(pulsera413.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera41 = new Pulsera(pentHouse.getPrecio()+inicial.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera41.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva41 = new Reserva(pulsera41.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva41.getTotal(pulsera41.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva41.getTotal(pulsera41.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 2:
                                    System.out.println("El plan "+intermedio.getTipo()+":\n"+intermedio.getDetalles()+"\nPor un precio de $"+intermedio.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera421 = new Pulsera(pentHouse.getPrecio()+intermedio.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera421.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva421 = new Reserva(pulsera421.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva421.getTotal(pulsera421.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva421.getTotal(pulsera421.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                
                                                break;
                                            case 2:
                                                Pulsera pulsera422 = new Pulsera(pentHouse.getPrecio()+intermedio.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera422.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva422 = new Reserva(pulsera422.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva422.getTotal(pulsera422.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva422.getTotal(pulsera422.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera423 = new Pulsera(pentHouse.getPrecio()+intermedio.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera423.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva423 = new Reserva(pulsera423.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva423.getTotal(pulsera423.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva423.getTotal(pulsera423.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera42 = new Pulsera(pentHouse.getPrecio()+intermedio.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera42.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva42 = new Reserva(pulsera42.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva42.getTotal(pulsera42.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva42.getTotal(pulsera42.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 3:
                                    System.out.println("El plan "+completo.getTipo()+":\n"+completo.getDetalles()+"\nPor un precio de $"+completo.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera431 = new Pulsera(pentHouse.getPrecio()+completo.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera431.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva431 = new Reserva(pulsera431.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva431.getTotal(pulsera431.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva431.getTotal(pulsera431.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera432 = new Pulsera(pentHouse.getPrecio()+completo.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera432.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva432 = new Reserva(pulsera432.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva432.getTotal(pulsera432.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva432.getTotal(pulsera432.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera433 = new Pulsera(pentHouse.getPrecio()+completo.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera433.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva433 = new Reserva(pulsera433.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva433.getTotal(pulsera433.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva433.getTotal(pulsera433.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera43 = new Pulsera(pentHouse.getPrecio()+completo.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera43.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva43 = new Reserva(pulsera43.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva43.getTotal(pulsera43.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva43.getTotal(pulsera43.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 4:
                                    System.out.println("El plan "+avanzado.getTipo()+":\n"+avanzado.getDetalles()+"\nPor un precio de $"+avanzado.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera441 = new Pulsera(pentHouse.getPrecio()+avanzado.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera441.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva441 = new Reserva(pulsera441.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lectorr.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva441.getTotal(pulsera441.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lector.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva441.getTotal(pulsera441.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera442 = new Pulsera(pentHouse.getPrecio()+avanzado.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera442.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva442 = new Reserva(pulsera442.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva442.getTotal(pulsera442.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva442.getTotal(pulsera442.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera443 = new Pulsera(pentHouse.getPrecio()+avanzado.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera443.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva443 = new Reserva(pulsera443.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva443.getTotal(pulsera443.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva443.getTotal(pulsera443.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera44 = new Pulsera(pentHouse.getPrecio()+avanzado.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera44.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva44 = new Reserva(pulsera44.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva44.getTotal(pulsera44.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva44.getTotal(pulsera44.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 5:
                                    System.out.println("El plan "+premium.getTipo()+":\n"+premium.getDetalles()+"\nPor un precio de $"+premium.getPrecio()+"\n");
                                    System.out.println("Tambien contamos con planes disponibles para pasajeros en preventa y bajo confirmacion del equipo de la agencia de Turismo, que permiten cubrir parte de los costos asociados a las excursiones.\n1."+light.getTipo()+"\n2."+plus.getTipo()+"\n3."+heavy.getTipo()+"\n4.No gracias\n");
                                    opcion4 = lectorr.nextInt();
                                    do{
                                        switch(opcion4){
                                            case 1:
                                                Pulsera pulsera451 = new Pulsera(pentHouse.getPrecio()+premium.getPrecio()+light.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera451.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva451 = new Reserva(pulsera451.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva451.getTotal(pulsera451.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva451.getTotal(pulsera451.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 2:
                                                Pulsera pulsera452 = new Pulsera(pentHouse.getPrecio()+premium.getPrecio()+plus.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera452.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva452 = new Reserva(pulsera452.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva452.getTotal(pulsera452.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva452.getTotal(pulsera452.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 3:
                                                Pulsera pulsera453 = new Pulsera(pentHouse.getPrecio()+premium.getPrecio()+heavy.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera453.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva453 = new Reserva(pulsera453.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva453.getTotal(pulsera453.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva453.getTotal(pulsera453.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                            case 4:
                                                Pulsera pulsera45 = new Pulsera(pentHouse.getPrecio()+premium.getPrecio());
                                                System.out.println("El total por noche es: $"+pulsera45.getTotal());
                                                if(pasajeros>pentHouse.getCapacidad()){
                                                    System.out.println("Usted no cumple con los requisitos de capacidad");
                                                }
                                                else{
                                                    try{
                                                        File bd = new File("hotel/clientes.csv");
                                                        Scanner lector = new Scanner(bd);
                                                        boolean a = false;
                                                        while(lector.hasNextLine()){
                                                            String linea = lector.nextLine(); 
                                                            String[] valor = linea.split(",");
                                                            if(pentHouse.getTipo().equals(valor[3])){ 
                                                                hpH--;
                                                            }       
                                                        }
                                                        lector.close();
                                                    }catch(FileNotFoundException e){
                                                        System.out.println("ERROR: Archivo no encontrado!!!");
                                                        e.printStackTrace();
                                                    }
                                                        if(hpH<0){
                                                            System.out.println("Lo sentimos no hay habitaciones disponibles");
                                                        }
                                                        else{
                                                            System.out.println("Ingrese la cantidad de noches que desea: ");
                                                            int noches = lectorr.nextInt();
                                                            Reserva reserva45 = new Reserva(pulsera45.getTotal(), noches);
                                                            try{
                                                                File bd = new File("hotel/clientes.csv");
                                                                Scanner lector = new Scanner(bd);
                                                                boolean a = false;
                                                                while(lector.hasNextLine()){
                                                                    String linea = lector.nextLine(); 
                                                                    String[] valor = linea.split(",");
                                                                    if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                                        System.out.println("Bienvenido denuevo");
                                                                        System.out.print("El valor Total es: $"+reserva45.getTotal(pulsera45.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                        int opcion5= lectorr.nextInt(); 
                                                                        switch(opcion5){
                                                                            case 1:
                                                                                //valor[2] = cl.getPasajeros();
                                                                                valor[3] = pentHouse.getTipo();
                                                                                //valor[4] = noches;
                                                                                break;
                                                                            case 2:
                                                                                break;
                                                                        }
                                                                        a = true;
                                                                    }
                                                                    if(lector.hasNextLine()==false){
                                                                        if(a==false){
                                                                            try{
                                                                                FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                                System.out.print("El valor Total es: $"+reserva45.getTotal(pulsera45.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                                int opcion5= lectorr.nextInt();
                                                                                switch(opcion5){
                                                                                    case 1:
                                                                                        escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                                        
                                                                                        escritor.close();
                                                                                        System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                                        break;
                                                                                    case 2:
                                                                                        break;
                                                                                }
                                                                            }catch(IOException e){
                                                                                System.out.println("Ocurrió un error en la escritura del archivo");
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                lector.close();
                                                    
                                                            }catch(FileNotFoundException e){
                                                                System.out.println("ERROR: Archivo no encontrado!!!");
                                                                e.printStackTrace();
                                                            }
                                                            lectorr.close(); 
                                                        }
                                                }
                                                break;
                                        }

                                    }while(opcion4<0 || opcion4>4);
                                    break;
                                case 6:
                                    Pulsera pulsera4 = new Pulsera(pentHouse.getPrecio());
                                    System.out.println("El total por noche es: $"+pulsera4.getTotal());
                                    if(pasajeros>pentHouse.getCapacidad()){
                                        System.out.println("Usted no cumple con los requisitos de capacidad");
                                    }
                                    else{
                                        try{
                                            File bd = new File("hotel/clientes.csv");
                                            Scanner lector = new Scanner(bd);
                                            boolean a = false;
                                            while(lector.hasNextLine()){
                                                String linea = lector.nextLine(); 
                                                String[] valor = linea.split(",");
                                                if(pentHouse.getTipo().equals(valor[3])){ 
                                                    hpH--;
                                                }       
                                            }
                                            lector.close();
                                        }catch(FileNotFoundException e){
                                            System.out.println("ERROR: Archivo no encontrado!!!");
                                            e.printStackTrace();
                                        }
                                            if(hpH<0){
                                                System.out.println("Lo sentimos no hay habitaciones disponibles");
                                            }
                                            else{
                                                System.out.println("Ingrese la cantidad de noches que desea: ");
                                                int noches = lectorr.nextInt();
                                                Reserva reserva4 = new Reserva(pulsera4.getTotal(), noches);
                                                try{
                                                    File bd = new File("hotel/clientes.csv");
                                                    Scanner lector = new Scanner(bd);
                                                    boolean a = false;
                                                    while(lector.hasNextLine()){
                                                        String linea = lector.nextLine(); 
                                                        String[] valor = linea.split(",");
                                                        if(nombre.equals(valor[0]) && rut.equals(valor[1])){
                                                            System.out.println("Bienvenido denuevo");
                                                            System.out.print("El valor Total es: $"+reserva4.getTotal(pulsera4.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                            int opcion5= lector.nextInt(); 
                                                            switch(opcion5){
                                                                case 1:
                                                                    //valor[2] = cl.getPasajeros();
                                                                    valor[3] = pentHouse.getTipo();
                                                                    //valor[4] = noches;
                                                                    break;
                                                                case 2:
                                                                    break;
                                                            }
                                                            a = true;
                                                        }
                                                        if(lector.hasNextLine()==false){
                                                            if(a==false){
                                                                try{
                                                                    FileWriter escritor = new FileWriter("hotel/clientes.csv",true);
                                                                    System.out.print("El valor Total es: $"+reserva4.getTotal(pulsera4.getTotal(), noches)+"\n Desea continuar?\n1.si\n2.no");
                                                                    int opcion5= lectorr.nextInt();
                                                                    switch(opcion5){
                                                                        case 1:
                                                                            escritor.append(cl.getNombre()+","+cl.getRut()+","+cl.getPasajeros()+","+pentHouse.getTipo()+","+noches+"\n");
                                                            
                                                                            escritor.close();
                                                                            System.out.println("La escritura del archivo fue realizada con exito!!!");
                                                                            break;
                                                                        case 2:
                                                                            break;
                                                                    }
                                                                }catch(IOException e){
                                                                    System.out.println("Ocurrió un error en la escritura del archivo");
                                                                    e.printStackTrace();
                                                                }
                                                            }
                                                        }
                                                        
                                                    }
                                                    lector.close();
                                        
                                                }catch(FileNotFoundException e){
                                                    System.out.println("ERROR: Archivo no encontrado!!!");
                                                    e.printStackTrace();
                                                }
                                                lectorr.close(); 
                                            }
                                    }
                                    
                                    break;
                            }

                        }while(opcion3<0 || opcion3>7);
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Porfavor elejir una opcion valida: ");
                }
                }while(opcion2<0 || opcion2>3);
                break;
            case 5:
                break;
            default:
                System.out.println("Porfavor elejir una opcion valida: ");
            

        }
        }while(opcion<-1 || opcion>6);    
    }
}