Ext.onReady(function() {
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
			type : 'date'
		}, {
			name : 'remark',
			type : 'string'
		}, {
			name : 'type',
			type : 'string'
		}, {
			name : 'coachId',
			type : 'long'
		}, {
			name : 'stuId',
			type : 'long'
		} ]
	});
});