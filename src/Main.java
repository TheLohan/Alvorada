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
        Jogo.contarHistoria();
        System.out.println("Os querreiros disponíveis para enfrentar essa aventura são: \n");
        vencya.contarHistoria();
        dorivan.contarHistoria();
        //Escolha do personagem
        int escolhaPersonagem = Jogo.escolherPersonagem();

        switch (escolhaPersonagem){
            case 1:
                Jogo.comprarItem(vencya);
                Jogo.start(esqueleto, zumbi, necromante, vencya);
                break;
            case 2:
                Jogo.comprarItem(dorivan);
                Jogo.start(esqueleto, zumbi, necromante, dorivan);
                break;
        }
    }
}