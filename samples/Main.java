import com.github.salesforce.marketingcloud.javasdk.ApiException;
import com.github.salesforce.marketingcloud.javasdk.exception.EnvironmentVariableNotSetException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ApiException, EnvironmentVariableNotSetException {
        Scanner scanner = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("Sample to run:");
            RunSample(scanner.nextLine());
        } else {
            for (String sampleName : args) {
                RunSample(sampleName);
            }
        }
        System.out.println("Press Enter to Exit");
        scanner.nextLine();
    }

    private static void RunSample(String sampleName) throws ApiException, EnvironmentVariableNotSetException {
        switch (sampleName) {
            case "SendEmailToMultipleRecipients":
                Samples.SendEmailToMultipleRecipients();
                break;
            case "SendEmailToSingleRecipient":
                Samples.SendEmailToSingleRecipient();
                break;
            default:
                System.out.println("Unrecognized sample: " + sampleName);
                break;
        }
    }
}