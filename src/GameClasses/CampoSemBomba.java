package GameClasses;
public class CampoSemBomba extends Bloco{
    private int bombasAdjacentes;
    
    public CampoSemBomba(int bombasAdjacentes){
        super();
        this.bombasAdjacentes = bombasAdjacentes;
    }

    @Override
    public boolean isBomba(){
        return false;
    }

    public int getBombasAdjacentes() {
        return bombasAdjacentes;
    }
    public void setBombasAdjacentes(int bombasAdjacentes) {
        this.bombasAdjacentes = bombasAdjacentes;
    }
}
