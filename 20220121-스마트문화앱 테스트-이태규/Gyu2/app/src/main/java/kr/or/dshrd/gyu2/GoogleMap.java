package kr.or.dshrd.gyu2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GoogleMap extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener  {

    boolean isPermissionGranted;
    FloatingActionButton fab;
    private FusedLocationProviderClient mLocationClient;
    private int GPS_REQUSET_CODE = 9001;
    //?????? ????????? ?????? 9001

    com.google.android.gms.maps.GoogleMap mGoogleMap;

    EditText localSearch;
    ImageView searchIcon;
    LottieAnimationView lottie;
    ImageView google_back_arrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);


        lottie = findViewById(R.id.lottie2);


        //hooks
        fab = findViewById(R.id.fab);

        localSearch = findViewById(R.id.etext_search);
        searchIcon = findViewById(R.id.search_icon);

        //?????? ??????
        checkPermission();

        //?????? ?????? ??? ?????? ?????? ??????
        initMap();
        mLocationClient = new FusedLocationProviderClient(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrLoc();
                lottie.animate()
                        .translationX(2000)
                        .setDuration(5000);
//                        .setStartDelay(3000);
            }
        });

        google_back_arrow = findViewById(R.id.google_back_arrow);

        google_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GoogleMap.this, MyCart.class);
                startActivity(intent);
            }
        });

        //?????? ???????????? ????????? ???????????? ?????? ???
        searchIcon.setOnClickListener(this::getCurrLoc);

    }


    private void getCurrLoc(View view) {
        String locationName = localSearch.getText().toString();

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        //?????? ????????? ?????? ???????????? API??? ???????????? ??? ????????? ??????????????? ???????????? ???????????? ??????
        //???????????? ????????? ?????????????????? ??????
        try {
            List<Address> addressList = geocoder.getFromLocationName(locationName, 1);

            if(addressList.size()>0){
                Address address = addressList.get(0);

                gotoLocation(address.getLatitude(), address.getLongitude());
                mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(address.getLatitude(), address.getLongitude()))
                        .icon(BitmapDescriptorFactory.fromResource(R.raw.lottie_anim)));

                Toast.makeText(this,address.getLocality(), Toast.LENGTH_SHORT).show();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void initMap() {

        if(isPermissionGranted){
            //??????????????? ???????????? ?????? ?????????.
            if(isGPSenable()){
                SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
                supportMapFragment.getMapAsync(this);
            }
        }
    }

    private boolean isGPSenable (){
        //?????? ????????? ????????? ????????? ?????? ?????? ????????? ??????????????? ????????? ????????? ????????????
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean providerEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(providerEnable){
            return true;
        }else{
            //?????????
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("GPS Permission")
                    .setMessage("GPS is required for this app to work. Please enable GPS")
                    .setPositiveButton("Yes", ((dialogInterface, i) -> {
                        //???????????? ????????? ????????? ???????????? ?????????
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent, GPS_REQUSET_CODE);
                    }))

                    .setCancelable(false)
                    .show();
        }
        return false;
    }

    @SuppressLint("MissingPermission")
    private void getCurrLoc() {

        mLocationClient.getLastLocation().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Location location = task.getResult();
//               if (location == null){
                gotoLocation(location.getLatitude(), location.getLongitude());
//               }

            }
        });

    }

    private void gotoLocation(double latitude, double longitude) {

        LatLng LatLng = new LatLng(latitude, longitude);
//        LatLng LatLng = new LatLng(35.16046261995374, 129.06159013754373);


        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng,18);
//        mGoogleMap.moveCamera(cameraUpdate);
        mGoogleMap.animateCamera(cameraUpdate);

        mGoogleMap.setMapType(com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL);

    }

    private void checkPermission() {
        Dexter.withContext(this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                //????????? ??????
                Toast.makeText(GoogleMap.this,"Permission Granted", Toast.LENGTH_SHORT).show();
                isPermissionGranted = true;
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                //?????? ?????? ?????? ??????
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                //???????????? ???????????????
                Uri uri = Uri.fromParts("package", getPackageName(), "");
                intent.setData(uri);
                startActivity(intent);
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                //?????? ??????
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(@NonNull com.google.android.gms.maps.GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.setMyLocationEnabled(true);

//        mGoogleMap.addMarker(new MarkerOptions()
//                .position(LatLng)
//                .title("Marker in Sydney"));

    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GPS_REQUSET_CODE){
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            boolean providerEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            if(providerEnable){
                Toast.makeText(this, "GPS is enable", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "GPS is not enable", Toast.LENGTH_SHORT).show();
            }
        }
    }

}