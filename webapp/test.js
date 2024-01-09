
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

function deleteRecord(){
	
}

function chkinserted(){
	alert("북마크 그룹 정보를 추가했습니다.");
}