
/**  
 * @Title: MessageControl.java
 * @Package com.fjt.control
 * @Description: TODO(用一句话描述该文件做什么)
 * @author fujiantao
 * @date 2019年9月9日 下午2:59:42 
 * @version V1.0  
 */

package com.fjt.control;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fjt.pojo.Message;
import com.fjt.pojo.User;
import com.fjt.service.MessageService;

/**
 * @ClassName: 留言板控制器
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author fujiantao
 * @date 2019年9月9日
 *
 */
@Controller
@RequestMapping("message")
public class MessageControl {
	private Logger logger = LoggerFactory.getLogger(MessageControl.class);

	@Autowired
	private MessageService messageService;

	/**
	 * 
	     * @Title: 跳转到留言板界面
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @param request
	     * @param @return 参数
	     * @author fujiantao
	     * @return ModelAndView 返回类型
	     * @throws
	 */
	@RequestMapping("showMessageView")
	public ModelAndView showMessageView(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String viewName = "Message";
		modelAndView.setViewName(viewName);
		List<Message> MessageList = messageService.showMessage();
		request.setAttribute("showInfo", MessageList);
		return modelAndView;

	}

	/**
	 * 
	     * @Title: 添加此操作
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @param request
	     * @param @return 参数
	     * @author fujiantao
	     * @return String 返回类型
	     * @throws
	 */
	@RequestMapping("messageAdd")
	@ResponseBody
	public String messageAdd(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String receve = request.getParameter("receve");
		String sendContext = request.getParameter("sendContext");

		try {
			Message message = new Message();
			message.setGetterId(Integer.parseInt(receve));
			message.setSenderId(user.getId());
			message.setConetent(sendContext);
			message.setMessageTime(new Date());
			messageService.saveMessage(message);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("添加失败", e.getMessage());
			return "error";
		}

		return "success";
	}

}
