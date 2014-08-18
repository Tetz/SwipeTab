package jp.aeriagames.tanuki;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfileFragment extends Fragment {

   public static final String ARG_SECTION_NUMBER = "section_number";

   public ProfileFragment(){
        // Do nothing
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);


        return rootView;
   }

}
