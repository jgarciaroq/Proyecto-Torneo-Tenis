
/**
 * Esta clase representa las raquetas controladas, es una subclase de raqueta generica
 * 
 * @author Antonio Javier Hidalgo
 * @author Juan Francisco García
 * @author David Bonilla
 * @version 13-11-2021
 */

public class RaquetaControlada extends RaquetaGenerica
{
    private double multiplicadorVelocidad;

      /**
     * Constructor Parametrizado de la clase RaquetaPotente
     * Este constructor crea un nuevo objeto de la clase RaquetaPotente 
     * con los valores pasados por parametro.
     */
    public RaquetaControlada(String modelo, double peso, double longitud, double tamañoCabeza,
                             Encordado encordado)
    {
        super(modelo, peso, longitud, tamañoCabeza, encordado);
        this.multiplicadorVelocidad = 1.2;
    }
    
    /**
     * Multiplica el control asociado a la raqueta según su tamaño de cabeza
     * @return control asociado a la raqueta según su tamaño de cabeza
     */
    @Override
    public double calcularControl ()
    {
        double control = super.getEncordado().getMultiplicadorControl();
        double resultado = super.calcularControl();
        return control*resultado;
    }
    
    /**
     * Multiplica la velocidad asociada a la raqueta según su peso
     * @return velocidad asociada a la raqueta según su peso
     */
    @Override
    public double calcularVelocidad ()
    {
        double resultado = super.calcularVelocidad();
        return multiplicadorVelocidad*resultado;
    }
    
    /**
     * Devuelve el multiplicador de velocidad de la raqueta
     * @return el multiplicador de velocidad
     */
    public double getMultiplicadorVelocidad()
    {
        return multiplicadorVelocidad;
    }
    
    /**
     * Permite cambiar el multiplicador de velocidad de la raqueta
     * @param multiplicadorVelocidad El nuevo multiplicador de velocidad
     */
    public void setMultiplicadorVelocidad(double multiplicadorVelocidad)
    {
        this.multiplicadorVelocidad = multiplicadorVelocidad;
    }
    
    public String mostrarTipo(){
        return "RaquetaControlada";
    }
    
    /**
     * Devuelve una cadena con el tipo de raqueta que es y los campos especificos de la subclase
     * @return el tipo de raqueta y sus campos especificos
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("   RaquetaControlada(Encordado:");
        builder.append(getEncordado());
        builder.append(" (MultiplicadorDePotencia: ");
        builder.append(getEncordado().getMultiplicadorPotencia()+")");
        builder.append(" (MultiplicadorDeControl: ");
        builder.append(getEncordado().getMultiplicadorControl()+")");
        builder.append("\n");
        builder.append(super.toString());
        return builder.toString();
    }
    
    @Override
    public int hashCode()
    {
        int result = 7;
        result = 3 * result + super.hashCode();
        result = 5 * result + ((Double)getMultiplicadorVelocidad()).hashCode();
        return result;
    }
    
    /**
     * Devuelve true si todos los campos son iguales o si apuntan al mismo objeto, 
     * false si algún campo es diferente o no son del mismo tipo
     */
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj){
            return true; 
        }
        if(!(obj instanceof RaquetaControlada)){
            return false; 
        }
        
        RaquetaControlada other = (RaquetaControlada) obj;
        
        return super.equals(other) && getMultiplicadorVelocidad()==other.getMultiplicadorVelocidad();
    }
}
