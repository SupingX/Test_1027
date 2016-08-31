package com.mycj.protocol.core;

import com.mycj.protocol.bean.MycjMassagerInfo;
import com.mycj.protocol.bean.Result;
import com.mycj.protocol.util.DataUtil;
import com.mycj.protocol.util.LogUtil;
import com.mycj.protocol.write.AbstractMassagerProtocolWrite;

/**
 * 按摩器Write抽象类
 * @author zeej
 *
 */
public class MassagerProtocolWriteManager extends AbstractMassagerProtocolWrite {

	private static MassagerProtocolWriteManager mMassagerProtoclWrite;
	private MassagerProtocolWriteManager(){}
	public static MassagerProtocolWriteManager newInstance(){
		if (null == mMassagerProtoclWrite) {
			mMassagerProtoclWrite = new MassagerProtocolWriteManager();
		}
		return mMassagerProtoclWrite;
	}
	
	
	@Override
	public byte[] writeForCurrentMassager() {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.MassagerInfo.getProtocl());
		sb.append(protocl)
			.append(ZERO)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForLoader() {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.Loader.getProtocl());
		sb.append(protocl)
			.append(ZERO)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForPattern() {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.Pattern.getProtocl());
		sb.append(protocl)
			.append(ZERO)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForPower() {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.Power.getProtocl());
		sb.append(protocl)
			.append(ZERO)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForTime() {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.Time.getProtocl());
		sb.append(protocl)
			.append(ZERO)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForTemperature() {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.Temperature.getProtocl());
		sb.append(protocl)
			.append(ZERO)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForHeartRate() {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.HeartRate.getProtocl());
		sb.append(protocl)
			.append(ZERO)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForStartMassager(MycjMassagerInfo info) {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.START.getProtocl());
		int pattern = info.getPattern();
		int power = info.getPower();
		int settingTime = info.getSettingTime();
		int temperature = info.getTemperature();
		int tempUnit = info.getTempUnit();
		
		sb.append(protocl)
			.append(DataUtil.toHexString(pattern))
			.append(DataUtil.toHexString(power))
			.append(toHexStringBySize(settingTime,4))
			.append(DataUtil.toHexString(temperature))
			.append(DataUtil.toHexString(tempUnit))
			.append(ZERO)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForStopMassager() {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.STOP.getProtocl());
		sb.append(protocl)
			.append(ZERO)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForChangePattern(int pattern) {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.ChangePatternCallBack.getProtocl());
		String patternStr = DataUtil.toHexString(pattern);
		sb.append(protocl)
			.append(patternStr)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForChangePower(int power) {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.ChangePowerCallBack.getProtocl());
		String powerStr = DataUtil.toHexString(power);
		sb.append(protocl)
			.append(powerStr)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForChangeTime(int time) {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.ChangeTimeCallBack.getProtocl());
		String timeStr = toHexStringBySize(time,4);
		sb.append(protocl)
			.append(timeStr)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log(result);
		return DataUtil.hexStringToByte(result);
	}

	@Override
	public byte[] writeForChangeTemperature(int temp, int unit) {
		StringBuffer sb = new StringBuffer();
		String protocl = DataUtil.toHexString(Result.ChangeTemperatureCallBack.getProtocl());
		String tempStr = toHexStringBySize(temp,2);
		String tempUnitStr = toHexStringBySize(unit,2);
		sb.append(protocl)
			.append(tempStr)
			.append(tempUnitStr)
			.append(ZERO)
			.append(ZERO)
			;
		String result = sb.toString();
		LogUtil.log( result);
		return DataUtil.hexStringToByte(result);
	}



	
	
	
}
