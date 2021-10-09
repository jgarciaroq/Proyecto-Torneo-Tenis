
   /**
 * Clase que carga los datos con los que simular un campeonato de tenis
 * 
 * @author 
 * @version 1.0
 */
public class InitTennisData {

    public InitTennisData(Campeonato campeonato) {
	//Descomentar la carga de datos que se quiera probar
        cargarDatos1(campeonato);//Produce la salida Salida1_EC1
		//cargarDatos2(campeonato);/Produce la salida Salida2_EC1
        
    }
    
    private void cargarDatos1(Campeonato campeonato) {
		//Instanciamos 8 zapatillas: (Los parámetros están en el orden: modelo, número, tipo valor)
		 Zapatillas z1 = new Zapatillas("Air Zoom Vapor Pro", 41, "amortiguacion", 5);
		 Zapatillas z2 = new Zapatillas("Court Vapor React", 41, "agarre", 5);
		 Zapatillas z3 = new Zapatillas("Gel-Resolution 8 GS", 41, "agarre", 4);
		 Zapatillas z4 = new Zapatillas("Vapor Lite", 41, "amortiguacion", 3);
		 Zapatillas z5 = new Zapatillas("Court Lite", 41, "agarre", 3);
		 Zapatillas z6 = new Zapatillas("UberSonic 4K", 41, "amortiguacion", 5.5);
		 Zapatillas z7 = new Zapatillas("Zoom GP Turbo", 41, "amortiguacion", 6);
		 Zapatillas z8 = new Zapatillas("CourtJam Bounce", 41, "agarre", 3.5);



		//Instanciamos 8 tenistas: (Los parámetros están en el orden nombre, zapatillas, saque, resto, ranking, pais)
		 Tenista t1 = new Tenista("Novak Djokovic", z1, 90, 80, 1, "Serbia");
		 Tenista t2 = new Tenista("Ashleigh Barty", z3, 70, 80, 1, "Australia");
		 Tenista t3 = new Tenista("Stefanos Tsitsipas", z7, 55, 48, 3, "Grecia");
		 Tenista t4 = new Tenista("Karolina Pliskova", z5, 67, 68.5, 3, "Rep Checa");
		 Tenista t5 = new Tenista("Elina Svitolina", z6, 55.5, 68.5, 4, "Ucrania"); //El saque es 55.5 pero da error 
		 Tenista t6 = new Tenista("Alexander Zverev", z8, 59, 49.5, 4, "Alemania");
		 Tenista t7 = new Tenista("Aryna Sabalenka", z2, 67.5, 79.5, 2, "Bielorrusia");//El saque es 67.5 pero da error
		 Tenista t8 = new Tenista("Daniil Medvedev", z4, 79, 68, 2, "Rusia");
		 
		 //A continuación se inscribirán a los 8 tenistas en el campeonato
		 campeonato.inscripcion(t1);
		 campeonato.inscripcion(t2);
		 campeonato.inscripcion(t3);
		 campeonato.inscripcion(t4);
		 campeonato.inscripcion(t5);
		 campeonato.inscripcion(t6);
		 campeonato.inscripcion(t7);
		 campeonato.inscripcion(t8);
    }
/*	
	private void cargarDatos2(Campeonato campeonato) {
        //Instanciamos 8 zapatillas: (Los parámetros están en el orden: modelo, número, tipo valor)
		Zapatillas z1 = new Zapatillas("Air Zoom Vapor Pro", 41, "amortiguacion", 5);
		Zapatillas z2 = new Zapatillas("Court Vapor React", 41, "agarre", 5);
		Zapatillas z3 = new Zapatillas("Gel-Resolution 8 GS", 41, "agarre", 4);
		Zapatillas z4 = new Zapatillas("Vapor Lite", 41, "amortiguacion", 3);
		Zapatillas z5 = new Zapatillas("Court Lite", 41, "agarre", 3);
		Zapatillas z6 = new Zapatillas("UberSonic 4K", 41, "amortiguacion", 5.5);
		Zapatillas z7 = new Zapatillas("Zoom GP Turbo", 41, "amortiguacion", 6);
		Zapatillas z8 = new Zapatillas("CourtJam Bounce", 41, "agarre", 3.5);



		//Instanciamos 8 tenistas: (Los parámetros están en el orden nombre, zapatillas, saque, resto, ranking, pais)
		Tenista t1 = new Tenista("Novak Djokovic", z3, 90, 80, 1, "Serbia");
		Tenista t2 = new Tenista("Ashleigh Barty", z1, 70, 80, 1, "Australia");
		Tenista t3 = new Tenista("Stefanos Tsitsipas", z7, 55, 48, 3, "Grecia");
		Tenista t4 = new Tenista("Karolina Pliskova", z5, 67, 68.5, 3, "Rep Checa");
		Tenista t5 = new Tenista("Elina Svitolina", z6, 55.5, 68.5, 4, "Ucrania");
		Tenista t6 = new Tenista("Alexander Zverev", z8, 59, 49.5, 4, "Alemania");
		Tenista t7 = new Tenista("Aryna Sabalenka", z2, 67.5, 79.5, 2, "Bielorrusia");
		Tenista t8 = new Tenista("Daniil Medvedev", z4, 79, 68, 2, "Rusia");
 
		//A continuación se inscribirán a los 8 tenistas en el campeonato
    }
}
    */
    
}
