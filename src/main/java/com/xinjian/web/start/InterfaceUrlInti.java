package com.xinjian.web.start;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.xinjian.wechat.util.GlobalConstants;

/**
 * @author xinjianhou
 *
 * @date Mar 11, 2018
 */
public class InterfaceUrlInti {

	/**
	 * <p>Title: init </p>
	 * <p>Description: </p>
	 */
	public synchronized static void init(){
		final ClassLoader cl = Thread.currentThread().getContextClassLoader();
		final Properties props = new Properties();
		if(GlobalConstants.interfaceUrlProperties==null){
			GlobalConstants.interfaceUrlProperties = new Properties();
		}
		InputStream in = null;
		try {
			in = cl.getResourceAsStream("property/interface_url.properties");
			props.load(in);
			for(final Object key : props.keySet()){
				GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
			}

			in = cl.getResourceAsStream("property/wechat.properties");
			props.load(in);
			for(final Object key : props.keySet()){
				GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
			}
			in = cl.getResourceAsStream("property/mail.properties");
			props.load(in);
			for(final Object key : props.keySet()){
				GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
			}

		} catch (final IOException e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
		return;
	}

}
