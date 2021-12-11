
/**
 * Clase que carga los datos con los que simular un campeonato de tenis.
 * 
 * @author Antonio Javier Hidalgo
 * @author Juan Francisco García
 * @author David Bonilla
 * @version 13-11-2021
 */

/**
 * Clase que carga los datos con los que simular un campeonato de tenis
 * 
 * @author Equipo Docente DP 
 * @version 3.0
 */
public class InitTennisData {

    public InitTennisData(Campeonato campeonato) {
	//Descomentar la carga de datos que se quiera probar
        cargarDatos1(campeonato);//Produce la salida Salida1_EC3
	//cargarDatos2(campeonato);/Produce la salida Salida2_EC3
        
    }
    
    private void cargarDatos1(Campeonato campeonato) {
		//Instanciamos 8 zapatillas: (Los parámetros están en el orden: tipo, modelo, número y valor)
		ZapatillaGenerica z1 = new ZapatillasAmortiguadas("Air Zoom Vapor Pro", 42,  5);
		ZapatillaGenerica z2 = new ZapatillasConAgarre("Court Vapor React", 40,  5);
        	ZapatillaGenerica z3 = new ZapatillasConAgarre("Gel-Resolution 8 GS", 40,  4);
        	ZapatillaGenerica z4 = new ZapatillasAmortiguadas("Vapor Lite", 42,  3);
        	ZapatillaGenerica z5 = new ZapatillasConAgarre("Court Lite", 39, 3);
        	ZapatillaGenerica z6 = new ZapatillasAmortiguadas("UberSonic 4K", 40, 6);
        	ZapatillaGenerica z7 = new ZapatillasAmortiguadas("Zoom GP Turbo", 43, 3.5);
        	ZapatillaGenerica z8 = new ZapatillasConAgarre("CourtJam Bounce", 42, 3.5);


		//Instanciamos 8 tenistas: (Los parámetros están en el orden nombre, zapatillas, saque, resto, ranking, pais y número de pie)
		//Novedad en EC3: cada tenista es de tipo "Golpeadores" o de tipo "Voleadores"
		Tenista t1 = new Golpeadores ("Novak Djokovic", z1, 90, 80, 1, "Serbia", 42);
	    	Tenista t2 = new Golpeadores ("Ashleigh Barty", z2, 70, 80, 1, "Australia", 40);
	    	Tenista t3 = new Voleadores ("Stefanos Tsitsipas", z7, 55, 48, 3, "Grecia", 43);
	    	Tenista t4 = new Voleadores ("Karolina Pliskova", z5, 67, 68.5, 3, "Rep Checa", 39);
	    	Tenista t5 = new Golpeadores ("Elina Svitolina", z6, 55.5, 68.5, 4, "Ucrania", 40);
	    	Tenista t6 = new Golpeadores ("Alexander Zverev", z8, 59, 49.5, 4, "Alemania", 42);
	    	Tenista t7 = new Voleadores ("Aryna Sabalenka", z3, 67.5, 79.5, 2, "Bielorrusia", 40);
	    	Tenista t8 = new Voleadores ("Daniil Medvedev", z4, 79, 68, 2, "Rusia", 42);
		 
		 //A continuación se inscribirán a los 8 tenistas en el campeonato
		 
		t1.realizarInscripcion();
		t2.realizarInscripcion();
                t3.realizarInscripcion();
                t4.realizarInscripcion();
                t5.realizarInscripcion();
                t6.realizarInscripcion();
                t7.realizarInscripcion();
                t8.realizarInscripcion();
                
		//Instanciamos zapatillas para ser usadas en el campeonato: 
		//(Los parámetros están en el orden: tipo, modelo, número y valor)
	  	ZapatillaGenerica z9 = new ZapatillasAmortiguadas("Lotto Space", 40,  5);
	    	ZapatillaGenerica z10 = new ZapatillasAmortiguadas("K-Swiss Express", 42,  3);
	    	ZapatillaGenerica z11 = new ZapatillasAmortiguadas("Babolat Jet Tere", 42, 5.5);
	    	ZapatillaGenerica z12 = new ZapatillasAmortiguadas("Lotto Mirage", 40, 6);
	   	ZapatillaGenerica z13 = new ZapatillasAmortiguadas("K-Swiss Hypercourt", 40,  5);
	    	ZapatillaGenerica z14 = new ZapatillasAmortiguadas("Wilson Rush", 42,  3.5);
	    	ZapatillaGenerica z15 = new ZapatillasAmortiguadas("Head Revolt", 40,  5);
	    	ZapatillaGenerica z16 = new ZapatillasConAgarre("Joma Slam", 40, 3);
	    	ZapatillaGenerica z17 = new ZapatillasConAgarre("Adidas Gamecourt", 40,  5);
	    	ZapatillaGenerica z18 = new ZapatillasConAgarre("Asics Gel-Game", 42,  4.5);
	    	ZapatillaGenerica z19 = new ZapatillasConAgarre("Asics Solution", 42, 3);
	    	ZapatillaGenerica z20 = new ZapatillasConAgarre("Nike Air Zoom", 40,  5);
	    	ZapatillaGenerica z21 = new ZapatillasConAgarre("Nike Zoom Vapor", 42,  4);
	    	ZapatillaGenerica z22 = new ZapatillasConAgarre("Wilson Kaos", 41,  5);
	    	ZapatillaGenerica z23 = new ZapatillasConAgarre("Head Revolt Pro", 42,  4.5);
	
	    	campeonato.añadirZapatilla(z9);
	    	campeonato.añadirZapatilla(z10);
	    	campeonato.añadirZapatilla(z11);
	    	campeonato.añadirZapatilla(z12);
	    	campeonato.añadirZapatilla(z13);
	    	campeonato.añadirZapatilla(z14);
	    	campeonato.añadirZapatilla(z15);
	    	campeonato.añadirZapatilla(z16);
	    	campeonato.añadirZapatilla(z17);
	    	campeonato.añadirZapatilla(z18);
	    	campeonato.añadirZapatilla(z19);
	    	campeonato.añadirZapatilla(z20);
	    	campeonato.añadirZapatilla(z21);
	    	campeonato.añadirZapatilla(z22);
	    	campeonato.añadirZapatilla(z23);
	    	
	
		//Instanciamos raquetas para ser usadas en el campeonato: 
		//(Los parámetros están en el orden: Modelo, peso, longitud, tamaño de cabeza, tipo de encordado)
		//Además en el caso de raquetas equilibradas también se indican al final los valores potencia y control
		RaquetaGenerica r1 =  new RaquetaPotente("Head Radical", 260, 680, 680,Encordado.ABIERTO);
	    	RaquetaGenerica r2 =  new RaquetaPotente("Wilson Blade", 260, 690, 680, Encordado.ABIERTO);
	    	RaquetaGenerica r3 =  new RaquetaPotente("Dunlop CX200", 300, 700, 630, Encordado.ABIERTO);
	    	RaquetaGenerica r4 =  new RaquetaPotente("Yonex Vcore", 300, 680, 650, Encordado.CERRADO);
	    	RaquetaGenerica r5 =  new RaquetaControlada("Babolat Drive", 340, 740, 600, Encordado.CERRADO);
	    	RaquetaGenerica r6 =  new RaquetaControlada("Pure Aero", 340, 680, 720, Encordado.CERRADO);
	    	RaquetaGenerica r7 =  new RaquetaControlada("TFlash 300", 300, 680, 680, Encordado.CERRADO);
	    	RaquetaGenerica r8 =  new RaquetaControlada("Wilson Silver", 220, 690, 650, Encordado.ABIERTO);
	    	RaquetaGenerica r9 =  new RaquetaEquilibrada("Prince Hornet 100", 220, 690, 600, Encordado.CERRADO, 2.5, 4);
	    	RaquetaGenerica r10 =  new RaquetaEquilibrada("Head Graphene", 320, 690, 630, Encordado.ABIERTO, 6, 2);
	    	RaquetaGenerica r11 =  new RaquetaEquilibrada("Prince TT Bandit", 220, 680, 680, Encordado.CERRADO, 6, 3);
	    	RaquetaGenerica r12 =  new RaquetaEquilibrada("Class 100L", 320, 680, 720, Encordado.ABIERTO, 8, 1);
	    	
	    	
	    	 //Novedad en EC3: Las siguientes raquetas son nuevas para EC3
        	RaquetaGenerica r14 = new RaquetaPotente("Wilson Energy XL", 260, 690, 680, Encordado.ABIERTO);
        	RaquetaGenerica r15 = new RaquetaPotente("Wilson Pro Open", 340, 740, 720, Encordado.ABIERTO);
        	RaquetaGenerica r16 = new RaquetaPotente("Babolat Boost Drive", 220, 680,600, Encordado.CERRADO);
        	RaquetaGenerica r17 = new RaquetaPotente("Babolat Pure Drive", 260, 720, 600, Encordado.CERRADO);
        	RaquetaGenerica r18 = new RaquetaControlada("Prince Force Ti OS", 340, 740, 600, Encordado.CERRADO);
        	RaquetaGenerica r19 = new RaquetaControlada("Head Prestige Pro", 340, 740, 720, Encordado.ABIERTO);
        	RaquetaGenerica r20 = new RaquetaControlada("Head Instinct", 220, 680,600, Encordado.ABIERTO);
        	RaquetaGenerica r21 = new RaquetaControlada("Dunlop Nitro", 340, 720, 600, Encordado.CERRADO);
        	RaquetaGenerica r22 = new RaquetaEquilibrada("Prince Force", 320, 690, 630, Encordado.ABIERTO, 6, 2);
        	RaquetaGenerica r23 = new RaquetaEquilibrada("Prince Warrior", 340, 740, 720, Encordado.ABIERTO, 6, 2);
        	RaquetaGenerica r24 = new RaquetaEquilibrada("Wilson Pro Staff", 220, 680, 600, Encordado.CERRADO, 2.5, 4);
        	
        	
        	
        	campeonato.añadirRaquetas(r1);
        	campeonato.añadirRaquetas(r2);
        	campeonato.añadirRaquetas(r3);
        	campeonato.añadirRaquetas(r4);
        	campeonato.añadirRaquetas(r5);
        	campeonato.añadirRaquetas(r6);
        	campeonato.añadirRaquetas(r7);
        	campeonato.añadirRaquetas(r8);
        	campeonato.añadirRaquetas(r9);
        	campeonato.añadirRaquetas(r10);
        	campeonato.añadirRaquetas(r11);
        	campeonato.añadirRaquetas(r12);
        	campeonato.añadirRaquetas(r14);
        	campeonato.añadirRaquetas(r15);
        	campeonato.añadirRaquetas(r16);
        	campeonato.añadirRaquetas(r17);
        	campeonato.añadirRaquetas(r18);
        	campeonato.añadirRaquetas(r19);
        	campeonato.añadirRaquetas(r20);
        	campeonato.añadirRaquetas(r21);
        	campeonato.añadirRaquetas(r22);
        	campeonato.añadirRaquetas(r23);
        	campeonato.añadirRaquetas(r24);
        
    }
	
/*	private void cargarDatos2(Campeonato campeonato) {
	        //Instanciamos 8 zapatillas: (Los parámetros están en el orden: modelo, número, tipo valor)
         	z1 =  ZapatillasAmortiguadas("Air Zoom Vapor Pro", 42,  5);
	        z2 =  ZapatillasConAgarre("Court Vapor React", 40,  5);
	        z3 =  ZapatillasConAgarre("Gel-Resolution 8 GS", 40,  4);
	        z4 =  ZapatillasAmortiguadas("Vapor Lite", 42,  3);
	        z5 =  ZapatillasConAgarre("Court Lite", 39, 3);
	        z6 =  ZapatillasAmortiguadas("UberSonic 4K", 40, 5.5);
	        z7 =  ZapatillasAmortiguadas("Zoom GP Turbo", 43, 7);
	        z8 =  ZapatillasConAgarre("CourtJam Bounce", 42, 3.5);

		//Instanciamos 8 tenistas: (Los parámetros están en el orden nombre, zapatillas, saque, resto, ranking, pais)
		//Novedad en EC3: cada tenista es de tipo "Golpeadores" o de tipo "Voleadores"
	        t1 = Golpeadores ("Novak Djokovic", z1, 90, 80, 1, "Serbia", 42);
		t2 = Golpeadores ("Ashleigh Barty", z6, 70, 80, 1, "Australia", 40);
	        t3 = Golpeadores ("Stefanos Tsitsipas", z7, 55, 48, 3, "Grecia", 43);
	        t4 = Golpeadores ("Karolina Pliskova", z5, 67, 68.5, 3, "Rep Checa", 39);
	        t5 = Voleadores ("Elina Svitolina", z3, 55.5, 68.5, 4, "Ucrania", 40);
	        t6 = Voleadores ("Alexander Zverev", z8, 59, 49.5, 4, "Alemania", 42);
	        t7 = Voleadores ("Aryna Sabalenka", z2, 67.5, 79.5, 2, "Bielorrusia", 40);
	        t8 = Voleadores ("Daniil Medvedev", z4, 79, 68, 2, "Rusia", 42);

		//A continuación se inscribirán a los 8 tenistas en el campeonato
 		//Instanciamos zapatillas para ser usadas en el campeonato: 
		//(Los parámetros están en el orden: tipo, modelo, número y valor)
		z9 = ZapatillasAmortiguadas("Lotto Space", 40,  5);
        	z10 = ZapatillasConAgarre("Adidas Gamecourt", 40,  5);
	        z11 = ZapatillasConAgarre("Asics Gel-Game", 42,  4.5);
	        z12 = ZapatillasAmortiguadas("K-Swiss Express", 42,  3);
	        z13 = ZapatillasConAgarre("Joma Slam", 40, 3);
	        z14 = ZapatillasAmortiguadas("Babolat Jet Tere", 42, 5.5);
	        z15 = ZapatillasConAgarre("Asics Solution", 42, 3);
	        z16 = ZapatillasAmortiguadas("K-Swiss Hypercourt", 40,  5);
	        z17 = ZapatillasConAgarre("Nike Air Zoom", 40,  5);
	        z18 = ZapatillasConAgarre("Nike Zoom Vapor", 42,  4);
	        z19 = ZapatillasAmortiguadas("Wilson Rush", 42,  3.5);
	        z20 = ZapatillasAmortiguadas("Head Revolt", 40,  3);
	        z21 = ZapatillasAmortiguadas("Lotto Mirage", 40, 6);
	        z22 = ZapatillasConAgarre("Wilson Kaos", 41,  5);
	        z23 = ZapatillasConAgarre("Head Revolt Pro", 42,  4.5);
	
		//Instanciamos raquetas para ser usadas en el campeonato: 
		//(Los parámetros están en el orden: Modelo, peso, longitud, tamaño de cabeza, tipo de encordado)
		//Además en el caso de raquetas equilibradas también se indican al final los valores potencia y control
		r1 = RaquetaPotente("Head Radical", 260, 680, 680,Encordado.ABIERTO);
	        r2 = RaquetaPotente("Wilson Blade", 260, 690, 680, Encordado.ABIERTO);
	        r3 = RaquetaPotente("Dunlop CX200", 300, 700, 630, Encordado.ABIERTO);
	        r4 = RaquetaPotente("Yonex Vcore", 300, 680, 650, Encordado.CERRADO);
	        r5 = RaquetaControlada("Babolat Drive", 340, 740, 600, Encordado.CERRADO);
	        r6 = RaquetaControlada("Pure Aero", 340, 680, 720, Encordado.CERRADO);
	        r7 = RaquetaControlada("TFlash 300", 300, 680, 680, Encordado.CERRADO);
	        r8 = RaquetaControlada("Wilson Silver", 220, 690, 650, Encordado.ABIERTO);
	        r9 = RaquetaEquilibrada("Prince Hornet 100", 220, 690, 600, Encordado.CERRADO, 2.5, 4);
	        r10 = RaquetaEquilibrada("Head Graphene", 320, 690, 630, Encordado.ABIERTO, 6, 2);
	        r11 = RaquetaEquilibrada("Prince TT Bandit", 220, 680, 680, Encordado.CERRADO, 6, 3);
	        r12 = RaquetaEquilibrada("Class 100L", 320, 680, 720, Encordado.ABIERTO, 8, 1);

	    	 //Novedad en EC3: Las siguientes raquetas son nuevas para EC3
        	r13 = RaquetaPotente("Wilson Energy XL", 260, 690, 680, Encordado.ABIERTO);
        	r14 = RaquetaPotente("Wilson Pro Open", 340, 740, 720, Encordado.ABIERTO);
        	r15 = RaquetaPotente("Babolat Boost Drive", 220, 680,600, Encordado.CERRADO);
        	r16 = RaquetaPotente("Babolat Pure Drive", 260, 720, 600, Encordado.CERRADO);
    }*/
   }


