package simulator.wrapper.wrappers;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class RegisterFile extends Wrapper {//Reg1//Reg2//Reg3//WriteData//RegWrite
    public RegisterFile(String label, String stream, Link... links) {
        super(label, stream, links);
    }
//input 0 MSB REG1//input 4 LSB REG1//input 5 MSB REG2//input 9 LSB REG1//input10 MSB REG3(TOWRITEIN)//input14 LSB REG3//input15REGWRITE//input16 LSB WRITEDATA//input 47 MSB WRITEDATA
//0 to 32 : LSB REG1 to MSB REG1//32 to 64 : LSB REG3 to MSB REG1
    @Override
    public void initialize() {


        Register[][] regfile = new Register[32][32];

        for (int i = 0 ; i < 32; i++){
            for (int j = 0; j < 32; j++){
                regfile[i][j] = new Register("myReg","2X1");
            }
        }

        Decoder5to32 DECODER5TO32 = new Decoder5to32("DECODER5TO32","5X32");

        DECODER5TO32.addInput(getInput(10),getInput(11),getInput(12),getInput(13),getInput(14));

        for(int i = 0; i < 32; i++){
            for(int j = 0; j < 32; j++){
                And AND1 = new And("AND1");
                AND1.addInput(DECODER5TO32.getOutput(i),getInput(15));
                regfile[i][j].addInput(AND1.getOutput(0),getInput(j + 16));

            }
        }

       Mux32to5[] REGONEMUX = new Mux32to5[32];
       Mux32to5[] REGTWOMUX = new Mux32to5[32];




        for(int i = 0; i < 32; i++){
            REGONEMUX[i] = new Mux32to5("MUX32TO5", "37X1", getInput(4), getInput(3), getInput(2), getInput(1), getInput(0));
            for(int j = 0; j < 32; j++){
                REGONEMUX[i].addInput(regfile[j][i].getOutput(0));
            }
           addOutput(REGONEMUX[i].getOutput(0));
        }

        for(int i = 0; i < 32; i++){
            REGTWOMUX[i] = new Mux32to5("MUX32TO5", "37X1", getInput(9), getInput(8), getInput(7), getInput(6), getInput(5));
            for(int j = 0; j < 32; j++){
                REGTWOMUX[i].addInput(regfile[j][i].getOutput(0));
            }
            addOutput(REGTWOMUX[i].getOutput(0));
        }


    }

}
