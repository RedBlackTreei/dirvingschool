Ext.onReady(function() {
	function formatDate(value) {
		return value ? Ext.Date.dateFormat(value, 'M d, Y') : '';
	}
	
	Ext.define('Car', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'id',
			type : 'long'
		}, {
			name : 'plateNum',
			type : 'string'
		}, {
			name : 'regDate',
			type : 'string'
		}, {
			name : 'remark',
			type : 'string'
		}, {
			name : 'type',
			type : 'string'
		}, {
			name : 'stuName',
			type : 'stirng'
		}, {
			name : 'coachName',
			type : 'string'
		}, {
			name : 'stuId',
			type : 'long'
		}, {
			name : 'coachId',
			type : 'long'
		} ]
	});

	var store = Ext.create('Ext.data.Store', {
		model : 'Car',
		proxy : {
			type : 'ajax',
			api : {
				read : 'getCarsAction',
				create : 'addCarAction',
				updaet : 'editCarAction',
				destory : 'deleteCarAction'
			},
			reader : {
				type : 'json'
			}
		},
		listeners : {
			update : function(store, record) {
				Ext.Ajax.request({
					url : 'editCarAction',
					params : {
						'car.id' : record.get('id'),
						'car.plateNum' : record.get('plateNum'),
						'car.regDate' : record.get('regDate'),
						'car.remark' : record.get('remark'),
						'car.type' : record.get('type'),
						'stuId' : record.get('stuId'),
						'coachId' : record.get('coachId')
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

	var carGrid = Ext.create('Ext.grid.Panel', {
		id : 'carsList',
		layout : 'fit',
		// width : 600,
		height : '100%',
		// frame : true,
		store : store,
		plugins : [ rowEditing ],
		selType : 'rowmodel',
		// style : 'margin: 50px',
		renderTo : Ext.getBody(),
		columns : [ {
			text : 'id',
			// xtype : 'hidden',
			hidden : true,
			dataIndex : 'id'
		}, {
			text : '品牌',
			sortable : true,
			dataIndex : 'type',
			editor : {
				xtype : 'textfield',
				hideTrigger : true,
				allowBlank : false
			}
		}, {
			text : '车牌号码',
			sortable : true,
			dataIndex : 'plateNum',
			editor : {
				xtype : 'textfield',
				allowBlank : false
			}
		}, {
			text : '备注',
			sortable : true,
			dataIndex : 'remark',
			editor : {
				xtype : 'textfield',
				allowBlank : false
			}
		}, {
			text : '注册时间',
			sortable : true,
			dataIndex : 'regDate',
			renderer : formatDate,
			editor : {
				xtype : 'datefield',
				format : 'm/d/y',
				minValue : '01/01/06',
				allowBlank : false
			}
		}, {
			text : '学生',
			sortable : true,
			dataIndex : 'stuName'
		}, {
			text : '教练',
			sortable : true,
			dataIndex : 'coachName'
		}, {
			text : 'stuId',
			hidden : true,
			dataIndex : 'stuId'
		}, {
			text : 'coachId',
			hidden : true,
			dataIndex : 'coachId'
		} ],
		listeners : {
			cellclick : function(el, td, cellIndex, record, tr, rowIndex, e,
					eOpts) {
				if (cellIndex == 5) {
					editStu(record);
				} else if (cellIndex == 6) {
					editCoach(record);
				}
			}
		},
		tbar : [
				{
					text : '添加',
					handler : function() {
						addCar();
					}
				},
				'-',
				{
					text : '删除',
					handler : function() {
						var selectedModel = carGrid.getSelectionModel();
						if (selectedModel.hasSelection()) {
							var record = selectedModel.getSelection();
							Ext.Msg.confirm("<font color='red'>系统提示</font>",
									"您确定要删除选择的数据吗?", function(btn) {
										if (btn == "yes") {
											deleteCar(record);
										}
									});
						} else {
							Ext.Msg.alert('失败', '请选择一行数据进行删除');
						}
					}
				} ]
	});

	function addCar() {
		var addForm = Ext.create('Ext.form.Panel', {
			bodyPadding : 5,
			// Fields will be arranged vertically, stretched to full width
			layout : 'form',
			frame : true,
			bodyBorder : false,
			// The form will submit an AJAX request to this URL when submitted
			url : 'addCarAction',
			items : [ {
				fieldLabel : '车牌号码',
				xtype : 'textfield',
				maxValue : 200,
				minValue : 1,
				name : 'car.plateNum',
				allowBlank : false
			}, {
				fieldLabel : '注册日期',
				xtype : 'datefield',
				name : 'car.regDate',
				allowBlank : false
			}, {
				fieldLabel : '备注',
				xtype : 'textfield',
				name : 'car.remark',
				allowBlank : false
			}, {
				fieldLabel : '类型',
				xtype : 'numberfield',
				name : 'car.type',
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
								///Ext.Msg.alert('成功', action.result.msg);
								store.reload();
								win.close();
							},
							failure : function(form, action) {
								//Ext.Msg.alert('失败', action.result.msg);
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
			layout : 'fit',
			width : 400,
			title : '添加车辆',
			items : [ addForm ]
		});
		win.show();
	}

	function deleteCar(records) {
		var id = records[0].get('id');
		Ext.Ajax.request({
			url : 'deleteCarAction',
			params : {
				id : id
			},
			method : 'post',
			success : function(response) {
				//var json = Ext.JSON.decode(response.responseText);
				//Ext.Msg.alert('成功', json.msg);
				store.reload();
			},
			failure : function(response) {
				//var json = Ext.JSON.decode(response.responseText);
				//Ext.Msg.alert('失败', json.msg);
			}
		});
	}

	function editStu(recordOfCar) {

		Ext.define('Student', {
			extend : 'Ext.data.Model',
			fields : [ {
				name : 'personId',
				type : 'string'
			}, {
				name : 'name',
				type : 'string'
			}, {
				name : 'dateOfEntry',
				type : 'string'
			}, {
				name : 'coachId',
				type : 'string'
			} ]
		});

		var stuStore = Ext.create('Ext.data.Store', {
			model : 'Student',
			proxy : {
				type : 'ajax',
				url : 'getStuAction',
				reader : 'json'
			},
			autoLoad : true
		});

		var stuGrid = Ext.create('Ext.grid.Panel', {
			id : 'stuList',
			layout : 'fit',
			// frame : true,
			store : stuStore,
			columns : [ {
				text : 'id',
				// xtype : 'hidden',
				hidden : true,
				dataIndex : 'personId'
			}, {
				text : '姓名',
				flex : 0.3,
				sortable : true,
				dataIndex : 'name'
			}, {
				text : '入学时间',
				sortable : true,
				flex : 0.6,
				dataIndex : 'dateOfEntry'
			}, {
				text : 'coachId',
				sortable : true,
				flex : 0.1,
				hidden : true,
				dataIndex : 'coachId'
			} ],
			listeners : {
				itemdblclick : function(view, record, item, index, e, eOpts) {
					Ext.Ajax.request({
						url : 'updateUserAction',
						params : {
							carId : recordOfCar.get('id'),
							stuId : record.get('personId'),
							coachId : recordOfCar.get('coachId')
						},
						method : 'post',
						success : function(response) {
							var json = Ext.JSON.decode(response.responseText);
							//Ext.Msg.alert('成功', json.msg);
							store.reload();
							win.close();
						},
						failure : function(response) {
							//var json = Ext.JSON.decode(response.responseText);
							//Ext.Msg.alert('失败', json.msg);
						}
					});

				}
			}
		});

		var win = Ext.create('Ext.window.Window', {
			width : 400,
			height : 300,
			title : '设置学生',
			items : [ stuGrid ]
		});
		win.show();
	}

	function editCoach(recordOfCar) {

		Ext.define('Coach', {
			extend : 'Ext.data.Model',
			fields : [ {
				name : 'personId',
				type : 'string'
			}, {
				name : 'name',
				type : 'string'
			}, {
				name : 'dateOfEntry',
				type : 'string'
			} ]
		});

		var coachStore = Ext.create('Ext.data.Store', {
			model : 'Coach',
			proxy : {
				type : 'ajax',
				url : 'getCoachesAction',
				reader : 'json'
			},
			autoLoad : true
		});

		var coachGrid = Ext.create('Ext.grid.Panel', {
			id : 'coachStore',
			layout : 'fit',
			// frame : true,
			store : coachStore,
			columns : [ {
				text : 'id',
				// xtype : 'hidden',
				hidden : true,
				dataIndex : 'personId'
			}, {
				text : '姓名',
				flex : 0.3,
				sortable : true,
				dataIndex : 'name'
			}, {
				text : '入职时间',
				sortable : true,
				flex : 0.6,
				dataIndex : 'dateOfEntry'
			} ],
			listeners : {
				itemdblclick : function(view, record, item, index, e, eOpts) {
					Ext.Ajax.request({
						url : 'updateUserAction',
						params : {
							carId : recordOfCar.get('id'),
							coachId : record.get('personId'),
							stuId : recordOfCar.get('stuId')
						},
						method : 'post',
						success : function(response) {
							//var json = Ext.JSON.decode(response.responseText);
							//Ext.Msg.alert('成功', json.msg);
							store.reload();
							win.close();
						},
						failure : function(response) {
							//var json = Ext.JSON.decode(response.responseText);
							//Ext.Msg.alert('失败', json.msg);
						}
					});
				}
			}
		});

		var win = Ext.create('Ext.window.Window', {
			width : 400,
			height : 300,
			title : '设置教练',
			items : [ coachGrid ]
		});
		win.show();

	}
});