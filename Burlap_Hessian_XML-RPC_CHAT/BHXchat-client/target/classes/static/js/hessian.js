(function worker() {
	  $.ajax({
		type:'GET',
	    url: '/hessian2', 
	    success: function(data) {
	    	$('#chatText').text('');
	      for(var i=0;i<data.length;i++){
	    	  var date = new Date(data[i].date);
	    	  $('#chatText').append('<p>['+date.getHours()+':'+date.getMinutes()+']'+data[i].textMessage+'</p>');
	      }
	      document.getElementById( 'chatBottom' ).scrollIntoView();
	      console.log(data);
	    },
	    complete: function() {
	      setTimeout(worker, 1000);
	    }
	  });
	})();