/**
 * 学习项目前台js代码
 */
Ext.onReady(function() {
	Ext.define('StudyItem', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'id',
			type : 'long'
		}, {
			name : 'itemName',
			type : 'string'
		}, {
			name : 'classHour',
			type : 'int'
		} ]
	});

	var store = Ext.create('Ext.data.ArrayStore', {
		model : 'StudyItem',
		proxy : {
			type : 'ajax',
			url : 'getItemsAction',
			reader : 'json'
		},
		listeners : {
			load : function(store, records, successful, operation, opts) {
				if (!successful) {
					Ext.Msg.alert('提示', '数据加载失败!');

				}
			}
		},
		autoLoad : true
	});

	var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
		  clicksToEdit: 1
	});
	
	var studyItemGrid = Ext.create('Ext.grid.Panel', {

		id : 'itemsList',
		//layout : 'fit',
		width:600,
		frame : true,
		store : store,
		plugins: [rowEditing],
	    selType: 'rowmodel',
	    style: 'margin: 50px',
		renderTo : Ext.getBody(),
		columns : [ {
			text : 'id',
			// xtype : 'hidden',
			hidden : true,
			dataIndex : 'id'
		}, {
			text : '项目名称',
			sortable : true,
			flex:0.3,
			dataIndex : 'itemName',
			editor: {
				xtype: 'textfield',
	            allowBlank: false
	        }
		}, {
			text : '课时',
			sortable : true,
			flex:0.2,
			dataIndex : 'classHour',
			editor: {
				xtype: 'numberfield',
				hideTrigger: true,
	            minValue: 1,
	            allowBlank: false
	        }
		} ],
		tbar : [
				{
					text : '添加',
					handler : function() {
						addNews();
					}
				},
				'-',
				{
					text : '编辑',
					handler : function() {
						var selModel = studyItemGrid.getSelectionModel();
						if (selModel.hasSelection()) {
							var records = selModel.getSelection();
							// editNews(records);
						} else {
							Ext.Msg.alert('失败', '请选择一行数据进行修改');
						}
					}
				},
				'-',
				{
					text : '删除',
					handler : function() {
						var selectedModel = studyItemGrid.getSelectionModel();
						if (selectedModel.hasSelection()) {
							var record = selectedModel.getSelection();
							Ext.Msg.confirm("<font color='red'>系统提示</font>",
									"您确定要删除选择的数据吗?", function(btn) {
										if (btn == "yes") {
											// deleteNews(record);
										}
									});
						} else {
							Ext.Msg.alert('失败', '请选择一行数据进行删除');
						}
					}
				} ]
	});
});