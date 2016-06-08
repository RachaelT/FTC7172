package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.io.*;

/**
 * Created by skye on 6/8/16.
 */

public class AutoRecord extends OpMode {

    DualPad gpads;
    File f = new File("/sdcard/FIRST/autorec.txt");
    PrintStream p;

    @Override
    public void init(){
        /****************************
         * Your init code goes here
         ****************************/

        gpads = new DualPad();

       //Opens the PrintWriter to write the state of the controller to your file
        try{
           p = new PrintStream(f);
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
        record();
    }

    public void record(){
        /*
        Eval order goes:
        A button
        B button
        Y button
        X button
        Shift-A
        Shift-B
        Shift-Y
        Shift-X

        L Bumper
        R Bumper
        DPAD Down
        DPAD Right
        DPAD Up
        DPAD Left
        Shift-DPAD Down
        Shift-DPAD Right
        Shift-DPAD Up
        Shift-DPAD Left

        //Double Values
        L Trigger
        Shift LTrigger
        R Trigger
        Shift RTrigger
        LJoy Y
        LJoy X
        RJoyY
        RJoy X
     */

        //Boolean values

        gpads.setPads(gamepad1, gamepad2);
        String state = "";

        state += gpads.a;
        state += " ";

        state += gpads.b;
        state += " ";

        state += gpads.y;
        state += " ";

        state += gpads.x;
        state += " ";

        state += gpads.shift_a;
        state += " ";

        state += gpads.shift_b;
        state += " ";

        state += gpads.shift_y;
        state += " ";

        state += gpads.shift_x;
        state += " ";

        state += gpads.left_bumper;
        state += " ";

        state += gpads.right_bumper;
        state += " ";

        state += gpads.dpad_down;
        state += " ";

        state += gpads.dpad_right;
        state += " ";

        state += gpads.dpad_up;
        state += " ";

        state += gpads.dpad_left;
        state += " ";

        state += gpads.shift_dpad_down;
        state += " ";

        state += gpads.shift_dpad_right;
        state += " ";

        state += gpads.shift_dpad_up;
        state += " ";

        state += gpads.shift_dpad_left;
        state += " ";

        //Double Values

        state += gpads.left_trigger;
        state += " ";

        state += gpads.shift_left_trigger;
        state += " ";

        state += gpads.right_trigger;
        state += " ";

        state += gpads.shift_right_trigger;
        state += " ";

        state += gpads.left_stick_y;
        state += " ";

        state += gpads.left_stick_x;
        state += " ";

        state += gpads.right_stick_y;
        state += " ";

        state += gpads.right_stick_x;
        state += " ";

        state += gpads.shift_left_stick_y;
        state += " ";

        state += gpads.shift_left_stick_x;
        state += " ";

        state += gpads.shift_right_stick_y;
        state += " ";


        state += gpads.shift_right_stick_x;
        state += " ";

        p.println(state);
    }


    @Override
    public void stop(){

        /****************************
         * Your stop code goes here.
         ****************************/

        p.close();
    }

}
