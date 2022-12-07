package org.ryuu.learndesugar;

import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import org.ryuu.functional.Action;
import org.ryuu.functional.IAction;
import org.ryuu.learndesugar.LearnDesugar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        LearnDesugar learnDesugar = new LearnDesugar();
        initialize(learnDesugar, config);
        IAction desugarFalse = () -> {
            List<Integer> integers = new ArrayList<>();
            integers.add(1);
            integers.add(2);
            integers.add(3);
            integers.add(4);
            integers.add(5);

            List<Integer> res = new ArrayList<>();

            for (int i : integers) {
                if (i <= 3) {
                    continue;
                }
                res.add(i);
            }

            Gdx.app.log(LearnDesugar.class.getSimpleName(), Arrays.toString(res.toArray()));
        };
        IAction desugarTrue = () -> {
            List<Integer> integers = new ArrayList<>();
            integers.add(1);
            integers.add(2);
            integers.add(3);
            integers.add(4);
            integers.add(5);

            List<Integer> collect = integers.stream().filter(integer -> integer > 3).collect(Collectors.toList());

            Gdx.app.log(LearnDesugar.class.getSimpleName(), Arrays.toString(collect.toArray()));
        };
        learnDesugar.getAfterCreate().add(desugarFalse);
        learnDesugar.getAfterCreate().add(desugarTrue);
    }
}