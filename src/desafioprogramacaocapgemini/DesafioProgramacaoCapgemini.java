package desafioprogramacaocapgemini;

import java.util.regex.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class DesafioProgramacaoCapgemini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int questao = 0;
        do {
            System.out.println("=========================================================");
            System.out.println("                    DESAFIO CAPGEMINI");
            System.out.println("=========================================================");
            System.out.println("1 - Quantidade 'n' de Degraus de uma Escada");
            System.out.println("2 - Validador de Senha");
            System.out.println("3 - Quantidade de Pares de Anagramas em uma palavra");
            System.out.println("0 - Sair do Sistema");
            System.out.println("=========================================================");
            System.out.print("Selecione a questão que gostaria de resolver: ");
            questao = scanner.nextInt();
            switch (questao) {
                case 0:
                    System.out.println("");
                    System.out.println("Sistema finalizado.");
                    break;
                case 1:
                    System.out.println("");
                    System.out.print("Informe o numero de degraus da escada: ");
                    int numeroDegraus = scanner.nextInt();
                    escada(numeroDegraus);
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("Escreva sua senha: ");
                    String senha = scanner.next();
                    verificarSenha(senha);
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    System.out.print("Informe uma palavra: ");
                    String palavra = scanner.next();
                    quantidadeAnagramas(palavra);
                    System.out.println("");
                    break;
                default:
                    System.out.println("");
                    System.out.println("Favor informar o número de uma questão valida.");
                    break;
            }
            System.out.println("");

        } while (questao != 0);
    }

    //Questão 1
    /**
     * método que mostra na tela uma escada de quantidade "n" informada pelo
     * usuário utilizando o caractere "*" e espaços
     *
     * @param numeroDegraus Quantidade de degraus informada pelo usuário
     */
    public static void escada(int numeroDegraus) {
        System.out.println("");

        System.out.println("================================================");
        System.out.println("=                   RESPOSTA                   =");
        System.out.println("================================================");

        String escadaVetor[] = new String[numeroDegraus];
        for (int i = escadaVetor.length - 1; i >= 0; i--) {
            escadaVetor[i] = "*";
            for (int j = 0; j < escadaVetor.length; j++) {
                if (j < i) {
                    escadaVetor[j] = " ";
                }
                System.out.print(escadaVetor[j]);
            }
            System.out.println("");
        }
    }

    //Questão 2
    /**
     * Método utilizado para verificar se uma senha é forte ou não levando em
     * consideração um determinado critério
     *
     * @param senha senha informada pelo usuário para ser verificada
     */
    public static void verificarSenha(String senha) {

        System.out.println("");
        Pattern padrao = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+]).{6,}$");
        Matcher m = padrao.matcher(senha);

        System.out.println("================================================");
        System.out.println("=                   RESPOSTA                   =");
        System.out.println("================================================");

        if (m.matches()) {
            System.out.println("Senha Forte");
        } else {
            if (senha.length() < 6) {
                System.out.println("A senha deve conter no minimo 6 caracteres. Faltam " + (6 - senha.length()) + " caracteres");

            }
            if (!senha.matches(".*[A-Z].*")) {
                System.out.println("A senha deve conter pelo menos um caractere maiusculo");
            }
            if (!senha.matches(".*[a-z].*")) {
                System.out.println("A senha deve conter pelo menos um caractere minusculo");
            }
            if (!senha.matches(".*[0-9].*")) {
                System.out.println("A senha deve conter pelo menos um digito");
            }
            if (!senha.matches(".*[!@#$%^&*()-+].*")) {
                System.out.println("A senha deve conter pelo menos um caractere especial");
            }

        }
    }

    //Questão 3
    /**
     * Método Utilizado para verificar quantos anagramas existem um uma
     * determinada palavra.
     *
     * @param palavra Palavra informada pelo usuário.
     */
    public static void quantidadeAnagramas(String palavra) {
        System.out.println("");

        System.out.println("================================================");
        System.out.println("=                   RESPOSTA                   =");
        System.out.println("================================================");

        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < palavra.length(); i++) {
            for (int j = i; j < palavra.length(); j++) {
                char[] listaCaractere = palavra.substring(i, j + 1).toCharArray();
                Arrays.sort(listaCaractere);
                String aux = new String(listaCaractere);

                if (hashMap.containsKey(aux)) {
                    hashMap.put(aux, hashMap.get(aux) + 1);

                } else {
                    hashMap.put(aux, 1);
                }
            }
        }

        int paresDeAnagramas = 0;
        for (String k : hashMap.keySet()) {
            int v = hashMap.get(k);
            paresDeAnagramas += (v * (v - 1)) / 2;
        }

        System.out.println(paresDeAnagramas);
    }

}
