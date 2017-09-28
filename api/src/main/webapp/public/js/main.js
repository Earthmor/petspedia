Ext.onReady(function() {

    Ext.QuickTips.init();

    var fm = Ext.form;
    var editor = new Ext.ux.grid.RowEditor({
        saveText: 'Update'
    });
    var fields =
        [
            {name: 'name', type: 'string'},
            {name: 'customer', type: 'string'},
            {name: 'price', type: 'float'},
            {name: 'stock', type: 'string'},
            {name: 'available', type: 'bool'},
            {name: 'createDate', type: 'date', dateFormat:'dd.MM.yyyy HH:mm:ss'},
            {name: 'updateDate', type: 'date', dateFormat:'dd.MM.yyyy HH:mm:ss'}
        ]
    ;
    var Medicine = Ext.data.Record.create(fields);
    var store = new Ext.data.JsonStore({
        url: 'medicines',
        root: 'data',
        autoLoad: true,
        fields: fields
    });

    var grid = new Ext.grid.GridPanel({
        id: 'gridMedicines',
        title: 'Medicines',
        width: 1000,
        height: 250,
        renderTo: 'grid-medicines',
        store: store,
        plugins: [editor],
        tbar:
            [
                {
                    iconCls: 'icon-user-add',
                    text: 'Добавить лекарство',
                    handler: function(){
                        var m = new Medicine({
                            name: 'Новое лекарство',
                            customer: 'Ты знаешь его?',
                            price: 333.33,
                            stock: 'На луне',
                            available: false,
                            createDate: new Date(),
                            updateDate: new Date()
                        });
                        editor.stopEditing();
                        store.insert(0, m);
                        grid.getView().refresh();
                        grid.getSelectionModel().selectRow(0);
                        editor.startEditing(0);
                    }
                },{
                    ref: '../removeBtn',
                    iconCls: 'icon-user-delete',
                    text: 'Удалить лекарство',
                    disabled: true,
                    handler: function(){
                        editor.stopEditing();
                        var s = grid.getSelectionModel().getSelections();
                        for(var i = 0, r; r = s[i]; i++){
                            store.remove(r);
                        }
                    }
                }
            ],
        columns: [
            new Ext.grid.RowNumberer(),
            {
                header   : 'Name',
                dataIndex: 'name',
                editor: new fm.TextField({
                    allowBlank: false
                })
            },
            {
                header   : 'Производитель',
                dataIndex: 'customer',
                editor: new fm.TextField({
                    allowBlank: false
                })
            },
            {
                header   : 'Цена',
                dataIndex: 'price',
                align: 'right',
                render: 'usMoney',
                editor: new fm.NumberField({
                    allowBlank: false,
                    allowNegative: false,
                    maxValue: 100000
                })
            },
            {
                header   : 'Склад',
                dataIndex: 'stock',
                editor: new fm.TextField({
                    allowBlank: false
                })
            },
            {
                header   : 'Доступно',
                dataIndex: 'available'
            },
            {
                header   : 'Дата создания',
                renderer : Ext.util.Format.dateRenderer('dd.MM.yyyy HH:mm:ss'),
                dataIndex: 'createDate'
            },
            {
                header   : 'Последнее обновление',
                renderer : Ext.util.Format.dateRenderer('dd.MM.yyyy HH:mm:ss'),
                dataIndex: 'updateDate'
            }
        ]
    });

    store.on('add', function(){
        Ext.Ajax.request({
            url: 'medicines',
            method: 'POST',
            jsonData: Ext.util.JSON.encode(this.data.items[0].data),
            success: function(){}
        });
    });
    store.on('remove', function(store, m){
        Ext.Ajax.request({
            url: 'medicines/' + m.id,
            method: 'DELETE',
            success: function(){}
        });
    });
    store.on('update', function(store, m){
        m.data.id = m.id;
        Ext.Ajax.request({
            url: 'medicines/'+ m.id,
            method: 'POST',
            jsonData: Ext.util.JSON.encode(m.data),
            success: function(){}
        });
    });

    grid.getSelectionModel().on('selectionchange', function(sm){
        grid.removeBtn.setDisabled(sm.getCount() < 1);
    });
});