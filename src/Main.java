import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Search search = new Search();
        Scanner scanner = new Scanner(System.in);
        boolean quitMenu = true;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Currency> listHistory = new ArrayList<>();
        System.out.println(" ---------- BIENVENIDO AL CONVERSOR DE MONEDA --------- ");
        while(quitMenu) {
            System.out.println("""
                   
                    ** Por favor seleccione una opción **
                        1 - Dólar ===> Peso argentino
                        2 - Peso argentino ===> Dólar
                        3 - Dólar brasileño ===> Dólar
                        4 - Dólar ===> Dolar brasileño
                        5 - Dólar ===> Peso colombiano
                        6 - Peso colombiano ===> Dólar
                        
                        7 - Ver historial de conversion
                        8 - Salir
                        
                    """);

            int numberMenu = Integer.parseInt(scanner.nextLine());
            if (numberMenu == 8){
                quitMenu = false;
            }else if (numberMenu == 7){
                if (!listHistory.isEmpty()){
                System.out.println("----- HISTORIAL DE RESULTADOS----- ");
                for (int i = 0; i < listHistory.size(); i++) {
                    System.out.println(i+" - "+listHistory.get(i).conversion_result());
                }}else{
                    System.out.println("Aún no se han realizado operaciones");
                }
            }else{
                System.out.println("Por favor introduzca el monto que desea convertir");
                int amountEntered = Integer.parseInt(scanner.nextLine());
                Currency currency = search.searchCoins(numberMenu,amountEntered);
                listHistory.add(currency);
                System.out.println("---------- MONTO CONVERTIDO EXITOSAMENTE ---------");
                System.out.printf("El monto ingresado de $%d %s equivale actualmente a $%.2f %s %n", amountEntered, currency.base_code(), currency.conversion_result(), currency.target_code());
            }
        }
        try {
            FileWriter writer = new FileWriter("history.json");
            writer.write(gson.toJson(listHistory));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("*** GRACIAS POR UTILIZAR EL CONVERSOR DE MONEDAS ***");
    }
}