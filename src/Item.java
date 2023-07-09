import java.util.Objects;

public class Item {
    private String nome;
    private String descricao;
    private int quantidade;

    public Item(String nome, String descricao, int quantidade) {
        setNome(nome);
        setDescricao(descricao);
        setQuantidade(quantidade);
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

    public String getDescricao() {
        return descricao;
    }

    public boolean setDescricao(String descricao) {
        if(descricao.isEmpty() || descricao.isBlank()){
            throw new IllegalArgumentException("Descrição vazia.");
        }
        this.descricao = descricao;
        return true;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean setQuantidade(int quantidade) {
        if(quantidade < 0){
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.quantidade = quantidade;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(nome, item.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
