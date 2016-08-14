package maszynaturingadodawanie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class TuringMachine {
    
    private final int[] alphabet = new int[]{0, 1, 2, 5};
    private final String BLANK_SYMBOL = "E";
    private final Set<Integer> finalStates = new HashSet(Arrays.asList(10));
    private final int initialState = 0;
    private Map<Pair, Triple> transitions;
    List<String> tape;
    ListIterator<String> tapeHead;
    Triple next;
    Pair pair;

    public TuringMachine() {
        transitions = new HashMap<>();
        tape = new LinkedList<>();
        tape.add(BLANK_SYMBOL);
        tapeHead = tape.listIterator();
        tapeHead.next();
        tapeHead.previous();
    }
    
    public void addTransition(int currentState, String currentSymbol, int nextState, String nextSymbol, TapeShift tapeShift) {
        transitions.put(new Pair(currentState, currentSymbol), new Triple(nextState, nextSymbol, tapeShift));
    }
    
    public void setTape(LinkedList tape) {
        this.tape = tape;
    }
    
    public void run() {
        tapeHead = tape.listIterator();
        while(tapeHead.next().equals(BLANK_SYMBOL));
        tapeHead.previous();
 
        pair = new Pair(initialState, tape.get(tapeHead.nextIndex()));
    }
    
    public boolean nextStep() {
        if(finalStates.contains(pair.state)) {
            return false;
        }
        
        Triple triple = transitions.get(pair);
        tapeHead.set(triple.symbol); 
        pair.state = triple.state; 
        if (triple.tapeShift == TapeShift.LEFT) { 
            if (!tapeHead.hasPrevious()) {
                tapeHead.add(BLANK_SYMBOL); 
            }
            pair.symbol = tapeHead.previous();
        } else if (triple.tapeShift == TapeShift.RIGHT) { 
            tapeHead.next();
            if (!tapeHead.hasNext()) {
                tapeHead.add(BLANK_SYMBOL); 
                tapeHead.previous();
            }
            pair.symbol = tapeHead.next(); 
            tapeHead.previous();
        } else {
            pair.symbol = triple.symbol;
        }
        
        return true;
    }

    public int getCurrentState() {
        return pair.state;
    }

    public List<String> getTape() {
        return tape;
    }

    public ListIterator<String> getTapeHead() {
        return tapeHead;
    }
}
