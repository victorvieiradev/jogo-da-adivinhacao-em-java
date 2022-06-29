import java.util.*;

public class Game {
    public static void main(String[] args) {
        List<Integer> acertou = new ArrayList<>();
        List<Integer> errou = new ArrayList<>();
        Random random = new Random();
        int numeroPensado = random.nextInt(6);
        int pontos = 0;
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Tente chutar um valor: ");
            int chute = input.nextInt();
            if (chute == numeroPensado){
                pontos += 10;
                acertou.add(chute);
                System.out.printf("Parabéns, você acertou! o número que eu pensei foi o %d \n", numeroPensado);
                System.out.println("A sua pontuação é: " + pontos);

                System.out.println("Deseja jogar novamente ? \n 1 para sim \n2 para não \n");
                int op = input.nextInt();
                if (op == 1){
                    numeroPensado = random.nextInt(6);
                    continue;
                }else if (op == 2){
                    System.out.println("Até a próxima, tchau!");
                    break;
                }else {
                    System.out.println("Opção invalida");
                    break;
                }
            }else if (chute - numeroPensado == -1 || chute - numeroPensado == 1){
                errou.add(chute);
                pontos += 5;
                System.out.println("Quase acertou, mas como recopensa vou te dar 5 pontos");
            }else {
                errou.add(chute);
                System.out.println("Que pena, você perdeu \n Sua pontuação é: " + pontos + " pontos");

                System.out.println("Deseja jogar novamente ? \n 1 para sim \n2 para não \n");
                int op = input.nextInt();
                if (op == 1){
                    numeroPensado = random.nextInt(6);
                    continue;
                }else if (op == 2){
                    System.out.println("Até a próxima, tchau!");
                    break;
                }else {
                System.out.println("Opção invalida");
                break;
                }


            }
        }
        System.out.println("A sua pontuação é: " + pontos);
        System.out.println("Os números acertados foram: " + acertou.toString());
        System.out.println("Os números errados foram: " + errou.toString());
        input.close();
    }
}
