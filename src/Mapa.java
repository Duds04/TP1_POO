import java.util.ArrayList;

// TODO: se houver uma casa na diagonal que é vazia, o backtracking deve abri-la ou nao? se não, é necessario filtrar

public class Mapa {

    private Bloco[][] mapa;
    private int totalBombas;
    private int bandeirasRestantes;
    private int linhas;
    private int colunas;
    private int totCelulas; // total de celulas que o usuario deve abrir
    private int celulasAbertas;


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
        return 0;
    }
    public int abrirBloco(){
        return 0;
    }
    public int backtrackingAbreVazio(int coordenadaX, int coordenadaY){
        // Filtra se X e Y estao fora do mapa

        // ! Estou considerando que o revelaBloco, caso abra uma bomba, chame uma funcao de finalizarPartida ou algo parecido. Se for retornar algo é necessário modificar
        // TODO: verificar comentario acima
        
        if (coordenadaX < 0 ||coordenadaX >= this.linhas){
            return 0;
        }
        if (coordenadaY < 0 || coordenadaY >= this.colunas){ 
            return 0;
        }

        // Caso a celula já tenha sido aberta, ela nao deve ser aberta novamente
        if (this.mapa[coordenadaX][coordenadaY].isRevelado() == True){
            return 0;
        }
        
        //Se nao for espaco vazio:
        if (this.mapa[coordenadaX][coordenadaY].getBombasAdjacentes() != 0){ 
            // o blobo deve ser aberto, porem nao deve continuar chamando a recursao para os blocos adjacentes
            this.mapa[coordenadaX][coordenadaY].revelaBloco();
            this.celulasAbertas += 1;
            if (totCelulas == celulasAbertas){
                this.finalizaPartida();
            }
            
            return 0;
        }

        this.mapa[coordenadaX][coordenadaY].revelaBloco();
        this.celulasAbertas += 1;
        if (totCelulas == celulasAbertas){
            this.finalizaPartida();
        }

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
        if (this.totCelulas == this.celulasAbertas) {
            System.out.println("============================================================");
            System.out.println("PARABENS, VOCE VENCEU!!!!");
            System.out.println("============================================================");
            // TODO: o que fazer aqui? perguntar ao usuario que ele quer jogar de novo? fazer uma animacao? ha de se averiguar
        }
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