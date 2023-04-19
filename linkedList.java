//Dorota Dyczek


 java.util.Scanner;

public class Source {
    public static Scanner in = new Scanner(System.in);
    public static void InsertFirst(Train train, String w_name){
        if (train !=null){        
            Carriage carriage = new Carriage(w_name);
            carriage.next = train.first;
            carriage.prev = train.first.prev;       
            train.first.prev.next = carriage;
            train.first.prev = carriage;

            train.first = carriage;        
        }
    
    }

    public static void InsertLast(Train train, String w_name){      
        if (train !=null){
            Carriage carriage = new Carriage(w_name);   
            carriage.next = train.first;
            carriage.prev = train.first.prev;       
            train.first.prev.next = carriage;
            train.first.prev = carriage;
            
        }
    }
    public static void Display(Train train){
                                                
        Carriage carr = train.first;            
        boolean loop = true;        
        while(carr != null){
            if(loop==false && carr==train.first){
                break;
            }
            loop=false;
            if(carr.next.next == carr){
                Carriage temp = carr.next.next;
                carr.next.next = carr.next.prev;
                carr.next.prev = temp;
            
            }
            System.out.print(carr.name + " ");
            carr=carr.next;
        }
                
    }

    
    

    public static void main(String[] args){
        int z = in.nextInt();               
        for(int i = 0; i < z; i++){
            int n = in.nextInt();
            TrainList tList = new TrainList();     
            for(int j = 0; j<n; j++){
                String operationName = in.next();
                if(operationName.equals("New")){
                    String train_name = in.next();
                    String carriage_name = in.next();
                    
                    if(tList.exist(train_name)){        
                        System.out.println("Train " + train_name + " already exists");
                    }
                    else{
                        tList.newTrain(train_name,carriage_name);       
                    }
                }
                else if(operationName.equals("InsertFirst")){
                    String train_name = in.next();      
                    String carriage_name = in.next();
                    Train train = tList.findTrain(train_name); 
                    if(!tList.exist(train_name)){
                        System.out.println("Train " + train_name + " does not exist");  
                    }
                    else{
                        InsertFirst(train, carriage_name);      
                    }
                }
                else if(operationName.equals("InsertLast")){
                    String train_name = in.next();
                    String carriage_name = in.next();
                    Train train = tList.findTrain(train_name);      
                    if(!tList.exist(train_name)){                   
                        System.out.println("Train " + train_name + " does not exist");
                    }
                    else{
                        InsertLast(train, carriage_name);
                    }
                }
                else if(operationName.equals("Display")){
                    String train_name = in.next();
                    Train train = tList.findTrain(train_name);
                    if(!tList.exist(train_name)){                  
                        System.out.println("Train " + train_name + " does not exist");
                    }
                    else{
                        System.out.print(train_name + ": ");
                        Display(train);                         
                        System.out.println();
                    }
                }else if(operationName.equals("Trains")){
                    System.out.print("Trains: ");
                    if(tList.head == null){         
                        System.out.println();
                    }
                    else{
                        tList.trainDisplay();       
                        System.out.println();
                    }
                }
                else if(operationName.equals("Union")){
                    String train_one = in.next();
                    String train_two = in.next();
                    if(!tList.exist(train_one)){      
                        System.out.println("Train " + train_one + " does not exist");
                    }
                    else if(!tList.exist(train_two)){
                        System.out.println("Train " + train_two + " does not exist");
                    }
                    else{
                        Train train1 = tList.findTrain(train_one);      
                        Train train2 = tList.findTrain(train_two);      
                        tList.Union(train1, train2);
                    }
        
                }
                else if(operationName.equals("Reverse")){
                    String train_name = in.next();
                    if(!tList.exist(train_name)){       
                        System.out.println("Train " + train_name + " does not exist");
                    }
                    else{
                        Train train = tList.findTrain(train_name);  
                        tList.Reverse(train);      
                    }   
                }
                else if(operationName.equals("DelFirst")){
                    String train_one = in.next();
                    String train_two = in.next();
                    if(!tList.exist(train_one)){        
                        System.out.println("Train " + train_one + " does not exist");
                    }
                    else if(tList.exist(train_two)){        
                        System.out.println("Train " + train_two + " already exists");
                    }
                    else{
                        Train train1 = tList.findTrain(train_one);      
                        
                        tList.DelFirst(train1,train_two);

                    }
                }
                else if(operationName.equals("DelLast")){
                    String train_one = in.next();
                    String train_two = in.next();
                    if(!tList.exist(train_one)){
                        System.out.println("Train " + train_one + " does not exist");       
                    }
                    else if(tList.exist(train_two)){
                        System.out.println("Train " + train_two + " already exists");   
                    }
                    else{
                        Train train1 = tList.findTrain(train_one); 
                        
                        tList.DelLast(train1,train_two);

                    }
                }
            }
        }

    }
}

