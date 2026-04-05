package streaming;

public class StreamMp3 extends Stream {
    public StreamMp3(String dataInput) { super(dataInput); }

    @Override
    public void encoder() {
        this.dataOutput = "Audio MP3 extraido do video: " + this.dataInput;
        System.out.println("[ENCODER MP3] " + this.dataOutput);
    }

    @Override
    public void decoder() {
        System.out.println("[DECODER MP3] Lendo entrada: " + this.dataInput);
    }
}