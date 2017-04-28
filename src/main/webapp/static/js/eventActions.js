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
    				
    				if($('#publishButton_event_'+eventId).hasClass('eventUnpublish')){
				        $('#publishButton_event_'+eventId).removeClass('eventUnpublish')
				        $('#publishButton_event_'+eventId).addClass('eventPublish')
				        $('#publishButton_event_'+eventId).html('Publish')
				        $('#event_'+eventId).removeClass('publishedEvent')
				        
				    } else {
				    	$('#publishButton_event_'+eventId).removeClass('eventPublish')
				    	$('#publishButton_event_'+eventId).addClass('eventUnpublish')
				         $('#publishButton_event_'+eventId).html('Unpublish')
				         $('#event_'+eventId).addClass('publishedEvent')
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