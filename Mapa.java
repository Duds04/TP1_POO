public class Mapa {
    //private Bloco[][] mapa;
    private int totalBombas;
    private int bandeirasRestantes;
    private int linhas;
    private int colunas;

    public Mapa(String dificuldade){

    }

    private void geraMapa(String dificuldade){
        // separei linhas e colunas no caso de querermos fazer um campo minado de outra forma, não necessáriamente quadrado
        int i = 0, j= 0;
        double posX, posY;
        if(dificuldade.toUpperCase() == "FACIL"){
            this.linhas = 8;
            this.colunas = 8;
            this.totalBombas = 10;
            //this.mapa = new Bloco[linhas][colunas];
        }
        else if(dificuldade.toUpperCase() == "MEDIO"){
            this.linhas = 14;
            this.colunas = 14;
            this.totalBombas = 40;
            //this.mapa = new Bloco[linhas][colunas];
        }
        else if(dificuldade.toUpperCase() == "DIFICIL"){
            this.linhas = 20;
            this.colunas = 20;
            this.totalBombas = 99;
            //this.mapa = new Bloco[linhas][colunas];
        }
        while (i<this.totalBombas) {
            posY = Math.floor(Math.random()*this.linhas);
            posX = Math.floor(Math.random()*this.colunas);
            //if( não tem bomba aqui){
            //  cria bomba aqui 
            // i++    
            //}
        }

    }

    private void completaCampo(String dificuldade){
        
    }
}
