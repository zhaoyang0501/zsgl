package com.pzy.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;

import com.pzy.entity.Category;
import com.pzy.entity.Resource;
import com.pzy.service.ResourceService;

@Namespace("/resource")
@ParentPackage("json-default") 
public class ResourceAction extends PageAction {
	private  Category category;
	
	private String keyword;
	
	private List<Resource> resources;
	
	private Long id;
	
	private Resource resource;
	
	@Autowired
	private ResourceService resourceService;
	@Action(value = "resourceDetail", results = { @Result(name = "success", location = "/WEB-INF/views/resource_detail.jsp") })
	public String resourceDetail(){
		resource=resourceService.find(id);
		resource.setCount(resource.getCount()==null?0:resource.getCount()+1);
		resourceService.save(resource);
		return SUCCESS;
	}
	@Action(value = "list", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String list() {
		int pageNumber = (int) (this.getIDisplayStart() / this.getIDisplayLength()) + 1;
		int pageSize =  this.getIDisplayLength();
		Page<Resource> list = resourceService.findAll(pageNumber, pageSize,keyword,category);
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
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
