package com.android.findit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.android.findit.Helper.Constant;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Hanani on 24/4/2016.
 */
public class MapFragment extends Fragment implements LocationListener{

    private MapView mapView;
    private GoogleMap map;
    private Location mLastLocation;

    private TextInputLayout ilSearch;
    private EditText etSearch;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MapFragment newInstance(int sectionNumber) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putInt(Constant.ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public MapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.map_fragment, container, false);
        mapView = (MapView) rootView.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        ilSearch = (TextInputLayout) rootView.findViewById(R.id.ilSearch);
        etSearch = (EditText) rootView.findViewById(R.id.etSearch);

        //hide keyboard
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        setupMap();

        setupSearch();

        return rootView;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    /**
     * setup map view
     */
    private void setupMap(){
        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                return false;
            }
        });

        //check permission for location
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        map.setMyLocationEnabled(true);

        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        MapsInitializer.initialize(this.getActivity());

        // Updates the location and zoom of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(2.9234326,101.636846), 13);
        map.animateCamera(cameraUpdate);
    }

    /**
     * to enable a permission for location checking
     */
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * used if current location is changing
     * @param location
     */
    @Override
    public void onLocationChanged(Location location)
    {
        mLastLocation = location;
        //current location
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        //move map camera
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        map.animateCamera(CameraUpdateFactory.zoomTo(13));

//        if (mGoogleApiClient != null) {
//            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
//        }
    }

    /**
     * setup search on map
     */
    private void setupSearch() {
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String search = etSearch.getText().toString();
                    if (search.equals("masjid")||search.equals("mosque")||search.equals("surau")) {
                        ilSearch.setError(null);
                        map.clear();
                        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(2.9322861,101.6477198), 13);
                        map.animateCamera(cameraUpdate);
                        addMarker(new LatLng(2.9322861,101.6477198), "Masjid Raja Haji Fisabilillah");
                        addMarker(new LatLng(2.9243195,101.6430764), "Masjid MMU Cyber");
                    } else if (search.equals("atm")||search.equals("bank")||search.equals("cdm")) {
                        ilSearch.setError(null);
                        map.clear();
                        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(2.9255218,101.6419096), 13);
                        map.animateCamera(cameraUpdate);
                        addMarker(new LatLng(2.9255218,101.6419096), "CIMB ATM & CDM");
                        addMarker(new LatLng(2.9218074,101.6505248), "Dpulze ATMs");
                        addMarker(new LatLng(2.9211821,101.6560967), "CIMB Bank");
                        addMarker(new LatLng(2.921186, 101.655855), "Maybank");
                    } else {
                        map.clear();
                        ilSearch.setError("Not Found");
                    }
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * function to add marker on map
     * @param latLng
     * @param title
     */
    private void addMarker (LatLng latLng, String title){
        map.addMarker(new MarkerOptions().position(latLng)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).title(title));
    }
}
