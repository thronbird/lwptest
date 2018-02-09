package redis;

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
			jedis = new Jedis("192.168.59.100", 6379);
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
}