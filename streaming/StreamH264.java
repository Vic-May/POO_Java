package streaming;

public class StreamH264 extends Stream {
    public StreamH264(String dataInput) { super(dataInput); }

    @Override
    public void encoder() {
        this.dataOutput = "Video convertido para H264 a partir de: " + this.dataInput;
        System.out.println("[ENCODER H264] " + this.dataOutput);
    }

    @Override
    public void decoder() {
        System.out.println("[DECODER H264] Lendo entrada: " + this.dataInput);
    }
}