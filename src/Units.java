public enum Units {
    CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit"),
    KELVIN("Kelvin");
    
    private String unit;

    private Units(String name) {
        this.unit = name;
    }

    public String getName() {
        return unit;
    }
}
