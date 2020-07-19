package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Register extends Wrapper {//SELECT,NEWDATA
    public Register(String label, String stream, Link... links) {
        super(label, stream, links);
    }
    //REGWRITE //NEWDATA

    @Override
    public void initialize() {

        Clock clock = new Clock("CLOCK1", 1000);

        DFlipFlop DFLIPFLOP1 = new DFlipFlop("DFLIPFLOP");
        Mux2to1 MUX2TO1 = new Mux2to1("MUX2TO1","3X1");


        MUX2TO1.addInput(getInput(0), DFLIPFLOP1.getOutput(0), getInput(1) );
        DFLIPFLOP1.addInput(clock.getOutput(0), MUX2TO1.getOutput(0));

        addOutput(DFLIPFLOP1.getOutput(0));
    }
}
