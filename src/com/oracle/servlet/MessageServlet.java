package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.UserDao;
import com.oracle.daoImpl.MessageDaoImpl;
import com.oracle.daoImpl.UserDaoImpl;
import com.oracle.entity.Message;
import com.oracle.entity.User;


public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
           String flag=request.getParameter("flag");
           
           HttpSession session=request.getSession();
           
           MessageDaoImpl mdi=new MessageDaoImpl();
           
           if("add".equals(flag)){
        	   
        	   String content=request.getParameter("content");
        	   String toName=request.getParameter("toName");
        	   
        	   User  user=(User)session.getAttribute("user");
        	   
        	    Message message=new Message();
        	    
        	    message.setContent(content);
        	    message.setToName(toName);
        	    message.setFromImg(user.getCartoon());
        	    message.setFromName(user.getName());
        	    
        	    mdi.addMessage(message);
        	    
        	    response.sendRedirect("MessageServlet?flag=main");
           }
           
           else if("main".equals(flag)){
        	   
        	   UserDao ud=new UserDaoImpl();
        	   
        	   List<User> list=ud.getAllUser();
        	   
        	   request.setAttribute("us", list);

        	   List<Message> ms=mdi.getAllMessage();
     	     
        	   request.setAttribute("ms", ms);
        	  
        	   request.getRequestDispatcher("main.jsp").forward(request, response);
        	   
           }
           
           else if("myMessage".equals(flag)){
        	   
        	   User  user=(User)session.getAttribute("user");
        	   
        	  List<Message> myMessage= mdi.getMyMessage(user.getName(), user.getName());
        	  
        	  request.setAttribute("myMessage", myMessage);
        	  
        	  request.getRequestDispatcher("showMyMessage.jsp").forward(request, response);
        	   
        	   
           }
           
           else if("removeMyMessage".equals(flag)){
        	   
        	      request.removeAttribute("myMessage");
        	      
        	      request.getRequestDispatcher("showMyMessage.jsp").forward(request, response);
        	        	   
           }
		
	}

}
