package com.nhsbsa.medicinelist;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
public class medicinceutlils {





        private static List<Medicine> Meds = new ArrayList<Medicine>();

        private static final int NUM_MEDS = 30;

        private static final int MIN_MEDS_NUM = 1000;

        public static List<Medicine> buildMedlist() {
            if (Meds.isEmpty()) {
                IntStream.range(0, NUM_MEDS).forEach(n -> {
                    Meds.add(new Medicine(MIN_MEDS_NUM + n + 1, "Spring in Action"));
                });

            }

            return Meds;
        }

    }
