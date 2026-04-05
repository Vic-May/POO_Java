package streaming;

public class StreamOgg extends Stream {
    public StreamOgg(String dataInput) { super(dataInput); }

    @Override
    public void encoder() {
        this.dataOutput = "Audio OGG extraido do video: " + this.dataInput;
        System.out.println("[ENCODER OGG] " + this.dataOutput);
    }

    @Override
    public void decoder() {
        System.out.println("[DECODER OGG] Lendo entrada: " + this.dataInput);
    }
}