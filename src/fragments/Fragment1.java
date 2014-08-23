package fragments;

import hu.gyerob.oowhangeffekt.R;

import java.util.ArrayList;

import adapters.GridAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import data.Adat;

public class Fragment1 extends Fragment {

	private static String ARG_SECTION_NUMBER = "section number";
	private static int PAGE_NUM = 0;

	private GridAdapter adapter;
	private GridView gridview;
	private ImageView iv;

	ArrayList<Adat> list;

	public static Fragment1 newInstance(int page) {
		Fragment1 fragment = new Fragment1();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, page);
		fragment.setArguments(args);
		return fragment;
	}

	public Fragment1() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		PAGE_NUM = getArguments().getInt(ARG_SECTION_NUMBER);

		list = new ArrayList<Adat>();

		if (PAGE_NUM == 1) {
			// OoW
			list.add(new Adat(R.raw.gomba, "Gomba"));
			list.add(new Adat(R.raw.hatszel, "Hátszél"));
			list.add(new Adat(R.raw.korhaz, "Korház"));
			list.add(new Adat(R.raw.larenon, "Vau Vau"));
			list.add(new Adat(R.raw.persze, "Hát persze"));
		} else if (PAGE_NUM == 2) {
			// WoW
			list.add(new Adat(R.raw.badpull, "Bad pull"));
			list.add(new Adat(R.raw.dkp, "-50 dkp"));
			list.add(new Adat(R.raw.fckbliz, "Fckbliz"));
			list.add(new Adat(R.raw.handleit, "Handle it"));
			list.add(new Adat(R.raw.hithard, "Hit hard"));
			list.add(new Adat(R.raw.hitit, "Hit it"));
			list.add(new Adat(R.raw.leeroy, "Leeroy"));
			list.add(new Adat(R.raw.moredots1, "More dots 1"));
			list.add(new Adat(R.raw.moredots2, "More dots 2"));
			list.add(new Adat(R.raw.murloc, "Murloc"));
			list.add(new Adat(R.raw.prepared, "Prepared"));
			list.add(new Adat(R.raw.rouges, "Rouges"));
			list.add(new Adat(R.raw.runto, "Run to"));
		} else if (PAGE_NUM == 3) {
			// Játék
			list.add(new Adat(R.raw.flawless, "Flawless"));
			list.add(new Adat(R.raw.godlike, "Godlike"));
			list.add(new Adat(R.raw.hshit, "Holy shit"));
			list.add(new Adat(R.raw.hshot, "Headshot"));
			list.add(new Adat(R.raw.killingspree, "Killing spree"));
			list.add(new Adat(R.raw.monsterkill, "Monster kill"));
			list.add(new Adat(R.raw.rampage, "Rampage"));
			list.add(new Adat(R.raw.sgodlike, "Godlike"));
			list.add(new Adat(R.raw.ultrakill, "Ultrakill"));
			list.add(new Adat(R.raw.unstoppable, "Unstoppable"));
			list.add(new Adat(R.raw.xkill, "Multikill"));
			list.add(new Adat(R.raw.rabbids, "Rabbidz"));
			list.add(new Adat(R.raw.shepard, "Shepard"));
		} else if (PAGE_NUM == 4) {
			//tv
			list.add(new Adat(R.raw.bennyhill, "Benny Hill"));
			list.add(new Adat(R.raw.heman, "He-man"));
			list.add(new Adat(R.raw.hullak, "Hullák"));
			list.add(new Adat(R.raw.idiota, "Idióta"));
			list.add(new Adat(R.raw.inditjuk, "Indítjuk"));
			list.add(new Adat(R.raw.kenny, "Kenny"));
			list.add(new Adat(R.raw.matrix, "Mátrix"));
			list.add(new Adat(R.raw.megvagy, "Megvagy"));
			list.add(new Adat(R.raw.mkay, "Értem?"));
			list.add(new Adat(R.raw.olj, "Ölj"));
			list.add(new Adat(R.raw.pokmalac, "Pókmalac"));
			list.add(new Adat(R.raw.puska, "Puska"));
			list.add(new Adat(R.raw.thundercatsho, "Thundercats"));
			list.add(new Adat(R.raw.ticktack, "Ticktack"));
			list.add(new Adat(R.raw.wilhelm, "Wilhelm"));
		} else if (PAGE_NUM == 5) {
			//zene
			list.add(new Adat(R.raw.boldog, "Boldog"));
			list.add(new Adat(R.raw.jonarez, "Rézfaszú"));
			list.add(new Adat(R.raw.nicedress, "Nice dress"));
			list.add(new Adat(R.raw.rickastley, "Rickroll'd"));
			list.add(new Adat(R.raw.trollololol, "Trollololol"));
		} else if (PAGE_NUM == 6) {
			//egyéb
			list.add(new Adat(R.raw.badget, "Badget"));
			list.add(new Adat(R.raw.elkurtuk, "Elkúrtuk"));
			list.add(new Adat(R.raw.ikillyou, "I kill you"));
			list.add(new Adat(R.raw.keycat, "Keyboard cat"));
			list.add(new Adat(R.raw.lehugyoza, "Lehugyoz"));
			list.add(new Adat(R.raw.nem, "Nem"));
			list.add(new Adat(R.raw.swedishmeal, "Swedish Mealtime"));
			list.add(new Adat(R.raw.szokecigany, "Szõkecigány"));
			list.add(new Adat(R.raw.ufo, "Ufo"));
			list.add(new Adat(R.raw.vissza, "Visszamennyé"));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);

		adapter = new GridAdapter(getActivity(), R.layout.row, list);
		gridview = (GridView) view.findViewById(R.id.grid);
		gridview.setAdapter(adapter);

		iv = (ImageView) view.findViewById(R.id.bg);
		
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				((GridAdapter) parent.getAdapter()).play(position);
			}
		});

		return view;
	}
}
