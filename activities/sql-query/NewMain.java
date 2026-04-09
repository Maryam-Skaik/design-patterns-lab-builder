// author Raghad Saqallah ID:220232444
public class NewMain {

    
    public static void main(String[] args) {
        

    
                 
        Query q =  new Query.builder("Employee")
                .setColumns("Name","Age")
                .setWhereCondition("Age>20")
                .setOrderBy("Age")
                .build();
        
        }
     
        
      
    
       
        
    }
    

