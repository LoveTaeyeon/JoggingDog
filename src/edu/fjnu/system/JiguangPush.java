package edu.fjnu.system;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class JiguangPush {
	/*
	 * 极光推�??
	 */
	public static void push(String username) {
		String masterSecret = "e7950233e864efce423451ff";
		String appKey = "c83f8bed3a5b1f163bf5c28e";
		JPushClient jPushClient = new JPushClient(masterSecret, appKey);// 初始�?

		PushPayload pushPayload = PushPayload
				.newBuilder()
				.setPlatform(Platform.all())
				// .setAudience(Audience.all())
				.setAudience(Audience.alias(username))
				.setNotification(Notification.alert("֪ͨ�ͻ����ϴ�����"))
				.setMessage(Message.content("jijijijij..........")).build();
		try {
			PushResult result = jPushClient.sendPush(pushPayload);
			System.out.println("success");
			System.out.println(result.msg_id);
			System.out.println(result.sendno);
		} catch (APIConnectionException e) {
			System.out.println("connection error...");
			e.printStackTrace();
		} catch (APIRequestException e) {
			System.out.println("request error...");
			e.printStackTrace();
		}

	}
}
