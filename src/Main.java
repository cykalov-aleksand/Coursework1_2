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

    static boolean evaluateCell(Employee element) {
        return (element.getSurnameNamePatrnimic() != null && !element.getSurnameNamePatrnimic().isBlank());
    }

    static void outputTheTable() {
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                System.out.println(variable);
            }
        }
    }

    static void outputTheTable(int numberDepartament) {
        System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (variable.getDepartament() == numberDepartament) {
                    System.out.printf("%5d%35s%20.2f%s\n", variable.getId(), variable.getSurnameNamePatrnimic(), variable.getSalary(), " руб.");
                }
            }
        }
    }

    static float calculateAmountExpenses() {
        float amount = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                amount = amount + variable.getSalary();
            }
        }
        return amount;
    }

    static float calculateAmountExpenses(int numberDepartament) {
        float amount = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (variable.getDepartament() == numberDepartament) {
                    amount = amount + variable.getSalary();
                }
            }
        }
        return amount;
    }

    static byte countTheEmployees() {
        byte amount = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                amount++;
            }
        }
        return amount;
    }

    static int countTheEmployees(int numberDepartament) {
        int amount = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (variable.getDepartament() == numberDepartament) {
                    amount++;
                }
            }
        }
        return amount;
    }

    static void findMinimumWage() {
        float minimum = 1000000f;
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (minimum >= variable.getSalary()) {
                    minimum = variable.getSalary();
                }
            }
        }
        int counter = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (minimum == variable.getSalary()) {
                    counter++;
                    System.out.println(variable);
                }
            }
        }
        System.out.printf("\n%s", "Минимальная зарплата сотрудника предприятия составляет: ");
        System.out.printf("%.2f%s%d%s\n", minimum, " руб. и её получает ", counter, " человек(а)");
    }

    static void findMinimumWage(int numberDepartament) {
        float minimum = 1000000f;
        System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (variable.getDepartament() == numberDepartament) {
                    if (minimum >= variable.getSalary()) {
                        minimum = variable.getSalary();
                    }
                }
            }
        }
        int counter = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (variable.getDepartament() == numberDepartament) {
                    if (minimum == variable.getSalary()) {
                        counter++;
                        System.out.printf("%5d%35s%20.2f%s\n", variable.getId(), variable.getSurnameNamePatrnimic(), variable.getSalary(), " руб.");
                    }
                }
            }
        }
        System.out.printf("\n%s", "Минимальная зарплата сотрудника отдела " + numberDepartament + " составляет: ");
        System.out.printf("%.2f%s%d%s\n", minimum, " руб. и её получает ", counter, " человек(а)");
    }

    static void findMaximumWage() {
        float maximum = 0f;
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (maximum <= variable.getSalary()) {
                    maximum = variable.getSalary();
                }
            }
        }
        byte counter = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (maximum == variable.getSalary()) {
                    counter++;
                    System.out.println(variable);
                }
            }
        }
        System.out.printf("\n%s", "Максимальная зарплата сотрудника предприятия составляет: ");
        System.out.printf("%.2f%s%d%s\n", maximum, " руб. и её получает ", counter, " человек(а)");
    }

    static void findMaximumWage(int numberDepartament) {
        float maximum = 0f;
        System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (variable.getDepartament() == numberDepartament) {
                    if (maximum <= variable.getSalary()) {
                        maximum = variable.getSalary();
                    }
                }
            }
        }
        byte counter = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (variable.getDepartament() == numberDepartament) {
                    if (maximum == variable.getSalary()) {
                        counter++;
                        System.out.printf("%5d%35s%20.2f%s\n", variable.getId(), variable.getSurnameNamePatrnimic(), variable.getSalary(), " руб.");
                    }
                }
            }
        }
        System.out.printf("%s", "Максимальная зарплата сотрудника отдела " + numberDepartament + " составляет: ");
        System.out.printf("%.2f%s%d%s\n", maximum, " руб. и её получает ", counter, " человек(а)");
    }

    static void displayListEmployees() {
        System.out.printf("%35s\n", "Фамилия имя отчество");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                System.out.printf("%35s\n", variable.getSurnameNamePatrnimic());
            }
        }
    }

    static void indexesWages(int procent) {
        System.out.printf("%5s%35s%10s%20s%35s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата", "Зарплата после индексации");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                System.out.print(variable);
                variable.setSalary((variable.getSalary() + (variable.getSalary() * procent / 100)));
                System.out.printf("%20.2f%5s\n", variable.getSalary(), "руб");
            }
        }
    }

    static void indexesWages(int procent, int numberDepartament) {
        System.out.printf("%5s%35s%10s%20s%35s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата", "Зарплата после индексации");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (variable.getDepartament() == numberDepartament) {
                    System.out.print(variable);
                    variable.setSalary((variable.getSalary() + (variable.getSalary() * procent / 100)));
                    System.out.printf("%20.2f%5s\n", variable.getSalary(), "руб");
                }
            }
        }
    }

    static void displayTheSalaryBelow(float doorstep) {
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        byte number = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (doorstep > variable.getSalary()) {
                    System.out.println(variable);
                    number++;
                }
            }
        }
        if (number == 0) {
            System.out.println("Зарплат ниже указанного порога нет");
        }
    }

    static void displayTheSalaryBelow(float doorstep, int numberDepartament) {
        System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        byte number = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (variable.getDepartament() == numberDepartament) {
                    if (doorstep > variable.getSalary()) {
                        System.out.printf("%5d%35s%20.2f%s\n", variable.getId(), variable.getSurnameNamePatrnimic(), variable.getSalary(), " руб.");
                        number++;
                    }
                }
            }
        }
        if (number == 0) {
            System.out.println("Зарплат ниже указанного порога  в отделе нет");
        }
    }

    static void displayTheSalaryAbove(float doorstep) {
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        byte number = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (doorstep <= variable.getSalary()) {
                    System.out.println(variable);
                    number++;
                }
            }
        }
        if (number == 0) {
            System.out.println("Зарплат выше указанного порога нет");
        }
    }

    static void displayTheSalaryAbove(float doorstep, int numberDepartament) {
        System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        byte number = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (variable.getDepartament() == numberDepartament) {
                    if (doorstep <= variable.getSalary()) {
                        System.out.printf("%5d%35s%20.2f%s\n", variable.getId(), variable.getSurnameNamePatrnimic(), variable.getSalary(), " руб.");
                        number++;
                    }
                }
            }
        }
        if (number == 0) {
            System.out.println("Зарплат выше указанного порога в отделе нет");
        }
    }

    public static void main(String[] args) {
        System.out.println("""
                -------------------------КУРСОВОЕ ЗАДАНИЕ-------------------------------
                ----------------------- КНИГА СОТРУДНИКОВ-------------------------------
                ------------------------------------------------------------------------
                """);
        System.out.println("------------------------БАЗОВАЯ СЛОЖНОСТЬ-------------------------------\n");
        System.out.println("--------------------a) список всех сотрудников--------------------------\n");
        outputTheTable();
        System.out.println("\n--------------------b) сумму затрат на ЗП в месяц------------------------");
        if (calculateAmountExpenses() == 0 && countTheEmployees() != 0) {
            System.out.println("Руководитель не платит работникам зарплату");
        } else if (countTheEmployees() == 0) {
            System.out.println("Штат пуст, трудоустраиваите людей на вакантные должности");
        } else {
            System.out.printf("%s%.2f%s\n", "Сумма затрат на зарплату сотрудникам составляет: ", calculateAmountExpenses(), " руб.");
            System.out.println("\n--------------------c) сотрудники предприятия с минимальной ЗП-----------");
            findMinimumWage();
            System.out.println("\n--------------------d) сотрудники предприятия с максимальной ЗП----------");
            findMaximumWage();
            System.out.println("\n--------------------e) среднее значение зарплат на предприятии-----------");
            System.out.printf("%s%.2f%s\n", "Среднее значение зарплат сотрудников предприятия составляет: ",
                    calculateAmountExpenses() / countTheEmployees(), " руб.");
            System.out.println("\n--------------------f) список ФИО всех сотрудников предприятия-----------");
            displayListEmployees();


            System.out.println("\n------------------------------------------------ПОВЫШЕННАЯ СЛОЖНОСТЬ--------------------------------------------\n");
            int procent = 10;
            int numberDepartament = 1;
            int procentDeportament = -10;
            float doorstep = 80000.23f;
            System.out.println("Ввели данные: \n1. procent = " + procent + " - значения для пункта 1.\n2. numberdepartament = " + numberDepartament +
                    " - значения для пункта 2.\n3. procentDeportament = " + procentDeportament + " -значения для пункта 2.е\n4. doorstep = " + doorstep + " - значение для пункта 3.");
            System.out.println("\n 1. Проиндексировать зарплату, (вызвать изменение зп у всех сотрудников на величину \"" + procent + " %\"):");
            indexesWages(procent);
            System.out.println("\n ------------------------2. Получили в качестве параметра номер отдела " + numberDepartament + "------------------------------------");
            final int constantMinimumDepartment = 1;
            final int constantMaximumDepartament = 5;
            if (numberDepartament < constantMinimumDepartment || numberDepartament > constantMaximumDepartament) {
                String error = "Неверно введён отдел";
                throw new IllegalArgumentException(error);
            } else if (countTheEmployees(numberDepartament) == 0) {
                System.out.println("Отдел пуст, проведите работу по трудоустройству специалистов");
            } else {
                System.out.println("\n ------------------------a.Сотрудники отдела " + numberDepartament + " с минимальной зп---------------------------------------------");
                findMinimumWage(numberDepartament);

                System.out.println("\n ------------------------b.Сотрудники отдела " + numberDepartament + " с максимальной зп--------------------------------------------");
                findMaximumWage(numberDepartament);

                System.out.println("\n ------------------------c.Сумма затрат на зп по отделу " + numberDepartament + "---------------------------------------------------");
                System.out.printf("%s%.2f%s\n", "Сумма затрат на зарплату сотрудникам составляет: ", calculateAmountExpenses(numberDepartament), " руб.");

                System.out.println("\n------------------d. Среднее значение зарплат в отделе " + numberDepartament + "----------------------------------------------------");
                System.out.printf("%s%.2f%s\n", "Среднее значение зарплат сотрудников предприятия составляет: ",
                        calculateAmountExpenses(numberDepartament) / countTheEmployees(numberDepartament), " руб.");

                System.out.println("\n------------------e. Проиндексировали зарплату всех сотрудников отдела " + numberDepartament + " на \"" + procentDeportament + " %\"-------------------------");
                indexesWages(procentDeportament, numberDepartament);
                System.out.println("\n------------------f. Напечатали всех сотрудников отдела № " + numberDepartament + " (все данные, кроме отдела)----------------------");
                // System.out.println("\nзарплата всех сотрудников отдела " + numberDepartament + " после индексации представлена в таблице:");
                outputTheTable(numberDepartament);

                System.out.println("\n ---------------3. Получили в качестве параметра порог зарплаты в отделе " + doorstep + "----------------------------");
                System.out.println("\n ---------------a.1. Вывели на консоль всех сотрудников отдела " + numberDepartament + " с зп меньше " + doorstep + "-----------------------");
                displayTheSalaryBelow(doorstep, numberDepartament);

                System.out.println("\n -------------b.1. Вывели на консоль всех сотрудников отдела " + numberDepartament + " с зп больше (или равно) " + doorstep + "-------------");
                displayTheSalaryAbove(doorstep, numberDepartament);
            }
            System.out.println("\n ------------3. Получили в качестве параметра порог зарплаты на предприятии " + doorstep + "------------------------");
            System.out.println("\n ---------------a.2. Вывели на консоль всех сотрудников предприятия с зп меньше " + doorstep + "--------------------");
            displayTheSalaryBelow(doorstep);
            System.out.println("\n ---------------b.2. Вывели на консоль всех сотрудников предприятия с зп больше (или равно)  " + doorstep + "-------");
            displayTheSalaryAbove(doorstep);
        }
    }
}
