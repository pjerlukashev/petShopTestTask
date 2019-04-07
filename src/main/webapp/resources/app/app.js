Ext.define('Person', {
    alias: 'model.person',
    extend: 'Ext.data.Model',

    idProperty:'id',
    fields: [  {name: 'id', type: 'int'},  {name: 'name', type: 'string'}, {name: 'email', type: 'string'}  ]
} );

Ext.define('Persons', {
    extend: 'Ext.data.Store',
    alias: 'store.persons',
    model: 'Person',
    autoLoad:true,
    autoSync: true,
    proxy: {
        type: 'rest',
        url : 'ajax/person',
        appendId: true,
        reader: 'json',
        writer: {writeAllFields: true}
    }
});

Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'MyApp',

    launch: function() {

        Ext.create('Ext.container.Viewport', {

      layout: 'fit',

            items: [{

                xtype: 'tabpanel',

                layout: 'fit',

                items: [{
                    title: 'Persons',
                    xtype: 'grid',
                    iconCls: 'x-fa fa-users',

                    selType: 'rowmodel',
                    plugins: [{
                        ptype: 'rowediting',
                        clicksToEdit: 1
                    }],

                    store: {
                       type: 'persons'
                    },
                    columns: [{
                        text: 'Name',
                        dataIndex: 'name',
                        editor: 'textfield',
                        flex: 1
                    }, {
                        text: 'E-mail',
                        dataIndex: 'email',
                        editor: 'textfield',
                        flex: 1
                    },
                        {
                            xtype:'actioncolumn',
                            width:50,
                            items: [{
                                iconCls: 'x-fa fa-close',
                                tooltip: 'Delete',
                                handler: function(grid, rowIndex, colIndex) {
                                    grid.getStore().removeAt(rowIndex);
                                }
                            }]
                        }

                    ],

                    dockedItems: [

                        {
                            xtype: 'toolbar',
                            docked: 'top',
                            width:100,
                            items: ['->', {
                                xtype: 'button',
                                text: 'Add person',
                                iconCls: 'x-fa fa-check',
                                handler: function(view) {
                                   Ext.Viewport.add({
                                        xtype: 'formpanel',
                                        title: 'Update Record',
                                        width: 300,
                                        floating: true,
                                        centered: true,
                                        modal: true,
                                        items: [
                                            {
                                                xtype: 'textfield',
                                                name: 'id',
                                                label: 'Id'
                                            },
                                            {
                                            xtype: 'textfield',
                                            name: 'name',
                                            label: 'Name'
                                        },  {
                                                xtype: 'textfield',
                                                name: 'email',
                                                label: 'Email'
                                            },
                                            {
                                            xtype: 'toolbar',
                                            docked: 'bottom',
                                            items: ['->', {
                                                xtype: 'button',
                                                text: 'Submit',
                                                iconCls: 'x-fa fa-check',
                                                handler: function(id, name, email) {

                                                    store.add( this.up('formpanel').getValues())

                                                    this.up('formpanel').destroy();
                                                }
                                            }, {
                                                xtype: 'button',
                                                text: 'Cancel',
                                                iconCls: 'x-fa fa-close',
                                                handler: function() {
                                                    this.up('formpanel').destroy();
                                                }
                                            }]
                                        }]
                                    });
                                }
                            }]
                        }
                        ]
                }, {

                    xtype: 'panel',
                    title: 'About Sencha',
                    iconCls: 'x-fa fa-info-circle'
                }]
      }]
        });
    }
});