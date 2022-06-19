package ru.job4j.question;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        Map<Integer, String> map = previous.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User user : current) {
            if (!map.containsKey(user.getId())) {
                added++;
            } else if (!Objects.equals(user.getName(), map.get(user.getId()))) {
                changed++;
            }
        }
        int deleted = previous.size() + added - current.size();
        return new Info(added, changed, deleted);
    }
}