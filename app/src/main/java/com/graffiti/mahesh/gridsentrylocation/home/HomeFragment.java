package com.graffiti.mahesh.gridsentrylocation.home;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.graffiti.mahesh.gridsentrylocation.R;


/**
 * @author 663918
 *
 */
public class HomeFragment extends Fragment implements LocationListener,OnMapReadyCallback {
    // Class to do operations on the Map
    GoogleMap googleMap;
    private LocationManager locationManager;
HomeActivity homeActivity;
    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        Bundle bdl = getArguments();
        homeActivity=(HomeActivity)getActivity();
        // setuping locatiomanager to perfrom location related operations
        locationManager = (LocationManager) getActivity().getSystemService(
                Context.LOCATION_SERVICE);

        // Requesting locationmanager for location updates
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 1, 1, this);
        }

//        MapFragment mapFragment = (MapFragment) getFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
        // To get map from MapFragment from layout
//        googleMap = ((MapFragment) getActivity().getFragmentManager()
//                .findFragmentById(R.id.map)).getMapAsync(get);
        MapFragment mapFragment = (MapFragment) getActivity().getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // To change the map type to Satellite
        // googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // To show our current location in the map with dot
        // googleMap.setMyLocationEnabled(true);

        // To listen action whenever we click on the map
        googleMap.setOnMapClickListener(new OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {
                /*
                 * LatLng:Class will give us selected position lattigude and
                 * longitude values
                 */
                Toast.makeText(getActivity(), latLng.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

        changeMapMode(3);

        // googleMap.setSatellite(true);
        googleMap.setTrafficEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.setMyLocationEnabled(true);

        return v;
    }
    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
    }
    private void doZoom() {
        if (googleMap != null) {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(18.520430, 73.856744), 17));
        }
    }

    private void changeMapMode(int mapMode) {

        if (googleMap != null) {
            switch (mapMode) {
                case 0:
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                    break;

                case 1:
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    break;

                case 2:
                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    break;

                case 3:
                    googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    break;

                case 4:
                    googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    break;

                default:
                    break;
            }
        }
    }

    private void createMarker(double latitude, double longitude) {
        // double latitude = 17.385044;
        // double longitude = 78.486671;

        // lets place some 10 random markers
        for (int i = 0; i < 10; i++) {
            // random latitude and logitude
            double[] randomLocation = createRandLocation(latitude, longitude);

            // Adding a marker
            MarkerOptions marker = new MarkerOptions().position(
                    new LatLng(randomLocation[0], randomLocation[1])).title(
                    "Hello Maps " + i);

            Log.e("Random", "> " + randomLocation[0] + ", " + randomLocation[1]);

            // changing marker color
            if (i == 0)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            if (i == 1)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            if (i == 2)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
            if (i == 3)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            if (i == 4)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
            if (i == 5)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
            if (i == 6)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED));
            if (i == 7)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
            if (i == 8)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
            if (i == 9)
                marker.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

            googleMap.addMarker(marker);

            // Move the camera to last position with a zoom level
            if (i == 9) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(randomLocation[0], randomLocation[1]))
                        .zoom(15).build();

                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        }

    }

    /*
     * creating random postion around a location for testing purpose only
     */
    private double[] createRandLocation(double latitude, double longitude) {

        return new double[] { latitude + ((Math.random() - 0.5) / 500),
                longitude + ((Math.random() - 0.5) / 500),
                150 + ((Math.random() - 0.5) * 10) };
    }

    @Override
    public void onLocationChanged(Location location) {

        if (null != googleMap) {
            // To get lattitude value from location object
            double latti = location.getLatitude();
            // To get longitude value from location object
            double longi = location.getLongitude();

            // To hold lattitude and longitude values
            LatLng position = new LatLng(latti, longi);

            createMarker(latti, longi);

            // Creating object to pass our current location to the map
            MarkerOptions markerOptions = new MarkerOptions();
            // To store current location in the markeroptions object
            markerOptions.position(position);

            // Zooming to our current location with zoom level 17.0f
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position,
                    17f));

            // adding markeroptions class object to the map to show our current
            // location in the map with help of default marker
            googleMap.addMarker(markerOptions);
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        super.onDestroyView();

        locationManager.removeUpdates(this);

        android.app.Fragment fragment = getActivity().getFragmentManager()
                .findFragmentById(R.id.map);
        if (null != fragment) {
            android.app.FragmentTransaction ft = getActivity()
                    .getFragmentManager().beginTransaction();
            ft.remove(fragment);
            ft.commit();
        }
    }


}