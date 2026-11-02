public class Spielfeld {
 private int[][] feld;
 public int count = 0;
 public Spielfeld(){this.feld=new int[6][7];}
 public void initialisiereSpielfeld(){
  count=0;
  for(int i=0;i<feld.length;i++) for(int j=0;j<feld[i].length;j++) feld[i][j]=0;
 }
 public void druckeSpielfeld(){
  for(int i=0;i<feld.length;i++){for(int j=0;j<feld[i].length;j++) System.out.print(feld[i][j]+" ");System.out.println();}
 }
 public boolean setzeSpielstein(Spieler spieler,int spalte){
  if(spalte<1||spalte>feld[0].length){System.out.println("ungültige spalte!");return false;}
  spalte--;
  for(int i=feld.length-1;i>=0;i--){
   if(feld[i][spalte]==0){feld[i][spalte]=spieler.getNummer();count++;return true;}
  }
  System.out.println("Diese Spalte ist voll!");
  return false;
 }
 public boolean testeSieg(Spieler spieler){
  return testHorizontal(spieler)||testVertikal(spieler)||testDiagonal(spieler);
 }
 public boolean testHorizontal(Spieler spieler){
  for(int i=0;i<feld.length;i++) for(int j=0;j<feld[i].length-3;j++)
   if(feld[i][j]==spieler.getNummer()&&feld[i][j]==feld[i][j+1]&&feld[i][j]==feld[i][j+2]&&feld[i][j]==feld[i][j+3]) return true;
  return false;
 }
 public boolean testVertikal(Spieler spieler){
  for(int i=0;i<feld.length-3;i++) for(int j=0;j<feld[i].length;j++)
   if(feld[i][j]==spieler.getNummer()&&feld[i][j]==feld[i+1][j]&&feld[i][j]==feld[i+2][j]&&feld[i][j]==feld[i+3][j]) return true;
  return false;
 }
 public boolean testDiagonal(Spieler spieler){
  for(int i=0;i<feld.length-3;i++) for(int j=0;j<feld[i].length-3;j++)
   if(feld[i][j]==spieler.getNummer()&&feld[i][j]==feld[i+1][j+1]&&feld[i][j]==feld[i+2][j+2]&&feld[i][j]==feld[i+3][j+3]) return true;
  for(int i=0;i<feld.length-3;i++) for(int j=3;j<feld[i].length;j++)
   if(feld[i][j]==spieler.getNummer()&&feld[i][j]==feld[i+1][j-1]&&feld[i][j]==feld[i+2][j-2]&&feld[i][j]==feld[i+3][j-3]) return true;
  return false;
 }
 public int getCount(){return count;}
}