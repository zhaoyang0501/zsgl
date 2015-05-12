package com.pzy.action.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.Category;
import com.pzy.entity.Resource;
import com.pzy.service.CategoryService;
import com.pzy.service.ResourceService;

@Namespace("/admin/resource")
@ParentPackage("json-default")
public class ResourceAction extends ActionSupport {
	private Integer sEcho = 1;
	private Integer iDisplayStart = 0;
	private Integer iDisplayLength = 10;
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	private String name;
	private Long categoryId;
	private Long id;
	private Resource resource;
	private List<Category> categorys;
	

	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private CategoryService categoryService;
	@Action(value = "index", results = { @Result(name = "success", location = "/WEB-INF/views/admin/resource/index.jsp") })
	public String index() {
		categorys=this.categoryService.findAll();
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(name = "success", type = "json") }, params = {
			"contentType", "text/html" })
	public String list() {
		int pageNumber = (int) (iDisplayStart / iDisplayLength) + 1;
		int pageSize = iDisplayLength;
		Page<Resource> list =  resourceService.findAll(pageNumber, pageSize,
				name,categoryId	);
		resultMap.put("aaData", list.getContent());
		resultMap.put("iTotalRecords", list.getTotalElements());
		resultMap.put("iTotalDisplayRecords", list.getTotalElements());
		resultMap.put("sEcho", sEcho);
		return SUCCESS;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Action(value = "delete", results = { @Result(name = "success", type = "json") }, params = {
			"contentType", "text/html" })
	public String delete() {
		try {
			resourceService.delete(id);
			resultMap.put("state", "success");
			resultMap.put("msg", "删除成功");
		} catch (Exception e) {
			resultMap.put("state", "error");
			resultMap.put("msg", "删除失败"+e.getMessage());
		}
		return SUCCESS;
	}

	@Action(value = "get", results = { @Result(name = "success", type = "json") }, params = {
			"contentType", "text/html" })
	public String get() {
		resultMap.put("resource",  resourceService.find(id));
		resultMap.put("state", "success");
		resultMap.put("msg", "删除成功");
		return SUCCESS;
	}

	@Action(value = "update", results = { @Result(name = "success", type = "json") }, params = {
			"contentType", "text/html" })
	public String update() {
		
		Resource bean = resourceService.find(resource.getId());
		bean.setCategory(categoryService.find(resource.getCategory().getId()));
		bean.setName(""+resource.getName());
		bean.setRemark(resource.getRemark());
		bean.setCreateDate(new Date(System.currentTimeMillis()));
		resourceService.save(bean);
		resultMap.put("state", "success");
		resultMap.put("msg", "修改成功");
		return SUCCESS;
	}
	@Action(value = "save", results = { @Result(name = "success", type = "json") }, params = {
			"contentType", "text/html" })
	public String save() {
		this.resourceService.save(resource);
		resultMap.put("state", "success");
		resultMap.put("msg", "保存成功");
		return SUCCESS;
	}
	/* ~~~~~~~~get and setter~~~~~~~~~ */
	@JSON
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public Integer getSEcho() {
		return sEcho;
	}

	public void setSEcho(Integer sEcho) {
		this.sEcho = sEcho;
	}

	public Integer getIDisplayStart() {
		return iDisplayStart;
	}

	public void setIDisplayStart(Integer idisplayStart) {
		this.iDisplayStart = idisplayStart;
	}

	public Integer getIDisplayLength() {
		return iDisplayLength;
	}

	public void setIDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
}
