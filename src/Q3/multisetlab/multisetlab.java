package Q3.multisetlab;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import DataStructures.Bag;

public class multisetlab {
    public static void main(String[] args) {
        try {
            var input = new Scanner(new File("Langdat/words"));
            var bag = new Bag<String>();
            var rnd = new java.util.Random(42);

            while (input.hasNext()) {
                String word = input.next().toLowerCase();
                for (int i = 0; i < rnd.nextInt(1, 11); i++) {
                    bag.insert(word);
                }

            }
            input.close();

            bag.enumerate();
            String[] str = new String[10];
            int[] nums = new int[10];
            var set = bag.getSet();
            var iter = set.iterator();
            while (iter.hasNext()) {
                var word = iter.next();
                var count = bag.count(word);
                var index = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (index != -1) {
                        if (nums[i] < count && nums[index] > nums[i]) {
                            index = i;
                        }
                    } else {
                        if (nums[i] < count) {
                            index = i;
                        }
                    }
                }
                if (index != -1) {
                    str[index] = word;
                    nums[index] = count;
                }
            }
            System.out.println("Ten most common words: ");
            for (String st : str) {
                System.out.println(st);
            }

        } catch (IOException e) {
            System.out.println("No data file found.");
        }
    }
}
//{
//	the(32)
//	getka(5)
//	coolest(2)
//	he(6)
//	kingest(1)
//	and(3)
//	smack(2)
//	dancing(4)
//	is(9)
//	dudest(4)
//	mr(3)
//	daddiest(3)
//	up(2)
//	got(1)
//	wowsa(4)
//	est(4)
//	class(4)
//	ist(9)
//	awesomest(4)
//	this(4)
//	whats(4)
//	knows(4)
//	guns(7)
//}
//Ten most common words:
//ist
//the
//guns
//dudest
//knows
//he
//dancing
//awesomest
//is
//getka