package com.oracle.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.oracle.daoImpl.UserDaoImpl;
import com.oracle.entity.User;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String flag=request.getParameter("flag");
		   
		 UserDaoImpl udi=new UserDaoImpl();
		 
		 HttpSession session=request.getSession();
		 
		 
		 if("register".equals(flag)){
			 
			 String userName=request.getParameter("name");
			 
			 Boolean result= udi.isUserExist(userName);
			 
			if(result==false){
			 
			User user=new User();
						 
			try {
				BeanUtils.populate(user, request.getParameterMap());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			udi.register(user);
			
			session.setAttribute("user", user);
			
			response.sendRedirect("Login.jsp");
			
			 }else{
			
			response.sendRedirect("register.jsp");
			
			 }
		 } 
		 
		 
		 else if("login".equals(flag)){
			 
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			
			User user=udi.login(name, password);
			
			if(user!=null){
			 
			 session.setAttribute("user", user);
			 
			 response.sendRedirect("MessageServlet?flag=main");
			 
			}else{
				
				request.setAttribute("f", false);
				
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			
			}
			 
		 }	
		 
		 
		 else if("logout".equals(flag)){
			 
			 request.getSession().removeAttribute("user");
			 
			 response.sendRedirect("Login.jsp");
			 
			 
		 }
		 
		 
		 else if("update".equals(flag)){
			 
			 User user=udi.getUserById(((User)session.getAttribute("user")).getId());
			 			 
			 String[] kk=user.getHobby();
			 String hobby="";
			 
			 for(int i=0;i<kk.length;i++){
				 
				 hobby+=kk[i];
			 }
			 
			 session.setAttribute("hobby", hobby);
			 request.setAttribute("user", user);
			 
			
			 
			 request.getRequestDispatcher("forUpdate.jsp").forward(request, response);
		 }
	
		 
		 else if("commitUpdate".equals(flag)){
			 
			 User user=new User();
			 		 
			 try {
				BeanUtils.populate(user, request.getParameterMap());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 udi.update(user);
			 
			 response.sendRedirect("Login.jsp");
		 }
		 
		 
		 else if("showUser".equals(flag)){
			 
			List<User> us=udi.getAllUser();
			
		    request.setAttribute("users", us);
		    			
			request.getRequestDispatcher("show.jsp").forward(request, response);
			 
		 }
		 
		 else if("updateLevel".equals(flag)){
			 
			int level=Integer.parseInt(request.getParameter("level"));
			int id=Integer.parseInt(request.getParameter("id"));
			
			   udi.updateLevel(id, level);
			
			response.sendRedirect("UserServlet?flag=showUser");
			
		 }
		 
		 else if("deleteUser".equals(flag)){
			 
			 Integer id=Integer.parseInt(request.getParameter("id"));
			 
			 udi.delete(id);
			 
			 response.sendRedirect("UserServlet?flag=showUser");
			 
			 
		 }
		 
		 
		 else if("checkUser".equals(flag)){
			 
			 String userName=request.getParameter("name");
			 
			 Boolean result= udi.isUserExist(userName);
			 
			 response.getWriter().print(result);
			 
		 }
		 
		 else if("showSelectUser".equals(flag)){
			 
			 
			 List<User> us=udi.getAllUser();
				
			    request.setAttribute("users", us);
			    
			    Gson gosn=new Gson();
			    
			    String listStr=gosn.toJson(us);
			    
			    response.getWriter().write(listStr);
		 }
		 
		 else if("myinformation".equals(flag)){
			 
			Integer id=Integer.parseInt(request.getParameter("id"));
			
			User u=udi.getUserById(id);
			
			String[] h=u.getHobby();
			
			String hob="";
			
			for(int i=0;i<h.length;i++){
				
				hob+=h[i];
			}
			
			request.setAttribute("info", u);
			
			request.setAttribute("hobby", hob);
			
			request.getRequestDispatcher("showMyInformation.jsp").forward(request, response);
			
			
		 }
		
		 else if("likename".equals(flag)){
			 
			String name=request.getParameter("name");
			
			/*String s1=new String(name.getBytes("iso-8859-1"),"utf-8");
			
			System.out.println(s1);*/
			 
			 List<String> listName=udi.getName(name);
			 
			 System.out.println(listName);
			 
			 Gson gson=new Gson();
			 
			 String s=gson.toJson(listName);
			 
			 response.getWriter().write(s);
			 
		 }
		 
				
	}

}
