package model;

import java.util.Scanner; 

public class View {
    
    
    public View()
    {
        
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print("Quel est votre prenom ? : "+str);
        sc = new Scanner(System.in);
        str = sc.nextLine();
        System.out.print("Quel est votre nom ? : "+str);
    }


}