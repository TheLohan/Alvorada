import java.util.*;

public abstract class Inimigo implements IObstaculo{
    protected int pv;
    protected String nome;

    protected int ataque;
    protected Random dado = new Random();

    public Inimigo(int pv, String nome) {
        setPv(pv);
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        this.nome = nome;
        return true;
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
