package com.pzy.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;

import com.pzy.entity.Category;
import com.pzy.entity.Collect;
import com.pzy.entity.Resource;
import com.pzy.entity.User;
import com.pzy.service.CollectService;

@Namespace("/collect")
@ParentPackage("json-default") 
public class CollectAction extends PageAction {

	private String tip;
	private Resource resource;
	
	
	private String keyword;
	
	private List<Collect> collects;
	
	private Long id;
	
	private Collect collect;
	
	@Autowired
	private CollectService collectService;
	
	@Action(value = "saveCollect", results = { @Result(name = "success", type = "json") }, params = {"contentType", "text/html" })
	public String saveCollect(){
		Collect collect=new Collect();
		collect.setResource(resource);
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		collect.setUser(user);
		List<Collect> list=collectService.findByUserAndCookBook(user, resource);
		if(list==null||list.size()==0){
			collect.setCreateDate(new Date());
			collectService.save(collect);
			tip="收藏成功！";
		}
		return SUCCESS;
	}
	@Action(value = "collectundo", results = { @Result(name = "success", type = "json") }, params = {"contentType", "text/html" })
	public String collectundo(){
		collectService.delete(collect);
		tip="取消收藏成功";
		return SUCCESS;
	}
	
	@Action(value = "list", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String list() {
		int pageNumber = (int) (this.getIDisplayStart() / this.getIDisplayLength()) + 1;
		int pageSize =  this.getIDisplayLength();
		Page<Collect> list = collectService.findAll(pageNumber, pageSize,keyword);
		this.getResultMap().put("aaData", list.getContent());
		this.getResultMap().put("iTotalRecords", list.getTotalElements());
		this.getResultMap().put("iTotalDisplayRecords", list.getTotalElements());
		this.getResultMap().put("sEcho", getSEcho());
		return SUCCESS;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collect getCollect() {
		return collect;
	}
	public void setCollect(Collect collect) {
		this.collect = collect;
	}
	public List<Collect> getCollects() {
		return collects;
	}

	public void setCollects(List<Collect> collects) {
		this.collects = collects;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
