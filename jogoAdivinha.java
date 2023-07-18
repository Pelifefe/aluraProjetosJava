package com.mycompany.projetoaluraajava;
import java.util.Scanner;
import java.util.Random;

public class jogoAdvinha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seja bem-vindo ao jogo de adivinhação!");
        
        int numeroAleatorio = new Random().nextInt(100);
        int contador = 0;
        int chute;

        for(int i = 0; i < 5; i++) {
            System.out.println("Digite o número do seu chute: ");
            chute = scanner.nextInt();
            
            if(chute == numeroAleatorio) {
                System.out.println("Parabénbs, acertou em cheio!");
                break;
            } else if(chute > numeroAleatorio) {
                System.out.println("O seu chute foi maior que o número pensado...");
            } else {
                System.out.println("O seu chute foi menor que o número pensado...");
            }
        }
    }
}
