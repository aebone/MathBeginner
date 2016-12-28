package edu.depaul.csc472.mathbeginner.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import edu.depaul.csc472.mathbeginner.QuestionOptions;
import edu.depaul.csc472.mathbeginner.R;

/**
 * Created by meline on 11/15/15.
 */
public class QuestionOptionMaps {

    private QuestionOptionMaps () {}

    public static ArrayList<QuestionOptions> getOptionsList() {
        return optionsList;
    }

    public static HashMap<QuestionOptions, Integer> getOptionsDrawableMap() {
        return optionsDrawableMap;
    }

    public static HashMap<QuestionOptions, String> getOptionsKeysMap() {
        return optionsKeysMap;
    }

    public static HashMap<QuestionOptions, Integer> getOptionsTimerMap() {
        return optionsTimerMap;
    }

    private static ArrayList<QuestionOptions> optionsList;
    private static HashMap<QuestionOptions, Integer> optionsDrawableMap;
    private static HashMap<QuestionOptions, String> optionsKeysMap;
    private static HashMap<QuestionOptions, Integer> optionsTimerMap;

    static {
        optionsList = new ArrayList<> ();
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.ADDITION, 1, false));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.ADDITION, 2, false));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.ADDITION, 3, false));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.ADDITION, 1, true));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.ADDITION, 2, true));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.ADDITION, 3, true));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.SUBTRACTION, 1, false));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.SUBTRACTION, 2, false));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.SUBTRACTION, 3, false));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.SUBTRACTION, 1, true));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.SUBTRACTION, 2, true));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.SUBTRACTION, 3, true));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.MULTIPLICATION, 1, false));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.MULTIPLICATION, 2, false));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.MULTIPLICATION, 1, true));
        optionsList.add (new QuestionOptions (QuestionOptions.OperationType.MULTIPLICATION, 2, true));

        ArrayList<String> prefKeyArray = new ArrayList<> ();
        prefKeyArray.add ("plus1_0");
        prefKeyArray.add ("plus2_0");
        prefKeyArray.add ("plus3_0");
        prefKeyArray.add ("plus1_1");
        prefKeyArray.add ("plus2_1");
        prefKeyArray.add ("plus3_1");
        prefKeyArray.add ("sub1_0");
        prefKeyArray.add ("sub2_0");
        prefKeyArray.add ("sub3_0");
        prefKeyArray.add ("sub1_1");
        prefKeyArray.add ("sub2_1");
        prefKeyArray.add ("sub3_1");
        prefKeyArray.add ("multi1_0");
        prefKeyArray.add ("multi2_0");
        prefKeyArray.add ("multi1_1");
        prefKeyArray.add ("multi2_1");
        optionsKeysMap = getHashMapFromCollections (optionsList, prefKeyArray);

        ArrayList<Integer> idArray = new ArrayList<> ();
        idArray.add (R.drawable.plus1_0);
        idArray.add (R.drawable.plus2_0);
        idArray.add (R.drawable.plus3_0);
        idArray.add (R.drawable.plus1_1);
        idArray.add (R.drawable.plus2_1);
        idArray.add (R.drawable.plus3_1);
        idArray.add (R.drawable.sub1_0);
        idArray.add (R.drawable.sub2_0);
        idArray.add (R.drawable.sub3_0);
        idArray.add (R.drawable.sub1_1);
        idArray.add (R.drawable.sub2_1);
        idArray.add (R.drawable.sub3_1);
        idArray.add (R.drawable.multi1_0);
        idArray.add (R.drawable.multi2_0);
        idArray.add (R.drawable.multi1_1);
        idArray.add (R.drawable.multi2_1);
        optionsDrawableMap = getHashMapFromCollections (optionsList, idArray);

        ArrayList<Integer> timeList = new ArrayList<> ();
        timeList.add (Integer.MIN_VALUE);
        timeList.add (Integer.MIN_VALUE);
        timeList.add (Integer.MIN_VALUE);
        timeList.add (20);
        timeList.add (60);
        timeList.add (60);
        timeList.add (Integer.MIN_VALUE);
        timeList.add (Integer.MIN_VALUE);
        timeList.add (Integer.MIN_VALUE);
        timeList.add (20);
        timeList.add (30);
        timeList.add (60);
        timeList.add (Integer.MIN_VALUE);
        timeList.add (Integer.MIN_VALUE);
        timeList.add (20);
        timeList.add (195);
        optionsTimerMap = getHashMapFromCollections (optionsList, timeList);
    }

    private static <K, V> HashMap<K, V> getHashMapFromCollections (Collection<K> keys, Collection<V> values) {
        if (keys.size () != values.size ())
            throw new AssertionError ();
        HashMap<K, V> map = new HashMap<> ();
        K[] keyArray = (K[])keys.toArray ();
        V[] valueArray = (V[])values.toArray ();
        for (int i = 0 ; i < keys.size () ; i++) {
            map.put (keyArray[i], valueArray[i]);
        }
        return map;
    }
}
