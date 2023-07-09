import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Personagem dorivan = new Dorivan();
        Personagem vencya = new Vencya();
        Esqueleto esqueleto = new Esqueleto();
        Zumbi zumbi = new Zumbi();
        Necromante necromante = new Necromante();

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

        System.out.println("O prefeito lhe deu 100 peças de ouro adiantado para você se preparar. O que quer comprar?");
        System.out.println("Espada aprimirada - Concede +2 de dano - 50 Peças de Ouro");
        System.out.println("Armadura aprimorada - Ignora 2 de dano - 80 Peças de Ouro");
        System.out.println("Poção de Cura - Cura 1d6 de vida - 20 Peças de Ouro");
        System.out.println("Poção de mana - Restaura 1d4 de mana - 20 Peças de ouro");

        switch (escolhaPersonagem){
            case 1:
                Jogo.start(esqueleto, zumbi, necromante, vencya);
                break;
            case 2:
                Jogo.start(esqueleto, zumbi, necromante, dorivan);
                break;
        }
    }
}