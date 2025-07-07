package OOP.L04_InterfacesAndAbstraction.P05_Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();

        urls.stream().forEach(url -> {
            if(isValidUrl(url)){
                stringBuilder.append(String.format("Browsing: %s!%n", url));
            }else {
                stringBuilder.append("Invalid URL!").append(System.lineSeparator());
            }
        });

        return stringBuilder.toString();
    }

    private boolean isValidUrl(String url) {
        for (int i = 0; i < url.length(); i++) {
            if(Character.isDigit(url.charAt(i))){
                return false;
            }
        }

        return true;
    }

    @Override
    public String call() {

        StringBuilder builder = new StringBuilder();

        numbers
                .stream()
                .forEach(number -> {
                    if(isValidNumber(number)){
                        builder.append(String.format("Calling... %s%n", number));
                    }else {
                        builder.append("Invalid number!").append(System.lineSeparator());
                    }

                });


        return builder.toString();
    }

    private boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if(!Character.isDigit(number.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
