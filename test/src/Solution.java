//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
    HashMap<String, String> map;

    public Solution() {
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.init();
        solution.run();
    }

    private void run() throws IOException {
        int inlegalCount = 0;
        int row = 0;
        int right = 0;
        int wrong = 0;
        FileInputStream fis = new FileInputStream("./input/test.txt");
        Scanner read = new Scanner(fis, "UTF-8");
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File("./out/correct.txt")));
        BufferedWriter wr = new BufferedWriter(out);
        OutputStreamWriter out2 = new OutputStreamWriter(new FileOutputStream(new File("./out/illegal.txt")));
        BufferedWriter wr2 = new BufferedWriter(out2);
        OutputStreamWriter out3 = new OutputStreamWriter(new FileOutputStream(new File("./out/wrong.txt")));
        BufferedWriter wr3 = new BufferedWriter(out3);
        ArrayList list = new ArrayList();

        while(read.hasNextLine()) {
            ++row;
            String ll = read.nextLine().toString().trim();
            String[] line = ll.split(" ");
            String w = line[0];
            line[0] = line[0].substring(0, 6);
            int n = line.length;
            if (!line[n - 1].equalsIgnoreCase("pc") && !line[n - 1].equalsIgnoreCase("phone") && !line[n - 1].equalsIgnoreCase("router")) {
                System.out.println("第" + row + "行输入格式不对");
                return;
            }

            if (!map.containsKey(line[0].substring(0, 6))) {
                ++inlegalCount;
                wr2.flush();
                wr2.write(ll.substring(0, 12) + "\n");
            } else {
                String t = ((String)map.get(line[0])).trim();
                String[] tt = t.split(" ");
                if (tt[tt.length - 1].equalsIgnoreCase(line[n - 1])) {
                    w = w + "  " + t;
                    ++right;
                } else {
                    ++wrong;
                    String ans = w + "   predict：" + tt[tt.length - 1];
                    int m = tt[tt.length - 1].length();
                    if (m == 2) {
                        ans = ans + "      ";
                    } else if (m == 5) {
                        ans = ans + "   ";
                    } else {
                        ans = ans + "  ";
                    }

                    ans = ans + "  label: " + line[n - 1];
                    list.add(ans);
                }

                w = w + "\n";
                wr.flush();
                if (w.length() >= 15) {
                    wr.write(w);
                }
            }
        }

        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String t1 = o1.trim();
                String t2 = o2.trim();
                return t1.compareToIgnoreCase(t2);
            }
        });
        Iterator var22 = list.iterator();

        while(var22.hasNext()) {
            String t = (String)var22.next();
            t = t + "\n";
            wr3.flush();
            wr3.write(t);
        }

        System.out.println("共有数据" + row + "个 , 准确预测数：" + right + "，不合法的有：" + inlegalCount + "行 ，出错的有 " + wrong + "个");
        System.out.println("准确率 =  准确预测数 / ( 总个数- 不合法个数) = " + (double)right * 1.0D / (double)(row - inlegalCount) * 100.0D + "%");
    }

    public void init() throws Exception {
        map = new HashMap<>();
        Scanner read = new Scanner(getClass().getResourceAsStream("/mac_company2.txt"), "UTF-8");

        while(read.hasNextLine()) {
            String line = read.nextLine().toString().trim();
            String key = line.substring(0, 6).trim();
            String value = line.substring(6).trim();
            if (!map.containsKey(key)) {
                map.put(key, value);
            }
        }

    }
}
