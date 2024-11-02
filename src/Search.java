public class Search {

    public Currency searchCoins(int optionCoin, int amount){
        Converter converter = new Converter();

        return switch (optionCoin) {
            case 1 ->
                //De dólar a peso argentino
                    converter.convertCoin("USD", "ARS", amount); // Salir del switch
            case 2 ->
                //De peso argentino a dólar
                    converter.convertCoin("ARS", "USD", amount); // Salir del switch
            case 3 ->
                //De dólar brasileño a dólar
                    converter.convertCoin("BRL", "USD", amount);

            case 4 ->
                //De dólar a dólar brasileño
                    converter.convertCoin("USD", "BRL", amount);

            case 5 ->
                //De dólar a peso colombiano
                    converter.convertCoin("USD", "COP", amount);

            case 6 ->
                //De peso colombiano a dólar
                    converter.convertCoin("COP", "USD", amount);
            default -> null;

        };

        };

}

