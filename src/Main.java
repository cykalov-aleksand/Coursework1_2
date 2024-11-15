public class Main {
    static final Employee[] employees = {
            new Employee("Рыжиков Сергей Викторович", 1, 74003f),
            new Employee("Кукушкина Надежда Михайловна", 2, 77777f),
            new Employee("Калмыков Вячеслав Васильевич", 3, 99343f),
            new Employee("Панферов Игорь викторович", 4, 99343f),
            new Employee("Баязитов Евгений Александрович", 1, 83023f),
            new Employee("Позднякова Галина Михайловна", 2, 77777f),
            new Employee("Синицын Алексей Иванович", 2, 68432f),
            new Employee("", 4, 0),
            new Employee("Колосов Александр Игоревич", 3, 85000f),
            new Employee("", 3, 0)
    };

    static void printTitle(String title) {
        int lineLength = 100;
        int headerLength = title.length();
        int numberOfCharacters = (lineLength - headerLength) / 2;
        String completion = "-";
        System.out.println("\n" + completion.repeat(numberOfCharacters) + title + completion.repeat(numberOfCharacters));
    }

    static void outputTheTable(int numberDepartament) {
        if (numberDepartament == 0) {
            System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        } else {
            System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        }
        for (Employee variable : employees) {
            if (variable.getFullname() != null && !variable.getFullname().isBlank()) {
                if (numberDepartament == 0) {
                    System.out.println(variable);
                } else if (variable.getDepartament() == numberDepartament) {
                    System.out.printf("%5d%35s%20.2f%s\n", variable.getId(), variable.getFullname(), variable.getSalary(), " руб.");
                }
            }
        }
    }

    static float calculateAmountExpenses(int numberDepartament) {
        float amount = 0;
        for (Employee variable : employees) {
            if (variable.getFullname() != null && !variable.getFullname().isBlank()) {
                if (numberDepartament == 0 || variable.getDepartament() == numberDepartament) {
                    amount = amount + variable.getSalary();
                }
            }
        }
        return amount;
    }

    static int countTheEmployees(int numberDepartament) {
        int amount = 0;
        for (Employee variable : employees) {
            if (variable.getFullname() != null && !variable.getFullname().isBlank()) {
                if (numberDepartament == 0 || variable.getDepartament() == numberDepartament) {
                    amount++;
                }
            }
        }
        return amount;
    }

    static void compareMoreLess(int numberDepartament, String moreLess) {
        float minimum = employees[0].getSalary();
        float maximum = employees[0].getSalary();
        System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        for (Employee variable : employees) {
            if (variable.getFullname() != null && !variable.getFullname().isBlank()) {
                if (numberDepartament == 0 || variable.getDepartament() == numberDepartament) {
                    if (minimum > variable.getSalary()) {
                        minimum = variable.getSalary();
                    }
                    if (maximum <= variable.getSalary()) {
                        maximum = variable.getSalary();
                    }
                }
            }
        }
        int counter = 0;
        float minimumOrMaximum = minimum;
        String outputString = "Минимальная";
        if (moreLess.contains(">")) {
            minimumOrMaximum = maximum;
            outputString = "Максимальная";
        }
        for (Employee variable : employees) {
            if (variable.getFullname() != null && !variable.getFullname().isBlank()) {
                if (numberDepartament == 0 || variable.getDepartament() == numberDepartament) {
                    if (minimumOrMaximum == variable.getSalary()) {
                        counter++;
                        System.out.printf("%5s%35s%20s\n", variable.getId(), variable.getFullname(), variable.getSalary());
                    }
                }
            }
        }
        System.out.printf("\n%s%s", outputString, " зарплата сотрудника предприятия составляет: ");
        System.out.printf("%.2f%s%d%s\n", minimumOrMaximum, " руб. и её получает ", counter, " человек(а)");
    }

    static void displayListEmployees() {
        System.out.printf("%35s\n", "Фамилия имя отчество");
        for (Employee variable : employees) {
            if (variable.getFullname() != null && !variable.getFullname().isBlank()) {
                System.out.printf("%35s\n", variable.getFullname());
            }
        }
    }

    static void indexesWages(int procent, int numberDepartament) {
        System.out.printf("%5s%35s%10s%20s%35s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата", "Зарплата после индексации");
        for (Employee variable : employees) {
            if (variable.getFullname() != null && !variable.getFullname().isBlank()) {
                if (numberDepartament == 0 || variable.getDepartament() == numberDepartament) {
                    System.out.print(variable);
                    variable.setSalary((variable.getSalary() + (variable.getSalary() * procent / 100)));
                    System.out.printf("%20.2f%5s\n", variable.getSalary(), "руб");
                }
            }
        }
    }

    static void compareMoreAndLessThreshold(float doorstep, int numberDepartament, String moreLess) {
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        byte number = 0;
        for (Employee variable : employees) {
            if (variable.getFullname() != null && !variable.getFullname().isBlank()) {
                if (numberDepartament == 0 || variable.getDepartament() == numberDepartament) {
                    if (moreLess.contains(">")) {
                        if (doorstep <= variable.getSalary()) {
                            System.out.println(variable);
                            number++;
                        }
                    } else if (doorstep > variable.getSalary()) {
                        System.out.println(variable);
                        number++;
                    }
                }
            }
        }
        String outputString = "ниже";
        if (moreLess.contains(">")) {
            outputString = "выше";
        }
        if (number == 0) {
            System.out.println("Зарплат " + outputString + " указанного порога нет");
        }
    }

    public static void main(String[] args) {
        printTitle("КУРСОВОЕ ЗАДАНИЕ");
        printTitle("КНИГА СОТРУДНИКОВ");
        printTitle("БАЗОВАЯ СЛОЖНОСТЬ");
        printTitle("a) список всех сотрудников");
        outputTheTable(0);
        printTitle("b) сумму затрат на ЗП в месяц");
        if (calculateAmountExpenses(0) == 0 && countTheEmployees(0) != 0) {
            System.out.println("Руководитель не платит работникам зарплату");
        } else if (countTheEmployees(0) == 0) {
            System.out.println("Штат пуст, трудоустраиваите людей на вакантные должности");
        } else {
            System.out.printf("%s%.2f%s\n", "Сумма затрат на зарплату сотрудникам составляет: ", calculateAmountExpenses(0), " руб.");
            printTitle("c) сотрудники предприятия с минимальной ЗП");
            compareMoreLess(0, "<");
            //findMinimumWage();
            printTitle("d) сотрудники предприятия с максимальной ЗП");
            compareMoreLess(0, ">");
            //findMaximumWage();
            printTitle("e) среднее значение зарплат на предприятии");
            System.out.printf("%s%.2f%s\n", "Среднее значение зарплат сотрудников предприятия составляет: ",
                    calculateAmountExpenses(0) / countTheEmployees(0), " руб.");
            printTitle("f) список ФИО всех сотрудников предприятия");
            displayListEmployees();

            printTitle("ПОВЫШЕННАЯ СЛОЖНОСТЬ");
            int procent = 10;
            int numberDepartament = 2;
            int procentDeportament = -10;
            float doorstep = 80000.23f;
            System.out.println("Ввели данные: \n1. procent = " + procent + " - значения для пункта 1.\n2. numberdepartament = " + numberDepartament +
                    " - значения для пункта 2.\n3. procentDeportament = " + procentDeportament + " -значения для пункта 2.е\n4. doorstep = " + doorstep + " - значение для пункта 3.");
            System.out.println("\n 1. Проиндексировать зарплату, (вызвать изменение зп у всех сотрудников на величину \"" + procent + " %\"):");
            indexesWages(procent, 0);
            printTitle("2. Получили в качестве параметра номер отдела " + numberDepartament);
            final int constantMinimumDepartment = 1;
            final int constantMaximumDepartament = 5;
            if (numberDepartament < constantMinimumDepartment || numberDepartament > constantMaximumDepartament) {
                String error = "Неверно введён отдел";
                throw new IllegalArgumentException(error);
            } else if (countTheEmployees(numberDepartament) == 0) {
                System.out.println("Отдел пуст, проведите работу по трудоустройству специалистов");
            } else {
                printTitle("a.Сотрудники отдела " + numberDepartament + " с минимальной зп");
                compareMoreLess(numberDepartament, "<");
                printTitle("b.Сотрудники отдела " + numberDepartament + " с максимальной зп");
                compareMoreLess(numberDepartament, ">");
                printTitle("c.Сумма затрат на зп по отделу " + numberDepartament);
                System.out.printf("%s%.2f%s\n", "Сумма затрат на зарплату сотрудникам составляет: ", calculateAmountExpenses(numberDepartament), " руб.");
                printTitle("d. Среднее значение зарплат в отделе " + numberDepartament);
                System.out.printf("%s%.2f%s\n", "Среднее значение зарплат сотрудников предприятия составляет: ",
                        calculateAmountExpenses(numberDepartament) / countTheEmployees(numberDepartament), " руб.");
                printTitle("e. Проиндексировали зарплату всех сотрудников отдела " + numberDepartament + " на \"" + procentDeportament + " %\"");
                indexesWages(procentDeportament, numberDepartament);
                printTitle("f. Напечатали всех сотрудников отдела № " + numberDepartament + " (все данные, кроме отдела)");
                outputTheTable(numberDepartament);
                printTitle("3. Получили в качестве параметра порог зарплаты в отделе " + doorstep);
                printTitle("a.1. Вывели на консоль всех сотрудников отдела \"" + numberDepartament + " с зп меньше " + doorstep);
                compareMoreAndLessThreshold(doorstep, numberDepartament, "<");
                printTitle("b.1. Вывели на консоль всех сотрудников отдела " + numberDepartament + " с зп больше (или равно) " + doorstep);
                compareMoreAndLessThreshold(doorstep, numberDepartament, ">");
            }
            printTitle("3. Получили в качестве параметра порог зарплаты на предприятии " + doorstep);
            printTitle("a.2. Вывели на консоль всех сотрудников предприятия с зп меньше " + doorstep);
            compareMoreAndLessThreshold(doorstep, 0, "<");
            printTitle("b.2. Вывели на консоль всех сотрудников предприятия с зп больше (или равно)  " + doorstep);
            compareMoreAndLessThreshold(doorstep, 0, ">");
        }
    }
}
//Во всех методах где указан номер дипартамента "0"- проводим действия со всем массивом информации