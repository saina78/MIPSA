package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Decoder5to32  extends Wrapper {
    //input0 MSB //input5 LSB
    //0//1//2//3...//31

    public Decoder5to32(String label, String stream, Link... links) {
        super(label, stream, links);
    }
    @Override
    public void initialize() {

        Not NOT1 = new Not("NOT1");
        Not NOT2 = new Not("NOT2");
        Not NOT3 = new Not("NOT3");
        Not NOT4 = new Not("NOT4");
        Not NOT5 = new Not("NOT5");

        And AND0 = new And("AND0");
        And AND1 = new And("AND1");
        And AND2 = new And("AND2");
        And AND3 = new And("AND3");
        And AND4 = new And("AND4");
        And AND5 = new And("AND5");
        And AND6 = new And("AND6");
        And AND7 = new And("AND7");
        And AND8 = new And("AND8");
        And AND9 = new And("AND9");
        And AND10 = new And("AND10");
        And AND11 = new And("AND11");
        And AND12 = new And("AND12");
        And AND13 = new And("AND13");
        And AND14 = new And("AND14");
        And AND15 = new And("AND15");
        And AND16 = new And("AND16");
        And AND17 = new And("AND17");
        And AND18 = new And("AND18");
        And AND19 = new And("AND19");
        And AND20 = new And("AND20");
        And AND21 = new And("AND21");
        And AND22 = new And("AND22");
        And AND23 = new And("AND23");
        And AND24 = new And("AND24");
        And AND25 = new And("AND25");
        And AND26 = new And("AND26");
        And AND27 = new And("AND27");
        And AND28 = new And("AND28");
        And AND29 = new And("AND29");
        And AND30 = new And("AND30");
        And AND31 = new And("AND31");


        NOT1.addInput(getInput(0)); //A
        NOT2.addInput(getInput(1));//B
        NOT3.addInput(getInput(2));//C
        NOT4.addInput(getInput(3));//D
        NOT5.addInput(getInput(4));//E

        AND0.addInput(NOT1.getOutput(0), NOT2.getOutput(0), NOT3.getOutput(0), NOT4.getOutput(0), NOT5.getOutput(0));
        AND1.addInput(NOT1.getOutput(0), NOT2.getOutput(0), NOT3.getOutput(0), NOT4.getOutput(0), getInput(4));
        AND2.addInput(NOT1.getOutput(0), NOT2.getOutput(0), NOT3.getOutput(0), getInput(3), NOT5.getOutput(0));
        AND3.addInput(NOT1.getOutput(0), NOT2.getOutput(0), NOT3.getOutput(0), getInput(3), getInput(4));
        AND4.addInput(NOT1.getOutput(0), NOT2.getOutput(0), getInput(2), NOT4.getOutput(0), NOT5.getOutput(0));
        AND5.addInput(NOT1.getOutput(0), NOT2.getOutput(0), getInput(2), NOT4.getOutput(0), getInput(4));
        AND6.addInput(NOT1.getOutput(0), NOT2.getOutput(0), getInput(2), getInput(3), NOT5.getOutput(0));
        AND7.addInput(NOT1.getOutput(0), NOT2.getOutput(0), getInput(2), getInput(3), getInput(4));
        AND8.addInput(NOT1.getOutput(0), getInput(1), NOT3.getOutput(0), NOT4.getOutput(0), NOT5.getOutput(0));
        AND9.addInput(NOT1.getOutput(0), getInput(1), NOT3.getOutput(0), NOT4.getOutput(0), getInput(4));
        AND10.addInput(NOT1.getOutput(0), getInput(1), NOT3.getOutput(0), getInput(3), NOT5.getOutput(0));
        AND11.addInput(NOT1.getOutput(0), getInput(1), NOT3.getOutput(0), getInput(3), getInput(4));
        AND12.addInput(NOT1.getOutput(0), getInput(1), getInput(2), NOT4.getOutput(0), NOT5.getOutput(0));
        AND13.addInput(NOT1.getOutput(0), getInput(1), getInput(2), NOT4.getOutput(0), getInput(4));
        AND14.addInput(NOT1.getOutput(0), getInput(1), getInput(2), getInput(3), NOT5.getOutput(0));
        AND15.addInput(NOT1.getOutput(0), getInput(1), getInput(2), getInput(3), getInput(4));
        AND16.addInput(getInput(0), NOT2.getOutput(0), NOT3.getOutput(0), NOT4.getOutput(0), NOT5.getOutput(0));
        AND17.addInput(getInput(0), NOT2.getOutput(0), NOT3.getOutput(0), NOT4.getOutput(0), getInput(0));
        AND18.addInput(getInput(0), NOT2.getOutput(0), NOT3.getOutput(0), getInput(3), NOT5.getOutput(0));
        AND19.addInput(getInput(0), NOT2.getOutput(0), NOT3.getOutput(0), getInput(3), getInput(4));
        AND20.addInput(getInput(0), NOT2.getOutput(0), getInput(2), NOT4.getOutput(0), NOT5.getOutput(0));
        AND21.addInput(getInput(0), NOT2.getOutput(0), getInput(2), NOT4.getOutput(0), getInput(4));
        AND22.addInput(getInput(0), NOT2.getOutput(0), getInput(2), getInput(3),NOT5.getOutput(0));
        AND23.addInput(getInput(0), NOT2.getOutput(0), getInput(2), getInput(3), getInput(4));
        AND24.addInput(getInput(0), getInput(1), NOT3.getOutput(0), NOT4.getOutput(0), NOT5.getOutput(0));
        AND25.addInput(getInput(0), getInput(1), NOT3.getOutput(0), NOT4.getOutput(0), getInput(4));
        AND26.addInput(getInput(0), getInput(1), NOT3.getOutput(0), getInput(3), NOT5.getOutput(0));
        AND27.addInput(getInput(0), getInput(1), NOT3.getOutput(0), getInput(3),getInput(4));
        AND28.addInput(getInput(0), getInput(1), getInput(2), NOT4.getOutput(0), NOT5.getOutput(0));
        AND29.addInput(getInput(0), getInput(1), getInput(2), NOT4.getOutput(0), getInput(4));
        AND30.addInput(getInput(0), getInput(1), getInput(2), getInput(3), NOT5.getOutput(0));
        AND31.addInput(getInput(0),getInput(1), getInput(2), getInput(3), getInput(4));

        addOutput(AND0.getOutput(0), AND1.getOutput(0), AND2.getOutput(0), AND3.getOutput(0), AND4.getOutput(0), AND5.getOutput(0)
                , AND6.getOutput(0), AND7.getOutput(0), AND8.getOutput(0), AND9.getOutput(0), AND10.getOutput(0)
                , AND11.getOutput(0), AND12.getOutput(0), AND13.getOutput(0), AND14.getOutput(0), AND15.getOutput(0)
                , AND16.getOutput(0), AND17.getOutput(0), AND18.getOutput(0), AND19.getOutput(0), AND20.getOutput(0)
                , AND21.getOutput(0), AND22.getOutput(0), AND23.getOutput(0), AND24.getOutput(0), AND25.getOutput(0)
                , AND26.getOutput(0), AND27.getOutput(0), AND28.getOutput(0), AND29.getOutput(0), AND30.getOutput(0)
                , AND31.getOutput(0)
        );

    }
}
