import javax.tools.FileObject;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Group gp1 = new Group();
        File fileUpload = new File("D:\\Java\\GroupDB\\new.db");
        File GroupDB = new File("D:\\Java\\GroupDB");
        File fileDownload = new File(GroupDB.list()[0]);

        gp1.addStudent(new Student("Invoker", "Popov", true, 23, 3));
        gp1.addStudent(new Student("Nyx", "Popov2", true, 26, 4));
        gp1.addStudent(new Student("Riki", "Popov3", true, 22, 1));
        gp1.addStudent(new Student("Axe", "Popov3", true, 22, 1));
        gp1.addStudent(new Student("Mirana", "Popov3", true, 22, 1));
        gp1.addStudent(new Student("Bane", "Popov3", true, 22, 1));
        gp1.addStudent(new Student("Bone", "Popov3", true, 22, 1));
        gp1.showStudents();

        System.out.println();

        int a;
        do{
            System.out.println("Make a choice:");
            System.out.println("1 : Upload in File(new.db)");
            System.out.println("2 : Select DB");
            System.out.println("3 : Download DB from File");
            System.out.println("4 : Show students");
            System.out.println("5 : Exit");
            a = scanner.nextInt();
            switch (a){
                case 1:
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileUpload))){
                        oos.writeObject(gp1);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    Scanner scanner1 = new Scanner(System.in);
                    String[] list;
                    list = GroupDB.list(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(".db");
                        }
                    });
                    System.out.println("============================");
                    for(String s : list){
                        System.out.println(s);
                    }
                    System.out.println("============================");
                    System.out.print("Select a data base: ");
                    String file = scanner1.nextLine();
                    fileDownload = new File(file);
                    break;
                case 3:
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Java\\GroupDB\\" + fileDownload))){
                        gp1 = (Group)ois.readObject();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    gp1.showStudents();
                    break;
                case 5:
                    return;
            }
        }while (a != 5);


    }
}