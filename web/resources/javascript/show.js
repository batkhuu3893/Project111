//$(function(){
//
//	var createRecordDataElement = function(props) {
//		var name = props.name;
//		var className = props.className;
//		var maxLength = props.maxLength;
//		var InitialValue = props.InitialValue;
//		var type = props.type;
//
//		var addStyle=props.addStyle;
//		style=style+addStyle;
//
//		var td = $('<td></td>');
//		var input = $('<input />', {
//			'class': 'form-control saveFalse' + className,
//			name: name,
//			maxlength: maxLength,
//			value: InitialValue,
//			type: type
//		})
//
//		td.append(input);
//		return td;
//	}
//
//	var createRecordItem = function() {
//		var item = $('<div></div>', { 'class': 'item' });
//		var table = $('<table></table>', { 'class': 'table' });
//		var row = $('<tr></tr>');
//
//		var btns = $('<div></div>',{'class':'button_position'});
//
//		var syoken_id = createRecordDataElement({
//			name: 'syoken_id',
//			className: 'syoken_id',
//			maxLength: '8',
//			isNumeric: true,
//			InitialValue:Initial_syoken_id_Value
//		});
//
//		var syumoku = createRecordDataElement({
//			name: 'syumoku',
//			className: 'syumoku',
//			maxLength: '12',
//			isType: true,
//			InitialValue:Initial_syumoku_Value
//		});
//
//		var sikibi = createRecordDataElement({
//			name: 'sikibi',
//			className: 'sikibi',
//			maxLength: '12',
//			InitialValue:Initial_sikibi_Value
//		});
//
//		var syukibi = createRecordDataElement({
//			name: 'syukibi',
//			className: 'syukibi',
//			maxLength: '12',
//			InitialValue:Initial_syukibi_Value
//		});
//
//		var  kokyaku_mei = createRecordDataElement({
//			name: 'kokyaku_mei',
//			className: 'kokyaku_mei',
//			maxLength: '8',
//			InitialValue:Initial_kokyaku_mei_Value
//		});
//
//		row.append(syoken_id);
//		row.append(syumoku);
//		row.append(sikibi);
//		row.append(syukibi);
//		row.append(kokyaku_mei);
//		row.append('<button type= "button" class= "btn btn-danger listdelete" form ="listdelete" style="margin:5px;" data-toggle="modal" data-target="#mylist_delete"> 削除 </button>');
//
//		table.append(row);
//		item.append(table);
//
//		item.append(btns);
//		return item;
//	}
//
//	var lineNames = [];
//
//	$.each(lineItems, function(index, line){
//		lineNames.push(line.name);
//	});    
    
    $(document).ready(function(){
        var syoken = $('.syoken_class').val();
        var syoken1 = $('.syoken1').val();
        var syoken2 = $('.syoken2').val();
        var syoken3 = $('.syoken3').val();
        var syoken4 = $('.syoken4').val();
        
            alert(syoken);
            alert(syoken1);
            alert(syoken2);
            alert(syoken3);
            alert(syoken4);
            
//        var syoken_id = {
//            syoken_id: syoken_id
//        }    
//        var abc;
//            $.ajax({
//                url: url,
//                data: data,
//                success: success,
//                dataType: dataType
//              })
//                      .done(function(data){
//                          abc = data;
//                            console.log(data);
//                            console.log('長さ:${data.length}');
//                for(var i=0;i<data.length; i++){
//                    Initial_syoken_id_Value=data[i].syoken_id;
//                    Initial_syumoku_Value=data[i].syumoku;
//                    Initial_sikibi_Value=data[i].sikibi;
//                    Initial_syukibi_Value=data[i].syukibi;
//                    Initial_kokyaku_mei_Value=data[i].kokyaku_mei;
//                    
//                    $(".items").append(createRecordItem);
//                    
//                }  
//                    Initial_syoken_id_Value="";
//                    Initial_syumoku_Value="";
//                    Initial_sikibi_Value = "";
//                    Initial_syukibi_Value = "";
//                    Initial_kokyaku_mei_Value = "";
//                    
//                      })
//        });
});
