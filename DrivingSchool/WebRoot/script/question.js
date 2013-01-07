Ext.require([ 'Ext.form.*', 'Ext.data.*', 'Ext.grid.Panel',
		'Ext.layout.container.Column' ]);
Ext.onReady(function() {

	Ext.QuickTips.init();

	Ext.define('Question', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'id',
			type : 'long'
		}, {
			name : 'title',
			type : 'string'
		}, {
			name : 'answer',
			type : 'int'
		} ]
	});

	Ext.define('QuestionItem', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'id',
			type : 'long'
		}, {
			name : 'item',
			type : 'string'
		} ]
	});

	var storeOfQuestion = Ext.create('Ext.data.ArrayStore', {
		model : 'Question',
		proxy : {
			type : 'ajax',
			url : 'getQuestionAction',
			reader : 'json'
		},
		autoLoad : true
	});

	// var storeOfItem = Ext.create('Ext.data.Store',{
	// model:'QuestionItem',
	// proxy : {
	// type : 'ajax',
	// url : 'getItemAction',
	// reader : 'json'
	// },
	// autoLoad : true
	// });

	var questionWithItems = Ext.create('Ext.form.Panel', {
		frame : true,
		title : '题库管理',
		bodyPadding : 5,
		width : document.body.clientWidth - 20,
		layout : 'column',
		// Specifies that the items will now be arranged in columns
		fieldDefaults : {
			labelAlign : 'left',
			msgTarget : 'side'
		},
		items : [ {
			columnWidth : 0.60,
			xtype : 'gridpanel',
			store : storeOfQuestion,
			height : 400,

			columns : [ {
				id : 'id',
				text : 'id',
				hidden : true,
				dataIndex : 'id'
			}, {
				text : '题目',
				flex : 3,
				sortable : true,
				dataIndex : 'title'
			}, {
				text : '答案',
				width : 75,
				flex : 1,
				sortable : true,
				dataIndex : 'answer'
			} ],

			listeners : {
				selectionchange : function(model, records) {
					if (records[0]) {
						var id = records[0].get('id');
						alert(id);
						Ext.Ajax.request({
							url : 'getItemAction',
							params : {
								id : id
							},
							method : 'post',
							success : function(response) {
								alert(response.responseText);
							},
							failure : function(response) {
							}
						});
					}
				},
				viewready:function ( view, eOpts ) {
					view.getSelectionModel().select(1);
				}
			}
		} ],
		renderTo : Ext.getBody()
	});
	 //questionWithItems.child('gridpanel').getSelectionModel().selectRow(0,false);
});