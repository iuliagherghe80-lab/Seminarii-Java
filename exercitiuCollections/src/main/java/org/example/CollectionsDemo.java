package org.example;
import java.util.*;


public class CollectionsDemo {
    public static void main(String[] args){
        List<String> studenti = new ArrayList<>();
        studenti.add("Ana");
        studenti.add("Bogdan");
        studenti.add("Cristina");
        studenti.add("David");
        studenti.add("Elena");
        System.out.println(studenti);

        studenti.remove(2);
        System.out.println(studenti);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.size();

        System.out.println("Numerele: " + numbers);
        System.out.println("Suma: " + sum);
        System.out.println("Media: " + average);

        List<Integer> listToReverse = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Înainte de inversare: " + listToReverse);

        int left = 0;
        int right = listToReverse.size() - 1;
        while (left < right) {
            int temp = listToReverse.get(left);
            listToReverse.set(left, listToReverse.get(right));
            listToReverse.set(right, temp);

            left++;
            right--;
        }
        System.out.println("După inversare manuală: " + listToReverse);

        String sentence = "java este un limbaj frumos si java este puternic";

        String[] words = sentence.split(" ");

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("Cuvinte unice: " + uniqueWords);
        System.out.println("Numărul de cuvinte unice: " + uniqueWords.size());

        String input = "apple banana apple orange banana apple";
        String[] fruits = input.split(" ");

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String fruit : fruits) {
            frequencyMap.put(fruit, frequencyMap.getOrDefault(fruit, 0) + 1);
        }
        System.out.println("Frecvența cuvintelor: " + frequencyMap);

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Iulia", "0722111222");
        phoneBook.put("Andrei", "0744333444");
        phoneBook.put("Elena", "0755555666");

        String searchName = "Iulia";
        if (phoneBook.containsKey(searchName)) {
            System.out.println("Numărul lui " + searchName + " este: " + phoneBook.get(searchName));
        }

        System.out.println("Toate intrările din agendă:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        List<Student> students = new ArrayList<>();
        students.add(new Student("Mihai", 8));
        students.add(new Student("Alina", 10));
        students.add(new Student("Radu", 7));
        students.add(new Student("Ioana", 9));

        System.out.println("Lista de studenți:");
        for (Student s : students) {
            System.out.println("  " + s);
        }

        Student highestGradeStudent = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > highestGradeStudent.getGrade()) {
                highestGradeStudent = s;
            }
        }
        System.out.println("Studentul cu cea mai mare notă: " + highestGradeStudent);

        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Sortat alfabetic după nume: " + students);

        students.sort(Comparator.comparingInt(Student::getGrade).reversed());
        System.out.println("Sortat descrescător după notă: " + students);

        List<Student> studentListWithDuplicates = new ArrayList<>();
        studentListWithDuplicates.add(new Student("Alina", 10));
        studentListWithDuplicates.add(new Student("Mihai", 8));
        studentListWithDuplicates.add(new Student("Alina", 10)); // Duplicat exact
        studentListWithDuplicates.add(new Student("Radu", 7));

        System.out.println("Lista inițială (cu duplicate): " + studentListWithDuplicates);

        Set<Student> cleanStudentSet = new LinkedHashSet<>(studentListWithDuplicates);

        List<Student> studentListNoDuplicates = new ArrayList<>(cleanStudentSet);
        System.out.println("Lista curățată (fără duplicate): " + studentListNoDuplicates);


    }
}
