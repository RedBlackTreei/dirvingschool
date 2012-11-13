Ext.onReady(function() {
	Ext.define('News', {
		extend: 'Ext.data.Model',
		fields: [ {
			name: 'title',
			type: 'string'
		}, {
			name: 'content',
			type: 'string'
		}, {
			name: 'date',
			type: 'string'
		}]
	});

	var store = Ext.create('Ext.data.ArrayStore', {
		model: 'News',
		proxy: {
			type: 'ajax',
			url: 'getNewsAction',
			reader: 'json'
		},
		autoLoad: true
	});

	var form = Ext.create('Ext.form.Panel', {
		id: 'news',
		frame: true,
		height:getScreenHeight(),
	    layout: 'column',
		renderTo:Ext.getBody(),
		fieldDefaults: {
			labelAlign: 'left',
			msgTarget: 'side'
		},
		items: [{
			columnWidth: 0.60,
			xtype: 'gridpanel',
			layout : 'fit',
			store: store,
			columns: [{
				text: '新闻标题',
				flex:0.3,
				sortable: true,
				dataIndex: 'title'
			}, {
				text: '新闻内容',
				sortable: true,
				flex:0.6,
				dataIndex: 'content'
			}, {
				text: '时间',
				sortable: true,
				flex:0.1,
				dataIndex: 'date'
			}],
			listeners: {
				selectionchange: function(model, records) {
					if(records[0]) {
						this.up('form').getForm().loadRecord(records[0]);
					}
				}
			}
		}, {
			columnWidth: 0.4,
			margin: '0 0 0 10',
			xtype: 'fieldset',
			title: '新闻编辑',
			layout:'fit',
			defaultType: 'textfield',
			items: [{
				fieldLabel: '新闻标题',
				name: 'title'
			}, {
				fieldLabel: '新闻内容',
				name: 'content'
			}, {
				fieldLabel: '时间',
				name: 'date'
			}]
		}]
	});
	
	function getScreenHeight(){
		return document.body.clientHeight;
	}

	form.child('gridpanel').getSelectionModel().select(0);
});