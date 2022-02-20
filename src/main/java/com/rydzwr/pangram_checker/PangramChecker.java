package com.rydzwr.pangram_checker;

import java.util.ArrayList;
import java.util.Collections;

public class PangramChecker
{
    public ArrayList<Character> createAlphabet()
    {
        ArrayList<Character> abc = new ArrayList<>();
        String str = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < str.length(); i++)
        {
            abc.add(str.charAt(i));
        }
        return abc;
    }

    public ArrayList<Character> splitSentence(String str)
    {
        ArrayList<Character> letters = new ArrayList<>();

        str = str.toLowerCase();
        str = str.replaceAll("[0-9]","");

        for (int i = 0; i < str.length(); i++)
        {
            letters.add(str.charAt(i));
        }

        for (int i = 0; i < letters.size(); i++)
        {
            if (letters.get(i) == ' ' || letters.get(i) == '.')
            {
                letters.remove(i);
            }
        }
        Collections.sort(letters);

        return letters;
    }

    public boolean check(String sentence)
    {
        ArrayList<Character> a = createAlphabet();
        ArrayList<Character> b = splitSentence(sentence);
        ArrayList<Boolean> booleanArrayList = new ArrayList<>();

        for (int i = 0; i < a.size(); i++)
        {
            if (b.contains(a.get(i)) == true)
            {
                booleanArrayList.add(true);
            }
            else if (b.contains(a.get(i)) == false)
            {
                booleanArrayList.add(false);
            }
        }

        if(booleanArrayList.contains(false))
        {
            return false;
        }
        else return true;
    }
}
