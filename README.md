# FTC7172
FTC 7172 Technical Difficulties code-in-progress

The DualPad class supports the use of multiple Gamepads in FTC programs.
Each driver's gamepad operates the same program, with gamepad1's key commands given priority over gamepad2's.
The Dualpad class makes code neater, denser, and easier to write.

The class also supports recording and replaying controller states - which means you can record robot performances, then replay them from files on your phone. A sample of this implementation is the File Creator and AutoRecord op modes. Run the FileCreator opMode to create files to record robot performance, then use AutoRecord to record and play motions from a single opMode. 

The vision folder contains a preliminary structure for using computer vision in FTC, by pulling images from the robot controller phone's camera, and performing blob detection using OpenCV. 

Team 7172
Created by Matthew Callahan, (Programmer)
           Patrick Michaud,  (Coach)
           Matthew Thomas,   (Mechanical Design)
           Rachael Thompson  (Lead programmer, Captain)
