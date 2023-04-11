package FirstSolver;

import java.util.*;

public class Solver extends ACSolver {

    public Solver(List<Process> p) {
        super(p);
        sortProcesses();
    }

    public Solver(Process p) {
        super(p);
        sortProcesses();
    }

    private void sortProcesses() {
        Collections.sort(PROCESSES, (Process a, Process b) -> {
            int knownVarsA = a.state1.countKnownProperties() + a.state2.countKnownProperties();
            int knownVarsB = b.state1.countKnownProperties() + b.state2.countKnownProperties();
            return knownVarsA - knownVarsB; //was knownVarsB-knownVarsA.
        });
    }

    private void propagateKnownInformation() {
        for (int i = 0; i < PROCESSES.size(); i++) {
            Process currentProcess = PROCESSES.get(i);
            for (int j = i + 1; j < PROCESSES.size(); j++) {
                Process otherProcess = PROCESSES.get(j);

                // Check if both processes share the same state and call passProperties() accordingly
                if (currentProcess.state1.equals(otherProcess.state1)) {
                    currentProcess.passProperties();
                    otherProcess.passProperties();
                } else if (currentProcess.state1.equals(otherProcess.state2)) {
                    currentProcess.passProperties();
                    otherProcess.passPropertiesReverse();
                } else if (currentProcess.state2.equals(otherProcess.state1)) {
                    currentProcess.passPropertiesReverse();
                    otherProcess.passProperties();
                } else if (currentProcess.state2.equals(otherProcess.state2)) {
                    currentProcess.passPropertiesReverse();
                    otherProcess.passPropertiesReverse();
                }
            }
        }
    }
//private void propagateKnownInformation() {
//    for (int i = 0; i < PROCESSES.size(); i++) {
//        Process currentProcess = PROCESSES.get(i);
//        for (int j = i + 1; j < PROCESSES.size(); j++) {
//            Process otherProcess = PROCESSES.get(j);
//
//            // Check if both processes share the same state and call passProperties() accordingly
//            if (currentProcess.state1.equals(otherProcess.state1)) {
//                currentProcess.passProperties();
//                otherProcess.passProperties();
//                otherProcess.state1.copyFrom(currentProcess.state1);
//            } else if (currentProcess.state1.equals(otherProcess.state2)) {
//                currentProcess.passProperties();
//                otherProcess.passPropertiesReverse();
//                otherProcess.state2.copyFrom(currentProcess.state1);
//            } else if (currentProcess.state2.equals(otherProcess.state1)) {
//                currentProcess.passPropertiesReverse();
//                otherProcess.passProperties();
//                otherProcess.state1.copyFrom(currentProcess.state2);
//            } else if (currentProcess.state2.equals(otherProcess.state2)) {
//                currentProcess.passPropertiesReverse();
//                otherProcess.passPropertiesReverse();
//                otherProcess.state2.copyFrom(currentProcess.state2);
//            }
//        }
//    }
//}





    public Map<String, List<Double>> CompleteSolve() {
        Map<String, List<Double>> finalProccesses = new HashMap<>();


        while (true) {
            boolean newStatesSolved = false;

            propagateKnownInformation();
            sortProcesses();

            for (Iterator<Process> p = PROCESSES.iterator(); p.hasNext();) {
                Process currentProcess = p.next();

                boolean prevState1Solved = currentProcess.state1.isSolved();
                boolean prevState2Solved = currentProcess.state2.isSolved();

                currentProcess.solveProcess();

                if (!prevState1Solved && currentProcess.state1.isSolved()) {
                    newStatesSolved = true;
                }
                if (!prevState2Solved && currentProcess.state2.isSolved()) {
                    newStatesSolved = true;
                }

                finalProccesses.put(currentProcess.state1.toString(), currentProcess.state1.getValues());
                finalProccesses.put(currentProcess.state2.toString(), currentProcess.state2.getValues());
            }

            if (!newStatesSolved) {
                break;
            }
        }

        return finalProccesses;
    }

//    private void validateProcess(Process process) {
//        State state1 = process.getState1();
//        State state2 = process.getState2();
//        char processType = process.getProcess();
//
//        switch (processType) {
//            case 'v': // Isochoric
//                if (state1.getPressure() != 0 && state2.getPressure() != 0 && state1.getTemp() != 0 && state2.getTemp() != 0) {
//                    if (state1.getPressure() * state1.getTemp() != state2.getPressure() * state2.getTemp()) {
//                        throw new IllegalArgumentException("Inconsistent input values for isochoric process");
//                    }
//                }
//                break;
//            case 't': // Isothermal
//                if (state1.getPressure() != 0 && state2.getPressure() != 0 && state1.getVolume() != 0 && state2.getVolume() != 0) {
//                    if (state1.getPressure() * state1.getVolume() != state2.getPressure() * state2.getVolume()) {
//                        throw new IllegalArgumentException("Inconsistent input values for isothermal process");
//                    }
//                }
//                break;
//            case 'p': // Isobaric
//                if (state1.getVolume() != 0 && state2.getVolume() != 0 && state1.getTemp() != 0 && state2.getTemp() != 0) {
//                    if (state1.getVolume() / state1.getTemp() != state2.getVolume() / state2.getTemp()) {
//                        throw new IllegalArgumentException("Inconsistent input values for isobaric process");
//                    }
//                }
//                break;
//            // Add similar checks for other process types if needed
//        }
//    }





    public void PrintResult(List<Map<String, List<Double>>> proccesses) {
        for (Iterator<Map<String, List<Double>>> iter = proccesses.iterator(); iter.hasNext(); ) {

        }
    }
}
