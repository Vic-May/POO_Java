package streaming;

public class StreamM4u extends Stream {
    public StreamM4u(String dataInput) { super(dataInput); }

    @Override
    public void encoder() {
        this.dataOutput = "Audio M4U extraido do video: " + this.dataInput;
        System.out.println("[ENCODER M4U] " + this.dataOutput);
    }

    @Override
    public void decoder() {
        System.out.println("[DECODER M4U] Lendo entrada: " + this.dataInput);
    }
}