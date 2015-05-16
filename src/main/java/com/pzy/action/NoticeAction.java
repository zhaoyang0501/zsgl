package com.pzy.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.pzy.entity.Notice;
import com.pzy.service.NoticeService;

@Namespace("/notice")
@ParentPackage("json-default") 
public class NoticeAction extends PageAction {
	private Date start;
	private Date end;
	private List<Notice> notices;
	
	private Long id;
	private Notice notice;
	@Autowired
	private NoticeService noticeService;

	@Action(value = "noticeDetail", results = { @Result(name = "success", location = "/WEB-INF/views/notice_detail.jsp") })
	public String noticeDetail(){
		notice=noticeService.find(id);
		return SUCCESS;
	}
	
	@Action(value = "list", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String list() {
		int pageNumber = (int) (this.getIDisplayStart() / this.getIDisplayLength()) + 1;
		int pageSize =  this.getIDisplayLength();
		Page<Notice> list = noticeService.findAll(pageNumber, pageSize,start,end);
		this.getResultMap().put("aaData", list.getContent());
		this.getResultMap().put("iTotalRecords", list.getTotalElements());
		this.getResultMap().put("iTotalDisplayRecords", list.getTotalElements());
		this.getResultMap().put("sEcho", getSEcho());
		return SUCCESS;
	}
	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}


	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
}
