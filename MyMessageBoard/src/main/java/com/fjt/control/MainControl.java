package com.fjt.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fjt.service.UserService;

/**
 * 
     * @ClassName: 主界面控制器
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author fujiantao
     * @date 2019年8月1日
     *
 */
@Controller
public class MainControl {
	private Logger logger = LoggerFactory.getLogger(UserControl.class);

	@Autowired
	private UserService userService;

	/**
	 * 
	     * @Title: 安全退出
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @author fujiantao
	     * @return String 返回类型
	     * @throws
	 */
	@RequestMapping("retnLongin")
	public String retnLongin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();//注销invalidate.
		return "Longin";

	}
}
