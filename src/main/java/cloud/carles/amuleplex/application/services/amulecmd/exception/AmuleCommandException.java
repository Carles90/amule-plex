package cloud.carles.amuleplex.application.services.amulecmd.exception;

public class AmuleCommandException extends Exception {
    private final String[] output;

    public AmuleCommandException(String[] output) {
        this.output = output;
    }

    public String[] getOutput() {
        return output;
    }
}
