
/**
 * La clase Campeonato representa el torneo que se va a disputar entre los distintos tenistas que participan
 * 
 * @author David Bonilla, Antonio Javier Hidalgo y Juan Francisco García 
 * @version 09-10-2021
 */
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Iterator;


public class Campeonato
{
    private String nombre;
    private ArrayList <Tenista> competidores;
    private ArrayList <Tenista> eliminados;
    private ArrayList <Zapatilla> zapatillasCampeonato;
    private TreeSet <Raqueta> raquetasCampeonato;
    
    /**
     * Constructor for objects of class Campeonato
     */
    public Campeonato(String nombre)
    {
        this.nombre = nombre;
        competidores = new ArrayList <Tenista>();
        eliminados = new ArrayList <Tenista>();
        zapatillasCampeonato = new ArrayList <Zapatilla>();
        raquetasCampeonato = new TreeSet <Raqueta> (new PotenciaComparator());
    }
    /**
     * Método que inscribe a un Tenista al campeonato, añadiendolo a la lista de competidores
     * @param t1 Hace referencia a un tenista
     */
    public void inscripcionCompetidores (Tenista t1)
    {
        competidores.add(t1);
    }
    
    public void añadirZapatilla (Zapatilla z1)
    {
        zapatillasCampeonato.add(z1);
    }
    
    public void añadirRaquetas (Raqueta r1)
    {
        raquetasCampeonato.add(r1);
    }
    
    public void asignarRaquetas (){
        
        if (raquetasCampeonato.size()>=competidores.size()){
                for (int i = 0; i<competidores.size(); i++){
                        Tenista t = competidores.get(i);
                        t.setRaqueta(raquetasCampeonato.first());
                        raquetasCampeonato.remove(raquetasCampeonato.first());
                }
            }
            
        else{
        System.out.println("## CAMPEONATO ANULADO POR FALTA DE RAQUETAS ");
        }
    }
    public void buscarZapatillaTenista(){

        for (Tenista jugadores: competidores) {
           jugadores.elegirZapatillaTenista(zapatillasCampeonato);
        }
    }

    /**
     * Método que simula un partido entre dos tenistas
     * @param t1 Hace referencia a un tenista
     * @param t2 Hace referencia a un tenista
     */  
    private void juego(Tenista t1, Tenista t2)
    {
        System.out.println("## Tenista1 ---->>>: "+t1.getNombre());
        System.out.println("## Tenista2 ---->>>: "+t2.getNombre());
        t1.jugar(t2);      
    }
    /**
     * Método que muestra por pantalla el avance de los partidos, las rondas, quien ha ganado y el listado de eliminados
     */
    public void controlDeCampeonato()
    {
        int i = 1;
        System.out.println("***** Inicio del campeonato: "+nombre+" *****\n");
        System.out.println("***** Listado de competidores: ");
        listaTenistas_competidores();
        buscarZapatillaTenista();
        asignarRaquetas();
        while(competidores.size() != 1){
           System.out.println("\n"); 
           System.out.println("***** Ronda---->>>: "+i);
           i++;
           partidos();
        }
        
        Tenista ganador = competidores.get(0);
        mostrarganadorTorneo(ganador);
        System.out.println("***** Listado de eliminados: ");
        Collections.sort(eliminados, Collections.reverseOrder(new PosicionComparator()));
        listaTenistas_eliminados();
    
    }
    /**
     * Método que muestra el ganador del torneo
     * @param ganador Hace referencia el tenista ganador
     */
    private void mostrarganadorTorneo (Tenista ganador)
    {
        System.out.println("\n");
        System.out.println("---->>>> Gana la competición:"); 
        ganador.mostrarTenista();
        System.out.println("\n"); 
    }
    /**
     * Método que gestiona la puntuacion de los tenistas tras los partidos y muestra por pantalla quien ha ganado y quien ha perdido
     */
    public void partidos()
    {   
        Tenista t1;
        Tenista t2;
        Tenista ganador;
        Tenista perdedor;
        for(int i = 0; i<competidores.size(); i++){
           t1 = competidores.get(i);
           t2 = competidores.get(competidores.size()-1);
           
           System.out.println("### Juego ------------>>>: "+i);
           juego(t1, t2);
           
           
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
     * Método que muestra el ganador y perdedor en el caso de que gane el primer tenista situado en la lista
     */
    private void ganaPrimero(Tenista ganador, Tenista perdedor)
    {
       añadirEliminado(perdedor);        
       borrarUltimoymostrar(ganador, perdedor);
    }
    /**
     * Metodo que añade a la lista de eliminados al tenista perdedor eliminandolo del campeonato,
     * añade a la lista de competidores al ganador  y muestra llamando a GanadorYperdedor
     * @param ganador hace referencia al Tenista que gana el partido
     * @param perdedor hace referencia al Tenista que pierde el partido
     * @param indice hace referencia a la posicion del tenista que se va a borrar.
     */
    private void ganaUltimo(Tenista ganador, Tenista perdedor, int indice)
    {
       añadirEliminado(perdedor);
       competidores.remove(indice);
       competidores.add(indice, ganador);
       borrarUltimoymostrar(ganador, perdedor);       
    }
    
    private void añadirEliminado(Tenista perdedor){
       eliminados.add(perdedor);
       perdedor.setposEliminado(eliminados.size());        
    }
    
    private void borrarUltimoymostrar (Tenista ganador, Tenista perdedor){
       competidores.remove(competidores.size()-1);
       mostrarGanadoryPerdedor(ganador, perdedor);        
    }
    /**
     * Metodo que imprime por pantalla la informacion referida a el tenista ganador y al perdedor,
     * siendo esta , el nombre y los puntos acumulados
     * @param ganador hace referencia al Tenista que gana el partido
     * @param perdedor hace referencia al Tenista que pierde el partido
     */
    private void mostrarGanadoryPerdedor(Tenista ganador, Tenista perdedor)
    {
       System.out.println("## Gana este juego: "+ganador.getNombre()+" con: "
       +ganador.getPuntosAcumulados()+" puntos acumulados.");
    
       System.out.println("## Se elimina: "+perdedor.getNombre()+" con: "
       +perdedor.getPuntosAcumulados()+" puntos acumulados. Tenista eliminado num: "+eliminados.size());
       ganador.resetPuntosAcumulados();        
    }
    /**
     * Metodo encargado de mostrar la lista de tenistas que compiten en el campeonato
     */
    private void listaTenistas_competidores ()
    {
        for(Tenista tenistas: competidores)
        {
            tenistas.mostrarTenista();
        }
    }
    /**
     * Metodo encargado de mostrar la lista de tenistas eliminados en el campeonato
     */

    private void listaTenistas_eliminados ()
    {
        for(Tenista tenistas: eliminados)
        {
            tenistas.mostrarTenista();
        }
    }
    
}