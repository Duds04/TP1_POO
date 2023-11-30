import java.util.Scanner;

public class CampoMinado {
    public static void main(String[] args) {
        Mapa mapa =  new Mapa("FACIL"); 
        Scanner scanner = new Scanner(System.in);
        String tipo;
        String linha;
        int x, y;
        /*
         * O jogo esta jogavel nesse ponto
         * Para abrir a celula, digite "X i j", onde i e j são as coordenadas (tem uma barra nas laterais da matriz pra facilitar na hora de ver)
         * Pra marcar com bandeira, digite "B i j", onde i e j são as coordenadas
         * Pra revelar a matriz (foi usado pra debug) digite "A 0 0"
         * 
         * Coisas a fazer:
         * // TODO: se perder tem que sair do jogo e revelar todas as bombas
         * // TODO: filtrar coordenadas invalidas e coisas do tipo
         */
        while (true) {
            mapa.mostraCampo();
            linha = scanner.nextLine();
            tipo = linha.substring(0,1);
            x = Integer.parseInt(linha.substring(2, 3));
            y = Integer.parseInt(linha.substring(4, 5));
            if (tipo.equals("B")){
                mapa.modificaBadeira(x, y);
                continue;
            }
            else if (tipo.equals("A")) {

                mapa.mostraCampoTudo();
                continue;
            }
            else if (tipo.equals("X")) {
                mapa.abrirBloco(x, y);
            }
        }
    }

}
