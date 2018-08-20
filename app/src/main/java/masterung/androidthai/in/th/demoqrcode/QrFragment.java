package masterung.androidthai.in.th.demoqrcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrFragment extends Fragment implements ZXingScannerView.ResultHandler {

    private ZXingScannerView zXingScannerView;

    @Override
    public void onResume() {
        super.onResume();
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        zXingScannerView = new ZXingScannerView(getActivity());
        return zXingScannerView;
    }

    @Override
    public void handleResult(Result result) {

        String resultString = result.getText().toString().trim();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        getActivity().setResult(100, intent);
        getActivity().finish();

    }
}
