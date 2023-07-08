import java.util.Random;

final public class Vencya extends Personagem implements IPersonagem{
    public Vencya() {
        super("Vencya", 35, 10, 30);
    }

    @Override
    public void contarHistoria() {
        System.out.println("Vencya, herdeira de uma nobre linhagem de guerreiros muito importantes do passado, " +
                "mas que caíram no esquecimento. \nEla busca se tornar a maior guerreira de sua geração e " +
                "retomar o prestígio que seus antepassados possuíam.\n");
    }

    @Override
    public void poderEspecial(Inimigo inimigo) {
        Random dado = new Random();
        int ataque = dado.nextInt(1, 8);
        inimigo.pv -= ataque;
        pm -= 4;
        System.out.println(inimigo.getNome() + " recebeu " + ataque + " de dano\nVida total: " + inimigo.getPv());
        System.out.println("Vencya perde 4 pontos de mana ao usar seu poder especial\nMana total: " + getPm());
    }

    @Override
    public void atacar(Inimigo inimigo) {
        Random dado = new Random();
        int ataque = dado.nextInt(1, 6);
        inimigo.pv -= ataque;
        System.out.println(inimigo.getNome() + " recebeu " + ataque + " de dano\nVida total: " + inimigo.getPv() + "\n");
    }
}
