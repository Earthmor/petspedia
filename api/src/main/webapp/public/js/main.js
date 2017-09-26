
Ext.onReady(function() {
    Ext.QuickTips.init();

    var store = new Ext.data.JsonStore({
        url: 'medicines',
        root: 'data',
        autoLoad: true,
        fields: [
            {name: 'id', type: 'integer'},
            {name: 'name', type: 'string'},
            {name: 'customer', type: 'string'},
            {name: 'price', type: 'float'},
            {name: 'stock', type: 'string'},
            {name: 'available', type: 'string'},
            {name: 'createDate', mapping: 'Date', type: 'date', dateFormat:'c'},
            {name: 'updateDate', mapping: 'Date', type: 'date', dateFormat:'c'}
        ]
    });

    var grid = new Ext.grid.GridPanel({
        id: 'gridMedicines',
        title: 'Medicines',
        width: 600,
        height: 250,
        renderTo: 'grid-medicines',
        store: store,
        columns: [
            {
                header   : 'ID',
                dataIndex: 'id'
            },
            {
                header   : 'Name',
                dataIndex: 'name'
            },
            {
                header   : 'Производитель',
                dataIndex: 'customer'
            },
            {
                header   : 'Цена',
                dataIndex: 'price',
                render: Ext.util.Format.usMoney
            },
            {
                header   : 'Склад',
                dataIndex: 'stock'
            },
            {
                header   : 'Доступно',
                dataIndex: 'available'
            },
            {
                header   : 'Дата создания',
                renderer : Ext.util.Format.dateRenderer('m/d/Y'),
                dataIndex: 'createDate'
            },
            {
                header   : 'Последнее обновление',
                renderer : Ext.util.Format.dateRenderer('m/d/Y'),
                dataIndex: 'updateDate'
            }
        ]
    });
});