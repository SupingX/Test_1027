package com.mycj.protocol.write;

import com.mycj.protocol.bean.MycjMassagerInfo;


/**
 * 按摩器统一接口协议 Write
 * 
 * @author zeej
 *
 */
public interface IMassagerProtocolWrite  {
	/**
	 * 获取当前按摩信息 DO
	 * 
	 * @return
	 */
	public byte[] writeForCurrentMassager();
	
	/**
	 * 获取当前负载 D1
	 * 
	 * @return
	 */
	public byte[] writeForLoader();
	
	/**
	 * 获取当前模式 D2
	 * 
	 * @return
	 */
	public byte[] writeForPattern();
	
	/**
	 * 获取当前力度 D4
	 * 
	 * @return
	 */
	public byte[] writeForPower();
	
	/**
	 * 获取当前时间 D6
	 * @return
	 */
	public byte[] writeForTime();
	
	/**
	 * 获取当前温度 D8
	 * 
	 * @return
	 */
	public byte[] writeForTemperature();
	
	/**
	 * 获取当前心率 D9
	 * 
	 * @return
	 */
	public byte[] writeForHeartRate();
	
	/**
	 * 开始按摩 DF
	 * @param info
	 * @return
	 */
	public byte[] writeForStartMassager(MycjMassagerInfo info);
	
	/**
	 * 结束按摩
	 * @return
	 */
	public byte[] writeForStopMassager();
	
	/**
	 * 切换模式D3
	 * @param pattern
	 * @return
	 */
	public byte[] writeForChangePattern(int pattern);
	
	/**
	 * 切换力度D5
	 * 
	 * @return
	 */
	public byte[] writeForChangePower(int power);
	
	/**
	 * 切换时间D6
	 * 
	 * @param time 单位：秒
	 * @return
	 */
	public byte[] writeForChangeTime(int time);
	
	/**
	 * 切换温度 D9
	 * @param temp
	 * @param unit 单位-0:摄氏度；1:华氏度
	 * @return
	 */
	public byte[] writeForChangeTemperature(int temp,int unit);
	
	
}
