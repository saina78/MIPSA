package simulator.wrapper.wrappers;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class ControlUnit extends Wrapper {
//OP0//OP1//OP2//OP3...//OP5
//RegDST//ALUSRC//MemToReg//RegWrite//MemRead//MemWrite//Branch//ALUOP1//ALUOP2
    public ControlUnit(String label, String stream, Link... links) {
        super(label, stream, links);
    }
    @Override
    public void initialize() {
        And AND1 = new And("And1");
        And AND2 = new And("And2");
        And AND3 = new And("And3");
        And AND4 = new And("And4");

        Or OR1 = new Or("Or1");
        Or OR2 = new Or("Or2");

        Not NOT0 = new Not("NOT0");
        Not NOT1 = new Not("NOT1");
        Not NOT2 = new Not("NOT2");
        Not NOT3 = new Not("NOT3");
        Not NOT4 = new Not("NOT4");
        Not NOT5 = new Not("NOT5");

        NOT0.addInput(getInput(0));
        NOT1.addInput(getInput(1));
        NOT2.addInput(getInput(2));
        NOT3.addInput(getInput(3));
        NOT4.addInput(getInput(4));
        NOT5.addInput(getInput(5));

        AND1.addInput(NOT0.getOutput(0), NOT1.getOutput(0), NOT2.getOutput(0), NOT3.getOutput(0), NOT4.getOutput(0), NOT5.getOutput(0));
        AND2.addInput(getInput(5), NOT4.getOutput(0), NOT3.getOutput(0), NOT2.getOutput(0), getInput(1), getInput(0));
        AND3.addInput(getInput(5), NOT4.getOutput(0), getInput(3), NOT2.getOutput(0), getInput(1), getInput(0));
        AND4.addInput(NOT5.getOutput(0), NOT4.getOutput(0), NOT3.getOutput(0), getInput(2), NOT1.getOutput(0), NOT0.getOutput(0));

        OR1.addInput(AND2.getOutput(0), AND3.getOutput(0));
        OR2.addInput(AND1.getOutput(0), AND2.getOutput(0));

        addOutput(AND1.getOutput(0), OR1.getOutput(0), AND2.getOutput(0), OR2.getOutput(0),AND2.getOutput(0), AND3.getOutput(0), AND4.getOutput(0), AND1.getOutput(0), AND4.getOutput(0));

    }
}
