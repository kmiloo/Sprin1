public class Hotel(){
	private String descanso;
	private String instalaciones;
	private String calificacion;
}

public class Persona(){
	private String nombre;
	private int edad;
	private float rut;
}

public class Cliente extends Persona(){
	private var dinero;

	public void pagar(){
	}
	public void solicitarMenu(){
	}
	public void solicitarExcursion(){
	}
	public void comer(){
	}
	public void reservar(){
	}
}

public class Trabajador extends Persona(){
	private String horarios;
	private String garzon;
	private String mucama;
	private String guia;
	private String recepcionista;

	public void horarios(){
	}
	public void trabajar(){
	}
	public void servir(){
	}
	public void ordenar(){
	}
	public void excursionar(){
	}
	public void recepcionar(){
	}

}
public class Pulsera(){
	private String color;

	public void verificarPlanes(){
	}
	public void guardarDatos(){
	}
	public void estadiaFrecuente(){
	}
	public void totalPagar(){
	}
}

public class Recepcion(){
	public void cobrar(){
	}
	public void recepcionar(){
	}
}

public class PaginaWeb(){
	public void reservas(){
	}
}

public class MenuRestaurant(){
	private var inicial;
	private var intermedio;
	private var completo;
	private var avanzado;
	private var premium;

	public void inicial(){
		inicial = "Incluye un plato principal de una comida (almuerzo o cena) del menu diario a gusto del chef.\nPrecio:$10.000";
	}
	public void intermedio(){
		intermedio = "Incluye una comida (almuerzo y cena) de tres tiempos (entrada,fondo y postre) del menu diario a gusto del chef.\nPrecio:$25.000";
	}
	public void completo(){
		completo = "Incluye dos comidas,almuerzo y cena, de tres tiempos (entrada,fondo y postre) del menu dario a gusto del chef.\nPrecio:45.000";
	}
	public void avanzado(){
		avanzado = "Incluye dos comidas, almuerzo y cena de tres tiempos (entrada,fondo y postre) del menu abierto de especialidad del chef.\nPrecio:$60.000";
	}
	public void premium(){
		premium = "Incluye tiempo de chef dedicado a todo momento para satisfacer los gustos exclusivos y peticione especificas de los pasajeros para una cantidad no determinada de comidas al dia.\nPrecio:$100.000";
	}
}

public class Excursion(){
	private var light;
	private var plus;
	private var heavy;

	public void light(){
		light = "Es una caminata de 6 horas por senderos de complejidad baja con hermosos lugares de vegetacion nativa y afluentes de agua, ideal para grupos familiares con nios o personas de 3ra edad (incluvise para personas con dificultades motrices).\nPrecio:$5.000";
	}
	public void plus(){
		plus = "Es una excursion de tipo hiking de 3 dias en total por una cadena montañosa,experiencias de campamento y contemplacion de glaciares y cascadas, ideal para grupos de personas con capacidades fisicas compatibles con la exigencia de la caminata.\nPrecio:$25.000";
	}
	public void heavy(){
		heavy = "Es una excursion de tipo hiking de 5 dias en total por una cadena montañosa y con navegacion en afluentes locales. Se incluyen actividades extremas de Rapel,Canopi,Rafting y Escalada. Las actividades requieren de capacidades fisicas compatibles con la complejidad de la excursion.\nPrecio:$50.000";
	}
}

public class Habitacion(){
	private var individuales;//10
	private var dobles;//10
	private var familiares;//10
	private var penthouse;//2
	private var minibar;

	public void individuales(){
		individuales = "Decripcion: HACERLA Precio: $50.000";
	}
	public void dobles(){
		dobles = "Descripcion: HACERLAPrecio : $80.000";
	public void familiar(){
		familiar = "Tiene dos habitaciones interiores (una con cama matrimonial y otra con dos camarotes dobles),ademas de una sala de estar con balcon.\nPrecio:$150.000";
	}
	public void penthouse(){
		penthouse = "Cuenta con terraza al aire libre, habitacion principal y habitacion de invitados, tambien cuentan con vista hacia la bahia de Puerto Montt.\nPrecio:$1.080.000";
	}
	public void minibar(){
		//precios aparte
	}
}