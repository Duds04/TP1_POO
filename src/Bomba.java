// TODO: Verificar possibilidade de criacao da funcao de fazer som de explosao

public class Bomba extends Bloco{
    public Bomba(){
        super();
    }
    
    @Override
    public boolean isBomba(){
        return true;
    }

    public void revelaQPerdeu(){
        System.out.println("--------- PERDEU! ---------");
        System.out.println("------- FIM DE JOGO -------");
    }
}


