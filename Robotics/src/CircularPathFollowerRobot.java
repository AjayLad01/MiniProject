import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.LightSensor;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;
public class CircularPathFollowerRobot {
static {
RobotContext.useBackground("sprites/yellowpath.gif");
RobotContext.setStartPosition(430,230);
RobotContext.setStartDirection(-90);
}
public CircularPathFollowerRobot() {
// Initi lize equi ed compo ents and add t em
// to t e robot.
LegoRobot legoRobot = ew LegoRobot();
Gear gear = ew Gear();
LightSensor lightSensorL = ew LightSensor(SensorPort.S2);
LightSensor lightSensorR = ew LightSensor(SensorPort.S1);
LightSensor lightSensorM = ew LightSensor(SensorPort.S3);
legoRobot.addPart(gear);
legoRobot.addPart(lightSensorL);
legoRobot.addPart(lightSensorR);
legoRobot.addPart(lightSensorM);
gear.forward();
gear.setSpeed(100);
doub e arcLength = 0.1;
wh le (tr e) {
int lightSensorRValue = lightSensorR.getValue();
int lightSensorDiff = lightSensorRValue - lightSensorL.getValue();
if (lightSensorM.getValue() < 100) {
gear.stop();
}
if(lightSensorDiff > 100) {
gear.rightArc(arcLength);
}
el e if (lightSensorDiff < -100) {
gear.leftArc(arcLength);
}
el e {
if (lightSensorRValue > 500) {
gear.forward();
}
}
}
}
public static void main(String[] args) {
ew Circ larPathFo lowerRobot();
}
}