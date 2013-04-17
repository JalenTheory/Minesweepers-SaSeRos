import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

/**
 * @author Joram Ruitenschild
 * Abstraction for the light-sensor
 */
public class ColourSensor {
	private static final String name = "Colour Sensor";
	private static final String port = "S4";
	private static ColorHTSensor cmps = new ColorHTSensor(SensorPort.S4);
	
	
	  
	while(!Button.ESCAPE.isDown()) {
		LCD.clear();
		LCD.drawString(colorSensorTest(), 1, 4);
		LCD.drawInt(SensorPort.S4.readRawValue(),1,5);
		 
		    
		if(blackDetected()){
			LCD.drawString("BLACK", 1, 6); 
		}
		
		LCD.refresh();
		Thread.sleep(INTERVAL);
	}
}

/* public static String colorSensorTest(){
	 if(SensorPort.S4.readRawValue() < 0){return "Color Sensor Fail";}
	 return "Color Sensor Success";
 }*/

	public static boolean blackDetected(){
		if (SensorPort.S4.readRawValue() > 600){
			return true;
		}
		return false;
	}


	
	public static Error checkForFaillure() {
		 if(SensorPort.S4.readRawValue() < 0){
		Error error = new Error(name, port, true);}
		return null;
	}
	
}
