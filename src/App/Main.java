package App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        // instancia o scanner
        Scanner sc = new Scanner(System.in);

        // cria o map
        Map<String, Integer> votes = new LinkedHashMap<>();

        // solicita que o usuario entre com o caminho
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        // tenta fazer a leitura do arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            // define a linha do arquivo
            String line = br.readLine();
            
            // estrutura 'Faça Enquanto' linha for diferente de vazio
            while (line != null) {

                // criar um vetor chamado fields que vai separar os valores pelo delimitador 'virgula'
                String[] fields = line.split(",");
                
                // variavel name que armazena o valor da posição 0, que seria o primeiro valor
                String name = fields[0];
                
                // variavel count que armazena o valor da posição 1, que seria o segundo valor
                int count = Integer.parseInt(fields[1]);

                // se dentro do map conter a chave nome faça isso
                if (votes.containsKey(name)) {
                    int votesSoFar = votes.get(name);
                    votes.put(name, count + votesSoFar);
                } else {
                    votes.put(name, count);
                }

                line = br.readLine();
            }

            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

}
