import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroPensado = random.nextInt(6);
        boolean acertou = false;
        int pontos = 0;
        Scanner input = new Scanner(System.in);
        while (acertou == false){
            System.out.println("Tente chutar um valor: ");
            int chute = input.nextInt();
            if (chute == numeroPensado){
                pontos += 10;
                System.out.printf("Parabéns, você acertou! o número que eu pensei foi o %d", numeroPensado);
                acertou = true;
            }
        }
        input.close();
    }
}
