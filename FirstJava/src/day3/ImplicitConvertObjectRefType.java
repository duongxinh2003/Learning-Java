package day3;

import java.io.Serializable;

import com.entity.Buses;
import com.entity.ExternalBus;
import com.entity.InternalBus;

import day2.InterfaceTest;
import day2.iParent;
import day2.iRobo;

public class ImplicitConvertObjectRefType {
	public static void main(String[] args) {
		ExternalBus externalBus = new ExternalBus();
		Buses buses = externalBus; //source type is subclass of target type
		iParent iParent = null;
		Object c = iParent; //Target type is object
		InterfaceTest interfaceTest = new InterfaceTest();
		iRobo iRobo = interfaceTest; //Source type is implemented of target type
		iParent = iRobo; //source type is a sub-interface of target type
		int[] intArray = {1,5,3,2};
		c = intArray; //Target type is object
		Serializable serializable = intArray;
		Cloneable cloneable = intArray; //Target type is Serializable or Cloneable
		int[] objectArray = intArray;
		Buses[] busesArray = {buses, new InternalBus()};
		ExternalBus[] externalBusArray = {externalBus};
		busesArray = externalBusArray;
		Object obj = busesArray;
	}
}
