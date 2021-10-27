package com.example.xlanguage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.util.Base64;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xlanguage.adapter.AdapterStatic;
import com.example.xlanguage.loading.loading;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextToSpeech texttoSpeech;
    ProgressBar barProggres;
    ScrollView setBackgroundMain;
    private static final int PICK_IMAGE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBackgroundMain = findViewById(R.id.background_main);
        SharedPreferences myPrefrence = getSharedPreferences("Image_DATA",MODE_PRIVATE);
        myPrefrence = getSharedPreferences("Image_DATA",MODE_PRIVATE);
       String imgB = myPrefrence.getString("imagePreferance","");
      Bitmap ps = decodeBase64(imgB);
      Drawable imgss = new BitmapDrawable(ps);
        setBackgroundMain.setBackground(imgss);
        RecycleViewFirst();
        RecycleViewTwo();
    }
    public void setBackground(){

    }
    public void RecycleViewFirst() {

        TextView levelId;
        Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        Animation shakeNew = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_item);
        AdapterStatic newAdapter;
        RecyclerView recone;
        barProggres = findViewById(R.id.levelBar);
        String tittleItem[], englishTextItem[], japanTextItem[];
        int firstRecycleImage[];
        tittleItem = getResources().getStringArray(R.array.one_tittle_rec_view);
        japanTextItem = getResources().getStringArray(R.array.one_japanese_alphabet);
        englishTextItem = getResources().getStringArray(R.array.one_japanese_text);
        //Home, School, Beach, Interaction, Farm
        firstRecycleImage = new int[]{
                R.drawable.home, R.drawable.schol, R.drawable.beach_icon, R.drawable.astrology, R.drawable.farm
        };
        String prefEdit[] = new String[]{
                "level_1", "level_2", "level_3", "level_4", "level_5"
        };
        String[] nameSharedPrefences = new String[]{
                "pref_1", "pref_2", "pref_3", "pref_4", "pref_5"
        };
        AdapterStatic staticAdapter;
        recone = findViewById(R.id.recone);


        AdapterStatic.adapterListener Listener;

        Listener = new AdapterStatic.adapterListener() {
            Intent intent;
            Context ctx;

            @Override
            public void onClick(View v, int position) {

                v.startAnimation(shakeNew);
                ctx = getApplicationContext();

                switch (position) {
                    case 0:
                        SharedPreferences getData;
                        getData = getSharedPreferences(nameSharedPrefences[0], Context.MODE_PRIVATE);
                        int levelsInt = getData.getInt(nameSharedPrefences[0], 0);
                        int subHome[] = new int[]{
                                R.drawable.armchair,
                                R.drawable.beds,
                                R.drawable.cloc,
                                R.drawable.computer,
                                R.drawable.cupboard,
                                R.drawable.door,
                                R.drawable.lamp,
                                R.drawable.painting,
                                R.drawable.refrigerator,
                                R.drawable.switch_icon,
                                R.drawable.table,
                                R.drawable.television,
                        };

                        String tittleHome[] = getResources().getStringArray(R.array.sub_homeEnglish);
                        String alphabetText[] = getResources().getStringArray(R.array.sub_home_alphabetText);
                        String nonAlphabetText[] = getResources().getStringArray(R.array.sub_home_nonAlphabetText);
                        intent = new Intent(ctx, loading.class);
                        String pref = nameSharedPrefences[0];
                        intent.putExtra("prefencesName", pref);
                        intent.putExtra("current_level", levelsInt);
                        intent.putExtra("imageData", subHome);
                        intent.putExtra("tittleData", tittleHome);
                        intent.putExtra("alphabetData", alphabetText);
                        intent.putExtra("nonalphabetData", nonAlphabetText);

                        startActivity(intent);
                        break;
                    case 1:
                        SharedPreferences getSchoolLevel;
                        getSchoolLevel = getSharedPreferences(nameSharedPrefences[1], Context.MODE_PRIVATE);
                        int levelSchool = getSchoolLevel.getInt(nameSharedPrefences[1], 2);
                        SharedPreferences getDataSchool;
                        getDataSchool = getSharedPreferences("position", Context.MODE_PRIVATE);

                        int subSchoolImage[] = new int[]{
                                R.drawable.biology,
                                R.drawable.book,
                                R.drawable.canteen,
                                R.drawable.chair,
                                R.drawable.chemistry,
                                R.drawable.clock,
                                R.drawable.color_pencil,
                                R.drawable.desk,
                                R.drawable.eraser,
                                R.drawable.increase,
                                R.drawable.laboratory,
                                R.drawable.laptop,
                                R.drawable.mathematics,
                                R.drawable.monitor,
                                R.drawable.paper,
                                R.drawable.parking_area,
                                R.drawable.pen,
                                R.drawable.pencil,
                                R.drawable.physic,
                                R.drawable.reading,
                                R.drawable.soccer_field,
                                R.drawable.teacher,
                                R.drawable.trash,
                                R.drawable.whiteboard,
                                R.drawable.window,
                                R.drawable.backpack,
                                R.drawable.canteen,
                                R.drawable.chair,
                                R.drawable.fan,
                                R.drawable.flourescent,
                                R.drawable.laptop,
                                R.drawable.locker,
                                R.drawable.pen,
                                R.drawable.reading,
                                R.drawable.restroom,
                                R.drawable.shirt,
                                R.drawable.sneakers,
                                R.drawable.table,
                                R.drawable.teacher,
                                R.drawable.trash,
                                R.drawable.trees,
                                R.drawable.whiteboard,
                                R.drawable.window,
                        };

                        String pref_two = nameSharedPrefences[1];
                        String englishSubHome[] = getResources().getStringArray(R.array.sub_schoolEnglish);
                        String alphabetSubSchool[] = getResources().getStringArray(R.array.sub_schoolAlphabet);
                        String nonAlphabetSubSchool[] = getResources().getStringArray(R.array.sub_SchoolNonAlphabet);
                        intent = new Intent(ctx, loading.class);
                        intent.putExtra("prefencesName", pref_two);
                        intent.putExtra("current_level", levelSchool);
                        intent.putExtra("imageData", subSchoolImage);
                        intent.putExtra("tittleData", englishSubHome);
                        intent.putExtra("alphabetData", alphabetSubSchool);
                        intent.putExtra("nonalphabetData", nonAlphabetSubSchool);
                        intent.putExtra("Level_current", levelSchool);
                        startActivity(intent);

                        break;
                    case 2:
                        SharedPreferences getDataBeach;
                        getDataBeach = getSharedPreferences(nameSharedPrefences[2], Context.MODE_PRIVATE);
                        int levelBeach = getDataBeach.getInt(nameSharedPrefences[2], 0);
                        int subBeach[] = new int[]{
                                R.drawable.ball,
                                R.drawable.boat,
                                R.drawable.crab,
                                R.drawable.fish,
                                R.drawable.palm,
                                R.drawable.sand,
                                R.drawable.sea,
                                R.drawable.stone,
                                R.drawable.sunrise,
                                R.drawable.sunset,
                                R.drawable.surfer,
                                R.drawable.towel,
                                R.drawable.wave,
                                R.drawable.wind,
                        };


                        String tittleBeach[] = getResources().getStringArray(R.array.subBeach_English_Text);
                        String alphabetBeach[] = getResources().getStringArray(R.array.subBeach_Alphabet_Text);
                        String nonAlphabetBeach[] = getResources().getStringArray(R.array.subBeach_NonAlphabet_Text);
                        intent = new Intent(ctx, loading.class);
                        String prefBeach = nameSharedPrefences[2];
                        intent.putExtra("prefencesName", prefBeach);
                        intent.putExtra("current_level", levelBeach);
                        intent.putExtra("imageData", subBeach);
                        intent.putExtra("tittleData", tittleBeach);
                        intent.putExtra("alphabetData", alphabetBeach);
                        intent.putExtra("nonalphabetData", nonAlphabetBeach);
                        startActivity(intent);

                        break;
                    case 3:
                        SharedPreferences gedDataAstronom;
                        gedDataAstronom = getSharedPreferences(nameSharedPrefences[3], Context.MODE_PRIVATE);
                        int levelAstronom = gedDataAstronom.getInt(nameSharedPrefences[3], 0);
                        int[] imageAstronom = new int[]{
                                R.drawable.alien,
                                R.drawable.aperture,
                                R.drawable.asterism,
                                R.drawable.asteroid,
                                R.drawable.astrology,
                                R.drawable.astronaut,
                                R.drawable.astronomer,
                                R.drawable.astronomic,
                                R.drawable.astronomy,
                                R.drawable.astrophysics,
                                R.drawable.azimuth,
                                R.drawable.big_bang,
                                R.drawable.binary_star,
                                R.drawable.black_body,
                                R.drawable.black_hole,
                                R.drawable.celestial,
                                R.drawable.cluster,
                                R.drawable.comet,
                                R.drawable.conjunction,
                                R.drawable.constellation,
                                R.drawable.corona,
                                R.drawable.cosmology,
                                R.drawable.cosmonaut,
                                R.drawable.cosmos,
                                R.drawable.crater,
                                R.drawable.crescent_moon,
                                R.drawable.day,
                                R.drawable.declination,
                                R.drawable.deep_space,
                                R.drawable.density,
                                R.drawable.docking,
                                R.drawable.double_star,
                                R.drawable.dust,
                                R.drawable.dwarf_planet,
                                R.drawable.earth,
                                R.drawable.eclipse,
                                R.drawable.exoplanet,
                                R.drawable.explode_stars,
                                R.drawable.falling_star,
                                R.drawable.flare,
                                R.drawable.free_fall,
                                R.drawable.full_moon,
                                R.drawable.galactic,
                                R.drawable.galaxy,
                                R.drawable.gamma_ray,
                                R.drawable.gibbous_moon,
                                R.drawable.gravitation,
                                R.drawable.gravity,
                                R.drawable.half_moon,
                                R.drawable.helium,
                                R.drawable.hubble_telescope,
                                R.drawable.hydrogen,
                                R.drawable.inclination,
                                R.drawable.inertia,
                                R.drawable.interstellar,
                                R.drawable.iss,
                                R.drawable.jupiter,
                                R.drawable.lens,
                                R.drawable.light,
                                R.drawable.light_sun,
                                R.drawable.local_group,
                                R.drawable.lunar,
                                R.drawable.lunar_eclipses,
                                R.drawable.magnitude,
                                R.drawable.mare,
                                R.drawable.mars,
                                R.drawable.mercury,
                                R.drawable.meteor,
                                R.drawable.meteorit,
                                R.drawable.meteorite,
                                R.drawable.meteoroid,
                                R.drawable.meteor_shower,
                                R.drawable.milky_way,
                                R.drawable.moon,
                                R.drawable.nasa,
                                R.drawable.natural_satellite,
                                R.drawable.natural_science,
                                R.drawable.nebula,
                                R.drawable.neptune,
                                R.drawable.neutron,
                                R.drawable.neutron_star,
                                R.drawable.neutron_stars,
                                R.drawable.new_moon,
                                R.drawable.north_star,
                                R.drawable.nova,
                                R.drawable.nuclear_fusion,
                                R.drawable.observatory,
                                R.drawable.occultation,
                                R.drawable.opposition,
                                R.drawable.orbit,
                                R.drawable.outer_planets,
                                R.drawable.parallax,
                                R.drawable.partial_eclipse,
                                R.drawable.phase,
                                R.drawable.physics,
                                R.drawable.planet,
                                R.drawable.pluto,
                                R.drawable.pole_star,
                                R.drawable.probe,
                                R.drawable.pulsar,
                                R.drawable.quarter_moon,
                                R.drawable.quasar,
                                R.drawable.radiant,
                                R.drawable.radiation,
                                R.drawable.radio_wave,
                                R.drawable.revolve,
                                R.drawable.rings,
                                R.drawable.rocket,
                                R.drawable.rocket_space_x,
                                R.drawable.satelite,
                                R.drawable.satellite,
                                R.drawable.saturn,
                                R.drawable.shooting_star,
                                R.drawable.sky,
                                R.drawable.solar,
                                R.drawable.solar_system,
                                R.drawable.solar_wind,
                                R.drawable.solstice,
                                R.drawable.space,
                                R.drawable.space_exploration,
                                R.drawable.space_ship,
                                R.drawable.space_station,
                                R.drawable.spectrum,
                                R.drawable.speed_of_light,
                                R.drawable.sputnik,
                                R.drawable.star,
                                R.drawable.starlight,
                                R.drawable.starry,
                                R.drawable.stars,
                                R.drawable.sun,
                                R.drawable.supernova,
                                R.drawable.telemetry,
                                R.drawable.telescope,
                                R.drawable.terminator,
                                R.drawable.terrestrial,
                                R.drawable.totality,
                                R.drawable.transit,
                                R.drawable.twinkling,
                                R.drawable.ufo,
                                R.drawable.universe,
                                R.drawable.vacuum,
                                R.drawable.venus,
                                R.drawable.waning,
                                R.drawable.wavelength,
                                R.drawable.waxing,
                                R.drawable.wormhole,
                                R.drawable.zenith,
                                R.drawable.zodiac,
                        };
                        String[] getEnglishAstronom = getResources().getStringArray(R.array.oneSubAstronomyEnglish);
                        String[] getAlphabetAstronom = getResources().getStringArray(R.array.oneSubAstronomyJapanese);
                        String[] getRomajiAstronom = getResources().getStringArray(R.array.oneSubAstronomyRomaji);
                        intent = new Intent(ctx, loading.class);
                        String prefAstronomy = nameSharedPrefences[3];
                        intent.putExtra("prefencesName", prefAstronomy);
                        intent.putExtra("current_level", levelAstronom);
                        intent.putExtra("imageData", imageAstronom);
                        intent.putExtra("tittleData", getEnglishAstronom);
                        intent.putExtra("alphabetData", getAlphabetAstronom);
                        intent.putExtra("nonalphabetData", getRomajiAstronom);
                        startActivity(intent);
                        break;
                    case 4:
                        SharedPreferences getDataFarm;
                        getDataFarm = getSharedPreferences(nameSharedPrefences[4], Context.MODE_PRIVATE);
                        int levelFarm = getDataFarm.getInt(nameSharedPrefences[4], 0);
                        int[] farmImage = new int[]{R.drawable.acreage,
                                R.drawable.agribusiness,
                                R.drawable.agricultural_college,
                                R.drawable.agricultural_development,
                                R.drawable.agricultural_industry,
                                R.drawable.agricultural_technique,
                                R.drawable.agriculture,
                                R.drawable.agriculture_land,
                                R.drawable.agriculturist,
                                R.drawable.agronomy,
                                R.drawable.animals,
                                R.drawable.axe,
                                R.drawable.b,
                                R.drawable.baler,
                                R.drawable.bale_of_hay,
                                R.drawable.bark,
                                R.drawable.barley,
                                R.drawable.barn,
                                R.drawable.bee,
                                R.drawable.beehive,
                                R.drawable.bison,
                                R.drawable.blade,
                                R.drawable.bloom,
                                R.drawable.boar,
                                R.drawable.branch,
                                R.drawable.breed,
                                R.drawable.bucket,
                                R.drawable.bud,
                                R.drawable.buffalo,
                                R.drawable.bull,
                                R.drawable.bush,
                                R.drawable.c,
                                R.drawable.calf,
                                R.drawable.camels,
                                R.drawable.cat,
                                R.drawable.chemical_fertilizer,
                                R.drawable.chick,
                                R.drawable.chicken,
                                R.drawable.clay,
                                R.drawable.combine,
                                R.drawable.coop,
                                R.drawable.corn,
                                R.drawable.cow,
                                R.drawable.cowshed,
                                R.drawable.crab,
                                R.drawable.crop,
                                R.drawable.crops,
                                R.drawable.crow,
                                R.drawable.cultivation,
                                R.drawable.cultivator,
                                R.drawable.d,
                                R.drawable.dairy,
                                R.drawable.debit,
                                R.drawable.deer,
                                R.drawable.dog,
                                R.drawable.donkey,
                                R.drawable.dove,
                                R.drawable.drake,
                                R.drawable.duck,
                                R.drawable.duckling,
                                R.drawable.e,
                                R.drawable.earth_worm,
                                R.drawable.egg,
                                R.drawable.ewe,
                                R.drawable.experimental_farm,
                                R.drawable.f,
                                R.drawable.fallow,
                                R.drawable.farm,
                                R.drawable.farmer,
                                R.drawable.farmhouse,
                                R.drawable.farming,
                                R.drawable.farm_community,
                                R.drawable.farm_house,
                                R.drawable.farm_land,
                                R.drawable.farm_worker,
                                R.drawable.feed,
                                R.drawable.fence,
                                R.drawable.fertile,
                                R.drawable.fertilize,
                                R.drawable.fertilizer,
                                R.drawable.field,
                                R.drawable.field_farm,
                                R.drawable.field_mouse,
                                R.drawable.fish,
                                R.drawable.flock,
                                R.drawable.flower_bud,
                                R.drawable.foal,
                                R.drawable.foliage,
                                R.drawable.food,
                                R.drawable.fruit,
                                R.drawable.fruit_tree,
                                R.drawable.g,
                                R.drawable.gander,
                                R.drawable.garden_fork,
                                R.drawable.gate,
                                R.drawable.geese,
                                R.drawable.goat,
                                R.drawable.goose,
                                R.drawable.grains,
                                R.drawable.green_house,
                                R.drawable.grow,
                                R.drawable.h,
                                R.drawable.hand_trowel,
                                R.drawable.harvest,
                                R.drawable.harvester,
                                R.drawable.harvest_moon,
                                R.drawable.harvest_time,
                                R.drawable.hay,
                                R.drawable.haystack,
                                R.drawable.hen,
                                R.drawable.herd,
                                R.drawable.hive,
                                R.drawable.hoe,
                                R.drawable.hog,
                                R.drawable.honey,
                                R.drawable.honeybee,
                                R.drawable.horse,
                                R.drawable.house_plant,
                                R.drawable.i,
                                R.drawable.incubator,
                                R.drawable.insecticide,
                                R.drawable.irrigation,
                                R.drawable.irrigation_system,
                                R.drawable.kid,
                                R.drawable.l,
                                R.drawable.lamb,
                                R.drawable.land,
                                R.drawable.lawn_mower,
                                R.drawable.llama,
                                R.drawable.llamas,
                                R.drawable.longhorn,
                                R.drawable.m,
                                R.drawable.machete,
                                R.drawable.mare,
                                R.drawable.meadow,
                                R.drawable.milk,
                                R.drawable.milling_machine,
                                R.drawable.mower,
                                R.drawable.mud_farm,
                                R.drawable.mulch,
                                R.drawable.mule,
                                R.drawable.o,
                                R.drawable.oats,
                                R.drawable.orchard,
                                R.drawable.ostriches,
                                R.drawable.ovary,
                                R.drawable.ox,
                                R.drawable.p,
                                R.drawable.paddy,
                                R.drawable.pail,
                                R.drawable.pasture,
                                R.drawable.pest,
                                R.drawable.petal,
                                R.drawable.pick,
                                R.drawable.pickaxe,
                                R.drawable.pig,
                                R.drawable.piglet,
                                R.drawable.plant,
                                R.drawable.plow,
                                R.drawable.poultry,
                                R.drawable.produce,
                                R.drawable.r,
                                R.drawable.rabbit,
                                R.drawable.rake,
                                R.drawable.ram,
                                R.drawable.ranch,
                                R.drawable.reap,
                                R.drawable.reindeer,
                                R.drawable.rice,
                                R.drawable.rice_field,
                                R.drawable.rice_mill,
                                R.drawable.ripe,
                                R.drawable.roost,
                                R.drawable.rooster,
                                R.drawable.root,
                                R.drawable.rye,
                                R.drawable.s,
                                R.drawable.scarecrow,
                                R.drawable.scythe,
                                R.drawable.seed,
                                R.drawable.seeding,
                                R.drawable.seeds,
                                R.drawable.shears,
                                R.drawable.sheep,
                                R.drawable.shepherd,
                                R.drawable.shovel,
                                R.drawable.shrimp,
                                R.drawable.sickle,
                                R.drawable.silo,
                                R.drawable.soil,
                                R.drawable.sow,
                                R.drawable.stable,
                                R.drawable.stallion,
                                R.drawable.steer,
                                R.drawable.stem,
                                R.drawable.stigma,
                                R.drawable.swine,
                                R.drawable.t,
                                R.drawable.tend,
                                R.drawable.till,
                                R.drawable.tiller,
                                R.drawable.tractor,
                                R.drawable.transplant,
                                R.drawable.tree,
                                R.drawable.trough,
                                R.drawable.trowel,
                                R.drawable.turkey,
                                R.drawable.twig,
                                R.drawable.udder,
                                R.drawable.vegetable,
                                R.drawable.w,
                                R.drawable.water,
                                R.drawable.weeder,
                                R.drawable.weeds,
                                R.drawable.wheat,
                                R.drawable.windmill,
                                R.drawable.wood,
                                R.drawable.yak,
                        };
                        String[] getEnglishFarm = getResources().getStringArray(R.array.subFarm_English_Text);
                        String[] getAlphabetFarm = getResources().getStringArray(R.array.subFarm_Alphabet_Text);
                        String[] getRomajiText = getResources().getStringArray(R.array.subFarm_NonAlphabet_Text);
                        intent = new Intent(ctx, loading.class);
                        String prefFarm = nameSharedPrefences[4];
                        intent.putExtra("prefencesName", prefFarm);
                        intent.putExtra("current_level", levelFarm);
                        intent.putExtra("imageData", farmImage);
                        intent.putExtra("tittleData", getEnglishFarm);
                        intent.putExtra("alphabetData", getAlphabetFarm);
                        intent.putExtra("nonalphabetData", getRomajiText);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        };
        LinearLayoutManager setHorizontal = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recone.setLayoutManager(setHorizontal);
        staticAdapter = new AdapterStatic(MainActivity.this, firstRecycleImage, tittleItem, englishTextItem, japanTextItem, Listener, nameSharedPrefences, prefEdit);
        recone.setAdapter(staticAdapter);


        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
       }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent getPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                getPhoto.setType("image/*");

                startActivityForResult(getPhoto,PICK_IMAGE);

                break;
            case R.id.item2:
                ImageView fluidTop;
                ImageView books;
                books = findViewById(R.id.imageView3);
                fluidTop = findViewById(R.id.fluidTop);
                books.setOnDragListener(new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int getAction = event.getAction();
                        switch (getAction){
                            case DragEvent.ACTION_DRAG_ENDED:
                                if(event.getResult()){
                                    fluidTop.setVisibility(View.INVISIBLE);
                                } else{
                                    fluidTop.setVisibility(View.VISIBLE);
                                }
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                fluidTop.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData clipdata = ClipData.newPlainText("","");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(fluidTop);
                        v.startDrag(clipdata,shadow,null,0);
                        return true;
                    }
                });
                break;
            case R.id.item3:
                break;
        }

        return super.onOptionsItemSelected(item);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data !=null && requestCode == PICK_IMAGE){
            Uri select_image = data.getData();
            try {

                SharedPreferences myPrefrence = getSharedPreferences("Image_DATA",MODE_PRIVATE);
                      Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), select_image);
                String imgBitmap = encodeTobase64(bitmap);
                SharedPreferences.Editor editor = myPrefrence.edit();
                editor.putString("namePreferance", "Image_DATA");
                editor.putString("imagePreferance", encodeTobase64(bitmap));
                editor.commit();
                Drawable dr = new BitmapDrawable(bitmap);
                setBackgroundMain.setBackground(dr);

            } catch (IOException e) {
                e.printStackTrace();

            }


        }
    }
    public static Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }
    public static String encodeTobase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }
    public void RecycleViewTwo(){
        String levelData[] = new String[]{
                "level_6", "level_7","level_8","level_9","level_10","level_11"
        };
        String[] nameSharedPrefences = new String[]{
                "pref_6","pref_7","pref_8","pref_9","pref_10","pref_11"
        };
        SharedPreferences getData;
        getData = getSharedPreferences("datalevel", Context.MODE_PRIVATE);
        TextView levelId;
        Animation shake = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake);
        Animation shakeNew = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake_item);
        AdapterStatic newAdapter;
        RecyclerView rectwo;
        barProggres = findViewById(R.id.levelBar);
        int levelsInt = getData.getInt("leveladd",0);

        String tittleItem[] , englishTextItem[] , japanTextItem[];
        int firstRecycleImage[];
        tittleItem = getResources().getStringArray(R.array.three_english_tittle);
        japanTextItem = getResources().getStringArray(R.array.three_japanese_alphabet);
        englishTextItem = getResources().getStringArray(R.array.three_japanese_text);
        firstRecycleImage = new int[]{
                R.drawable.trees, R.drawable.mountain, R.drawable.plants,R.drawable.rock, R.drawable.valley, R.drawable.fox
        };
        AdapterStatic staticAdapter;
        rectwo = findViewById(R.id.rectwo);


        AdapterStatic.adapterListener Listener;

        Listener = new AdapterStatic.adapterListener() {
            Intent intent;
            Context ctx;
            @Override
            public void onClick(View v, int position) {

                v.startAnimation(shakeNew);
                ctx = getApplicationContext();

                switch (position){
                    case 0:
                        SharedPreferences getDataTree;
                        getDataTree = getSharedPreferences(nameSharedPrefences[0], Context.MODE_PRIVATE);
                        int levelTree = getDataTree.getInt(nameSharedPrefences[0],0);
                        int[] imageTree = new int[]{R.drawable.banana_tree,
                            R.drawable.cedar,
                            R.drawable.cherry_tree,
                            R.drawable.coconut_tree,
                            R.drawable.fig_tree,
                            R.drawable.lime_tree,
                            R.drawable.loquat,
                            R.drawable.magnolia,
                            R.drawable.mahogany,
                            R.drawable.mangrove,
                            R.drawable.maple,
                            R.drawable.mimosa,
                            R.drawable.nectarine,
                            R.drawable.oak,
                            R.drawable.olive,
                            R.drawable.orange,
                            R.drawable.palm,
                            R.drawable.peach,
                            R.drawable.pear,
                            R.drawable.pecan,
                            R.drawable.persimmon,
                            R.drawable.pine,
                            R.drawable.pine_tree,
                            R.drawable.plum,
                            R.drawable.poplar,
                            R.drawable.poplar_tree,
                            R.drawable.quince,
                            R.drawable.rain_forest,
                            R.drawable.redwood,
                            R.drawable.rubber_tree,
                            R.drawable.sequoia,
                            R.drawable.spruce,
                            R.drawable.sugar_palm,
                            R.drawable.sycamore,
                            R.drawable.tree,
                            R.drawable.viburnum,
                            R.drawable.walnut,
                            R.drawable.weeping_willow,
                            R.drawable.willow,
                            R.drawable.yellowwood,
                            R.drawable.yew,
                            R.drawable.zelkova,
                    };
                        String[] getTreeEnglish = getResources().getStringArray(R.array.three_subTree_tittle);
                        String[] getTreeJapanese = getResources().getStringArray(R.array.three_subTree_japanese);
                        String[] getTreeRomaji = getResources().getStringArray(R.array.three_subTree_romaji);
                        intent = new Intent(ctx,loading.class);
                        String prefTree = nameSharedPrefences[0];
                        intent.putExtra("prefencesName",prefTree);
                        intent.putExtra("current_level",levelTree);
                        intent.putExtra("imageData",imageTree);
                        intent.putExtra("tittleData",getTreeEnglish);
                        intent.putExtra("alphabetData",getTreeJapanese);
                        intent.putExtra("nonalphabetData",getTreeRomaji);
                        startActivity(intent);
                        break;
                    case 1:
                        SharedPreferences getDataGeographic;
                        getDataGeographic = getSharedPreferences(nameSharedPrefences[1],Context.MODE_PRIVATE);
                        int levelGeographic = getDataGeographic.getInt(nameSharedPrefences[1],0);
                        int[] imageGeograpihc = new int[]{R.drawable.africa,
                                R.drawable.agriculture,
                                R.drawable.antarctica,
                                R.drawable.arctic,
                                R.drawable.arctic_circle,
                                R.drawable.area,
                                R.drawable.asia,
                                R.drawable.atlas,
                                R.drawable.atmosphere,
                                R.drawable.australia,
                                R.drawable.avalanche,
                                R.drawable.azimuth,
                                R.drawable.barn,
                                R.drawable.beach,
                                R.drawable.bog,
                                R.drawable.border,
                                R.drawable.bridge,
                                R.drawable.capital,
                                R.drawable.capital_city,
                                R.drawable.cartography,
                                R.drawable.chart,
                                R.drawable.city,
                                R.drawable.cliff,
                                R.drawable.continent,
                                R.drawable.country,
                                R.drawable.countryside,
                                R.drawable.crater,
                                R.drawable.crop,
                                R.drawable.desert,
                                R.drawable.earth,
                                R.drawable.earthquake,
                                R.drawable.east,
                                R.drawable.economy,
                                R.drawable.elevation,
                                R.drawable.energy,
                                R.drawable.environment,
                                R.drawable.equator,
                                R.drawable.erosion,
                                R.drawable.eruption,
                                R.drawable.europe,
                                R.drawable.famine,
                                R.drawable.farm,
                                R.drawable.farmhouse,
                                R.drawable.fence,
                                R.drawable.field,
                                R.drawable.forest,
                                R.drawable.fossil_fuel,
                                R.drawable.gate,
                                R.drawable.geography,
                                R.drawable.glacier,
                                R.drawable.global,
                                R.drawable.globe,
                                R.drawable.gps,
                                R.drawable.harbour,
                                R.drawable.harvest,
                                R.drawable.hay,
                                R.drawable.hedge,
                                R.drawable.hemisphere,
                                R.drawable.hill,
                                R.drawable.idl,
                                R.drawable.irrigation,
                                R.drawable.island,
                                R.drawable.jungle,
                                R.drawable.key,
                                R.drawable.kilometers,
                                R.drawable.land,
                                R.drawable.landform,
                                R.drawable.landscape,
                                R.drawable.landslide,
                                R.drawable.lava,
                                R.drawable.legend,
                                R.drawable.life_expectancy,
                                R.drawable.lighthouse,
                                R.drawable.literacy,
                                R.drawable.livestock,
                                R.drawable.longitude,
                                R.drawable.magnetic_pole,
                                R.drawable.malnutrition,
                                R.drawable.map,
                                R.drawable.map_projection,
                                R.drawable.meadow,
                                R.drawable.meridian,
                                R.drawable.migration,
                                R.drawable.miles,
                                R.drawable.moor,
                                R.drawable.mountain,
                                R.drawable.mountain_range,
                                R.drawable.nation,
                                R.drawable.national_park,
                                R.drawable.north,
                                R.drawable.northeast,
                                R.drawable.north_america,
                                R.drawable.north_magnetic_pole,
                                R.drawable.north_pole,
                                R.drawable.nuclear_energy,
                                R.drawable.ocean,
                                R.drawable.oil_rig,
                                R.drawable.parallel,
                                R.drawable.path,
                                R.drawable.peak,
                                R.drawable.peninsula,
                                R.drawable.pier,
                                R.drawable.plain,
                                R.drawable.pole,
                                R.drawable.political_map,
                                R.drawable.pollution,
                                R.drawable.population,
                                R.drawable.poverty,
                                R.drawable.projection,
                                R.drawable.radiation,
                                R.drawable.rainforest,
                                R.drawable.ratio,
                                R.drawable.region,
                                R.drawable.relief_map,
                                R.drawable.river,
                                R.drawable.rock,
                                R.drawable.rose,
                                R.drawable.rural,
                                R.drawable.sand_dune,
                                R.drawable.scale,
                                R.drawable.scale_bar,
                                R.drawable.sea,
                                R.drawable.sea_level,
                                R.drawable.slum,
                                R.drawable.south,
                                R.drawable.southeast,
                                R.drawable.southwest,
                                R.drawable.south_america,
                                R.drawable.south_pole,
                                R.drawable.street_map,
                                R.drawable.swamp,
                                R.drawable.territory,
                                R.drawable.tide,
                                R.drawable.time_zone,
                                R.drawable.topographic_map,
                                R.drawable.topography,
                                R.drawable.town,
                                R.drawable.to_harvest,
                                R.drawable.trade,
                                R.drawable.tributary,
                                R.drawable.tropics,
                                R.drawable.tsunami,
                                R.drawable.unemployment,
                                R.drawable.urban,
                                R.drawable.valley,
                                R.drawable.village,
                                R.drawable.volcano,
                                R.drawable.wall,
                                R.drawable.wave,
                                R.drawable.weather_map,
                                R.drawable.west,
                                R.drawable.wheat,
                                R.drawable.wood,
                                R.drawable.world,
                        };
                        String[] getGeographicEnglish = getResources().getStringArray(R.array.three_SubGeography_English);
                        String[] getGeographicJapanese = getResources().getStringArray(R.array.three_SubGeography_Japanese);
                        String[] getGeographicRomaji = getResources().getStringArray(R.array.three_SubGeography_Romaji);
                        intent = new Intent(ctx,loading.class);
                        String prefGeographic = nameSharedPrefences[1];
                        intent.putExtra("prefencesName",prefGeographic);
                        intent.putExtra("current_level",levelGeographic);
                        intent.putExtra("imageData",imageGeograpihc);
                        intent.putExtra("tittleData",getGeographicEnglish);
                        intent.putExtra("alphabetData",getGeographicJapanese);
                        intent.putExtra("nonalphabetData",getGeographicRomaji);
                        startActivity(intent);

                        break;
                    case 2:
                        SharedPreferences getDataPlant;
                        getDataPlant = getSharedPreferences(nameSharedPrefences[2],Context.MODE_PRIVATE);
                        int levelPlant = getDataPlant.getInt(nameSharedPrefences[2],0);
                        int[] imagePlant = new int[]{R.drawable.a,
                                R.drawable.accident,
                                R.drawable.adhesive,
                                R.drawable.afternoon,
                                R.drawable.agarwood,
                                R.drawable.alder,
                                R.drawable.aloe_vera,
                                R.drawable.arm,
                                R.drawable.artichoke,
                                R.drawable.asparagus,
                                R.drawable.aster,
                                R.drawable.b,
                                R.drawable.bamboo,
                                R.drawable.basil,
                                R.drawable.bean,
                                R.drawable.beetroot,
                                R.drawable.begonia,
                                R.drawable.blow_up,
                                R.drawable.bluebell,
                                R.drawable.bougainvillea,
                                R.drawable.brocolli,
                                R.drawable.burden,
                                R.drawable.c,
                                R.drawable.cabbage,
                                R.drawable.calabash,
                                R.drawable.calculating,
                                R.drawable.camellia,
                                R.drawable.camping,
                                R.drawable.canna,
                                R.drawable.cardamom,
                                R.drawable.carnation,
                                R.drawable.carrot,
                                R.drawable.cauliflower,
                                R.drawable.cayenne,
                                R.drawable.cedar,
                                R.drawable.celery,
                                R.drawable.cempedak,
                                R.drawable.cherry_blossom,
                                R.drawable.cherry_tree,
                                R.drawable.chestnut_tree,
                                R.drawable.chickpeas,
                                R.drawable.chilli,
                                R.drawable.china,
                                R.drawable.chives,
                                R.drawable.chrysanthemum,
                                R.drawable.clamp,
                                R.drawable.clams,
                                R.drawable.clove,
                                R.drawable.clover,
                                R.drawable.coffee_tree,
                                R.drawable.come_on,
                                R.drawable.conifer,
                                R.drawable.corn,
                                R.drawable.cross,
                                R.drawable.cumin,
                                R.drawable.d,
                                R.drawable.dahlia,
                                R.drawable.daisy,
                                R.drawable.dandelion,
                                R.drawable.e,
                                R.drawable.ebony,
                                R.drawable.edelweiss,
                                R.drawable.eggplant,
                                R.drawable.elm_tree,
                                R.drawable.events,
                                R.drawable.fern,
                                R.drawable.fig_tree,
                                R.drawable.finger_palm,
                                R.drawable.flowers,
                                R.drawable.g,
                                R.drawable.galangal,
                                R.drawable.gardenia,
                                R.drawable.garlic,
                                R.drawable.ginger,
                                R.drawable.gladiolus,
                                R.drawable.green_bean,
                                R.drawable.gude,
                                R.drawable.h,
                                R.drawable.henna_henna,
                                R.drawable.horrible,
                                R.drawable.hypnotic,
                                R.drawable.j,
                                R.drawable.jasmine,
                                R.drawable.k,
                                R.drawable.kailan,
                                R.drawable.l,
                                R.drawable.laughing,
                                R.drawable.lavender,
                                R.drawable.leek,
                                R.drawable.lily,
                                R.drawable.lime,
                                R.drawable.long_beans,
                                R.drawable.look_up,
                                R.drawable.m,
                                R.drawable.mahogany,
                                R.drawable.mango,
                                R.drawable.mangrove,
                                R.drawable.me,
                                R.drawable.melon,
                                R.drawable.mint_leaves,
                                R.drawable.mung_bean,
                                R.drawable.mushroom,
                                R.drawable.mustard_greens,
                                R.drawable.n,
                                R.drawable.noni,
                                R.drawable.nutmeg,
                                R.drawable.oak,
                                R.drawable.olive_tree,
                                R.drawable.onion,
                                R.drawable.orchid,
                                R.drawable.p,
                                R.drawable.padma,
                                R.drawable.palm_tree,
                                R.drawable.pea,
                                R.drawable.peanut,
                                R.drawable.pepper,
                                R.drawable.peppermint,
                                R.drawable.petunia,
                                R.drawable.pimping,
                                R.drawable.pine,
                                R.drawable.pistachio,
                                R.drawable.potatoes,
                                R.drawable.pumpkin,
                                R.drawable.raspberry,
                                R.drawable.reed,
                                R.drawable.remove,
                                R.drawable.rice,
                                R.drawable.rock,
                                R.drawable.rose,
                                R.drawable.roselle,
                                R.drawable.rosemary,
                                R.drawable.rubber,
                                R.drawable.sandpaper,
                                R.drawable.seaweed,
                                R.drawable.sesame,
                                R.drawable.shallots,
                                R.drawable.shampoo,
                                R.drawable.shrub,
                                R.drawable.spinach,
                                R.drawable.spring_onion,
                                R.drawable.squash,
                                R.drawable.step,
                                R.drawable.stick,
                                R.drawable.sticky_rice,
                                R.drawable.stone,
                                R.drawable.strawberry,
                                R.drawable.sugar_cane,
                                R.drawable.sugar_palm,
                                R.drawable.sunflower,
                                R.drawable.sweet_potatoes,
                                R.drawable.tamarind,
                                R.drawable.teak,
                                R.drawable.tea_tree,
                                R.drawable.thorns,
                                R.drawable.tomato,
                                R.drawable.tulip,
                                R.drawable.turmeric,
                                R.drawable.umbrella_leaves,
                                R.drawable.venus,
                                R.drawable.walnuts,
                                R.drawable.watercress,
                                R.drawable.waterlily,
                                R.drawable.watermelon,
                                R.drawable.water_hyacinth,
                                R.drawable.water_spinach,
                                R.drawable.willow,
                                R.drawable.words,
                                R.drawable.yellow,
                                R.drawable.zucchini,
                        };
                        String[] getEnglishPlant = getResources().getStringArray(R.array.three_sub_PlantEnglish);
                        String[] getJapanesePlant = getResources().getStringArray(R.array.three_Sub_PlantJapanese);
                        String[] getRomajiPlant = getResources().getStringArray(R.array.three_Sub_PlantRomaji);
                        intent = new Intent(ctx,loading.class);
                        String prefAstronomy = nameSharedPrefences[2];
                        intent.putExtra("prefencesName",prefAstronomy);
                        intent.putExtra("current_level",levelPlant);
                        intent.putExtra("imageData",imagePlant);
                        intent.putExtra("tittleData",getEnglishPlant);
                        intent.putExtra("alphabetData",getJapanesePlant);
                        intent.putExtra("nonalphabetData",getRomajiPlant);
                        startActivity(intent);
                        break;
                    case 3:
                        SharedPreferences getRockMineral;
                        getRockMineral = getSharedPreferences(nameSharedPrefences[3],Context.MODE_PRIVATE);
                        int levelRockMineral = getRockMineral.getInt(nameSharedPrefences[3],0);
                        int[] imgRockMineral = new int[]{
                                R.drawable.alexandrite,
                                R.drawable.amber,
                                R.drawable.amethyst,
                                R.drawable.aquamarine,
                                R.drawable.basalt,
                                R.drawable.carat,
                                R.drawable.citrine,
                                R.drawable.coal,
                                R.drawable.coral,
                                R.drawable.crystal,
                                R.drawable.density,
                                R.drawable.diamond,
                                R.drawable.emerald,
                                R.drawable.facet,
                                R.drawable.fossil,
                                R.drawable.garnet,
                                R.drawable.gem,
                                R.drawable.gemstone,
                                R.drawable.geode,
                                R.drawable.geology,
                                R.drawable.gold,
                                R.drawable.granite,
                                R.drawable.gravel,
                                R.drawable.gypsum,
                                R.drawable.hardness,
                                R.drawable.igneous_rock,
                                R.drawable.inclusion,
                                R.drawable.jade,
                                R.drawable.jet,
                                R.drawable.karat,
                                R.drawable.lava,
                                R.drawable.limestone,
                                R.drawable.luster,
                                R.drawable.magma,
                                R.drawable.meteoroid,
                                R.drawable.mineral,
                                R.drawable.obsidian,
                                R.drawable.opal,
                                R.drawable.pumice,
                                R.drawable.quartz,
                                R.drawable.rock,
                                R.drawable.rock_cycle,
                                R.drawable.rose_quartz,
                                R.drawable.ruby,
                                R.drawable.salt,
                                R.drawable.sand,
                                R.drawable.sandstone,
                                R.drawable.sapphire,
                                R.drawable.seismograph,
                                R.drawable.serpentine,
                                R.drawable.silt,
                                R.drawable.soapstone,
                                R.drawable.stalagmite,
                                R.drawable.stone,
                                R.drawable.talc,
                                R.drawable.tourmaline,
                                R.drawable.turquoise,
                                R.drawable.volcano,
                        };

                        String[] getEnglishRockMineral = getResources().getStringArray(R.array.three_SubMineralEnglish);
                        String[] getJapaneseRockMineral = getResources().getStringArray(R.array.three_SubMineralJapanese);
                        String[] getRomajiRockMineral = getResources().getStringArray(R.array.three_SubMineralJapanese);
                        intent = new Intent(ctx,loading.class);
                        String prefRockMineral = nameSharedPrefences[3];
                        intent.putExtra("prefencesName",prefRockMineral);
                        intent.putExtra("current_level",levelRockMineral);
                        intent.putExtra("imageData",imgRockMineral);
                        intent.putExtra("tittleData",getEnglishRockMineral);
                        intent.putExtra("alphabetData",getJapaneseRockMineral);
                        intent.putExtra("nonalphabetData",getRomajiRockMineral);
                        startActivity(intent);
                        break;
                    case 4:
                        SharedPreferences getDataNature;
                        getDataNature = getSharedPreferences(nameSharedPrefences[4],Context.MODE_PRIVATE);
                        int levelNature = getDataNature.getInt(nameSharedPrefences[4],0);
                        int[] imgNature = new int[]{R.drawable.abundant,
                            R.drawable.air,
                            R.drawable.algae,
                            R.drawable.altruism,
                            R.drawable.animal,
                            R.drawable.animalism,
                            R.drawable.animality,
                            R.drawable.animal_nature,
                            R.drawable.animism,
                            R.drawable.anthropology,
                            R.drawable.any,
                            R.drawable.ape,
                            R.drawable.approach,
                            R.drawable.aquatic,
                            R.drawable.aquifer,
                            R.drawable.archaea,
                            R.drawable.archipelago,
                            R.drawable.arctic,
                            R.drawable.array,
                            R.drawable.artifact,
                            R.drawable.aspect,
                            R.drawable.aspects,
                            R.drawable.atmosphere,
                            R.drawable.atypical,
                            R.drawable.autumn,
                            R.drawable.avatar,
                            R.drawable.awareness,
                            R.drawable.awesome,
                            R.drawable.bacteria,
                            R.drawable.bay,
                            R.drawable.beauty,
                            R.drawable.bees,
                            R.drawable.behavior,
                            R.drawable.beings,
                            R.drawable.belief,
                            R.drawable.benign,
                            R.drawable.benignant,
                            R.drawable.beyond,
                            R.drawable.bio,
                            R.drawable.biodegradable,
                            R.drawable.biodiversity,
                            R.drawable.biologic,
                            R.drawable.biological,
                            R.drawable.biologically,
                            R.drawable.biologist,
                            R.drawable.biology,
                            R.drawable.biosphere,
                            R.drawable.bird,
                            R.drawable.boulder,
                            R.drawable.bourgeois,
                            R.drawable.branch,
                            R.drawable.brilliant,
                            R.drawable.brook,
                            R.drawable.buoyancy,
                            R.drawable.bush,
                            R.drawable.buzz,
                            R.drawable.captivity,
                            R.drawable.carbon_dioxide,
                            R.drawable.cause,
                            R.drawable.celestial,
                            R.drawable.celestial_bodies,
                            R.drawable.character,
                            R.drawable.characteristic,
                            R.drawable.characteristically,
                            R.drawable.characteristics,
                            R.drawable.chemical_substance,
                            R.drawable.civilization,
                            R.drawable.cliff,
                            R.drawable.climate,
                            R.drawable.climate_change,
                            R.drawable.cloud,
                            R.drawable.clouds,
                            R.drawable.coastal,
                            R.drawable.color,
                            R.drawable.combustible,
                            R.drawable.comet,
                            R.drawable.commercial,
                            R.drawable.common,
                            R.drawable.commune,
                            R.drawable.complexion,
                            R.drawable.complexities,
                            R.drawable.complexity,
                            R.drawable.concept,
                            R.drawable.conflict,
                            R.drawable.conifer,
                            R.drawable.consciousness,
                            R.drawable.conservation,
                            R.drawable.considered,
                            R.drawable.context,
                            R.drawable.contexts,
                            R.drawable.continent,
                            R.drawable.contraries,
                            R.drawable.cosmography,
                            R.drawable.cosmos,
                            R.drawable.crater,
                            R.drawable.creating,
                            R.drawable.creation,
                            R.drawable.creature,
                            R.drawable.creatures,
                            R.drawable.critical,
                            R.drawable.crucial,
                            R.drawable.crust,
                            R.drawable.cultural,
                            R.drawable.culture,
                            R.drawable.current,
                            R.drawable.cyclone,
                            R.drawable.deformation,
                            R.drawable.deft,
                            R.drawable.demise,
                            R.drawable.deposition,
                            R.drawable.depression,
                            R.drawable.describe,
                            R.drawable.describing,
                            R.drawable.desert,
                            R.drawable.destructive,
                            R.drawable.destructiveness,
                            R.drawable.dichotomy,
                            R.drawable.dimensions,
                            R.drawable.dinosaur,
                            R.drawable.disposable,
                            R.drawable.distinctive,
                            R.drawable.dna,
                            R.drawable.duality,
                            R.drawable.dynamic,
                            R.drawable.dynamics,
                            R.drawable.earth,
                            R.drawable.earthquake,
                            R.drawable.earthy,
                            R.drawable.earth_materials,
                            R.drawable.eclipse,
                            R.drawable.eco,
                            R.drawable.ecological,
                            R.drawable.ecologist,
                            R.drawable.ecology,
                            R.drawable.ecoregion,
                            R.drawable.ecosystem,
                            R.drawable.ecosystems,
                            R.drawable.efficient,
                            R.drawable.embodiment,
                            R.drawable.endangered,
                            R.drawable.endemic,
                            R.drawable.energy,
                            R.drawable.entirely,
                            R.drawable.environment,
                            R.drawable.environmental,
                            R.drawable.ephemeral,
                            R.drawable.equator,
                            R.drawable.erosion,
                            R.drawable.essence,
                            R.drawable.ethic,
                            R.drawable.ethos,
                            R.drawable.evergreen,
                            R.drawable.evolution,
                            R.drawable.example,
                            R.drawable.examples,
                            R.drawable.exclusive,
                            R.drawable.existence,
                            R.drawable.exists,
                            R.drawable.experience,
                            R.drawable.experiences,
                            R.drawable.extension,
                            R.drawable.extremely,
                            R.drawable.fact,
                            R.drawable.fall,
                            R.drawable.fallow,
                            R.drawable.farming,
                            R.drawable.faunas,
                            R.drawable.fertile,
                            R.drawable.fierce,
                            R.drawable.fish,
                            R.drawable.flood,
                            R.drawable.flora,
                            R.drawable.flower,
                            R.drawable.fog,
                            R.drawable.foliage,
                            R.drawable.folklore,
                            R.drawable.forest,
                            R.drawable.form,
                            R.drawable.forms,
                            R.drawable.fragility,
                            R.drawable.freshwater,
                            R.drawable.fresh_water,
                            R.drawable.fungus,
                            R.drawable.gaia,
                            R.drawable.gas,
                            R.drawable.gaseous,
                            R.drawable.generic,
                            R.drawable.genesis,
                            R.drawable.genetics,
                            R.drawable.genotype,
                            R.drawable.genre,
                            R.drawable.genus,
                            R.drawable.geography,
                            R.drawable.geology,
                            R.drawable.glacier,
                            R.drawable.gorgeous,
                            R.drawable.gravity,
                            R.drawable.greenhouse_gas,
                            R.drawable.groundwater,
                            R.drawable.growth,
                            R.drawable.habitat,
                            R.drawable.hail,
                            R.drawable.harvard_university,
                            R.drawable.healthy,
                            R.drawable.hibernate,
                            R.drawable.highly,
                            R.drawable.historical,
                            R.drawable.horizon,
                            R.drawable.human,
                            R.drawable.humaneness,
                            R.drawable.humanoid,
                            R.drawable.hurricane,
                            R.drawable.hydrogen,
                            R.drawable.hydrology,
                            R.drawable.hygienic,
                            R.drawable.ice,
                            R.drawable.iceberg,
                            R.drawable.ice_age,
                            R.drawable.idea,
                            R.drawable.ideal,
                            R.drawable.ilk,
                            R.drawable.imitation,
                            R.drawable.immutable,
                            R.drawable.importance,
                            R.drawable.important,
                            R.drawable.inclinations,
                            R.drawable.indeed,
                            R.drawable.indigenous,
                            R.drawable.individual,
                            R.drawable.individuality,
                            R.drawable.insects,
                            R.drawable.intellectual,
                            R.drawable.intense,
                            R.drawable.intensely,
                            R.drawable.interesting,
                            R.drawable.interpretation,
                            R.drawable.interpretations,
                            R.drawable.intimate,
                            R.drawable.intrinsic,
                            R.drawable.intrusion,
                            R.drawable.is,
                            R.drawable.jungle,
                            R.drawable.juniper,
                            R.drawable.juxtaposition,
                            R.drawable.karyotype,
                            R.drawable.keen,
                            R.drawable.kind,
                            R.drawable.kindhearted,
                            R.drawable.knowledge,
                            R.drawable.lack,
                            R.drawable.lake,
                            R.drawable.land,
                            R.drawable.landform,
                            R.drawable.landscape,
                            R.drawable.landscapes,
                            R.drawable.latin,
                            R.drawable.lava,
                            R.drawable.leaf,
                            R.drawable.leaves,
                            R.drawable.lemur,
                            R.drawable.life,
                            R.drawable.liquid,
                            R.drawable.logging,
                            R.drawable.luxuriance,
                            R.drawable.magical,
                            R.drawable.magnetic_field,
                            R.drawable.magnificent,
                            R.drawable.mammal,
                            R.drawable.manifestations,
                            R.drawable.manner,
                            R.drawable.mantle,
                            R.drawable.marine,
                            R.drawable.materiality,
                            R.drawable.meaning,
                            R.drawable.meanings,
                            R.drawable.means,
                            R.drawable.medicine,
                            R.drawable.metaphor,
                            R.drawable.metaphysical,
                            R.drawable.meteor,
                            R.drawable.meteorology,
                            R.drawable.methane,
                            R.drawable.microbiology,
                            R.drawable.migratory,
                            R.drawable.milieu,
                            R.drawable.mimesis,
                            R.drawable.mind,
                            R.drawable.mining,
                            R.drawable.monkey,
                            R.drawable.moon,
                            R.drawable.moss,
                            R.drawable.most,
                            R.drawable.mountains,
                            R.drawable.mud,
                            R.drawable.mushroom,
                            R.drawable.mutability,
                            R.drawable.mutant,
                            R.drawable.mythology,
                            R.drawable.natipe_img,
                            R.drawable.natural,
                            R.drawable.naturalism,
                            R.drawable.naturalist,
                            R.drawable.naturally,
                            R.drawable.naturalness,
                            R.drawable.natural_environment,
                            R.drawable.natural_hazard,
                            R.drawable.natural_satellite,
                            R.drawable.nature,
                            R.drawable.natures,
                            R.drawable.naturism,
                            R.drawable.neglected,
                            R.drawable.neurobiology,
                            R.drawable.nitrogen,
                            R.drawable.nurture,
                            R.drawable.ocean,
                            R.drawable.oceanography,
                            R.drawable.ocean_current,
                            R.drawable.often,
                            R.drawable.organism,
                            R.drawable.organisms,
                            R.drawable.original,
                            R.drawable.origins,
                            R.drawable.overly,
                            R.drawable.oxygen,
                            R.drawable.ozone_layer,
                            R.drawable.paleontology,
                            R.drawable.pangaea,
                            R.drawable.paradoxes,
                            R.drawable.parasitic,
                            R.drawable.parks,
                            R.drawable.particular,
                            R.drawable.path,
                            R.drawable.peaceful,
                            R.drawable.peaks,
                            R.drawable.peculiarities,
                            R.drawable.peculiarity,
                            R.drawable.perfectness,
                            R.drawable.personal,
                            R.drawable.personality,
                            R.drawable.perspective,
                            R.drawable.petroleum_geology,
                            R.drawable.phenomena,
                            R.drawable.physical,
                            R.drawable.physics,
                            R.drawable.physis,
                            R.drawable.pinnacle,
                            R.drawable.planet,
                            R.drawable.plant,
                            R.drawable.plants,
                            R.drawable.plate_tectonics,
                            R.drawable.playful,
                            R.drawable.polar_climate,
                            R.drawable.polecat,
                            R.drawable.pollutant,
                            R.drawable.pond,
                            R.drawable.popular,
                            R.drawable.practical,
                            R.drawable.prairie,
                            R.drawable.precipitation,
                            R.drawable.predator,
                            R.drawable.preservation,
                            R.drawable.primate,
                            R.drawable.pristine,
                            R.drawable.productive,
                            R.drawable.protection,
                            R.drawable.protist,
                            R.drawable.prototypical,
                            R.drawable.psychological,
                            R.drawable.psychology,
                            R.drawable.purely,
                            R.drawable.purpose,
                            R.drawable.quality,
                            R.drawable.quiet,
                            R.drawable.quite,
                            R.drawable.radioactive,
                            R.drawable.rain,
                            R.drawable.range,
                            R.drawable.rare,
                            R.drawable.realities,
                            R.drawable.reality,
                            R.drawable.recreation,
                            R.drawable.refers,
                            R.drawable.regard,
                            R.drawable.relation,
                            R.drawable.remoteness,
                            R.drawable.renewable,
                            R.drawable.representation,
                            R.drawable.reproductive,
                            R.drawable.reserve,
                            R.drawable.resilient,
                            R.drawable.resources,
                            R.drawable.restorative,
                            R.drawable.ridge,
                            R.drawable.riparian,
                            R.drawable.river,
                            R.drawable.rock,
                            R.drawable.safe,
                            R.drawable.salinity,
                            R.drawable.sanctuary,
                            R.drawable.sand,
                            R.drawable.sane,
                            R.drawable.scenery,
                            R.drawable.scenic,
                            R.drawable.science,
                            R.drawable.scientific_method,
                            R.drawable.scientist,
                            R.drawable.scope,
                            R.drawable.sea,
                            R.drawable.season,
                            R.drawable.seasons,
                            R.drawable.seawater,
                            R.drawable.sediment,
                            R.drawable.sense,
                            R.drawable.serene,
                            R.drawable.serenity,
                            R.drawable.seriousness,
                            R.drawable.shelter,
                            R.drawable.shore,
                            R.drawable.shrubs,
                            R.drawable.sill,
                            R.drawable.similar,
                            R.drawable.sky,
                            R.drawable.sleet,
                            R.drawable.smells,
                            R.drawable.snow,
                            R.drawable.sociality,
                            R.drawable.sociology,
                            R.drawable.soil,
                            R.drawable.solar,
                            R.drawable.solar_system,
                            R.drawable.solar_time,
                            R.drawable.solar_wind,
                            R.drawable.solid,
                            R.drawable.soluble,
                            R.drawable.sort,
                            R.drawable.sounds,
                            R.drawable.spatial,
                            R.drawable.specie,
                            R.drawable.species,
                            R.drawable.spring,
                            R.drawable.stars,
                            R.drawable.steam,
                            R.drawable.stream,
                            R.drawable.stunning,
                            R.drawable.subject,
                            R.drawable.subjective,
                            R.drawable.suggests,
                            R.drawable.summer,
                            R.drawable.sun,
                            R.drawable.sunshine,
                            R.drawable.supernatural,
                            R.drawable.surroundings,
                            R.drawable.symbiosis,
                            R.drawable.systematics,
                            R.drawable.taxonomy,
                            R.drawable.tectonic_plate,
                            R.drawable.temperament,
                            R.drawable.temperaments,
                            R.drawable.temperature,
                            R.drawable.tendencies,
                            R.drawable.terra,
                            R.drawable.terrain,
                            R.drawable.terrestrial_planet,
                            R.drawable.these,
                            R.drawable.this_img,
                            R.drawable.tide,
                            R.drawable.topography,
                            R.drawable.tornado,
                            R.drawable.toxic,
                            R.drawable.trait,
                            R.drawable.trees,
                            R.drawable.tropical,
                            R.drawable.tropical_climate,
                            R.drawable.img_true,
                            R.drawable.truly,
                            R.drawable.tsunami,
                            R.drawable.type,
                            R.drawable.typical,
                            R.drawable.ultimate,
                            R.drawable.ultraviolet,
                            R.drawable.uncommon,
                            R.drawable.understanding,
                            R.drawable.undeveloped,
                            R.drawable.unique,
                            R.drawable.uniqueness,
                            R.drawable.universals,
                            R.drawable.universe,
                            R.drawable.unpredictable,
                            R.drawable.uplifting,
                            R.drawable.useful,
                            R.drawable.value,
                            R.drawable.vapor,
                            R.drawable.variety,
                            R.drawable.versatile,
                            R.drawable.very,
                            R.drawable.view,
                            R.drawable.vigilant,
                            R.drawable.visible,
                            R.drawable.vista,
                            R.drawable.volcanic_rock,
                            R.drawable.volcano,
                            R.drawable.vulnerable,
                            R.drawable.warmth,
                            R.drawable.watercourse,
                            R.drawable.waterfall,
                            R.drawable.wave,
                            R.drawable.ways,
                            R.drawable.weather,
                            R.drawable.wild,
                            R.drawable.wildlife,
                            R.drawable.wildness,
                            R.drawable.winter,
                            R.drawable.world,
                            R.drawable.worldwide,
                            R.drawable.world_ocean,
                            R.drawable.world_population,
                            R.drawable.yielding,
                            R.drawable.zoo,
                            R.drawable.zoology,
                    };
                        String[] getNatureEnglish = getResources().getStringArray(R.array.three_sub_NatureEnglish);
                        String[] getNatureJapan = getResources().getStringArray(R.array.three_subNatureJapanese);
                        String[] getNatureRomaji = getResources().getStringArray(R.array.three_subNatureRomaji);
                        intent = new Intent(ctx,loading.class);
                        String prefNature = nameSharedPrefences[4];
                        intent.putExtra("prefencesName",prefNature);
                        intent.putExtra("current_level",levelNature);
                        intent.putExtra("imageData",imgNature);
                        intent.putExtra("tittleData",getNatureEnglish);
                        intent.putExtra("alphabetData",getNatureJapan);
                        intent.putExtra("nonalphabetData",getNatureRomaji);
                        startActivity(intent);
                        break;
                    case 5:
                        SharedPreferences getDataAnimal;
                        getDataAnimal = getSharedPreferences(nameSharedPrefences[5], Context.MODE_PRIVATE);
                        int levelAnimal = getDataAnimal.getInt(nameSharedPrefences[5],0);

                        int[] imageAnimal=new int[]{
                        R.drawable.abalone,
                                R.drawable.african_elephant,
                                R.drawable.albatross,
                                R.drawable.algae,
                                R.drawable.alligator,
                                R.drawable.alpaca,
                                R.drawable.american_bison,
                                R.drawable.amoeba,
                                R.drawable.amphibian,
                                R.drawable.amphibians,
                                R.drawable.anaconda,
                                R.drawable.angelfish,
                                R.drawable.animal,
                                R.drawable.ant,
                                R.drawable.anteater,
                                R.drawable.antelope,
                                R.drawable.apatosaurus,
                                R.drawable.ape,
                                R.drawable.aphid,
                                R.drawable.arachnid,
                                R.drawable.arachnids,
                                R.drawable.arctic_fox,
                                R.drawable.arctic_tern,
                                R.drawable.arctic_wolf,
                                R.drawable.armadillo,
                                R.drawable.arthropod,
                                R.drawable.asp,
                                R.drawable.baboon,
                                R.drawable.badger,
                                R.drawable.bald_eagle,
                                R.drawable.barbel,
                                R.drawable.basilisk,
                                R.drawable.bat,
                                R.drawable.beagle,
                                R.drawable.bear,
                                R.drawable.bearded_dragon,
                                R.drawable.beaver,
                                R.drawable.bed_bug,
                                R.drawable.bee,
                                R.drawable.beetle,
                                R.drawable.beluga_whale,
                                R.drawable.bichon_frise,
                                R.drawable.bighorn_sheep,
                                R.drawable.bird,
                                R.drawable.birds,
                                R.drawable.bison,
                                R.drawable.bivalve,
                                R.drawable.blackbird,
                                R.drawable.black_bear,
                                R.drawable.black_swan,
                                R.drawable.blowfish,
                                R.drawable.blue_jay,
                                R.drawable.blue_whale,
                                R.drawable.boa,
                                R.drawable.bobcat,
                                R.drawable.bongo,
                                R.drawable.border_collie,
                                R.drawable.boston_terrier,
                                R.drawable.bowhead_whale,
                                R.drawable.boxer,
                                R.drawable.box_turtle,
                                R.drawable.brown_bear,
                                R.drawable.buffalo,
                                R.drawable.bug,
                                R.drawable.bull,
                                R.drawable.bulldog,
                                R.drawable.bullock,
                                R.drawable.bull_shark,
                                R.drawable.buzzard,
                                R.drawable.caiman,
                                R.drawable.calf,
                                R.drawable.camel,
                                R.drawable.canada_goose,
                                R.drawable.canary,
                                R.drawable.caracal,
                                R.drawable.cardinal,
                                R.drawable.caribou,
                                R.drawable.carp,
                                R.drawable.cat,
                                R.drawable.caterpillar,
                                R.drawable.cavy,
                                R.drawable.centipede,
                                R.drawable.chameleon,
                                R.drawable.cheetah,
                                R.drawable.chick,
                                R.drawable.chickadee,
                                R.drawable.chicken,
                                R.drawable.chihuahua,
                                R.drawable.chimpanzee,
                                R.drawable.chinchilla,
                                R.drawable.chipmunk,
                                R.drawable.chrysalis,
                                R.drawable.cicada,
                                R.drawable.clam,
                                R.drawable.clownfish,
                                R.drawable.coati,
                                R.drawable.cobra,
                                R.drawable.cockroach,
                                R.drawable.cod,
                                R.drawable.collie,
                                R.drawable.conch,
                                R.drawable.condor,
                                R.drawable.coral,
                                R.drawable.cormorant,
                                R.drawable.cougar,
                                R.drawable.cow,
                                R.drawable.coyote,
                                R.drawable.crab,
                                R.drawable.crane,
                                R.drawable.crayfish,
                                R.drawable.cricket,
                                R.drawable.crocodile,
                                R.drawable.crow,
                                R.drawable.crustacean,
                                R.drawable.cuckoo,
                                R.drawable.dachshund,
                                R.drawable.dalmatian,
                                R.drawable.damselfly,
                                R.drawable.deer,
                                R.drawable.desert_tortoise,
                                R.drawable.diatom,
                                R.drawable.dilophosaurus,
                                R.drawable.dingo,
                                R.drawable.dinosaur,
                                R.drawable.diplodocus,
                                R.drawable.dog,
                                R.drawable.dolphin,
                                R.drawable.donkey,
                                R.drawable.dory,
                                R.drawable.dove,
                                R.drawable.dragonfly,
                                R.drawable.drake,
                                R.drawable.dromedary,
                                R.drawable.duck,
                                R.drawable.duckling,
                                R.drawable.dugong,
                                R.drawable.dung_beetle,
                                R.drawable.eagle,
                                R.drawable.earthworm,
                                R.drawable.earwig,
                                R.drawable.echidna,
                                R.drawable.echinoderms,
                                R.drawable.eel,
                                R.drawable.egg,
                                R.drawable.egret,
                                R.drawable.elasmosaurus,
                                R.drawable.electric_eel,
                                R.drawable.elephant,
                                R.drawable.elk,
                                R.drawable.emu,
                                R.drawable.ermine,
                                R.drawable.extinct_animals,
                                R.drawable.falcon,
                                R.drawable.farm_animals,
                                R.drawable.fennec_fox,
                                R.drawable.ferret,
                                R.drawable.fiddler_crab,
                                R.drawable.finch,
                                R.drawable.fin_whale,
                                R.drawable.firefly,
                                R.drawable.fish,
                                R.drawable.fishes_and_marine_animals,
                                R.drawable.flamingo,
                                R.drawable.flatworm,
                                R.drawable.flea,
                                R.drawable.flightless_birds,
                                R.drawable.flounder,
                                R.drawable.fly,
                                R.drawable.flying_fish,
                                R.drawable.flying_squirrel,
                                R.drawable.fowl,
                                R.drawable.fox,
                                R.drawable.frog,
                                R.drawable.fruit_fly,
                                R.drawable.fugu,
                                R.drawable.gander,
                                R.drawable.gar,
                                R.drawable.gazelle,
                                R.drawable.gecko,
                                R.drawable.gerbil,
                                R.drawable.german_shepherd,
                                R.drawable.gibbon,
                                R.drawable.gila_monster,
                                R.drawable.giraffe,
                                R.drawable.gnat,
                                R.drawable.gnu,
                                R.drawable.goat,
                                R.drawable.golden_eagle,
                                R.drawable.golden_retriever,
                                R.drawable.goldfish,
                                R.drawable.goose,
                                R.drawable.gorilla,
                                R.drawable.gosling,
                                R.drawable.great_dane,
                                R.drawable.great_white_shark,
                                R.drawable.greenland_shark,
                                R.drawable.green_iguana,
                                R.drawable.green_snake,
                                R.drawable.greyhound,
                                R.drawable.grizzly_bear,
                                R.drawable.groundhog,
                                R.drawable.grouse,
                                R.drawable.grub,
                                R.drawable.guinea_pig,
                                R.drawable.gull,
                                R.drawable.halibut,
                                R.drawable.hammerhead_shark,
                                R.drawable.hamster,
                                R.drawable.hare,
                                R.drawable.harpy_eagle,
                                R.drawable.hawk,
                                R.drawable.hedgehog,
                                R.drawable.hen,
                                R.drawable.hermit_crab,
                                R.drawable.heron,
                                R.drawable.herring,
                                R.drawable.hippo,
                                R.drawable.hippopotamus,
                                R.drawable.honey_bee,
                                R.drawable.hornet,
                                R.drawable.horse,
                                R.drawable.horseshoe_crab,
                                R.drawable.hound,
                                R.drawable.house_fly,
                                R.drawable.human_being,
                                R.drawable.hummingbird,
                                R.drawable.humpback_whale,
                                R.drawable.husky,
                                R.drawable.hyena,
                                R.drawable.ibis,
                                R.drawable.ichthyosaurus,
                                R.drawable.iguana,
                                R.drawable.iguanodon,
                                R.drawable.impala,
                                R.drawable.indian_elephant,
                                R.drawable.insect,
                                R.drawable.insects,
                                R.drawable.invertebrates,
                                R.drawable.jackdaw,
                                R.drawable.jack_russell_terrier,
                                R.drawable.jaguar,
                                R.drawable.japanese_crane,
                                R.drawable.jay,
                                R.drawable.jellyfish,
                                R.drawable.jerboa,
                                R.drawable.joey,
                                R.drawable.john_dory,
                                R.drawable.kakapo,
                                R.drawable.kangaroo,
                                R.drawable.katydid,
                                R.drawable.kentrosaurus,
                                R.drawable.killer_whale,
                                R.drawable.king_cobra,
                                R.drawable.king_crab,
                                R.drawable.kiwi,
                                R.drawable.koala,
                                R.drawable.krill,
                                R.drawable.kronosaurus,
                                R.drawable.kudu,
                                R.drawable.labrador_retriever,
                                R.drawable.ladybug,
                                R.drawable.lamb,
                                R.drawable.larva,
                                R.drawable.leech,
                                R.drawable.lemming,
                                R.drawable.lemur,
                                R.drawable.leopard,
                                R.drawable.lice,
                                R.drawable.lightning_bug,
                                R.drawable.limpet,
                                R.drawable.lion,
                                R.drawable.lizard,
                                R.drawable.llama,
                                R.drawable.lobster,
                                R.drawable.locust,
                                R.drawable.longhorn,
                                R.drawable.loon,
                                R.drawable.louse,
                                R.drawable.lynx,
                                R.drawable.macaque,
                                R.drawable.macaw,
                                R.drawable.mackerel,
                                R.drawable.maggot,
                                R.drawable.mallard,
                                R.drawable.mamba,
                                R.drawable.mammal,
                                R.drawable.mammals,
                                R.drawable.mammoth,
                                R.drawable.manatee,
                                R.drawable.mandrill,
                                R.drawable.manta_ray,
                                R.drawable.mantis,
                                R.drawable.marine_mammals,
                                R.drawable.marmoset,
                                R.drawable.marsupial,
                                R.drawable.mastiff,
                                R.drawable.mastodon,
                                R.drawable.mealworm,
                                R.drawable.meerkat,
                                R.drawable.megalodon,
                                R.drawable.mice,
                                R.drawable.midge,
                                R.drawable.migrate,
                                R.drawable.mink,
                                R.drawable.mockingbird,
                                R.drawable.mole,
                                R.drawable.mollusk,
                                R.drawable.mongoose,
                                R.drawable.monkey,
                                R.drawable.moose,
                                R.drawable.moray_eel,
                                R.drawable.mosquito,
                                R.drawable.moth,
                                R.drawable.mountain_lion,
                                R.drawable.mouse,
                                R.drawable.mule,
                                R.drawable.muskrat,
                                R.drawable.mussels,
                                R.drawable.nandu,
                                R.drawable.narwhal,
                                R.drawable.nautilus,
                                R.drawable.nene,
                                R.drawable.nest,
                                R.drawable.newt,
                                R.drawable.nightingale,
                                R.drawable.northern_cardinal,
                                R.drawable.nuthatch,
                                R.drawable.nymph,
                                R.drawable.ocelot,
                                R.drawable.octopus,
                                R.drawable.old_english_sheepdog,
                                R.drawable.orangutan,
                                R.drawable.orca,
                                R.drawable.oryx,
                                R.drawable.ostrich,
                                R.drawable.owl,
                                R.drawable.ox,
                                R.drawable.oyster,
                                R.drawable.panda,
                                R.drawable.pangolin,
                                R.drawable.panther,
                                R.drawable.parakeet,
                                R.drawable.parrot,
                                R.drawable.partridge,
                                R.drawable.pekingese,
                                R.drawable.pelican,
                                R.drawable.penguin,
                                R.drawable.perch,
                                R.drawable.petrel,
                                R.drawable.pheasant,
                                R.drawable.pig,
                                R.drawable.pigeon,
                                R.drawable.pika,
                                R.drawable.pike,
                                R.drawable.pill_bug,
                                R.drawable.piranha,
                                R.drawable.platypus,
                                R.drawable.plover,
                                R.drawable.polar_bear,
                                R.drawable.polecat,
                                R.drawable.pomeranian,
                                R.drawable.pond_skater,
                                R.drawable.pony,
                                R.drawable.poodle,
                                R.drawable.porcupine,
                                R.drawable.porpoise,
                                R.drawable.prairie_dog,
                                R.drawable.praying_mantis,
                                R.drawable.primates,
                                R.drawable.ptarmigan,
                                R.drawable.pufferfish,
                                R.drawable.puffin,
                                R.drawable.pug,
                                R.drawable.puma,
                                R.drawable.puppy,
                                R.drawable.python,
                                R.drawable.quail,
                                R.drawable.quetzal,
                                R.drawable.quokka,
                                R.drawable.rabbit,
                                R.drawable.rat,
                                R.drawable.raven,
                                R.drawable.ray,
                                R.drawable.red_panda,
                                R.drawable.red_wolf,
                                R.drawable.reindeer,
                                R.drawable.reptile,
                                R.drawable.reptiles,
                                R.drawable.rhea,
                                R.drawable.rhino,
                                R.drawable.rhinoceros,
                                R.drawable.roach,
                                R.drawable.roadrunner,
                                R.drawable.robin,
                                R.drawable.rodent,
                                R.drawable.rooster,
                                R.drawable.roundworm,
                                R.drawable.sailfish,
                                R.drawable.salamander,
                                R.drawable.salmon,
                                R.drawable.sand_dollar,
                                R.drawable.sardine,
                                R.drawable.scallop,
                                R.drawable.scorpion,
                                R.drawable.seagull,
                                R.drawable.seahorse,
                                R.drawable.seal,
                                R.drawable.sealion,
                                R.drawable.sea_anemone,
                                R.drawable.sea_cow,
                                R.drawable.sea_snake,
                                R.drawable.sea_star,
                                R.drawable.sea_turtle,
                                R.drawable.sea_urchin,
                                R.drawable.sea_worm,
                                R.drawable.shark,
                                R.drawable.sheep,
                                R.drawable.shrew,
                                R.drawable.shrimp,
                                R.drawable.siberian_husky,
                                R.drawable.silkworm,
                                R.drawable.silverfish,
                                R.drawable.skink,
                                R.drawable.skipper,
                                R.drawable.skunk,
                                R.drawable.sloth,
                                R.drawable.slug,
                                R.drawable.smilodon,
                                R.drawable.snail,
                                R.drawable.snake,
                                R.drawable.snapper,
                                R.drawable.snapping_turtle,
                                R.drawable.snowy_owl,
                                R.drawable.snow_leopard,
                                R.drawable.sparrow,
                                R.drawable.spider,
                                R.drawable.sponge,
                                R.drawable.squid,
                                R.drawable.squirrel,
                                R.drawable.starfish,
                                R.drawable.starling,
                                R.drawable.stegosaurus,
                                R.drawable.stingray,
                                R.drawable.stonefly,
                                R.drawable.stork,
                                R.drawable.sturgeon,
                                R.drawable.sugar_glider,
                                R.drawable.sunfish,
                                R.drawable.swallow,
                                R.drawable.swallowtail,
                                R.drawable.swan,
                                R.drawable.swift,
                                R.drawable.swordfish,
                                R.drawable.tadpole,
                                R.drawable.tamarin,
                                R.drawable.tapeworm,
                                R.drawable.tapir,
                                R.drawable.tarantula,
                                R.drawable.tarsier,
                                R.drawable.termite,
                                R.drawable.tern,
                                R.drawable.terrier,
                                R.drawable.tick,
                                R.drawable.tiger,
                                R.drawable.toad,
                                R.drawable.tortoise,
                                R.drawable.toucan,
                                R.drawable.triceratops,
                                R.drawable.troodon,
                                R.drawable.trout,
                                R.drawable.tsetse_fly,
                                R.drawable.tuna,
                                R.drawable.turkey,
                                R.drawable.turtle,
                                R.drawable.tyrannosaurus_rex,
                                R.drawable.urchin,
                                R.drawable.vampire_bat,
                                R.drawable.various,
                                R.drawable.velociraptor,
                                R.drawable.venomous_animals,
                                R.drawable.vertebrates,
                                R.drawable.viper,
                                R.drawable.vulture,
                                R.drawable.walkingstick,
                                R.drawable.wallaby,
                                R.drawable.walrus,
                                R.drawable.warthog,
                                R.drawable.wasp,
                                R.drawable.water_strider,
                                R.drawable.weasel,
                                R.drawable.weevil,
                                R.drawable.whale,
                                R.drawable.whelk,
                                R.drawable.white_dove,
                                R.drawable.white_tiger,
                                R.drawable.wildebeest,
                                R.drawable.wild_cat,
                                R.drawable.wild_dog,
                                R.drawable.wolf,
                                R.drawable.wolverine,
                                R.drawable.wombat,
                                R.drawable.woodpecker,
                                R.drawable.woolly_mammoth,
                                R.drawable.working_dog,
                                R.drawable.worm,
                                R.drawable.worms,
                                R.drawable.yak,
                                R.drawable.yorkshire_terrier,
                                R.drawable.zebra,
                                R.drawable.zorro,
                    };
                        Toast.makeText(getApplicationContext(),"ANIMAL",Toast.LENGTH_SHORT).show();
                        String[] getEnglishAnimal = getResources().getStringArray(R.array.three_SubAnimalEnglish);
                        String[] getJapaneseAnimal = getResources().getStringArray(R.array.three_subAnimalJapanese);
                        String[] getRomajiAnimal = getResources().getStringArray(R.array.three_subAnimalRomaji);
                        intent = new Intent(ctx,loading.class);
                        String prefAnimal = nameSharedPrefences[5];
                        intent.putExtra("prefencesName",prefAnimal);
                        intent.putExtra("current_level",levelAnimal);
                        intent.putExtra("imageData",imageAnimal);
                        intent.putExtra("tittleData",getEnglishAnimal);
                        intent.putExtra("alphabetData",getJapaneseAnimal);
                        intent.putExtra("nonalphabetData",getRomajiAnimal);
                        startActivity(intent);

                        break;
                    default:
                        break;
                }
            }
        };
        LinearLayoutManager setHorizontal = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,false);
        rectwo.setLayoutManager(setHorizontal);
        staticAdapter = new AdapterStatic(MainActivity.this,firstRecycleImage,tittleItem,englishTextItem,japanTextItem,Listener,nameSharedPrefences,levelData);
        rectwo.setAdapter(staticAdapter);


    }
}