package onlyfun.js.uitl;

import java.text.SimpleDateFormat;

/**
 * 项目名称：DrivingSchool  <br/>
 * 类名称：DateFormat  <br/>
 * 类描述：  <br/>
 * 创建人：js  <br/>
 * 创建时间：2012-12-6 下午3:58:55  <br/>
 * 修改人：js  <br/>
 * 修改时间：2012-12-6 下午3:58:55  <br/>
 * 修改备注：  <br/>
 * @version  
 */
public class DateFormat {
	public static String formatDate(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
}
