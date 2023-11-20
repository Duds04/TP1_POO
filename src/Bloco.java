
public class Bloco{
    private boolean bandeira;
    private boolean revelado;


    public Bloco(){
        this.bandeira = false;
        this.revelado = false;
    }

    public boolean isBandeira(){
        if (this.bandeira == true) return true;
        return false;
    }

    public void colocaBandeira(){
        this.bandeira = true;
    }

    public void tiraBandeira(){
        this.bandeira = false;
    }

    public void modificaBandeira(){
        if(this.bandeira == true){
            tiraBandeira();
            return;
        }
        colocaBandeira();
    }

    public boolean isRevelado(){
        if(this.revelado == true) return true;
        return false;
    }

    public void revelaBloco(){
        if(isRevelado() == true)
            return;
        this.revelado = true;
    }

    public boolean isBomba(){
        return false;
    }

}