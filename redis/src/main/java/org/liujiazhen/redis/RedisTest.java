package org.liujiazhen.redis;

import org.liujiazhen.redis.model.User;
import org.liujiazhen.redis.util.SerializeUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

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
        Long age = jedis.incr("age");
        System.out.println(age);
//        User zhangsan = new User("zhangsan", 22);
//        jedis.set(SerializeUtil.serialize("zhangsan"), SerializeUtil.serialize(zhangsan));

        byte[] zhangsans = jedis.get(SerializeUtil.serialize("zhangsan"));
        User o = (User) SerializeUtil.unSerialize(zhangsans);
        System.out.println(o);

    }
    static void jedisTest() {
        JedisPoolConfig config = new JedisPoolConfig();
    }
}