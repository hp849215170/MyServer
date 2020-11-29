package m.hp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import m.hp.entity.UserDataEntity;
import m.hp.entity.UserJsonRoot;
import m.hp.opt.CSOption;

@WebServlet(name = "SyncUserDataServlet", urlPatterns = "/SyncUserDataServlet")
public class SyncUserDataServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		sendRequest(request, response);
	}

	protected void sendRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");

		PrintWriter writer = response.getWriter();// 向客户端发送数据

		String remoteAddr = request.getRemoteAddr();

		System.out.println(remoteAddr + "发来的消息");

		if (remoteAddr.equals("127.0.0.1")) {
			// CSOption.deleteAll();
		}
		// 获取浏览器发来的消息
		String contentType = request.getContentType();
		// System.out.println("contentType----" + contentType);

		if ("application/x-www-form-urlencoded".equals(contentType)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("userinfo=" + username + ":" + password);
			if (username.equals("hp") && password.equals("hp123456")) {
				writer.print(true);
				System.out.print("正确");
			} else {
				writer.print(false);
				System.out.print("错误");
			}
		} else {

			response.setCharacterEncoding("UTF-8");

			// 获取客户端发来的消息
			BufferedReader reader = request.getReader();
			String s = reader.readLine();
			System.out.println("客户端发来的消息----" + s);
			if (s == null) {
				return;
			}
			JSONObject parseObject = JSON.parseObject(s);
			String option = parseObject.getString("option");

			List<UserDataEntity> userList = null;
			List<UserDataEntity> sameUserList;
			if (option.equals("insert")) {
				List<UserDataEntity> allUserData = CSOption.findAll();
				userList = new ArrayList<>();
				sameUserList = new ArrayList<>();
				boolean theSame = false;
				JSONArray jsonArray = parseObject.getJSONArray("userList");
				for (int i = 0; i < jsonArray.size(); i++) {
					Integer id = jsonArray.getJSONObject(i).getInteger("id");
					String buyTime = jsonArray.getJSONObject(i).getString("buyTime");
					String carNumber = jsonArray.getJSONObject(i).getString("carNumber");
					String carSerialNumber = jsonArray.getJSONObject(i).getString("carSerialNumber");
					String lastDate = jsonArray.getJSONObject(i).getString("lastDate");
					String type = jsonArray.getJSONObject(i).getString("type");
					String userName = jsonArray.getJSONObject(i).getString("userName");
					String phone = jsonArray.getJSONObject(i).getString("phone");
					String remark = jsonArray.getJSONObject(i).getString("remarks");
					Double cashBack = jsonArray.getJSONObject(i).getDouble("cashBack");
					Double jcPrice = jsonArray.getJSONObject(i).getDouble("jcPrice");
					Double jcRebate = jsonArray.getJSONObject(i).getDouble("jcRebate");
					Double jqPrice = jsonArray.getJSONObject(i).getDouble("jqPrice");
					Double jqRebate = jsonArray.getJSONObject(i).getDouble("jqRebate");
					Double syPrice = jsonArray.getJSONObject(i).getDouble("syPrice");
					Double syRebate = jsonArray.getJSONObject(i).getDouble("syRebate");
					//判断车架号是否重复
					for (int j = 0; j < allUserData.size(); j++) {
						if (carSerialNumber.equals(allUserData.get(j).getCarSerialNumber())) {
							theSame = true;
							System.out.println("车架号：" + carSerialNumber + "重复");
							break;
						} else {
							theSame = false;
						}
					}
					UserDataEntity user = new UserDataEntity(id, carNumber, userName, lastDate, buyTime,
							carSerialNumber, phone, syPrice, jqPrice, jcPrice, syRebate, jqRebate, jcRebate,
							cashBack, type, remark);
					if (!theSame) {
						userList.add(user);
					}else {
						sameUserList.add(user);
					}
				}
				//记录更新的数据条数
				int count = 0;
				
				
				for (int i = 0; i < userList.size(); i++) {
					CSOption.insert(userList.get(i));
					count++;
				}
				//对比数据是否有更改
				for (int i = 0; i < sameUserList.size(); i++) {
					String carSerialNumber = sameUserList.get(i).getCarSerialNumber();
					String carnumber = sameUserList.get(i).getCarNumber();
					String username = sameUserList.get(i).getUserName();
					String buyTimeString = sameUserList.get(i).getBuyTime();
					String lastDate = sameUserList.get(i).getLastDate();
					String type = sameUserList.get(i).getType();
					String phone = sameUserList.get(i).getPhone();
					String remarks = sameUserList.get(i).getRemarks();
					double cashBack = sameUserList.get(i).getCashBack();
					double jcPrice = sameUserList.get(i).getJcPrice();
					double jcRebate = sameUserList.get(i).getJcRebate();
					double jqPrice = sameUserList.get(i).getJqPrice();
					double jqRebate = sameUserList.get(i).getJqRebate();
					double syPrice = sameUserList.get(i).getSyPrice();
					double syRebate = sameUserList.get(i).getSyRebate();
		
					for (int j = 0; j < allUserData.size(); j++) {
						
						if (carSerialNumber.equals(allUserData.get(j).getCarSerialNumber())) {

							if (!carnumber.equals(allUserData.get(j).getCarNumber())||//车牌不相同
								!username.equals(allUserData.get(j).getUserName())||//投保人不相同
								!buyTimeString.equals(allUserData.get(j).getBuyTime())||//续保时间不相同
								!lastDate.equals(allUserData.get(j).getLastDate())||//终保时间不相同
								!type.equals(allUserData.get(j).getType())||//客户来源不相同
								!phone.equals(allUserData.get(j).getPhone())||//手机号不相同
								!remarks.equals(allUserData.get(j).getRemarks())||//备注不相同
								cashBack!=allUserData.get(j).getCashBack()||//返现不相同
								jcPrice!=allUserData.get(j).getJcPrice()||//驾乘险保费不相同
								jcRebate!=allUserData.get(j).getJcRebate()||//驾乘点数不相同
								jqPrice!=allUserData.get(j).getJqPrice()||//交强险保费不相同
								jqRebate!=allUserData.get(j).getJqRebate()|//交强险点数不相同
								syPrice!=allUserData.get(j).getSyPrice()||//商业险保费不相同
								syRebate!=allUserData.get(j).getSyRebate()) {//商业险点数不相同
								CSOption.update(sameUserList.get(i));//更新用户信息
								count++;
								System.out.println("比较的次数："+count);
							}
						}
						break;		
					}
				}
				if (count == 0) {
					// writer.println(URLEncoder.encode("云端数据已经是最新了", "utf-8"));
					writer.println("云端数据已经是最新了");
				} else {
					writer.println("更新了" + count + "条数据");

				}
			} else if (option.equals("findAll")) {
				List<UserDataEntity> allUserData = CSOption.findAll();
				UserJsonRoot userJsonRoot = new UserJsonRoot();
				userJsonRoot.setOption("findAll");
				userJsonRoot.setUserList(allUserData);
				String allUsesJson = JSONArray.toJSONString(userJsonRoot); // 发送数据 
				writer.println(allUsesJson); 
//				writer.println(URLEncoder.encode(allUsesJson, "utf-8"));
			}
		}
	}
}
