final public class Necromante extends Inimigo implements IObstaculo{
    public Necromante(int pv, String nome) {
        super(30, "Necromante");
    }

    @Override
    public void contaHistoria(Personagem personagem) {
        System.out.println(personagem.getNome() + " derrota dezenas de zumbis até conseguir entrar na torre, onde o necromante está se escondendo " +
                ", até que o vilão se mostra ameaçando a filha do prefeito. É então que sua batalha se inicia...\n");
    }

    @Override
    public void interageComPersonagem(Personagem personagem) {
        ataque = dado.nextInt(1, 12);
        personagem.pv -= ataque;
        System.out.println(personagem.getNome() + " recebeu " + ataque + " de dano necrótico\nVida total: " + personagem.getPv() + "\n");
    }
}
