package com.pzy.action;  
  
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.Category;
import com.pzy.entity.Log;
import com.pzy.entity.Resource;
import com.pzy.entity.User;
import com.pzy.service.CategoryService;
import com.pzy.service.LogService;
import com.pzy.service.ResourceService;
import com.pzy.service.UserService;
 
@ParentPackage("struts-default")  
public class DoCenterAction extends ActionSupport  {
	private User user;
	private String tip;
	@Autowired
	private UserService userService;
	@Autowired
	private LogService logService;
	@Action(value = "docenter", results = { @Result(name = "success", location = "/WEB-INF/views/msg.jsp") })  
	public String doFind(){
		userService.save(user);
		ActionContext.getContext().getSession().put("user",userService.find(user.getId()));
		logService.save(getUserFromSession(),getIp(),"修改了用户信息",Log.INFO_LEVEL);
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