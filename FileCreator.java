package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.robocol.Telemetry;

import java.io.*;

/**
 * Created by skye on 6/8/16.
 */
public class FileCreator extends LinearOpMode{
    @Override
    //Creates the files you can upload your recorded moves to
    public void runOpMode() throws InterruptedException{
        File a = new File("/sdcard/FIRST/auto_1.txt");
        File b = new File("/sdcard/FIRST/auto_2.txt");
        File c = new File("/sdcard/FIRST/auto_3.txt");
        File d = new File("/sdcard/FIRST/auto_4.txt");
        File v = new File("/sdcard/FIRST/auto_5.txt");

        try {

            PrintStream q = new PrintStream(a);
            PrintStream r = new PrintStream(b);
            PrintStream s = new PrintStream(c);
            PrintStream t = new PrintStream(d);
            PrintStream u = new PrintStream(v);
        }
        catch (FileNotFoundException e){
            telemetry.addData("Error", e.getMessage());
        }
        telemetry.addData("Status", "Finished");

        waitOneFullHardwareCycle();
    }
}
