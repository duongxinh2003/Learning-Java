package day3;

import com.entity.Buses;
import com.entity.ExternalBus;
import com.entity.InternalBus;

import day2.iParent;
import day2.iRobo;

public class ExplicitConvertObjectRefType {
	public static void main(String[] args) {
		Buses buses = new Buses();
		InternalBus internalBus = new InternalBus();
		ExternalBus externalBus = (ExternalBus) buses;
//		internalBus = externalBus;
		iParent iParent = (iParent) internalBus;
//		iParent = (iParent) externalBus; //externalBus make final
		InternalBus a1 = new InternalBus(), a2;
		buses = a1;
		a2 = (InternalBus) buses;
	}
}
