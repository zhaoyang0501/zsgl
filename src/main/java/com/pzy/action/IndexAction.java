package com.pzy.action;  
  
import java.util.List;
import java.util.Map;

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
public class IndexAction extends ActionSupport implements SessionAware {  
	private Map<String,Object> session;
	private User user;
	private String tip;
	private List<Category> categorys;
	private List<Resource> resources;
	private List<Resource> resourcesHot;
	private List<Resource> resourcesNew;
	private Resource resource;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private LogService logService;
	@Autowired
	@Action(value = "index", results = { @Result(name = "success", location = "/WEB-INF/views/index.jsp") })  
    public String index() throws Exception { 
		resourcesHot=resourceService.findHot();
		resourcesNew=resourceService.findNew();
        return SUCCESS;  
    }  
    @Action(value = "center", results = { @Result(name = "success", location = "/WEB-INF/views/center.jsp") })  
    public String center() throws Exception {  
    	logService.save(getUserFromSession(),getIp(),"访问了个人中心",Log.INFO_LEVEL);
        return SUCCESS;  
    } 
    @Action(value = "register", results = { @Result(name = "success", location = "/WEB-INF/views/register.jsp") })  
    public String register() throws Exception {  
        return SUCCESS;  
    } 
    @Action(value = "find", results = { @Result(name = "success", location = "/WEB-INF/views/find.jsp") })  
    public String find() throws Exception { 
    	resources=this.resourceService.findAll();
    	categorys=this.categoryService.findAll();
    	logService.save(getUserFromSession(),getIp(),"访问资源搜索",Log.INFO_LEVEL);
    	return SUCCESS;  
    }
    @Action(value = "goupload", results = { @Result(name = "success", location = "/WEB-INF/views/goupload.jsp") })  
    public String goupload() throws Exception { 
    	if(resource!=null)
    		resource=resourceService.find(resource.getId());
    	categorys=this.categoryService.findAll();
    	return SUCCESS;  
    }
	@Action(value = "myupload", results = { @Result(name = "success", location = "/WEB-INF/views/myupload.jsp") })  
    public String myupload() throws Exception {
    	User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
    	this.resources=resourceService.find(user);
    	logService.save(getUserFromSession(),getIp(),"访问我的上传",Log.INFO_LEVEL);
    	return SUCCESS;  
    }
    @Action(value = "registerUser", results = { @Result(name = "success", location = "/WEB-INF/views/registerok.jsp") })  
    public String registerUser() throws Exception {  
    	userService.save(user);
        return SUCCESS;  
    } 
    @Action(value = "login", results = { @Result(name = "success", location = "/WEB-INF/views/login.jsp") })  
    public String login() throws Exception {  
        return SUCCESS;  
    } 
    @Action(value = "loginout", results = { @Result(name = "success", location = "/WEB-INF/views/index.jsp") })  
    public String loginout() throws Exception {  
    	ActionContext.getContext().getSession().clear();
        return SUCCESS;  
    } 
    @Action(value = "dologin", 
    		results = { @Result(name = "success" ,type="redirect", location = "index") ,
    					@Result(name = "login", location = "/WEB-INF/views/login.jsp") })  
    public String dologin() throws Exception { 
    	User loginuser=userService.login(user.getUserName(), user.getPassword());
    	if(loginuser!=null){
    		session.put("user",loginuser );
    		 logService.save(loginuser,getIp(),"登录了系统",Log.INFO_LEVEL);	 
            return SUCCESS; 
    	}
    	else{
    		ActionContext.getContext().getSession().clear();
    		logService.save(null,getIp(),user.getUserName()+"尝试登录系统失败！",Log.WARM_LEVEL);	 
    		this.tip="登陆失败 不存在此用户名或密码!";
    		return LOGIN;
    	}
    	
    }
    private User getUserFromSession(){
    	User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
    	return user;
    }
    private String getIp(){
    	return ServletActionContext.getRequest().getRemoteAddr();
    }
    /**setter getter~~~~~~~~~~~~~*/
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public List<Resource> getResourcesHot() {
		return resourcesHot;
	}

	public void setResourcesHot(List<Resource> resourcesHot) {
		this.resourcesHot = resourcesHot;
	}

	public List<Resource> getResourcesNew() {
		return resourcesNew;
	}

	public void setResourcesNew(List<Resource> resourcesNew) {
		this.resourcesNew = resourcesNew;
	}
}