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
        int cura = Dado.rolarDados(1,4);
        setPv(getPv() + cura);
        setPm(this.pm - 5);
        System.out.println("Dorivan recebe " + cura + " ponto(s) de vida após se benzer\t - Vida total: " + getPv() +
                "\t - Mana total: " + getPm());
        inimigo.setPv(inimigo.getPv()-2);
        if (inimigo.getPv() > 0)
            System.out.println("O inimigo é afetado pela purificação de Dorivan e perde 2 pontos de vida\t - Vida total: " +
                inimigo.getPv() + "\n");
        else
            System.out.println("O inimigo é afetado pela purificação de Dorivan, perde 2 pontos de vida e é derrotado\n");
    }

    @Override
    public void atacar(Inimigo inimigo) {
        int ataque = Dado.rolarDados(1,6) + ataqueAdicional;
        inimigo.setPv(inimigo.getPv()-ataque);
        if (inimigo.getPv() > 0)
            System.out.println(inimigo.getNome() + " recebeu " + ataque + " de dano\t - Vida total: " + inimigo.getPv());
        else
            System.out.println(inimigo.getNome() + " recebeu " + ataque + " de dano e foi derrotado.");
    }
}
