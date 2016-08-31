package com.mycj.protocol.notify;

public interface IProtocolNotifyManager {
	/**
	 * 解析数据
	 * @param data
	 */
	public void parse(byte[] data);
}
