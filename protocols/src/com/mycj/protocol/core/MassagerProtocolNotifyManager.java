package com.mycj.protocol.core;

import com.mycj.protocol.bean.MycjMassagerInfo;
import com.mycj.protocol.bean.Result;
import com.mycj.protocol.notify.BasicProtocolNotifyManager;
import com.mycj.protocol.notify.OnProtocolNotifyListener;
import com.mycj.protocol.util.DataUtil;
import com.mycj.protocol.util.LogUtil;

import android.content.Context;

public class MassagerProtocolNotifyManager extends BasicProtocolNotifyManager{

	public MassagerProtocolNotifyManager(Context context,
			OnProtocolNotifyListener l) {
		super(context, l);
	}

	public MassagerProtocolNotifyManager(ProtocolBroadcast broadcast,
			OnProtocolNotifyListener l) {
		super(broadcast, l);
	}

	public MassagerProtocolNotifyManager(OnProtocolNotifyListener l) {
		super(l);
	}
	
	@Override
	public synchronized void parse(byte[] data) {
		super.parse(data);
		String result = DataUtil.byteToHexString(data);
		String head = result.substring(0, 2);
		int size = data.length;
		try {
			int headInt = Integer.valueOf(head,16);
			if (headInt == Result.ChangePatternCallBack.getProtocl()
					&& size == 6) {
				String data_ok = result.substring(2, 4);
				String data_pattern = result.substring(4, 6);
				int success = Integer.valueOf(data_ok, 16);
				int pattern = Integer.valueOf(data_pattern, 16);
				String desc = getDesc() + "切换模式:"+success+",pattern :" +pattern;
				if (mOnProtocolNotifyListener != null) {
					mOnProtocolNotifyListener.onParseChangePatternCallBack(desc,success,pattern);
				}
				if (broadcast != null) {
					broadcast.sendBroadcastForChangePatternCallBack(success, pattern);
				}
			} else if(headInt == Result.MassagerInfo.getProtocl()
					&& size == 20){
				String data_open = result.substring(2, 4);
				String data_pattern = result.substring(4, 6);
				String data_power = result.substring(6, 8);
				String data_leftTime = result.substring(8, 12);
				String data_settingTime = result.substring(12, 16);
				String data_temp = result.substring(16, 18);
				String data_tempUnit = result.substring(18, 20);
				String data_load = result.substring(20, 22);
				String data_hr = result.substring(22, 24);
				int open = Integer.valueOf(data_open, 16);
				int pattern = Integer.valueOf(data_pattern, 16);
				int power = Integer.valueOf(data_power, 16);
				int leftTime = Integer.valueOf(data_leftTime, 16);
				int settingTime = Integer.valueOf(data_settingTime, 16);
				int temperature = Integer.valueOf(data_temp, 16);
				int tempUnit = Integer.valueOf(data_tempUnit, 16);
				int loader = Integer.valueOf(data_load, 16);
				int hr = Integer.valueOf(data_hr, 16);

				MycjMassagerInfo info = new MycjMassagerInfo(open, pattern,
						power, leftTime, settingTime, temperature, tempUnit,
						loader, hr);
				String desc = getDesc() + "按摩模式:"+info.toString();
				if (mOnProtocolNotifyListener != null) {
					mOnProtocolNotifyListener.onParseMassagerInfo(desc,info);
				}
				if (broadcast != null) {
					broadcast.sendBroadcastForCurrentMassagerInfo(info);
				}
			} else if(headInt == Result.Loader.getProtocl() && size == 4){
				String data_loader = result.substring(2, 4);
				int loader = Integer.valueOf(data_loader, 16);
				String desc = getDesc() + "负载:"+loader;
				if (mOnProtocolNotifyListener != null) {
					mOnProtocolNotifyListener.onParseLoader(desc,loader);
				}
				if (broadcast != null) {
					broadcast.sendBroadcastForLoader(loader);
				}
			} else if(headInt == Result.Pattern.getProtocl() && size == 4){
				String data_pattern = result.substring(2, 4);
				int pattern = Integer.valueOf(data_pattern, 16);
				String desc = getDesc() + "模式:"+pattern;
				if (mOnProtocolNotifyListener != null) {
					mOnProtocolNotifyListener.onParsePattern(desc,pattern);
				}
				if (broadcast != null) {
					broadcast.sendBroadcastForPattern(pattern);
				}
			} else if(headInt == Result.Power.getProtocl() && size == 4){
				String data_power = result.substring(2, 4);
				int power = Integer.valueOf(data_power, 16);
				String desc = getDesc() + "力度:"+power;
				if (mOnProtocolNotifyListener != null) {
					mOnProtocolNotifyListener.onParsePower(desc,power);
				}
				if (broadcast != null) {
					broadcast.sendBroadcastForPower(power);
				}
			} else if(headInt == Result.ChangePowerCallBack.getProtocl()
					&& size == 6){
				String data_ok = result.substring(2, 4);
				String data_power = result.substring(4, 6);
				int success = Integer.valueOf(data_ok, 16);
				int power = Integer.valueOf(data_power, 16) ;//力度为现实的1/2
				String desc = getDesc() + "改变力度:"+success+",power:"+power;
				if (mOnProtocolNotifyListener != null) {
					mOnProtocolNotifyListener.onParseChangePowerCallBack(desc,success,power);
				}
				if (broadcast != null) {
					broadcast.sendBroadcastForChangePowerCallBack(success, power);
				}
			} else if(headInt == Result.Time.getProtocl() && size == 7){
				String data_lefttime = result.substring(2, 6);
				String data_settingtime = result.substring(6, 10);
				int leftTime = Integer.valueOf(data_lefttime, 16);
				int settingTime = Integer.valueOf(data_settingtime, 16);
				String desc = getDesc() + "当前时间:"+leftTime+",设置时间:"+settingTime;
				if (mOnProtocolNotifyListener != null) {
					mOnProtocolNotifyListener.onParseTime(desc,leftTime,settingTime);
				}
				if (broadcast != null) {
					broadcast.sendBroadcastForTime(leftTime, settingTime);
				}
			} else if(headInt == Result.ChangeTimeCallBack.getProtocl()
					&& size == 6){
				String data_ok = result.substring(2, 4);
				String data_settingtime = result.substring(4, 8);
				int success = Integer.valueOf(data_ok, 16);
				int settingTime = Integer.valueOf(data_settingtime, 16);
				String desc = getDesc() + "设置时间:"+success+",settingTime: "+settingTime;
				if (mOnProtocolNotifyListener != null) {
					mOnProtocolNotifyListener.onParseChangeTimeCallBack(desc,success,settingTime);
				}
				if (broadcast != null) {
					broadcast.sendBroadcastForChangeTimeCallBack(success, settingTime);
				}
			} else if(headInt == Result.Temperature.getProtocl() && size == 4){
				String data_temp = result.substring(2, 4);
				String data_temp_unit = result.substring(4, 6);
				int temp = Integer.valueOf(data_temp, 16);
				int tempUnit = Integer.valueOf(data_temp_unit, 16);
				String desc = getDesc() + "当前温度:"+temp+(tempUnit==0?"摄氏度":"华氏度");
				if (mOnProtocolNotifyListener != null) {
					mOnProtocolNotifyListener.onParseTemperature(desc,temp,tempUnit);
				}
				if (broadcast != null) {
					broadcast.sendBroadcastForTemperature(temp, tempUnit);
				}
			} else if(headInt == Result.ChangeTemperatureCallBack.getProtocl()
					&& size == 7){
				String data_ok = result.substring(2, 4);
				String data_temp = result.substring(4, 6);
				String data_temp_unit = result.substring(6, 8);
				int success = Integer.valueOf(data_ok, 16);
				int temp = Integer.valueOf(data_temp, 16);
				int tempUnit = Integer.valueOf(data_temp_unit, 16);
				String desc = getDesc() + "设置温度:"+success+",温度："+temp+(tempUnit==0?"摄氏度":"华氏度");
				if (mOnProtocolNotifyListener != null) {
					mOnProtocolNotifyListener.onParseChangeTemperatureCallBack(desc,success,temp,tempUnit);
				}
				if (broadcast != null) {
					broadcast.sendBroadcastForChangeTemperatureCallBack(success, temp, tempUnit);
				}
			} else if(headInt == Result.HeartRate.getProtocl() && size == 4){
				String data_hr = result.substring(2, 4);
					int hr = Integer.valueOf(data_hr, 16);
					String desc = getDesc() + "当前心率:"+hr;
					if (mOnProtocolNotifyListener != null) {
						mOnProtocolNotifyListener.onParseChangeHeartRate(desc,hr);
					}
					if (broadcast != null) {
						broadcast.sendBroadcastForHeartRate(hr);
					}
			}
			
			
			
			//待续
			
			
			
		} catch (Exception e) {
		}
	}

}
