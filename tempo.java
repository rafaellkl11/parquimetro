
/**
 * Relgio.
 * 
 * Rafael Henrique Flores de Chapman Santos
 * 
 */
public class tempo 
{
    // recebe minutos
    private int minutos;
    // recebe horas
    private int horas;
    

    /**
     * Construtor para objetos da classe tempo
     * Recebe horas e minutos e transforma em relogio
     */
    public tempo(int minutos, int horas)
    {
        this.minutos = minutos;
        this.horas = horas; 
        System.out.println(minutos);
        while (this.minutos >= 60){
            this.minutos = this.minutos - 60;
            this.horas ++;
        }
    }
    
    public String getRelogio()
    {   
        return String.format("%02d:%02d", horas,minutos);
        
    }
    
    
}
