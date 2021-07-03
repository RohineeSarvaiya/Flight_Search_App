package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.UserDao;
import Model.User;


@Controller
public class SignUpController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/signup")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		//fetching username password from the request
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");

		//checking password and confirm password equal
		if (!password.equals(cpassword))
		{
			System.out.println("Password and Confirm password must be same");
			mv.setViewName("signup");
			return mv;
		}

		//saving new user details in the database
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		userDao.saveUser(user);

		//attaching username with view
		mv.addObject("userName", userName);		
		mv.setViewName("login");

		return mv;
	}

}
