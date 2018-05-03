/**
 * @Title: RedisCacheConfig.java
 * @Package com.xinjian.wechat.util
 * @Description: TODO
 * @author xinjianhou
 * @date May 2, 2018 12:28:18 PM
 * @version V1.0
 */

package com.xinjian.wechat.util;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>Title: RedisCacheConfig</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date May 2, 2018
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
	/**
	 * @Fields jedisConnectionFactory : TODO
	 */
	private volatile JedisConnectionFactory jedisConnectionFactory;
	/**
	 * @Fields redisTemplate : TODO
	 */
	private volatile RedisTemplate<String, String> redisTemplate;
	/**
	 * @Fields redisCacheManager : TODO
	 */
	private volatile RedisCacheManager redisCacheManager;

	/**
	 * <p>Title: </p>
	 * <p>Description: </p>
	 */
	public RedisCacheConfig() {
		super();
	}

	/**
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * @param jedisConnectionFactory
	 * @param redisTemplate
	 * @param redisCacheManager
	 */
	public RedisCacheConfig(final JedisConnectionFactory jedisConnectionFactory, final RedisTemplate<String, String> redisTemplate,
			final RedisCacheManager redisCacheManager) {
		this.jedisConnectionFactory = jedisConnectionFactory;
		this.redisTemplate = redisTemplate;
		this.redisCacheManager = redisCacheManager;
	}

	/**
	 * <p>Title: customKeyGenerator </p>
	 * <p>Description: </p>
	 * @return
	 */
	@Bean
	public KeyGenerator customKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(final Object target, final Method method, final Object... objects) {
				final StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (final Object obj : objects) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}

		};
	}

	/**
	 * <p>Title: getJedisConnecionFactory </p>
	 * <p>Description: </p>
	 * @return
	 */
	public JedisConnectionFactory getJedisConnecionFactory() {
		return jedisConnectionFactory;
	}

	/**
	 * <p>Title: getRedisCacheManager </p>
	 * <p>Description: </p>
	 * @return
	 */
	public RedisCacheManager getRedisCacheManager() {
		return redisCacheManager;
	}

	/**
	 * <p>Title: getRedisTemplate </p>
	 * <p>Description: </p>
	 * @return
	 */
	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}
}
