package simple;

import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.xinjian.wechat.service.message.response.Article;
import com.xinjian.wechat.service.message.response.NewsResMessage;

/**
 * @author xinjianhou
 *
 * @date Mar 11, 2018
 */
public class XStreamTest {

	/**
	 * <p>Title: main </p>
	 * <p>Description: </p>
	 * @param args
	 */
	public static void main(final String[] args) {

		final NewsResMessage mes = new NewsResMessage();

		mes.setArticleCount(1);
		final ArrayList<Article> arts = new ArrayList<Article>();
		final Article art= new Article();
		art.setTitle("pop");
		arts.add(art);
		mes.setArticles(arts);
		mes.setToUserName("xinjian");
		mes.setMsgType("News");
		mes.setCreateTime(20180310);
		mes.setFromUserName("vincent");

		final String xml = objectToXML(mes);
		System.out.print(xml);
	}

	/**
	 * <p>Title: objectToXML </p>
	 * <p>Description: </p>
	 * @param o
	 * @return
	 */
	public static String objectToXML(final NewsResMessage o) {
		final XStream xs = new XStream();
		xs.alias("News", o.getClass());
		xs.alias("Article", o.getArticles().get(0).getClass());
		return xs.toXML(o);
	}

}
