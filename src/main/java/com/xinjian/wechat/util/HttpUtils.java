/**
 * @Title: HttpUtils.java
 * @Package com.xinjian.wechart.util
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 13, 2018 11:14:12 AM
 * @version V1.0
 */

package com.xinjian.wechat.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * <p>
 * Title: HttpUtils
 * </p>
 * <p>
 * Description:http请求工具类
 * </p>
 *
 * @author xinjianhou
 * @date Mar 13, 2018
 */
public class HttpUtils {
	/**
	 * <p>
	 * Title: buildUrl
	 * </p>
	 * <p>
	 * Description:构建get方式的url
	 * </p>
	 *
	 * @param reqUrl
	 * @param params
	 * @return
	 */
	public static String buildUrl(final String reqUrl, final Map<String, String> params) {
		final StringBuilder query = new StringBuilder();
		final Set<String> set = params.keySet();
		for (final String key : set) {
			query.append(String.format("%s=%s&", key, params.get(key)));
		}
		return reqUrl + "?" + query.toString();
	}

	/**
	 * <p>
	 * Title: getJsonStringFromGZIP
	 * </p>
	 * <p>
	 * Description:从gzip格式里获取json
	 * </p>
	 *
	 * @param is
	 * @return
	 */
	private static String getJsonStringFromGZIP(InputStream is) {
		String jsonString = null;
		try {
			final BufferedInputStream bis = new BufferedInputStream(is);
			bis.mark(2);
			// 取前两个字节
			final byte[] header = new byte[2];
			final int result = bis.read(header);
			// reset 输入流到开始位置
			bis.reset();
			// 判断是否是 GZIP 格式
			final int headerData = getShort(header);
			// Gzip 流 的前两个字节是 0x1f8b
			if (result != -1 && headerData == 0x1f8b) {
				// LogUtil.i("HttpTask", " use GZIPInputStream ");
				is = new GZIPInputStream(bis);
			} else {
				// LogUtil.d("HttpTask", " not use GZIPInputStream");
				is = bis;
			}
			final InputStreamReader reader = new InputStreamReader(is, "utf-8");
			final char[] data = new char[100];
			int readSize;
			final StringBuffer sb = new StringBuffer();
			while ((readSize = reader.read(data)) > 0) {
				sb.append(data, 0, readSize);
			}
			jsonString = sb.toString();
			bis.close();
			reader.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}

		return jsonString;
	}

	/**
	 * <p>
	 * Title: getShort
	 * </p>
	 * <p>
	 * Description: 读取
	 * </p>
	 *
	 * @param data
	 * @return
	 */
	private static int getShort(final byte[] data) {
		return (data[0] << 8) | data[1] & 0xFF;
	}

	/**
	 * <p>
	 * Title: sendGet
	 * </p>
	 * <p>
	 * Description:http get 请求共用方法
	 * </p>
	 *
	 * @param reqUrl
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String sendGet(final String reqUrl, final Map<String, String> params) throws Exception {
		InputStream inputStream = null;
		final HttpGet request = new HttpGet();
		try {
			final String url = buildUrl(reqUrl, params);
			final HttpClient client = HttpClientBuilder.create().build();

			request.setHeader("Accept-Encoding", "gzip");
			request.setURI(new URI(url));

			final HttpResponse response = client.execute(request);

			inputStream = response.getEntity().getContent();
			final String result = getJsonStringFromGZIP(inputStream);
			return result;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			request.releaseConnection();
		}

	}

	/**
	 * <p>
	 * Title: sendPost
	 * </p>
	 * <p>
	 * Description:http post 请求共用方法
	 * </p>
	 *
	 * @param reqUrl
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String sendPost(final String reqUrl, final Map<String, String> params) throws Exception {
		try {
			final Set<String> set = params.keySet();
			final List<NameValuePair> list = new ArrayList<NameValuePair>();
			for (final String key : set) {
				list.add(new BasicNameValuePair(key, params.get(key)));
			}
			if (list.size() > 0) {
				try {
					final HttpClient client = HttpClientBuilder.create().build();
					final HttpPost request = new HttpPost(reqUrl);

					request.setHeader("Accept-Encoding", "gzip");
					request.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));

					final HttpResponse response = client.execute(request);

					final InputStream inputStream = response.getEntity().getContent();
					try {
						final String result = getJsonStringFromGZIP(inputStream);

						return result;
					} finally {
						inputStream.close();
					}
				} catch (final Exception ex) {
					ex.printStackTrace();
					throw new Exception("网络连接失败,请连接网络后再试");
				}
			} else {
				throw new Exception("参数不全，请稍后重试");
			}
		} catch (final Exception ex) {
			ex.printStackTrace();
			throw new Exception("发送未知异常");
		}
	}

	/**
	 * <p>
	 * Title: sendPostBuffer
	 * </p>
	 * <p>
	 * Description: http post 请求 json 数据
	 * </p>
	 *
	 * @param urls
	 * @param params
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String sendPostBuffer(final String urls, final String params)
			throws ClientProtocolException, IOException {
		final HttpPost request = new HttpPost(urls);

		final StringEntity se = new StringEntity(params, "UTF-8");
		se.setContentType("application/json");
		request.setEntity(se);
		// 发送请求
		final HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		// 得到应答的字符串，这也是一个 JSON 格式保存的数据
		final String retSrc = EntityUtils.toString(httpResponse.getEntity());
		request.releaseConnection();
		return retSrc;

	}

	/**
	 * <p>Title: sendXmlPost </p>
	 * <p>Description:http 请求发送 xml 内容 </p>
	 * @param urlStr
	 * @param xmlInfo
	 * @return
	 */
	public static String sendXmlPost(final String urlStr, final String xmlInfo) {
		// xmlInfo xml 具体字符串

		try {
			final URL url = new URL(urlStr);
			final URLConnection con = url.openConnection();
			con.setDoOutput(true);
			con.setRequestProperty("Pragma:", "no-cache");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setRequestProperty("Content-Type", "text/xml");
			final OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
			out.write(new String(xmlInfo.getBytes("utf-8")));
			out.flush();
			out.close();
			final BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String lines = "";
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				lines = lines + line;
			}
			return lines; // 返回请求结果
		} catch (final MalformedURLException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return "fail";
	}

}
