package functions;

import io.cucumber.java.Scenario;

public class LogFunction {

    public static void logStepResult (Scenario scenario, String stepDescription) {
        scenario.log("Successful: " + stepDescription + " step completed successfully.");
    }


}
