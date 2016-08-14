
package maszynaturingadodawanie;

import java.util.Objects;

public class Pair {
    
    public int state;
    public String symbol;

    public Pair(int state, String symbol) {
        this.state = state;
        this.symbol = symbol;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        if (state != other.state)
            return false;
        if (!symbol.equals(other.symbol))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.state;
        hash = 71 * hash + Objects.hashCode(this.symbol);
        return hash;
    }
}
