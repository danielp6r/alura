import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double mediaAvaliacao = 0;
        double nota = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite a avaliação número " + (i+1));
            nota = leitura.nextDouble();
            mediaAvaliacao += nota;
        }
        mediaAvaliacao = mediaAvaliacao / 3;
        System.out.println("Média :" + mediaAvaliacao);
    }

}
