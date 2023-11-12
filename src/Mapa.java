import java.util.ArrayList;

// TODO: se houver uma casa na diagonal que é vazia, o backtracking deve abri-la ou nao? se não, é necessario filtrar

public class Mapa {

    private Bloco[][] mapa;
    private int totalBombas;
    private int bandeirasRestantes;
    private int linhas;
    private int colunas;


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
        return this.totalBombas;
    }
    public int modificaBadeira(int coordenadaX, int coordenadaY){
//        mapa[coordenadaX][coordenadaX].modificaBandeira();
        return 0;
    }
    public int abrirBloco(int coordenadaX, int coordenadaY){

//        if(mapa[coordenadaX][coordenadaX].isBomba()) 
//            finalizaPartida();
//        else
//            mapa[coordenadaX][coordenadaX].revelaBloco();
//        
        return 0;
    }
    
    public int backtrackingAbreVazio(int coordenadaX, int coordenadaY){
        // Filtra se X e Y estao fora do mapa
        if (coordenadaX < 0 ||coordenadaX >= this.linhas){
            return 0;
        }
        if (coordenadaY < 0 || coordenadaY >= this.colunas){ 
            return 0;
        }
        //Ou seja, nao eh um espaco vazio:
        if (this.mapa[coordenadaX][coordenadaY].getBombasAdjacentes() != 0){ 
            // o blobo deve ser aberto, porem nao deve continuar chamando a recursao para os blocos adjacentes
            this.mapa[coordenadaX][coordenadaY].revelaBloco();
            return 0;
        }

        this.mapa[coordenadaX][coordenadaY].revelaBloco();

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
        revelaOutrasBombas();
        return 0;
    }
    
    public int revelaOutrasBombas(){
        for (int i = 0; i < this.linhas; i++){
            for (int j = 0; j < this.colunas; j++){
                // TODO: se for pra mostrar aos poucos, tem que ir colocar um timer. Ha se averiguar como será feito
                if (!this.mapa[i][j].isRevelado()) this.mapa[i][j].revelaBloco();
            }
        }
    }

}