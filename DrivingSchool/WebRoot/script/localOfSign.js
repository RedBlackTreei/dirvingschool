Ext.onReady(function() {
	Ext.define('LOS', {
		extend: 'Ext.data.Model',
		fields: [{
			name: 'id',
			type: 'long'
		}, {
			name: 'name',
			type: 'string'
		}, {
			name: 'address',
			type: 'string'
		}, {
			name: 'tel',
			type: 'string'
		}]
	});

	var store = Ext.create('Ext.data.ArrayStore', {
		model: 'LOS',
		proxy: {
			type: 'ajax',
			api: {
				read: 'getLOSListAction',
				create: 'addLOSAction',
				updaet: 'editLOSAction',
				destory: 'deleteLOSAction'
			},
			reader: {
				type: 'json'
			}
		},
		listeners: {
			update: function(store, record) {
				Ext.Ajax.request({
					url: 'editLOSAction',
					params: {
						'localOfSign.id': record.get('id'),
						'localOfSign.name': record.get('name'),
						'localOfSign.address': record.get('address'),
						'localOfSign.tel': record.get('tel')
					},
					success: function(response) {
						store.reload();
					}
				});
			},
			exception: function(proxy, response, operation) {
				Ext.MessageBox.show({
					title: '服务器端异常',
					msg: operation.getError(),
					icon: Ext.MessageBox.ERROR,
					buttons: Ext.Msg.OK
				});
			},
			load: function(store, records, successful, operation, opts) {
				if(!successful) {
					Ext.Msg.alert('提示', '数据加载失败!');

				}
			},
			write: function(proxy, operation) {
				Ext.example.msg(operation.action, operation.resultSet.message);
			}
		},
		autoLoad: true
	});

	var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
		clicksToEdit: 2
	});

	var LOSGrid = Ext.create('Ext.grid.Panel', {
		id: 'LOSList',
		layout : 'fit',
		//width: 600,
		height:'100%',
		frame: true,
		store: store,
		plugins: [rowEditing],
		selType: 'rowmodel',
		//style: 'margin: 50px',
		renderTo: Ext.getBody(),
		columns: [{
			header: 'id',
			// xtype : 'hidden',
			hidden: true,
			dataIndex: 'id'
		}, {
			header: '驾校名称',
			sortable: true,
			flex:3,
			dataIndex: 'name',
			editor: {
				xtype: 'textfield',
				allowBlank: false
			}
		}, {
			header: '驾校地址',
			sortable: true,
			flex:4,
			dataIndex: 'address',
			editor: {
				xtype: 'textfield',
				hideTrigger: true,
				allowBlank: false
			}
		}, {
			header: '联系电话',
			sortable: true,
			flex:3,
			dataIndex: 'tel',
			editor: {
				xtype: 'numberfield',
				hideTrigger: true,
				minValue: 1,
				allowBlank: false
			}
		}],
		tbar: [{
			text: '添加',
			handler: function() {
				addLOS();
			}
		}, '-',
		{
			text: '删除',
			handler: function() {
				var selectedModel = LOSGrid.getSelectionModel();
				if(selectedModel.hasSelection()) {
					var record = selectedModel.getSelection();
					Ext.Msg.confirm("<font color='red'>系统提示</font>", "您确定要删除选择的数据吗?", function(btn) {
						if(btn == "yes") {
							deleteLOS(record);
						}
					});
				} else {
					Ext.Msg.alert('失败', '请选择一行数据进行删除');
				}
			}
		}]
	});

	function addLOS() {
		var addForm = Ext.create('Ext.form.Panel', {
			bodyPadding: 5,
			// Fields will be arranged vertically, stretched to full width
			layout: 'form',
			frame: true,
			bodyBorder: true,
			// The form will submit an AJAX request to this URL when submitted
			url: 'addLOSAction',
			items: [{
				fieldLabel: '驾校名称',
				xtype: 'textfield',
				maxValue: 200,
				minValue: 1,
				name: 'localOfSign.name',
				allowBlank: false
			}, {
				fieldLabel: '驾校地址',
				xtype: 'textfield',
				name: 'localOfSign.address',
				allowBlank: false
			}, {
				fieldLabel: '联系电话',
				xtype: 'numberfield',
				name: 'localOfSign.tel',
				allowBlank: false
			}],

			// Reset and Submit buttons
			buttons: [{
				text: '提交',
				formBind: true,
				// only enabled once the form is valid
				disabled: true,
				handler: function() {
					var form = this.up('form').getForm();
					if(form.isValid()) {
						form.submit({
							success: function(form, action) {
								Ext.Msg.alert('成功', action.result.msg);
								store.reload();
								win.close();
							},
							failure: function(form, action) {
								Ext.Msg.alert('失败', action.result.msg);
							}
						});
					}
				}
			}, {
				text: '重置',
				handler: function() {
					this.up('form').getForm().reset();
				}
			}]
		});

		var win = Ext.create('Ext.window.Window', {
			layout: 'fit',
			width: 400,
			title: '添加报名点',
			items: [addForm]
		});
		win.show();
	}

	function deleteLOS(records) {
		var id = records[0].get('id');
		Ext.Ajax.request({
			url: 'deleteLOSAction',
			params: {
				id: id
			},
			method: 'post',
			success: function(response) {
				var json = Ext.JSON.decode(response.responseText);
				Ext.Msg.alert('成功', json.msg);
				store.reload();
			},
			failure: function(response) {
				var json = Ext.JSON.decode(response.responseText);
				Ext.Msg.alert('失败', json.msg);
			}
		});
	}
});