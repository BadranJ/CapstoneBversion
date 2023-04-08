package FirstSolver;
import FirstSolver.State;


import java.util.*;

public class Graph {
    private Map<State, List<Process>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(Process process) {
        State fromState = process.getState1();
        State toState = process.getState2();

        adjacencyList.putIfAbsent(fromState, new ArrayList<>());
        adjacencyList.get(fromState).add(process);
    }

    public List<Process> topologicalSort() {
        Stack<State> stack = new Stack<>();
        Set<State> visited = new HashSet<>();

        for (State state : adjacencyList.keySet()) {
            if (!visited.contains(state)) {
                topologicalSortUtil(state, visited, stack);
            }
        }

        List<Process> sortedProcesses = new ArrayList<>();
        while (!stack.isEmpty()) {
            State currentState = stack.pop();
            if (adjacencyList.containsKey(currentState)) {
                sortedProcesses.addAll(adjacencyList.get(currentState));
            }
        }

        return sortedProcesses;
    }

    private void topologicalSortUtil(State state, Set<State> visited, Stack<State> stack) {
        visited.add(state);

        if (adjacencyList.containsKey(state)) {
            for (Process process : adjacencyList.get(state)) {
                State nextState = process.getState2();
                if (!visited.contains(nextState)) {
                    topologicalSortUtil(nextState, visited, stack);
                }
            }
        }

        stack.push(state);
    }
}
