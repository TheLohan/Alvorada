import java.util.Scanner;

final public class Jogo {
    public static void start(Esqueleto esqueleto, Zumbi zumbi, Necromante necromante, Personagem personagem){
        boolean foiSucesso = true;
        Inimigo[] inimigos = {esqueleto, zumbi, necromante};
        int escolha;
        Scanner scanner = new Scanner(System.in);
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
            if(!foiSucesso){
                break;
            }
        }
        if(foiSucesso){
            System.out.println(personagem.getNome()+" venceu o necromante, o banindo deste mundo. Casou-se\n" +
                    "com a filha do prefeito, e foi reconhecido(a) como herói/heroína por todo o reino.");
        }
        else if(!foiSucesso) {
            System.out.println(personagem.getNome() + " foi devorade por uma horda de mortos-vivos, o\n" +
                    "necromante espalhou sua influência pelo mundo e ficou mais poderoso.");
        }
    }
}
