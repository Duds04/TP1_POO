import java.util.ArrayList;
import java.util.Arrays;

public class CampoMinado {
    public static void main(String[] args) {
        int tamanhoX =6;
        int tamanhoY = 10;
        ArrayList<ArrayList<Integer>> mapa = new ArrayList<ArrayList<Integer>>(tamanhoX);
        
        //caso queiram testar, basta editar a matriz abaixo. Para teste eu considerei que as celulas que foram abertas seriam marcadas com 10
        
        mapa.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0)));
        mapa.add(new ArrayList<Integer>(Arrays.asList(0,0,2,1,1,1,0,0,0,0)));
        mapa.add(new ArrayList<Integer>(Arrays.asList(1,1,1,1,0,1,1,1,1,0)));
        mapa.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,1,0)));
        mapa.add(new ArrayList<Integer>(Arrays.asList(1,1,1,1,0,1,1,1,1,0)));
        mapa.add(new ArrayList<Integer>(Arrays.asList(0,0,0,1,1,1,0,0,1,0)));

        // para preencher iterativamente
        // for (int i = 0; i < tamanhoX; i++){
        //     mapa.add(new ArrayList<Integer>(tamanhoY));
        // }
        // for (int i = 0; i < tamanhoX; i++ ){
        //     for (int j = 0; j < tamanhoY; j++){
        //         mapa.get(i).add(i*j);
        //     }
        // }
        for (int i = 0; i < tamanhoX; i++ ){
            for (int j = 0; j < tamanhoY; j++){
                System.out.print("\t" + mapa.get(i).get(j));
            }
        System.out.println("");
        }
        backtrackingAbreVazio(mapa, 3, 0);
        System.out.println("");
        
        for (int i = 0; i < tamanhoX; i++ ){
            for (int j = 0; j < tamanhoY; j++){
                System.out.print("\t" + mapa.get(i).get(j));
            }
        System.out.println("");
        }

    }
    static int backtrackingAbreVazio( ArrayList<ArrayList<Integer>> mapa, int coordenadaX, int coordenadaY){
        // Filtra se X e Y estao fora do mapa
        if (coordenadaX < 0 ||coordenadaX >= mapa.size()){
            return 0;
        }
        if (coordenadaY < 0 || coordenadaY >= mapa.get(0).size()){ // como toda linha tera o mesmo tamanho, basta comparar com o tamanho da linha 0
            return 0;
        }
        //Ou seja, nao eh um espaco vazio:
        if (mapa.get(coordenadaX).get(coordenadaY) != 0){ // todo
            // o blobo deve ser aberto, porem nao deve continuar chamando a recursao para os blocos adjacentes
            mapa.get(coordenadaX).set(coordenadaY, 10);
            return 0;
        }

        mapa.get(coordenadaX).set(coordenadaY, 10);

        backtrackingAbreVazio(mapa, coordenadaX - 1, coordenadaY - 1);
        backtrackingAbreVazio(mapa, coordenadaX - 1, coordenadaY);
        backtrackingAbreVazio(mapa, coordenadaX - 1, coordenadaY + 1);
        backtrackingAbreVazio(mapa, coordenadaX, coordenadaY - 1);
        backtrackingAbreVazio(mapa, coordenadaX, coordenadaY + 1);
        backtrackingAbreVazio(mapa, coordenadaX + 1, coordenadaY - 1);
        backtrackingAbreVazio(mapa, coordenadaX + 1, coordenadaY);
        backtrackingAbreVazio(mapa, coordenadaX + 1, coordenadaY + 1);
        return 0;
    }
}
