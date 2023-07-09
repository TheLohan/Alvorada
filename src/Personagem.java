import java.util.ArrayList;
import java.util.Scanner;

public abstract class Personagem implements IPersonagem{
    protected String nome;
    protected int idade;
    protected int pm;
    protected int pv;
    protected int pecasOuro;
    protected int ataqueAdicional;
    protected ArrayList<Item> inventario = new ArrayList<>();

    public Personagem(String nome, int idade, int pm, int pv) {
        setNome(nome);
        setIdade(idade);
        setPm(pm);
        setPv(pv);
        setPecasOuro(100);
        ataqueAdicional = 0;
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
            pecasOuro -= item.getPreco();
            inventario.add(item);
            if(item instanceof Espada){
                ataqueAdicional += item.gerarEfeito();
            }
            else if (item instanceof Armadura){
                pv += item.gerarEfeito();
            }
        }
        else {
            pecasOuro -= item.getPreco();
            Item itemClone = inventario.get(inventario.indexOf(item));
            inventario.remove(item);
            itemClone.setQuantidade(itemClone.getQuantidade() + 1);
            inventario.add(itemClone);
        }
    }

    public void imprimirInventario(){
        for(Item item : inventario){
            System.out.println(item.getNome());
        }
    }

    public void usarItem(){
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        for(Item item : inventario){
            if(item instanceof PocaoCura || item instanceof PocaoMana){
                System.out.println("Digite " + i+ " para usar " + item.getNome() + "- Quantidade: " + item.getQuantidade());
                i++;
            }
        }
        int escolha = scanner.nextInt();
    }
    public abstract void atacar(Inimigo inimigo);

}
