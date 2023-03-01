// Creating an enum with three values, Celsius, Fahrenheit, and Kelvin.
public enum UnitsList {
    CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit"),
    KELVIN("Kelvin");

    private String unit;

    private UnitsList(String name) {
        this.unit = name;
    }

    public String getName() {
        return unit;
    }
}
