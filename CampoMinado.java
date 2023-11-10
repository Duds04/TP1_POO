import java.util.ArrayList;

public class CampoMinado {
    public static void main(String[] args) {
        int tamanhoX = 10;
        int tamanhoY = 15;
        ArrayList<ArrayList<Integer>> mapa = new ArrayList<ArrayList<Integer>>(tamanhoX);
        for (int i = 0; i < tamanhoX; i++){
            mapa.add(new ArrayList<Integer>(tamanhoY));
        }
        for (int i = 0; i < tamanhoX; i++ ){
            for (int j = 0; j < tamanhoY; j++){
                mapa.get(i).add(i*j);
            }
        }
        for (int i = 0; i < tamanhoX; i++ ){
            for (int j = 0; j < tamanhoY; j++){
                System.out.print("\t" + mapa.get(i).get(j));
            }
        System.out.println("");
        }

    }
}
