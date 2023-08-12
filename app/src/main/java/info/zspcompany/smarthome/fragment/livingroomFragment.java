package info.zspcompany.smarthome.fragment;

import info.zspcompany.smarthome.R;
import info.zspcompany.smarthome.TcpClient.Alert;
import info.zspcompany.smarthome.TcpClient.TcpSocket;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link livingroomFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link livingroomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class livingroomFragment extends Fragment implements TcpSocket.TcpSocketEventListener {

    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    Button connectionButton;

    EditText hostEditText;
    EditText portEditText;

    ProgressDialog connectionProgressDialog = null;

    TcpSocket tcpSocket;
    boolean isConnected = false;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public livingroomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment livingroomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static livingroomFragment newInstance(String param1, String param2) {
        livingroomFragment fragment = new livingroomFragment();
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
        View view = inflater.inflate(R.layout.fragment_livingroom, container, false);
        Alert.init(this);
        buttonA = (Button) view.findViewById(R.id.Lsw2);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpSocket.sendPacket("A");
            }
        });
        buttonB = (Button) view.findViewById(R.id.Lsw3);
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpSocket.sendPacket("B");
            }
        });
        buttonC = (Button) view.findViewById(R.id.Lsw4);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpSocket.sendPacket("C");
            }
        });
        buttonD = (Button) view.findViewById(R.id.Lsw5);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpSocket.sendPacket("D");
            }
        });
        connectionButton = (Button) view.findViewById(R.id.Lsw1);
        connectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleConnection();
            }
        });

//        hostEditText = (EditText) view.findViewById(R.id.host_editText);
//        portEditText = (EditText) view.findViewById(R.id.port_editText);

        return view;
    }

    public void toggleConnection() {
        if (!isConnected) {
            connect();
        } else {
            disconnect();
        }
    }

    public void connect() {
//        String hostAdddress = hostEditText.getText().toString();
//        String portString = portEditText.getText().toString();

        String hostAdddress = "192.168.1.104";
        String portString = "8080";


        tcpSocket = new TcpSocket(hostAdddress, Integer.valueOf(portString), this);
    }


    private void disconnect() {
        tcpSocket.disconnect();
//        hostEditText.setEnabled(true);
//        portEditText.setEnabled(true);
        enableCommandButtons(false);
        connectionButton.setText("Connect");
        isConnected = false;
    }

    private void enableCommandButtons(boolean enable) {
        buttonA.setEnabled(enable);
        buttonB.setEnabled(enable);
        buttonC.setEnabled(enable);
        buttonD.setEnabled(enable);
    }

    @Override
    public void onConnectionError(final TcpSocket.ConnectionErrorType connectionErrorType) {

    }

    @Override
    public void onSocketConnected() {

//        hostEditText.setEnabled(false);
//        portEditText.setEnabled(false);
        connectionButton.setText("Disconnect");
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
