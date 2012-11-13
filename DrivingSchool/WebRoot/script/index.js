Ext.onReady(function() {

	var store = Ext.create('Ext.data.TreeStore', {
		root : {
			expanded : true,
			children : [ {
				text : "人员管理",
				leaf : false,
				expanded : true,
				children : [ {
					text : '学员管理',
					url : 'login.jsp',
					leaf : true
				}, {
					text : '教练管理',
					leaf : true
				} ]
			}, {
				text : "车辆管理",
				leaf : true
			}, {
				text : "库存管理",
				leaf : true
			}, {
				text : '新闻管理',
				url : 'news.jsp',
				leaf : true
			}, {
				text : '学习项目管理',
				leaf : true
			}, {
				text : '报名点管理',
				leaf : true
			}, {
				text : '考试管理',
				expanded : true,
				children : [ {
					text : '题库管理',
					leaf : true
				}, {
					text : '成绩管理',
					leaf : true
				} ]
			}, {
				text : '帮助信息',
				url : 'help.jsp',
				leaf : true
			} ]
		}
	});

	var treePanel = Ext.create('Ext.tree.Panel', {
		// layout: 'anchor',
		region : 'west',
		layout : {
			anchor : '100%,100%'
		},
		store : store,
		collapsible : true,
		title : '导航',
		width : 200,
		border : false,
		rootVisible : false,
		// 树的监听事件
		listeners : {
			/*
			 * this : Ext.view.View record : Ext.data.Model item : HTMLElement
			 * index : Number e: Ext.EventObject options : Object
			 */
			itemclick : function(tree, record, item, index, e, options) {
				var nodeText = record.data.text, tabPanel = viewport.items
						.get(4), tabBar = tabPanel.getTabBar(), tabIndex;
				for ( var i = 0; i < tabBar.items.length; i++) {
					if (tabBar.items.get(i).getText() === nodeText) {
						tabIndex = i;
					}
				}

				// 判断tabIndex是否赋值且当前节点是否为叶子节点
				if (Ext.isEmpty(tabIndex) && record.raw.leaf) {
					// var id = record.attributes.id;
					var fname = record.data.fname;
					var url = record.raw.url;
					tabPanel.add({
						title : record.data.text,
						html : "<iframe style='width:100%;height:100%;' name="
								+ fname + " frameborder='0' src='" + url
								+ "'></frame>"
					});
					tabIndex = tabPanel.items.length - 1;
				}
				tabPanel.setActiveTab(tabIndex);
			}
		}
	});

	var viewport = Ext.create('Ext.container.Viewport', {
		layout : 'border',
		baseCls : 'x-panel',
		items : [ {
			region : 'north',
			html : '<h1 class="x-panel-header">武夷驾校</h1>',
			height : 100,
			border : false,
			margins : '0 0 5 0'
		}, treePanel, {
			region : 'south',
			html : 'copyright@js,2012-2020',
			split : true,
			height : 100
		}, {
			region : 'center',
			xtype : 'tabpanel',
			// TabPanel itself has no title
			activeTab : 0,
			// First tab active by default
			items : {
				title : '首页',
				html : '欢迎使用驾校资源管理系统...'
			}
		} ]
	});
});