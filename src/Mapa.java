import java.util.ArrayList;

public class Mapa {
    protected int totalDeBombas;
    protected int bandeirasRestantes;

    // TODO: conferir se o tipo do mapa será esse mesmo
    protected ArrayList<ArrayList<Bloco>> mapa;


    public Mapa (String dificuldade){

    }
    public int geraMapa(){
        return 0;
    }
    public int completaCampo(){
        return 0;
    }
    public int getTotalDeBombas() {
        return totalDeBombas;
    }
    public int modificaBadeira(int coordenadaX, int coordenadaY){
        return 0;
    }
    public int abrirBloco(){
        return 0;
    }
    public int backtrackingAbreVazio(){
        return 0;
    }
    public int finalizaPartida(){
        return 0;
    }
    public int revelaOutrasBombas(){
        return 0;
    }

}