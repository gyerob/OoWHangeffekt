package adapters;

import hu.gyerob.oowhangeffekt.R;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import data.Adat;

public class GridAdapter extends ArrayAdapter<Adat> {

	private ArrayList<Adat> adat;
	private Context context;
	private int layoutResourceId;
	private MediaPlayer mPlayer;
	private int prevpos = -1;

	public GridAdapter(Context context, int resource, ArrayList<Adat> list) {
		super(context, resource, list);

		layoutResourceId = resource;
		this.context = context;
		adat = list;
		
		mPlayer = new MediaPlayer();

		Log.d("adapter konstruktor", "meghívva");
	}

	public class Viewholder {
		ImageView image;
		TextView text;
	}

	public void play(int pos) {
		if (mPlayer != null) {
			if(prevpos == pos) {
				if(mPlayer.isPlaying()) {
					mPlayer.stop();
				} else {
					mPlayer = MediaPlayer.create(context, adat.get(pos).id);
					mPlayer.start();
				}
			} else {
				if(mPlayer.isPlaying()) {
					mPlayer.stop();
					mPlayer = MediaPlayer.create(context, adat.get(pos).id);
					mPlayer.start();
				} else {
					mPlayer = MediaPlayer.create(context, adat.get(pos).id);
					mPlayer.start();
				}
			}
			
			prevpos = pos;
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Viewholder holder = null;

		Log.d("pos", Integer.toString(position));

		if (convertView == null) {
			holder = new Viewholder();
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			convertView = inflater.inflate(layoutResourceId, parent, false);
			holder.image = (ImageView) convertView.findViewById(R.id.rowimage);
			holder.text = (TextView) convertView.findViewById(R.id.rowtext);
			convertView.setTag(holder);
		} else {
			holder = (Viewholder) convertView.getTag();
		}

		holder.image.setImageResource(R.drawable.ic_launcher);
		holder.text.setText(adat.get(position).text);

		return convertView;
	}

}
