package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.hardware.Gamepad;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.Array;

/**
 * Created by skye on 6/8/16.
 */

public class AutoRecord extends OpMode {

    DualPad gpads;
    File f;
    PrintStream p;
    Scanner s;

    Boolean record = false;
    Boolean play = false;

    @Override
    public void init(){
        /****************************
         * Your init code goes here
         ****************************/

        gpads = new DualPad();

        ArrayList<File> fs = gpads.getRecordedPlays();
      // int fcount = 0;
        gpads.setPads(gamepad1, gamepad2);
      //  if(gpads.a) break;
        if(gpads.b) record = true;
        if(record) play = false;

        if(gpads.x) play = true;
        if(play) record = false;

        telemetry.addData("Record (B)", record);
        telemetry.addData("Play (X)", play);

            //waitOneHardwareCycle();

        f = fs.get(0);
        telemetry.addData("File", f.getName());

        try{
            if(record)
                p = new PrintStream(f);
            if(play)
               s = new Scanner(f);
        }
        catch(IOException e){

        }
    }


    @Override
    public void loop(){
        /****************************
         * Your loop code goes here
         ****************************/

        gpads.setPads(gamepad1, gamepad2);
        if(record) {
            gpads.recordState(p);
        }
        if(play){
            gpads.playState(s);
        }
    }




    @Override
    public void stop(){

        /****************************
         * Your stop code goes here.
         ****************************/

        p.close();
    }

}
