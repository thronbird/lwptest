package redis;

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
				jedis.lpush("bcScheduleOrderCache", "{Bill{billid=1113005515, transactiontype='充值', status='处理中', inputdate=Wed Aug 15 10:24:02 CST 2018, businessrecordnumber='1018081510243410002', businesstype='银联充值', updatedate=Wed Aug 15 14:11:06 CST 2018, refundtype='null', paymethod='bankPay'}");
			}
		} finally {
			jedis.close();
		}

	}
}