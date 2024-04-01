//Pacote para organizar classes relacionadas
//Pacotes em Java ajudam a organizar o código de forma lógica e evitam conflitos de nomeação.
package com.calculator;

//Declaração da classe Calculator, que é pública e pode ser acessada de qualquer lugar.
//Serve como ponto de entrada para uma aplicação
public class AppCalculator {

    //constante PARAMETER_COUNT especifica o número esperado de argumentos de linha de comando
    //(3 no total: operação, número1, número2).
    public static final int PARAMETER_COUNT = 3;

    //código de saída ERROR_MISSING_PARAMETERS para ser usado caso o número de parâmetros fornecidos seja insuficiente.
    public static final int ERROR_MISSING_PARAMETERS = 2;

    //código de saída ERROR_INVALID_NUMBER.
    public static final int ERROR_INVALID_NUMBER = 3;

    //Verifica se o número de argumentos fornecidos (args.length)
    //corresponde ao número esperado de parâmetros (PARAMETER_COUNT).
    public static void main(String[] args) {
        //Se o número de argumentos for insuficiente,
        if (args.length != PARAMETER_COUNT) {
            //imprime uma mensagem solicitando todos os parâmetros necessários
            System.out.println("Favor informar todos os parametros para execução!");
            //e termina o programa usando System.exit com o código de erro ERROR_MISSING_PARAMETERS.
            System.exit(ERROR_MISSING_PARAMETERS);
        }

        //variável idx com -1 para ser usada como índice ao acessar os argumentos de linha de comando.
        int idx = -1;
        //Incrementa idx antes de usar para acessar cada argumento em args,
        //atribuindo os valores respectivamente às variáveis oper, strNum1 e strNum2.
        //Essa técnica permite recuperar sequencialmente a operação e os dois números como strings.
        String oper = args[++idx];
        String strNum1 = args[++idx];
        String strNum2 = args[++idx];

        //Imprime uma mensagem indicando a operação e os números fornecidos.
        System.out.printf("Iniciando operação: %s, %s, %s%n", oper, strNum1, strNum2);

        //Instância da classe Calculator, passando a operação e os números (como strings) para o construtor.
        Calculator calculator = new Calculator(oper, strNum1, strNum2);
        //Chama o método execute na instância de Calculator,
        //que executa a operação matemática especificada e imprime o resultado.
        calculator.execute();
    }
}