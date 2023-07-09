import java.util.Scanner;

final public class Jogo {
    private Esqueleto esqueleto;
    private Zumbi zumbi;
    private Necromante necromante;
    private Personagem personagem;

    private Scanner scanner = new Scanner(System.in);

    public Jogo(Esqueleto esqueleto, Zumbi zumbi, Necromante necromante, Personagem personagem) {
        this.esqueleto = esqueleto;
        this.zumbi = zumbi;
        this.necromante = necromante;
        this.personagem = personagem;
    }

    public void start(){
        boolean foiSucesso = true;
        Inimigo[] inimigos = {esqueleto, zumbi, necromante};
        int escolha;
        for(int i = 0; i < 3; i++){
            inimigos[i].contaHistoria(personagem);
            do{
                System.out.println("Digite 1 para atacar \nDigite 2 para usar o poder especial");
                do{
                    escolha = scanner.nextInt();
                }while (escolha != 1 && escolha != 2);
                if(escolha == 1){
                    personagem.atacar(inimigos[i]);
                }
                if(escolha == 2){
                    personagem.poderEspecial(inimigos[i]);
                }
                if(inimigos[i].getPv() > 0){
                    inimigos[i].interageComPersonagem(personagem);
                }
                if(personagem.getPv() < 0){
                    foiSucesso = false;
                    break;
                }
            }while(inimigos[i].getPv() > 0);
        }
        if(foiSucesso){
            System.out.println("vc venceu");
        }
        else if(!foiSucesso) {
            System.out.println(personagem.getNome() + " foi devorade por uma horda de mortos-vivos, o\n" +
                    "necromante espalhou sua influência pelo mundo e ficou mais poderoso.");
        }
    }
}
