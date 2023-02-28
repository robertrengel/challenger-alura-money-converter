public enum MoneyList {
    USD("Dolar Estado Unidense", "usd"),
    EUR("Euro", "eur"),
    JPY("Yen Japones", "jpy"),
    PEN("Sol Peruano", "pen"),
    GBP("Libra Esterlina", "gbp");

    private final String name;
    private final String reference;

    private MoneyList(String name, String reference) {
        this.name = name;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }
}