package com.liwanping.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

public class redispipelinetest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		withoutPipeline();
		System.out.println("Without Pipeline takes: " + (System.currentTimeMillis() - start) + " ms.");
		start = System.currentTimeMillis();
		withPipeline();
		System.out.println("With Pipeline takes: " + (System.currentTimeMillis() - start) + " ms.");
	}

	public static void withPipeline() {
		Jedis jedis = null;
		try {
			jedis = new Jedis("192.168.59.100", 6379);
			jedis.flushDB();
			Pipeline p = jedis.pipelined();

			p.set("thekey", Integer.toString(0));

			for (int i = 1; i <= 2000; i++) {
				p.incr("thekey");
			}
			Response<String> r = p.get("thekey");
			p.sync();
			System.out.println(r.get());
		} finally {
			jedis.close();
		}

	}

	public static void withoutPipeline() {
		Jedis jedis = null;

		try {
			jedis = new Jedis("127.0.0.1", 6379);
			jedis.flushDB();
			jedis.set("thekey", Integer.toString(0));

			for (int i = 1; i <= 2000; i++) {
				jedis.incr("thekey");
			}

			System.out.println(jedis.get("thekey"));
		} finally {
			jedis.close();
		}

	}
	@Test
	public  void memoryTest() {
		Jedis jedis = null;
		try {
			jedis = new Jedis("127.0.0.1", 6379);
			jedis.flushDB();
			for (int i = 1; i <= 10000; i++) {
				jedis.lpush("bcScheduleOrderCache", "{\"billid\":1113013691,\"frompartyid\":567947973,\"fromaccountnumber\":\"8801111111377\",\"fromrealname\":\"测试AFS\",\"businessnumber\":\"6318082815284910005\",\"transactiontype\":\"提现\",\"transactionsite\":\"全网\",\"transactiondate\":\"Aug 28, 2018 3:28:23 PM\",\"transactionamount\":\"1.00\",\"description\":\"商户提现\",\"status\":\"成功\",\"inputman\":\"测试AFS\",\"inputdate\":\"Aug 28, 2018 3:28:19 PM\",\"transactionnumber\":\"1118082815285210001\",\"appid\":\"enterprise\",\"terminal\":\"\",\"businessrecordnumber\":\"2918082815283920001\",\"businesstype\":\"商户提现\",\"updatedate\":\"Aug 28, 2018 3:28:23 PM\",\"merchantaccountnumber\":\"5688130133018597\",\"bankcardnumber\":\"11111111111111\",\"channelname\":\"TEST401\",\"customerip\":\"\",\"clientdfp\":\"\",\"tasktime\":\"D0_12\",\"fee\":\"0.00\",\"sign_type\":\"MD5\"}");
			}
		} finally {
			jedis.close();
		}

	}
}