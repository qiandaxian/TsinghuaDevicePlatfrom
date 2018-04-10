package com.cictec.middleware.tsinghua.codec.message;

import com.cictec.middleware.tsinghua.utils.UUIDGenerator;
import lombok.Data;

import java.util.Date;


@Data
public class TerminalMessage {
	private Long sessionId;
	private Header header;
	private final String uuid;

	public TerminalMessage(){
		this.uuid = UUIDGenerator.genUuidStr();
	}

	public TerminalMessage(Header header){
		this.header = header;
		this.uuid = UUIDGenerator.genUuidStr();
	}

	@Data
	static public class Header{
		/**
		 * 命令字
		 */
		private int messageId;
		/**
		 * 消息长度
		 */
		private int bodyLength;
		/**
		 * 协议版本
		 */
		private String version="1.0";
		/**
		 * 流水号
		 */
		private int messageSequence;
		/**
		 * 发送时间
		 */
		private Date sendTime;
		/**
		 * 终端编号
		 */
		private String terminalId;
		/**
		 * 线路编号
		 */
		private int lineId;
		/**
		 * 数据标识 
		 */
		private int dataFlag;
		/**
		 * 校验和
		 */
		private int validateCode;
		/**
		 * 是否为实时数据
		 */
		private boolean realTimeData;

	}
}
