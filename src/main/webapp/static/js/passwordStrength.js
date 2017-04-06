$(document).ready(function()
{
	
	$('#newPassword').keyup(function()
	{
		$('#result').html(checkStrength($('#newPassword').val()))
	})	
	
	
	
	function checkStrength(password)
	{
		
		var strength = 0
		
		//if the password length is less than 6, return message.
		if ((password.length >1) && (password.length < 6)) { 
			$('#result').removeClass()
			
			$('#result').addClass('short')
			return 'Short' 
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
			$('#result').addClass('weak').doTimeout( 5000, 'remove' );
			return 'Weak'			
		}
		else if (strength == 2 )
		{
			$('#result').removeClass()
			$('#result').addClass('good').doTimeout( 5000, 'remove' );
			return 'Good'		
		}
		else
		{
			$('#result').removeClass()
			$('#result').addClass('strong')
			return 'Strong'
		}
	}
	

	$('#confpassword').on('keyup', function () {
		if($('#newPassword').val() != null)
		{
	    if ($('#newPassword').val() == $('#confpassword').val()) {
	        $('#result2').html('Matching').css('color', 'white');
	    } else 
	        $('#result2').html('Not Matching').css('color', 'red');
		}
	else{
			$('#result2').html('Enter password').css('color', 'red');
	}
	});
});
