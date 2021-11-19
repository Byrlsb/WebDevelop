package service;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class renameTest {
    @Test
    public void testRename() {
        String name = "笔记本人群圈选_条件多选批量任务_date_1";

        String[] nameSplit = name.split("_");
        String target = nameSplit[nameSplit.length-1];
        System.out.println(target);


        String[] nameList = {"笔记本人群圈选_条件多选批量任务_date_1","笔记本人群圈选_条件多选批量任务_date_2","笔记本人群圈选_条件多选批量任务_date_3","afsagsfs","笔记本人群圈选_条件多选批量任务_date_4"};
        System.out.println( nameList[0].length());
        char[] c = nameList[0].toCharArray();
        Arrays.sort(nameList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                 return Integer.valueOf(o1.charAt(o1.length()-1)) - Integer.valueOf(o2.charAt(o2.length()-1));
            }
        });

        for (String item : nameList) {
            System.out.println(item);
        }
    }

}
