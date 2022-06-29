import java.util.*;

public class Game {
    public static final int NUMERO_MAXIMO_DO_SORTEIO = 6;
    public static void main(String[] args) {
        List<Integer> acertou = new ArrayList<>();
        List<Integer> errou = new ArrayList<>();
        int pontos = 0;
        boolean startGame = true;
        Scanner input = new Scanner(System.in);
        while (startGame){
            int numeroPensado = getNumeroPensado();
            System.out.println("Tente chutar um valor: ");
            int chute = input.nextInt();
            int pontosTemporarios = validaPontos(numeroPensado, chute);
            pontos += pontosTemporarios;
            startGame = continuarJogo(pontosTemporarios);
            if (startGame == false){
                startGame = msg(acertou, errou, pontos);
            }
        }
        input.close();
    }

    private static boolean msg(List<Integer> acertou, List<Integer> errou, int pontos) {
        Scanner input = new Scanner(System.in);
        System.out.println("A sua pontuação é: " + pontos);
        System.out.println("Os números acertados foram: " + acertou.toString());
        System.out.println("Os números errados foram: " + errou.toString());
        System.out.println("Deseja jogar novamente? S | N");
        String op = input.next();
        if (op.equalsIgnoreCase("s")){
            return  true;
        }
        return  false;

    }

    private static int getNumeroPensado() {
        Random random = new Random();
        return random.nextInt(NUMERO_MAXIMO_DO_SORTEIO);
    }
    private static int validaPontos(int numeroPensado, int chute){
        if (chute == numeroPensado){
            return  10;
        }
        if (chute - numeroPensado == -1 || chute - numeroPensado == 1){
            return  5;
        }
        return  0;
    }
    private  static  boolean continuarJogo(int pontos){
        if (pontos == 0){
            return false;
        }
        return  true;
    }
}
