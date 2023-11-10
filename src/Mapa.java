import java.util.ArrayList;

public class Mapa {
    private int totalDeBombas;
    private int bandeirasRestantes;

    // Esses seriam os valores das dimensoes das matrizes usados para setar a dificuldade
    private static int dificuldadeFacilX = 10;
    private static int dificuldadeFacilY = 10;
    private static int dificuldadeMediaX = 10;
    private static int dificuldadeMediaY = 10;
    private static int dificuldadeDificilX = 10;
    private static int dificuldadeDificilY = 10;

    // TODO: conferir se o tipo do mapa será esse mesmo
    private ArrayList<ArrayList<Bloco>> mapa;


    public Mapa (String dificuldade){

    }
    public int geraMapa(){
        // para cada elemento do arraylist mais interno, deve-se criar um novo array list dentro dele. Segue pseudo
        // for M in matriz MxN:
        //      mapa.add(new ArrayList(N))
        // 
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
    public int backtrackingAbreVazio(int coordenadaX, int coordenadaY){
        // Filtra se X e Y estao fora do mapa
        if (coordenadaX < 0 ||coordenadaX >= this.mapa.size()){
            return 0;
        }
        if (coordenadaY < 0 || coordenadaY >= this.mapa.get(0).size()){ // como toda linha tera o mesmo tamanho, basta comparar com o tamanho da linha 0
            return 0;
        }
        //Ou seja, nao eh um espaco vazio:
        if (this.mapa.get(coordenadaX).get(coordenadaY).getBombasAdjacentes() != 0){ 
            // o blobo deve ser aberto, porem nao deve continuar chamando a recursao para os blocos adjacentes
            this.mapa.get(coordenadaX).get(coordenadaY).revelaBloco();
            return 0;
        }

        this.mapa.get(coordenadaX).get(coordenadaY).revelaBloco();

        backtrackingAbreVazio(coordenadaX - 1, coordenadaY - 1);
        backtrackingAbreVazio(coordenadaX - 1, coordenadaY);
        backtrackingAbreVazio(coordenadaX - 1, coordenadaY + 1);
        backtrackingAbreVazio(coordenadaX, coordenadaY - 1);
        backtrackingAbreVazio(coordenadaX, coordenadaY + 1);
        backtrackingAbreVazio(coordenadaX + 1, coordenadaY - 1);
        backtrackingAbreVazio(coordenadaX + 1, coordenadaY);
        backtrackingAbreVazio(coordenadaX + 1, coordenadaY + 1);
        return 0;
    }
    public int finalizaPartida(){
        return 0;
    }
    public int revelaOutrasBombas(){
        return 0;
    }

}