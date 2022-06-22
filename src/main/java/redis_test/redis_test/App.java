package redis_test.redis_test;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class App {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);
		System.out.println("Connect success! " + jedis.ping());
	
		// String
		jedis.set("hello", "world");
        System.out.println("value: "+ jedis.get("hello"));
        
        // Map
        jedis.hset("myHash", "cat", "meow");
        Map<String, String> hashMap = jedis.hgetAll("myHash");
        System.out.println("map:" + hashMap);
        
        // List
        jedis.lpush("myList", "one");
        jedis.lpush("myList", "two");
        jedis.lpush("myList", "three");
        List<String> list = jedis.lrange("myList", 0 ,-1);
        System.out.println("list:" + list);
        
	}
}
