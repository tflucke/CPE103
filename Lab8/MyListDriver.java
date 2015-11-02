import java.util.Scanner;

public class MyListDriver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MyList intList = new MyList();
		
		System.out.println("Choose one of the following operations:");
        System.out.println("- add (enter the letter a)");
        System.out.println("- find (enter the letter f)");
        System.out.println("- print (enter the letter p)");
        System.out.println("- sum (enter the letter s)");
        System.out.println("- quit (enter the letter q)");
        
        String temp = scan.nextLine();
        
        while (temp.length() != 1) {
            System.out.println("Invalid choice");
            System.out.println("Do another operation? (refer to menu above)");
            temp = scan.nextLine();
        }
        
        char answer = temp.charAt(0);
        
        while (answer != 'q'){
            switch (answer){
                case 'a':
                    System.out.println("What int do you want to add?");
                    if(scan.hasNextInt()){
                        int item = scan.nextInt();
                        intList.add(item);
                        System.out.println(item+" added");
                    }
                    else System.out.println("Invalid value");
                    scan.nextLine();
                    break;
                case 'f':
                	System.out.println("What int do you want to search for?");
                    if(scan.hasNextInt()){
                        int item = scan.nextInt();
                        if (intList.find(item)) System.out.println(item+" found");
                        else System.out.println(item+" not found");
                    }
                    else System.out.println("Invalid value");
                    scan.nextLine();
                    break;
                    
                case 'p':
                    intList.print();
                    System.out.println();
                    break;
                    
                case 's':
                    System.out.println("Sum of all values is " + intList.sum());
                    break;
                    
                default:
                    System.out.println("Invalid case");
                    break;
            }
            
            System.out.println("Do another operation? (refer to menu above)");
            temp = scan.nextLine();
            
            while (temp.length() != 1) {
                System.out.println("Invalid choice");
                System.out.println("Do another operation? (refer to menu above)");
                temp = scan.nextLine();
            }
            
            answer = temp.charAt(0);
        }
        scan.close();
        System.out.println("quitting");
        System.out.println();
	}

}
