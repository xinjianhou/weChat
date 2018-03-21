/**
 * @Title: HttpPostUploadUtil.java
 * @Package com.shunxin.wechat.util
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 14, 2018 8:50:41 PM
 * @version V1.0
 */

package com.shunxin.wechat.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;

/**
 * <p>Title: HttpPostUploadUtil</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 14, 2018
 */
public class HttpPostUploadUtil {

	/**
	 * @Fields urlStr : TODO
	 */
	private final String urlStr;

	/**
	 * <p>Title: </p>
	 * <p>Description: 构造函数</p>
	 * @param type
	 */
	public HttpPostUploadUtil(final String type){

		urlStr = GlobalConstants.getString("mediaUrl")+GlobalConstants.getString("access_token")+"&type="+type;
	}

	/**
	 * <p>Title: formUpload </p>
	 * <p>Description: 上传图片 </p>
	 * @param textMap
	 * @param fileMap
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String formUpload(final Map<String, String> textMap,
			final Map<String, String> fileMap) {
		String res = "";
		HttpURLConnection conn = null;
		final String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
		try {
			final URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn
			.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
			conn.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=" + BOUNDARY);

			final OutputStream out = new DataOutputStream(conn.getOutputStream());
			// text
			if (textMap != null) {
				final StringBuffer strBuf = new StringBuffer();
				final Iterator<?> iter = textMap.entrySet().iterator();
				while (iter.hasNext()) {
					final Map.Entry entry = (Map.Entry) iter.next();
					final String inputName = (String) entry.getKey();
					final String inputValue = (String) entry.getValue();
					if (inputValue == null) {
						continue;
					}
					strBuf.append("\r\n").append("--").append(BOUNDARY).append(
							"\r\n");
					strBuf.append("Content-Disposition: form-data; name=\""
							+ inputName + "\"\r\n\r\n");
					strBuf.append(inputValue);
				}
				out.write(strBuf.toString().getBytes());
			}

			// file
			if (fileMap != null) {
				final Iterator<?> iter = fileMap.entrySet().iterator();
				while (iter.hasNext()) {
					final Map.Entry entry = (Map.Entry) iter.next();
					final String inputName = (String) entry.getKey();
					final String inputValue = (String) entry.getValue();
					if (inputValue == null) {
						continue;
					}
					final File file = new File(inputValue);
					final String filename = file.getName();
					String contentType = new MimetypesFileTypeMap()
							.getContentType(file);
					if (filename.endsWith(".jpg")||filename.endsWith(".JPG")) {
						contentType = "image/jpg";
					}else {
						contentType = "image/png";
					}
					if (contentType == null || contentType.equals("")) {
						contentType = "application/octet-stream";
					}

					final StringBuffer strBuf = new StringBuffer();
					strBuf.append("\r\n").append("--").append(BOUNDARY).append(
							"\r\n");
					strBuf.append("Content-Disposition: form-data; name=\""
							+ inputName + "\"; filename=\"" + filename
							+ "\"\r\n");
					strBuf.append("Content-Type:" + contentType + "\r\n\r\n");

					out.write(strBuf.toString().getBytes());

					final DataInputStream in = new DataInputStream(
							new FileInputStream(file));
					int bytes = 0;
					final byte[] bufferOut = new byte[1024];
					while ((bytes = in.read(bufferOut)) != -1) {
						out.write(bufferOut, 0, bytes);
					}
					in.close();
				}
			}

			final byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
			out.write(endData);
			out.flush();
			out.close();

			// 读取返回数据
			final StringBuffer strBuf = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				strBuf.append(line).append("\n");
			}
			res = strBuf.toString();
			reader.close();
			reader = null;
		} catch (final Exception e) {
			System.out.println("发送POST请求出错。" + urlStr);
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
				conn = null;
			}
		}
		return res;
	}
}
