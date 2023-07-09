import java.util.ArrayList;

public abstract class Personagem implements IPersonagem{
    protected String nome;
    protected int idade;
    protected int pm;
    protected int pv;
    protected int pecasOuro;
    protected ArrayList<Item> inventario = new ArrayList<>();

    public Personagem(String nome, int idade, int pm, int pv) {
        setNome(nome);
        setIdade(idade);
        setPm(pm);
        setPv(pv);
        setPecasOuro(100);
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        if(nome.isEmpty() || nome.isBlank()){
            throw new IllegalArgumentException("Nome vazio.");
        }
        this.nome = nome;
        return true;
    }

    public int getIdade() {
        return idade;
    }

    public boolean setIdade(int idade) {
        if(idade < 18){
            throw new IllegalArgumentException("Herói deve ser maior que 18 anos");
        }
        this.idade = idade;
        return true;
    }

    public int getPm() {
        return pm;
    }

    public boolean setPm(int pm) {
        if(pm < 0){
            throw new IllegalArgumentException("Pontos de mana devem ser maiores que zero.");
        }
        this.pm = pm;
        return true;
    }

    public int getPv() {
        return pv;
    }

    public boolean setPv(int pv) {
        this.pv = pv;
        return true;
    }

    public int getPecasOuro() {
        return pecasOuro;
    }

    public boolean setPecasOuro(int pecasOuro) {
        if(this.pecasOuro < 0){
            throw new IllegalArgumentException("Peças de ouro menor que zero");
        }
        this.pecasOuro = pecasOuro;
        return true;
    }

    @Override
    public abstract void contarHistoria();

    @Override
    public abstract void poderEspecial(Inimigo inimigo);

    @Override
    public void adicionarItem(Item item){
        if(!inventario.contains(item)){
            inventario.add(item);
        }
        else {
            Item itemClone = inventario.get(inventario.indexOf(item));
            inventario.remove(item);
            itemClone.setQuantidade(itemClone.getQuantidade() + 1);
            inventario.add(itemClone);
        }
    }

    public abstract void atacar(Inimigo inimigo);

}
