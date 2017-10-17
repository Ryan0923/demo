package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

/**
 * Created by mojunbin on 2016/3/21.
 */
public class DelayQueueMain {
    public static void main(String[] args) {
        //ArrayList<String> list = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        //ArrayList<String> list = Lists.newArrayList("1");
        ArrayList<String> list = Lists.newArrayList("1", "2", "3");
        ArrayList<Integer> list2 = Lists.newArrayList(1,2,3);
        ArrayList<String> list1 = safeSublist(list, 2, 0);
        ArrayList<String> strings = safeSublist(list, 2, 0);

    }

    static class DelayedObj implements Delayed {
        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }

    public static <T> ArrayList<T> safeSublist(List<T> srcList, int pageSize, int page) {
        if (CollectionUtils.isEmpty(srcList) || pageSize == 0 || page < 1) {
            return Lists.newArrayList();
        }
        ArrayList<T> list = Lists.newArrayListWithExpectedSize(pageSize);
        int total = srcList.size();
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        if (end > total) {
            end = total;
        }
        for (int i = start; i < end; i++) {
            list.add(srcList.get(i));
        }
        System.out.println(
            "page=" + page + " pageSise=" + pageSize + " total=" + srcList.size() + " start=" + start + " end=" + end
                + " rs=" + list);

        return list;
    }
}
