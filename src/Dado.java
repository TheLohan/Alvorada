import java.util.Random;

public class Dado {
    public static int rolarDados(int quantidade, int face){
        Random random = new Random();
        int resultado = 0;
        for(int i = 0; i < quantidade; i++ ){
            resultado += random.nextInt(1,face);
        }
        return resultado;
    }
}
