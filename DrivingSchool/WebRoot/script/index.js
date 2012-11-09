Ext.onReady(function() {

    var store = Ext.create('Ext.data.TreeStore', {
        root: {
            expanded: true,
            children: [{
                text: "学员管理",
                leaf: false,
                expanded: true,
                children: [{
                    text: '学员信息',
                    leaf: true
                }, {
                    text: '学员操作',
                    leaf: true
                }]
            }, {
                text: "教练管理",
                expanded: true,
                children: [{
                    text: '教练信息',
                    leaf: true
                }, {
                    text: '添加教练',
                    leaf: true
                }]
            }, {
                text: "车辆管理",
                leaf: true
            }, {
                text: '新闻管理',
                leaf: true
            }, {
                text: '考试管理',
                leaf: true
            }]
        }
    });

    var treePanel = Ext.create('Ext.tree.Panel', {
        layout:'fit',
        store: store,
        rootVisible: false
    });

    Ext.create('Ext.container.Viewport', {
        layout: 'border',
        items: [{
            region: 'north',
            html: '<h1 class="x-panel-header">武夷驾校</h1>',
            height: 100,
            border: false,
            margins: '0 0 5 0'
        }, {
            region: 'west',
            collapsible: true,
            title: '导航',
            width: 200,
            items: [{
                xtype: 'treepanel',
                width:200,
                store: store,
                rootVisible: false
            }]
            // could use a TreePanel or AccordionLayout for navigational items
        }, {
            region: 'south',
            html: 'copyright@js,2012-2020',
            split: true,
            height: 100
        }, {
            region: 'center',
            xtype: 'tabpanel',
            // TabPanel itself has no title
            activeTab: 0,
            // First tab active by default
            items: {
                title: 'Default Tab',
                html: 'The first tab\'s content. Others may be added dynamically'
            }
        }]
    });
});