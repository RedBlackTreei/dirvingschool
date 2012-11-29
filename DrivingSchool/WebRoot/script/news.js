Ext.onReady(function() {
	Ext.define('News', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'id',
			type : 'long'
		}, {
			name : 'title',
			type : 'string'
		}, {
			name : 'content',
			type : 'string'
		}, {
			name : 'date',
			type : 'string'
		} ]
	});

	var store = Ext.create('Ext.data.ArrayStore', {
		model : 'News',
		proxy : {
			type : 'ajax',
			url : 'getNewsAction',
			reader : 'json'
		},
		autoLoad : true
	});

	var newsGrid = Ext.create('Ext.grid.Panel', {
		id : 'newsList',
		layout : 'fit',
		frame : true,
		store : store,
		renderTo : Ext.getBody(),
		columns : [ {
			text : 'id',
			// xtype : 'hidden',
			hidden : true,
			dataIndex : 'id'
		}, {
			text : '新闻标题',
			flex : 0.3,
			sortable : true,
			dataIndex : 'title'
		}, {
			text : '新闻内容',
			sortable : true,
			flex : 0.6,
			dataIndex : 'content'
		}, {
			text : '时间',
			sortable : true,
			flex : 0.1,
			dataIndex : 'date'
		} ]
	});

	function addNews() {
		var addForm = Ext.create('Ext.form.Panel', {
			bodyPadding : 5,
			width : 500,
			height : 500,
			// Fields will be arranged vertically, stretched to full width
			layout : 'form',
			frame : true,
			bodyBorder : false,
			// The form will submit an AJAX request to this URL when submitted
			url : 'addNewsAction',
			items : [ {
				fieldLabel : '标题',
				xtype : 'textfield',
				name : 'news.title',
				allowBlank : false
			}, {
				fieldLabel : '时间',
				xtype : 'datefield',
				name : 'news.date',
				allowBlank : false
			}, {
				fieldLabel : '内容',
				xtype : 'htmleditor',
				name : 'news.content',
				height : 200,
				allowBlank : false
			} ],

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
			width : 700,
			height : 600,
			title : '添加新闻',
			items : [ addForm ]
		});
		win.show();
	}

	function deleteNews(records) {
		var id = records[0].get('id');
		Ext.Ajax.request({
			url : 'deleteNewsAction',
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

	function editNews(records) {
		var model = records[0];
		var eidtForm = Ext.create('Ext.form.Panel', {
			bodyPadding : 5,
			width : 500,
			height : 500,
			// Fields will be arranged vertically, stretched to full width
			layout : 'form',
			frame : true,
			bodyBorder : false,
			// The form will submit an AJAX request to this URL when submitted
			url : 'editNewsAction',
			items : [ {
				// xtype : 'hidden',
				xtype : 'textfield',
				name : 'news.id',
				value : model.get('id'),
				hidden : true,
			}, {
				fieldLabel : '标题',
				xtype : 'textfield',
				name : 'news.title',
				value : model.get('title'),
				allowBlank : false
			}, {
				fieldLabel : '时间',
				xtype : 'datefield',
				name : 'news.date',
				value : model.get('date'),
				allowBlank : false
			}, {
				fieldLabel : '内容',
				xtype : 'htmleditor',
				name : 'news.content',
				value : model.get('content'),
				height : 200,
				allowBlank : false
			} ],

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
			width : 700,
			height : 600,
			title : '编辑新闻',
			items : [ eidtForm ]
		});
		win.show();
	}

	function getScreenHeight() {
		return document.body.clientHeight;
	}
});