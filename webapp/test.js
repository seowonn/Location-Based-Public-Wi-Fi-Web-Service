
function getCurrentPositionLatLng() {
	if(navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			const latitude = position.coords.latitude;
			const longitude = position.coords.longitude;
			document.getElementById("currentLat").value = latitude.toFixed(7);
			document.getElementById("currentLnt").value = longitude.toFixed(7);
		});
	} else {
		alert("해당 브라우저에서는 geolocation이 지원되지 않습니다.");
	}
}

function getNearWifis() {
	
	const lat = document.getElementById("currentLat").value;
	const lnt = document.getElementById("currentLnt").value;
	
	if(lat != "" || lnt != "") {
		window.location.assign("http://localhost:8080/Mission1Project/index.jsp/?lat" + lat + "&lnt=" + lnt);
	} else {
		alert("위치가 입력되지 않았습니다.")
	}
	
	document.getElementById("currentLat").value = latitude.toFixed(7);
	document.getElementById("currentLnt").value = longitude.toFixed(7);
}