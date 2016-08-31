package com.mycj.protocol.core;


import com.mycj.protocol.bean.MycjMassagerInfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

public class ProtocolBroadcastReceiver extends BroadcastReceiver {
	/**
	 * 设置初始的masagerinfo 可重写
	 * @param info 原来的massagerInfo
	 * @return settingInfo 初始值的info
	 */
	protected MycjMassagerInfo setDefaultMassagerInfo(MycjMassagerInfo info){
		if (info == null) {
			info = new MycjMassagerInfo(0, 0, 1, 10*60, 10*60, 10, 0, 0, 0);
		}else{
			if (info.getOpen()==0) {
				info = new MycjMassagerInfo(0, 0, 1, 10*60, 10*60, 10, 0, 0, 0);
			}
		}
		return info;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		Bundle bundle = intent.getExtras();
		if (TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_CHANGE_PATTERN_CALL_BACK)) {
			int stauts = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_STATUS);
			int pattern = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_PATTERN);
			onChangePatternCallBack(stauts,pattern);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_CHANGE_POWER_CALL_BACK)){
			int stauts = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_STATUS);
			int power = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_POWER);
			onChangePowerCallBack(stauts,power);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_CHANGE_TEMPEATURE_CALL_BACK)){
			int stauts = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_STATUS);
			int temp = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_TEMPEATURE);
			int tempUnit = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_TEMPEATURE_UNIT);
			onChangeTempeatureCallBack(stauts,temp,tempUnit);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_CHANGE_TIME_CALL_BACK)){
			int stauts = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_STATUS);
			int time = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_TIME_SETTING);
			onChangeTimeCallBack(stauts,time);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_ELECTRICITY)){
			int totalElect = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_STATUS);
			int leftElect = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_TIME_SETTING);
			onChangeElectricityCallBack(totalElect,leftElect);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_FACTORYRESETSTATUS)){
			int status = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_STATUS);
			onChangeFactoryResetCallBack(status);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_FIRMWAREVERSION)){
			String version = bundle.getString(ProtocolBroadcast.EXTRA_MYCJ_FIRMWAREVERSION);
			onChangeFirmwareVersion(version);
		}else if(TextUtils.equals(action, ProtocolBroadcast.EXTRA_MYCJ_HEARTRATE)){
			int heartRate = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_HEARTRATE);
			onChangeHeartRate(heartRate);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_LOADER)){
			int loader = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_LOADER);
			onChangeLoader(loader);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_MASSAGERINFO)){
			MycjMassagerInfo info = bundle.getParcelable(ProtocolBroadcast.EXTRA_MYCJ_MASSAGERINFO);
			
//			LogUtil.log("广播接受的info ：" + info.toString());
			MycjMassagerInfo data = setDefaultMassagerInfo(info);
			onChangeMassagerInfo(data);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_ERROR)){
			
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_OPEN_OR_CLOSE_CALL_BACK)){
			int status = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_STATUS);
			onChangeOpenOrCloseCallBack(status);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_PATTERN)){
			int pattern = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_PATTERN);
			onChangePattern(pattern);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_POWER)){
			int power = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_POWER);
			onChangePower(power);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_TEMPERATURE)){
			int temp = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_TEMPEATURE);
			int tempUnit = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_TEMPEATURE_UNIT);
			onChangeTemperature(temp,tempUnit);
		}else if(TextUtils.equals(action, ProtocolBroadcast.ACTION_MYCJ_TIME)){
			int time = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_TIME);
			int timeSetting = bundle.getInt(ProtocolBroadcast.EXTRA_MYCJ_TIME_SETTING);
			onChangeTime(time,timeSetting);
		}
	}


	protected void onChangeTime(int time, int timeSetting) {
		
	}


	protected void onChangeTemperature(int temp, int tempUnit) {
		// TODO Auto-generated method stub
		
	}


	protected void onChangePower(int power) {
		
	}

	protected void onChangePattern(int pattern) {
	}

	protected void onChangeOpenOrCloseCallBack(int status) {
		// TODO Auto-generated method stub
		
	}

	protected void onChangeMassagerInfo(MycjMassagerInfo info) {
		// TODO Auto-generated method stub
		
	}

	protected void onChangeLoader(int loader) {
		// TODO Auto-generated method stub
		
	}

	protected void onChangeHeartRate(int heartRate) {
		// TODO Auto-generated method stub
		
	}

	protected void onChangeFirmwareVersion(String version) {
		// TODO Auto-generated method stub
		
	}

	protected void onChangeFactoryResetCallBack(int status) {
		// TODO Auto-generated method stub
		
	}

	protected void onChangeElectricityCallBack(int totalElect, int leftElect) {
		// TODO Auto-generated method stub
		
	}

	protected void onChangeTimeCallBack(int stauts, int time) {
		// TODO Auto-generated method stub
		
	}

	protected void onChangeTempeatureCallBack(int stauts, int temp, int tempUnit) {
		// TODO Auto-generated method stub
		
	}

	protected void onChangePowerCallBack(int stauts, int power) {
	}

	protected void onChangePatternCallBack(int stauts, int pattern) {
	}
	
}
