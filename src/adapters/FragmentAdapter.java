package adapters;

import hu.gyerob.oowhangeffekt.R;

import java.util.Locale;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import fragments.Fragment1;

public class FragmentAdapter extends FragmentPagerAdapter {

	Context context;
	
	public FragmentAdapter(FragmentManager fm, Context context) {
		super(fm);
		this.context = context;
	}

	@Override
	public Fragment getItem(int pos) {
		return Fragment1.newInstance(pos+1);
	}

	@Override
	public int getCount() {
		return 6;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return context.getString(R.string.title_section1).toUpperCase(l);
		case 1:
			return context.getString(R.string.title_section2).toUpperCase(l);
		case 2:
			return context.getString(R.string.title_section3).toUpperCase(l);
		case 3:
			return context.getString(R.string.title_section4).toUpperCase(l);
		case 4:
			return context.getString(R.string.title_section5).toUpperCase(l);
		case 5:
			return context.getString(R.string.title_section6).toUpperCase(l);
		}
		return null;
	}

}
