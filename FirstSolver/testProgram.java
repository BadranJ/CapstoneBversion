package FirstSolver;

import java.util.ArrayList;
// import java.util.ArrayList;
// import java.util.Iterator;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class testProgram {

    public static void main(String[] args) {
        // List<State> statesSolved = new ArrayList<>();
        Map<String, List<Double>> statesValues;
        List<Process> proc = new ArrayList<>();
        State state1 = new State(0, 100, 0.1, "State 1"); // we assume that passed properties from processes to be overriding
        State state2 = new State(120, 0, 0, "State 2");
        State state3 = new State(800, 250, 0, "State 3");
        State state4 = new State(0, 2000, 0, "State 4");
        Process process1 = new Process(state1, state2, 'p');
        //Process process2 = new Process(state3, state4, 'p');
        Process process3 = new Process(state4, state3, 't');
//         Process process4 = new Process(state1, state4, 't');
        proc.add(process1);
        //proc.add(process3);
        //proc.add(process2);

//         proc.add(process4);

        // process1.solveProcess();
        // statesValues = process1.getSolvedStatesValues();


        // testing for polytropic
//        State state5 = new State(100, 150, 0, "State 5");
//        State state6 = new State(0, 30, 0, "State 6");
//        double n = 1.2;
//        Process process5 = new Process(state5, state6, n, 'x');
//        proc.add(process5);
//
//
//        State state7= new State(100,150,0,"State 7");
//        State state8= new State(76.5,0,0,"State8");
//
//        Process process6=new Process(state7,state8,n,'y');
//        proc.add(process6);
//
//        State state9= new State(100,150,0,"State9");
//        State state10= new State(0,0,0.732,"State10");
//
//        Process process7=new Process(state9,state10,n,'x');
//        proc.add(process7);


        State state11 = new State(0, 100, 0, "State11");
        State state12 = new State(300, 0, 0, "State12");
        State state13 = new State(0, 0, 0.1, "State13");


//        Process process9=new Process(state12,state13,'v'); //ORDER MATTERS.
//        proc.add(process9);
//
//
//        Process process8=new Process(state11,state12,'t');
//        proc.add(process8);

        //Process process9 =new Process(state12,state13,'v');
        // proc.add(process9);

//        Process process10=new Process(state13,state11,1.4,'x');
//        proc.add(process10);

        // System.out.println("Both states solved " + statesSolved);
        // System.out.println("Both states solved Values " + statesValues);


        State state15 = new State(0, 100, 0, "State 15");
        State state16 = new State(0, 200, 0, "State 16");
        State state17 = new State(200, 300, 0, "State 17");


        //EXAMPEL 1
//        State state18 = new State(0, 0, 0.1435, "state1");
//        State state19 = new State(500, 2000, 0.07175, "State2");
//        State state20 = new State(1000, 0, 0.1435, "State 3");
//
//        Process p1 = new Process(state18,state19,'t');
//        proc.add(p1);
//
//        Process p2= new Process(state19,state20,'p');
//        proc.add(p2);
//
//        Process p3 = new Process(state20,state18,'v');
//        proc.add(p3);


        //EXAMPLE 2

        State state21 = new State(0, 1000, 0, "State 1");
        State state22 = new State(0, 0, 0.1435, "State 2");
        State state23 = new State(800, 0, 0, "State 3");
        State state24 = new State(0, 2000, 0, "State 4");


        Process p1 = new Process(state21,state22,'v');
        proc.add(p1);


        Process p2= new Process(state22,state23,'t');
        proc.add(p2);

        Process p3 = new Process(state23,state24,'p');
        proc.add(p3);

        Process p4 = new Process(state24,state21,'t');
        proc.add(p4);

//        Collections.sort(proc, (Process a, Process b) -> {
//            if (a.getProcess() == 't' && b.getProcess() != 't') {
//                return 1;
//            } else if (a.getProcess() != 't' && b.getProcess() == 't') {
//                return -1;
//            } else {
//                return 0;
//            }
//        });







//
//        Process process11= new Process(state15,state16,'t');
//        proc.add(process11);
//
//        Process process12= new Process(state16,state17,'t');
//        proc.add(process12);


//        Process process12= new Process(state16,state17,'t');
//        proc.add(process12);


//


        Solver solver = new Solver(proc);
        System.out.println(solver.CompleteSolve());

//        double x1=process6.getHeat();
//        double x2=process6.getWork();
//
//        System.out.println(x2);
    }



}