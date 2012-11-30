/*
 *库存管理前台代码
 */
Ext.onReady(function() {
	Ext.define('Stock', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'id',
			type : 'long'
		}, {
			name : 'storesName',
			type : 'string'
		}, {
			name : 'storesId',
			type : 'string'
		}, {
			name : 'price',
			type : 'double'
		}, {
			name : 'currentNum',
			type : 'int'
		}, {
			name : 'minNum',
			type : 'int'
		} ]
	});

	var store = Ext.create('Ext.data.ArrayStore', {
		model : 'Stock',
		proxy : {
			type : 'ajax',
			api : {
				read : 'getStocksAction',
				create : 'addStockAction',
				updaet : 'editStockAction',
				destory : 'deleteStockAction'
			},
			reader : {
				type : 'json'
			}
		},
		listeners : {
			update : function(store, record) {
				Ext.Ajax.request({
					url : 'editStockAction',
					params : {
						'stock.id' : record.get('id'),
						'stock.storesName' : record.get('storesName'),
						'stock.storesId' : record.get('storesId'),
						'stock.price' : record.get('price'),
						'stock.currentNum' : record.get('currentNum'),
						'stock.minNum' : record.get('minNum')
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
		autoLoad:true
	});

	var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
		clicksToEdit : 2
	});

	var stockGrid = Ext.create('Ext.grid.Panel', {
		id : 'stockList',
		layout : 'fit',
		//width : 600,
		height:'100%',
		frame : true,
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
			text : '名称',
			sortable : true,
			flex : 2,
			dataIndex : 'storesName',
			editor : {
				xtype : 'textfield',
				allowBlank : false
			}
		}, {
			text : '编号',
			sortable : true,
			flex : 3,
			dataIndex : 'storesId',
			editor : {
				xtype : 'textfield',
				hideTrigger : true,
				minValue : 1,
				allowBlank : false
			}
		}, {
			text : '价格',
			sortable : true,
			flex : 1,
			dataIndex : 'price',
			editor : {
				xtype : 'numberfield',
				hideTrigger : true,
				minValue : 1,
				allowBlank : false
			}
		}, {
			text : '现存数量',
			sortable : true,
			flex : 1,
			dataIndex : 'currentNum',
			editor : {
				xtype : 'numberfield',
				hideTrigger : true,
				minValue : 1,
				allowBlank : false
			}
		}, {
			text : '最低需求',
			sortable : true,
			flex : 1,
			dataIndex : 'minNum',
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
						addStores();
					}
				},
				'-',
				{
					text : '删除',
					handler : function() {
						var selectedModel = stockGrid.getSelectionModel();
						if (selectedModel.hasSelection()) {
							var record = selectedModel.getSelection();
							Ext.Msg.confirm("<font color='red'>系统提示</font>",
									"您确定要删除选择的数据吗?", function(btn) {
										if (btn == "yes") {
											deleteStores(record);
										}
									});
						} else {
							Ext.Msg.alert('失败', '请选择一行数据进行删除');
						}
					}
				} ]
	});
	
	function addStores() {
		var addForm = Ext.create('Ext.form.Panel', {
			bodyPadding : 5,
			// Fields will be arranged vertically, stretched to full width
			layout : 'form',
			frame : true,
			bodyBorder : false,
			// The form will submit an AJAX request to this URL when submitted
			url : 'addStockAction',
			items : [ {
				fieldLabel : '名称',
				xtype : 'textfield',
				maxValue:200,
				minValue:1,
				name : 'stock.storesName',
				allowBlank : false
			}, {
				fieldLabel : '编号',
				xtype : 'textfield',
				name : 'stock.storesId',
				allowBlank : false
			},{
				fieldLabel : '价格',
				xtype : 'numberfield',
				name : 'stock.price',
				allowBlank : false
			},{
				fieldLabel : '当前数量',
				xtype : 'numberfield',
				name : 'stock.currentNum',
				allowBlank : false
			},{
				fieldLabel : '最低需求',
				xtype : 'numberfield',
				name : 'stock.minNum',
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
			width:400,
			title : '删除库存',
			items : [ addForm ]
		});
		win.show();
	}
	function deleteStores(records){
		var id = records[0].get('id');
		Ext.Ajax.request({
			url : 'deleteStockAction',
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