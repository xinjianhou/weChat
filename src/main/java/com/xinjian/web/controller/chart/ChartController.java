/**
 * @Title: ChartController.java
 * @Package com.xinjian.web.controller.chart
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 14, 2018 9:53:17 AM
 * @version V1.0
 */

package com.xinjian.web.controller.chart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xinjian.web.util.Utils;
import com.xinjian.web.vo.json.PieData;
import com.xinjian.web.vo.json.ReqVo;
import com.xinjian.web.vo.json.ResultVo;

/**
 * <p>Title: ChartController</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 14, 2018
 */
@Controller
public class ChartController {

	@RequestMapping(value = "/getFollowerType.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public @ResponseBody String getFollowerType(final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody final ReqVo reqData){
		final ResultVo val = new ResultVo();
		final String type = reqData.getType();
		final List<PieData> value = new ArrayList<PieData>();
		String title=null;
		if("sex".equalsIgnoreCase(type)) {
			title= "性别";
			final PieData data= new PieData();
			data.setName("男性");
			data.setValue(212);
			final PieData data1= new PieData();
			data1.setName("女性");
			data1.setValue(334);
			final PieData data2= new PieData();
			data2.setName("未知");
			data2.setValue(400);
			value.add(data);
			value.add(data1);
			value.add(data2);

		}else if("age".equalsIgnoreCase(type)){
			title= "年龄";
			final PieData data= new PieData();
			data.setName("50后");
			data.setValue(335);
			final PieData data1= new PieData();
			data1.setName("60后");
			data1.setValue(310);
			final PieData data2= new PieData();
			data2.setName("70后");
			data2.setValue(243);
			final PieData data3= new PieData();
			data3.setName("80后");
			data3.setValue(275);
			final PieData data4= new PieData();
			data4.setName("90后");
			data4.setValue(400);
			final PieData data5= new PieData();
			data5.setName("00后");
			data5.setValue(317);

			value.add(data);
			value.add(data1);
			value.add(data2);
			value.add(data3);
			value.add(data4);
			value.add(data5);

		}
		val.setResult(title);
		val.setLabel(Utils.getFollowerLabe(type));
		val.setValue(value);
		return JSON.toJSONString(val);
	}

	/**
	 * <p>Title: getRecentFollow </p>
	 * <p>Description: </p>
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getRecentFollow.do", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public @ResponseBody String getRecentFollow(final HttpServletRequest request, final HttpServletResponse response){
		final String[] week = Utils.getLastWeek();
		final ResultVo val = new ResultVo();
		val.setLabel(week);
		final int[] data = {120,223,123,45,66,22,345};
		val.setData(data);
		return JSON.toJSONString(val);

	}
}
