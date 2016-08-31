package com.mycj.protocol.notify;

import com.mycj.protocol.bean.MycjMassagerInfo;


public interface IMassagerProtocolNotifyListener {
	void onParseChangePatternCallBack(String desc, int success, int pattern);
	void onParseMassagerInfo(String desc, MycjMassagerInfo info);
	void onParseLoader(String desc, int loader);
	void onParsePattern(String desc, int pattern);
	void onParsePower(String desc, int power);
	void onParseChangePowerCallBack(String desc, int success, int power);
	void onParseTime(String desc, int leftTime, int settingTime);
	void onParseChangeTimeCallBack(String desc, int success, int settingTime);
	void onParseTemperature(String desc, int temp, int tempUnit);
	void onParseChangeTemperatureCallBack(String desc, int success,int temp, int tempUnit);
	void onParseChangeHeartRate(String desc, int hr);
}
