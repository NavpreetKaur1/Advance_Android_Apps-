package riosorti.com.mapsheridan;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMapD;
    private GoogleMap mMapH;
    private GoogleMap mMapT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        mMapD = googleMap;
        mMapH = googleMap;
        mMapT = googleMap;

        LatLng davis = new LatLng(43.6560676, -79.7410584);
        LatLng hmc = new LatLng(43.5910195, -79.6489782);
        LatLng tra = new LatLng(43.4689298, -79.7021133);
        mMapD.addMarker(new MarkerOptions()
                .position(davis)
                .title("Davis Campus")
                .snippet("7899 McLaughlin Rd, Brampton, ON L6Y 5H9")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMapD.moveCamera(CameraUpdateFactory.newLatLng(davis));
        mMapH.addMarker(new MarkerOptions()
                .position(hmc)
                .title("HMC Campus")
                .snippet("4180 Duke of York Blvd, Mississauga, ON L5B 0G5")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMapH.moveCamera(CameraUpdateFactory.newLatLng(hmc));
        mMapT.addMarker(new MarkerOptions()
                .position(tra)
                .title("Trafalgar Campus")
                .snippet("1430 Trafalgar Rd, Oakville, ON L6H 2L1")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMapT.moveCamera(CameraUpdateFactory.newLatLng(tra));

        CircleOptions circleA = new CircleOptions()
                .center(hmc)
                .radius(15000)
                .strokeColor(Color.BLACK)
                .fillColor(0x30ff0000)
                .strokeWidth(8);

        Circle circle = mMapH.addCircle(circleA);



        //lines connecting

        PolygonOptions rectOptions = new PolygonOptions()
                .add(davis)
                .add(hmc)
                .add(tra);
        Polygon polyline = mMapD.addPolygon(rectOptions);
        CircleOptions abcd = new CircleOptions()
                .center(davis)
                .radius(1000)
                .strokeColor(Color.RED);
        Circle abc = mMapD.addCircle(abcd);

        googleMap.setTrafficEnabled(true);
    }
}
