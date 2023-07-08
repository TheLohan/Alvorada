import java.util.*;
final public class Esqueleto extends Inimigo implements IObstaculo{
    public Esqueleto(){
        super(15, "Esqueleto");
    }

    @Override
    public void interageComPersonagem(Personagem personagem) {
        ataque = dado.nextInt(1, 4);
        personagem.pv -= ataque;
        System.out.println(personagem.getNome() + " recebeu " + ataque + " de dano\nVida total: " + personagem.getPv() + "\n");
    }

    @Override
    public void contaHistoria(Personagem personagem) {
        System.out.println(personagem.getNome() + " chega até a vila e se depara com uma horda de esqueletos bem na " +
                "entrada do local. É então que sua batalha se inicia...\n");
    }
}
