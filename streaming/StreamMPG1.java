package streaming;

public class StreamMPG1 extends Stream {
    public StreamMPG1(String dataInput) { super(dataInput); }

    @Override
    public void encoder() {
        this.dataOutput = "Video convertido para MPG1 a partir de: " + this.dataInput;
        System.out.println("[ENCODER MPG1] " + this.dataOutput);
    }

    @Override
    public void decoder() {
        System.out.println("[DECODER MPG1] Lendo entrada: " + this.dataInput);
    }
}