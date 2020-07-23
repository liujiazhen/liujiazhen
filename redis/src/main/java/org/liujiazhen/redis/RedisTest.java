package org.liujiazhen.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println(jedis.ping());

        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}