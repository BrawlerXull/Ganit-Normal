

import java.util.Arrays;

public class MarathiWrongAnswers {

    public static String getMarathiWrongAnswers(String input) {
        String wrongAnswers = "";
        try {
            int intValue = Integer.parseInt(input.trim());
            return "$" + input + "$ <br>";
        } catch (NumberFormatException e) {
            if(input.contains(",")){

                String[] vehiclesArray = input.split(", ");
                wrongAnswers =input + "<br>"+"#" + getOnlySingleVehicleTranslation(vehiclesArray[0])+", "+getOnlySingleVehicleTranslation(vehiclesArray[1])+", " +getOnlySingleVehicleTranslation(vehiclesArray[2])+", " + getOnlySingleVehicleTranslation(vehiclesArray[3])+ "<br>";

            }else{
                wrongAnswers = translateToMarathi(input);
            }

        }

        return wrongAnswers;
    }

    private static String translateToMarathi(String answer) {
        if (answer.toLowerCase().startsWith("$1$ cm on the y-axis represents") &&
                answer.toLowerCase().endsWith("travelers.")) {
            String variedNumber = answer
                    .replace("$1$ cm on the y-axis represents", "")
                    .replace("travelers.", "")
                    .trim();

            return  "$1$ cm on the y-axis represents " + variedNumber +
                    " travelers.<br>#$1$ सी.एम. य-अक्षावर " + variedNumber + " प्रवाशींची दर्शवणार.<br>";
        }
        return switch (answer.toLowerCase()) {
            case "number of students travelling by different vehicles." ->
                    "Number of students travelling by different vehicles.<br>#हा स्तंभालेख विविध प्रवासाच्या माध्यमांतून प्रवास करणाऱ्या विद्यार्थ्यांची संख्या दर्शवितो.<br>";
            case "number of teachers travelling by different vehicles." ->
                    "Number of teachers travelling by different vehicles.<br>#हा स्तंभालेख विविध प्रवासाच्या माध्यमांतून प्रवास करणाऱ्या शिक्षकांची संख्या दर्शवितो.<br>";
            case "number of principal travelling by different vehicles." ->
                    "Number of principals travelling by different vehicles.<br>#हा स्तंभालेख विविध प्रवासाच्या माध्यमांतून प्रवास करणाऱ्या मुख्याध्यापकांची संख्या दर्शवितो.<br>";
            case "$1$ cm on the y-axis represents $9$ travelers" ->
                    "$1$ cm on the y-axis represents $9$ travelers<br>#एक सी.एम. य-अक्षावर $9$ प्रवाशींची दर्शवणार<br>";
            case "$1$ cm on the y-axis represents $10$ travelers" ->
                    "$1$ cm on the y-axis represents $10$ travelers<br>#एक सी.एम. य-अक्षावर $10$ प्रवाशींची दर्शवणार<br>";
            case "$1$ cm on the y-axis represents $5$ travelers" ->
                    "$1$ cm on the y-axis represents $5$ travelers<br>#एक सी.एम. य-अक्षावर $5$ प्रवाशींची दर्शवणार<br>";
            case "bus" ->
                    "Bus<br>#बस<br>";
            case "truck" ->
                    "Truck<br>#ट्रक<br>";
            case "motorcycle" ->
                    "Motorcycle<br>#मोटरसायकल<br>";
            case "bicycle" ->
                    "Bicycle<br>#सायकल<br>";
            case "scooter" ->
                    "Scooter<br>#दुचाकी<br>";
            case "car" ->
                    "Car<br>#कार<br>";
            default ->
                    answer;
        };
    }
    private static String getOnlySingleVehicleTranslation(String vehicle) {
        return switch (vehicle.trim().toLowerCase()) {
            case "scooter" -> "दुचाकी";
            case "car" -> "कार";
            case "motorcycle" -> "मोटरसायकल";
            case "bicycle" -> "सायकल";
            case "bus" -> "बस";
            case "truck" -> "ट्रक";
            default -> vehicle;
        };
    }


}
