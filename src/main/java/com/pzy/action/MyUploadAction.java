package com.pzy.action;  
  
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.Resource;
import com.pzy.entity.User;
import com.pzy.service.CategoryService;
import com.pzy.service.ResourceService;
 
@ParentPackage("struts-default")  
public class MyUploadAction extends ActionSupport implements SessionAware {
    /**上传的文件*/
    private File filePath;  
    /**上传的文件ContentType*/
    private String filePathContentType;  
    /**上传的文件名*/
    private String filePathFileName; 
    private Resource resource;
    private Long categoryId;
    private String tip;
	@Autowired
    private ResourceService resourceService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
	@Override
	public void setSession(Map<String, Object> arg0) {
	}
	@Action(value = "deleteResource", results = { @Result( type="redirect" ,name = "success", location = "myupload") })  
	public String deleteResource(){
		resourceService.delete(resource.getId());
		tip="删除成功";
		return SUCCESS;
	}
	
	@Action(value = "doUpload", results = { @Result(name = "success", location = "/WEB-INF/views/msg.jsp") })  
	public String doUpload(){
		resource.setCreateDate(new Date(System.currentTimeMillis()));
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		resource.setCreater(user);
		resource.setCategory(categoryService.find(this.categoryId));
		resource.setFilePath(this.filePathFileName);
		resourceService.save(resource);
		/**文件上传逻辑*/
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println(realpath);
		File savefile = new File(new File(realpath), this.filePathFileName);
         try {
			FileUtils.copyFile(filePath, savefile);
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
         tip="上传成功";
		return SUCCESS;
	}

	/*** ~~~~~~~~~~~~~getter setter~~~~~~~~~~~~~~~~~~~ */
	private User getUserFromSession() {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		return user;
	}

	private String getIp() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}
	public File getFilePath() {
		return filePath;
	}

	public void setFilePath(File filePath) {
		this.filePath = filePath;
	}

	public String getFilePathContentType() {
		return filePathContentType;
	}

	public void setFilePathContentType(String filePathContentType) {
		this.filePathContentType = filePathContentType;
	}

	public String getFilePathFileName() {
		return filePathFileName;
	}

	public void setFilePathFileName(String filePathFileName) {
		this.filePathFileName = filePathFileName;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
}