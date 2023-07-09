import java.util.Random;

public final class PocaoCura extends Item{
    public PocaoCura() {
        super("Poção de cura", "Cura 2d6 de vida.", 1,20);
    }

    @Override
    public int gerarEfeito() {
        Random dado = new Random();
        int cura = Dado.rolarDados(2,6);
        return cura;
    }
}
