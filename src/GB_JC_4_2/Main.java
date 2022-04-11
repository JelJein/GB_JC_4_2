package GB_JC_4_2;

import java.util.ArrayList;

    /**
 *      Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
 *      телефонных номеров. В этот телефонный справочник с помощью метода add() можно
 *      добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
 *      учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 *      тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
 *      лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
 *      через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
 *      справочника.
     */

    class PhoneRecord {

        String surname;
        String phoneNumber;

        public PhoneRecord(String surname, String phoneNumber) {
            this.surname = surname;
            this.phoneNumber = phoneNumber;
        }

        public String toString() {
            return surname + " : " + phoneNumber;
        }
    }

    class PhoneBook<T extends PhoneRecord> extends ArrayList {

        public PhoneBook() {
            super();
        }

        public void add(String surname, String phoneNumber) {
            this.add(new PhoneRecord(surname, phoneNumber));
        }

        public ArrayList get(String surname) {
            ArrayList<T> res = new ArrayList<>();
            for (int i = 0; i < this.size(); i++) {
                T record = (T) this.get(i);
                if (surname.equals(record.surname)) {
                    res.add(record);
                }
            }
            return res;
        }
    }

    public class Main {

        public static void main(String[] args) {

            PhoneBook phoneBook = new PhoneBook();
            phoneBook.add("Zhabin","9221002233");
            phoneBook.add("Sidorov","9221003344");
            phoneBook.add("Bronevikov","9221004455");
            phoneBook.add("Zhabin","9221005566");
            System.out.println("Phone book: " + phoneBook);
            System.out.println("Found for: " + phoneBook.get("Zhabin"));
    }
}
