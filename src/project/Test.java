package project;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by owner_ on 2016-02-22.
 */
public class Test {


    public static String getWhoSelectedStudent(Collection<Student> students, Student given) {


        Predicate<Student> selected = s -> s.getSelected().contains(given.getStudentID());

        return
                students.stream()
                        .filter(s -> s.getSelected().contains(given.getStudentID()))
                        .map(Student::getStudentID)
                        .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {

//        DatabaseStuff.INSTANCE.getALlStudents();



//        class Student {
//            String id;
//            Student(String id) {
//                this.id = id;
//            }
//            String getStudentId() {
//                return id;
//            }
//        }
//
//        Student[] students = {new Student("1"), new Student("2"), new Student("3")};
//
//        for (Student student: Arrays.stream(students).filter(s -> !s.getStudentId().equals("1")).collect(Collectors.toList())) {
//            System.out.println(student.getStudentId());
//        }


        for (project.Student s:  DatabaseStuff.INSTANCE.getALlStudents().values()) {
            System.out.println(s.getName() +", " + s.getStudentID());
        }


//        for (project.Student s:  Helpers.filterStudents(DatabaseStuff.INSTANCE.getALlStudents().values(), "3040500")) {
//            System.out.println(s.getName() +", " + s.getStudentID());
//        }


//        System.out.println(DatabaseStuff.INSTANCE.getALlStudents().get("3040502").getSelected());


        Map<String, project.Student> allStudentsMap = DatabaseStuff.INSTANCE.getALlStudents();




        System.out.println(getWhoSelectedStudent(allStudentsMap.values(), allStudentsMap.get("3040500")));





//        String[] arr = {"arr1", "arr2"};
//        System.out.println(Arrays.stream(arr).collect(Collectors.joining(" ")));

//        System.out.println("2353 33 55".contains("55"));
//

//        System.out.println(Helpers.filterStudents(DatabaseStuff.INSTANCE.getALlStudents().values(), "3040500"));

//        public class Service {
//            private String pValue;
//
//            public void bDayCalc(PageContext pageContext) throws ParseException, IOException
//            {
//                long mYear = 365L*24*60*60*1000;
//
//                Bean lBean = (Bean) pageContext.getAttribute("bean");
//
//                String dateFormatString = "MM/dd/yyyy";
//                SimpleDateFormat format = new SimpleDateFormat(dateFormatString);
//
//                Date birthday = format.parse(lBean.getBirthDate());
//
//                Date today = new Date();
//
//                long diff = today.getTime() - birthday.getTime();
//                long years = (diff / mYear);
//
//                Calendar nextBday = Calendar.getInstance();
//                nextBday.setTime(birthday);
//                nextBday.add(Calendar.YEAR, (int) years);
//
//                Calendar cDiff = Calendar.getInstance();
//                cDiff.setTime(today);
//
//                nextBday.add(Calendar.DAY_OF_YEAR,-1*cDiff.get(Calendar.DAY_OF_YEAR));
//
//                ((JspWriter) pageContext.getOut()).write("You next birthday is in " + nextBday.get(Calendar.DAY_OF_YEAR) + " days");
//
//            }
//
//        }
//
//
    }
}

