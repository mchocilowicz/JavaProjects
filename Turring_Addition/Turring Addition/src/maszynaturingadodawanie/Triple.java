
package maszynaturingadodawanie;

public class Triple {
    public int state;
    public String symbol;
    public TapeShift tapeShift;

    public Triple(int state, String symbol, TapeShift tapeShift) {
        this.state = state;
        this.symbol = symbol;
        this.tapeShift = tapeShift;
    }
}
