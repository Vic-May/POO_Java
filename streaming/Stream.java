package streaming;

public abstract class Stream {
    protected String dataInput;
    protected String dataOutput;

    public Stream(String dataInput) {
        this.dataInput = dataInput;
    }

    public abstract void encoder();
    public abstract void decoder();

    public String getDataInput() { return dataInput; }
    public void setDataInput(String dataInput) { this.dataInput = dataInput; }
    public String getDataOutput() { return dataOutput; }
    public void setDataOutput(String dataOutput) { this.dataOutput = dataOutput; }
}