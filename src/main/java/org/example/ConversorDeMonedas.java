package org.example;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ConversorDeMonedas {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/b5b6847043625bba7f3d9ce2/latest/";

    // Mapa de monedas y sus nombres completos
    private static final Map<String, String> NOMBRE_MONEDA;

    static {
        NOMBRE_MONEDA = new HashMap<>();
        NOMBRE_MONEDA.put("AED", "Dirham de los Emiratos Árabes Unidos");
        NOMBRE_MONEDA.put("AFN", "Afgani afgano");
        NOMBRE_MONEDA.put("ALL", "Lek albanés");
        NOMBRE_MONEDA.put("AMD", "Dram armenio");
        NOMBRE_MONEDA.put("ANG", "Florín antillano neerlandés");
        NOMBRE_MONEDA.put("AOA", "Kwanza angoleño");
        NOMBRE_MONEDA.put("ARS", "Peso argentino");
        NOMBRE_MONEDA.put("AUD", "Dólar australiano");
        NOMBRE_MONEDA.put("AWG", "Florín arubano");
        NOMBRE_MONEDA.put("AZN", "Manat azerbaiyano");
        NOMBRE_MONEDA.put("BAM", "Marco convertible de Bosnia y Herzegovina");
        NOMBRE_MONEDA.put("BBD", "Dólar de Barbados");
        NOMBRE_MONEDA.put("BDT", "Taka bangladesí");
        NOMBRE_MONEDA.put("BGN", "Lev búlgaro");
        NOMBRE_MONEDA.put("BHD", "Dinar bareiní");
        NOMBRE_MONEDA.put("BIF", "Franco burundés");
        NOMBRE_MONEDA.put("BMD", "Dólar bermudeño");
        NOMBRE_MONEDA.put("BND", "Dólar de Brunéi");
        NOMBRE_MONEDA.put("BOB", "Boliviano");
        NOMBRE_MONEDA.put("BRL", "Real brasileño");
        NOMBRE_MONEDA.put("BSD", "Dólar bahameño");
        NOMBRE_MONEDA.put("BTN", "Ngultrum de Bután");
        NOMBRE_MONEDA.put("BWP", "Pula de Botsuana");
        NOMBRE_MONEDA.put("BYN", "Rublo bielorruso");
        NOMBRE_MONEDA.put("BZD", "Dólar beliceño");
        NOMBRE_MONEDA.put("CAD", "Dólar canadiense");
        NOMBRE_MONEDA.put("CDF", "Franco congoleño");
        NOMBRE_MONEDA.put("CHF", "Franco suizo");
        NOMBRE_MONEDA.put("CLP", "Peso chileno");
        NOMBRE_MONEDA.put("CNY", "Yuan chino");
        NOMBRE_MONEDA.put("CRC", "Colón costarricense");
        NOMBRE_MONEDA.put("CUP", "Peso cubano");
        NOMBRE_MONEDA.put("CVE", "Escudo caboverdiano");
        NOMBRE_MONEDA.put("CZK", "Corona checa");
        NOMBRE_MONEDA.put("DJF", "Franco yibutiano");
        NOMBRE_MONEDA.put("DKK", "Corona danesa");
        NOMBRE_MONEDA.put("DOP", "Peso dominicano");
        NOMBRE_MONEDA.put("DZD", "Dinar argelino");
        NOMBRE_MONEDA.put("EGP", "Libra egipcia");
        NOMBRE_MONEDA.put("ERN", "Nakfa eritreo");
        NOMBRE_MONEDA.put("ETB", "Birr etíope");
        NOMBRE_MONEDA.put("EUR", "Euro");
        NOMBRE_MONEDA.put("FJD", "Dólar fiyiano");
        NOMBRE_MONEDA.put("FKP", "Libra de las Islas Malvinas");
        NOMBRE_MONEDA.put("FOK", "Corona de las Islas Feroe");
        NOMBRE_MONEDA.put("GBP", "Libra esterlina");
        NOMBRE_MONEDA.put("GEL", "Lari georgiano");
        NOMBRE_MONEDA.put("GGP", "Libra de Guernsey");
        NOMBRE_MONEDA.put("GHS", "Cedi ghanés");
        NOMBRE_MONEDA.put("GIP", "Libra de Gibraltar");
        NOMBRE_MONEDA.put("GMD", "Dalasi gambiano");
        NOMBRE_MONEDA.put("GNF", "Franco guineano");
        NOMBRE_MONEDA.put("GTQ", "Quetzal guatemalteco");
        NOMBRE_MONEDA.put("GYD", "Dólar guyanés");
        NOMBRE_MONEDA.put("HKD", "Dólar de Hong Kong");
        NOMBRE_MONEDA.put("HNL", "Lempira hondureño");
        NOMBRE_MONEDA.put("HRK", "Kuna croata");
        NOMBRE_MONEDA.put("HTG", "Gourde haitiano");
        NOMBRE_MONEDA.put("HUF", "Florín húngaro");
        NOMBRE_MONEDA.put("IDR", "Rupia indonesia");
        NOMBRE_MONEDA.put("ILS", "Shekel israelí");
        NOMBRE_MONEDA.put("IMP", "Libra de la Isla de Man");
        NOMBRE_MONEDA.put("INR", "Rupia india");
        NOMBRE_MONEDA.put("IQD", "Dinar iraquí");
        NOMBRE_MONEDA.put("IRR", "Rupia iraní");
        NOMBRE_MONEDA.put("ISK", "Corona islandesa");
        NOMBRE_MONEDA.put("JEP", "Libra de Jersey");
        NOMBRE_MONEDA.put("JMD", "Dólar jamaiquino");
        NOMBRE_MONEDA.put("JOD", "Dinar jordano");
        NOMBRE_MONEDA.put("JPY", "Yen japonés");
        NOMBRE_MONEDA.put("KES", "Shilling keniano");
        NOMBRE_MONEDA.put("KGS", "Som kirguís");
        NOMBRE_MONEDA.put("KHR", "Riel camboyano");
        NOMBRE_MONEDA.put("KID", "Dólar de las Islas Kiribati");
        NOMBRE_MONEDA.put("KMF", "Franco comorense");
        NOMBRE_MONEDA.put("KRW", "Won surcoreano");
        NOMBRE_MONEDA.put("KWD", "Dinar kuwaití");
        NOMBRE_MONEDA.put("KYD", "Dólar de las Islas Caimán");
        NOMBRE_MONEDA.put("KZT", "Tenge kazajo");
        NOMBRE_MONEDA.put("LAK", "Kip laosiano");
        NOMBRE_MONEDA.put("LBP", "Libra libanesa");
        NOMBRE_MONEDA.put("LKR", "Rupia de Sri Lanka");
        NOMBRE_MONEDA.put("LRD", "Dólar liberiano");
        NOMBRE_MONEDA.put("LSL", "Loti de Lesoto");
        NOMBRE_MONEDA.put("LYD", "Dinar libio");
        NOMBRE_MONEDA.put("MAD", "Dirham marroquí");
        NOMBRE_MONEDA.put("MDL", "Leu moldavo");
        NOMBRE_MONEDA.put("MGA", "Ariary malgache");
        NOMBRE_MONEDA.put("MKD", "Denar macedonio");
        NOMBRE_MONEDA.put("MMK", "Kyat birmano");
        NOMBRE_MONEDA.put("MNT", "Tugrik mongol");
        NOMBRE_MONEDA.put("MOP", "Pataca de Macao");
        NOMBRE_MONEDA.put("MRU", "Ouguiya mauritana");
        NOMBRE_MONEDA.put("MUR", "Rupia de Mauricio");
        NOMBRE_MONEDA.put("MVR", "Rufiyaa de Maldivas");
        NOMBRE_MONEDA.put("MWK", "Kwacha malauí");
        NOMBRE_MONEDA.put("MXN", "Peso mexicano");
        NOMBRE_MONEDA.put("MYR", "Ringgit malayo");
        NOMBRE_MONEDA.put("MZN", "Metical mozambiqueño");
        NOMBRE_MONEDA.put("NAD", "Dólar namibio");
        NOMBRE_MONEDA.put("NGN", "Naira nigeriana");
        NOMBRE_MONEDA.put("NIO", "Córdoba nicaragüense");
        NOMBRE_MONEDA.put("NOK", "Corona noruega");
        NOMBRE_MONEDA.put("NPR", "Rupia nepalí");
        NOMBRE_MONEDA.put("NZD", "Dólar neozelandés");
        NOMBRE_MONEDA.put("OMR", "Rial omaní");
        NOMBRE_MONEDA.put("PAB", "Balboa panameño");
        NOMBRE_MONEDA.put("PEN", "Sol peruano");
        NOMBRE_MONEDA.put("PGK", "Kina de Papúa Nueva Guinea");
        NOMBRE_MONEDA.put("PHP", "Peso filipino");
        NOMBRE_MONEDA.put("PKR", "Rupia paquistaní");
        NOMBRE_MONEDA.put("PLN", "Zloty polaco");
        NOMBRE_MONEDA.put("PYG", "Guaraní paraguayo");
        NOMBRE_MONEDA.put("QAR", "Riyal qatarí");
        NOMBRE_MONEDA.put("RON", "Leu rumano");
        NOMBRE_MONEDA.put("RSD", "Dinar serbio");
        NOMBRE_MONEDA.put("RUB", "Rublo ruso");
        NOMBRE_MONEDA.put("RWF", "Franco ruandés");
        NOMBRE_MONEDA.put("SAR", "Riyal saudí");
        NOMBRE_MONEDA.put("SBD", "Dólar de las Islas Salomón");
        NOMBRE_MONEDA.put("SCR", "Rupia seychelense");
        NOMBRE_MONEDA.put("SDG", "Libra sudanesa");
        NOMBRE_MONEDA.put("SEK", "Corona sueca");
        NOMBRE_MONEDA.put("SGD", "Dólar de Singapur");
        NOMBRE_MONEDA.put("SHP", "Libra de Santa Helena");
        NOMBRE_MONEDA.put("SLE", "León de Sierra Leona");
        NOMBRE_MONEDA.put("SLL", "León de Sierra Leona (nuevo)");
        NOMBRE_MONEDA.put("SOS", "Shilling somalí");
        NOMBRE_MONEDA.put("SRD", "Dólar surinamés");
        NOMBRE_MONEDA.put("SSP", "Libra sursudanesa");
        NOMBRE_MONEDA.put("STN", "Dobra de Santo Tomé y Príncipe");
        NOMBRE_MONEDA.put("SYP", "Libra siria");
        NOMBRE_MONEDA.put("SZL", "Lilangeni suazi");
        NOMBRE_MONEDA.put("THB", "Baht tailandés");
        NOMBRE_MONEDA.put("TJS", "Somoni tayiko");
        NOMBRE_MONEDA.put("TMT", "Manat turkmeno");
        NOMBRE_MONEDA.put("TND", "Dinar tunecino");
        NOMBRE_MONEDA.put("TOP", "Paʻanga tongano");
        NOMBRE_MONEDA.put("TRY", "Lira turca");
        NOMBRE_MONEDA.put("TTD", "Dólar de Trinidad y Tobago");
        NOMBRE_MONEDA.put("TVD", "Dólar de Tuvalu");
        NOMBRE_MONEDA.put("TWD", "Dólar nuevo taiwanés");
        NOMBRE_MONEDA.put("TZS", "Shilling tanzano");
        NOMBRE_MONEDA.put("UAH", "Grivna ucraniana");
        NOMBRE_MONEDA.put("UGX", "Shilling ugandés");
        NOMBRE_MONEDA.put("USD", "Dólar estadounidense");
        NOMBRE_MONEDA.put("UYU", "Peso uruguayo");
        NOMBRE_MONEDA.put("UZS", "Som uzbeko");
        NOMBRE_MONEDA.put("VES", "Bolívar venezolano");
        NOMBRE_MONEDA.put("VND", "Dong vietnamita");
        NOMBRE_MONEDA.put("VUV", "Vatu vanuatuense");
        NOMBRE_MONEDA.put("WST", "Tala samoano");
        NOMBRE_MONEDA.put("XAF", "Franco CFA BEAC");
        NOMBRE_MONEDA.put("XCD", "Dólar del Caribe Oriental");
        NOMBRE_MONEDA.put("XDR", "Derecho Especial de Giro");
        NOMBRE_MONEDA.put("XOF", "Franco CFA BCEAO");
        NOMBRE_MONEDA.put("XPF", "Franco CFP");
        NOMBRE_MONEDA.put("YER", "Riyal yemení");
        NOMBRE_MONEDA.put("ZAR", "Rand sudafricano");
        NOMBRE_MONEDA.put("ZMW", "Kwacha zambiano");
        NOMBRE_MONEDA.put("ZWL", "Dólar zimbabuense");

        // Agrega más monedas según sea necesario
    }

    public double convertir(String monedaBase, String monedaObjetivo, double cantidad) throws Exception {
        double tasaCambio = obtenerTasaCambio(monedaBase, monedaObjetivo);
        return cantidad * tasaCambio;
    }

    private static double obtenerTasaCambio(String base, String objetivo) throws Exception {
        String urlString = API_URL + base;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        // Parsear JSON usando Gson
        Gson gson = new Gson();
        ExchangeRateResponse respuesta = gson.fromJson(content.toString(), ExchangeRateResponse.class);
        return respuesta.getConversion_rates().get(objetivo);
    }

    public Map<String, Double> obtenerTasasDeCambio(String base) throws Exception {
        String urlString = API_URL + base;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        // Parsear JSON usando Gson
        Gson gson = new Gson();
        ExchangeRateResponse respuesta = gson.fromJson(content.toString(), ExchangeRateResponse.class);
        return respuesta.getConversion_rates();
    }

    // Método para obtener el nombre completo de la moneda
    public String obtenerNombreMoneda(String codigo) {
        return NOMBRE_MONEDA.getOrDefault(codigo, "Nombre desconocido");
    }
    // Método para obtener los códigos de monedas disponibles
    public Map<String, String> obtenerMonedasDisponibles() {
        Map<String, String> monedasDisponibles = new HashMap<>();
        for (String codigo : NOMBRE_MONEDA.keySet()) {
            monedasDisponibles.put(codigo, NOMBRE_MONEDA.get(codigo));
        }
        return monedasDisponibles;
    }


    private class ExchangeRateResponse {
        private String result;
        private String base_code;
        private Map<String, Double> conversion_rates;

        public Map<String, Double> getConversion_rates() {
            return conversion_rates;
        }
    }
}
