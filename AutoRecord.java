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

    Scanner s;
    ArrayList<File> fs;
    DualPad gpads;
    ArrayList<File> cues;
    int fileTrack = 0;
    Scanner scan;
    PrintStream print;
    boolean pastPrint = false;
    boolean playing = false;


    @Override
    public void init(){
        /****************************
         * Your init code goes here
         ****************************/

        fs = gpads.getRecordedPlays();
        gpads = new DualPad();
        cues = gpads.getRecordedPlays();
        try {
            scan = new Scanner(cues.get(0));
        }
        catch(IOException e) {
        }
    }


    @Override
    public void loop(){
        /****************************
         * Your loop code goes here
         ****************************/

            gpads.setPads(gamepad1, gamepad2);

            //Press UP on the DPAD to cycle through your saved files
            if(gpads.dpad_up && !(gpads.left_bumper || gpads.right_bumper)) {
                fileTrack++;
                fileTrack = fileTrack % cues.size();
                try {
                    scan = new Scanner(cues.get(fileTrack));
                }
                catch(IOException e){

                }
            }
            try {
                if(gpads.b && !gpads.right_bumper && (pastPrint == false)) {
                    print = new PrintStream(cues.get(fileTrack));
                }
            }
            catch(IOException e){

            }

            telemetry.addData("File", cues.get(fileTrack));

            //Press RIGHT BUMPER to play
            if(gpads.right_bumper && !gpads.left_bumper){
                if(scan.hasNextLine())
                    gpads.playState(scan);
                playing = true;
            }
            if(!gpads.right_bumper){
                playing = false;
                scan.close();
                try {
                    scan = new Scanner(cues.get(fileTrack));
                }
                catch(FileNotFoundException e){
                }
            }

            // Press B BUTTON to record
            if(gpads.b && !gpads.right_bumper && !playing){
                gpads.recordState(print);
                pastPrint = true;
            }
            else {
                if (pastPrint) {
                    print.close();
                    pastPrint = false;
                }
            }
    }




    @Override
    public void stop(){

        /****************************
         * Your stop code goes here.
         ****************************/

        print.close();
    }

}
