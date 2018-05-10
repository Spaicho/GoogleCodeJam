package round_0.c_bathroom_stalls.submissions;
import java.util.Comparator;


public class StallComparator implements Comparator<Stall> {
    @Override
    public int compare(Stall o1, Stall o2) {
        if(o1.s > o2.s){
        	return 1;
        } else if(o1.s < o2.s){
        	return -1;
        } else {
        	return 0;
        }
    }
}