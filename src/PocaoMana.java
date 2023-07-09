import java.util.Random;

public final class PocaoMana extends Item{

    public PocaoMana() {
        super("Poção de Mana", "Restaura 2d4 de Mana.", 1, 20);
    }

    @Override
    public int gerarEfeito() {
        Random dado = new Random();
        int mana = Dado.rolarDados(2,4);
        return mana;
    }
}
