//Dorota Dyczek

import java.util.Scanner; 
class iterStack{            
   int size;                
   int[] array;             
   int top;
   iterStack(int iterSize){     
       size = iterSize;
       array = new int[size];
       top = 0;
   } 
   public void push(int index){     
        
        array[top] = index;
        top++;                      
       
   }
   public int pop(){
       if( top == 0){   
        return -1;
       }
       else{  
    
        return array[--top];
         
       }
   }
   public int top(){  
   
        if(top != 0){
            return array[top-1];
        }
        return -2;    
   }
   public void toPrint(int[] arr){     
        for(int i = 0;i < top ;i++){
            arr[array[i]] = 1;
        }
        
   }

}
class Source {
    public static Scanner sc = new Scanner(System.in); 
    static boolean printA = false;      

    public static void iter_pakuj(int[] arr, int sum, int[] indexArr){                           
        iterStack iterStack = new iterStack(arr.length);
        int curr_sum = 0;                 

        for(int i = 0;i<arr.length;i++){
          
            iterStack.push(i);          
            curr_sum += arr[i];

            if(curr_sum == sum){    
                iterStack.toPrint(indexArr);
                printA=true;
                return;
            }
            else if(i == arr.length - 1){      
                
                curr_sum -=  arr[i];
                iterStack.pop();        
                
                i = iterStack.top;
                if (iterStack.top == -1){    
                    return;                 
                }
                curr_sum -= arr[iterStack.top()];            
                i=iterStack.pop();
            
            }
            else if(curr_sum > sum){
                curr_sum -= arr[i];
                iterStack.pop();

            }
           
        
        }
    }
    public static void rec_pakuj(int[] arr, int sum, int curr_sum, int index,int[] indexArr){
        
        if(sum == curr_sum){       
            
            printA = true;      
            return;
        }
        else if(index == arr.length){   
            return;
        }
        else{
            indexArr[index] = 1;      
            curr_sum += arr[index];     
            
            if(curr_sum <= sum){       
                rec_pakuj(arr,sum,curr_sum,index+1,indexArr);
                
            }
            if(!printA){      
                curr_sum -= arr[index];
                indexArr[index] = 0;
                rec_pakuj(arr,sum,curr_sum,index+1,indexArr);
            }
            
        }
        
        return;
    }
    public static void main( String [] args ) {
        int z = sc.nextInt();
        for(int i = 0; i<z;i++){            
            printA = false;
            int sum = sc.nextInt();     
            int k = sc.nextInt();
            int[] array= new int[k];
            for(int j = 0; j < k; j++){
                array[j] = sc.nextInt();
            }
            int[] indexArr = new int[k];       

            rec_pakuj(array,sum,0,0,indexArr); 
            if(printA){
                System.out.print("REC: " + sum + " = ");
                for(int t = 0; t < array.length;t++){          
                    
                    if(indexArr[t] == 1){
                        System.out.print(array[t]+" ");
                    }
                    
                }
                System.out.println();
                printA = false;
                indexArr = new int[k];      

                iter_pakuj(array,sum,indexArr);

                System.out.print("ITER: " + sum + " = ");
                for(int t = 0; t < array.length;t++){
                    
                    if(indexArr[t] == 1){
                        System.out.print(array[t]+" ");
                    }
                    
                }
                System.out.println();
                
            }
            else{
                System.out.println("BRAK");
            }
            

        }        
    }
} 
