public class Condicional {
    public static void main(String[] args) {
        int anoDeLancamento = 1990;
        boolean incluidoNoPlano = true;
        double notaDoFilme = 8.1;
        String tipoPlano = "plus";

        if (anoDeLancamento >= 2022) {
            System.out.println("Lançamento");
        } else {
            System.out.println("Filme Retrô");
        }

        if (incluidoNoPlano && tipoPlano .equals("plus")) {
            System.out.println("Liberado");
        } else {
            System.out.println("Deve pagar locação");
        }

    }
}
