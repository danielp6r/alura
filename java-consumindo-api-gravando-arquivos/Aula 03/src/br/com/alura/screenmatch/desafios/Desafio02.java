package br.com.alura.screenmatch.desafios;

import java.util.Scanner;

public class Desafio02 {
    public static void main(String[] args) {
        //02 - Crie um programa que lê uma senha do usuário. Utilize o bloco try/catch para capturar a exceção
        //SenhaInvalidaException, uma classe de exceção personalizada que deve ser lançada caso a senha não atenda
        //a critérios específicos (por exemplo, ter pelo menos 8 caracteres).

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        try {
            if (senha.length() < 8) {
                throw new SenhaInvalidaException("A senha deve ter pelo menos 8 caracteres.");
            }
            System.out.println("Senha válidada.");
        } catch (SenhaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
