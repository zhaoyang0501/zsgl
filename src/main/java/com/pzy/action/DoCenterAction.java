package com.pzy.action;  
  
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.User;
import com.pzy.service.UserService;
 
@ParentPackage("struts-default")  
public class DoCenterAction extends ActionSupport  {
	private User user;
	private String tip;
	@Autowired
	private UserService userService;
	@Action(value = "docenter", results = { @Result(name = "success", location = "/WEB-INF/views/msg.jsp") })  
	public String doFind(){
		userService.save(user);
		ActionContext.getContext().getSession().put("user",userService.find(user.getId()));
		this.tip="用户信息修改成功！";
		return SUCCESS;
	}
	/***getter setter ***/
	private User getUserFromSession(){
	    	User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
	    	return user;
	}
	
	private String getIp(){
	    	return ServletActionContext.getRequest().getRemoteAddr();
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}