final public class Espada extends Item{
    public Espada() {
        super("Espada", "Causa +2 de dano", 1,60);
    }

    @Override
    public int gerarEfeito() {
        return 2;
    }
}
