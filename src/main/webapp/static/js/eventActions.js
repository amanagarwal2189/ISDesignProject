/**
 * change the status of the event to be published or unpublished 
 */
function changeEventStatus(eventId,currStatus){
		$.ajax({
			type: "GET",
    		contentType : "application/json",
    		url : "/changeEventStatus",
    		data:{'eventId':eventId,'currStatus':currStatus},
    		async:true,
    		timeout : 100000,
    		success : function(data) {
    			if(data!=null){    		
    				var class_publish_event=''
    				var class_publish_button=''
    				var publishButton=''
    				if($('#publishButton_event_'+eventId).hasClass('eventUnpublish')){
    					class_publish_event=''
    					class_publish_button='eventPublish'
    					publishButton='Publish'
    				} else {
    					class_publish_event='publishedEvent'
    					class_publish_button='eventUnpublish'
    					publishButton='Unpublish'
    				}
    				
    				var html = '<div id = "event_'+data.id+'" class="thumbnail '+class_publish_event+'"><img src="static/img/event-thumbnail.jpg" alt="..."/><div class="caption" style="text-align:center;">'
					 +'<div class="truncate"><b>'+data.title + '</b></div>'
					 +'<div><button class="btn btn-primary" onclick="viewEvent('+data.id+')">View</button>&nbsp;&nbsp;'
					 +'<button id="publishButton_event_'+data.id+'" class="'+class_publish_button+' btn" onclick="changeEventStatus('+data.id+','+data._active+')">'+publishButton+'</button></div>'
					 +'</div></div>';
    				$('#event_'+eventId).replaceWith(html)
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


/*
 * fetch the events when sponsor searches for the events 
 */
function callForEvents(fromDate,toDate,city,state,zip, loc){
	$('#sponsor-events').empty();
	 $.ajax({
 		type : "GET",
 		contentType : "application/json",
 		url : "/displayEventsForSponsor",
 		data:{'fromDate':fromDate,'toDate':toDate,'city':city,'state':state, 'zip':zip},
 		timeout : 100000,
 		success : function(data) {
 			if(data!=null && data.length>0){
 				if(loc=="inside"){
 					$.each(data,function(i,doc){
 						$('#sponsor-events').append('<div class="result-title-mini col-xs-12"><div class="result-title-mini row"><div class="col-xs-12">Results</div></div></div>'+
 							'<div class="col-sm-6 col-md-4"><div class="thumbnail"><img src="static/img/event-thumbnail.jpg" alt="..."/><div class="caption" style="text-align:center;">'
 							+'<div class="truncate"><b>'+doc.title + '</b></div>'+'<div> <a href="/displaySelectedEvent?eventId='+doc.id+'" class="btn btn-primary" role="button">View</a></div>'+
 							'</div></div></div>'); 			    
 					});
 				}
 				else{
 					$.each(data,function(i,doc){ 				
 	 					 $('#sponsor-events').append('<div class="result-title-mini col-xs-12"><div class="result-title-mini row"><div class="col-xs-12">Results</div></div></div>'+
 	     					'<div class="col-sm-6 col-md-4"><div class="thumbnail"><img src="static/img/event-thumbnail.jpg" alt="..."/><div class="caption" style="text-align:center;">'
 	 					 	+'<div class="truncate"><b>'+doc.title + '</b></div>'+'<div><button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#sponsorModal">View</button></div>'+
 	     					'</div></div></div>');  
 	 				});
 				}
 			}
 			else{
 				$('#sponsor-events').append('<div class="col-xs-12"><div class="row"><div id="noEventsFound" class=" img-fluid col-xs-12 col-sm-12 col-md-12" style="text-align:center; height: auto;"><img src="static/img/notfound.jpeg" width=100% alt="Not found"/></div></div>');
 			}
 		},
 		error : function(e) {
 			console.log("ERROR: ", e);
 		},
 		done : function(e) {
 			console.log("DONE");
 		}
 	});
}


/*
 * When search is clicked on sponsor pages
 * */
function clickSearch(loc){
	var fromDate = document.getElementById('fromDate').value;
	var toDate = document.getElementById('toDate').value;
	var city = document.getElementById('city').value;
	var state = document.getElementById('state').value;
	var zip = document.getElementById('zip').value;
	callForEvents(fromDate,toDate,city,state,zip, loc);
}

function clickSearchMini(loc){
	var fromDate = document.getElementById('from-date-mini').value;
	var toDate = document.getElementById('to-date-mini').value;
	var city = document.getElementById('city-mini').value;
	var state = document.getElementById('state-mini').value;
	callForEvents(fromDate,toDate,city,state,"", loc);
}

function showOptions(){
	if($('#text-show').text()=="show"){
		$('.more').removeClass("more-hide");
		$('.more').addClass("more-show");
		$('#arrow').removeClass("glyphicon-chevron-down")
		$('#arrow').addClass("glyphicon-chevron-up")
		$('#text-show').html("hide")
	} else {
		$('.more').removeClass("more-show");
		$('.more').addClass("more-hide");
		$('#arrow').removeClass("glyphicon-chevron-up")
		$('#arrow').addClass("glyphicon-chevron-down")
		$('#text-show').html("show")
	}
}