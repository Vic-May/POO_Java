package streaming;

public class StreamMP4 extends Stream {
    public StreamMP4(String dataInput) { super(dataInput); }

    @Override
    public void encoder() {
        this.dataOutput = "Video convertido para MP4 a partir de: " + this.dataInput;
        System.out.println("[ENCODER MP4] " + this.dataOutput);
    }

    @Override
    public void decoder() {
        System.out.println("[DECODER MP4] Lendo entrada: " + this.dataInput);
    }
}