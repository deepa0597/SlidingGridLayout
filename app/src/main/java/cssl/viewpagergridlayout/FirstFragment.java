package cssl.viewpagergridlayout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment
{
    private ViewPager viewPager;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    public FirstFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView;
        rootView=inflater.inflate(R.layout.fragment_first, container, false);
        viewPager=(ViewPager)rootView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        return rootView;
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FirstScreen(),"Summary");
        adapter.addFragment(new SecondScreen(),"Earnings");
        viewPager.setAdapter(adapter);


    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mfragment=new ArrayList<>();
        private final List<String> fmtitle=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm)
        { super(fm); }

        @Override
        public Fragment getItem(int position)
        {  return mfragment.get(position);   }

        @Override
        public int getCount()
        {   return mfragment.size(); }

        public void addFragment(Fragment fragment, String title)
        {
            mfragment.add(fragment);
            fmtitle.add(title);
        }
        public CharSequence getPageTitle(int position) {
            return fmtitle.get(position);
        }
    }

}