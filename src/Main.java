import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Personagem dorivan = new Dorivan();
        Personagem vencya = new Vencya();

        vencya.contarHistoria();
        dorivan.contarHistoria();

        //TODO: Implementar a história do jogo

        System.out.println("Olá jogador, escolha seu personagem. \nDigite 1 para jogar com a Vencya, A Guerreira\nDigite 2 para jogar com Dorivan, O Clérigo");
        int escolhaPersonagem = scanner.nextInt();
        
    }
}