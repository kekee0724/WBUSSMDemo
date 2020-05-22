package com.whsxy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * SpringMVC 三层架构
 * 控制层  接受请求
 * 视图层  解析视图
 * 服务层  处理请求
 */

import com.whsxy.entity.User;
import com.whsxy.service.UserService;

/*
 * day02:新知识点
 * 在方法的参赛中添加request，使用request获取到前端传来的数据
 * 在springMVC配置文件中，解析视图解析器
 * 绑定数据：使用request.setAtribute
 *         第一个参数：别名，类似于给数据打个标签，方便查找。可以任意填写
 *         第二个参数：数据，需要绑定的数据.绑定需要将后台中的数据转发到前端的内容之中
 * 
 */

/*
 * 下午课程：
 * 第一步：连接service层
 *       添加注解Resource(name="service层别名")
 */

//controller 控制层
@Controller
public class UserController {

	@Resource(name = "userService")
	UserService service;

	@RequestMapping("demo.do")
	public String doLogin(HttpServletRequest request) throws ServletException, IOException {
		System.out.println("SpringMVC 环境搭建成功");
		request.setCharacterEncoding("utf-8");
		/*
		 * String name = request.getParameter("name"); String pass = "0724";
		 * request.setAttribute("aaa", name); request.setAttribute("bbb", pass);
		 * System.out.println(name);
		 */
		// 创建对象
		User user1 = new User();
		user1.setId(1);
		user1.setName("后裔");
		user1.setPassword("123456");
		user1.setAge(20);

		User user2 = new User();
		user2.setId(2);
		user2.setName("可可");
		user2.setPassword("0724");
		user2.setAge(18);

		User user3 = new User();
		user3.setId(3);
		user3.setName("猛哥");
		user3.setPassword("24679");
		user3.setAge(22);
		// System.out.println(user);

		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		// 绑定对象
		// request.setAttribute("u", user1);
		request.setAttribute("users", users);

		// return "redirect:regist.jsp";
		return "login";
		/*
		 * 转发：return 返回视图，由视图解析器去解析完成 使用时可以将绑定的数据携带上，跳转到新的页面 新的页面可以将绑定的数据，显示到页面之中
		 * 
		 * 重定向：return 跳转页面，但是不经过视图解析器 格式:return "redirect:regist.jsp"; 清除所有request绑定的数据
		 * 
		 * 什么时候使用重定向：在发送请求后，即将跳转的页面，该页面不需要获取后台的数据时，使用重定向
		 * 
		 */
	}

	@RequestMapping("login.do")
	public String doLoginUser(HttpServletRequest request) {
		// 获取前端传来的id
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		System.out.println("帐号：" + id);
		// 获取前端传来的password
		String password = request.getParameter("password");
		System.out.println("密码：" + password);
		// 通过id查找数据库的数据
		User user = service.findUserById(id);
		System.out.println("用户信息：" + user);

		String name = "商学院实训session";
		HttpSession session = request.getSession();
		session.setAttribute("wbu", name);
		if (user == null) {
			// request.getRequestDispatcher("/login").forward(request, response);
			System.out.println("账号不存在，请重新输入");
			String tishi = "账号不存在，请重新输入";
			request.setAttribute("tishi", tishi);
			return "index";
		}
		if (id == user.getId() && password.equals(user.getPassword())) {
			// 代表前端输入的内容和数据库中查找到的数据相匹配
			System.out.println("登录成功，欢迎！");
			// 匹配成功之后，在新的页面显示出数据库User表中所有的数据
			List<User> users = new ArrayList<User>();
			users = service.findAllUser();
			request.setAttribute("users", users);
			System.out.println("users:" + users);
			return "login";
		} else {
			System.out.println("账号与密码不匹配，请重新输入");
			String tishi = "账号与密码不匹配，请重新输入";
			request.setAttribute("tishi", tishi);
			return "index";
		}

	}

	// 删除
	@RequestMapping("delete.do")
	// 获取请求携带的参数：直接在参数列表中，填写发送请求时绑定的内容
	public String doDelete(HttpServletRequest request, int isd) {
		// 获取请求携带的参数
		System.out.println(isd);
		// 除了select 查询语句，其他所有SQL语句不具备返回值
		service.dodeleteUser(isd);

		List<User> users = new ArrayList<User>();
		users = service.findAllUser();
		request.setAttribute("users", users);
		System.out.println("users:" + users);
		return "login";
	}

	// 注册
	@RequestMapping("regist.do")
	public String doRegist(HttpServletRequest request, User user) {
		System.out.println(user);
		service.doregist(user);
		request.setAttribute("user", user);
		return "index";
	}

	// 接收修改请求
	@RequestMapping("update.do")
	public String doUpdate(int id, HttpServletRequest request) {
		User user = service.findUserById(id);
		System.out.println(user);
		request.setAttribute("user", user);
		return null;
	}
	
	// 修改
		@RequestMapping("doupdate.do")
		public String doupdate(User user) {
			service.doupdate(user);
			return "index";
		}

	@RequestMapping("exit.do")
	public String doExit() {
		System.out.println("退出请求");
		return "index";
	}

}
