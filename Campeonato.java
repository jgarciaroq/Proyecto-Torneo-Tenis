import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.IOException;

/**
 * La clase Campeonato representa el torneo que se va a disputar entre los distintos 
 * tenistas que participan.
 * 
 * @author Antonio Javier Hidalgo
 * @author Juan Francisco García
 * @author David Bonilla
 * @version 21-12-2021
 * 
 */

public class Campeonato extends Comunicacion
{
    private String nombre;
    private ArrayList <Tenista> competidores;
    private ArrayList <Tenista> eliminados;
    private ArrayList <Zapatilla> zapatillasCampeonato;
    private TreeSet <Raqueta> raquetasCampeonato;
    private static Campeonato singletonCampeonato;
    private FileWriter writer;
    
    /**
     * Constructor parametrizado de la clase Campeonato
     * Crea un nuevo objeto de la clase Campeonato 
     */ 
    private Campeonato(String nombre)
    {
        this.nombre = nombre;
        competidores = new ArrayList <Tenista>();
        eliminados = new ArrayList <Tenista>();
        zapatillasCampeonato = new ArrayList <Zapatilla>();
        raquetasCampeonato = new TreeSet <Raqueta> (new PotenciaComparator());
        try{
            writer = new FileWriter("salida.txt");
        }
        catch(IOException e)
        {
            System.err.println("Hubo un error abriendo en el fichero");
        }
    }
    
    /**
     * Método que impide crear mas de un campeonato con el mismo nombre 
     * @param nombre nombre del campeonato
     */
    public static synchronized Campeonato getInstance(String nombre)
    {
        if(singletonCampeonato == null){
            singletonCampeonato = new Campeonato(nombre);
        }
        return singletonCampeonato;
    }
    
    /**
     * Método que inscribe a un Tenista al campeonato, añadiendolo a la lista de competidores
     * @param t1 un tenista
     */
    public synchronized void inscripcionCompetidores (Tenista t1)
    {
        competidores.add(t1);
    }
    
    /**
     * Método que añade una zapatilla a la lista zapatillas
     * @param z1 una zapatilla
     */
    public synchronized void añadirZapatilla (Zapatilla z1)
    {
        zapatillasCampeonato.add(z1);
    }
    
    /**
     * Método que añade una raqueta al arbol de raquetas
     * @param una raqueta
     */
    public synchronized void añadirRaquetas (Raqueta r1)
    {
        raquetasCampeonato.add(r1);
    }
    
    public synchronized void añadirSubscriptor(MedioGenerico medio){
        añadirMedio(medio);
    }
    
     /**
     * Metodo encargado de asignar las raquetas a los competidores
     * @return verdadero si se ha asignado una raqueta y falso en caso contrario
     */
    public synchronized boolean asignarRaquetas (){
        boolean bandera=false;
        escribirFicheroPantalla("***** Asignando raquetas a tenistas *****");
        if (raquetasCampeonato.size()>=competidores.size()){
            bandera=true;
                for (int i = 0; i<competidores.size(); i++){
                        Tenista t = competidores.get(i);
                        t.setRaqueta(raquetasCampeonato.first());
                        raquetasCampeonato.remove(raquetasCampeonato.first());
                }
            }
        
        return bandera;
    }
    
