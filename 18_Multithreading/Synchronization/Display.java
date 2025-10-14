public class Display{
    public synchronized void printCapitals(){
        for(int i = 65; i <= 90; i++){
            System.out.print((char)i + " ");
            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void printSmaller(){
        for(int i = 97; i <= 122; i++){
            System.out.print((char)i + " ");
            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}