final public class Armadura extends Item{
    public Armadura() {
        super("Armadura", "Concede +10 de vida", 1,80);
    }

    @Override
    public int gerarEfeito() {
        return 10;
    }
}

