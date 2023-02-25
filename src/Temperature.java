public class Temperature {
    private double inputResolved;

    Units[] units = Units.values();

    public Temperature(double inputValue, String unit1, String unit2) {
;
        if (unit1.equals(units[0].getName())) {
            if (unit2.equals(units[1].getName())) {
                setInputResolved(celsiusToFahrenheit(inputValue)) ;
            } else if (unit2.equals(units[2].getName())) {
                setInputResolved(celsiusToKelvin(inputValue)) ;
            }
        }
        else if (unit1.equals(units[1].getName())) {
            if (unit2.equals(units[0].getName())) {
                setInputResolved(fahrenheitToCelsius(inputValue)) ;
            } else if (unit2.equals(units[2].getName())) {
                setInputResolved(fahrenheitToKelvin(inputValue)) ;
            }
        }
        else if (unit1.equals(units[2].getName())) {
            if (unit2.equals(units[0].getName())) {
                setInputResolved(kelvinToCelsius(inputValue)) ;
            } else if (unit2.equals(units[1].getName())) {
                setInputResolved(kelvinToFahrenheit(inputValue)) ;
            }
        }

        else if(unit1.equals(unit2)){
            setInputResolved(inputValue);;
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9/5) + 32;
        return fahrenheit;
    }

    public static double celsiusToKelvin(double celsius) {
        double kelvin = celsius + 273.15;
        return kelvin;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5/9;
        return celsius;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        double kelvin = fahrenheit + 273.15;
        return kelvin;
    }

    public static double kelvinToCelsius(double kelvin) {
        double celsius = kelvin - 273.15;
        return celsius;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        double fahrenheit = (kelvin - 273.15) * 9/5 + 32;
        return fahrenheit;
    }

    public double getInputResolved() {
        return inputResolved;
    }

    public void setInputResolved(double inputResolved) {
        this.inputResolved = inputResolved;
    }

}
