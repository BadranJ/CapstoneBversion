package FirstSolver;

import java.util.Comparator;
import java.util.List;

public class CustomProcessComparator implements Comparator<Process> {
    private List<Character> priorityOrder;

    public CustomProcessComparator(List<Character> priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    @Override
    public int compare(Process p1, Process p2) {
        int index1 = priorityOrder.indexOf(p1.getProcess());
        int index2 = priorityOrder.indexOf(p2.getProcess());
        return Integer.compare(index1, index2);
    }
}