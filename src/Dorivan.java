import java.util.Random;

public class Dorivan extends Personagem implements IPersonagem{
    public Dorivan() {
        super("Dorivan", 26, 20, 25);
    }

    @Override
    public void contarHistoria() {
        System.out.println("Dorivan, um clérigo pertencente à ordem clerical Alvorada, cultuante do Deus do Sol, " +
                "busca o extermínio dos mortos-vivos que assolam sua região.\n");
    }

    @Override
    public void poderEspecial(Inimigo inimigo) {
        Random dado = new Random();
        int cura = dado.nextInt(1, 4);
        pv += cura;
        pm -= 5;
        System.out.println("Dorivan recebe " + cura + " ponto(s) de vida após se benzer\nVida total: " + getPv() +
                "\tMana total: " + getPm());
        inimigo.pv -= 2;
        System.out.println("O inimigo é afetado pela purificação de Dorivan e perde 2 pontos de vida\nVida total: " +
                inimigo.getPv() + "\n");
    }

    @Override
    public void atacar(Inimigo inimigo) {
        Random dado = new Random();
        int ataque = dado.nextInt(1, 4);
        inimigo.pv -= ataque;
        System.out.println(inimigo.getNome() + " recebeu " + ataque + " de dano\nVida total: " + inimigo.getPv() + "\n");
    }
}
