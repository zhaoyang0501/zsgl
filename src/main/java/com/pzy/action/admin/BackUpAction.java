package com.pzy.action.admin;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;

import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.Category;
import com.pzy.entity.Log;
import com.pzy.entity.Resource;
import com.pzy.service.CategoryService;
import com.pzy.service.LogService;
import com.pzy.service.ResourceService;

@Namespace("/admin/backup")
@ParentPackage("json-default")
public class BackUpAction extends ActionSupport {
	@Value("${jdbc.url}")  
	private String url;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.username}")
	private String username;
	@Action(value = "backup", results = { @Result(name = "success", location = "/WEB-INF/views/admin/log/index.jsp") })
	/*public String backup(){
        // 文件下载地址，也是数据库文件导出地址  
        String downloadURL = downloadroot + fileName;  
  
        // 备份语句  
        String command = "cmd /c mysqldump -u" + username + " -p" + password  
                + " -h" + dataBaseIp + " " + dataBaseName + " >" + downloadURL + " --lock-all-tables";  
        System.out.println(command);  
        Process ls_proc = Runtime.getRuntime().exec(command);  
        BufferedReader in = new BufferedReader(new InputStreamReader(  
                new DataInputStream(ls_proc.getInputStream())));  
        String commandResult = in.readLine();  
//      System.out.println("commandResult :" + commandResult);  
  
        // 生成文件  
        File file = new File(downloadURL);  
        HttpServletResponse response = getResponse();  
        response.setContentType("application/x-msdownload");  
        response.setContentLength((int) file.length());  
        response.setHeader("Content-Disposition", "attachment;filename="  
                + fileName);  
        FileInputStream fis = new FileInputStream(file);  
        BufferedInputStream buff = new BufferedInputStream(fis);  
        byte[] b = new byte[1024];  
        long k = 0;  
        OutputStream myout = response.getOutputStream();  
        while (k < file.length()) {  
            int j = buff.read(b, 0, 1024);  
            k += j;  
            myout.write(b, 0, j);  
        }  
        myout.flush();  
		return SUCCESS;
			
	}*/
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
