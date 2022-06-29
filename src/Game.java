import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        int pontos = 0;
        Scanner input = new Scanner(System.in);
        while (true){
            Random random = new Random();
            int numeroPensado = random.nextInt(6);
            System.out.println("Tente chutar um valor: ");
            int chute = input.nextInt();
            if (chute == numeroPensado){
                pontos += 10;
                System.out.printf("Parabéns, você acertou! o número que eu pensei foi o %d \n", numeroPensado);
                System.out.println("A sua pontuação é: " + pontos);
                break;
            }else if (chute - numeroPensado == -1 || chute - numeroPensado == 1){
                pontos += 5;
                System.out.println("Quase acertou, mas como recopensa vou te dar 5 pontos");
            }else {
                System.out.println("Que pena, você perdeu \n Sua pontuação é: " + pontos + " pontos");
                System.out.println("Deseja jogar novamente ? \n 1 para sim \n2 para não \n");
                int op = input.nextInt();
                if (op == 1){
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
        input.close();
    }
}
