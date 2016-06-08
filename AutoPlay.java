package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.io.*;
import java.util.Scanner;
/**
 * Created by skye on 6/8/16.
 */
public class AutoPlay extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException{
        File f = new File("/sdcard/FIRST/autorec.txt");

        try {
            Scanner scan = new Scanner(f);


          while (scan.hasNextLine()) {

              boolean a = Boolean.parseBoolean(scan.next());
              boolean b = Boolean.parseBoolean(scan.next());
              boolean y = Boolean.parseBoolean(scan.next());
              boolean x = Boolean.parseBoolean(scan.next());

              boolean shift_a = Boolean.parseBoolean(scan.next());
              boolean shift_b = Boolean.parseBoolean(scan.next());
              boolean shift_y = Boolean.parseBoolean(scan.next());
              boolean shift_x = Boolean.parseBoolean(scan.next());

              boolean left_bumper = Boolean.parseBoolean(scan.next());
              boolean right_bumper = Boolean.parseBoolean(scan.next());

              boolean dpad_down = Boolean.parseBoolean(scan.next());
              boolean dpad_right = Boolean.parseBoolean(scan.next());
              boolean dpad_up = Boolean.parseBoolean(scan.next());
              boolean dpad_left = Boolean.parseBoolean(scan.next());

              boolean shift_dpad_down = Boolean.parseBoolean(scan.next());
              boolean shift_dpad_right = Boolean.parseBoolean(scan.next());
              boolean shift_dpad_up = Boolean.parseBoolean(scan.next());
              boolean shift_dpad_left = Boolean.parseBoolean(scan.next());

              double left_trigger = Double.parseDouble(scan.next());
              double shift_left_trigger = Double.parseDouble(scan.next());
              double right_trigger = Double.parseDouble(scan.next());
              double shift_right_trigger = Double.parseDouble(scan.next());

              double left_stick_y = Double.parseDouble(scan.next());
              double left_stick_x = Double.parseDouble(scan.next());
              double right_stick_y = Double.parseDouble(scan.next());
              double right_stick_x = Double.parseDouble(scan.next());

              double shift_left_stick_y = Double.parseDouble(scan.next());
              double shift_left_stick_x = Double.parseDouble(scan.next());
              double shift_right_stick_y = Double.parseDouble(scan.next());
              double shift_right_stick_x = Double.parseDouble(scan.next());

              scan.nextLine();
              /*******************************************
               * Plug the variables in for your code here
               *******************************************/


              waitOneFullHardwareCycle();
          }
        }
        catch(IOException e){

        }
    }
}
