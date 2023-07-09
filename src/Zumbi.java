final public class Zumbi extends Inimigo implements IObstaculo{



    public Zumbi() {
        super(20, "Zumbi");
    }

    @Override
    public void contaHistoria(Personagem personagem) {
        System.out.println(personagem.getNome() + " avança, acabando com as hordas de esqueletos, chegando a entrada da torre do prefeito, onde o necromante mantém a filha do prefeito como refém. Oh não! ela está protegida por uma turba de zumbis" +
                ". É então que sua batalha se inicia...\n");
    }

    @Override
    public void interageComPersonagem(Personagem personagem) {
        ataque = dado.nextInt(1, 8);
        personagem.pv -= ataque;
        System.out.println(personagem.getNome() + " recebeu " + ataque + " de dano\nVida total: " + personagem.getPv() + "\n");
    }
}
