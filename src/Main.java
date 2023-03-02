import java.util.*;
import java.util.stream.Collectors;
//        Дан класс User, который содержит поля с именем и возрастом. Необходимо реализовать следующий метод:
//        1. На входе коллекция пользователей
//        2. Необходимо удалить все дубли (одинаковое имя и возраст)
//        3. Отсортировать по возрасту и имени
//        4. Вернуть самого старого пользователя



public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivanov", 21));
        users.add(new User("Petrova", 23));
        users.add(new User("Kovalov", 26));
        users.add(new User("Stepanov", 42));
        users.add(new User("Gromov", 50));
        users.add(new User("Smirnov", 40));
        users.add(new User("Ivanov", 21));
        users.add(new User("Smirnov", 40));

        System.out.println(users);
        // Необходимо удалить все дубли (одинаковое имя и возраст)
        //Метод Java Stream distinct()возвращает новый поток различных элементов.
        // Поэтому его можно использовать для удаления дубликатов элементов из набора.
        List<User> usersWithoutDuplicate = users.stream().distinct().collect(Collectors.toList());
        System.out.println(usersWithoutDuplicate);
        System.out.println();
        //Отсортировать по возрасту и имени
        List<User> sortedList = users.stream().sorted(Comparator.comparing(User::getAge).thenComparing(User::getName)).collect(Collectors.toList());
        sortedList.forEach(System.out::println);
        System.out.println();
        // Вернуть самого старого пользователя
        User maxAge = users.stream().max(Comparator.comparingInt(User::getAge)).get();
        System.out.println(maxAge);

    }

}