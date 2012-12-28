package onlyfun.js.uitl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

/**
 * 项目名称：DrivingSchool <br/>
 * 类名称：Json <br/>
 * 类描述： <br/>
 * 创建人：js <br/>
 * 创建时间：2012-12-5 下午4:26:03 <br/>
 * 修改人：js <br/>
 * 修改时间：2012-12-5 下午4:26:03 <br/>
 * 修改备注： <br/>
 * 
 * @version
 */
public class Json {

	/**
	 * 将N组数据转化成Json
	 * 
	 * @param key
	 *            某一条数据的标示符
	 * @param objArrayList
	 *            数据组
	 * @return List<String>
	 */
	public static List<String> toJson(String[] key, List<Object[]> objArrayList) {
		List<String> list = new ArrayList<String>();
		for (Object[] objects : objArrayList) {
			String str = "{";
			int i = 0;
			for (Object object : objects) {
				str += key[i] + ":'" + object + "',";
				i++;
			}
			str = str.substring(0, str.length() - 1);
			str += "}";
			list.add(str);
		}
		return list;
	}

	/**
	 * JsonConfig配置，用于过滤关联对象，比如，Question对象关联的QuestionItem对象。避免Json解析陷入死循环。
	 * @param arg 要过滤的对象
	 * @return 配置好的JsonConfig
	 */
	public static JsonConfig getConfig(final String arg) {
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object arg0, String arg1, Object arg2) {
				if (arg1.equals(arg)) {
					return true;
				} else {
					return false;
				}
			}
		});
		return config;
	}
}
