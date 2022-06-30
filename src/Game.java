import java.util.*;
public class Game {
    public static int NUMERO_MAXIMO_DO_SORTEIO = 10;
    public static Set<Integer> acertou = new HashSet<>();
    public static Set<Integer> errou = new HashSet<>();
    public static  int numeroPensado = getNumeroPensado();
    public static void main(String[] args) {
        int pontos = 0;
        boolean startGame = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja aumentar a dificuldade ? S | N");
        String res = input.next();
        if ("s".equalsIgnoreCase(res)){
            NUMERO_MAXIMO_DO_SORTEIO = 20;
        }
        while (startGame){
            System.out.println("Tente chutar um valor: ");
            int chute = input.nextInt();
            pontos += validaPontos(numeroPensado, chute);
            startGame = continuarJogo(validaPontos(numeroPensado, chute));
            if (!startGame){
                startGame = msg(acertou, errou, pontos);
            }
        }
        input.close();
    }
    private static boolean msg(Set<Integer> acertou, Set<Integer> errou, int pontos) {
        Scanner input = new Scanner(System.in);
        System.out.println("Eu pensei no número: " + numeroPensado);
        System.out.println("A sua pontuação é: " + pontos);
        System.out.println("Os números acertados foram: " + acertou.toString());
        System.out.println("Os números errados foram: " + errou.toString());
        System.out.println("Deseja jogar novamente? S | N");
        String op = input.next();
        if ("s".equalsIgnoreCase(op)){
            numeroPensado = getNumeroPensado();
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
            acertou.add(chute);
            return  10;
        }
        if (chute - numeroPensado == -1 || chute - numeroPensado == 1){
            errou.add(chute);
            return  5;
        }
        errou.add(chute);
        return  0;
    }
    private  static boolean continuarJogo(int pontos){
        if (pontos == 0 || pontos == 10){
            return false;
        }
        return  true;
    }
}
