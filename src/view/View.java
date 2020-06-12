package model;

import java.util.Scanner; 

public class View {
    
    
    public View()
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print("Quel est votre prenom ? : "+str);

        System.out.print("Quel est votre nom ? : ");
    }


}