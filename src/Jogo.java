import java.util.InputMismatchException;
import java.util.Scanner;

final public class Jogo {

    private static Scanner scanner = new Scanner(System.in);

    public static void contarHistoria(){
        System.out.println("\n" +
                "   ▄████████  ▄█        ▄█    █▄   ▄██████▄     ▄████████    ▄████████ ████████▄     ▄████████ \n" +
                "  ███    ███ ███       ███    ███ ███    ███   ███    ███   ███    ███ ███   ▀███   ███    ███ \n" +
                "  ███    ███ ███       ███    ███ ███    ███   ███    ███   ███    ███ ███    ███   ███    ███ \n" +
                "  ███    ███ ███       ███    ███ ███    ███  ▄███▄▄▄▄██▀   ███    ███ ███    ███   ███    ███ \n" +
                "▀███████████ ███       ███    ███ ███    ███ ▀▀███▀▀▀▀▀   ▀███████████ ███    ███ ▀███████████ \n" +
                "  ███    ███ ███       ███    ███ ███    ███ ▀███████████   ███    ███ ███    ███   ███    ███ \n" +
                "  ███    ███ ███▌    ▄ ███    ███ ███    ███   ███    ███   ███    ███ ███   ▄███   ███    ███ \n" +
                "  ███    █▀  █████▄▄██  ▀██████▀   ▀██████▀    ███    ███   ███    █▀  ████████▀    ███    █▀  \n" +
                "             ▀                                 ███    ███                                      \n");
        System.out.println("A Vila de Yu’Myriin, é o mais recente alvo das grandes hordas de mortos-vivos que têm " +
                "infestado os vilarejos locais. \nO prefeito da vila, aterrorizado com a quantidade de monstros, está " +
                "contratando guerreiros habilidosos para lidar com a infestação, \npagando uma boa quantia em dinheiro " +
                "para o corajoso que aceitar o trabalho.\n");
    }

    public static int escolherPersonagem(){
        boolean erro;
        int escolhaPersonagem = 0;
        System.out.println("Olá jogador, escolha seu personagem: " +
                "\nDigite 1 para jogar com a Vencya, A Guerreira" +
                "\nDigite 2 para jogar com Dorivan, O Clérigo");

        do {
            erro = false;
            try{
                escolhaPersonagem = scanner.nextInt();
                if(escolhaPersonagem != 1 && escolhaPersonagem != 2){
                    throw new EscolhaPersonagemException("Você deve entrar com um personagem válido");
                }
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Entrada inválida");
                erro = true;
            }catch (EscolhaPersonagemException e){
                System.out.println(e.getMessage());
                erro = true;
            }
            catch (Exception e){
                System.out.println("Erro");
                erro = true;
            }
        } while (erro);
        return escolhaPersonagem;
    }

    public static void comprarItem(Personagem personagem){
        boolean erro;
        int escolha = 1;
        System.out.println("\nO prefeito lhe deu 100 peças de ouro adiantado para você se preparar. O que quer comprar?");
        System.out.println("1 - Espada aprimorada - Concede +2 de dano - 60 Peças de Ouro");
        System.out.println("2 - Armadura aprimorada - concede +10 de vida - 80 Peças de Ouro");
        System.out.println("3 - Poção de Cura - Cura 2d6 de vida - 10 Peças de Ouro");
        System.out.println("4 - Poção de mana - Restaura 2d4 de mana - 10 Peças de ouro");
        System.out.println("Digide 0 se quiser parar de comprar");
        do{
            erro = false;
            try {
                System.out.println("\nPeças de ouro restantes: " + personagem.getPecasOuro());
                System.out.println("Vou querer: ");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1 -> personagem.adicionarItem(new Espada());
                    case 2 -> personagem.adicionarItem(new Armadura());
                    case 3 -> personagem.adicionarItem(new PocaoCura());
                    case 4 -> personagem.adicionarItem(new PocaoMana());
                }
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Entrada inválida");
                erro = true;
            }catch (Exception e){
                System.out.println("Erro");
                erro = true;
            }
        }while((personagem.getPecasOuro() >= 10 && escolha != 0) || erro);
    }
    public static void start(Esqueleto esqueleto, Zumbi zumbi, Necromante necromante, Personagem personagem){
        boolean foiSucesso = true, erro;
        Inimigo[] inimigos = {esqueleto, zumbi, necromante};
        int escolha;
        for(int i = 0; i < 3; i++){
            inimigos[i].contaHistoria(personagem);
            do{
                erro = false;
                try {
                    System.out.println("Digite 1 para atacar\nDigite 2 para usar o poder especial\nDigite 3 para usar um item");
                    do {
                        escolha = scanner.nextInt();
                    } while (escolha != 1 && escolha != 2 && escolha != 3);
                    if (escolha == 1) {
                        personagem.atacar(inimigos[i]);
                    }
                    if (escolha == 2) {
                        personagem.poderEspecial(inimigos[i]);
                    }
                    if (escolha == 3) {
                        personagem.usarItem();
                    }
                    if (inimigos[i].getPv() > 0) {
                        inimigos[i].interageComPersonagem(personagem);
                    }
                    if (personagem.getPv() < 0) {
                        foiSucesso = false;
                        break;
                    }
                }catch (InputMismatchException e){
                    scanner.nextLine();
                    System.out.println("Entrada inválida");
                    erro = true;
                }catch (Exception e){
                    System.out.println("Erro");
                    erro = true;
                }
            }while(inimigos[i].getPv() > 0);
            if(!foiSucesso){
                break;
            }
        }
        if(foiSucesso){
            System.out.println(personagem.getNome()+" venceu o necromante, o banindo deste mundo. Casou-se" +
                    "com a filha do prefeito, e foi reconhecido(a) como herói/heroína por todo o reino.");
        }
        else if(!foiSucesso) {
            System.out.println(personagem.getNome() + " foi devorado(a) por uma horda de mortos-vivos, " +
                    "o necromante espalhou sua influência pelo mundo e ficou ainda mais poderoso.");
        }
    }
}
