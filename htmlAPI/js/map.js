let x = document.getElementById("Lat");
let y = document.getElementById("Long");	
let map = null;
let geocoder = new kakao.maps.services.Geocoder();

function error(mistake) {
    alert(`ERROR(${mistake.code}): ${mistake.message}`);
};

function success(position) {
     map = new kakao.maps.Map(document.querySelector('.mapArea'),{
  center: new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude), 
  level : 1}); 
     
    if ( localStorage.getItem('Latitude') === null && localStorage.getItem('Longitude') === null ){
       localStorage.setItem( 'Latitude', JSON.stringify([position.coords.latitude]) );
       localStorage.setItem( 'Longitude', JSON.stringify([position.coords.longitude]) );
    }
     
    let lat = JSON.parse(localStorage.getItem('Latitude'));
    let lon = JSON.parse(localStorage.getItem('Longitude'));
    
    lat.push(position.coords.latitude);   
    lon.push(position.coords.longitude);

    localStorage.setItem( 'Latitude', JSON.stringify(lat) );
    localStorage.setItem( 'Longitude', JSON.stringify(lon) );
    

    x.innerHTML = localStorage.getItem('Latitude');
    y.innerHTML = localStorage.getItem('Longitude');

    let latArr = JSON.parse(localStorage.getItem('Latitude'));
    let lonArr = JSON.parse(localStorage.getItem('Longitude'));
    
    for(let i = 0; i < latArr.length - 1; i++){
      searchAddrFromCoords(new kakao.maps.LatLng(latArr[i], lonArr[i]), displayCenterInfo);
    }
    
}
 
window.onload = function getLocation() {
  if (navigator.geolocation) {	  
    navigator.geolocation.getCurrentPosition(success, error);
  }
}

const marker = new kakao.maps.Marker();

kakao.maps.event.addListener(map, 'click', (mouseEvent) => {
  //마커 위치를 클릭한 위치로 이동
  marker.setPosition(mouseEvent.latLng);
  marker.setMap(map);
  
  alert(`위도 : ${latlng.getLat()}, 경도 : ${latlng.getLng()}`);
}); 

function searchAddrFromCoords(coords, callback) {
    // 좌표로 행정동 주소 정보를 요청합니다
    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
}

function displayCenterInfo(result, status) {
    if (status === kakao.maps.services.Status.OK) {
      
        let infoDiv = document.getElementById('centerAddr');

        for(var i = 0; i < result.length; i++) {
          let addressList = document.createElement("div");     
          let textnode = document.createTextNode(result[i].address_name);
          
          infoDiv.appendChild(addressList)
          addressList.appendChild(textnode);
        } 
    }    
}
