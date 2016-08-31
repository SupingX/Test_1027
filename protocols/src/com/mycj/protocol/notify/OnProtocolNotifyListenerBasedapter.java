package com.mycj.protocol.notify;

import com.mycj.protocol.bean.MycjFirmwareVersion;
import com.mycj.protocol.bean.MycjMassagerInfo;

public abstract class OnProtocolNotifyListenerBasedapter implements OnProtocolNotifyListener {

	@Override
	public void onParseChangePatternCallBack(String desc, int success,
			int pattern) {
		
	}

	@Override
	public void onError(String desc) {
		
	}

	@Override
	public void onParseMycjFirmwareVersion(String desc, MycjFirmwareVersion mfv) {
		
	}

	@Override
	public void onParseOpenorCloseCallBack(String desc, int success) {
		
	}

	@Override
	public void onParseElectricity(String desc, int allElect, int leftElect) {
		
	}

	@Override
	public void onParseTest(String desc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParseFactoryResetStatus(String desc, int success) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParseMassagerInfo(String desc, MycjMassagerInfo info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParseLoader(String desc, int loader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParsePattern(String desc, int pattern) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParsePower(String desc, int power) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParseChangePowerCallBack(String desc, int success, int power) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParseTime(String desc, int leftTime, int settingTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParseChangeTimeCallBack(String desc, int success,
			int settingTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParseTemperature(String desc, int temp, int tempUnit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParseChangeTemperatureCallBack(String desc, int success,int temp,
			int tempUnit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParseChangeHeartRate(String desc, int hr) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