    /**
     * Método que muestra por pantalla el avance de los partidos, las rondas, 
     * quién ha ganado y el listado de eliminados
     */
    public synchronized void controlDeCampeonato() throws ExcepcionRaquetas
    {
        escribirFicheroPantalla("***** Inicio del campeonato: "+nombre+" *****\n");
        if (asignarRaquetas()){
            mostrarRaquetas();
            int i = 1;
            escribirFicheroPantalla("***** Listado de competidores: ");
            listaTenistas_competidores();
            escribirFicheroPantalla("***** Listado de raquetas disponibles: ");
            raquetasDisponibles();
            while(competidores.size() != 1){
               escribirFicheroPantalla("\n"); 
               escribirFicheroPantalla("***** Ronda---->>>: "+i);
               partidos(i);
               i++;
            }
            
            Tenista ganador = competidores.get(0);
            mostrarganadorTorneo(ganador);
            escribirFicheroPantalla("***** Listado de eliminados: ");
            Collections.sort(eliminados, Collections.reverseOrder(new PosicionComparator()));
            listaTenistas_eliminados();
            try
            {
                writer.close();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        else{
            throw new ExcepcionRaquetas(); //Excepcion que salta cuando hay más jugadores 
                                           //que raquetas          
        } 
    }
    
    /**
     * Método que gestiona la puntuacion de los tenistas tras los partidos y muestra por 
     * pantalla quién ha ganado y quién ha perdido
     */
    public synchronized void partidos(int ronda)
    {   
        Tenista t1;
        Tenista t2;
        Tenista ganador;
        Tenista perdedor;
        for(int i = 0; i<competidores.size(); i++){
           t1 = competidores.get(i);
           t2 = competidores.get(competidores.size()-1);
           
           escribirFicheroPantalla("  #### Juego ------------>>>: "+i);
           juego(t1, t2);
           //LLAMADA A LOS MEDIOS 
           if(t1.getPuntosAcumulados() > t2.getPuntosAcumulados()){
               notificar(t1,t2,ronda);
           }
           else{
               notificar(t2,t1,ronda);
           }
           
           if(t1.getPuntosAcumulados()==t2.getPuntosAcumulados())
           {
               if((t1.getSaque()+t1.getResto())<(t2.getSaque()+t2.getResto())){
                    ganaPrimero(t1,t2);                  
               }
               else{
                    ganaUltimo(t2,t1,i);                  
               }
           }
           else if(t1.getPuntosAcumulados() > t2.getPuntosAcumulados()){
                    ganaPrimero(t1,t2);
           }
           
           else{
                    ganaUltimo(t2,t1,i);                    
           }  
        }
    }
    
    /**
     * Método que simula un partido entre dos tenistas
     * @param t1 un tenista
     * @param t2 un tenista
     */  
    private synchronized void juego(Tenista t1, Tenista t2)
    {
        escribirFicheroPantalla("    ## Tenista1 ("+t1.getClass().getName()+") ---->>>: "+t1.getNombre());
        comprobacionMostrarZapatilla(t1);
        escribirFicheroPantalla("    ## Tenista2 ("+t2.getClass().getName()+") ---->>>: "+t2.getNombre());
        comprobacionMostrarZapatilla(t2);
        t1.jugar(t2);
        t2.jugar(t1);
    }
    
    /**
     * Método que muestra el ganador y perdedor en el caso de que gane el primer tenista 
     * situado en la lista
     */
    private synchronized void ganaPrimero(Tenista ganador, Tenista perdedor)
    {
       añadirEliminado(perdedor);        
       borrarUltimoymostrar(ganador, perdedor);
    }
    
    /**
     * Metodo que añade a la lista de eliminados al tenista perdedor 
     * eliminandolo del campeonato, añade a la lista de competidores al ganador y 
     * muestra llamando a GanadorYperdedor
     * @param ganador El Tenista que gana el partido
     * @param perdedor El Tenista que pierde el partido
     * @param indice La posicion del tenista que se va a borrar.
     */
    private synchronized void ganaUltimo(Tenista ganador, Tenista perdedor, int indice)
    {
       añadirEliminado(perdedor);
       competidores.remove(indice);
       competidores.add(indice, ganador);
       borrarUltimoymostrar(ganador, perdedor);       
    }
    
    /**
     * Método que muestra el ganador del torneo
     * @param ganador El tenista ganador
     */
    private synchronized void mostrarganadorTorneo (Tenista ganador)
    {
        escribirFicheroPantalla("\n");
        escribirFicheroPantalla("---->>>>  Gana la competición:"+ganador.toString()+"  <<<<----\n");  
    }
    
    /**
     * Método que muestra las nuevas zapatillas del Tenista en caso de que cambie las suyas
     * @param t1 un Tenista
     */
    private synchronized void comprobacionMostrarZapatilla (Tenista t1){
       if (t1.elegirZapatillaTenista()){
            escribirFicheroPantalla("       Zapatillas asignadas: "+t1.getZapatilla().toString());
        }        
    }
    
    /**
     * Método que añade un Tenista a la lista de eliminados
     * @param perdedor un tenista que ha perdido
     */
    private synchronized void añadirEliminado(Tenista perdedor){
       eliminados.add(perdedor);
       perdedor.setposEliminado(eliminados.size());        
    }
    
    /**
     * Método que borra el último jugador de la lista de competidores y muestra el
     * ganador y perdedor de cada partido
     * @param un Tenista ganador
     * @param un Tenista perdedor
     */
    private synchronized void borrarUltimoymostrar (Tenista ganador, Tenista perdedor){
       competidores.remove(competidores.size()-1);
       mostrarGanadoryPerdedor(ganador, perdedor);        
    }
    
    /**
     * Metodo que imprime por pantalla la informacion referida a el tenista ganador y 
     * al perdedor siendo esta , el nombre y los puntos acumulados
     * @param ganador hace referencia al Tenista que gana el partido
     * @param perdedor hace referencia al Tenista que pierde el partido
     */
    private synchronized void mostrarGanadoryPerdedor(Tenista ganador, Tenista perdedor)
    {
       escribirFicheroPantalla("    ## Gana este juego: "+ganador.getNombre()+" con: "
       +ganador.getPuntosAcumulados()+" puntos acumulados.");
    
       escribirFicheroPantalla("    ## Se elimina: "+perdedor.getNombre()+" con: "
       +perdedor.getPuntosAcumulados()+" puntos acumulados. Tenista eliminado num: "
       +eliminados.size() + "\n");
       ganador.resetPuntosAcumulados();        
    }
    
    /**
     * Método encargado de mostrar las raquetas asignadas a tenistas
     */
    public synchronized void mostrarRaquetas(){
        for(Tenista tenistas: competidores)
        {
            escribirFicheroPantalla("   **     "+tenistas.getRaqueta().toString()+ 
                               " asignada a -->> "+tenistas.getNombre());
        }        
    }
    
    /**
     * Método encargado de mostrar la lista de tenistas que compiten en el campeonato
     */
    private synchronized void listaTenistas_competidores ()
    {
        for(Tenista tenistas: competidores)
        {
             escribirFicheroPantalla(tenistas.toString());
        }
    }
    
    /**
     * Método encargado de mostrar las raquetas disponibles del campeonato
     */
    private synchronized void raquetasDisponibles(){
        for(Raqueta raqueta: raquetasCampeonato)
        {
             escribirFicheroPantalla("      "+raqueta.toString());
        }  
    }
    
    /**
     * Método encargado de mostrar la lista de tenistas eliminados en el campeonato
     */
    private synchronized void listaTenistas_eliminados ()
    {
        for(Tenista tenistas: eliminados)
        {
             escribirFicheroPantalla(tenistas.toString());
        }
    }
    
    /**
     * Método encargado de borrar una Zapatilla de la lista de zapatillas
     */
    public synchronized void borrarZapatilla(Zapatilla z)
    {
        zapatillasCampeonato.remove(z);
    }
    
    /**
     * Método encargado de borrar una Raqueta del treeset de raquetas
     */
    public synchronized void borrarRaqueta(Raqueta r)
    {
        raquetasCampeonato.remove(r);
    }
    
    /**
     * Método que realiza una copia de la lista de competidores
     */
    public synchronized ArrayList<Tenista> getCompetidores()
    {
        ArrayList <Tenista> copiaCompetidores = new ArrayList<Tenista>(competidores);
        return copiaCompetidores;
    }
    
    /**
     * Método que realiza una copia de la lista de zapatillas
     */
    public synchronized ArrayList<Zapatilla> getZapatillasCampeonato()
    {
        ArrayList <Zapatilla> copiaZapatillas = new ArrayList<Zapatilla>(zapatillasCampeonato);
        return copiaZapatillas;
    }
    
    /**
     * Método que hace una copia del treeset de raquetas
     */
    public synchronized TreeSet<Raqueta> getRaquetasCampeonato()
    {
        TreeSet <Raqueta> copiaRaquetas = new TreeSet<Raqueta>(raquetasCampeonato);
        return copiaRaquetas;
    }
    
    /**
     * Devuelve el nombre de un Campeonato
     * @return el nombre de un campeonato
     */
    public synchronized String getNombre(){
        return this.nombre;
    }
    
    /**
     * Método que hace un reset de todas las listas y treeset del campeonato y 
     * finaliza la instancia campeonato
     */
    
    public synchronized void reset () 
    {
        singletonCampeonato=null;
    }
    
    public void escribirFichero(String texto)
    {
        try
        {
            writer.write(texto);
        }
        catch(IOException e)
        {
            System.err.println("Error al escribir en fichero");
        }
    }
    
    public void escribirFicheroPantalla(String texto)
    {
        escribirFichero(texto);
        escribirFichero("\n");
        System.out.println(texto);
    }
}