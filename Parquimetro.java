
/**
 * Representa um parquímetro fracionado simplificado.
 * 
 * O parquímetro funciona assim:
 * 1. o cliente seleciona a quantidade de tempo
 *    de estacionamento, incrementando-o
 *    de 15 em 15 minutos.
 * 2. o cliente insere o dinheiro suficiente para
 *    pagar o ticket de estacionamento.
 * 3. o cliente pede para imprimir o ticket.
 * 
 * O parquímetro mantém o total de dinheiro acumulado
 * ao longo do tempo em que está em operação.
 * 
 * @author Daniel Conrado 
 * @version 2023
 */
public class Parquimetro
{
    // campo que armazena quanto custa cada unidade de tempo solicitada.
    // p. ex. o preço unitário a cada 15 minutos comprados.
    private int preçoUnitario;
    // armazena o tempo total sendo solicitado
    private int tempoSolicitado;
    // quantidade de dinheiro já inserida pelo cliente
    private int balanço;
    // quantidade total de dinheiro acumulado por este parquímetro
    private int total;
    // consultar o valor a pagar
    private int totalAPagar;
    // tempo minimo
    private int tempoMinimo;
    // tempo maximo
    private int tempoMaximo;
    
    
    /**
     * Constroi um novo objeto Parquimetro com o preço unitário, tempo minimo e tempo maximo configurado.
     */
    public Parquimetro(int preçoDaFração, int tempo_Minimo, int tempo_Maximo)
    {
        preçoUnitario = preçoDaFração;
        tempoMinimo = tempo_Minimo;
        tempoMaximo = tempo_Maximo;
        tempoSolicitado = tempoMinimo;
        balanço = 0;
        total = 0;
        totalAPagar = 0;
    }

    public void inserirDinheiro(int quantia)
    {
        balanço = balanço + quantia;
    }
    
    public void aumentarTempo()
    {
        if (tempoSolicitado == 15){
            tempoSolicitado = tempoSolicitado + 15;
        }
        else if (tempoSolicitado > 15 && tempoSolicitado < tempoMaximo){
            tempoSolicitado = tempoSolicitado + 30;
        }
    }
    
    public void imprimirTicket(int horaAtual, int minutoAtual)
    {
        getTotalAPagar();
        tempo inicio = new tempo(minutoAtual, horaAtual);
        minutoAtual = minutoAtual+tempoSolicitado;
        tempo finall = new tempo(minutoAtual, horaAtual);
        
        
        if(balanço >= totalAPagar){
            System.out.println("+--------------------------+");
            System.out.println("| Ticket de Zona Azul      |");
            System.out.println("+--------------------------+");
            System.out.printf ("| Início: %s           |\n", inicio.getRelogio());
            System.out.println("|                          |");
            System.out.printf ("| Final: %s           |\n", finall.getRelogio());
            System.out.println("|                          |");
            System.out.printf ("| Válido por: %-13s|\n", tempoSolicitado + "min");
            System.out.println("+--------------------------+");
        
            total = total + totalAPagar;
            tempoSolicitado = tempoMinimo;
            balanço = balanço - totalAPagar;
        }
    }
    
    public void devolverTroco(){
        balanço = 0;
    }
    
    public int getTotalAPagar()
    {
         if (tempoSolicitado <= 15){
            totalAPagar = 50;
        }
        else if (tempoSolicitado <= 30){
            totalAPagar = 100;
        }
        else if (tempoSolicitado <= 60){
            totalAPagar = 150;
        }
        else if (tempoSolicitado <= 90){
            totalAPagar = 200;
        }
        else if (tempoSolicitado <= 120){
            totalAPagar = 250;
        }
        return totalAPagar;
    }
    
    public int getEsvaziar()
    {
        total = 0;
        return total;
    }
    
    public int getPreçoUnitario()
    {
        return preçoUnitario;
    }
    
    public int getTempoSolicitado()
    {
        return tempoSolicitado;
    }
    
    public int getBalanço()
    {
        return balanço;
    }
}
