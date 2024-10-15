package test;

import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionComparator {

    // 定义差异结果类
    public static class DiffResult<T> {
        private List<T> added;
        private List<T> modified;
        private List<T> removed;

        public DiffResult(List<T> added, List<T> modified, List<T> removed) {
            this.added = added;
            this.modified = modified;
            this.removed = removed;
        }


        public List<T> getAdded() {
            return added;
        }

        public List<T> getModified() {
            return modified;
        }

        public List<T> getRemoved() {
            return removed;
        }
        // 构造方法和getter/setter省略...
    }

    public static <T> DiffResult<T> compareCollections(Collection<T> oldCollection,
                                                       Collection<T> newCollection,
                                                       Function<T, String> nameExtractor,
                                                       Function<T, Object> valueExtractor) {

        // 创建旧集合的查找Map（name -> value）
        Map<String, Object> oldMap = oldCollection.stream()
                .collect(Collectors.toMap(
                        nameExtractor,
                        valueExtractor,
                        (existing, replacement) -> existing));

        // 创建新集合的查找Map（name -> object）
        Map<String, T> newMap = newCollection.stream()
                .collect(Collectors.toMap(
                        nameExtractor,
                        obj -> obj,
                        (existing, replacement) -> existing));

        List<T> added = new ArrayList<>();
        List<T> modified = new ArrayList<>();
        List<T> removed = new ArrayList<>();

        // 检查新增和修改
        for (T newItem : newCollection) {
            String name = nameExtractor.apply(newItem);
            Object newValue = valueExtractor.apply(newItem);

            if (!oldMap.containsKey(name)) {
                added.add(newItem);
            } else {
                Object oldValue = oldMap.get(name);
                if (!Objects.equals(oldValue, newValue)) {
                    modified.add(newItem);
                }
            }
        }

        // 检查删除
        for (T oldItem : oldCollection) {
            String name = nameExtractor.apply(oldItem);
            if (!newMap.containsKey(name)) {
                removed.add(oldItem);
            }
        }

        return new DiffResult<>(added, modified, removed);
    }

    // 使用示例
    public static void main(String[] args) {
        List<A> oldList = Arrays.asList(
                new A("A1", null),
                new A("A2", null),
                new A("A3", null)
        );

        List<A> newList = Arrays.asList(
                new A("A1", "150"),  // 修改
                new A("A3", "300"),
                new A("A4", "400")  // 新增
        );

        DiffResult<A> result = compareCollections(
                oldList,
                newList,
                A::getName,
                A::getValue
        );

        System.out.println("Added: " + result.getAdded());
        System.out.println("Modified: " + result.getModified());
        System.out.println("Removed: " + result.getRemoved());
    }
}

// A类定义
@Data
class A {
    private String name;
    private String value;

    public A(String a1, String a2 ) {
        this.name = a1;
        this.value = a2;
    }

    // 构造方法和getter/setter省略...
}