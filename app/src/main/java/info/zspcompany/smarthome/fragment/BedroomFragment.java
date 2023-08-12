package info.zspcompany.smarthome.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import info.zspcompany.smarthome.R;
import info.zspcompany.smarthome.TcpClient.TcpSocket;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BedroomFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BedroomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BedroomFragment extends Fragment implements TcpSocket.TcpSocketEventListener {

    TcpSocket tcpSocket;
    boolean isConnected = false;
    Button wbb, wwb, wnb;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    public BedroomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BedroomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BedroomFragment newInstance(String param1, String param2) {
        BedroomFragment fragment = new BedroomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bedroom, container, false);

        wwb = (Button) view.findViewById(R.id.Bdsw2);
        wwb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Lamp On/Off", Toast.LENGTH_SHORT).show();
                tcpSocket.sendPacket("A");
            }
        });
        wbb = (Button) view.findViewById(R.id.Bdsw1);
        wbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Connect To Server", Toast.LENGTH_SHORT).show();
                toggleConnectionbedroom();
            }
        });
        wnb = (Button) view.findViewById(R.id.Bdsw3);
        wnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Lamp2 On/Off", Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }

    public void toggleConnectionbedroom() {
        if (!isConnected) {
            connect();
        } else {
            disconnect();
        }
    }

    private void enableCommandButtons(boolean enable) {
        wwb.setEnabled(enable);
        wnb.setEnabled(enable);

    }

    public void connect() {
        String hostAdddress = "192.168.1.104";
        String portString = "8080";
        tcpSocket = new TcpSocket(hostAdddress, Integer.valueOf(portString), this);
    }


    private void disconnect() {
        tcpSocket.disconnect();
        isConnected = false;
        wbb.setText("Connect");
        enableCommandButtons(false);
    }


    @Override
    public void onConnectionError(final TcpSocket.ConnectionErrorType connectionErrorType) {

    }

    @Override
    public void onSocketConnected() {

//        hostEditText.setEnabled(false);
//        portEditText.setEnabled(false);
        wbb.setText("Disconnect");
        enableCommandButtons(true);
        isConnected = true;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
