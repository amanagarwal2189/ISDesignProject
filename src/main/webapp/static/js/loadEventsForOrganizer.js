/**
 * 
 */
 $(document).ready(function(){
        $.ajax({
    		type : "GET",
    		contentType : "application/json",
    		url : "/displayEventsForOrganizer",
    		timeout : 100000,
    		success : function(data) {
    			if(data!=null){
    			$.each(data,function(i,doc){
    				var publishButton='Unpublish'
    				var class_publish='eventUnpublish'	
    				if(doc._active==false){
    					publishButton='Publish'
    					class_publish='eventPublish'
    				}
    				 $('#org-events').append(
        				'<div class="col-sm-6 col-md-4"><div class="thumbnail"><img src="img/event-thumbnail.jpg" alt="..."/><div class="caption" style="text-align:center;">'
    					 +'<div class="truncate"><b>'+doc.title + '</b></div>'
    					 +'<div><button class="btn btn-primary" onclick="viewEvent('+doc.id+')">View</button>&nbsp;&nbsp;'
    					 +'<button id="event_'+doc.id+'" class="'+class_publish+' btn" onclick="changeEventStatus('+doc.id+','+doc._active+')">'+publishButton+'</button></div>'
    					 +'</div></div></div>');
    			});
    					$('#org-events').append(
        				'<div class="col-sm-6 col-md-4"><div class="thumbnail"><a href="/createEvent"><img src="img/text-plus-icon.png" style="height:50%; width:50%; margin:25%" alt="..."/></a>'
    					 +'</div></div>');
    		   }
    			else{
    				$('#org-events').append(
            				'<div class="col-sm-6 col-md-4"><div class="thumbnail"><a href="/createEvent"><img src="img/text-plus-icon.png" style="height:50%; width:50%; margin:25%" alt="..."/></a>'
        					 +'</div></div>');
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
});

	  
function viewEvent(eventId){
	window.location.href = '/displayEvent?eventId='+eventId;
}