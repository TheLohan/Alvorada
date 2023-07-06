public abstract class Inimigo implements IObstaculo{
    protected int pv;

    public Inimigo(int pv) {
        setPv(pv);
    }

    public int getPv() {
        return pv;
    }

    public boolean setPv(int pv) {
        this.pv = pv;
        return true;
    }

    @Override
    public abstract void interageComPersonagem(Personagem personagem);

}
