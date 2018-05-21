package com.cictec.middleware.tsinghua.tcp.handler;

import com.alibaba.fastjson.JSON;

import com.cictec.middleware.tsinghua.config.Constants;
import com.cictec.middleware.tsinghua.config.ResultCode;
import com.cictec.middleware.tsinghua.entity.po.TDevice;
import com.cictec.middleware.tsinghua.service.TDeviceService;
import com.cictec.middleware.tsinghua.tcp.SessionManager;
import com.cictec.middleware.tsinghua.tcp.annotation.HandleMessages;
import com.cictec.middleware.tsinghua.tcp.handler.base.AbstractReceiverHandler;
import com.cictec.middleware.tsinghua.tcp.message.TerminalMessage;
import com.cictec.middleware.tsinghua.tcp.message.request.TerminalAuthenticationRequest;
import com.cictec.middleware.tsinghua.tcp.message.response.PlatformGeneralResponse;
import com.cictec.middleware.tsinghua.utils.DateUtils;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 连接信息请求处理类TerminalConnectRequestHandler类
 * 
 * @file TerminalConnectRequestHandler.java
 * @author zoboy
 * @version 2.0.0 Copyright(C), 2017 xi'an Coordinates Software Development Co.,
 *          Ltd.
 */
@HandleMessages(0x0102)
@Component
public class TerminalConnectRequestHandler extends AbstractReceiverHandler {

	private static Logger logger = LoggerFactory.getLogger(TerminalConnectRequestHandler.class);

	@Value("${media.authentication.check}")
	private boolean authenticationKeyCheck;
	@Autowired
	private TDeviceService tDeviceService;
	@Autowired
	private SessionManager sessionManager;
	
	@Override
	public void handleMessage(TerminalMessage msg, IoSession session) {

		TerminalAuthenticationRequest tcr = (TerminalAuthenticationRequest) msg;
		String id=UUID.randomUUID().toString();
//		logger.info("终端 {}  Session {} 连接请求  鉴权码{}  ", tcr.getTerminalId(),msg.getSessionId(), tcr.getAuthenticationKey());

		String resultContent =  "设备请求登录，鉴权码："+tcr.getAuthenticationKey();
		
		recodeLogToEs("", id, new Date(), ResultCode.MES_LOGIN, resultContent);

		TDevice device =tDeviceService.findByDevCode(tcr.getTerminalId());

		if (authenticationKeyCheck&&device!=null&&device.getDevKey()!=null&&device.getDevKey()!=""){
			if (!device.getDevKey().equals(tcr.getAuthenticationKey())){
				device = null;
			}
		}


		TerminalMessage.Header platformGeneralResponseHeader = new TerminalMessage.Header(0x8001);
		platformGeneralResponseHeader.setTerminalId(tcr.getHeader().getTerminalId());
		platformGeneralResponseHeader.setMessageSequence(tcr.getHeader().getMessageSequence());

		PlatformGeneralResponse platformGeneralResponse = new PlatformGeneralResponse(platformGeneralResponseHeader);

		platformGeneralResponse.setResponseMsgId(tcr.getHeader().getMessageId());
		platformGeneralResponse.setResponseSequence(tcr.getHeader().getMessageSequence());

		if (device != null && device.getDevCode() != null && !"".equals(device.getDevCode())) {

			sessionManager.tmpToRegistered(session.getId(), device.getDevCode());
			device.setDevOnlineStatus(Constants.VAL_LOGIN_ONLINE);
			device.setDevUpdateTime(new Date());
			tDeviceService.update(device);
			platformGeneralResponse.setResponseResult(PlatformGeneralResponse.RESPONSE_RESULT_SUCCESS);
			sendMessageToTerminal(platformGeneralResponse, session);
			resultContent =  "设备编号："+device.getDevCode()+" 登录成功！状态：‘在线’！";
			recodeLogToEs(device.getDevCode(), id,new Date(), ResultCode.MES_SUCCESS+"", resultContent);
		} else {
			platformGeneralResponse.setResponseResult(PlatformGeneralResponse.RESPONSE_RESULT_FALSE);
			sendMessageToTerminal(platformGeneralResponse, session);
			sessionManager.closeSession(session.getId(), true);
			resultContent =  "该鉴权码:["+tcr.getAuthenticationKey()+"] 没有找到对应的设备信息，请您 登录 多媒体管理系统 在 【设备管理】 中 补充相关信息后重新注册获取鉴权码！";
			recodeLogToEs("", id,new Date(), ResultCode.MES_FAILED+"", resultContent);
		}
	}
	
	private void recodeLogToEs(String deviceId,String id, Date date,String resultCode,String resultContent){
		Map<String,String> map=new HashMap<String,String>();
		map=new HashMap<String,String>();
		map.put("esname",ResultCode.ES_NAME);
		map.put("command", ResultCode.MES_LOGIN_NAME);
		map.put("agreement", ResultCode.JT808);
		map.put("id",id);
		map.put("deviceId", deviceId);
		map.put("date", DateUtils.formatDateTime(date));
		map.put("time", DateUtils.formatTime(date));
		map.put("type", ResultCode.MES_LOGIN+"");
		map.put("resultCode", resultCode);
		map.put("result", resultContent);
		logger.info(JSON.toJSONString(map));
	}
	
}
