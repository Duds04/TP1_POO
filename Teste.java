public class Teste {
    public static void main(String[] args) {
        CampoMinado campoMinado = new CampoMinado();
        System.out.println("\nMapa antes de ser aberto");
        campoMinado.mostraCampo();
        campoMinado.backtrackingAbreVazio(0, 0);
        System.out.println("\nMapa depois de ser aberto");
        campoMinado.mostraCampo();
        System.out.println("Total de casas abertas: " + campoMinado.getCelulasAbertas());
    }
}
