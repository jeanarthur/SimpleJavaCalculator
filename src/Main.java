import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            printOperationsMenu();
            String[] validOperationChoices = {"1", "2", "3", "4"};
            String userChoice = getUserChoice("Digite o nº correspondente a uma operação: ", validOperationChoices);
            doOperation(userChoice);

            String[] validResponses = {"S", "N", "s", "n"};
            userChoice = getUserChoice("Deseja fazer outra operação? (S/N)", validResponses);
            if (userChoice.equalsIgnoreCase("n")) { break; }
        }
    }
    
    public static void printOperationsMenu(){
        print("+================+");
        print("| 1. Somar       |");
        print("| 2. Subtrair    |");
        print("| 3. Multiplicar |");
        print("| 4. Dividir     |");
        print("+================+");
    }
    
    public static String getUserChoice(String message, String[] validChoices){
        String userInput = null;
        boolean isValidChoice = false;
        
        while(!isValidChoice){
            userInput = getInput(message);
            for (String choice: validChoices){
                if (choice.equals(userInput)){ isValidChoice = true; break; }
            }
            if (!isValidChoice) { print("Opção inválida!"); }
        }
        
        return userInput;
    }
    
    public static void doOperation(String operationIndex){
        switch (operationIndex) {
            case "1" -> print("Resultado da soma: " + sum(getValues(getValuesAmount())));
            case "2" -> print("Resultado da subtração: " + subtract(getValues(getValuesAmount())));
            case "3" -> print("Resultado da multiplicação: " + multiply(getValues(getValuesAmount())));
            case "4" -> print("Resultado da divisão: " + divide(getValues(getValuesAmount())));
        }
    }

    public static int[] getValues(int valuesAmount){
        int[] values = new int[valuesAmount];
        for (int i = 0; i < valuesAmount; i++){
            values[i] = getIntegerInput(String.format("Digite o %dº número: ", i+1));
        }
        return values;
    }
    
    public static int getValuesAmount(){
        int valuesAmount;

        do {
            valuesAmount = getIntegerInput("Deseja quantos números na equação?");
            print("Valor inválido!");
        } while (valuesAmount <= 0);

        return valuesAmount;
    }
    
    public static int sum(int[] values){
        int result = 0;
        for(int value: values){
            result += value;
        }
        return result;
    }

    public static int subtract(int[] values){
        int result = values[0];
        int i = 0;
        for(int value: values){
            if (i++ != 0) { result -= value; }
        }
        return result;
    }

    public static int multiply(int[] values){
        int result = 1;
        for(int value: values){
            result *= value;
        }
        return result;
    }

    public static int divide(int[] values){
        int result = values[0];
        int i = 0;
        for(int value: values){
            if (i++ != 0) { result /= value; }
        }
        return result;
    }
    
    public static String getInput(String message){
        Scanner scanner = new Scanner(System.in);
        print(message);
        return scanner.nextLine();
    }

    public static int getIntegerInput(String message){
        int userInput;

        while (true){
            try {
                userInput = Integer.parseInt(getInput(message));
                break;
            } catch (Exception ex){
                print("Valor inválido!");
            }
        }

        return userInput;
    }

    public static void print(String message){
        System.out.println(message);
    }
    
}