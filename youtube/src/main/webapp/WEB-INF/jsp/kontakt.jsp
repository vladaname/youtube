<!DOCTYPE html>
<html>
<body>

<h1>Novi Sad, Bulevar oslobodjenja 15</h1>

<div id="map" style="width:100%;height:550px;"></div>

<script>
    function myMap() {
        // var mapProp= {
        //     center:new google.maps.LatLng(45.255129,19.835364),
        //     zoom:16,
        // };
        // var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
        //
        // var marker = new google.maps.Marker({position: mapProp});
        //
        // marker.setMap(googleMap);
        var location = {lat: 45.255129,lng: 19.835364};
        var map = new google.maps.Map(document.getElementById("map"),{
            zoom:16,
            center: location
        });
        var marker = new google.maps.Marker({
            position: location,
            map: map
        })
    }
</script>

<script src="https://maps.googleapis.com/maps/api/js?AIzaSyDuM6DtHRqar5GCAt8rTyKIa0BP5Kue0v4&callback=myMap"></script>

</body>
</html>
