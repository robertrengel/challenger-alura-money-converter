// A Java Enum.
public enum MoneyList {
    PEN("Sol Peruano", "pen"),
    USD("Dolar Estado Unidense", "usd"),
    EUR("Euro", "eur"),
    JPY("Yen Japones", "jpy"),
    GBP("Libra Esterlina", "gbp"),
    KRW("Won Sur Coreano", "krw");

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