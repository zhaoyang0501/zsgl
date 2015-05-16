jQuery.collect = {
		collectDataTable:null,
		categoryChange:function(category){
			$(".ppt-category-list a").removeClass("selected");
			$("#category_href_"+category).addClass("selected");
			$("#category").val(category);
			jQuery.collect.initSearchDataTable();
		},
		initSearchDataTable : function() {
			if (this.collectDataTable == null) {
				this.collectDataTable = $('#dt_table_view').dataTable({
					"sDom" : "<'row-fluid'<'span6'l>r>t<'row-fluid'<'span6'i><'span6'p>>",
					"sPaginationType" : "bootstrap",
					"oLanguage" : {
						"sLengthMenu" : "每页显示 _MENU_ 条记录",
						"sZeroRecords" : "抱歉， 暂时没有记录",
						"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
						"sSearch" : "",
						"sInfoEmpty" : "没有数据",
						"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
						"oPaginate" : {
							"sFirst" : "首页",
							"sPrevious" : "前一页",
							"sNext" : "后一页",
							"sLast" : "尾页"
						}
					},
					"bAutoWidth" : false,
					"iDisplayLength" : 10,
					"aLengthMenu" : [ 5, 10, 25, 50],
					"bServerSide" : true,
					"sServerMethod" : "POST",
					"bProcessing" : true,
					"bSort" : false,
					"sAjaxSource" : $.ace.getContextPath() + "/collect/list",
					"fnDrawCallback" : function(oSettings) {
						$('[rel="popover"],[data-rel="popover"]').popover();
					},
					"fnServerData" : function(sSource, aoData, fnCallback) {
						var name = $("#name_").val();
						var category = $("#category").val();
						if (!!name) {
							aoData.push({
								"name" : "keyword",
								"value" : name
							});
						}
						if (!!category) {
							aoData.push({
								"name" : "category.id",
								"value" : category
							});
						}
						$.ajax({
							"dataType" : 'json',
							"type" : "POST",
							"url" : sSource,
							"data" : aoData,
							"success" : function(data){
								fnCallback(data.resultMap);
							}
						});
					},
					"aoColumns" : [ {
						"mDataProp" : "resource.name"
					}, {
						"mDataProp" : "createDate"
					}, {
						"mDataProp" : ""
					}],
					"aoColumnDefs" : [
						{
							'aTargets' : [2],
							'fnRender' : function(oObj, sVal) {
								return  "<a href=\"resource/resourceDetail?id="+oObj.aData.id+"\" target=\"_blank\">查看</a> " +
										"<a href=\"./upload/"+oObj.aData.resource.filePath+"\" target=\"_blank\">下载</a> "+
										"<a onclick=\"jQuery.collect.collectundo('"+oObj.aData.id+"')\" href='javascript:;' >取消收藏</a>";
							}
						},
					 {
						'aTargets' : [ '_all' ],
						'bSortable' : false,
						'sClass' : 'center'
					}]

				});
			} else {
				var oSettings = this.collectDataTable.fnSettings();
				oSettings._iDisplayStart = 0;
				this.collectDataTable.fnDraw(oSettings);
			}

		},
		collectundo :function(id){
			$.ajax({
    			type : "get",
    			url : $.ace.getContextPath() + "/collect/collectundo?collect.id="+id,
    			dataType : "json",
    			success : function(json) {
    				alert(json.tip);
    				jQuery.collect.initSearchDataTable();
    			}
    		});
		},
		
};