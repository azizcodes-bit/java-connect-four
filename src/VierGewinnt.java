import java.util.Scanner;
public class VierGewinnt {
 public static void main(String[] args){
  Spieler sp1=new Spieler("alex",1),sp2=new Spieler("mueller",2);
  Spielfeld fe=new Spielfeld();
  fe.initialisiereSpielfeld();fe.druckeSpielfeld();
  Scanner scanner=new Scanner(System.in);
  Spieler aktuellerSpieler=sp1;
  while(fe.getCount()<42){
   System.out.println(aktuellerSpieler.getName()+" wähle eine Spalte (1-7)");
   int spalte=liesZahl(scanner);
   if(!fe.setzeSpielstein(aktuellerSpieler,spalte))continue;
   fe.druckeSpielfeld();
   if(fe.testeSieg(aktuellerSpieler)){
    System.out.println(aktuellerSpieler.getName()+" hat gewonnen!");break;
   }
   aktuellerSpieler=aktuellerSpieler==sp1?sp2:sp1;
  }
  if(fe.getCount()==42&&!fe.testeSieg(aktuellerSpieler))System.out.println("Unentschieden!");
  scanner.close();
 }
 private static int liesZahl(Scanner scanner){
  while(true)try{return Integer.parseInt(scanner.nextLine().trim());}
  catch(NumberFormatException e){System.out.println("Bitte eine ganze Zahl eingeben.");}
 }
}