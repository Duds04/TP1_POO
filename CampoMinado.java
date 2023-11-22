public class CampoMinado {
    
    // ! TUDO QUE ESTA DENTRO DESSA CLASSE PODE SER APAGADO. FOI CRIADO UNICAMENTE PARA PODER GERAR UMA CLASSE INDEPENDENTE DO BLOCO E TENTAR O BACKTRACKING ABRE VAZIO. (pode ser testado executando a classe teste)

    private int[][] mapa =  {{0,0,0,0,0,0,0,0,0,0},
        {0,0,2,1,1,1,0,0,0,0},
        {1,1,1,1,0,1,1,1,1,0},
        {0,0,0,0,0,0,0,0,1,0},
        {1,1,1,1,0,1,1,1,1,0},
        {0,0,0,1,1,1,0,0,1,0}};
    private int totalBombas;
    private int bandeirasRestantes;
    private int linhas;
    private int colunas;
    private int totCelulas; // total de celulas que o usuario deve abrir
    private int celulasAbertas;


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
        if (this.mapa[coordenadaX][coordenadaY] == 10){
            return 0;
        }
        //Ou seja, nao eh um espaco vazio:
        if (this.mapa[coordenadaX][coordenadaY] != 0  ){ 
            // o blobo deve ser aberto, porem nao deve continuar chamando a recursao para os blocos adjacentes
            this.mapa[coordenadaX][coordenadaY] = 10;
            this.celulasAbertas += 1;
            if (totCelulas == celulasAbertas){
                System.out.println("Ganhou");
                return 0;
            }
            
            return 0;
        }

        this.mapa[coordenadaX][coordenadaY] = 10;
        this.celulasAbertas += 1;
        if (totCelulas == celulasAbertas){
            System.out.println("Ganhou");
            return 0;
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

    public CampoMinado(){
        this.linhas = 6;
        this.colunas = 10;
        this.totalBombas = 0;
        this.celulasAbertas = 0;
        this.totCelulas = linhas * colunas;
    }

        // para preencher iterativamente
        // for (int i = 0; i < tamanhoX; i++){
        //     mapa.add(new ArrayList<Integer>(tamanhoY));
        // }
        // for (int i = 0; i < tamanhoX; i++ ){
        //     for (int j = 0; j < tamanhoY; j++){
        //         mapa.get(i).add(i*j);
        //     }
        // }
    public int mostraCampo(){
        for (int i = 0; i < this.linhas; i++ ){
            for (int j = 0; j < this.colunas; j++){
                System.out.print("\t" + this.mapa[i][j]);
            }
        System.out.println("");
        }
        return 0;
    }
    public int getCelulasAbertas() {
        return celulasAbertas;
    }

}
