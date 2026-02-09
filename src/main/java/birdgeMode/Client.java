package birdgeMode;

import birdgeMode.airPlanMaker.AirPlaneMaker;
import birdgeMode.airPlanMaker.Boeing;
import birdgeMode.airPlane.AirPlane;
import birdgeMode.airPlane.PassengerAirPlane;

/**
 * Created by marcopan on 17/10/28.
 */
public class Client {
    public static void main(String[] args) {
        AirPlaneMaker planeMaker = new Boeing();
        AirPlane airPlane = new PassengerAirPlane(planeMaker);
        airPlane.fly();
    }
}