class Train{
    Train next;     
    Carriage first; 
    String name;    
    public Train(String t_name, String w_name){ 
        Carriage newCarriage = new Carriage(w_name);
        name = t_name;                                  
        newCarriage.prev = newCarriage;                 
        newCarriage.next = newCarriage;
        first = newCarriage;
        next = this;                                   
    }
}

class Carriage{
    Carriage prev;              
    Carriage next;              
    String name;               
    public Carriage(String w_name){
        name=w_name;            
    }   
}
 

class TrainList{
    public Train head = null;

    public void newTrain(String t_name, String w_name){ 
        if(head != null){                          
            Train train = new Train(t_name, w_name);
            train.next = head;
            head = train;                           
        }
        else{                                   
            Train train = new Train(t_name, w_name);
            train.next = null;
            head = train;                       
        }
    }
    public boolean exist(String t_name){       
        Train loop = head;  
        while(loop != null){
            if(loop.name.equals(t_name)){      
                return true;
            }
            loop = loop.next;
        }
        return false;
    }
   
    public Train findTrain(String t_name){     
        Train theTrain = head;
        while(theTrain != null){
            if(theTrain.name.equals(t_name)){       
                return theTrain;
            }
            theTrain = theTrain.next;      
        }
        return null;
    }
    public void trainDisplay(){    
        Train train = head;     
        while(train!=null){
            System.out.print(train.name+" ");
            train=train.next;       
        }
    }
    public void DelFirst(Train train1, String train2_name){
        Carriage temp = train1.first;       
        String name = temp.name;            
        int one = 0;
        
        if( train1.first.next == train1.first){     
           one = 1;
            train1.first.prev=null;
            train1.first.next=null;

            
        }
        else if(train1.first == train1.first.prev.next){
          
            train1.first.next.prev=train1.first.prev;       
            train1.first.prev.next = train1.first.next;
            train1.first = train1.first.next;

        }
        else {
        
            temp = temp.prev.next;
            train1.first.prev.prev = temp;      
            train1.first.prev.next = train1.first.next;
            train1.first = train1.first.prev;
            train1.first.next.prev=train1.first;
        }
        newTrain(train2_name, name);
      
        if(one==1){
            if(train1.name == head.name){    

                head = head.next;
            }
            else{                         
                Train first = head;
                while(head.next != train1){
                    head=head.next;
                }
                head.next=train1.next;  
                head = first;
            }
        }
    }
    public void DelLast(Train train1, String train2_name){  
        Carriage temp = train1.first;
        String name = temp.prev.name;
       
        int one = 0;
        if( train1.first == train1.first.prev){     
            one = 1;
            train1.first.prev=null;
            train1.first.next=null;

        
        }
        else if(train1.first.next.prev == train1.first){
            train1.first.prev = train1.first.prev.prev;
            train1.first.prev.next = train1.first;
        }
        else {
            temp = train1.first.next.next;
            train1.first.next.next.next = train1.first.next.next.prev;
            train1.first.next.next.prev = train1.first;

            train1.first.next = temp;
        }
        newTrain(train2_name, name);
         
        if(one==1){
            if(train1 == head){
                head = head.next;
            }
            else{
                Train first = head;
                while(head.next != train1){
                    head=head.next;
                }
                head.next=train1.next;  
                head = first;
        }
    }
    }
    public void Union(Train train1, Train train2){     
        Train first = head;
            Carriage tmp1 = train1.first.prev;
            Carriage tmp2 = train2.first.prev;
            train1.first.prev = tmp2;
            train2.first.prev = tmp1;
            tmp1.next = train2.first;
            tmp2.next = train1.first;


        if(first == train2){             

            head = train2.next;
        }
        else{
            Train temp = head;
            while(head.next != train2){
                head = head.next;
            }

            head.next = train2.next;
            head = temp;
            
        } 

    }
    public void Reverse(Train train){   
        if(train != null){
            Carriage temp = train.first.next;
            train.first.next = train.first.prev;        
            train.first.prev = temp;

            temp = train.first.next.next;
            train.first.next.next = train.first.next.prev;
            train.first.next.prev = temp;
            train.first = train.first.next;
        }
    }
}
