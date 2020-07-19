package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Mux32to5 extends Wrapper {
    public Mux32to5(String label, String stream, Link... links) {
        super(label, stream, links);
    }
    //input0 LSB SELECTOR //input4 MSB SELECTOR //input5 LSB....//input36 MSB


    @Override
    public void initialize() {

        Mux16to4 MUX16TO4FIRST = new Mux16to4("MUX16TO4FIR", "20X1");
        Mux16to4 MUX16TO4SECOND = new Mux16to4("MUX16TO4SEC", "20X1");
        Mux2to1 MUX2TO1 = new Mux2to1("MUX2TO1","3X1");

        MUX16TO4FIRST.addInput( getInput(0), getInput(1), getInput(2), getInput(3),
                getInput(5), getInput(6), getInput(7), getInput(8),
                getInput(9), getInput(10), getInput(11), getInput(12),
                getInput(13), getInput(14), getInput(15), getInput(16),
                getInput(17), getInput(18), getInput(19), getInput(20));

        MUX16TO4SECOND.addInput(getInput(0), getInput(1), getInput(2), getInput(3),
                getInput(21), getInput(22), getInput(23), getInput(24),
                getInput(25), getInput(26), getInput(27), getInput(28),
                getInput(29), getInput(30), getInput(31), getInput(32),
                getInput(33), getInput(34), getInput(35), getInput(36));

        MUX2TO1.addInput(getInput(4),MUX16TO4FIRST.getOutput(0),MUX16TO4SECOND.getOutput(0));

        addOutput( MUX2TO1.getOutput(0));

    }
}
