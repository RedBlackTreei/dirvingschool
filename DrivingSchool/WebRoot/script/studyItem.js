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
			api : {
				read : 'getItemsAction',
				create : 'addItemAction',
				update : 'updateItemAction',
				destory : 'deleteItemAction'
			},
			reader : {
				type : 'json'
			}
		},
		listeners : {
			update : function(store, record) {
				// alert(record.get("ID"))
				Ext.Ajax.request({
					url : 'updateItemAction',
					params : {
						'items.id': record.get('id'),
						'items.classHour' : record.get('classHour'),
						'items.itemName' : record.get('itemName')
					},
					success : function(response) {
						store.reload();
					}
				});
			},
			exception : function(proxy, response, operation) {
				Ext.MessageBox.show({
					title : '服务器端异常',
					msg : operation.getError(),
					icon : Ext.MessageBox.ERROR,
					buttons : Ext.Msg.OK
				});
			},
			load : function(store, records, successful, operation, opts) {
				if (!successful) {
					Ext.Msg.alert('提示', '数据加载失败!');

				}
			},
			write : function(proxy, operation) {
				Ext.example.msg(operation.action, operation.resultSet.message);
			}
		},
		autoLoad : true
	});

	var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
		clicksToEdit : 2
	});

	var studyItemGrid = Ext.create('Ext.grid.Panel', {
		id : 'itemsList',
		layout : 'fit',
		//width : 600,
		height:'100%',
		//frame : true,
		store : store,
		plugins : [ rowEditing ],
		selType : 'rowmodel',
		//style : 'margin: 50px',
		renderTo : Ext.getBody(),
		columns : [ {
			text : 'id',
			// xtype : 'hidden',
			hidden : true,
			dataIndex : 'id'
		}, {
			text : '项目名称',
			sortable : true,
			flex : 0.3,
			dataIndex : 'itemName',
			editor : {
				xtype : 'textfield',
				allowBlank : false
			}
		}, {
			text : '课时',
			sortable : true,
			flex : 0.2,
			dataIndex : 'classHour',
			editor : {
				xtype : 'numberfield',
				hideTrigger : true,
				minValue : 1,
				allowBlank : false
			}
		} ],
		tbar : [
				{
					text : '添加',
					handler : function() {
						addItem();
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
											 deleteItem(record);
										}
									});
						} else {
							Ext.Msg.alert('失败', '请选择一行数据进行删除');
						}
					}
				} ]
	});
	
	function addItem() {
		var addForm = Ext.create('Ext.form.Panel', {
			bodyPadding : 5,
			// Fields will be arranged vertically, stretched to full width
			layout : 'form',
			frame : true,
			bodyBorder : false,
			// The form will submit an AJAX request to this URL when submitted
			url : 'addItemAction',
			items : [ {
				fieldLabel : '课时',
				xtype : 'numberfield',
				maxValue:200,
				minValue:1,
				name : 'items.classHour',
				allowBlank : false
			}, {
				fieldLabel : '课程名称',
				xtype : 'textfield',
				name : 'items.itemName',
				allowBlank : false
			}],

			// Reset and Submit buttons
			buttons : [ {
				text : '提交',
				formBind : true, // only enabled once the form is valid
				disabled : true,
				handler : function() {
					var form = this.up('form').getForm();
					if (form.isValid()) {
						form.submit({
							success : function(form, action) {
								Ext.Msg.alert('成功', action.result.msg);
								store.reload();
								win.close();
							},
							failure : function(form, action) {
								Ext.Msg.alert('失败', action.result.msg);
							}
						});
					}
				}
			}, {
				text : '重置',
				handler : function() {
					this.up('form').getForm().reset();
				}
			} ]
		});

		var win = Ext.create('Ext.window.Window', {
			layout:'fit',
			width:250,
			title : '添加科目',
			items : [ addForm ]
		});
		win.show();
	}
	
	function deleteItem(records){
		var id = records[0].get('id');
		Ext.Ajax.request({
			url : 'deleteItemAction',
			params : {
				id : id
			},
			method : 'post',
			success : function(response) {
				var json = Ext.JSON.decode(response.responseText);
				Ext.Msg.alert('成功', json.msg);
				store.reload();
			},
			failure : function(response) {
				var json = Ext.JSON.decode(response.responseText);
				Ext.Msg.alert('失败', json.msg);
			}
		});
	}
});