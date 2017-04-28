/**
 * 
 */



function changeEventStatus(eventId,currStatus){
		$.ajax({
			type: "POST",
    		contentType : "application/json",
    		url : "/changeEventStatus?eventId="+eventId+"&currStatus="+currStatus,
    		data:{'eventId':eventId,'currStatus':currStatus},
    		async:true,
    		timeout : 100000,
    		success : function(data) {
    			if(data!=null){
    				/*$('#event_eventId').click(function(){
    				    
    				});*/
    				
    				if($('#event_'+eventId).hasClass('eventUnpublish')){
				        $('#event_'+eventId).removeClass('eventUnpublish')
				        $('#event_'+eventId).addClass('eventPublish')
				        $('#event_'+eventId).html('Publish')
				    } else {
				    	$('#event_'+eventId).removeClass('eventPublish')
				    	$('#event_'+eventId).addClass('eventUnpublish')
				         $('#event_'+eventId).html('Unpublish')
				    }
    		   }
    		},
    		error : function(e) {
    			console.log("ERROR: ", e);
    			//display(e);
    		},
    		done : function(e) {
    			console.log("DONE");
    		}
    	});
	return currStatus;
}