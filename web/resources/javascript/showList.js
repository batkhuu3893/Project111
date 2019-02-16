$(function(){
   
    var createList = function(props){
		var name = props.name;
		var className = props.className;
		var maxLength = props.maxLength;
		var InitialValue = props.InitialValue;
		var type = props.type;
        
        var addStyle = props.addStyle;
        style = style + addStyle;
        
        var td = $('<td></td>');
        var input = $('<input />',{
            'class': 'form-control save' + className,
            name: name,
            type: type
        })
        
        td.append(input);
        return td;
    }
    
    var createRecord = function(){
        var item = $('<div></div>', { 'class': 'item'});
        var table = $('<table></table>', {'class': 'table'});
        var row = $('<tr></tr>');
        
        var btns = $('<div></div>', {'class':'button_position'});
        
        var syoken_id = createList({
            name: 'syoken_id',
            className: 'syoken_id',
            maxLength: '8',
            InitialValue:Initial_syoken_id_Value
        });
        
        var syumoku = createList({
            name: 'syumoku',
            className: 'syumoku',
            maxLength: '12',
            InitialValue:Initial_syumoku_Value
        });
        
        var sikibi = createList({
            name: 'sikibi',
            className: 'sikibi',
            maxLength: '12',
            InitialValue:Initial_sikibi_Value
        });
        
        var syukibi = createList({
            name: 'syukibi',
            className: 'syukibi',
            maxLength: '12',
            InitialValue:Initial_syukibi_Value
        });
        
        var mei = createList({
            name: 'mei',
            className: 'mei',
            maxLength: '30',
            InitialValue:Initial_mei_Value
        });
        
        row.append('<button type = "button" class = "btn btn-dager" form="ddd" data-toggle="modal" data-target="#mylist_delete" >照会</button>');
        row.append(syoken_id);
        row.append(syumoku);
        row.append(sikibi);
        row.append(syukibi);
        row.append(mei);
        
        table.append(row);
        item.append(table);
        
        item.append(btns);
                
        return item;
    }
    
    var lineNames = [];
    
    $.each(lineItems, function(index, line){
        lineNames.push(line.name);
        
    });
    
    $(function(){
        
        $(document).ready(function(){
            console.log("111111111111111111111");
            
            var syoken_id = document.getElementById('syoken_id').innerText;
            console.log(user_id);
            
            var id = {
                syoken_id: syoken_id
            }
            var abc;
                $.ajax({
                    url: "data",
                    data: "SET",
                    type: "",        
                })
                        .done(function(data){
                            
                        });
        });
    });
    
});

