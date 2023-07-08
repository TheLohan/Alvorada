import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Personagem dorivan = new Dorivan();
        Personagem vencya = new Vencya();
        Inimigo esqueleto = new Esqueleto();

        System.out.println("   ▄████████  ▄█        ▄█    █▄   ▄██████▄     ▄████████    ▄████████ ████████▄     ▄████████ \n" +
                            "  ███    ███ ███       ███    ███ ███    ███   ███    ███   ███    ███ ███   ▀███   ███    ███ \n" +
                            "  ███    ███ ███       ███    ███ ███    ███   ███    ███   ███    ███ ███    ███   ███    ███ \n" +
                            "  ███    ███ ███       ███    ███ ███    ███  ▄███▄▄▄▄██▀   ███    ███ ███    ███   ███    ███ \n" +
                            "▀███████████ ███       ███    ███ ███    ███ ▀▀███▀▀▀▀▀   ▀███████████ ███    ███ ▀███████████ \n" +
                            "  ███    ███ ███       ███    ███ ███    ███ ▀███████████   ███    ███ ███    ███   ███    ███ \n" +
                            "  ███    ███ ███▌    ▄ ███    ███ ███    ███   ███    ███   ███    ███ ███   ▄███   ███    ███ \n" +
                            "  ███    █▀  █████▄▄██  ▀██████▀   ▀██████▀    ███    ███   ███    █▀  ████████▀    ███    █▀  \n" +
                            "             ▀                                 ███    ███                                      \n");


        //História do jogo
        System.out.println("A Vila de Yu’Myriin, é o mais recente alvo das grandes hordas de mortos-vivos que têm " +
                "infestado os vilarejos locais. \nO prefeito da vila, aterrorizado com a quantidade de monstros, está " +
                "contratando guerreiros habilidosos para lidar com a infestação, \npagando uma boa quantia em dinheiro " +
                "para o corajoso que aceitar o trabalho.\n");


        System.out.println("Os querreiros disponíveis para enfrentar essa aventura são: \n");
        vencya.contarHistoria();
        dorivan.contarHistoria();

        //Escolha do personagem
        int escolhaPersonagem = 0;
        boolean erro;
        System.out.println("Olá jogador, escolha seu personagem. " +
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

        switch (escolhaPersonagem){
            case 1:
                esqueleto.contaHistoria(vencya);
                esqueleto.interageComPersonagem(vencya);
                vencya.atacar(esqueleto);
                vencya.poderEspecial(esqueleto);
                break;
            case 2:
                esqueleto.contaHistoria(dorivan);
                esqueleto.interageComPersonagem(dorivan);
                dorivan.poderEspecial(esqueleto);
                dorivan.atacar(esqueleto);
                break;
        }
    }
}