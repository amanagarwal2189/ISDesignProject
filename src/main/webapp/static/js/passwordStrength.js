$(document).ready(function()
{
	
	$('#newPassword').keyup(function()
	{
		//alert($('#uname').val());
		if(($('#newPassword').val() == null)&& ($('#newPassword').val() == '')){
			$('#result').val('');
		}
		else{
		$('#result').html(checkStrength($('#newPassword').val()))
		
    	$("#confpassword").removeClass();

    	$('#result2').empty();
    	//$('#result').empty('');
    	$('#registerbtn').prop('disabled', true);
    	$('#registerbtn').removeClass();
        $('#registerbtn').addClass('regButton');
		}
	});	
	
	
	
	function checkStrength(password)
	{
		
		var strength = 0
		//alert(password.length);
		//if the password length is less than 6, return message.
		if(password.length==0){
			$('#result').val('');
		}
		
		if ((password.length >1) && (password.length < 6)) { 
			$('#result').removeClass()
			
			$('#result').addClass('short')
			return 'Short password' 
		}
		
		//length is ok, lets continue.
		
		//if length is 8 characters or more, increase strength value
		if (password.length > 7) strength += 1
		
		//if password contains both lower and uppercase characters, increase strength value
		if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/))  strength += 1
		
		//if it has numbers and characters, increase strength value
		if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/))  strength += 1 
		
		//if it has one special character, increase strength value
		if (password.match(/([!,%,&,@,#,$,^,*,?,_,~])/))  strength += 1
		
		//if it has two special characters, increase strength value
		if (password.match(/(.*[!,%,&,@,#,$,^,*,?,_,~].*[!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1
		
		//now we have calculated strength value, we can return messages
		
		//if value is less than 2
		if (strength < 2 )
		{
			$('#result').removeClass()
			$('#result').addClass('weak')//.doTimeout( 5000, 'remove' );
			return 'Weak password'			
		}
		else if (strength == 2 )
		{
			$('#result').removeClass()
			$('#result').addClass('good')//.doTimeout( 5000, 'remove' );
			return 'Good password'		
		}
		else
		{
			$('#result').removeClass()
			$('#result').addClass('strong')
			return 'Strong password'
		}
	}
	

	$('#confpassword').on('keyup', function () {
		if(($('#newPassword').val() != null)&& ($('#newPassword').val() != ''))
		{
			//console.log($('input[name="usermail"]').val());
	    if (($('#newPassword').val() == $('#confpassword').val()) 
	    		&& ($('input[name="usermail"]').val()== '') 
	    		&& (($('#uname').val()!=null) && ($('#uname').val()!=''))) {
	        $('#result2').html('Matching').css('color', 'white');
	        $('#result2').html('Matching').css('font-size','0.7em');
	        $('#registerbtn').prop('disabled', false);
	        $('#registerbtn').removeClass();
	        $('#registerbtn').addClass('successButton');
	        
	    }
	    else if ($('#newPassword').val() == $('#confpassword').val()){
	    	 $('#result2').html('Matching').css('color', 'white');
		     $('#result2').html('Matching').css('font-size','0.7em');
	    }
	     else {
	        $('#result2').html('Not Matching').css('color', 'red');
	    	$('#result2').css('font-size','0.7em');
		}
		}
	else{
		$('#result').html('')
			$('#result2').html('Enter password').css('color', 'red');
			$('#result2').css('font-size','0.7em');
	}
	});
});

