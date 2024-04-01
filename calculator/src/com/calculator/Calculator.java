//pacote para organizar classes relacionadas
package com.calculator;

//Classe Calculator, que é pública e pode ser acessada de qualquer lugar.
public class Calculator {
    //constantes para cada tipo de operação
    public static final String OPER_SUM = "SOMA";
    public static final String OPER_SUBTRACT = "SUBTRACAO";
    public static final String OPER_MULTIPLY = "MULTIPLICACAO";
    public static final String OPER_DIVIDE = "DIVISAO";

    //variáveis de instância para armazenar a operação a ser executada
    private String oper;
    private int num1;
    private int num2;

    //método isNumber verifica se uma string pode ser convertida em um número.
    private static boolean isNumber(String sNum)  {
        //Tenta converter a string sNum para um inteiro.
        try {
            Integer.parseInt(sNum);
            return true;
            //Se for bem-sucedido, retorna true;
        } catch (NumberFormatException ex) {
            //Caso contrário, captura a exceção NumberFormatException.
            System.err.println("Falha ao converter para numero: " + ex.getMessage());
            return false;
            //Se a conversão falhar, imprime uma mensagem de erro e retorna false
        }
    }

    //O construtor da classe Calculator, que aceita a operação e dois números (como strings) como argumentos
    public Calculator(String oper, String strNum1, String strNum2) {
        //Converte a operação para maiúsculas para padronização e facilita a comparação de strings.
        this.oper = oper.toUpperCase();
        //Método isNumber para verificar se strNum1 e strNum2 são números válidos.
        if (!isNumber(strNum1)) {
            System.exit(AppCalculator.ERROR_INVALID_NUMBER);
            // Se não for, encerra o programa.
            return;
        }

        if (!isNumber(strNum2)) {
            System.exit(AppCalculator.ERROR_INVALID_NUMBER);
            return;

        }
        //Converte strNum1 e strNum2 para inteiros e inicializa as variáveis num1 e num2
        this.num1 = Integer.parseInt(strNum1);
        this.num2 = Integer.parseInt(strNum2);
        //Imprime uma mensagem indicando que a calculadora foi inicializada com sucesso
        System.out.println("Calculadora inicializada com sucesso");
    }

    //Método execute, que não retorna nenhum valor e é responsável por executar a operação especificada.
    public void execute(){
        //Verifica se a operação é soma. Se for, calcula a soma de num1 e num2
        if (oper.equals(OPER_SUM)) {
            //Calcula a soma e imprime o resultado.
            int sum = num1 + num2;
            System.out.printf("A soma de %s + %s é igual a %s%n", num1, num2, sum);
        } else if (oper.equals(OPER_SUBTRACT)) {
            int subtract = num1 - num2;
            System.out.printf("A subtração de %s - %s é igual a %s%n", num1, num2, subtract);
        } else if (oper.equals(OPER_MULTIPLY)) {
            int multiply = num1 * num2;
            System.out.printf("A multiplicação de %s * %s é igual a %s%n", num1, num2, multiply);
        } else if (oper.equals(OPER_DIVIDE)) {
            if (num2 == 0) {
                System.out.println("Erro: Divisão por zero não é permitida.");
            } else {
                int divide = num1 / num2;
                System.out.printf("A divisão de %s / %s é igual a %s%n", num1, num2, divide);
            }
        } else {
            System.out.printf("Operação [%s] não suportada %n", oper);
        }
    }
}

